package com.google.android.exoplayer2.source.hls.playlist;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Base64;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.C0643C;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.extractor.mp4.PsshAtomUtil;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.icy.IcyHeaders;
import com.google.android.exoplayer2.source.hls.HlsTrackMetadataEntry;
import com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist;
import com.google.android.exoplayer2.source.hls.playlist.HlsMultivariantPlaylist;
import com.google.android.exoplayer2.upstream.ParsingLoadable;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.UriUtil;
import com.google.android.exoplayer2.util.Util;
import com.google.common.collect.Iterables;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import p000.jz2;

/* loaded from: classes.dex */
public final class HlsPlaylistParser implements ParsingLoadable.Parser<HlsPlaylist> {

    /* renamed from: a */
    public final HlsMultivariantPlaylist f11518a;

    /* renamed from: b */
    public final HlsMediaPlaylist f11519b;

    /* renamed from: c */
    public static final Pattern f11494c = Pattern.compile("AVERAGE-BANDWIDTH=(\\d+)\\b");

    /* renamed from: d */
    public static final Pattern f11495d = Pattern.compile("VIDEO=\"(.+?)\"");

    /* renamed from: e */
    public static final Pattern f11496e = Pattern.compile("AUDIO=\"(.+?)\"");

    /* renamed from: f */
    public static final Pattern f11497f = Pattern.compile("SUBTITLES=\"(.+?)\"");

    /* renamed from: g */
    public static final Pattern f11498g = Pattern.compile("CLOSED-CAPTIONS=\"(.+?)\"");

    /* renamed from: h */
    public static final Pattern f11499h = Pattern.compile("[^-]BANDWIDTH=(\\d+)\\b");

    /* renamed from: i */
    public static final Pattern f11500i = Pattern.compile("CHANNELS=\"(.+?)\"");

    /* renamed from: j */
    public static final Pattern f11501j = Pattern.compile("CODECS=\"(.+?)\"");

    /* renamed from: k */
    public static final Pattern f11502k = Pattern.compile("RESOLUTION=(\\d+x\\d+)");

    /* renamed from: l */
    public static final Pattern f11503l = Pattern.compile("FRAME-RATE=([\\d\\.]+)\\b");

    /* renamed from: m */
    public static final Pattern f11504m = Pattern.compile("#EXT-X-TARGETDURATION:(\\d+)\\b");

    /* renamed from: n */
    public static final Pattern f11505n = Pattern.compile("DURATION=([\\d\\.]+)\\b");

    /* renamed from: o */
    public static final Pattern f11506o = Pattern.compile("PART-TARGET=([\\d\\.]+)\\b");

    /* renamed from: p */
    public static final Pattern f11507p = Pattern.compile("#EXT-X-VERSION:(\\d+)\\b");

    /* renamed from: q */
    public static final Pattern f11508q = Pattern.compile("#EXT-X-PLAYLIST-TYPE:(.+)\\b");

    /* renamed from: r */
    public static final Pattern f11509r = Pattern.compile("CAN-SKIP-UNTIL=([\\d\\.]+)\\b");

    /* renamed from: s */
    public static final Pattern f11510s = m2800a("CAN-SKIP-DATERANGES");

    /* renamed from: t */
    public static final Pattern f11511t = Pattern.compile("SKIPPED-SEGMENTS=(\\d+)\\b");

    /* renamed from: u */
    public static final Pattern f11512u = Pattern.compile("[:|,]HOLD-BACK=([\\d\\.]+)\\b");

    /* renamed from: v */
    public static final Pattern f11513v = Pattern.compile("PART-HOLD-BACK=([\\d\\.]+)\\b");

    /* renamed from: w */
    public static final Pattern f11514w = m2800a("CAN-BLOCK-RELOAD");

    /* renamed from: x */
    public static final Pattern f11515x = Pattern.compile("#EXT-X-MEDIA-SEQUENCE:(\\d+)\\b");

    /* renamed from: y */
    public static final Pattern f11516y = Pattern.compile("#EXTINF:([\\d\\.]+)\\b");

    /* renamed from: z */
    public static final Pattern f11517z = Pattern.compile("#EXTINF:[\\d\\.]+\\b,(.+)");

    /* renamed from: A */
    public static final Pattern f11466A = Pattern.compile("LAST-MSN=(\\d+)\\b");

    /* renamed from: B */
    public static final Pattern f11467B = Pattern.compile("LAST-PART=(\\d+)\\b");

    /* renamed from: C */
    public static final Pattern f11468C = Pattern.compile("TIME-OFFSET=(-?[\\d\\.]+)\\b");

    /* renamed from: D */
    public static final Pattern f11469D = Pattern.compile("#EXT-X-BYTERANGE:(\\d+(?:@\\d+)?)\\b");

    /* renamed from: E */
    public static final Pattern f11470E = Pattern.compile("BYTERANGE=\"(\\d+(?:@\\d+)?)\\b\"");

    /* renamed from: F */
    public static final Pattern f11471F = Pattern.compile("BYTERANGE-START=(\\d+)\\b");

    /* renamed from: G */
    public static final Pattern f11472G = Pattern.compile("BYTERANGE-LENGTH=(\\d+)\\b");

    /* renamed from: H */
    public static final Pattern f11473H = Pattern.compile("METHOD=(NONE|AES-128|SAMPLE-AES|SAMPLE-AES-CENC|SAMPLE-AES-CTR)\\s*(?:,|$)");

    /* renamed from: I */
    public static final Pattern f11474I = Pattern.compile("KEYFORMAT=\"(.+?)\"");

    /* renamed from: J */
    public static final Pattern f11475J = Pattern.compile("KEYFORMATVERSIONS=\"(.+?)\"");

    /* renamed from: K */
    public static final Pattern f11476K = Pattern.compile("URI=\"(.+?)\"");

    /* renamed from: L */
    public static final Pattern f11477L = Pattern.compile("IV=([^,.*]+)");

    /* renamed from: M */
    public static final Pattern f11478M = Pattern.compile("TYPE=(AUDIO|VIDEO|SUBTITLES|CLOSED-CAPTIONS)");

    /* renamed from: N */
    public static final Pattern f11479N = Pattern.compile("TYPE=(PART|MAP)");

    /* renamed from: O */
    public static final Pattern f11480O = Pattern.compile("LANGUAGE=\"(.+?)\"");

    /* renamed from: P */
    public static final Pattern f11481P = Pattern.compile("NAME=\"(.+?)\"");

    /* renamed from: Q */
    public static final Pattern f11482Q = Pattern.compile("GROUP-ID=\"(.+?)\"");

    /* renamed from: R */
    public static final Pattern f11483R = Pattern.compile("CHARACTERISTICS=\"(.+?)\"");

    /* renamed from: S */
    public static final Pattern f11484S = Pattern.compile("INSTREAM-ID=\"((?:CC|SERVICE)\\d+)\"");

    /* renamed from: T */
    public static final Pattern f11485T = m2800a("AUTOSELECT");

    /* renamed from: U */
    public static final Pattern f11486U = m2800a("DEFAULT");

    /* renamed from: V */
    public static final Pattern f11487V = m2800a("FORCED");

    /* renamed from: W */
    public static final Pattern f11488W = m2800a("INDEPENDENT");

    /* renamed from: X */
    public static final Pattern f11489X = m2800a("GAP");

    /* renamed from: Y */
    public static final Pattern f11490Y = m2800a("PRECISE");

    /* renamed from: Z */
    public static final Pattern f11491Z = Pattern.compile("VALUE=\"(.+?)\"");

    /* renamed from: a0 */
    public static final Pattern f11492a0 = Pattern.compile("IMPORT=\"(.+?)\"");

    /* renamed from: b0 */
    public static final Pattern f11493b0 = Pattern.compile("\\{\\$([a-zA-Z0-9\\-_]+)\\}");

    /* loaded from: classes.dex */
    public static final class DeltaUpdateException extends IOException {
    }

    public HlsPlaylistParser() {
        this(HlsMultivariantPlaylist.EMPTY, null);
    }

    /* renamed from: a */
    public static Pattern m2800a(String str) {
        return Pattern.compile(str.concat("=(NO|YES)"));
    }

    /* renamed from: b */
    public static DrmInitData m2801b(String str, DrmInitData.SchemeData[] schemeDataArr) {
        DrmInitData.SchemeData[] schemeDataArr2 = new DrmInitData.SchemeData[schemeDataArr.length];
        for (int i = 0; i < schemeDataArr.length; i++) {
            schemeDataArr2[i] = schemeDataArr[i].copyWithData(null);
        }
        return new DrmInitData(str, schemeDataArr2);
    }

    /* renamed from: c */
    public static DrmInitData.SchemeData m2802c(String str, String str2, HashMap hashMap) {
        String m2808i = m2808i(str, f11475J, IcyHeaders.REQUEST_HEADER_ENABLE_METADATA_VALUE, hashMap);
        boolean equals = "urn:uuid:edef8ba9-79d6-4ace-a3c8-27dcd51d21ed".equals(str2);
        Pattern pattern = f11476K;
        if (equals) {
            String m2809j = m2809j(str, pattern, hashMap);
            return new DrmInitData.SchemeData(C0643C.WIDEVINE_UUID, MimeTypes.VIDEO_MP4, Base64.decode(m2809j.substring(m2809j.indexOf(44)), 0));
        }
        if ("com.widevine".equals(str2)) {
            return new DrmInitData.SchemeData(C0643C.WIDEVINE_UUID, "hls", Util.getUtf8Bytes(str));
        }
        if ("com.microsoft.playready".equals(str2) && IcyHeaders.REQUEST_HEADER_ENABLE_METADATA_VALUE.equals(m2808i)) {
            String m2809j2 = m2809j(str, pattern, hashMap);
            byte[] decode = Base64.decode(m2809j2.substring(m2809j2.indexOf(44)), 0);
            UUID uuid = C0643C.PLAYREADY_UUID;
            return new DrmInitData.SchemeData(uuid, MimeTypes.VIDEO_MP4, PsshAtomUtil.buildPsshAtom(uuid, decode));
        }
        return null;
    }

    /* renamed from: d */
    public static HlsMediaPlaylist m2803d(HlsMultivariantPlaylist hlsMultivariantPlaylist, HlsMediaPlaylist hlsMediaPlaylist, jz2 jz2Var, String str) {
        List<HlsMediaPlaylist.Part> list;
        String str2;
        long j;
        long j2;
        long j3;
        HashMap hashMap;
        HashMap hashMap2;
        ArrayList arrayList;
        String str3;
        boolean z;
        String str4;
        int i;
        String hexString;
        long j4;
        String hexString2;
        boolean z2;
        long j5;
        String hexString3;
        long j6;
        HashMap hashMap3;
        HashMap hashMap4;
        boolean z3;
        DrmInitData drmInitData;
        HlsMediaPlaylist.Segment segment;
        HlsMultivariantPlaylist hlsMultivariantPlaylist2 = hlsMultivariantPlaylist;
        HlsMediaPlaylist hlsMediaPlaylist2 = hlsMediaPlaylist;
        boolean z4 = hlsMultivariantPlaylist2.hasIndependentSegments;
        HashMap hashMap5 = new HashMap();
        HashMap hashMap6 = new HashMap();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        ArrayList arrayList5 = new ArrayList();
        HlsMediaPlaylist.ServerControl serverControl = new HlsMediaPlaylist.ServerControl(C0643C.TIME_UNSET, false, C0643C.TIME_UNSET, C0643C.TIME_UNSET, false);
        TreeMap treeMap = new TreeMap();
        String str5 = "";
        boolean z5 = z4;
        HlsMediaPlaylist.ServerControl serverControl2 = serverControl;
        String str6 = "";
        long j7 = -1;
        int i2 = 0;
        boolean z6 = false;
        long j8 = C0643C.TIME_UNSET;
        long j9 = 0;
        boolean z7 = false;
        int i3 = 0;
        long j10 = 0;
        int i4 = 1;
        long j11 = C0643C.TIME_UNSET;
        long j12 = C0643C.TIME_UNSET;
        boolean z8 = false;
        DrmInitData drmInitData2 = null;
        long j13 = 0;
        DrmInitData drmInitData3 = null;
        long j14 = 0;
        long j15 = 0;
        boolean z9 = false;
        String str7 = null;
        String str8 = null;
        String str9 = null;
        int i5 = 0;
        long j16 = 0;
        boolean z10 = false;
        HlsMediaPlaylist.Segment segment2 = null;
        long j17 = 0;
        long j18 = 0;
        ArrayList arrayList6 = arrayList3;
        HlsMediaPlaylist.Part part = null;
        while (jz2Var.m5472k()) {
            String m5473l = jz2Var.m5473l();
            if (m5473l.startsWith("#EXT")) {
                arrayList5.add(m5473l);
            }
            if (m5473l.startsWith("#EXT-X-PLAYLIST-TYPE")) {
                String m2809j = m2809j(m5473l, f11508q, hashMap5);
                if ("VOD".equals(m2809j)) {
                    i2 = 1;
                } else if ("EVENT".equals(m2809j)) {
                    i2 = 2;
                }
            } else if (m5473l.equals("#EXT-X-I-FRAMES-ONLY")) {
                z10 = true;
            } else {
                if (m5473l.startsWith("#EXT-X-START")) {
                    str2 = str5;
                    long parseDouble = (long) (Double.parseDouble(m2809j(m5473l, f11468C, Collections.emptyMap())) * 1000000.0d);
                    z6 = m2805f(m5473l, f11490Y);
                    j8 = parseDouble;
                } else {
                    str2 = str5;
                    if (m5473l.startsWith("#EXT-X-SERVER-CONTROL")) {
                        double m2806g = m2806g(m5473l, f11509r);
                        if (m2806g == -9.223372036854776E18d) {
                            j = C0643C.TIME_UNSET;
                        } else {
                            j = (long) (m2806g * 1000000.0d);
                        }
                        boolean m2805f = m2805f(m5473l, f11510s);
                        double m2806g2 = m2806g(m5473l, f11512u);
                        if (m2806g2 == -9.223372036854776E18d) {
                            j2 = C0643C.TIME_UNSET;
                        } else {
                            j2 = (long) (m2806g2 * 1000000.0d);
                        }
                        double m2806g3 = m2806g(m5473l, f11513v);
                        if (m2806g3 == -9.223372036854776E18d) {
                            j3 = C0643C.TIME_UNSET;
                        } else {
                            j3 = (long) (m2806g3 * 1000000.0d);
                        }
                        serverControl2 = new HlsMediaPlaylist.ServerControl(j, m2805f, j2, j3, m2805f(m5473l, f11514w));
                    } else if (m5473l.startsWith("#EXT-X-PART-INF")) {
                        j12 = (long) (Double.parseDouble(m2809j(m5473l, f11506o, Collections.emptyMap())) * 1000000.0d);
                    } else {
                        boolean startsWith = m5473l.startsWith("#EXT-X-MAP");
                        Pattern pattern = f11470E;
                        boolean z11 = z6;
                        Pattern pattern2 = f11476K;
                        if (startsWith) {
                            String m2809j2 = m2809j(m5473l, pattern2, hashMap5);
                            String m2808i = m2808i(m5473l, pattern, null, hashMap5);
                            if (m2808i != null) {
                                String[] split = Util.split(m2808i, "@");
                                j7 = Long.parseLong(split[0]);
                                if (split.length > 1) {
                                    j13 = Long.parseLong(split[1]);
                                }
                            }
                            if (j7 == -1) {
                                j13 = 0;
                            }
                            if (str7 != null && str8 == null) {
                                throw ParserException.createForMalformedManifest("The encryption IV attribute must be present when an initialization segment is encrypted with METHOD=AES-128.", null);
                            }
                            segment2 = new HlsMediaPlaylist.Segment(m2809j2, j13, j7, str7, str8);
                            if (j7 != -1) {
                                j13 += j7;
                            }
                            j7 = -1;
                            str5 = str2;
                            z6 = z11;
                        } else {
                            ArrayList arrayList7 = arrayList6;
                            ArrayList arrayList8 = arrayList5;
                            if (m5473l.startsWith("#EXT-X-TARGETDURATION")) {
                                j11 = Integer.parseInt(m2809j(m5473l, f11504m, Collections.emptyMap())) * 1000000;
                            } else if (m5473l.startsWith("#EXT-X-MEDIA-SEQUENCE")) {
                                j14 = Long.parseLong(m2809j(m5473l, f11515x, Collections.emptyMap()));
                                j10 = j14;
                            } else if (m5473l.startsWith("#EXT-X-VERSION")) {
                                i4 = Integer.parseInt(m2809j(m5473l, f11507p, Collections.emptyMap()));
                            } else {
                                if (m5473l.startsWith("#EXT-X-DEFINE")) {
                                    String m2808i2 = m2808i(m5473l, f11492a0, null, hashMap5);
                                    if (m2808i2 != null) {
                                        String str10 = hlsMultivariantPlaylist2.variableDefinitions.get(m2808i2);
                                        if (str10 != null) {
                                            hashMap5.put(m2808i2, str10);
                                        }
                                    } else {
                                        hashMap5.put(m2809j(m5473l, f11481P, hashMap5), m2809j(m5473l, f11491Z, hashMap5));
                                    }
                                    hashMap = hashMap5;
                                    hashMap2 = hashMap6;
                                    arrayList = arrayList7;
                                    str3 = str9;
                                } else {
                                    if (m5473l.startsWith("#EXTINF")) {
                                        j17 = new BigDecimal(m2809j(m5473l, f11516y, Collections.emptyMap())).multiply(new BigDecimal(1000000L)).longValue();
                                        str6 = m2808i(m5473l, f11517z, str2, hashMap5);
                                        str5 = str2;
                                    } else {
                                        String str11 = str2;
                                        if (m5473l.startsWith("#EXT-X-SKIP")) {
                                            int parseInt = Integer.parseInt(m2809j(m5473l, f11511t, Collections.emptyMap()));
                                            if (hlsMediaPlaylist2 != null && arrayList2.isEmpty()) {
                                                z = true;
                                            } else {
                                                z = false;
                                            }
                                            Assertions.checkState(z);
                                            int i6 = (int) (j10 - ((HlsMediaPlaylist) Util.castNonNull(hlsMediaPlaylist)).mediaSequence);
                                            int i7 = parseInt + i6;
                                            if (i6 >= 0 && i7 <= hlsMediaPlaylist2.segments.size()) {
                                                long j19 = j16;
                                                while (i6 < i7) {
                                                    HlsMediaPlaylist.Segment segment3 = hlsMediaPlaylist2.segments.get(i6);
                                                    int i8 = i7;
                                                    String str12 = str11;
                                                    if (j10 != hlsMediaPlaylist2.mediaSequence) {
                                                        segment3 = segment3.copyWith(j19, (hlsMediaPlaylist2.discontinuitySequence - i3) + segment3.relativeDiscontinuitySequence);
                                                    }
                                                    arrayList2.add(segment3);
                                                    j19 += segment3.durationUs;
                                                    long j20 = segment3.byteRangeLength;
                                                    if (j20 != -1) {
                                                        j13 = segment3.byteRangeOffset + j20;
                                                    }
                                                    int i9 = segment3.relativeDiscontinuitySequence;
                                                    HlsMediaPlaylist.Segment segment4 = segment3.initializationSegment;
                                                    DrmInitData drmInitData4 = segment3.drmInitData;
                                                    String str13 = segment3.fullSegmentEncryptionKeyUri;
                                                    String str14 = segment3.encryptionIV;
                                                    if (str14 == null || !str14.equals(Long.toHexString(j14))) {
                                                        str8 = segment3.encryptionIV;
                                                    }
                                                    j14++;
                                                    i6++;
                                                    hlsMediaPlaylist2 = hlsMediaPlaylist;
                                                    str7 = str13;
                                                    j15 = j19;
                                                    i5 = i9;
                                                    segment2 = segment4;
                                                    str11 = str12;
                                                    drmInitData3 = drmInitData4;
                                                    i7 = i8;
                                                }
                                                hlsMultivariantPlaylist2 = hlsMultivariantPlaylist;
                                                hlsMediaPlaylist2 = hlsMediaPlaylist;
                                                str5 = str11;
                                                j16 = j19;
                                            } else {
                                                throw new DeltaUpdateException();
                                            }
                                        } else {
                                            str2 = str11;
                                            if (m5473l.startsWith("#EXT-X-KEY")) {
                                                String m2809j3 = m2809j(m5473l, f11473H, hashMap5);
                                                String m2808i3 = m2808i(m5473l, f11474I, "identity", hashMap5);
                                                if ("NONE".equals(m2809j3)) {
                                                    treeMap.clear();
                                                    drmInitData3 = null;
                                                    str7 = null;
                                                    str8 = null;
                                                } else {
                                                    String m2808i4 = m2808i(m5473l, f11477L, null, hashMap5);
                                                    if ("identity".equals(m2808i3)) {
                                                        if ("AES-128".equals(m2809j3)) {
                                                            str7 = m2809j(m5473l, pattern2, hashMap5);
                                                            str8 = m2808i4;
                                                        }
                                                    } else {
                                                        String str15 = str9;
                                                        if (str15 == null) {
                                                            if (!"SAMPLE-AES-CENC".equals(m2809j3) && !"SAMPLE-AES-CTR".equals(m2809j3)) {
                                                                str4 = C0643C.CENC_TYPE_cbcs;
                                                            } else {
                                                                str4 = C0643C.CENC_TYPE_cenc;
                                                            }
                                                            str9 = str4;
                                                        } else {
                                                            str9 = str15;
                                                        }
                                                        DrmInitData.SchemeData m2802c = m2802c(m5473l, m2808i3, hashMap5);
                                                        if (m2802c != null) {
                                                            treeMap.put(m2808i3, m2802c);
                                                            str8 = m2808i4;
                                                            drmInitData3 = null;
                                                            str7 = null;
                                                        }
                                                    }
                                                    str8 = m2808i4;
                                                    str7 = null;
                                                }
                                                hlsMultivariantPlaylist2 = hlsMultivariantPlaylist;
                                                hlsMediaPlaylist2 = hlsMediaPlaylist;
                                            } else {
                                                str3 = str9;
                                                if (m5473l.startsWith("#EXT-X-BYTERANGE")) {
                                                    String[] split2 = Util.split(m2809j(m5473l, f11469D, hashMap5), "@");
                                                    j7 = Long.parseLong(split2[0]);
                                                    if (split2.length > 1) {
                                                        j13 = Long.parseLong(split2[1]);
                                                    }
                                                } else if (m5473l.startsWith("#EXT-X-DISCONTINUITY-SEQUENCE")) {
                                                    i3 = Integer.parseInt(m5473l.substring(m5473l.indexOf(58) + 1));
                                                    hlsMultivariantPlaylist2 = hlsMultivariantPlaylist;
                                                    hlsMediaPlaylist2 = hlsMediaPlaylist;
                                                    str9 = str3;
                                                    arrayList6 = arrayList7;
                                                    str5 = str2;
                                                    z6 = z11;
                                                    arrayList5 = arrayList8;
                                                    z7 = true;
                                                } else if (m5473l.equals("#EXT-X-DISCONTINUITY")) {
                                                    i5++;
                                                } else {
                                                    if (m5473l.startsWith("#EXT-X-PROGRAM-DATE-TIME")) {
                                                        if (j9 == 0) {
                                                            j9 = Util.msToUs(Util.parseXsDateTime(m5473l.substring(m5473l.indexOf(58) + 1))) - j16;
                                                        }
                                                        hashMap = hashMap5;
                                                        hashMap2 = hashMap6;
                                                        arrayList = arrayList7;
                                                    } else if (m5473l.equals("#EXT-X-GAP")) {
                                                        hlsMultivariantPlaylist2 = hlsMultivariantPlaylist;
                                                        hlsMediaPlaylist2 = hlsMediaPlaylist;
                                                        str9 = str3;
                                                        arrayList6 = arrayList7;
                                                        str5 = str2;
                                                        z6 = z11;
                                                        arrayList5 = arrayList8;
                                                        z9 = true;
                                                    } else if (m5473l.equals("#EXT-X-INDEPENDENT-SEGMENTS")) {
                                                        hlsMultivariantPlaylist2 = hlsMultivariantPlaylist;
                                                        hlsMediaPlaylist2 = hlsMediaPlaylist;
                                                        str9 = str3;
                                                        arrayList6 = arrayList7;
                                                        str5 = str2;
                                                        z6 = z11;
                                                        arrayList5 = arrayList8;
                                                        z5 = true;
                                                    } else if (m5473l.equals("#EXT-X-ENDLIST")) {
                                                        hlsMultivariantPlaylist2 = hlsMultivariantPlaylist;
                                                        hlsMediaPlaylist2 = hlsMediaPlaylist;
                                                        str9 = str3;
                                                        arrayList6 = arrayList7;
                                                        str5 = str2;
                                                        z6 = z11;
                                                        arrayList5 = arrayList8;
                                                        z8 = true;
                                                    } else {
                                                        if (m5473l.startsWith("#EXT-X-RENDITION-REPORT")) {
                                                            long m2807h = m2807h(m5473l, f11466A);
                                                            Matcher matcher = f11467B.matcher(m5473l);
                                                            if (matcher.find()) {
                                                                i = Integer.parseInt((String) Assertions.checkNotNull(matcher.group(1)));
                                                            } else {
                                                                i = -1;
                                                            }
                                                            arrayList4.add(new HlsMediaPlaylist.RenditionReport(Uri.parse(UriUtil.resolve(str, m2809j(m5473l, pattern2, hashMap5))), m2807h, i));
                                                        } else if (m5473l.startsWith("#EXT-X-PRELOAD-HINT")) {
                                                            if (part == null && "PART".equals(m2809j(m5473l, f11479N, hashMap5))) {
                                                                String m2809j4 = m2809j(m5473l, pattern2, hashMap5);
                                                                long m2807h2 = m2807h(m5473l, f11471F);
                                                                long m2807h3 = m2807h(m5473l, f11472G);
                                                                if (str7 == null) {
                                                                    hexString = null;
                                                                } else if (str8 != null) {
                                                                    hexString = str8;
                                                                } else {
                                                                    hexString = Long.toHexString(j14);
                                                                }
                                                                if (drmInitData3 == null && !treeMap.isEmpty()) {
                                                                    DrmInitData.SchemeData[] schemeDataArr = (DrmInitData.SchemeData[]) treeMap.values().toArray(new DrmInitData.SchemeData[0]);
                                                                    DrmInitData drmInitData5 = new DrmInitData(str3, schemeDataArr);
                                                                    if (drmInitData2 == null) {
                                                                        drmInitData2 = m2801b(str3, schemeDataArr);
                                                                    }
                                                                    drmInitData3 = drmInitData5;
                                                                }
                                                                if (m2807h2 == -1 || m2807h3 != -1) {
                                                                    if (m2807h2 != -1) {
                                                                        j4 = m2807h2;
                                                                    } else {
                                                                        j4 = 0;
                                                                    }
                                                                    part = new HlsMediaPlaylist.Part(m2809j4, segment2, 0L, i5, j15, drmInitData3, str7, hexString, j4, m2807h3, false, false, true);
                                                                }
                                                            }
                                                        } else if (m5473l.startsWith("#EXT-X-PART")) {
                                                            if (str7 == null) {
                                                                hexString2 = null;
                                                            } else if (str8 != null) {
                                                                hexString2 = str8;
                                                            } else {
                                                                hexString2 = Long.toHexString(j14);
                                                            }
                                                            String m2809j5 = m2809j(m5473l, pattern2, hashMap5);
                                                            long parseDouble2 = (long) (Double.parseDouble(m2809j(m5473l, f11505n, Collections.emptyMap())) * 1000000.0d);
                                                            boolean m2805f2 = m2805f(m5473l, f11488W);
                                                            if (z5 && arrayList7.isEmpty()) {
                                                                z2 = true;
                                                            } else {
                                                                z2 = false;
                                                            }
                                                            boolean z12 = m2805f2 | z2;
                                                            boolean m2805f3 = m2805f(m5473l, f11489X);
                                                            String m2808i5 = m2808i(m5473l, pattern, null, hashMap5);
                                                            if (m2808i5 != null) {
                                                                String[] split3 = Util.split(m2808i5, "@");
                                                                j5 = Long.parseLong(split3[0]);
                                                                if (split3.length > 1) {
                                                                    j18 = Long.parseLong(split3[1]);
                                                                }
                                                            } else {
                                                                j5 = -1;
                                                            }
                                                            if (j5 == -1) {
                                                                j18 = 0;
                                                            }
                                                            if (drmInitData3 == null && !treeMap.isEmpty()) {
                                                                DrmInitData.SchemeData[] schemeDataArr2 = (DrmInitData.SchemeData[]) treeMap.values().toArray(new DrmInitData.SchemeData[0]);
                                                                DrmInitData drmInitData6 = new DrmInitData(str3, schemeDataArr2);
                                                                if (drmInitData2 == null) {
                                                                    drmInitData2 = m2801b(str3, schemeDataArr2);
                                                                }
                                                                drmInitData3 = drmInitData6;
                                                            }
                                                            arrayList7.add(new HlsMediaPlaylist.Part(m2809j5, segment2, parseDouble2, i5, j15, drmInitData3, str7, hexString2, j18, j5, m2805f3, z12, false));
                                                            j15 += parseDouble2;
                                                            if (j5 != -1) {
                                                                j18 += j5;
                                                            }
                                                            hlsMultivariantPlaylist2 = hlsMultivariantPlaylist;
                                                            hlsMediaPlaylist2 = hlsMediaPlaylist;
                                                            str9 = str3;
                                                            arrayList6 = arrayList7;
                                                        } else {
                                                            arrayList = arrayList7;
                                                            if (!m5473l.startsWith("#")) {
                                                                if (str7 == null) {
                                                                    hexString3 = null;
                                                                } else if (str8 != null) {
                                                                    hexString3 = str8;
                                                                } else {
                                                                    hexString3 = Long.toHexString(j14);
                                                                }
                                                                long j21 = j14 + 1;
                                                                String m2810k = m2810k(m5473l, hashMap5);
                                                                HlsMediaPlaylist.Segment segment5 = (HlsMediaPlaylist.Segment) hashMap6.get(m2810k);
                                                                if (j7 == -1) {
                                                                    j6 = 0;
                                                                } else {
                                                                    if (z10 && segment2 == null && segment5 == null) {
                                                                        segment5 = new HlsMediaPlaylist.Segment(m2810k, 0L, j13, null, null);
                                                                        hashMap6.put(m2810k, segment5);
                                                                    }
                                                                    j6 = j13;
                                                                }
                                                                if (drmInitData3 == null && !treeMap.isEmpty()) {
                                                                    hashMap3 = hashMap5;
                                                                    hashMap4 = hashMap6;
                                                                    z3 = false;
                                                                    DrmInitData.SchemeData[] schemeDataArr3 = (DrmInitData.SchemeData[]) treeMap.values().toArray(new DrmInitData.SchemeData[0]);
                                                                    drmInitData = new DrmInitData(str3, schemeDataArr3);
                                                                    if (drmInitData2 == null) {
                                                                        drmInitData2 = m2801b(str3, schemeDataArr3);
                                                                    }
                                                                } else {
                                                                    hashMap3 = hashMap5;
                                                                    hashMap4 = hashMap6;
                                                                    z3 = false;
                                                                    drmInitData = drmInitData3;
                                                                }
                                                                if (segment2 != null) {
                                                                    segment = segment2;
                                                                } else {
                                                                    segment = segment5;
                                                                }
                                                                arrayList2.add(new HlsMediaPlaylist.Segment(m2810k, segment, str6, j17, i5, j16, drmInitData, str7, hexString3, j6, j7, z9, arrayList));
                                                                j15 = j16 + j17;
                                                                ArrayList arrayList9 = new ArrayList();
                                                                if (j7 != -1) {
                                                                    j6 += j7;
                                                                }
                                                                j13 = j6;
                                                                hlsMediaPlaylist2 = hlsMediaPlaylist;
                                                                z9 = z3;
                                                                str9 = str3;
                                                                drmInitData3 = drmInitData;
                                                                j7 = -1;
                                                                j16 = j15;
                                                                j14 = j21;
                                                                hashMap5 = hashMap3;
                                                                hashMap6 = hashMap4;
                                                                str5 = str2;
                                                                str6 = str5;
                                                                z6 = z11;
                                                                arrayList5 = arrayList8;
                                                                j17 = 0;
                                                                arrayList6 = arrayList9;
                                                                hlsMultivariantPlaylist2 = hlsMultivariantPlaylist;
                                                            } else {
                                                                hashMap = hashMap5;
                                                                hashMap2 = hashMap6;
                                                            }
                                                        }
                                                        hashMap = hashMap5;
                                                        hashMap2 = hashMap6;
                                                        arrayList = arrayList7;
                                                    }
                                                    str5 = str2;
                                                    z6 = z11;
                                                    arrayList5 = arrayList8;
                                                }
                                                hlsMultivariantPlaylist2 = hlsMultivariantPlaylist;
                                                hlsMediaPlaylist2 = hlsMediaPlaylist;
                                                str9 = str3;
                                            }
                                        }
                                    }
                                    arrayList6 = arrayList7;
                                    z6 = z11;
                                    arrayList5 = arrayList8;
                                }
                                hlsMultivariantPlaylist2 = hlsMultivariantPlaylist;
                                hlsMediaPlaylist2 = hlsMediaPlaylist;
                                str9 = str3;
                                arrayList6 = arrayList;
                                hashMap5 = hashMap;
                                hashMap6 = hashMap2;
                                str5 = str2;
                                z6 = z11;
                                arrayList5 = arrayList8;
                            }
                            arrayList6 = arrayList7;
                            str5 = str2;
                            z6 = z11;
                            arrayList5 = arrayList8;
                        }
                    }
                }
                str5 = str2;
            }
        }
        ArrayList arrayList10 = arrayList6;
        ArrayList arrayList11 = arrayList5;
        boolean z13 = z6;
        boolean z14 = false;
        HashMap hashMap7 = new HashMap();
        for (int i10 = 0; i10 < arrayList4.size(); i10++) {
            HlsMediaPlaylist.RenditionReport renditionReport = (HlsMediaPlaylist.RenditionReport) arrayList4.get(i10);
            long j22 = renditionReport.lastMediaSequence;
            if (j22 == -1) {
                j22 = (j10 + arrayList2.size()) - (arrayList10.isEmpty() ? 1L : 0L);
            }
            int i11 = renditionReport.lastPartIndex;
            if (i11 == -1 && j12 != C0643C.TIME_UNSET) {
                if (arrayList10.isEmpty()) {
                    list = ((HlsMediaPlaylist.Segment) Iterables.getLast(arrayList2)).parts;
                } else {
                    list = arrayList10;
                }
                i11 = list.size() - 1;
            }
            Uri uri = renditionReport.playlistUri;
            hashMap7.put(uri, new HlsMediaPlaylist.RenditionReport(uri, j22, i11));
        }
        if (part != null) {
            arrayList10.add(part);
        }
        if (j9 != 0) {
            z14 = true;
        }
        return new HlsMediaPlaylist(i2, str, arrayList11, j8, z13, j9, z7, i3, j10, i4, j11, j12, z5, z8, z14, drmInitData2, arrayList2, arrayList10, serverControl2, hashMap7);
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:104:0x03bf. Please report as an issue. */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v3, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r14v4, types: [boolean] */
    /* renamed from: e */
    public static HlsMultivariantPlaylist m2804e(jz2 jz2Var, String str) {
        String str2;
        int i;
        Uri resolveToUri;
        char c;
        Format format;
        ArrayList arrayList;
        ArrayList arrayList2;
        HlsMultivariantPlaylist.Variant variant;
        String str3;
        ArrayList arrayList3;
        int parseInt;
        String str4;
        Format format2;
        int i2;
        HlsMultivariantPlaylist.Variant variant2;
        String str5;
        HlsMultivariantPlaylist.Variant variant3;
        int i3;
        boolean z;
        int i4;
        ArrayList arrayList4;
        ArrayList arrayList5;
        int i5;
        ArrayList arrayList6;
        ArrayList arrayList7;
        ArrayList arrayList8;
        int i6;
        int i7;
        ArrayList arrayList9;
        float f;
        Uri resolveToUri2;
        HashMap hashMap;
        String str6;
        String str7 = str;
        HashMap hashMap2 = new HashMap();
        HashMap hashMap3 = new HashMap();
        ArrayList arrayList10 = new ArrayList();
        ArrayList arrayList11 = new ArrayList();
        ArrayList arrayList12 = new ArrayList();
        ArrayList arrayList13 = new ArrayList();
        ArrayList arrayList14 = new ArrayList();
        ArrayList arrayList15 = new ArrayList();
        ArrayList arrayList16 = new ArrayList();
        ArrayList arrayList17 = new ArrayList();
        boolean z2 = false;
        boolean z3 = false;
        while (true) {
            boolean m5472k = jz2Var.m5472k();
            String str8 = MimeTypes.APPLICATION_M3U8;
            Pattern pattern = f11476K;
            Pattern pattern2 = f11481P;
            if (m5472k) {
                String m5473l = jz2Var.m5473l();
                if (m5473l.startsWith("#EXT")) {
                    arrayList17.add(m5473l);
                }
                boolean startsWith = m5473l.startsWith("#EXT-X-I-FRAME-STREAM-INF");
                ArrayList arrayList18 = arrayList14;
                if (m5473l.startsWith("#EXT-X-DEFINE")) {
                    hashMap3.put(m2809j(m5473l, pattern2, hashMap3), m2809j(m5473l, f11491Z, hashMap3));
                } else {
                    if (m5473l.equals("#EXT-X-INDEPENDENT-SEGMENTS")) {
                        hashMap = hashMap2;
                        arrayList8 = arrayList11;
                        arrayList7 = arrayList12;
                        arrayList6 = arrayList13;
                        arrayList9 = arrayList15;
                        arrayList4 = arrayList16;
                        arrayList5 = arrayList17;
                        z2 = true;
                    } else if (m5473l.startsWith("#EXT-X-MEDIA")) {
                        arrayList15.add(m5473l);
                    } else if (m5473l.startsWith("#EXT-X-SESSION-KEY")) {
                        DrmInitData.SchemeData m2802c = m2802c(m5473l, m2808i(m5473l, f11474I, "identity", hashMap3), hashMap3);
                        if (m2802c != null) {
                            String m2809j = m2809j(m5473l, f11473H, hashMap3);
                            if (!"SAMPLE-AES-CENC".equals(m2809j) && !"SAMPLE-AES-CTR".equals(m2809j)) {
                                str6 = C0643C.CENC_TYPE_cbcs;
                            } else {
                                str6 = C0643C.CENC_TYPE_cenc;
                            }
                            arrayList16.add(new DrmInitData(str6, m2802c));
                        }
                    } else if (m5473l.startsWith("#EXT-X-STREAM-INF") || startsWith) {
                        z3 |= m5473l.contains("CLOSED-CAPTIONS=NONE");
                        if (startsWith) {
                            i4 = 16384;
                        } else {
                            i4 = 0;
                        }
                        arrayList4 = arrayList16;
                        int parseInt2 = Integer.parseInt(m2809j(m5473l, f11499h, Collections.emptyMap()));
                        Matcher matcher = f11494c.matcher(m5473l);
                        if (matcher.find()) {
                            arrayList5 = arrayList17;
                            i5 = Integer.parseInt((String) Assertions.checkNotNull(matcher.group(1)));
                        } else {
                            arrayList5 = arrayList17;
                            i5 = -1;
                        }
                        arrayList6 = arrayList13;
                        String m2808i = m2808i(m5473l, f11501j, null, hashMap3);
                        arrayList7 = arrayList12;
                        String m2808i2 = m2808i(m5473l, f11502k, null, hashMap3);
                        if (m2808i2 != null) {
                            String[] split = Util.split(m2808i2, "x");
                            i7 = Integer.parseInt(split[0]);
                            i6 = Integer.parseInt(split[1]);
                            if (i7 <= 0 || i6 <= 0) {
                                i6 = -1;
                                i7 = -1;
                            }
                            arrayList8 = arrayList11;
                        } else {
                            arrayList8 = arrayList11;
                            i6 = -1;
                            i7 = -1;
                        }
                        arrayList9 = arrayList15;
                        String m2808i3 = m2808i(m5473l, f11503l, null, hashMap3);
                        if (m2808i3 != null) {
                            f = Float.parseFloat(m2808i3);
                        } else {
                            f = -1.0f;
                        }
                        HashMap hashMap4 = hashMap2;
                        String m2808i4 = m2808i(m5473l, f11495d, null, hashMap3);
                        String m2808i5 = m2808i(m5473l, f11496e, null, hashMap3);
                        String m2808i6 = m2808i(m5473l, f11497f, null, hashMap3);
                        String m2808i7 = m2808i(m5473l, f11498g, null, hashMap3);
                        if (startsWith) {
                            resolveToUri2 = UriUtil.resolveToUri(str7, m2809j(m5473l, pattern, hashMap3));
                        } else if (jz2Var.m5472k()) {
                            resolveToUri2 = UriUtil.resolveToUri(str7, m2810k(jz2Var.m5473l(), hashMap3));
                        } else {
                            throw ParserException.createForMalformedManifest("#EXT-X-STREAM-INF must be followed by another line", null);
                        }
                        arrayList10.add(new HlsMultivariantPlaylist.Variant(resolveToUri2, new Format.Builder().setId(arrayList10.size()).setContainerMimeType(MimeTypes.APPLICATION_M3U8).setCodecs(m2808i).setAverageBitrate(i5).setPeakBitrate(parseInt2).setWidth(i7).setHeight(i6).setFrameRate(f).setRoleFlags(i4).build(), m2808i4, m2808i5, m2808i6, m2808i7));
                        hashMap = hashMap4;
                        ArrayList arrayList19 = (ArrayList) hashMap.get(resolveToUri2);
                        if (arrayList19 == null) {
                            arrayList19 = new ArrayList();
                            hashMap.put(resolveToUri2, arrayList19);
                        }
                        arrayList19.add(new HlsTrackMetadataEntry.VariantInfo(i5, parseInt2, m2808i4, m2808i5, m2808i6, m2808i7));
                    }
                    hashMap2 = hashMap;
                    arrayList14 = arrayList18;
                    arrayList16 = arrayList4;
                    arrayList17 = arrayList5;
                    arrayList13 = arrayList6;
                    arrayList12 = arrayList7;
                    arrayList11 = arrayList8;
                    arrayList15 = arrayList9;
                }
                hashMap = hashMap2;
                arrayList8 = arrayList11;
                arrayList7 = arrayList12;
                arrayList6 = arrayList13;
                arrayList9 = arrayList15;
                arrayList4 = arrayList16;
                arrayList5 = arrayList17;
                hashMap2 = hashMap;
                arrayList14 = arrayList18;
                arrayList16 = arrayList4;
                arrayList17 = arrayList5;
                arrayList13 = arrayList6;
                arrayList12 = arrayList7;
                arrayList11 = arrayList8;
                arrayList15 = arrayList9;
            } else {
                HashMap hashMap5 = hashMap2;
                ArrayList arrayList20 = arrayList11;
                ArrayList arrayList21 = arrayList12;
                ArrayList arrayList22 = arrayList13;
                ArrayList arrayList23 = arrayList14;
                ArrayList arrayList24 = arrayList15;
                ArrayList arrayList25 = arrayList16;
                ArrayList arrayList26 = arrayList17;
                ArrayList arrayList27 = new ArrayList();
                HashSet hashSet = new HashSet();
                int i8 = 0;
                while (i8 < arrayList10.size()) {
                    HlsMultivariantPlaylist.Variant variant4 = (HlsMultivariantPlaylist.Variant) arrayList10.get(i8);
                    if (hashSet.add(variant4.url)) {
                        if (variant4.format.metadata == null) {
                            z = true;
                        } else {
                            z = false;
                        }
                        Assertions.checkState(z);
                        i3 = 1;
                        arrayList27.add(variant4.copyWithFormat(variant4.format.buildUpon().setMetadata(new Metadata(new HlsTrackMetadataEntry(null, null, (List) Assertions.checkNotNull((ArrayList) hashMap5.get(variant4.url))))).build()));
                    } else {
                        i3 = 1;
                    }
                    i8 += i3;
                }
                int i9 = 0;
                Format format3 = null;
                ArrayList arrayList28 = null;
                while (i9 < arrayList24.size()) {
                    ArrayList arrayList29 = arrayList24;
                    String str9 = (String) arrayList29.get(i9);
                    String m2809j2 = m2809j(str9, f11482Q, hashMap3);
                    String m2809j3 = m2809j(str9, pattern2, hashMap3);
                    Format.Builder builder = new Format.Builder();
                    StringBuilder sb = new StringBuilder();
                    sb.append(m2809j2);
                    Pattern pattern3 = pattern2;
                    sb.append(":");
                    sb.append(m2809j3);
                    Format.Builder containerMimeType = builder.setId(sb.toString()).setLabel(m2809j3).setContainerMimeType(str8);
                    ?? m2805f = m2805f(str9, f11486U);
                    int i10 = m2805f;
                    if (m2805f(str9, f11487V)) {
                        i10 = (m2805f == true ? 1 : 0) | 2;
                    }
                    int i11 = i10;
                    if (m2805f(str9, f11485T)) {
                        i11 = (i10 == true ? 1 : 0) | 4;
                    }
                    Format.Builder selectionFlags = containerMimeType.setSelectionFlags(i11);
                    String m2808i8 = m2808i(str9, f11483R, null, hashMap3);
                    if (TextUtils.isEmpty(m2808i8)) {
                        str2 = str8;
                        i = 0;
                    } else {
                        String[] split2 = Util.split(m2808i8, ",");
                        if (Util.contains(split2, "public.accessibility.describes-video")) {
                            i = 512;
                            str2 = str8;
                        } else {
                            str2 = str8;
                            i = 0;
                        }
                        if (Util.contains(split2, "public.accessibility.transcribes-spoken-dialog")) {
                            i |= 4096;
                        }
                        if (Util.contains(split2, "public.accessibility.describes-music-and-sound")) {
                            i |= 1024;
                        }
                        if (Util.contains(split2, "public.easy-to-read")) {
                            i |= 8192;
                        }
                    }
                    Format.Builder language = selectionFlags.setRoleFlags(i).setLanguage(m2808i(str9, f11480O, null, hashMap3));
                    String m2808i9 = m2808i(str9, pattern, null, hashMap3);
                    if (m2808i9 == null) {
                        resolveToUri = null;
                    } else {
                        resolveToUri = UriUtil.resolveToUri(str7, m2808i9);
                    }
                    Pattern pattern4 = pattern;
                    Metadata metadata = new Metadata(new HlsTrackMetadataEntry(m2809j2, m2809j3, Collections.emptyList()));
                    String m2809j4 = m2809j(str9, f11478M, hashMap3);
                    switch (m2809j4.hashCode()) {
                        case -959297733:
                            if (m2809j4.equals("SUBTITLES")) {
                                c = 0;
                                break;
                            }
                            break;
                        case -333210994:
                            if (m2809j4.equals("CLOSED-CAPTIONS")) {
                                c = 1;
                                break;
                            }
                            break;
                        case 62628790:
                            if (m2809j4.equals("AUDIO")) {
                                c = 2;
                                break;
                            }
                            break;
                        case 81665115:
                            if (m2809j4.equals("VIDEO")) {
                                c = 3;
                                break;
                            }
                            break;
                    }
                    c = 65535;
                    switch (c) {
                        case 0:
                            arrayList24 = arrayList29;
                            format = format3;
                            arrayList = arrayList21;
                            arrayList2 = arrayList20;
                            int i12 = 0;
                            while (true) {
                                if (i12 < arrayList10.size()) {
                                    variant = (HlsMultivariantPlaylist.Variant) arrayList10.get(i12);
                                    if (!m2809j2.equals(variant.subtitleGroupId)) {
                                        i12++;
                                    }
                                } else {
                                    variant = null;
                                }
                            }
                            if (variant != null) {
                                String codecsOfType = Util.getCodecsOfType(variant.format.codecs, 3);
                                language.setCodecs(codecsOfType);
                                str3 = MimeTypes.getMediaMimeType(codecsOfType);
                            } else {
                                str3 = null;
                            }
                            if (str3 == null) {
                                str3 = MimeTypes.TEXT_VTT;
                            }
                            language.setSampleMimeType(str3).setMetadata(metadata);
                            if (resolveToUri != null) {
                                arrayList3 = arrayList22;
                                arrayList3.add(new HlsMultivariantPlaylist.Rendition(resolveToUri, language.build(), m2809j2, m2809j3));
                            } else {
                                arrayList3 = arrayList22;
                                Log.m3027w("HlsPlaylistParser", "EXT-X-MEDIA tag with missing mandatory URI attribute: skipping");
                            }
                            format2 = format;
                            break;
                        case 1:
                            arrayList24 = arrayList29;
                            Format format4 = format3;
                            arrayList = arrayList21;
                            arrayList2 = arrayList20;
                            String m2809j5 = m2809j(str9, f11484S, hashMap3);
                            if (m2809j5.startsWith("CC")) {
                                parseInt = Integer.parseInt(m2809j5.substring(2));
                                str4 = MimeTypes.APPLICATION_CEA608;
                            } else {
                                parseInt = Integer.parseInt(m2809j5.substring(7));
                                str4 = MimeTypes.APPLICATION_CEA708;
                            }
                            if (arrayList28 == null) {
                                arrayList28 = new ArrayList();
                            }
                            language.setSampleMimeType(str4).setAccessibilityChannel(parseInt);
                            arrayList28.add(language.build());
                            format2 = format4;
                            arrayList3 = arrayList22;
                            break;
                        case 2:
                            arrayList2 = arrayList20;
                            int i13 = 0;
                            while (true) {
                                if (i13 < arrayList10.size()) {
                                    HlsMultivariantPlaylist.Variant variant5 = (HlsMultivariantPlaylist.Variant) arrayList10.get(i13);
                                    arrayList24 = arrayList29;
                                    if (m2809j2.equals(variant5.audioGroupId)) {
                                        variant2 = variant5;
                                        i2 = 1;
                                    } else {
                                        i13++;
                                        arrayList29 = arrayList24;
                                    }
                                } else {
                                    arrayList24 = arrayList29;
                                    i2 = 1;
                                    variant2 = null;
                                }
                            }
                            if (variant2 != null) {
                                String codecsOfType2 = Util.getCodecsOfType(variant2.format.codecs, i2);
                                language.setCodecs(codecsOfType2);
                                str5 = MimeTypes.getMediaMimeType(codecsOfType2);
                            } else {
                                str5 = null;
                            }
                            format = format3;
                            String m2808i10 = m2808i(str9, f11500i, null, hashMap3);
                            if (m2808i10 != null) {
                                language.setChannelCount(Integer.parseInt(Util.splitAtFirst(m2808i10, "/")[0]));
                                if (MimeTypes.AUDIO_E_AC3.equals(str5) && m2808i10.endsWith("/JOC")) {
                                    language.setCodecs(MimeTypes.CODEC_E_AC3_JOC);
                                    str5 = MimeTypes.AUDIO_E_AC3_JOC;
                                }
                            }
                            language.setSampleMimeType(str5);
                            if (resolveToUri != null) {
                                language.setMetadata(metadata);
                                arrayList = arrayList21;
                                arrayList.add(new HlsMultivariantPlaylist.Rendition(resolveToUri, language.build(), m2809j2, m2809j3));
                            } else {
                                arrayList = arrayList21;
                                if (variant2 != null) {
                                    format2 = language.build();
                                    arrayList3 = arrayList22;
                                    break;
                                }
                            }
                            arrayList3 = arrayList22;
                            format2 = format;
                            break;
                        case 3:
                            int i14 = 0;
                            while (true) {
                                if (i14 < arrayList10.size()) {
                                    variant3 = (HlsMultivariantPlaylist.Variant) arrayList10.get(i14);
                                    if (!m2809j2.equals(variant3.videoGroupId)) {
                                        i14++;
                                    }
                                } else {
                                    variant3 = null;
                                }
                            }
                            if (variant3 != null) {
                                Format format5 = variant3.format;
                                String codecsOfType3 = Util.getCodecsOfType(format5.codecs, 2);
                                language.setCodecs(codecsOfType3).setSampleMimeType(MimeTypes.getMediaMimeType(codecsOfType3)).setWidth(format5.width).setHeight(format5.height).setFrameRate(format5.frameRate);
                            }
                            if (resolveToUri != null) {
                                language.setMetadata(metadata);
                                arrayList2 = arrayList20;
                                arrayList2.add(new HlsMultivariantPlaylist.Rendition(resolveToUri, language.build(), m2809j2, m2809j3));
                                arrayList24 = arrayList29;
                                format = format3;
                                arrayList3 = arrayList22;
                                arrayList = arrayList21;
                                format2 = format;
                                break;
                            }
                        default:
                            arrayList24 = arrayList29;
                            format = format3;
                            arrayList3 = arrayList22;
                            arrayList = arrayList21;
                            arrayList2 = arrayList20;
                            format2 = format;
                            break;
                    }
                    i9++;
                    str7 = str;
                    format3 = format2;
                    arrayList21 = arrayList;
                    arrayList22 = arrayList3;
                    arrayList20 = arrayList2;
                    pattern2 = pattern3;
                    str8 = str2;
                    pattern = pattern4;
                }
                Format format6 = format3;
                ArrayList arrayList30 = arrayList22;
                ArrayList arrayList31 = arrayList21;
                ArrayList arrayList32 = arrayList20;
                if (z3) {
                    arrayList28 = Collections.emptyList();
                }
                return new HlsMultivariantPlaylist(str, arrayList26, arrayList27, arrayList32, arrayList31, arrayList30, arrayList23, format6, arrayList28, z2, hashMap3, arrayList25);
            }
        }
    }

    /* renamed from: f */
    public static boolean m2805f(String str, Pattern pattern) {
        Matcher matcher = pattern.matcher(str);
        if (matcher.find()) {
            return "YES".equals(matcher.group(1));
        }
        return false;
    }

    /* renamed from: g */
    public static double m2806g(String str, Pattern pattern) {
        Matcher matcher = pattern.matcher(str);
        if (matcher.find()) {
            return Double.parseDouble((String) Assertions.checkNotNull(matcher.group(1)));
        }
        return -9.223372036854776E18d;
    }

    /* renamed from: h */
    public static long m2807h(String str, Pattern pattern) {
        Matcher matcher = pattern.matcher(str);
        if (matcher.find()) {
            return Long.parseLong((String) Assertions.checkNotNull(matcher.group(1)));
        }
        return -1L;
    }

    /* renamed from: i */
    public static String m2808i(String str, Pattern pattern, String str2, Map map) {
        Matcher matcher = pattern.matcher(str);
        if (matcher.find()) {
            str2 = (String) Assertions.checkNotNull(matcher.group(1));
        }
        if (!map.isEmpty() && str2 != null) {
            return m2810k(str2, map);
        }
        return str2;
    }

    /* renamed from: j */
    public static String m2809j(String str, Pattern pattern, Map map) {
        String m2808i = m2808i(str, pattern, null, map);
        if (m2808i != null) {
            return m2808i;
        }
        throw ParserException.createForMalformedManifest("Couldn't match " + pattern.pattern() + " in " + str, null);
    }

    /* renamed from: k */
    public static String m2810k(String str, Map map) {
        Matcher matcher = f11493b0.matcher(str);
        StringBuffer stringBuffer = new StringBuffer();
        while (matcher.find()) {
            String group = matcher.group(1);
            if (map.containsKey(group)) {
                matcher.appendReplacement(stringBuffer, Matcher.quoteReplacement((String) map.get(group)));
            }
        }
        matcher.appendTail(stringBuffer);
        return stringBuffer.toString();
    }

    public HlsPlaylistParser(HlsMultivariantPlaylist hlsMultivariantPlaylist, @Nullable HlsMediaPlaylist hlsMediaPlaylist) {
        this.f11518a = hlsMultivariantPlaylist;
        this.f11519b = hlsMediaPlaylist;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0069 A[Catch: all -> 0x0097, LOOP:0: B:13:0x0069->B:38:0x0069, LOOP_START, TryCatch #0 {all -> 0x0097, blocks: (B:3:0x000f, B:5:0x0018, B:7:0x0020, B:10:0x0029, B:13:0x0069, B:15:0x006f, B:18:0x007a, B:53:0x0082, B:20:0x0099, B:22:0x00a1, B:24:0x00a9, B:26:0x00b1, B:28:0x00b9, B:30:0x00c1, B:32:0x00c9, B:34:0x00d1, B:36:0x00da, B:41:0x00de, B:62:0x0101, B:63:0x0107, B:67:0x0030, B:69:0x0036, B:74:0x003f, B:76:0x0048, B:81:0x0051, B:83:0x0057, B:85:0x005d, B:87:0x0062), top: B:2:0x000f }] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0101 A[Catch: all -> 0x0097, TRY_ENTER, TryCatch #0 {all -> 0x0097, blocks: (B:3:0x000f, B:5:0x0018, B:7:0x0020, B:10:0x0029, B:13:0x0069, B:15:0x006f, B:18:0x007a, B:53:0x0082, B:20:0x0099, B:22:0x00a1, B:24:0x00a9, B:26:0x00b1, B:28:0x00b9, B:30:0x00c1, B:32:0x00c9, B:34:0x00d1, B:36:0x00da, B:41:0x00de, B:62:0x0101, B:63:0x0107, B:67:0x0030, B:69:0x0036, B:74:0x003f, B:76:0x0048, B:81:0x0051, B:83:0x0057, B:85:0x005d, B:87:0x0062), top: B:2:0x000f }] */
    @Override // com.google.android.exoplayer2.upstream.ParsingLoadable.Parser
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public HlsPlaylist parse(Uri uri, InputStream inputStream) {
        String trim;
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        ArrayDeque arrayDeque = new ArrayDeque();
        try {
            int read = bufferedReader.read();
            boolean z = false;
            if (read == 239) {
                if (bufferedReader.read() == 187 && bufferedReader.read() == 191) {
                    read = bufferedReader.read();
                }
                if (!z) {
                    while (true) {
                        String readLine = bufferedReader.readLine();
                        if (readLine != null) {
                            trim = readLine.trim();
                            if (!trim.isEmpty()) {
                                if (trim.startsWith("#EXT-X-STREAM-INF")) {
                                    arrayDeque.add(trim);
                                    return m2804e(new jz2(arrayDeque, bufferedReader, 4), uri.toString());
                                }
                                if (trim.startsWith("#EXT-X-TARGETDURATION") || trim.startsWith("#EXT-X-MEDIA-SEQUENCE") || trim.startsWith("#EXTINF") || trim.startsWith("#EXT-X-KEY") || trim.startsWith("#EXT-X-BYTERANGE") || trim.equals("#EXT-X-DISCONTINUITY") || trim.equals("#EXT-X-DISCONTINUITY-SEQUENCE") || trim.equals("#EXT-X-ENDLIST")) {
                                    break;
                                }
                                arrayDeque.add(trim);
                            }
                        } else {
                            Util.closeQuietly(bufferedReader);
                            throw ParserException.createForMalformedManifest("Failed to parse the playlist, could not identify any tags.", null);
                        }
                    }
                    arrayDeque.add(trim);
                    return m2803d(this.f11518a, this.f11519b, new jz2(arrayDeque, bufferedReader, 4), uri.toString());
                }
                throw ParserException.createForMalformedManifest("Input does not start with the #EXTM3U header.", null);
            }
            while (read != -1 && Character.isWhitespace(read)) {
                read = bufferedReader.read();
            }
            int i = 0;
            while (true) {
                if (i < 7) {
                    if (read != "#EXTM3U".charAt(i)) {
                        break;
                    }
                    read = bufferedReader.read();
                    i++;
                } else {
                    while (read != -1 && Character.isWhitespace(read) && !Util.isLinebreak(read)) {
                        read = bufferedReader.read();
                    }
                    z = Util.isLinebreak(read);
                }
            }
            if (!z) {
            }
        } finally {
            Util.closeQuietly(bufferedReader);
        }
    }
}
