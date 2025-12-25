package com.google.android.exoplayer2.source.hls;

import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.C0643C;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.SeekParameters;
import com.google.android.exoplayer2.analytics.PlayerId;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.drm.DrmSessionEventListener;
import com.google.android.exoplayer2.drm.DrmSessionManager;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.offline.StreamKey;
import com.google.android.exoplayer2.source.CompositeSequenceableLoaderFactory;
import com.google.android.exoplayer2.source.MediaPeriod;
import com.google.android.exoplayer2.source.MediaSourceEventListener;
import com.google.android.exoplayer2.source.SampleStream;
import com.google.android.exoplayer2.source.SequenceableLoader;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist;
import com.google.android.exoplayer2.source.hls.playlist.HlsMultivariantPlaylist;
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker;
import com.google.android.exoplayer2.trackselection.ExoTrackSelection;
import com.google.android.exoplayer2.trackselection.TrackSelectionUtil;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy;
import com.google.android.exoplayer2.upstream.Loader;
import com.google.android.exoplayer2.upstream.TransferListener;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.Util;
import com.google.common.collect.Iterables;
import com.google.common.primitives.Ints;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;
import p000.AbstractC1726qj;
import p000.p01;
import p000.q01;
import p000.r01;
import p000.u01;
import p000.v01;
import p000.ye0;

/* loaded from: classes.dex */
public final class HlsMediaPeriod implements MediaPeriod, HlsSampleStreamWrapper$Callback, HlsPlaylistTracker.PlaylistEventListener {

    /* renamed from: a */
    public final HlsExtractorFactory f11383a;

    /* renamed from: b */
    public final HlsPlaylistTracker f11384b;

    /* renamed from: c */
    public final HlsDataSourceFactory f11385c;

    /* renamed from: d */
    public final TransferListener f11386d;

    /* renamed from: e */
    public final DrmSessionManager f11387e;

    /* renamed from: f */
    public final DrmSessionEventListener.EventDispatcher f11388f;

    /* renamed from: g */
    public final LoadErrorHandlingPolicy f11389g;

    /* renamed from: h */
    public final MediaSourceEventListener.EventDispatcher f11390h;

    /* renamed from: i */
    public final Allocator f11391i;

    /* renamed from: l */
    public final CompositeSequenceableLoaderFactory f11394l;

    /* renamed from: m */
    public final boolean f11395m;

    /* renamed from: n */
    public final int f11396n;

    /* renamed from: o */
    public final boolean f11397o;

    /* renamed from: p */
    public final PlayerId f11398p;

    /* renamed from: q */
    public MediaPeriod.Callback f11399q;

    /* renamed from: r */
    public int f11400r;

    /* renamed from: s */
    public TrackGroupArray f11401s;

    /* renamed from: w */
    public int f11405w;

    /* renamed from: x */
    public SequenceableLoader f11406x;

    /* renamed from: j */
    public final IdentityHashMap f11392j = new IdentityHashMap();

    /* renamed from: k */
    public final TimestampAdjusterProvider f11393k = new TimestampAdjusterProvider();

    /* renamed from: t */
    public v01[] f11402t = new v01[0];

    /* renamed from: u */
    public v01[] f11403u = new v01[0];

    /* renamed from: v */
    public int[][] f11404v = new int[0];

    public HlsMediaPeriod(HlsExtractorFactory hlsExtractorFactory, HlsPlaylistTracker hlsPlaylistTracker, HlsDataSourceFactory hlsDataSourceFactory, @Nullable TransferListener transferListener, DrmSessionManager drmSessionManager, DrmSessionEventListener.EventDispatcher eventDispatcher, LoadErrorHandlingPolicy loadErrorHandlingPolicy, MediaSourceEventListener.EventDispatcher eventDispatcher2, Allocator allocator, CompositeSequenceableLoaderFactory compositeSequenceableLoaderFactory, boolean z, int i, boolean z2, PlayerId playerId) {
        this.f11383a = hlsExtractorFactory;
        this.f11384b = hlsPlaylistTracker;
        this.f11385c = hlsDataSourceFactory;
        this.f11386d = transferListener;
        this.f11387e = drmSessionManager;
        this.f11388f = eventDispatcher;
        this.f11389g = loadErrorHandlingPolicy;
        this.f11390h = eventDispatcher2;
        this.f11391i = allocator;
        this.f11394l = compositeSequenceableLoaderFactory;
        this.f11395m = z;
        this.f11396n = i;
        this.f11397o = z2;
        this.f11398p = playerId;
        this.f11406x = compositeSequenceableLoaderFactory.createCompositeSequenceableLoader(new SequenceableLoader[0]);
    }

    /* renamed from: b */
    public static Format m2791b(Format format, Format format2, boolean z) {
        String codecsOfType;
        Metadata metadata;
        int i;
        String str;
        int i2;
        int i3;
        String str2;
        int i4;
        int i5 = -1;
        if (format2 != null) {
            codecsOfType = format2.codecs;
            metadata = format2.metadata;
            i2 = format2.channelCount;
            i = format2.selectionFlags;
            i3 = format2.roleFlags;
            str = format2.language;
            str2 = format2.label;
        } else {
            codecsOfType = Util.getCodecsOfType(format.codecs, 1);
            metadata = format.metadata;
            if (z) {
                i2 = format.channelCount;
                i = format.selectionFlags;
                i3 = format.roleFlags;
                str = format.language;
                str2 = format.label;
            } else {
                i = 0;
                str = null;
                i2 = -1;
                i3 = 0;
                str2 = null;
            }
        }
        String mediaMimeType = MimeTypes.getMediaMimeType(codecsOfType);
        if (z) {
            i4 = format.averageBitrate;
        } else {
            i4 = -1;
        }
        if (z) {
            i5 = format.peakBitrate;
        }
        return new Format.Builder().setId(format.f9354id).setLabel(str2).setContainerMimeType(format.containerMimeType).setSampleMimeType(mediaMimeType).setCodecs(codecsOfType).setMetadata(metadata).setAverageBitrate(i4).setPeakBitrate(i5).setChannelCount(i2).setSelectionFlags(i).setRoleFlags(i3).setLanguage(str).build();
    }

    /* renamed from: a */
    public final v01 m2792a(String str, int i, Uri[] uriArr, Format[] formatArr, Format format, List list, Map map, long j) {
        return new v01(str, i, this, new p01(this.f11383a, this.f11384b, uriArr, formatArr, this.f11385c, this.f11386d, this.f11393k, list, this.f11398p), map, this.f11391i, j, format, this.f11387e, this.f11388f, this.f11389g, this.f11390h, this.f11396n);
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
    public boolean continueLoading(long j) {
        if (this.f11401s == null) {
            for (v01 v01Var : this.f11402t) {
                if (!v01Var.f27566D) {
                    v01Var.continueLoading(v01Var.f27578P);
                }
            }
            return false;
        }
        return this.f11406x.continueLoading(j);
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public void discardBuffer(long j, boolean z) {
        for (v01 v01Var : this.f11403u) {
            if (v01Var.f27565C && !v01Var.m7799h()) {
                int length = v01Var.f27608v.length;
                for (int i = 0; i < length; i++) {
                    v01Var.f27608v[i].discardTo(j, z, v01Var.f27576N[i]);
                }
            }
        }
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public long getAdjustedSeekPositionUs(long j, SeekParameters seekParameters) {
        HlsMediaPlaylist hlsMediaPlaylist;
        long j2;
        for (v01 v01Var : this.f11403u) {
            if (v01Var.f27563A == 2) {
                p01 p01Var = v01Var.f27590d;
                int selectedIndex = p01Var.f24988q.getSelectedIndex();
                Uri[] uriArr = p01Var.f24976e;
                int length = uriArr.length;
                HlsPlaylistTracker hlsPlaylistTracker = p01Var.f24978g;
                if (selectedIndex < length && selectedIndex != -1) {
                    hlsMediaPlaylist = hlsPlaylistTracker.getPlaylistSnapshot(uriArr[p01Var.f24988q.getSelectedIndexInTrackGroup()], true);
                } else {
                    hlsMediaPlaylist = null;
                }
                if (hlsMediaPlaylist != null && !hlsMediaPlaylist.segments.isEmpty() && hlsMediaPlaylist.hasIndependentSegments) {
                    long initialStartTimeUs = hlsMediaPlaylist.startTimeUs - hlsPlaylistTracker.getInitialStartTimeUs();
                    long j3 = j - initialStartTimeUs;
                    int binarySearchFloor = Util.binarySearchFloor((List<? extends Comparable<? super Long>>) hlsMediaPlaylist.segments, Long.valueOf(j3), true, true);
                    long j4 = hlsMediaPlaylist.segments.get(binarySearchFloor).relativeStartTimeUs;
                    if (binarySearchFloor != hlsMediaPlaylist.segments.size() - 1) {
                        j2 = hlsMediaPlaylist.segments.get(binarySearchFloor + 1).relativeStartTimeUs;
                    } else {
                        j2 = j4;
                    }
                    return seekParameters.resolveSeekPositionUs(j3, j4, j2) + initialStartTimeUs;
                }
                return j;
            }
        }
        return j;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
    public long getBufferedPositionUs() {
        return this.f11406x.getBufferedPositionUs();
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
    public long getNextLoadPositionUs() {
        return this.f11406x.getNextLoadPositionUs();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r15v1 */
    /* JADX WARN: Type inference failed for: r15v2, types: [int] */
    /* JADX WARN: Type inference failed for: r15v7 */
    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public List<StreamKey> getStreamKeys(List<ExoTrackSelection> list) {
        int[] iArr;
        TrackGroupArray trackGroupArray;
        int i;
        int i2;
        HlsMediaPeriod hlsMediaPeriod = this;
        HlsMultivariantPlaylist hlsMultivariantPlaylist = (HlsMultivariantPlaylist) Assertions.checkNotNull(hlsMediaPeriod.f11384b.getMultivariantPlaylist());
        boolean isEmpty = hlsMultivariantPlaylist.variants.isEmpty();
        boolean z = !isEmpty;
        int length = hlsMediaPeriod.f11402t.length - hlsMultivariantPlaylist.subtitles.size();
        int i3 = 0;
        if (!isEmpty) {
            v01 v01Var = hlsMediaPeriod.f11402t[0];
            iArr = hlsMediaPeriod.f11404v[0];
            v01Var.m7795a();
            trackGroupArray = v01Var.f27571I;
            i = v01Var.f27574L;
        } else {
            iArr = new int[0];
            trackGroupArray = TrackGroupArray.EMPTY;
            i = 0;
        }
        ArrayList arrayList = new ArrayList();
        boolean z2 = false;
        boolean z3 = false;
        for (ExoTrackSelection exoTrackSelection : list) {
            TrackGroup trackGroup = exoTrackSelection.getTrackGroup();
            int indexOf = trackGroupArray.indexOf(trackGroup);
            if (indexOf != -1) {
                if (indexOf == i) {
                    for (int i4 = i3; i4 < exoTrackSelection.length(); i4++) {
                        arrayList.add(new StreamKey(i3, iArr[exoTrackSelection.getIndexInTrackGroup(i4)]));
                    }
                    z3 = true;
                } else {
                    z2 = true;
                }
            } else {
                ?? r15 = z;
                while (true) {
                    v01[] v01VarArr = hlsMediaPeriod.f11402t;
                    if (r15 < v01VarArr.length) {
                        v01 v01Var2 = v01VarArr[r15];
                        v01Var2.m7795a();
                        if (v01Var2.f27571I.indexOf(trackGroup) != -1) {
                            if (r15 < length) {
                                i2 = 1;
                            } else {
                                i2 = 2;
                            }
                            int[] iArr2 = hlsMediaPeriod.f11404v[r15];
                            for (int i5 = 0; i5 < exoTrackSelection.length(); i5++) {
                                arrayList.add(new StreamKey(i2, iArr2[exoTrackSelection.getIndexInTrackGroup(i5)]));
                            }
                        } else {
                            hlsMediaPeriod = this;
                            r15++;
                        }
                    }
                }
            }
            hlsMediaPeriod = this;
            i3 = 0;
        }
        if (z2 && !z3) {
            int i6 = iArr[0];
            int i7 = hlsMultivariantPlaylist.variants.get(i6).format.bitrate;
            for (int i8 = 1; i8 < iArr.length; i8++) {
                int i9 = hlsMultivariantPlaylist.variants.get(iArr[i8]).format.bitrate;
                if (i9 < i7) {
                    i6 = iArr[i8];
                    i7 = i9;
                }
            }
            arrayList.add(new StreamKey(0, i6));
        }
        return arrayList;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public TrackGroupArray getTrackGroups() {
        return (TrackGroupArray) Assertions.checkNotNull(this.f11401s);
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
    public boolean isLoading() {
        return this.f11406x.isLoading();
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public void maybeThrowPrepareError() {
        for (v01 v01Var : this.f11402t) {
            v01Var.m7801j();
            if (v01Var.f27582T && !v01Var.f27566D) {
                throw ParserException.createForMalformedContainer("Loading finished before preparation is complete.", null);
            }
        }
    }

    @Override // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker.PlaylistEventListener
    public void onPlaylistChanged() {
        for (v01 v01Var : this.f11402t) {
            ArrayList arrayList = v01Var.f27600n;
            if (!arrayList.isEmpty()) {
                q01 q01Var = (q01) Iterables.getLast(arrayList);
                int m6764b = v01Var.f27590d.m6764b(q01Var);
                if (m6764b == 1) {
                    q01Var.f25366B = true;
                } else if (m6764b == 2 && !v01Var.f27582T) {
                    Loader loader = v01Var.f27596j;
                    if (loader.isLoading()) {
                        loader.cancelLoading();
                    }
                }
            }
        }
        this.f11399q.onContinueLoadingRequested(this);
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x007b, code lost:
    
        if (r9.f24978g.excludeMediaPlaylist(r17, r14) == false) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x007f, code lost:
    
        if (r14 == com.google.android.exoplayer2.C0643C.TIME_UNSET) goto L39;
     */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0051 A[SYNTHETIC] */
    @Override // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker.PlaylistEventListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onPlaylistError(Uri uri, LoadErrorHandlingPolicy.LoadErrorInfo loadErrorInfo, boolean z) {
        long j;
        int i;
        Uri[] uriArr;
        boolean z2;
        int indexOf;
        boolean z3 = true;
        for (v01 v01Var : this.f11402t) {
            p01 p01Var = v01Var.f27590d;
            if (Util.contains(p01Var.f24976e, uri)) {
                if (!z) {
                    LoadErrorHandlingPolicy.FallbackSelection fallbackSelectionFor = v01Var.f27595i.getFallbackSelectionFor(TrackSelectionUtil.createFallbackOptions(p01Var.f24988q), loadErrorInfo);
                    if (fallbackSelectionFor != null && fallbackSelectionFor.type == 2) {
                        j = fallbackSelectionFor.exclusionDurationMs;
                        i = 0;
                        while (true) {
                            uriArr = p01Var.f24976e;
                            if (i >= uriArr.length) {
                                if (uriArr[i].equals(uri)) {
                                    break;
                                }
                                i++;
                            } else {
                                i = -1;
                                break;
                            }
                        }
                        if (i != -1 && (indexOf = p01Var.f24988q.indexOf(i)) != -1) {
                            p01Var.f24990s |= uri.equals(p01Var.f24986o);
                            if (j != C0643C.TIME_UNSET) {
                                if (!p01Var.f24988q.blacklist(indexOf, j)) {
                                }
                                z2 = false;
                                z3 &= z2;
                            }
                        }
                    }
                }
                j = -9223372036854775807L;
                i = 0;
                while (true) {
                    uriArr = p01Var.f24976e;
                    if (i >= uriArr.length) {
                    }
                    i++;
                }
                if (i != -1) {
                    p01Var.f24990s |= uri.equals(p01Var.f24986o);
                    if (j != C0643C.TIME_UNSET) {
                    }
                }
            }
            z2 = true;
            z3 &= z2;
        }
        this.f11399q.onContinueLoadingRequested(this);
        return z3;
    }

    @Override // com.google.android.exoplayer2.source.hls.HlsSampleStreamWrapper$Callback
    public void onPlaylistRefreshRequired(Uri uri) {
        this.f11384b.refreshPlaylist(uri);
    }

    @Override // com.google.android.exoplayer2.source.hls.HlsSampleStreamWrapper$Callback
    public void onPrepared() {
        int i = this.f11400r - 1;
        this.f11400r = i;
        if (i > 0) {
            return;
        }
        int i2 = 0;
        for (v01 v01Var : this.f11402t) {
            v01Var.m7795a();
            i2 += v01Var.f27571I.length;
        }
        TrackGroup[] trackGroupArr = new TrackGroup[i2];
        int i3 = 0;
        for (v01 v01Var2 : this.f11402t) {
            v01Var2.m7795a();
            int i4 = v01Var2.f27571I.length;
            int i5 = 0;
            while (i5 < i4) {
                v01Var2.m7795a();
                trackGroupArr[i3] = v01Var2.f27571I.get(i5);
                i5++;
                i3++;
            }
        }
        this.f11401s = new TrackGroupArray(trackGroupArr);
        this.f11399q.onPrepared(this);
    }

    /* JADX WARN: Code restructure failed: missing block: B:50:0x00e9, code lost:
    
        if (r1[r11] == 2) goto L47;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x017a  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x023d  */
    /* JADX WARN: Type inference failed for: r2v0, types: [java.util.Map] */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v47, types: [java.util.HashMap] */
    @Override // com.google.android.exoplayer2.source.MediaPeriod
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void prepare(MediaPeriod.Callback callback, long j) {
        ?? emptyMap;
        boolean z;
        List<HlsMultivariantPlaylist.Rendition> list;
        Map map;
        List<HlsMultivariantPlaylist.Rendition> list2;
        ArrayList arrayList;
        ArrayList arrayList2;
        int i;
        List<HlsMultivariantPlaylist.Rendition> list3;
        int i2;
        boolean z2;
        int i3;
        boolean z3;
        boolean z4;
        int i4;
        int codecCountOfType;
        int codecCountOfType2;
        boolean z5;
        int i5;
        v01 m2792a;
        ArrayList arrayList3;
        int i6;
        int i7;
        this.f11399q = callback;
        HlsPlaylistTracker hlsPlaylistTracker = this.f11384b;
        hlsPlaylistTracker.addListener(this);
        HlsMultivariantPlaylist hlsMultivariantPlaylist = (HlsMultivariantPlaylist) Assertions.checkNotNull(hlsPlaylistTracker.getMultivariantPlaylist());
        if (this.f11397o) {
            List<DrmInitData> list4 = hlsMultivariantPlaylist.sessionKeyDrmInitData;
            ArrayList arrayList4 = new ArrayList(list4);
            emptyMap = new HashMap();
            int i8 = 0;
            while (i8 < arrayList4.size()) {
                DrmInitData drmInitData = list4.get(i8);
                String str = drmInitData.schemeType;
                i8++;
                int i9 = i8;
                while (i9 < arrayList4.size()) {
                    DrmInitData drmInitData2 = (DrmInitData) arrayList4.get(i9);
                    if (TextUtils.equals(drmInitData2.schemeType, str)) {
                        drmInitData = drmInitData.merge(drmInitData2);
                        arrayList4.remove(i9);
                    } else {
                        i9++;
                    }
                }
                emptyMap.put(str, drmInitData);
            }
        } else {
            emptyMap = Collections.emptyMap();
        }
        Map map2 = emptyMap;
        boolean isEmpty = hlsMultivariantPlaylist.variants.isEmpty();
        List<HlsMultivariantPlaylist.Rendition> list5 = hlsMultivariantPlaylist.audios;
        List<HlsMultivariantPlaylist.Rendition> list6 = hlsMultivariantPlaylist.subtitles;
        this.f11400r = 0;
        ArrayList arrayList5 = new ArrayList();
        ArrayList arrayList6 = new ArrayList();
        boolean z6 = this.f11395m;
        if (!isEmpty) {
            int size = hlsMultivariantPlaylist.variants.size();
            int[] iArr = new int[size];
            int i10 = 0;
            int i11 = 0;
            int i12 = 0;
            while (i10 < hlsMultivariantPlaylist.variants.size()) {
                Format format = hlsMultivariantPlaylist.variants.get(i10).format;
                if (format.height > 0 || Util.getCodecsOfType(format.codecs, 2) != null) {
                    i7 = 1;
                    iArr[i10] = 2;
                    i11++;
                } else {
                    i7 = 1;
                    if (Util.getCodecsOfType(format.codecs, 1) != null) {
                        iArr[i10] = 1;
                        i12++;
                    } else {
                        iArr[i10] = -1;
                    }
                }
                i10 += i7;
            }
            if (i11 > 0) {
                i3 = i11;
                z3 = true;
            } else if (i12 < size) {
                i3 = size - i12;
                z3 = false;
                z4 = true;
                Uri[] uriArr = new Uri[i3];
                Format[] formatArr = new Format[i3];
                int[] iArr2 = new int[i3];
                z = z6;
                i4 = 0;
                int i13 = 0;
                while (i4 < hlsMultivariantPlaylist.variants.size()) {
                    if (z3) {
                        arrayList3 = arrayList6;
                    } else {
                        arrayList3 = arrayList6;
                    }
                    if (!z4 || iArr[i4] != 1) {
                        HlsMultivariantPlaylist.Variant variant = hlsMultivariantPlaylist.variants.get(i4);
                        uriArr[i13] = variant.url;
                        formatArr[i13] = variant.format;
                        i6 = 1;
                        iArr2[i13] = i4;
                        i13++;
                        i4 += i6;
                        arrayList6 = arrayList3;
                    }
                    i6 = 1;
                    i4 += i6;
                    arrayList6 = arrayList3;
                }
                ArrayList arrayList7 = arrayList6;
                String str2 = formatArr[0].codecs;
                codecCountOfType = Util.getCodecCountOfType(str2, 2);
                codecCountOfType2 = Util.getCodecCountOfType(str2, 1);
                if ((codecCountOfType2 != 1 || (codecCountOfType2 == 0 && hlsMultivariantPlaylist.audios.isEmpty())) && codecCountOfType <= 1 && codecCountOfType2 + codecCountOfType > 0) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                if (z3 && codecCountOfType2 > 0) {
                    i5 = 1;
                } else {
                    i5 = 0;
                }
                list2 = list5;
                arrayList = arrayList7;
                list = list6;
                map = map2;
                arrayList2 = arrayList5;
                m2792a = m2792a("main", i5, uriArr, formatArr, hlsMultivariantPlaylist.muxedAudioFormat, hlsMultivariantPlaylist.muxedCaptionFormats, map2, j);
                arrayList2.add(m2792a);
                arrayList.add(iArr2);
                if (z && z5) {
                    ArrayList arrayList8 = new ArrayList();
                    if (codecCountOfType <= 0) {
                        Format[] formatArr2 = new Format[i3];
                        for (int i14 = 0; i14 < i3; i14++) {
                            Format format2 = formatArr[i14];
                            String codecsOfType = Util.getCodecsOfType(format2.codecs, 2);
                            formatArr2[i14] = new Format.Builder().setId(format2.f9354id).setLabel(format2.label).setContainerMimeType(format2.containerMimeType).setSampleMimeType(MimeTypes.getMediaMimeType(codecsOfType)).setCodecs(codecsOfType).setMetadata(format2.metadata).setAverageBitrate(format2.averageBitrate).setPeakBitrate(format2.peakBitrate).setWidth(format2.width).setHeight(format2.height).setFrameRate(format2.frameRate).setSelectionFlags(format2.selectionFlags).setRoleFlags(format2.roleFlags).build();
                        }
                        arrayList8.add(new TrackGroup("main", formatArr2));
                        if (codecCountOfType2 > 0 && (hlsMultivariantPlaylist.muxedAudioFormat != null || hlsMultivariantPlaylist.audios.isEmpty())) {
                            arrayList8.add(new TrackGroup("main:audio", m2791b(formatArr[0], hlsMultivariantPlaylist.muxedAudioFormat, false)));
                        }
                        List<Format> list7 = hlsMultivariantPlaylist.muxedCaptionFormats;
                        if (list7 != null) {
                            for (int i15 = 0; i15 < list7.size(); i15++) {
                                arrayList8.add(new TrackGroup(ye0.m8291k(i15, "main:cc:"), list7.get(i15)));
                            }
                        }
                    } else {
                        Format[] formatArr3 = new Format[i3];
                        for (int i16 = 0; i16 < i3; i16++) {
                            formatArr3[i16] = m2791b(formatArr[i16], hlsMultivariantPlaylist.muxedAudioFormat, true);
                        }
                        arrayList8.add(new TrackGroup("main", formatArr3));
                    }
                    TrackGroup trackGroup = new TrackGroup("main:id3", new Format.Builder().setId("ID3").setSampleMimeType(MimeTypes.APPLICATION_ID3).build());
                    arrayList8.add(trackGroup);
                    m2792a.m7802k((TrackGroup[]) arrayList8.toArray(new TrackGroup[0]), arrayList8.indexOf(trackGroup));
                }
            } else {
                i3 = size;
                z3 = false;
            }
            z4 = false;
            Uri[] uriArr2 = new Uri[i3];
            Format[] formatArr4 = new Format[i3];
            int[] iArr22 = new int[i3];
            z = z6;
            i4 = 0;
            int i132 = 0;
            while (i4 < hlsMultivariantPlaylist.variants.size()) {
            }
            ArrayList arrayList72 = arrayList6;
            String str22 = formatArr4[0].codecs;
            codecCountOfType = Util.getCodecCountOfType(str22, 2);
            codecCountOfType2 = Util.getCodecCountOfType(str22, 1);
            if (codecCountOfType2 != 1) {
            }
            z5 = true;
            if (z3) {
            }
            i5 = 0;
            list2 = list5;
            arrayList = arrayList72;
            list = list6;
            map = map2;
            arrayList2 = arrayList5;
            m2792a = m2792a("main", i5, uriArr2, formatArr4, hlsMultivariantPlaylist.muxedAudioFormat, hlsMultivariantPlaylist.muxedCaptionFormats, map2, j);
            arrayList2.add(m2792a);
            arrayList.add(iArr22);
            if (z) {
                ArrayList arrayList82 = new ArrayList();
                if (codecCountOfType <= 0) {
                }
                TrackGroup trackGroup2 = new TrackGroup("main:id3", new Format.Builder().setId("ID3").setSampleMimeType(MimeTypes.APPLICATION_ID3).build());
                arrayList82.add(trackGroup2);
                m2792a.m7802k((TrackGroup[]) arrayList82.toArray(new TrackGroup[0]), arrayList82.indexOf(trackGroup2));
            }
        } else {
            z = z6;
            list = list6;
            map = map2;
            list2 = list5;
            arrayList = arrayList6;
            arrayList2 = arrayList5;
        }
        ArrayList arrayList9 = new ArrayList(list2.size());
        ArrayList arrayList10 = new ArrayList(list2.size());
        ArrayList arrayList11 = new ArrayList(list2.size());
        HashSet hashSet = new HashSet();
        int i17 = 0;
        while (i17 < list2.size()) {
            List<HlsMultivariantPlaylist.Rendition> list8 = list2;
            String str3 = list8.get(i17).name;
            if (!hashSet.add(str3)) {
                i = i17;
                list3 = list8;
            } else {
                arrayList9.clear();
                arrayList10.clear();
                arrayList11.clear();
                int i18 = 0;
                boolean z7 = true;
                while (i18 < list8.size()) {
                    if (Util.areEqual(str3, list8.get(i18).name)) {
                        HlsMultivariantPlaylist.Rendition rendition = list8.get(i18);
                        arrayList11.add(Integer.valueOf(i18));
                        arrayList9.add(rendition.url);
                        arrayList10.add(rendition.format);
                        i2 = 1;
                        if (Util.getCodecCountOfType(rendition.format.codecs, 1) == 1) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        z7 &= z2;
                    } else {
                        i2 = 1;
                    }
                    i18 += i2;
                }
                String m7038C = AbstractC1726qj.m7038C("audio:", str3);
                i = i17;
                list3 = list8;
                v01 m2792a2 = m2792a(m7038C, 1, (Uri[]) arrayList9.toArray((Uri[]) Util.castNonNullTypeArray(new Uri[0])), (Format[]) arrayList10.toArray(new Format[0]), null, Collections.emptyList(), map, j);
                arrayList.add(Ints.toArray(arrayList11));
                arrayList2.add(m2792a2);
                if (z && z7) {
                    m2792a2.m7802k(new TrackGroup[]{new TrackGroup(m7038C, (Format[]) arrayList10.toArray(new Format[0]))}, new int[0]);
                    i17 = i + 1;
                    list2 = list3;
                }
            }
            i17 = i + 1;
            list2 = list3;
        }
        this.f11405w = arrayList2.size();
        for (int i19 = 0; i19 < list.size(); i19++) {
            HlsMultivariantPlaylist.Rendition rendition2 = list.get(i19);
            StringBuilder m8299s = ye0.m8299s(i19, "subtitle:", ":");
            m8299s.append(rendition2.name);
            String sb = m8299s.toString();
            v01 m2792a3 = m2792a(sb, 3, new Uri[]{rendition2.url}, new Format[]{rendition2.format}, null, Collections.emptyList(), map, j);
            arrayList.add(new int[]{i19});
            arrayList2.add(m2792a3);
            m2792a3.m7802k(new TrackGroup[]{new TrackGroup(sb, rendition2.format)}, new int[0]);
        }
        this.f11402t = (v01[]) arrayList2.toArray(new v01[0]);
        this.f11404v = (int[][]) arrayList.toArray(new int[0]);
        this.f11400r = this.f11402t.length;
        for (int i20 = 0; i20 < this.f11405w; i20++) {
            this.f11402t[i20].f27590d.f24983l = true;
        }
        for (v01 v01Var : this.f11402t) {
            if (!v01Var.f27566D) {
                v01Var.continueLoading(v01Var.f27578P);
            }
        }
        this.f11403u = this.f11402t;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public long readDiscontinuity() {
        return C0643C.TIME_UNSET;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
    public void reevaluateBuffer(long j) {
        this.f11406x.reevaluateBuffer(j);
    }

    public void release() {
        this.f11384b.removeListener(this);
        for (v01 v01Var : this.f11402t) {
            if (v01Var.f27566D) {
                for (u01 u01Var : v01Var.f27608v) {
                    u01Var.preRelease();
                }
            }
            v01Var.f27596j.release(v01Var);
            v01Var.f27604r.removeCallbacksAndMessages(null);
            v01Var.f27570H = true;
            v01Var.f27605s.clear();
        }
        this.f11399q = null;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public long seekToUs(long j) {
        v01[] v01VarArr = this.f11403u;
        if (v01VarArr.length > 0) {
            boolean m7804m = v01VarArr[0].m7804m(j, false);
            int i = 1;
            while (true) {
                v01[] v01VarArr2 = this.f11403u;
                if (i >= v01VarArr2.length) {
                    break;
                }
                v01VarArr2[i].m7804m(j, m7804m);
                i++;
            }
            if (m7804m) {
                this.f11393k.reset();
            }
        }
        return j;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:172:0x0263  */
    /* JADX WARN: Type inference failed for: r25v1 */
    /* JADX WARN: Type inference failed for: r2v22 */
    /* JADX WARN: Type inference failed for: r4v14 */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v32 */
    @Override // com.google.android.exoplayer2.source.MediaPeriod
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public long selectTracks(ExoTrackSelection[] exoTrackSelectionArr, boolean[] zArr, SampleStream[] sampleStreamArr, boolean[] zArr2, long j) {
        IdentityHashMap identityHashMap;
        int i;
        boolean z;
        boolean z2;
        r01[] r01VarArr;
        int i2;
        v01 v01Var;
        int i3;
        SampleStream[] sampleStreamArr2;
        int i4;
        int i5;
        IdentityHashMap identityHashMap2;
        v01[] v01VarArr;
        ExoTrackSelection[] exoTrackSelectionArr2;
        int[] iArr;
        int[] iArr2;
        p01 p01Var;
        boolean z3;
        boolean z4;
        v01[] v01VarArr2;
        boolean z5;
        IdentityHashMap identityHashMap3;
        boolean z6;
        ExoTrackSelection[] exoTrackSelectionArr3;
        boolean z7;
        IdentityHashMap identityHashMap4;
        v01[] v01VarArr3;
        SampleStream sampleStream;
        ExoTrackSelection exoTrackSelection;
        int intValue;
        HlsMediaPeriod hlsMediaPeriod = this;
        SampleStream[] sampleStreamArr3 = sampleStreamArr;
        int[] iArr3 = new int[exoTrackSelectionArr.length];
        int[] iArr4 = new int[exoTrackSelectionArr.length];
        int i6 = 0;
        while (true) {
            int length = exoTrackSelectionArr.length;
            identityHashMap = hlsMediaPeriod.f11392j;
            if (i6 >= length) {
                break;
            }
            SampleStream sampleStream2 = sampleStreamArr3[i6];
            if (sampleStream2 == null) {
                intValue = -1;
            } else {
                intValue = ((Integer) identityHashMap.get(sampleStream2)).intValue();
            }
            iArr3[i6] = intValue;
            iArr4[i6] = -1;
            ExoTrackSelection exoTrackSelection2 = exoTrackSelectionArr[i6];
            if (exoTrackSelection2 != null) {
                TrackGroup trackGroup = exoTrackSelection2.getTrackGroup();
                int i7 = 0;
                while (true) {
                    v01[] v01VarArr4 = hlsMediaPeriod.f11402t;
                    if (i7 < v01VarArr4.length) {
                        v01 v01Var2 = v01VarArr4[i7];
                        v01Var2.m7795a();
                        if (v01Var2.f27571I.indexOf(trackGroup) != -1) {
                            iArr4[i6] = i7;
                            break;
                        }
                        i7++;
                    }
                }
            }
            i6++;
        }
        identityHashMap.clear();
        int length2 = exoTrackSelectionArr.length;
        SampleStream[] sampleStreamArr4 = new SampleStream[length2];
        int length3 = exoTrackSelectionArr.length;
        int length4 = exoTrackSelectionArr.length;
        ExoTrackSelection[] exoTrackSelectionArr4 = new ExoTrackSelection[length4];
        v01[] v01VarArr5 = new v01[hlsMediaPeriod.f11402t.length];
        int i8 = length2;
        int i9 = 0;
        int i10 = 0;
        boolean z8 = false;
        ?? r4 = new SampleStream[length3];
        while (i9 < hlsMediaPeriod.f11402t.length) {
            SampleStream[] sampleStreamArr5 = sampleStreamArr4;
            int i11 = 0;
            while (true) {
                i = length3;
                if (i11 >= exoTrackSelectionArr.length) {
                    break;
                }
                if (iArr3[i11] == i9) {
                    sampleStream = sampleStreamArr3[i11];
                } else {
                    sampleStream = null;
                }
                r4[i11] = sampleStream;
                if (iArr4[i11] == i9) {
                    exoTrackSelection = exoTrackSelectionArr[i11];
                } else {
                    exoTrackSelection = null;
                }
                exoTrackSelectionArr4[i11] = exoTrackSelection;
                i11++;
                length3 = i;
            }
            v01 v01Var3 = hlsMediaPeriod.f11402t[i9];
            v01Var3.m7795a();
            int i12 = v01Var3.f27567E;
            int i13 = i9;
            int i14 = 0;
            while (i14 < length4) {
                r01 r01Var = (r01) r4[i14];
                if (r01Var != null && (exoTrackSelectionArr4[i14] == null || !zArr[i14])) {
                    identityHashMap4 = identityHashMap;
                    v01Var3.f27567E--;
                    v01VarArr3 = v01VarArr5;
                    if (r01Var.f25821c != -1) {
                        v01 v01Var4 = r01Var.f25820b;
                        v01Var4.m7795a();
                        Assertions.checkNotNull(v01Var4.f27573K);
                        int i15 = v01Var4.f27573K[r01Var.f25819a];
                        Assertions.checkState(v01Var4.f27576N[i15]);
                        v01Var4.f27576N[i15] = false;
                        r01Var.f25821c = -1;
                    }
                    r4[i14] = 0;
                } else {
                    identityHashMap4 = identityHashMap;
                    v01VarArr3 = v01VarArr5;
                }
                i14++;
                identityHashMap = identityHashMap4;
                v01VarArr5 = v01VarArr3;
            }
            IdentityHashMap identityHashMap5 = identityHashMap;
            v01[] v01VarArr6 = v01VarArr5;
            if (!z8 && (!v01Var3.f27581S ? j == v01Var3.f27578P : i12 != 0)) {
                z = false;
            } else {
                z = true;
            }
            p01 p01Var2 = v01Var3.f27590d;
            ExoTrackSelection exoTrackSelection3 = p01Var2.f24988q;
            boolean z9 = z;
            ExoTrackSelection exoTrackSelection4 = exoTrackSelection3;
            int i16 = 0;
            while (i16 < length4) {
                ExoTrackSelection exoTrackSelection5 = exoTrackSelectionArr4[i16];
                if (exoTrackSelection5 == null) {
                    exoTrackSelectionArr3 = exoTrackSelectionArr4;
                } else {
                    exoTrackSelectionArr3 = exoTrackSelectionArr4;
                    int indexOf = v01Var3.f27571I.indexOf(exoTrackSelection5.getTrackGroup());
                    if (indexOf == v01Var3.f27574L) {
                        p01Var2.f24988q = exoTrackSelection5;
                        exoTrackSelection4 = exoTrackSelection5;
                    }
                    if (r4[i16] == 0) {
                        v01Var3.f27567E++;
                        r01 r01Var2 = new r01(v01Var3, indexOf);
                        r4[i16] = r01Var2;
                        zArr2[i16] = true;
                        if (v01Var3.f27573K != null) {
                            r01Var2.m7158a();
                            if (!z9) {
                                u01 u01Var = v01Var3.f27608v[v01Var3.f27573K[indexOf]];
                                if (!u01Var.seekTo(j, true) && u01Var.getReadIndex() != 0) {
                                    z7 = true;
                                } else {
                                    z7 = false;
                                }
                                z9 = z7;
                            }
                        }
                    }
                }
                i16++;
                exoTrackSelectionArr4 = exoTrackSelectionArr3;
            }
            ExoTrackSelection[] exoTrackSelectionArr5 = exoTrackSelectionArr4;
            int i17 = v01Var3.f27567E;
            ArrayList arrayList = v01Var3.f27600n;
            if (i17 == 0) {
                p01Var2.f24985n = null;
                v01Var3.f27569G = null;
                v01Var3.f27580R = true;
                arrayList.clear();
                Loader loader = v01Var3.f27596j;
                if (loader.isLoading()) {
                    if (v01Var3.f27565C) {
                        for (u01 u01Var2 : v01Var3.f27608v) {
                            u01Var2.discardToEnd();
                        }
                    }
                    loader.cancelLoading();
                } else {
                    v01Var3.m7803l();
                }
                r01VarArr = r4;
                i2 = length4;
                v01Var = v01Var3;
                i3 = i8;
                sampleStreamArr2 = sampleStreamArr5;
                i4 = i;
                i5 = i13;
                identityHashMap2 = identityHashMap5;
                v01VarArr = v01VarArr6;
                exoTrackSelectionArr2 = exoTrackSelectionArr5;
                iArr = iArr3;
                iArr2 = iArr4;
                p01Var = p01Var2;
            } else {
                if (!arrayList.isEmpty() && !Util.areEqual(exoTrackSelection4, exoTrackSelection3)) {
                    if (!v01Var3.f27581S) {
                        long j2 = 0;
                        if (j < 0) {
                            j2 = -j;
                        }
                        q01 m7798f = v01Var3.m7798f();
                        exoTrackSelectionArr2 = exoTrackSelectionArr5;
                        r01VarArr = r4;
                        i2 = length4;
                        i4 = i;
                        sampleStreamArr2 = sampleStreamArr5;
                        v01Var = v01Var3;
                        iArr = iArr3;
                        i3 = i8;
                        i5 = i13;
                        p01Var = p01Var2;
                        identityHashMap2 = identityHashMap5;
                        iArr2 = iArr4;
                        v01VarArr = v01VarArr6;
                        exoTrackSelection4.updateSelectedTrack(j, j2, C0643C.TIME_UNSET, v01Var3.f27601o, p01Var2.m6763a(m7798f, j));
                        if (exoTrackSelection4.getSelectedIndexInTrackGroup() == p01Var.f24979h.indexOf(m7798f.trackFormat)) {
                            z2 = true;
                        }
                    } else {
                        r01VarArr = r4;
                        i2 = length4;
                        v01Var = v01Var3;
                        i3 = i8;
                        sampleStreamArr2 = sampleStreamArr5;
                        i4 = i;
                        i5 = i13;
                        identityHashMap2 = identityHashMap5;
                        v01VarArr = v01VarArr6;
                        exoTrackSelectionArr2 = exoTrackSelectionArr5;
                        iArr = iArr3;
                        iArr2 = iArr4;
                        p01Var = p01Var2;
                    }
                    z2 = true;
                    v01Var.f27580R = true;
                    z4 = true;
                    z3 = true;
                    if (z3) {
                        v01Var.m7804m(j, z4);
                        int i18 = 0;
                        while (i18 < i4) {
                            if (r01VarArr[i18] != null) {
                                zArr2[i18] = z2;
                            }
                            i18++;
                            z2 = true;
                        }
                    }
                    z9 = z3;
                } else {
                    z2 = true;
                    r01VarArr = r4;
                    i2 = length4;
                    v01Var = v01Var3;
                    i3 = i8;
                    sampleStreamArr2 = sampleStreamArr5;
                    i4 = i;
                    i5 = i13;
                    identityHashMap2 = identityHashMap5;
                    v01VarArr = v01VarArr6;
                    exoTrackSelectionArr2 = exoTrackSelectionArr5;
                    iArr = iArr3;
                    iArr2 = iArr4;
                    p01Var = p01Var2;
                }
                z3 = z9;
                z4 = z8;
                if (z3) {
                }
                z9 = z3;
            }
            ArrayList arrayList2 = v01Var.f27605s;
            arrayList2.clear();
            for (int i19 = 0; i19 < i4; i19++) {
                r01 r01Var3 = r01VarArr[i19];
                if (r01Var3 != null) {
                    arrayList2.add(r01Var3);
                }
            }
            v01Var.f27581S = true;
            boolean z10 = false;
            int i20 = 0;
            while (i20 < exoTrackSelectionArr.length) {
                r01 r01Var4 = r01VarArr[i20];
                int i21 = i5;
                if (iArr2[i20] == i21) {
                    Assertions.checkNotNull(r01Var4);
                    sampleStreamArr2[i20] = r01Var4;
                    identityHashMap3 = identityHashMap2;
                    identityHashMap3.put(r01Var4, Integer.valueOf(i21));
                    z10 = true;
                } else {
                    identityHashMap3 = identityHashMap2;
                    if (iArr[i20] == i21) {
                        if (r01Var4 == null) {
                            z6 = true;
                        } else {
                            z6 = false;
                        }
                        Assertions.checkState(z6);
                    }
                }
                i20++;
                identityHashMap2 = identityHashMap3;
                i5 = i21;
            }
            int i22 = i5;
            IdentityHashMap identityHashMap6 = identityHashMap2;
            if (z10) {
                int i23 = i10;
                v01VarArr2 = v01VarArr;
                v01VarArr2[i23] = v01Var;
                i10 = i23 + 1;
                if (i23 == 0) {
                    p01Var.f24983l = true;
                    if (!z9) {
                        length3 = i4;
                        hlsMediaPeriod = this;
                        v01[] v01VarArr7 = hlsMediaPeriod.f11403u;
                        if (v01VarArr7.length != 0 && v01Var == v01VarArr7[0]) {
                        }
                    } else {
                        length3 = i4;
                        hlsMediaPeriod = this;
                    }
                    hlsMediaPeriod.f11393k.reset();
                    z8 = true;
                } else {
                    length3 = i4;
                    hlsMediaPeriod = this;
                    if (i22 < hlsMediaPeriod.f11405w) {
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                    p01Var.f24983l = z5;
                }
            } else {
                length3 = i4;
                v01VarArr2 = v01VarArr;
                hlsMediaPeriod = this;
            }
            i9 = i22 + 1;
            v01VarArr5 = v01VarArr2;
            identityHashMap = identityHashMap6;
            sampleStreamArr4 = sampleStreamArr2;
            iArr3 = iArr;
            iArr4 = iArr2;
            exoTrackSelectionArr4 = exoTrackSelectionArr2;
            r4 = r01VarArr;
            length4 = i2;
            i8 = i3;
            sampleStreamArr3 = sampleStreamArr;
        }
        System.arraycopy(sampleStreamArr4, 0, sampleStreamArr3, 0, i8);
        v01[] v01VarArr8 = (v01[]) Util.nullSafeArrayCopy(v01VarArr5, i10);
        hlsMediaPeriod.f11403u = v01VarArr8;
        hlsMediaPeriod.f11406x = hlsMediaPeriod.f11394l.createCompositeSequenceableLoader(v01VarArr8);
        return j;
    }

    @Override // com.google.android.exoplayer2.source.SequenceableLoader.Callback
    public void onContinueLoadingRequested(v01 v01Var) {
        this.f11399q.onContinueLoadingRequested(this);
    }
}
