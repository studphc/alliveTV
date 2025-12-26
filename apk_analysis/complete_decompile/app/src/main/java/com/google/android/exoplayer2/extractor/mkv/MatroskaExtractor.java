package com.google.android.exoplayer2.extractor.mkv;

import android.util.Pair;
import android.util.SparseArray;
import androidx.annotation.CallSuper;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.exoplayer2.C0643C;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.audio.AacUtil;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.extractor.ChunkIndex;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.extractor.PositionHolder;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.extractor.TrueHdSampleRechunker;
import com.google.android.exoplayer2.extractor.p002ts.TsExtractor;
import com.google.android.exoplayer2.upstream.DataReader;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.LongArray;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.NalUnitUtil;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.video.AvcConfig;
import com.google.android.exoplayer2.video.ColorInfo;
import com.google.android.exoplayer2.video.DolbyVisionConfig;
import com.google.android.exoplayer2.video.HevcConfig;
import com.google.common.collect.ImmutableList;
import com.google.firebase.FirebaseError;
import com.hisona.allive.CardPresenter;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;
import p000.C1582ne;
import p000.b01;
import p000.d13;
import p000.ee0;
import p000.p00;
import p000.q00;
import p000.ye0;

/* loaded from: classes.dex */
public class MatroskaExtractor implements Extractor {
    public static final int FLAG_DISABLE_SEEK_FOR_CUES = 1;

    /* renamed from: h0 */
    public static final Map f10191h0;

    /* renamed from: A */
    public long f10192A;

    /* renamed from: B */
    public long f10193B;

    /* renamed from: C */
    public LongArray f10194C;

    /* renamed from: D */
    public LongArray f10195D;

    /* renamed from: E */
    public boolean f10196E;

    /* renamed from: F */
    public boolean f10197F;

    /* renamed from: G */
    public int f10198G;

    /* renamed from: H */
    public long f10199H;

    /* renamed from: I */
    public long f10200I;

    /* renamed from: J */
    public int f10201J;

    /* renamed from: K */
    public int f10202K;

    /* renamed from: L */
    public int[] f10203L;

    /* renamed from: M */
    public int f10204M;

    /* renamed from: N */
    public int f10205N;

    /* renamed from: O */
    public int f10206O;

    /* renamed from: P */
    public int f10207P;

    /* renamed from: Q */
    public boolean f10208Q;

    /* renamed from: R */
    public long f10209R;

    /* renamed from: S */
    public int f10210S;

    /* renamed from: T */
    public int f10211T;

    /* renamed from: U */
    public int f10212U;

    /* renamed from: V */
    public boolean f10213V;

    /* renamed from: W */
    public boolean f10214W;

    /* renamed from: X */
    public boolean f10215X;

    /* renamed from: Y */
    public int f10216Y;

    /* renamed from: Z */
    public byte f10217Z;

    /* renamed from: a */
    public final q00 f10218a;

    /* renamed from: a0 */
    public boolean f10219a0;

    /* renamed from: b */
    public final d13 f10220b;

    /* renamed from: b0 */
    public ExtractorOutput f10221b0;

    /* renamed from: c */
    public final SparseArray f10222c;

    /* renamed from: d */
    public final boolean f10223d;

    /* renamed from: e */
    public final ParsableByteArray f10224e;

    /* renamed from: f */
    public final ParsableByteArray f10225f;

    /* renamed from: g */
    public final ParsableByteArray f10226g;

    /* renamed from: h */
    public final ParsableByteArray f10227h;

    /* renamed from: i */
    public final ParsableByteArray f10228i;

    /* renamed from: j */
    public final ParsableByteArray f10229j;

    /* renamed from: k */
    public final ParsableByteArray f10230k;

    /* renamed from: l */
    public final ParsableByteArray f10231l;

    /* renamed from: m */
    public final ParsableByteArray f10232m;

    /* renamed from: n */
    public final ParsableByteArray f10233n;

    /* renamed from: o */
    public ByteBuffer f10234o;

    /* renamed from: p */
    public long f10235p;

    /* renamed from: q */
    public long f10236q;

    /* renamed from: r */
    public long f10237r;

    /* renamed from: s */
    public long f10238s;

    /* renamed from: t */
    public long f10239t;

    /* renamed from: u */
    public Track f10240u;

    /* renamed from: v */
    public boolean f10241v;

    /* renamed from: w */
    public int f10242w;

    /* renamed from: x */
    public long f10243x;

    /* renamed from: y */
    public boolean f10244y;

    /* renamed from: z */
    public long f10245z;
    public static final ExtractorsFactory FACTORY = new ee0(8);

    /* renamed from: c0 */
    public static final byte[] f10186c0 = {49, 10, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 48, 48, 32, 45, 45, 62, 32, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 48, 48, 10};

    /* renamed from: d0 */
    public static final byte[] f10187d0 = Util.getUtf8Bytes("Format: Start, End, ReadOrder, Layer, Style, Name, MarginL, MarginR, MarginV, Effect, Text");

    /* renamed from: e0 */
    public static final byte[] f10188e0 = {68, 105, 97, 108, 111, 103, 117, 101, 58, 32, 48, 58, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 58, 48, 48, 58, 48, 48, 58, 48, 48, 44};

    /* renamed from: f0 */
    public static final byte[] f10189f0 = {87, 69, 66, 86, 84, 84, 10, 10, 48, 48, 58, 48, 48, 58, 48, 48, 46, 48, 48, 48, 32, 45, 45, 62, 32, 48, 48, 58, 48, 48, 58, 48, 48, 46, 48, 48, 48, 10};

    /* renamed from: g0 */
    public static final UUID f10190g0 = new UUID(72057594037932032L, -9223371306706625679L);

    @Target({ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface Flags {
    }

    /* loaded from: classes.dex */
    public static final class Track {

        /* renamed from: a */
        public int f10246a;
        public String codecId;
        public byte[] codecPrivate;
        public TrackOutput.CryptoData cryptoData;
        public int defaultSampleDurationNs;
        public byte[] dolbyVisionConfigBytes;
        public DrmInitData drmInitData;
        public boolean flagForced;
        public boolean hasContentEncryption;
        public int maxBlockAdditionId;
        public int nalUnitLengthFieldLength;
        public String name;
        public int number;
        public TrackOutput output;
        public byte[] sampleStrippedBytes;
        public TrueHdSampleRechunker trueHdSampleRechunker;
        public int type;
        public int width = -1;
        public int height = -1;
        public int displayWidth = -1;
        public int displayHeight = -1;
        public int displayUnit = 0;
        public int projectionType = -1;
        public float projectionPoseYaw = RecyclerView.f7068F0;
        public float projectionPosePitch = RecyclerView.f7068F0;
        public float projectionPoseRoll = RecyclerView.f7068F0;
        public byte[] projectionData = null;
        public int stereoMode = -1;
        public boolean hasColorInfo = false;
        public int colorSpace = -1;
        public int colorTransfer = -1;
        public int colorRange = -1;
        public int maxContentLuminance = 1000;
        public int maxFrameAverageLuminance = 200;
        public float primaryRChromaticityX = -1.0f;
        public float primaryRChromaticityY = -1.0f;
        public float primaryGChromaticityX = -1.0f;
        public float primaryGChromaticityY = -1.0f;
        public float primaryBChromaticityX = -1.0f;
        public float primaryBChromaticityY = -1.0f;
        public float whitePointChromaticityX = -1.0f;
        public float whitePointChromaticityY = -1.0f;
        public float maxMasteringLuminance = -1.0f;
        public float minMasteringLuminance = -1.0f;
        public int channelCount = 1;
        public int audioBitDepth = -1;
        public int sampleRate = 8000;
        public long codecDelayNs = 0;
        public long seekPreRollNs = 0;
        public boolean flagDefault = true;

        /* renamed from: b */
        public String f10247b = "eng";

        /* renamed from: a */
        public final byte[] m2551a(String str) {
            byte[] bArr = this.codecPrivate;
            if (bArr != null) {
                return bArr;
            }
            throw ParserException.createForMalformedContainer("Missing CodecPrivate for codec " + str, null);
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Code restructure failed: missing block: B:253:0x04ca, code lost:
        
            if (r3.readLong() == r5.getLeastSignificantBits()) goto L261;
         */
        /* JADX WARN: Failed to find 'out' block for switch in B:4:0x01df. Please report as an issue. */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:115:0x0530  */
        /* JADX WARN: Removed duplicated region for block: B:13:0x0519  */
        /* JADX WARN: Removed duplicated region for block: B:18:0x052e  */
        /* JADX WARN: Removed duplicated region for block: B:21:0x053d  */
        /* JADX WARN: Removed duplicated region for block: B:24:0x070f  */
        /* JADX WARN: Removed duplicated region for block: B:29:0x054e  */
        /* JADX WARN: Type inference failed for: r1v0, types: [java.lang.String] */
        /* JADX WARN: Type inference failed for: r1v3 */
        /* JADX WARN: Type inference failed for: r1v4, types: [java.lang.Throwable] */
        /* JADX WARN: Type inference failed for: r1v7 */
        @EnsuresNonNull({"this.output"})
        @RequiresNonNull({"codecId"})
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void initializeOutput(ExtractorOutput extractorOutput, int i) {
            char c;
            int i2;
            int i3;
            List<byte[]> list;
            List<byte[]> list2;
            int i4;
            String str;
            int i5;
            List<byte[]> list3;
            ArrayList arrayList;
            List<byte[]> list4;
            Pair pair;
            int i6;
            List<byte[]> list5;
            String str2;
            List<byte[]> list6;
            List<byte[]> list7;
            int i7;
            List<byte[]> list8;
            byte[] bArr;
            int i8;
            Format.Builder builder;
            int i9;
            float f;
            int i10;
            ColorInfo colorInfo;
            byte[] bArr2;
            int i11;
            String str3;
            DolbyVisionConfig parse;
            String str4 = this.codecId;
            str4.getClass();
            String str5 = MimeTypes.VIDEO_UNKNOWN;
            ?? r1 = MimeTypes.APPLICATION_SUBRIP;
            switch (str4.hashCode()) {
                case -2095576542:
                    if (str4.equals("V_MPEG4/ISO/AP")) {
                        c = 0;
                        break;
                    }
                    c = 65535;
                    break;
                case -2095575984:
                    if (str4.equals("V_MPEG4/ISO/SP")) {
                        c = 1;
                        break;
                    }
                    c = 65535;
                    break;
                case -1985379776:
                    if (str4.equals("A_MS/ACM")) {
                        c = 2;
                        break;
                    }
                    c = 65535;
                    break;
                case -1784763192:
                    if (str4.equals("A_TRUEHD")) {
                        c = 3;
                        break;
                    }
                    c = 65535;
                    break;
                case -1730367663:
                    if (str4.equals("A_VORBIS")) {
                        c = 4;
                        break;
                    }
                    c = 65535;
                    break;
                case -1482641358:
                    if (str4.equals("A_MPEG/L2")) {
                        c = 5;
                        break;
                    }
                    c = 65535;
                    break;
                case -1482641357:
                    if (str4.equals("A_MPEG/L3")) {
                        c = 6;
                        break;
                    }
                    c = 65535;
                    break;
                case -1373388978:
                    if (str4.equals("V_MS/VFW/FOURCC")) {
                        c = 7;
                        break;
                    }
                    c = 65535;
                    break;
                case -933872740:
                    if (str4.equals("S_DVBSUB")) {
                        c = '\b';
                        break;
                    }
                    c = 65535;
                    break;
                case -538363189:
                    if (str4.equals("V_MPEG4/ISO/ASP")) {
                        c = '\t';
                        break;
                    }
                    c = 65535;
                    break;
                case -538363109:
                    if (str4.equals("V_MPEG4/ISO/AVC")) {
                        c = '\n';
                        break;
                    }
                    c = 65535;
                    break;
                case -425012669:
                    if (str4.equals("S_VOBSUB")) {
                        c = 11;
                        break;
                    }
                    c = 65535;
                    break;
                case -356037306:
                    if (str4.equals("A_DTS/LOSSLESS")) {
                        c = '\f';
                        break;
                    }
                    c = 65535;
                    break;
                case 62923557:
                    if (str4.equals("A_AAC")) {
                        c = '\r';
                        break;
                    }
                    c = 65535;
                    break;
                case 62923603:
                    if (str4.equals("A_AC3")) {
                        c = 14;
                        break;
                    }
                    c = 65535;
                    break;
                case 62927045:
                    if (str4.equals("A_DTS")) {
                        c = 15;
                        break;
                    }
                    c = 65535;
                    break;
                case 82318131:
                    if (str4.equals("V_AV1")) {
                        c = 16;
                        break;
                    }
                    c = 65535;
                    break;
                case 82338133:
                    if (str4.equals("V_VP8")) {
                        c = 17;
                        break;
                    }
                    c = 65535;
                    break;
                case 82338134:
                    if (str4.equals("V_VP9")) {
                        c = 18;
                        break;
                    }
                    c = 65535;
                    break;
                case 99146302:
                    if (str4.equals("S_HDMV/PGS")) {
                        c = 19;
                        break;
                    }
                    c = 65535;
                    break;
                case 444813526:
                    if (str4.equals("V_THEORA")) {
                        c = 20;
                        break;
                    }
                    c = 65535;
                    break;
                case 542569478:
                    if (str4.equals("A_DTS/EXPRESS")) {
                        c = 21;
                        break;
                    }
                    c = 65535;
                    break;
                case 635596514:
                    if (str4.equals("A_PCM/FLOAT/IEEE")) {
                        c = 22;
                        break;
                    }
                    c = 65535;
                    break;
                case 725948237:
                    if (str4.equals("A_PCM/INT/BIG")) {
                        c = 23;
                        break;
                    }
                    c = 65535;
                    break;
                case 725957860:
                    if (str4.equals("A_PCM/INT/LIT")) {
                        c = 24;
                        break;
                    }
                    c = 65535;
                    break;
                case 738597099:
                    if (str4.equals("S_TEXT/ASS")) {
                        c = 25;
                        break;
                    }
                    c = 65535;
                    break;
                case 855502857:
                    if (str4.equals("V_MPEGH/ISO/HEVC")) {
                        c = 26;
                        break;
                    }
                    c = 65535;
                    break;
                case 1045209816:
                    if (str4.equals("S_TEXT/WEBVTT")) {
                        c = 27;
                        break;
                    }
                    c = 65535;
                    break;
                case 1422270023:
                    if (str4.equals("S_TEXT/UTF8")) {
                        c = 28;
                        break;
                    }
                    c = 65535;
                    break;
                case 1809237540:
                    if (str4.equals("V_MPEG2")) {
                        c = 29;
                        break;
                    }
                    c = 65535;
                    break;
                case 1950749482:
                    if (str4.equals("A_EAC3")) {
                        c = 30;
                        break;
                    }
                    c = 65535;
                    break;
                case 1950789798:
                    if (str4.equals("A_FLAC")) {
                        c = 31;
                        break;
                    }
                    c = 65535;
                    break;
                case 1951062397:
                    if (str4.equals("A_OPUS")) {
                        c = ' ';
                        break;
                    }
                    c = 65535;
                    break;
                default:
                    c = 65535;
                    break;
            }
            switch (c) {
                case 0:
                case 1:
                case '\t':
                    i2 = 1;
                    i3 = 2;
                    byte[] bArr3 = this.codecPrivate;
                    if (bArr3 == null) {
                        list = null;
                    } else {
                        list = Collections.singletonList(bArr3);
                    }
                    str5 = MimeTypes.VIDEO_MP4V;
                    list2 = list;
                    i4 = -1;
                    str = null;
                    i5 = -1;
                    list3 = list2;
                    bArr = this.dolbyVisionConfigBytes;
                    if (bArr != null && (parse = DolbyVisionConfig.parse(new ParsableByteArray(bArr))) != null) {
                        str = parse.codecs;
                        str5 = MimeTypes.VIDEO_DOLBY_VISION;
                    }
                    boolean z = this.flagDefault;
                    if (!this.flagForced) {
                        i8 = i3;
                    } else {
                        i8 = 0;
                    }
                    int i12 = (z ? 1 : 0) | i8;
                    builder = new Format.Builder();
                    if (!MimeTypes.isAudio(str5)) {
                        builder.setChannelCount(this.channelCount).setSampleRate(this.sampleRate).setPcmEncoding(i5);
                    } else if (MimeTypes.isVideo(str5)) {
                        if (this.displayUnit == 0) {
                            int i13 = this.displayWidth;
                            i9 = -1;
                            if (i13 == -1) {
                                i13 = this.width;
                            }
                            this.displayWidth = i13;
                            int i14 = this.displayHeight;
                            if (i14 == -1) {
                                i14 = this.height;
                            }
                            this.displayHeight = i14;
                        } else {
                            i9 = -1;
                        }
                        if (this.displayWidth != i9 && (i11 = this.displayHeight) != i9) {
                            f = (this.height * r1) / (this.width * i11);
                        } else {
                            f = -1.0f;
                        }
                        if (this.hasColorInfo) {
                            if (this.primaryRChromaticityX == -1.0f || this.primaryRChromaticityY == -1.0f || this.primaryGChromaticityX == -1.0f || this.primaryGChromaticityY == -1.0f || this.primaryBChromaticityX == -1.0f || this.primaryBChromaticityY == -1.0f || this.whitePointChromaticityX == -1.0f || this.whitePointChromaticityY == -1.0f || this.maxMasteringLuminance == -1.0f || this.minMasteringLuminance == -1.0f) {
                                i10 = 0;
                                bArr2 = null;
                            } else {
                                bArr2 = new byte[25];
                                ByteBuffer order = ByteBuffer.wrap(bArr2).order(ByteOrder.LITTLE_ENDIAN);
                                i10 = 0;
                                order.put((byte) 0);
                                order.putShort((short) ((this.primaryRChromaticityX * 50000.0f) + 0.5f));
                                order.putShort((short) ((this.primaryRChromaticityY * 50000.0f) + 0.5f));
                                order.putShort((short) ((this.primaryGChromaticityX * 50000.0f) + 0.5f));
                                order.putShort((short) ((this.primaryGChromaticityY * 50000.0f) + 0.5f));
                                order.putShort((short) ((this.primaryBChromaticityX * 50000.0f) + 0.5f));
                                order.putShort((short) ((this.primaryBChromaticityY * 50000.0f) + 0.5f));
                                order.putShort((short) ((this.whitePointChromaticityX * 50000.0f) + 0.5f));
                                order.putShort((short) ((this.whitePointChromaticityY * 50000.0f) + 0.5f));
                                order.putShort((short) (this.maxMasteringLuminance + 0.5f));
                                order.putShort((short) (this.minMasteringLuminance + 0.5f));
                                order.putShort((short) this.maxContentLuminance);
                                order.putShort((short) this.maxFrameAverageLuminance);
                            }
                            colorInfo = new ColorInfo(this.colorSpace, this.colorRange, this.colorTransfer, bArr2);
                        } else {
                            i10 = 0;
                            colorInfo = null;
                        }
                        String str6 = this.name;
                        if (str6 != null) {
                            Map map = MatroskaExtractor.f10191h0;
                            if (map.containsKey(str6)) {
                                i9 = ((Integer) map.get(this.name)).intValue();
                            }
                        }
                        if (this.projectionType == 0 && Float.compare(this.projectionPoseYaw, RecyclerView.f7068F0) == 0 && Float.compare(this.projectionPosePitch, RecyclerView.f7068F0) == 0) {
                            if (Float.compare(this.projectionPoseRoll, RecyclerView.f7068F0) == 0) {
                                i9 = i10;
                            } else if (Float.compare(this.projectionPosePitch, 90.0f) == 0) {
                                i9 = 90;
                            } else if (Float.compare(this.projectionPosePitch, -180.0f) != 0 && Float.compare(this.projectionPosePitch, 180.0f) != 0) {
                                if (Float.compare(this.projectionPosePitch, -90.0f) == 0) {
                                    i9 = 270;
                                }
                            } else {
                                i9 = 180;
                            }
                        }
                        builder.setWidth(this.width).setHeight(this.height).setPixelWidthHeightRatio(f).setRotationDegrees(i9).setProjectionData(this.projectionData).setStereoMode(this.stereoMode).setColorInfo(colorInfo);
                        i2 = i3;
                    } else {
                        if (!MimeTypes.APPLICATION_SUBRIP.equals(str5) && !MimeTypes.TEXT_SSA.equals(str5) && !MimeTypes.TEXT_VTT.equals(str5) && !MimeTypes.APPLICATION_VOBSUB.equals(str5) && !MimeTypes.APPLICATION_PGS.equals(str5) && !MimeTypes.APPLICATION_DVBSUBS.equals(str5)) {
                            throw ParserException.createForMalformedContainer("Unexpected MIME type.", null);
                        }
                        i2 = 3;
                    }
                    str3 = this.name;
                    if (str3 != null && !MatroskaExtractor.f10191h0.containsKey(str3)) {
                        builder.setLabel(this.name);
                    }
                    Format build = builder.setId(i).setSampleMimeType(str5).setMaxInputSize(i4).setLanguage(this.f10247b).setSelectionFlags(i12).setInitializationData(list3).setCodecs(str).setDrmInitData(this.drmInitData).build();
                    TrackOutput track = extractorOutput.track(this.number, i2);
                    this.output = track;
                    track.format(build);
                    return;
                case 2:
                    i3 = 2;
                    ParsableByteArray parsableByteArray = new ParsableByteArray(m2551a(this.codecId));
                    try {
                        int readLittleEndianUnsignedShort = parsableByteArray.readLittleEndianUnsignedShort();
                        i2 = 1;
                        if (readLittleEndianUnsignedShort != 1) {
                            if (readLittleEndianUnsignedShort == 65534) {
                                parsableByteArray.setPosition(24);
                                long readLong = parsableByteArray.readLong();
                                UUID uuid = MatroskaExtractor.f10190g0;
                                if (readLong == uuid.getMostSignificantBits()) {
                                    break;
                                }
                            }
                            Log.m3027w("MatroskaExtractor", "Non-PCM MS/ACM is unsupported. Setting mimeType to audio/x-unknown");
                            str5 = MimeTypes.AUDIO_UNKNOWN;
                            list2 = null;
                            i4 = -1;
                            str = null;
                            i5 = -1;
                            list3 = list2;
                            bArr = this.dolbyVisionConfigBytes;
                            if (bArr != null) {
                                str = parse.codecs;
                                str5 = MimeTypes.VIDEO_DOLBY_VISION;
                                break;
                            }
                            boolean z2 = this.flagDefault;
                            if (!this.flagForced) {
                            }
                            int i122 = (z2 ? 1 : 0) | i8;
                            builder = new Format.Builder();
                            if (!MimeTypes.isAudio(str5)) {
                            }
                            str3 = this.name;
                            if (str3 != null) {
                                builder.setLabel(this.name);
                                break;
                            }
                            Format build2 = builder.setId(i).setSampleMimeType(str5).setMaxInputSize(i4).setLanguage(this.f10247b).setSelectionFlags(i122).setInitializationData(list3).setCodecs(str).setDrmInitData(this.drmInitData).build();
                            TrackOutput track2 = extractorOutput.track(this.number, i2);
                            this.output = track2;
                            track2.format(build2);
                            return;
                        }
                        int pcmEncoding = Util.getPcmEncoding(this.audioBitDepth);
                        if (pcmEncoding == 0) {
                            Log.m3027w("MatroskaExtractor", "Unsupported PCM bit depth: " + this.audioBitDepth + ". Setting mimeType to audio/x-unknown");
                            str5 = MimeTypes.AUDIO_UNKNOWN;
                            list2 = null;
                            i4 = -1;
                            str = null;
                            i5 = -1;
                            list3 = list2;
                            bArr = this.dolbyVisionConfigBytes;
                            if (bArr != null) {
                            }
                            boolean z22 = this.flagDefault;
                            if (!this.flagForced) {
                            }
                            int i1222 = (z22 ? 1 : 0) | i8;
                            builder = new Format.Builder();
                            if (!MimeTypes.isAudio(str5)) {
                            }
                            str3 = this.name;
                            if (str3 != null) {
                            }
                            Format build22 = builder.setId(i).setSampleMimeType(str5).setMaxInputSize(i4).setLanguage(this.f10247b).setSelectionFlags(i1222).setInitializationData(list3).setCodecs(str).setDrmInitData(this.drmInitData).build();
                            TrackOutput track22 = extractorOutput.track(this.number, i2);
                            this.output = track22;
                            track22.format(build22);
                            return;
                        }
                        i5 = pcmEncoding;
                        str5 = MimeTypes.AUDIO_RAW;
                        list3 = null;
                        i4 = -1;
                        str = null;
                        bArr = this.dolbyVisionConfigBytes;
                        if (bArr != null) {
                        }
                        boolean z222 = this.flagDefault;
                        if (!this.flagForced) {
                        }
                        int i12222 = (z222 ? 1 : 0) | i8;
                        builder = new Format.Builder();
                        if (!MimeTypes.isAudio(str5)) {
                        }
                        str3 = this.name;
                        if (str3 != null) {
                        }
                        Format build222 = builder.setId(i).setSampleMimeType(str5).setMaxInputSize(i4).setLanguage(this.f10247b).setSelectionFlags(i12222).setInitializationData(list3).setCodecs(str).setDrmInitData(this.drmInitData).build();
                        TrackOutput track222 = extractorOutput.track(this.number, i2);
                        this.output = track222;
                        track222.format(build222);
                        return;
                    } catch (ArrayIndexOutOfBoundsException unused) {
                        throw ParserException.createForMalformedContainer("Error parsing MS/ACM codec private", null);
                    }
                case 3:
                    i3 = 2;
                    this.trueHdSampleRechunker = new TrueHdSampleRechunker();
                    str5 = MimeTypes.AUDIO_TRUEHD;
                    arrayList = null;
                    i4 = -1;
                    str = null;
                    i5 = -1;
                    i2 = 1;
                    list3 = arrayList;
                    bArr = this.dolbyVisionConfigBytes;
                    if (bArr != null) {
                    }
                    boolean z2222 = this.flagDefault;
                    if (!this.flagForced) {
                    }
                    int i122222 = (z2222 ? 1 : 0) | i8;
                    builder = new Format.Builder();
                    if (!MimeTypes.isAudio(str5)) {
                    }
                    str3 = this.name;
                    if (str3 != null) {
                    }
                    Format build2222 = builder.setId(i).setSampleMimeType(str5).setMaxInputSize(i4).setLanguage(this.f10247b).setSelectionFlags(i122222).setInitializationData(list3).setCodecs(str).setDrmInitData(this.drmInitData).build();
                    TrackOutput track2222 = extractorOutput.track(this.number, i2);
                    this.output = track2222;
                    track2222.format(build2222);
                    return;
                case 4:
                    byte[] m2551a = m2551a(this.codecId);
                    try {
                        try {
                            if (m2551a[0] == 2) {
                                int i15 = 0;
                                int i16 = 1;
                                while (true) {
                                    int i17 = m2551a[i16] & 255;
                                    if (i17 == 255) {
                                        i15 += 255;
                                        i16++;
                                    } else {
                                        int i18 = i16 + 1;
                                        int i19 = i15 + i17;
                                        int i20 = 0;
                                        while (true) {
                                            try {
                                                int i21 = m2551a[i18] & 255;
                                                if (i21 == 255) {
                                                    i20 += 255;
                                                    i18++;
                                                } else {
                                                    int i22 = i18 + 1;
                                                    int i23 = i20 + i21;
                                                    if (m2551a[i22] == 1) {
                                                        byte[] bArr4 = new byte[i19];
                                                        System.arraycopy(m2551a, i22, bArr4, 0, i19);
                                                        int i24 = i22 + i19;
                                                        if (m2551a[i24] == 3) {
                                                            int i25 = i24 + i23;
                                                            if (m2551a[i25] == 5) {
                                                                byte[] bArr5 = new byte[m2551a.length - i25];
                                                                System.arraycopy(m2551a, i25, bArr5, 0, m2551a.length - i25);
                                                                i3 = 2;
                                                                ArrayList arrayList2 = new ArrayList(2);
                                                                arrayList2.add(bArr4);
                                                                arrayList2.add(bArr5);
                                                                str5 = MimeTypes.AUDIO_VORBIS;
                                                                i4 = 8192;
                                                                arrayList = arrayList2;
                                                                str = null;
                                                                i5 = -1;
                                                                i2 = 1;
                                                                list3 = arrayList;
                                                                bArr = this.dolbyVisionConfigBytes;
                                                                if (bArr != null) {
                                                                }
                                                                boolean z22222 = this.flagDefault;
                                                                if (!this.flagForced) {
                                                                }
                                                                int i1222222 = (z22222 ? 1 : 0) | i8;
                                                                builder = new Format.Builder();
                                                                if (!MimeTypes.isAudio(str5)) {
                                                                }
                                                                str3 = this.name;
                                                                if (str3 != null) {
                                                                }
                                                                Format build22222 = builder.setId(i).setSampleMimeType(str5).setMaxInputSize(i4).setLanguage(this.f10247b).setSelectionFlags(i1222222).setInitializationData(list3).setCodecs(str).setDrmInitData(this.drmInitData).build();
                                                                TrackOutput track22222 = extractorOutput.track(this.number, i2);
                                                                this.output = track22222;
                                                                track22222.format(build22222);
                                                                return;
                                                            }
                                                            throw ParserException.createForMalformedContainer("Error parsing vorbis codec private", null);
                                                        }
                                                        throw ParserException.createForMalformedContainer("Error parsing vorbis codec private", null);
                                                    }
                                                    throw ParserException.createForMalformedContainer("Error parsing vorbis codec private", null);
                                                }
                                            } catch (ArrayIndexOutOfBoundsException unused2) {
                                                r1 = 0;
                                                throw ParserException.createForMalformedContainer("Error parsing vorbis codec private", r1);
                                            }
                                        }
                                    }
                                }
                            } else {
                                throw ParserException.createForMalformedContainer("Error parsing vorbis codec private", null);
                            }
                        } catch (ArrayIndexOutOfBoundsException unused3) {
                        }
                    } catch (ArrayIndexOutOfBoundsException unused4) {
                        r1 = 0;
                    }
                    break;
                case 5:
                    str5 = MimeTypes.AUDIO_MPEG_L2;
                    list4 = null;
                    str = null;
                    i4 = 4096;
                    i5 = -1;
                    list7 = list4;
                    i2 = 1;
                    i3 = 2;
                    list3 = list7;
                    bArr = this.dolbyVisionConfigBytes;
                    if (bArr != null) {
                    }
                    boolean z222222 = this.flagDefault;
                    if (!this.flagForced) {
                    }
                    int i12222222 = (z222222 ? 1 : 0) | i8;
                    builder = new Format.Builder();
                    if (!MimeTypes.isAudio(str5)) {
                    }
                    str3 = this.name;
                    if (str3 != null) {
                    }
                    Format build222222 = builder.setId(i).setSampleMimeType(str5).setMaxInputSize(i4).setLanguage(this.f10247b).setSelectionFlags(i12222222).setInitializationData(list3).setCodecs(str).setDrmInitData(this.drmInitData).build();
                    TrackOutput track222222 = extractorOutput.track(this.number, i2);
                    this.output = track222222;
                    track222222.format(build222222);
                    return;
                case 6:
                    str5 = MimeTypes.AUDIO_MPEG;
                    list4 = null;
                    str = null;
                    i4 = 4096;
                    i5 = -1;
                    list7 = list4;
                    i2 = 1;
                    i3 = 2;
                    list3 = list7;
                    bArr = this.dolbyVisionConfigBytes;
                    if (bArr != null) {
                    }
                    boolean z2222222 = this.flagDefault;
                    if (!this.flagForced) {
                    }
                    int i122222222 = (z2222222 ? 1 : 0) | i8;
                    builder = new Format.Builder();
                    if (!MimeTypes.isAudio(str5)) {
                    }
                    str3 = this.name;
                    if (str3 != null) {
                    }
                    Format build2222222 = builder.setId(i).setSampleMimeType(str5).setMaxInputSize(i4).setLanguage(this.f10247b).setSelectionFlags(i122222222).setInitializationData(list3).setCodecs(str).setDrmInitData(this.drmInitData).build();
                    TrackOutput track2222222 = extractorOutput.track(this.number, i2);
                    this.output = track2222222;
                    track2222222.format(build2222222);
                    return;
                case 7:
                    ParsableByteArray parsableByteArray2 = new ParsableByteArray(m2551a(this.codecId));
                    try {
                        parsableByteArray2.skipBytes(16);
                        long readLittleEndianUnsignedInt = parsableByteArray2.readLittleEndianUnsignedInt();
                        if (readLittleEndianUnsignedInt == 1482049860) {
                            pair = new Pair(MimeTypes.VIDEO_DIVX, null);
                        } else if (readLittleEndianUnsignedInt == 859189832) {
                            pair = new Pair(MimeTypes.VIDEO_H263, null);
                        } else {
                            if (readLittleEndianUnsignedInt == 826496599) {
                                int position = parsableByteArray2.getPosition() + 20;
                                byte[] data = parsableByteArray2.getData();
                                while (position < data.length - 4) {
                                    if (data[position] == 0) {
                                        i6 = 1;
                                        if (data[position + 1] == 0 && data[position + 2] == 1) {
                                            if (data[position + 3] == 15) {
                                                pair = new Pair(MimeTypes.VIDEO_VC1, Collections.singletonList(Arrays.copyOfRange(data, position, data.length)));
                                            }
                                        } else {
                                            position += i6;
                                        }
                                    }
                                    i6 = 1;
                                    position += i6;
                                }
                                throw ParserException.createForMalformedContainer("Failed to find FourCC VC1 initialization data", null);
                            }
                            Log.m3027w("MatroskaExtractor", "Unknown FourCC. Setting mimeType to video/x-unknown");
                            pair = new Pair(MimeTypes.VIDEO_UNKNOWN, null);
                        }
                        str5 = (String) pair.first;
                        list8 = (List) pair.second;
                        str = null;
                        list6 = list8;
                        i4 = -1;
                        list4 = list6;
                        i5 = -1;
                        list7 = list4;
                        i2 = 1;
                        i3 = 2;
                        list3 = list7;
                        bArr = this.dolbyVisionConfigBytes;
                        if (bArr != null) {
                        }
                        boolean z22222222 = this.flagDefault;
                        if (!this.flagForced) {
                        }
                        int i1222222222 = (z22222222 ? 1 : 0) | i8;
                        builder = new Format.Builder();
                        if (!MimeTypes.isAudio(str5)) {
                        }
                        str3 = this.name;
                        if (str3 != null) {
                        }
                        Format build22222222 = builder.setId(i).setSampleMimeType(str5).setMaxInputSize(i4).setLanguage(this.f10247b).setSelectionFlags(i1222222222).setInitializationData(list3).setCodecs(str).setDrmInitData(this.drmInitData).build();
                        TrackOutput track22222222 = extractorOutput.track(this.number, i2);
                        this.output = track22222222;
                        track22222222.format(build22222222);
                        return;
                    } catch (ArrayIndexOutOfBoundsException unused5) {
                        throw ParserException.createForMalformedContainer("Error parsing FourCC private data", null);
                    }
                case '\b':
                    byte[] bArr6 = new byte[4];
                    System.arraycopy(m2551a(this.codecId), 0, bArr6, 0, 4);
                    ImmutableList m3903of = ImmutableList.m3903of(bArr6);
                    str = null;
                    str5 = MimeTypes.APPLICATION_DVBSUBS;
                    list6 = m3903of;
                    i4 = -1;
                    list4 = list6;
                    i5 = -1;
                    list7 = list4;
                    i2 = 1;
                    i3 = 2;
                    list3 = list7;
                    bArr = this.dolbyVisionConfigBytes;
                    if (bArr != null) {
                    }
                    boolean z222222222 = this.flagDefault;
                    if (!this.flagForced) {
                    }
                    int i12222222222 = (z222222222 ? 1 : 0) | i8;
                    builder = new Format.Builder();
                    if (!MimeTypes.isAudio(str5)) {
                    }
                    str3 = this.name;
                    if (str3 != null) {
                    }
                    Format build222222222 = builder.setId(i).setSampleMimeType(str5).setMaxInputSize(i4).setLanguage(this.f10247b).setSelectionFlags(i12222222222).setInitializationData(list3).setCodecs(str).setDrmInitData(this.drmInitData).build();
                    TrackOutput track222222222 = extractorOutput.track(this.number, i2);
                    this.output = track222222222;
                    track222222222.format(build222222222);
                    return;
                case '\n':
                    AvcConfig parse2 = AvcConfig.parse(new ParsableByteArray(m2551a(this.codecId)));
                    list5 = parse2.initializationData;
                    this.nalUnitLengthFieldLength = parse2.nalUnitLengthFieldLength;
                    str2 = parse2.codecs;
                    str5 = MimeTypes.VIDEO_H264;
                    str = str2;
                    list6 = list5;
                    i4 = -1;
                    list4 = list6;
                    i5 = -1;
                    list7 = list4;
                    i2 = 1;
                    i3 = 2;
                    list3 = list7;
                    bArr = this.dolbyVisionConfigBytes;
                    if (bArr != null) {
                    }
                    boolean z2222222222 = this.flagDefault;
                    if (!this.flagForced) {
                    }
                    int i122222222222 = (z2222222222 ? 1 : 0) | i8;
                    builder = new Format.Builder();
                    if (!MimeTypes.isAudio(str5)) {
                    }
                    str3 = this.name;
                    if (str3 != null) {
                    }
                    Format build2222222222 = builder.setId(i).setSampleMimeType(str5).setMaxInputSize(i4).setLanguage(this.f10247b).setSelectionFlags(i122222222222).setInitializationData(list3).setCodecs(str).setDrmInitData(this.drmInitData).build();
                    TrackOutput track2222222222 = extractorOutput.track(this.number, i2);
                    this.output = track2222222222;
                    track2222222222.format(build2222222222);
                    return;
                case 11:
                    ImmutableList m3903of2 = ImmutableList.m3903of(m2551a(this.codecId));
                    str = null;
                    str5 = MimeTypes.APPLICATION_VOBSUB;
                    list6 = m3903of2;
                    i4 = -1;
                    list4 = list6;
                    i5 = -1;
                    list7 = list4;
                    i2 = 1;
                    i3 = 2;
                    list3 = list7;
                    bArr = this.dolbyVisionConfigBytes;
                    if (bArr != null) {
                    }
                    boolean z22222222222 = this.flagDefault;
                    if (!this.flagForced) {
                    }
                    int i1222222222222 = (z22222222222 ? 1 : 0) | i8;
                    builder = new Format.Builder();
                    if (!MimeTypes.isAudio(str5)) {
                    }
                    str3 = this.name;
                    if (str3 != null) {
                    }
                    Format build22222222222 = builder.setId(i).setSampleMimeType(str5).setMaxInputSize(i4).setLanguage(this.f10247b).setSelectionFlags(i1222222222222).setInitializationData(list3).setCodecs(str).setDrmInitData(this.drmInitData).build();
                    TrackOutput track22222222222 = extractorOutput.track(this.number, i2);
                    this.output = track22222222222;
                    track22222222222.format(build22222222222);
                    return;
                case '\f':
                    str5 = MimeTypes.AUDIO_DTS_HD;
                    list6 = null;
                    str = null;
                    i4 = -1;
                    list4 = list6;
                    i5 = -1;
                    list7 = list4;
                    i2 = 1;
                    i3 = 2;
                    list3 = list7;
                    bArr = this.dolbyVisionConfigBytes;
                    if (bArr != null) {
                    }
                    boolean z222222222222 = this.flagDefault;
                    if (!this.flagForced) {
                    }
                    int i12222222222222 = (z222222222222 ? 1 : 0) | i8;
                    builder = new Format.Builder();
                    if (!MimeTypes.isAudio(str5)) {
                    }
                    str3 = this.name;
                    if (str3 != null) {
                    }
                    Format build222222222222 = builder.setId(i).setSampleMimeType(str5).setMaxInputSize(i4).setLanguage(this.f10247b).setSelectionFlags(i12222222222222).setInitializationData(list3).setCodecs(str).setDrmInitData(this.drmInitData).build();
                    TrackOutput track222222222222 = extractorOutput.track(this.number, i2);
                    this.output = track222222222222;
                    track222222222222.format(build222222222222);
                    return;
                case '\r':
                    List<byte[]> singletonList = Collections.singletonList(m2551a(this.codecId));
                    AacUtil.Config parseAudioSpecificConfig = AacUtil.parseAudioSpecificConfig(this.codecPrivate);
                    this.sampleRate = parseAudioSpecificConfig.sampleRateHz;
                    this.channelCount = parseAudioSpecificConfig.channelCount;
                    String str7 = parseAudioSpecificConfig.codecs;
                    str5 = MimeTypes.AUDIO_AAC;
                    str = str7;
                    list6 = singletonList;
                    i4 = -1;
                    list4 = list6;
                    i5 = -1;
                    list7 = list4;
                    i2 = 1;
                    i3 = 2;
                    list3 = list7;
                    bArr = this.dolbyVisionConfigBytes;
                    if (bArr != null) {
                    }
                    boolean z2222222222222 = this.flagDefault;
                    if (!this.flagForced) {
                    }
                    int i122222222222222 = (z2222222222222 ? 1 : 0) | i8;
                    builder = new Format.Builder();
                    if (!MimeTypes.isAudio(str5)) {
                    }
                    str3 = this.name;
                    if (str3 != null) {
                    }
                    Format build2222222222222 = builder.setId(i).setSampleMimeType(str5).setMaxInputSize(i4).setLanguage(this.f10247b).setSelectionFlags(i122222222222222).setInitializationData(list3).setCodecs(str).setDrmInitData(this.drmInitData).build();
                    TrackOutput track2222222222222 = extractorOutput.track(this.number, i2);
                    this.output = track2222222222222;
                    track2222222222222.format(build2222222222222);
                    return;
                case 14:
                    str5 = MimeTypes.AUDIO_AC3;
                    list6 = null;
                    str = null;
                    i4 = -1;
                    list4 = list6;
                    i5 = -1;
                    list7 = list4;
                    i2 = 1;
                    i3 = 2;
                    list3 = list7;
                    bArr = this.dolbyVisionConfigBytes;
                    if (bArr != null) {
                    }
                    boolean z22222222222222 = this.flagDefault;
                    if (!this.flagForced) {
                    }
                    int i1222222222222222 = (z22222222222222 ? 1 : 0) | i8;
                    builder = new Format.Builder();
                    if (!MimeTypes.isAudio(str5)) {
                    }
                    str3 = this.name;
                    if (str3 != null) {
                    }
                    Format build22222222222222 = builder.setId(i).setSampleMimeType(str5).setMaxInputSize(i4).setLanguage(this.f10247b).setSelectionFlags(i1222222222222222).setInitializationData(list3).setCodecs(str).setDrmInitData(this.drmInitData).build();
                    TrackOutput track22222222222222 = extractorOutput.track(this.number, i2);
                    this.output = track22222222222222;
                    track22222222222222.format(build22222222222222);
                    return;
                case 15:
                case 21:
                    str5 = MimeTypes.AUDIO_DTS;
                    list6 = null;
                    str = null;
                    i4 = -1;
                    list4 = list6;
                    i5 = -1;
                    list7 = list4;
                    i2 = 1;
                    i3 = 2;
                    list3 = list7;
                    bArr = this.dolbyVisionConfigBytes;
                    if (bArr != null) {
                    }
                    boolean z222222222222222 = this.flagDefault;
                    if (!this.flagForced) {
                    }
                    int i12222222222222222 = (z222222222222222 ? 1 : 0) | i8;
                    builder = new Format.Builder();
                    if (!MimeTypes.isAudio(str5)) {
                    }
                    str3 = this.name;
                    if (str3 != null) {
                    }
                    Format build222222222222222 = builder.setId(i).setSampleMimeType(str5).setMaxInputSize(i4).setLanguage(this.f10247b).setSelectionFlags(i12222222222222222).setInitializationData(list3).setCodecs(str).setDrmInitData(this.drmInitData).build();
                    TrackOutput track222222222222222 = extractorOutput.track(this.number, i2);
                    this.output = track222222222222222;
                    track222222222222222.format(build222222222222222);
                    return;
                case 16:
                    str5 = MimeTypes.VIDEO_AV1;
                    list6 = null;
                    str = null;
                    i4 = -1;
                    list4 = list6;
                    i5 = -1;
                    list7 = list4;
                    i2 = 1;
                    i3 = 2;
                    list3 = list7;
                    bArr = this.dolbyVisionConfigBytes;
                    if (bArr != null) {
                    }
                    boolean z2222222222222222 = this.flagDefault;
                    if (!this.flagForced) {
                    }
                    int i122222222222222222 = (z2222222222222222 ? 1 : 0) | i8;
                    builder = new Format.Builder();
                    if (!MimeTypes.isAudio(str5)) {
                    }
                    str3 = this.name;
                    if (str3 != null) {
                    }
                    Format build2222222222222222 = builder.setId(i).setSampleMimeType(str5).setMaxInputSize(i4).setLanguage(this.f10247b).setSelectionFlags(i122222222222222222).setInitializationData(list3).setCodecs(str).setDrmInitData(this.drmInitData).build();
                    TrackOutput track2222222222222222 = extractorOutput.track(this.number, i2);
                    this.output = track2222222222222222;
                    track2222222222222222.format(build2222222222222222);
                    return;
                case 17:
                    str5 = MimeTypes.VIDEO_VP8;
                    list6 = null;
                    str = null;
                    i4 = -1;
                    list4 = list6;
                    i5 = -1;
                    list7 = list4;
                    i2 = 1;
                    i3 = 2;
                    list3 = list7;
                    bArr = this.dolbyVisionConfigBytes;
                    if (bArr != null) {
                    }
                    boolean z22222222222222222 = this.flagDefault;
                    if (!this.flagForced) {
                    }
                    int i1222222222222222222 = (z22222222222222222 ? 1 : 0) | i8;
                    builder = new Format.Builder();
                    if (!MimeTypes.isAudio(str5)) {
                    }
                    str3 = this.name;
                    if (str3 != null) {
                    }
                    Format build22222222222222222 = builder.setId(i).setSampleMimeType(str5).setMaxInputSize(i4).setLanguage(this.f10247b).setSelectionFlags(i1222222222222222222).setInitializationData(list3).setCodecs(str).setDrmInitData(this.drmInitData).build();
                    TrackOutput track22222222222222222 = extractorOutput.track(this.number, i2);
                    this.output = track22222222222222222;
                    track22222222222222222.format(build22222222222222222);
                    return;
                case 18:
                    str5 = MimeTypes.VIDEO_VP9;
                    list6 = null;
                    str = null;
                    i4 = -1;
                    list4 = list6;
                    i5 = -1;
                    list7 = list4;
                    i2 = 1;
                    i3 = 2;
                    list3 = list7;
                    bArr = this.dolbyVisionConfigBytes;
                    if (bArr != null) {
                    }
                    boolean z222222222222222222 = this.flagDefault;
                    if (!this.flagForced) {
                    }
                    int i12222222222222222222 = (z222222222222222222 ? 1 : 0) | i8;
                    builder = new Format.Builder();
                    if (!MimeTypes.isAudio(str5)) {
                    }
                    str3 = this.name;
                    if (str3 != null) {
                    }
                    Format build222222222222222222 = builder.setId(i).setSampleMimeType(str5).setMaxInputSize(i4).setLanguage(this.f10247b).setSelectionFlags(i12222222222222222222).setInitializationData(list3).setCodecs(str).setDrmInitData(this.drmInitData).build();
                    TrackOutput track222222222222222222 = extractorOutput.track(this.number, i2);
                    this.output = track222222222222222222;
                    track222222222222222222.format(build222222222222222222);
                    return;
                case 19:
                    list6 = null;
                    str = null;
                    str5 = MimeTypes.APPLICATION_PGS;
                    i4 = -1;
                    list4 = list6;
                    i5 = -1;
                    list7 = list4;
                    i2 = 1;
                    i3 = 2;
                    list3 = list7;
                    bArr = this.dolbyVisionConfigBytes;
                    if (bArr != null) {
                    }
                    boolean z2222222222222222222 = this.flagDefault;
                    if (!this.flagForced) {
                    }
                    int i122222222222222222222 = (z2222222222222222222 ? 1 : 0) | i8;
                    builder = new Format.Builder();
                    if (!MimeTypes.isAudio(str5)) {
                    }
                    str3 = this.name;
                    if (str3 != null) {
                    }
                    Format build2222222222222222222 = builder.setId(i).setSampleMimeType(str5).setMaxInputSize(i4).setLanguage(this.f10247b).setSelectionFlags(i122222222222222222222).setInitializationData(list3).setCodecs(str).setDrmInitData(this.drmInitData).build();
                    TrackOutput track2222222222222222222 = extractorOutput.track(this.number, i2);
                    this.output = track2222222222222222222;
                    track2222222222222222222.format(build2222222222222222222);
                    return;
                case 20:
                    list6 = null;
                    str = null;
                    i4 = -1;
                    list4 = list6;
                    i5 = -1;
                    list7 = list4;
                    i2 = 1;
                    i3 = 2;
                    list3 = list7;
                    bArr = this.dolbyVisionConfigBytes;
                    if (bArr != null) {
                    }
                    boolean z22222222222222222222 = this.flagDefault;
                    if (!this.flagForced) {
                    }
                    int i1222222222222222222222 = (z22222222222222222222 ? 1 : 0) | i8;
                    builder = new Format.Builder();
                    if (!MimeTypes.isAudio(str5)) {
                    }
                    str3 = this.name;
                    if (str3 != null) {
                    }
                    Format build22222222222222222222 = builder.setId(i).setSampleMimeType(str5).setMaxInputSize(i4).setLanguage(this.f10247b).setSelectionFlags(i1222222222222222222222).setInitializationData(list3).setCodecs(str).setDrmInitData(this.drmInitData).build();
                    TrackOutput track22222222222222222222 = extractorOutput.track(this.number, i2);
                    this.output = track22222222222222222222;
                    track22222222222222222222.format(build22222222222222222222);
                    return;
                case 22:
                    if (this.audioBitDepth == 32) {
                        list7 = null;
                        str = null;
                        str5 = MimeTypes.AUDIO_RAW;
                        i4 = -1;
                        i5 = 4;
                        i2 = 1;
                        i3 = 2;
                        list3 = list7;
                        bArr = this.dolbyVisionConfigBytes;
                        if (bArr != null) {
                        }
                        boolean z222222222222222222222 = this.flagDefault;
                        if (!this.flagForced) {
                        }
                        int i12222222222222222222222 = (z222222222222222222222 ? 1 : 0) | i8;
                        builder = new Format.Builder();
                        if (!MimeTypes.isAudio(str5)) {
                        }
                        str3 = this.name;
                        if (str3 != null) {
                        }
                        Format build222222222222222222222 = builder.setId(i).setSampleMimeType(str5).setMaxInputSize(i4).setLanguage(this.f10247b).setSelectionFlags(i12222222222222222222222).setInitializationData(list3).setCodecs(str).setDrmInitData(this.drmInitData).build();
                        TrackOutput track222222222222222222222 = extractorOutput.track(this.number, i2);
                        this.output = track222222222222222222222;
                        track222222222222222222222.format(build222222222222222222222);
                        return;
                    }
                    Log.m3027w("MatroskaExtractor", "Unsupported floating point PCM bit depth: " + this.audioBitDepth + ". Setting mimeType to audio/x-unknown");
                    list6 = null;
                    str = null;
                    str5 = MimeTypes.AUDIO_UNKNOWN;
                    i4 = -1;
                    list4 = list6;
                    i5 = -1;
                    list7 = list4;
                    i2 = 1;
                    i3 = 2;
                    list3 = list7;
                    bArr = this.dolbyVisionConfigBytes;
                    if (bArr != null) {
                    }
                    boolean z2222222222222222222222 = this.flagDefault;
                    if (!this.flagForced) {
                    }
                    int i122222222222222222222222 = (z2222222222222222222222 ? 1 : 0) | i8;
                    builder = new Format.Builder();
                    if (!MimeTypes.isAudio(str5)) {
                    }
                    str3 = this.name;
                    if (str3 != null) {
                    }
                    Format build2222222222222222222222 = builder.setId(i).setSampleMimeType(str5).setMaxInputSize(i4).setLanguage(this.f10247b).setSelectionFlags(i122222222222222222222222).setInitializationData(list3).setCodecs(str).setDrmInitData(this.drmInitData).build();
                    TrackOutput track2222222222222222222222 = extractorOutput.track(this.number, i2);
                    this.output = track2222222222222222222222;
                    track2222222222222222222222.format(build2222222222222222222222);
                    return;
                case 23:
                    int i26 = this.audioBitDepth;
                    if (i26 == 8) {
                        i5 = 3;
                        list7 = null;
                        str = null;
                        str5 = MimeTypes.AUDIO_RAW;
                        i4 = -1;
                        i2 = 1;
                        i3 = 2;
                        list3 = list7;
                        bArr = this.dolbyVisionConfigBytes;
                        if (bArr != null) {
                        }
                        boolean z22222222222222222222222 = this.flagDefault;
                        if (!this.flagForced) {
                        }
                        int i1222222222222222222222222 = (z22222222222222222222222 ? 1 : 0) | i8;
                        builder = new Format.Builder();
                        if (!MimeTypes.isAudio(str5)) {
                        }
                        str3 = this.name;
                        if (str3 != null) {
                        }
                        Format build22222222222222222222222 = builder.setId(i).setSampleMimeType(str5).setMaxInputSize(i4).setLanguage(this.f10247b).setSelectionFlags(i1222222222222222222222222).setInitializationData(list3).setCodecs(str).setDrmInitData(this.drmInitData).build();
                        TrackOutput track22222222222222222222222 = extractorOutput.track(this.number, i2);
                        this.output = track22222222222222222222222;
                        track22222222222222222222222.format(build22222222222222222222222);
                        return;
                    }
                    if (i26 == 16) {
                        i7 = 268435456;
                        i5 = i7;
                        list7 = null;
                        str = null;
                        str5 = MimeTypes.AUDIO_RAW;
                        i4 = -1;
                        i2 = 1;
                        i3 = 2;
                        list3 = list7;
                        bArr = this.dolbyVisionConfigBytes;
                        if (bArr != null) {
                        }
                        boolean z222222222222222222222222 = this.flagDefault;
                        if (!this.flagForced) {
                        }
                        int i12222222222222222222222222 = (z222222222222222222222222 ? 1 : 0) | i8;
                        builder = new Format.Builder();
                        if (!MimeTypes.isAudio(str5)) {
                        }
                        str3 = this.name;
                        if (str3 != null) {
                        }
                        Format build222222222222222222222222 = builder.setId(i).setSampleMimeType(str5).setMaxInputSize(i4).setLanguage(this.f10247b).setSelectionFlags(i12222222222222222222222222).setInitializationData(list3).setCodecs(str).setDrmInitData(this.drmInitData).build();
                        TrackOutput track222222222222222222222222 = extractorOutput.track(this.number, i2);
                        this.output = track222222222222222222222222;
                        track222222222222222222222222.format(build222222222222222222222222);
                        return;
                    }
                    Log.m3027w("MatroskaExtractor", "Unsupported big endian PCM bit depth: " + this.audioBitDepth + ". Setting mimeType to audio/x-unknown");
                    list6 = null;
                    str = null;
                    str5 = MimeTypes.AUDIO_UNKNOWN;
                    i4 = -1;
                    list4 = list6;
                    i5 = -1;
                    list7 = list4;
                    i2 = 1;
                    i3 = 2;
                    list3 = list7;
                    bArr = this.dolbyVisionConfigBytes;
                    if (bArr != null) {
                    }
                    boolean z2222222222222222222222222 = this.flagDefault;
                    if (!this.flagForced) {
                    }
                    int i122222222222222222222222222 = (z2222222222222222222222222 ? 1 : 0) | i8;
                    builder = new Format.Builder();
                    if (!MimeTypes.isAudio(str5)) {
                    }
                    str3 = this.name;
                    if (str3 != null) {
                    }
                    Format build2222222222222222222222222 = builder.setId(i).setSampleMimeType(str5).setMaxInputSize(i4).setLanguage(this.f10247b).setSelectionFlags(i122222222222222222222222222).setInitializationData(list3).setCodecs(str).setDrmInitData(this.drmInitData).build();
                    TrackOutput track2222222222222222222222222 = extractorOutput.track(this.number, i2);
                    this.output = track2222222222222222222222222;
                    track2222222222222222222222222.format(build2222222222222222222222222);
                    return;
                case 24:
                    i7 = Util.getPcmEncoding(this.audioBitDepth);
                    if (i7 == 0) {
                        Log.m3027w("MatroskaExtractor", "Unsupported little endian PCM bit depth: " + this.audioBitDepth + ". Setting mimeType to audio/x-unknown");
                        list6 = null;
                        str = null;
                        str5 = MimeTypes.AUDIO_UNKNOWN;
                        i4 = -1;
                        list4 = list6;
                        i5 = -1;
                        list7 = list4;
                        i2 = 1;
                        i3 = 2;
                        list3 = list7;
                        bArr = this.dolbyVisionConfigBytes;
                        if (bArr != null) {
                        }
                        boolean z22222222222222222222222222 = this.flagDefault;
                        if (!this.flagForced) {
                        }
                        int i1222222222222222222222222222 = (z22222222222222222222222222 ? 1 : 0) | i8;
                        builder = new Format.Builder();
                        if (!MimeTypes.isAudio(str5)) {
                        }
                        str3 = this.name;
                        if (str3 != null) {
                        }
                        Format build22222222222222222222222222 = builder.setId(i).setSampleMimeType(str5).setMaxInputSize(i4).setLanguage(this.f10247b).setSelectionFlags(i1222222222222222222222222222).setInitializationData(list3).setCodecs(str).setDrmInitData(this.drmInitData).build();
                        TrackOutput track22222222222222222222222222 = extractorOutput.track(this.number, i2);
                        this.output = track22222222222222222222222222;
                        track22222222222222222222222222.format(build22222222222222222222222222);
                        return;
                    }
                    i5 = i7;
                    list7 = null;
                    str = null;
                    str5 = MimeTypes.AUDIO_RAW;
                    i4 = -1;
                    i2 = 1;
                    i3 = 2;
                    list3 = list7;
                    bArr = this.dolbyVisionConfigBytes;
                    if (bArr != null) {
                    }
                    boolean z222222222222222222222222222 = this.flagDefault;
                    if (!this.flagForced) {
                    }
                    int i12222222222222222222222222222 = (z222222222222222222222222222 ? 1 : 0) | i8;
                    builder = new Format.Builder();
                    if (!MimeTypes.isAudio(str5)) {
                    }
                    str3 = this.name;
                    if (str3 != null) {
                    }
                    Format build222222222222222222222222222 = builder.setId(i).setSampleMimeType(str5).setMaxInputSize(i4).setLanguage(this.f10247b).setSelectionFlags(i12222222222222222222222222222).setInitializationData(list3).setCodecs(str).setDrmInitData(this.drmInitData).build();
                    TrackOutput track222222222222222222222222222 = extractorOutput.track(this.number, i2);
                    this.output = track222222222222222222222222222;
                    track222222222222222222222222222.format(build222222222222222222222222222);
                    return;
                case 25:
                    ImmutableList m3904of = ImmutableList.m3904of(MatroskaExtractor.f10187d0, m2551a(this.codecId));
                    str5 = MimeTypes.TEXT_SSA;
                    list8 = m3904of;
                    str = null;
                    list6 = list8;
                    i4 = -1;
                    list4 = list6;
                    i5 = -1;
                    list7 = list4;
                    i2 = 1;
                    i3 = 2;
                    list3 = list7;
                    bArr = this.dolbyVisionConfigBytes;
                    if (bArr != null) {
                    }
                    boolean z2222222222222222222222222222 = this.flagDefault;
                    if (!this.flagForced) {
                    }
                    int i122222222222222222222222222222 = (z2222222222222222222222222222 ? 1 : 0) | i8;
                    builder = new Format.Builder();
                    if (!MimeTypes.isAudio(str5)) {
                    }
                    str3 = this.name;
                    if (str3 != null) {
                    }
                    Format build2222222222222222222222222222 = builder.setId(i).setSampleMimeType(str5).setMaxInputSize(i4).setLanguage(this.f10247b).setSelectionFlags(i122222222222222222222222222222).setInitializationData(list3).setCodecs(str).setDrmInitData(this.drmInitData).build();
                    TrackOutput track2222222222222222222222222222 = extractorOutput.track(this.number, i2);
                    this.output = track2222222222222222222222222222;
                    track2222222222222222222222222222.format(build2222222222222222222222222222);
                    return;
                case 26:
                    HevcConfig parse3 = HevcConfig.parse(new ParsableByteArray(m2551a(this.codecId)));
                    list5 = parse3.initializationData;
                    this.nalUnitLengthFieldLength = parse3.nalUnitLengthFieldLength;
                    str2 = parse3.codecs;
                    str5 = MimeTypes.VIDEO_H265;
                    str = str2;
                    list6 = list5;
                    i4 = -1;
                    list4 = list6;
                    i5 = -1;
                    list7 = list4;
                    i2 = 1;
                    i3 = 2;
                    list3 = list7;
                    bArr = this.dolbyVisionConfigBytes;
                    if (bArr != null) {
                    }
                    boolean z22222222222222222222222222222 = this.flagDefault;
                    if (!this.flagForced) {
                    }
                    int i1222222222222222222222222222222 = (z22222222222222222222222222222 ? 1 : 0) | i8;
                    builder = new Format.Builder();
                    if (!MimeTypes.isAudio(str5)) {
                    }
                    str3 = this.name;
                    if (str3 != null) {
                    }
                    Format build22222222222222222222222222222 = builder.setId(i).setSampleMimeType(str5).setMaxInputSize(i4).setLanguage(this.f10247b).setSelectionFlags(i1222222222222222222222222222222).setInitializationData(list3).setCodecs(str).setDrmInitData(this.drmInitData).build();
                    TrackOutput track22222222222222222222222222222 = extractorOutput.track(this.number, i2);
                    this.output = track22222222222222222222222222222;
                    track22222222222222222222222222222.format(build22222222222222222222222222222);
                    return;
                case 27:
                    str5 = MimeTypes.TEXT_VTT;
                    list6 = null;
                    str = null;
                    i4 = -1;
                    list4 = list6;
                    i5 = -1;
                    list7 = list4;
                    i2 = 1;
                    i3 = 2;
                    list3 = list7;
                    bArr = this.dolbyVisionConfigBytes;
                    if (bArr != null) {
                    }
                    boolean z222222222222222222222222222222 = this.flagDefault;
                    if (!this.flagForced) {
                    }
                    int i12222222222222222222222222222222 = (z222222222222222222222222222222 ? 1 : 0) | i8;
                    builder = new Format.Builder();
                    if (!MimeTypes.isAudio(str5)) {
                    }
                    str3 = this.name;
                    if (str3 != null) {
                    }
                    Format build222222222222222222222222222222 = builder.setId(i).setSampleMimeType(str5).setMaxInputSize(i4).setLanguage(this.f10247b).setSelectionFlags(i12222222222222222222222222222222).setInitializationData(list3).setCodecs(str).setDrmInitData(this.drmInitData).build();
                    TrackOutput track222222222222222222222222222222 = extractorOutput.track(this.number, i2);
                    this.output = track222222222222222222222222222222;
                    track222222222222222222222222222222.format(build222222222222222222222222222222);
                    return;
                case 28:
                    str5 = MimeTypes.APPLICATION_SUBRIP;
                    list6 = null;
                    str = null;
                    i4 = -1;
                    list4 = list6;
                    i5 = -1;
                    list7 = list4;
                    i2 = 1;
                    i3 = 2;
                    list3 = list7;
                    bArr = this.dolbyVisionConfigBytes;
                    if (bArr != null) {
                    }
                    boolean z2222222222222222222222222222222 = this.flagDefault;
                    if (!this.flagForced) {
                    }
                    int i122222222222222222222222222222222 = (z2222222222222222222222222222222 ? 1 : 0) | i8;
                    builder = new Format.Builder();
                    if (!MimeTypes.isAudio(str5)) {
                    }
                    str3 = this.name;
                    if (str3 != null) {
                    }
                    Format build2222222222222222222222222222222 = builder.setId(i).setSampleMimeType(str5).setMaxInputSize(i4).setLanguage(this.f10247b).setSelectionFlags(i122222222222222222222222222222222).setInitializationData(list3).setCodecs(str).setDrmInitData(this.drmInitData).build();
                    TrackOutput track2222222222222222222222222222222 = extractorOutput.track(this.number, i2);
                    this.output = track2222222222222222222222222222222;
                    track2222222222222222222222222222222.format(build2222222222222222222222222222222);
                    return;
                case 29:
                    str5 = MimeTypes.VIDEO_MPEG2;
                    list6 = null;
                    str = null;
                    i4 = -1;
                    list4 = list6;
                    i5 = -1;
                    list7 = list4;
                    i2 = 1;
                    i3 = 2;
                    list3 = list7;
                    bArr = this.dolbyVisionConfigBytes;
                    if (bArr != null) {
                    }
                    boolean z22222222222222222222222222222222 = this.flagDefault;
                    if (!this.flagForced) {
                    }
                    int i1222222222222222222222222222222222 = (z22222222222222222222222222222222 ? 1 : 0) | i8;
                    builder = new Format.Builder();
                    if (!MimeTypes.isAudio(str5)) {
                    }
                    str3 = this.name;
                    if (str3 != null) {
                    }
                    Format build22222222222222222222222222222222 = builder.setId(i).setSampleMimeType(str5).setMaxInputSize(i4).setLanguage(this.f10247b).setSelectionFlags(i1222222222222222222222222222222222).setInitializationData(list3).setCodecs(str).setDrmInitData(this.drmInitData).build();
                    TrackOutput track22222222222222222222222222222222 = extractorOutput.track(this.number, i2);
                    this.output = track22222222222222222222222222222222;
                    track22222222222222222222222222222222.format(build22222222222222222222222222222222);
                    return;
                case 30:
                    str5 = MimeTypes.AUDIO_E_AC3;
                    list6 = null;
                    str = null;
                    i4 = -1;
                    list4 = list6;
                    i5 = -1;
                    list7 = list4;
                    i2 = 1;
                    i3 = 2;
                    list3 = list7;
                    bArr = this.dolbyVisionConfigBytes;
                    if (bArr != null) {
                    }
                    boolean z222222222222222222222222222222222 = this.flagDefault;
                    if (!this.flagForced) {
                    }
                    int i12222222222222222222222222222222222 = (z222222222222222222222222222222222 ? 1 : 0) | i8;
                    builder = new Format.Builder();
                    if (!MimeTypes.isAudio(str5)) {
                    }
                    str3 = this.name;
                    if (str3 != null) {
                    }
                    Format build222222222222222222222222222222222 = builder.setId(i).setSampleMimeType(str5).setMaxInputSize(i4).setLanguage(this.f10247b).setSelectionFlags(i12222222222222222222222222222222222).setInitializationData(list3).setCodecs(str).setDrmInitData(this.drmInitData).build();
                    TrackOutput track222222222222222222222222222222222 = extractorOutput.track(this.number, i2);
                    this.output = track222222222222222222222222222222222;
                    track222222222222222222222222222222222.format(build222222222222222222222222222222222);
                    return;
                case 31:
                    List<byte[]> singletonList2 = Collections.singletonList(m2551a(this.codecId));
                    str5 = MimeTypes.AUDIO_FLAC;
                    list8 = singletonList2;
                    str = null;
                    list6 = list8;
                    i4 = -1;
                    list4 = list6;
                    i5 = -1;
                    list7 = list4;
                    i2 = 1;
                    i3 = 2;
                    list3 = list7;
                    bArr = this.dolbyVisionConfigBytes;
                    if (bArr != null) {
                    }
                    boolean z2222222222222222222222222222222222 = this.flagDefault;
                    if (!this.flagForced) {
                    }
                    int i122222222222222222222222222222222222 = (z2222222222222222222222222222222222 ? 1 : 0) | i8;
                    builder = new Format.Builder();
                    if (!MimeTypes.isAudio(str5)) {
                    }
                    str3 = this.name;
                    if (str3 != null) {
                    }
                    Format build2222222222222222222222222222222222 = builder.setId(i).setSampleMimeType(str5).setMaxInputSize(i4).setLanguage(this.f10247b).setSelectionFlags(i122222222222222222222222222222222222).setInitializationData(list3).setCodecs(str).setDrmInitData(this.drmInitData).build();
                    TrackOutput track2222222222222222222222222222222222 = extractorOutput.track(this.number, i2);
                    this.output = track2222222222222222222222222222222222;
                    track2222222222222222222222222222222222.format(build2222222222222222222222222222222222);
                    return;
                case ' ':
                    ArrayList arrayList3 = new ArrayList(3);
                    arrayList3.add(m2551a(this.codecId));
                    ByteBuffer allocate = ByteBuffer.allocate(8);
                    ByteOrder byteOrder = ByteOrder.LITTLE_ENDIAN;
                    arrayList3.add(allocate.order(byteOrder).putLong(this.codecDelayNs).array());
                    arrayList3.add(ByteBuffer.allocate(8).order(byteOrder).putLong(this.seekPreRollNs).array());
                    str5 = MimeTypes.AUDIO_OPUS;
                    i4 = 5760;
                    str = null;
                    list4 = arrayList3;
                    i5 = -1;
                    list7 = list4;
                    i2 = 1;
                    i3 = 2;
                    list3 = list7;
                    bArr = this.dolbyVisionConfigBytes;
                    if (bArr != null) {
                    }
                    boolean z22222222222222222222222222222222222 = this.flagDefault;
                    if (!this.flagForced) {
                    }
                    int i1222222222222222222222222222222222222 = (z22222222222222222222222222222222222 ? 1 : 0) | i8;
                    builder = new Format.Builder();
                    if (!MimeTypes.isAudio(str5)) {
                    }
                    str3 = this.name;
                    if (str3 != null) {
                    }
                    Format build22222222222222222222222222222222222 = builder.setId(i).setSampleMimeType(str5).setMaxInputSize(i4).setLanguage(this.f10247b).setSelectionFlags(i1222222222222222222222222222222222222).setInitializationData(list3).setCodecs(str).setDrmInitData(this.drmInitData).build();
                    TrackOutput track22222222222222222222222222222222222 = extractorOutput.track(this.number, i2);
                    this.output = track22222222222222222222222222222222222;
                    track22222222222222222222222222222222222.format(build22222222222222222222222222222222222);
                    return;
                default:
                    throw ParserException.createForMalformedContainer("Unrecognized codec identifier.", null);
            }
        }

        @RequiresNonNull({"output"})
        public void outputPendingSampleMetadata() {
            TrueHdSampleRechunker trueHdSampleRechunker = this.trueHdSampleRechunker;
            if (trueHdSampleRechunker != null) {
                trueHdSampleRechunker.outputPendingSampleMetadata(this.output, this.cryptoData);
            }
        }

        public void reset() {
            TrueHdSampleRechunker trueHdSampleRechunker = this.trueHdSampleRechunker;
            if (trueHdSampleRechunker != null) {
                trueHdSampleRechunker.reset();
            }
        }
    }

    static {
        HashMap hashMap = new HashMap();
        ye0.m8278A(0, hashMap, "htc_video_rotA-000", 90, "htc_video_rotA-090");
        ye0.m8278A(180, hashMap, "htc_video_rotA-180", 270, "htc_video_rotA-270");
        f10191h0 = Collections.unmodifiableMap(hashMap);
    }

    public MatroskaExtractor() {
        this(0);
    }

    /* renamed from: d */
    public static byte[] m2542d(String str, long j, long j2) {
        boolean z;
        if (j != C0643C.TIME_UNSET) {
            z = true;
        } else {
            z = false;
        }
        Assertions.checkArgument(z);
        int i = (int) (j / 3600000000L);
        long j3 = j - (i * 3600000000L);
        int i2 = (int) (j3 / 60000000);
        long j4 = j3 - (i2 * 60000000);
        int i3 = (int) (j4 / 1000000);
        return Util.getUtf8Bytes(String.format(Locale.US, str, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf((int) ((j4 - (i3 * 1000000)) / j2))));
    }

    /* renamed from: a */
    public final void m2543a(int i) {
        if (this.f10194C != null && this.f10195D != null) {
            return;
        }
        throw ParserException.createForMalformedContainer("Element " + i + " must be in a Cues", null);
    }

    /* renamed from: b */
    public final void m2544b(int i) {
        if (this.f10240u != null) {
            return;
        }
        throw ParserException.createForMalformedContainer("Element " + i + " must be in a TrackEntry", null);
    }

    @CallSuper
    public void binaryElement(int i, int i2, ExtractorInput extractorInput) {
        int i3;
        long j;
        int i4;
        int i5;
        int i6;
        int i7;
        SparseArray sparseArray = this.f10222c;
        int i8 = 1;
        int i9 = 0;
        if (i != 161 && i != 163) {
            if (i != 165) {
                if (i != 16877) {
                    if (i != 16981) {
                        if (i != 18402) {
                            if (i != 21419) {
                                if (i != 25506) {
                                    if (i == 30322) {
                                        m2544b(i);
                                        byte[] bArr = new byte[i2];
                                        this.f10240u.projectionData = bArr;
                                        extractorInput.readFully(bArr, 0, i2);
                                        return;
                                    }
                                    throw ParserException.createForMalformedContainer("Unexpected id: " + i, null);
                                }
                                m2544b(i);
                                byte[] bArr2 = new byte[i2];
                                this.f10240u.codecPrivate = bArr2;
                                extractorInput.readFully(bArr2, 0, i2);
                                return;
                            }
                            ParsableByteArray parsableByteArray = this.f10228i;
                            Arrays.fill(parsableByteArray.getData(), (byte) 0);
                            extractorInput.readFully(parsableByteArray.getData(), 4 - i2, i2);
                            parsableByteArray.setPosition(0);
                            this.f10242w = (int) parsableByteArray.readUnsignedInt();
                            return;
                        }
                        byte[] bArr3 = new byte[i2];
                        extractorInput.readFully(bArr3, 0, i2);
                        getCurrentTrack(i).cryptoData = new TrackOutput.CryptoData(1, bArr3, 0, 0);
                        return;
                    }
                    m2544b(i);
                    byte[] bArr4 = new byte[i2];
                    this.f10240u.sampleStrippedBytes = bArr4;
                    extractorInput.readFully(bArr4, 0, i2);
                    return;
                }
                handleBlockAddIDExtraData(getCurrentTrack(i), extractorInput, i2);
                return;
            }
            if (this.f10198G != 2) {
                return;
            }
            handleBlockAdditionalData((Track) sparseArray.get(this.f10204M), this.f10207P, extractorInput, i2);
            return;
        }
        int i10 = this.f10198G;
        ParsableByteArray parsableByteArray2 = this.f10226g;
        if (i10 == 0) {
            d13 d13Var = this.f10220b;
            this.f10204M = (int) d13Var.m4509c(extractorInput, false, true, 8);
            this.f10205N = d13Var.f16215b;
            this.f10200I = C0643C.TIME_UNSET;
            this.f10198G = 1;
            parsableByteArray2.reset(0);
        }
        Track track = (Track) sparseArray.get(this.f10204M);
        if (track == null) {
            extractorInput.skipFully(i2 - this.f10205N);
            this.f10198G = 0;
            return;
        }
        Assertions.checkNotNull(track.output);
        if (this.f10198G == 1) {
            m2546e(extractorInput, 3);
            int i11 = (parsableByteArray2.getData()[2] & 6) >> 1;
            if (i11 == 0) {
                this.f10202K = 1;
                int[] iArr = this.f10203L;
                if (iArr == null) {
                    iArr = new int[1];
                } else if (iArr.length < 1) {
                    iArr = new int[Math.max(iArr.length * 2, 1)];
                }
                this.f10203L = iArr;
                iArr[0] = (i2 - this.f10205N) - 3;
            } else {
                int i12 = 4;
                m2546e(extractorInput, 4);
                int i13 = (parsableByteArray2.getData()[3] & 255) + 1;
                this.f10202K = i13;
                int[] iArr2 = this.f10203L;
                if (iArr2 == null) {
                    iArr2 = new int[i13];
                } else if (iArr2.length < i13) {
                    iArr2 = new int[Math.max(iArr2.length * 2, i13)];
                }
                this.f10203L = iArr2;
                if (i11 == 2) {
                    int i14 = (i2 - this.f10205N) - 4;
                    int i15 = this.f10202K;
                    Arrays.fill(iArr2, 0, i15, i14 / i15);
                } else if (i11 == 1) {
                    int i16 = 0;
                    int i17 = 0;
                    while (true) {
                        i4 = this.f10202K - 1;
                        if (i16 >= i4) {
                            break;
                        }
                        this.f10203L[i16] = 0;
                        while (true) {
                            i5 = i12 + 1;
                            m2546e(extractorInput, i5);
                            int i18 = parsableByteArray2.getData()[i12] & 255;
                            int[] iArr3 = this.f10203L;
                            i6 = iArr3[i16] + i18;
                            iArr3[i16] = i6;
                            if (i18 != 255) {
                                break;
                            } else {
                                i12 = i5;
                            }
                        }
                        i17 += i6;
                        i16++;
                        i12 = i5;
                    }
                    this.f10203L[i4] = ((i2 - this.f10205N) - i12) - i17;
                } else {
                    if (i11 == 3) {
                        int i19 = 0;
                        int i20 = 0;
                        while (true) {
                            int i21 = this.f10202K - i8;
                            if (i19 < i21) {
                                this.f10203L[i19] = i9;
                                int i22 = i12 + 1;
                                m2546e(extractorInput, i22);
                                if (parsableByteArray2.getData()[i12] != 0) {
                                    int i23 = i9;
                                    int i24 = 8;
                                    while (true) {
                                        if (i23 < i24) {
                                            int i25 = i8 << (7 - i23);
                                            if ((parsableByteArray2.getData()[i12] & i25) != 0) {
                                                int i26 = i22 + i23;
                                                m2546e(extractorInput, i26);
                                                j = (~i25) & parsableByteArray2.getData()[i12] & 255;
                                                while (i22 < i26) {
                                                    j = (j << 8) | (parsableByteArray2.getData()[i22] & 255);
                                                    i22++;
                                                }
                                                if (i19 > 0) {
                                                    j -= (1 << ((i23 * 7) + 6)) - 1;
                                                }
                                                i12 = i26;
                                            } else {
                                                i23++;
                                                i24 = 8;
                                                i8 = 1;
                                            }
                                        } else {
                                            j = 0;
                                            i12 = i22;
                                            break;
                                        }
                                    }
                                    if (j < -2147483648L || j > 2147483647L) {
                                        break;
                                    }
                                    int i27 = (int) j;
                                    int[] iArr4 = this.f10203L;
                                    if (i19 != 0) {
                                        i27 += iArr4[i19 - 1];
                                    }
                                    iArr4[i19] = i27;
                                    i20 += i27;
                                    i19++;
                                    i8 = 1;
                                    i9 = 0;
                                } else {
                                    throw ParserException.createForMalformedContainer("No valid varint length mask found", null);
                                }
                            } else {
                                this.f10203L[i21] = ((i2 - this.f10205N) - i12) - i20;
                                break;
                            }
                        }
                        throw ParserException.createForMalformedContainer("EBML lacing sample size out of range.", null);
                    }
                    throw ParserException.createForMalformedContainer("Unexpected lacing value: " + i11, null);
                }
            }
            this.f10199H = m2548g((parsableByteArray2.getData()[0] << 8) | (parsableByteArray2.getData()[1] & 255)) + this.f10193B;
            if (track.type != 2 && (i != 163 || (parsableByteArray2.getData()[2] & 128) != 128)) {
                i7 = 0;
            } else {
                i7 = 1;
            }
            this.f10206O = i7;
            this.f10198G = 2;
            this.f10201J = 0;
            i3 = 163;
        } else {
            i3 = 163;
        }
        if (i == i3) {
            while (true) {
                int i28 = this.f10201J;
                if (i28 < this.f10202K) {
                    m2545c(track, ((this.f10201J * track.defaultSampleDurationNs) / 1000) + this.f10199H, this.f10206O, m2549h(extractorInput, track, this.f10203L[i28], false), 0);
                    this.f10201J++;
                } else {
                    this.f10198G = 0;
                    return;
                }
            }
        } else {
            while (true) {
                int i29 = this.f10201J;
                if (i29 < this.f10202K) {
                    int[] iArr5 = this.f10203L;
                    iArr5[i29] = m2549h(extractorInput, track, iArr5[i29], true);
                    this.f10201J++;
                } else {
                    return;
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x00e0  */
    /* renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void m2545c(Track track, long j, int i, int i2, int i3) {
        byte[] m2542d;
        int i4;
        int limit;
        TrueHdSampleRechunker trueHdSampleRechunker = track.trueHdSampleRechunker;
        if (trueHdSampleRechunker != null) {
            trueHdSampleRechunker.sampleMetadata(track.output, j, i, i2, i3, track.cryptoData);
        } else {
            if ("S_TEXT/UTF8".equals(track.codecId) || "S_TEXT/ASS".equals(track.codecId) || "S_TEXT/WEBVTT".equals(track.codecId)) {
                if (this.f10202K > 1) {
                    Log.m3027w("MatroskaExtractor", "Skipping subtitle sample in laced block.");
                } else {
                    long j2 = this.f10200I;
                    if (j2 == C0643C.TIME_UNSET) {
                        Log.m3027w("MatroskaExtractor", "Skipping subtitle sample with no duration.");
                    } else {
                        String str = track.codecId;
                        ParsableByteArray parsableByteArray = this.f10230k;
                        byte[] data = parsableByteArray.getData();
                        str.getClass();
                        char c = 65535;
                        switch (str.hashCode()) {
                            case 738597099:
                                if (str.equals("S_TEXT/ASS")) {
                                    c = 0;
                                    break;
                                }
                                break;
                            case 1045209816:
                                if (str.equals("S_TEXT/WEBVTT")) {
                                    c = 1;
                                    break;
                                }
                                break;
                            case 1422270023:
                                if (str.equals("S_TEXT/UTF8")) {
                                    c = 2;
                                    break;
                                }
                                break;
                        }
                        switch (c) {
                            case 0:
                                m2542d = m2542d("%01d:%02d:%02d:%02d", j2, 10000L);
                                i4 = 21;
                                break;
                            case 1:
                                m2542d = m2542d("%02d:%02d:%02d.%03d", j2, 1000L);
                                i4 = 25;
                                break;
                            case 2:
                                m2542d = m2542d("%02d:%02d:%02d,%03d", j2, 1000L);
                                i4 = 19;
                                break;
                            default:
                                throw new IllegalArgumentException();
                        }
                        System.arraycopy(m2542d, 0, data, i4, m2542d.length);
                        int position = parsableByteArray.getPosition();
                        while (true) {
                            if (position < parsableByteArray.limit()) {
                                if (parsableByteArray.getData()[position] == 0) {
                                    parsableByteArray.setLimit(position);
                                } else {
                                    position++;
                                }
                            }
                        }
                        track.output.sampleData(parsableByteArray, parsableByteArray.limit());
                        limit = parsableByteArray.limit() + i2;
                        if ((i & 268435456) != 0) {
                            int i5 = this.f10202K;
                            ParsableByteArray parsableByteArray2 = this.f10233n;
                            if (i5 > 1) {
                                parsableByteArray2.reset(0);
                            } else {
                                int limit2 = parsableByteArray2.limit();
                                track.output.sampleData(parsableByteArray2, limit2, 2);
                                limit += limit2;
                            }
                        }
                        track.output.sampleMetadata(j, i, limit, i3, track.cryptoData);
                    }
                }
            }
            limit = i2;
            if ((i & 268435456) != 0) {
            }
            track.output.sampleMetadata(j, i, limit, i3, track.cryptoData);
        }
        this.f10197F = true;
    }

    /* renamed from: e */
    public final void m2546e(ExtractorInput extractorInput, int i) {
        ParsableByteArray parsableByteArray = this.f10226g;
        if (parsableByteArray.limit() >= i) {
            return;
        }
        if (parsableByteArray.capacity() < i) {
            parsableByteArray.ensureCapacity(Math.max(parsableByteArray.capacity() * 2, i));
        }
        extractorInput.readFully(parsableByteArray.getData(), parsableByteArray.limit(), i - parsableByteArray.limit());
        parsableByteArray.setLimit(i);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:171:0x02e6, code lost:
    
        if (r6.equals("S_DVBSUB") == false) goto L82;
     */
    @CallSuper
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void endMasterElement(int i) {
        SeekMap unseekable;
        int i2;
        long[] jArr;
        char c = '\b';
        int i3 = 0;
        Assertions.checkStateNotNull(this.f10221b0);
        SparseArray sparseArray = this.f10222c;
        if (i != 160) {
            if (i != 174) {
                if (i != 19899) {
                    if (i != 25152) {
                        if (i != 28032) {
                            if (i != 357149030) {
                                if (i != 374648427) {
                                    if (i == 475249515) {
                                        if (!this.f10241v) {
                                            ExtractorOutput extractorOutput = this.f10221b0;
                                            LongArray longArray = this.f10194C;
                                            LongArray longArray2 = this.f10195D;
                                            if (this.f10236q != -1 && this.f10239t != C0643C.TIME_UNSET && longArray != null && longArray.size() != 0 && longArray2 != null && longArray2.size() == longArray.size()) {
                                                int size = longArray.size();
                                                int[] iArr = new int[size];
                                                long[] jArr2 = new long[size];
                                                long[] jArr3 = new long[size];
                                                long[] jArr4 = new long[size];
                                                for (int i4 = 0; i4 < size; i4++) {
                                                    jArr4[i4] = longArray.get(i4);
                                                    jArr2[i4] = longArray2.get(i4) + this.f10236q;
                                                }
                                                while (true) {
                                                    i2 = size - 1;
                                                    if (i3 >= i2) {
                                                        break;
                                                    }
                                                    int i5 = i3 + 1;
                                                    iArr[i3] = (int) (jArr2[i5] - jArr2[i3]);
                                                    jArr3[i3] = jArr4[i5] - jArr4[i3];
                                                    i3 = i5;
                                                }
                                                iArr[i2] = (int) ((this.f10236q + this.f10235p) - jArr2[i2]);
                                                long j = this.f10239t - jArr4[i2];
                                                jArr3[i2] = j;
                                                if (j <= 0) {
                                                    Log.m3027w("MatroskaExtractor", "Discarding last cue point with unexpected duration: " + j);
                                                    iArr = Arrays.copyOf(iArr, i2);
                                                    jArr2 = Arrays.copyOf(jArr2, i2);
                                                    jArr3 = Arrays.copyOf(jArr3, i2);
                                                    jArr = Arrays.copyOf(jArr4, i2);
                                                } else {
                                                    jArr = jArr4;
                                                }
                                                unseekable = new ChunkIndex(iArr, jArr2, jArr3, jArr);
                                            } else {
                                                unseekable = new SeekMap.Unseekable(this.f10239t);
                                            }
                                            extractorOutput.seekMap(unseekable);
                                            this.f10241v = true;
                                        }
                                        this.f10194C = null;
                                        this.f10195D = null;
                                        return;
                                    }
                                    return;
                                }
                                if (sparseArray.size() != 0) {
                                    this.f10221b0.endTracks();
                                    return;
                                }
                                throw ParserException.createForMalformedContainer("No valid tracks were found", null);
                            }
                            if (this.f10237r == C0643C.TIME_UNSET) {
                                this.f10237r = 1000000L;
                            }
                            long j2 = this.f10238s;
                            if (j2 != C0643C.TIME_UNSET) {
                                this.f10239t = m2548g(j2);
                                return;
                            }
                            return;
                        }
                        m2544b(i);
                        Track track = this.f10240u;
                        if (track.hasContentEncryption && track.sampleStrippedBytes != null) {
                            throw ParserException.createForMalformedContainer("Combining encryption and compression is not supported", null);
                        }
                        return;
                    }
                    m2544b(i);
                    Track track2 = this.f10240u;
                    if (track2.hasContentEncryption) {
                        TrackOutput.CryptoData cryptoData = track2.cryptoData;
                        if (cryptoData != null) {
                            track2.drmInitData = new DrmInitData(new DrmInitData.SchemeData(C0643C.UUID_NIL, MimeTypes.VIDEO_WEBM, cryptoData.encryptionKey));
                            return;
                        }
                        throw ParserException.createForMalformedContainer("Encrypted Track found but ContentEncKeyID was not found", null);
                    }
                    return;
                }
                int i6 = this.f10242w;
                if (i6 != -1) {
                    long j3 = this.f10243x;
                    if (j3 != -1) {
                        if (i6 == 475249515) {
                            this.f10245z = j3;
                            return;
                        }
                        return;
                    }
                }
                throw ParserException.createForMalformedContainer("Mandatory element SeekID or SeekPosition not found", null);
            }
            Track track3 = (Track) Assertions.checkStateNotNull(this.f10240u);
            String str = track3.codecId;
            if (str != null) {
                switch (str.hashCode()) {
                    case -2095576542:
                        if (str.equals("V_MPEG4/ISO/AP")) {
                            c = 0;
                            break;
                        }
                        c = 65535;
                        break;
                    case -2095575984:
                        if (str.equals("V_MPEG4/ISO/SP")) {
                            c = 1;
                            break;
                        }
                        c = 65535;
                        break;
                    case -1985379776:
                        if (str.equals("A_MS/ACM")) {
                            c = 2;
                            break;
                        }
                        c = 65535;
                        break;
                    case -1784763192:
                        if (str.equals("A_TRUEHD")) {
                            c = 3;
                            break;
                        }
                        c = 65535;
                        break;
                    case -1730367663:
                        if (str.equals("A_VORBIS")) {
                            c = 4;
                            break;
                        }
                        c = 65535;
                        break;
                    case -1482641358:
                        if (str.equals("A_MPEG/L2")) {
                            c = 5;
                            break;
                        }
                        c = 65535;
                        break;
                    case -1482641357:
                        if (str.equals("A_MPEG/L3")) {
                            c = 6;
                            break;
                        }
                        c = 65535;
                        break;
                    case -1373388978:
                        if (str.equals("V_MS/VFW/FOURCC")) {
                            c = 7;
                            break;
                        }
                        c = 65535;
                        break;
                    case -933872740:
                        break;
                    case -538363189:
                        if (str.equals("V_MPEG4/ISO/ASP")) {
                            c = '\t';
                            break;
                        }
                        c = 65535;
                        break;
                    case -538363109:
                        if (str.equals("V_MPEG4/ISO/AVC")) {
                            c = '\n';
                            break;
                        }
                        c = 65535;
                        break;
                    case -425012669:
                        if (str.equals("S_VOBSUB")) {
                            c = 11;
                            break;
                        }
                        c = 65535;
                        break;
                    case -356037306:
                        if (str.equals("A_DTS/LOSSLESS")) {
                            c = '\f';
                            break;
                        }
                        c = 65535;
                        break;
                    case 62923557:
                        if (str.equals("A_AAC")) {
                            c = '\r';
                            break;
                        }
                        c = 65535;
                        break;
                    case 62923603:
                        if (str.equals("A_AC3")) {
                            c = 14;
                            break;
                        }
                        c = 65535;
                        break;
                    case 62927045:
                        if (str.equals("A_DTS")) {
                            c = 15;
                            break;
                        }
                        c = 65535;
                        break;
                    case 82318131:
                        if (str.equals("V_AV1")) {
                            c = 16;
                            break;
                        }
                        c = 65535;
                        break;
                    case 82338133:
                        if (str.equals("V_VP8")) {
                            c = 17;
                            break;
                        }
                        c = 65535;
                        break;
                    case 82338134:
                        if (str.equals("V_VP9")) {
                            c = 18;
                            break;
                        }
                        c = 65535;
                        break;
                    case 99146302:
                        if (str.equals("S_HDMV/PGS")) {
                            c = 19;
                            break;
                        }
                        c = 65535;
                        break;
                    case 444813526:
                        if (str.equals("V_THEORA")) {
                            c = 20;
                            break;
                        }
                        c = 65535;
                        break;
                    case 542569478:
                        if (str.equals("A_DTS/EXPRESS")) {
                            c = 21;
                            break;
                        }
                        c = 65535;
                        break;
                    case 635596514:
                        if (str.equals("A_PCM/FLOAT/IEEE")) {
                            c = 22;
                            break;
                        }
                        c = 65535;
                        break;
                    case 725948237:
                        if (str.equals("A_PCM/INT/BIG")) {
                            c = 23;
                            break;
                        }
                        c = 65535;
                        break;
                    case 725957860:
                        if (str.equals("A_PCM/INT/LIT")) {
                            c = 24;
                            break;
                        }
                        c = 65535;
                        break;
                    case 738597099:
                        if (str.equals("S_TEXT/ASS")) {
                            c = 25;
                            break;
                        }
                        c = 65535;
                        break;
                    case 855502857:
                        if (str.equals("V_MPEGH/ISO/HEVC")) {
                            c = 26;
                            break;
                        }
                        c = 65535;
                        break;
                    case 1045209816:
                        if (str.equals("S_TEXT/WEBVTT")) {
                            c = 27;
                            break;
                        }
                        c = 65535;
                        break;
                    case 1422270023:
                        if (str.equals("S_TEXT/UTF8")) {
                            c = 28;
                            break;
                        }
                        c = 65535;
                        break;
                    case 1809237540:
                        if (str.equals("V_MPEG2")) {
                            c = 29;
                            break;
                        }
                        c = 65535;
                        break;
                    case 1950749482:
                        if (str.equals("A_EAC3")) {
                            c = 30;
                            break;
                        }
                        c = 65535;
                        break;
                    case 1950789798:
                        if (str.equals("A_FLAC")) {
                            c = 31;
                            break;
                        }
                        c = 65535;
                        break;
                    case 1951062397:
                        if (str.equals("A_OPUS")) {
                            c = ' ';
                            break;
                        }
                        c = 65535;
                        break;
                    default:
                        c = 65535;
                        break;
                }
                switch (c) {
                    case 0:
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                    case 7:
                    case '\b':
                    case '\t':
                    case '\n':
                    case 11:
                    case '\f':
                    case '\r':
                    case 14:
                    case 15:
                    case 16:
                    case 17:
                    case 18:
                    case 19:
                    case 20:
                    case 21:
                    case 22:
                    case 23:
                    case 24:
                    case 25:
                    case 26:
                    case 27:
                    case 28:
                    case 29:
                    case 30:
                    case 31:
                    case ' ':
                        track3.initializeOutput(this.f10221b0, track3.number);
                        sparseArray.put(track3.number, track3);
                        break;
                }
                this.f10240u = null;
                return;
            }
            throw ParserException.createForMalformedContainer("CodecId is missing in TrackEntry element", null);
        }
        if (this.f10198G != 2) {
            return;
        }
        Track track4 = (Track) sparseArray.get(this.f10204M);
        Assertions.checkNotNull(track4.output);
        if (this.f10209R > 0 && "A_OPUS".equals(track4.codecId)) {
            this.f10233n.reset(ByteBuffer.allocate(8).order(ByteOrder.LITTLE_ENDIAN).putLong(this.f10209R).array());
        }
        int i7 = 0;
        for (int i8 = 0; i8 < this.f10202K; i8++) {
            i7 += this.f10203L[i8];
        }
        int i9 = 0;
        while (i9 < this.f10202K) {
            long j4 = this.f10199H + ((track4.defaultSampleDurationNs * i9) / 1000);
            int i10 = this.f10206O;
            if (i9 == 0 && !this.f10208Q) {
                i10 |= 1;
            }
            int i11 = this.f10203L[i9];
            int i12 = i7 - i11;
            m2545c(track4, j4, i10, i11, i12);
            i9++;
            i7 = i12;
        }
        this.f10198G = 0;
    }

    /* renamed from: f */
    public final void m2547f() {
        this.f10210S = 0;
        this.f10211T = 0;
        this.f10212U = 0;
        this.f10213V = false;
        this.f10214W = false;
        this.f10215X = false;
        this.f10216Y = 0;
        this.f10217Z = (byte) 0;
        this.f10219a0 = false;
        this.f10229j.reset(0);
    }

    @CallSuper
    public void floatElement(int i, double d) {
        if (i != 181) {
            if (i != 17545) {
                switch (i) {
                    case 21969:
                        getCurrentTrack(i).primaryRChromaticityX = (float) d;
                        return;
                    case 21970:
                        getCurrentTrack(i).primaryRChromaticityY = (float) d;
                        return;
                    case 21971:
                        getCurrentTrack(i).primaryGChromaticityX = (float) d;
                        return;
                    case 21972:
                        getCurrentTrack(i).primaryGChromaticityY = (float) d;
                        return;
                    case 21973:
                        getCurrentTrack(i).primaryBChromaticityX = (float) d;
                        return;
                    case 21974:
                        getCurrentTrack(i).primaryBChromaticityY = (float) d;
                        return;
                    case 21975:
                        getCurrentTrack(i).whitePointChromaticityX = (float) d;
                        return;
                    case 21976:
                        getCurrentTrack(i).whitePointChromaticityY = (float) d;
                        return;
                    case 21977:
                        getCurrentTrack(i).maxMasteringLuminance = (float) d;
                        return;
                    case 21978:
                        getCurrentTrack(i).minMasteringLuminance = (float) d;
                        return;
                    default:
                        switch (i) {
                            case 30323:
                                getCurrentTrack(i).projectionPoseYaw = (float) d;
                                return;
                            case 30324:
                                getCurrentTrack(i).projectionPosePitch = (float) d;
                                return;
                            case 30325:
                                getCurrentTrack(i).projectionPoseRoll = (float) d;
                                return;
                            default:
                                return;
                        }
                }
            }
            this.f10238s = (long) d;
            return;
        }
        getCurrentTrack(i).sampleRate = (int) d;
    }

    /* renamed from: g */
    public final long m2548g(long j) {
        long j2 = this.f10237r;
        if (j2 != C0643C.TIME_UNSET) {
            return Util.scaleLargeTimestamp(j, j2, 1000L);
        }
        throw ParserException.createForMalformedContainer("Can't scale timecode prior to timecodeScale being set.", null);
    }

    public Track getCurrentTrack(int i) {
        m2544b(i);
        return this.f10240u;
    }

    @CallSuper
    public int getElementType(int i) {
        switch (i) {
            case 131:
            case 136:
            case 155:
            case 159:
            case CardPresenter.CARD_HEIGHT /* 176 */:
            case 179:
            case 186:
            case 215:
            case 231:
            case 238:
            case 241:
            case 251:
            case 16871:
            case 16980:
            case 17029:
            case 17143:
            case 18401:
            case 18408:
            case 20529:
            case 20530:
            case 21420:
            case 21432:
            case 21680:
            case 21682:
            case 21690:
            case 21930:
            case 21945:
            case 21946:
            case 21947:
            case 21948:
            case 21949:
            case 21998:
            case 22186:
            case 22203:
            case 25188:
            case 30114:
            case 30321:
            case 2352003:
            case 2807729:
                return 2;
            case TsExtractor.TS_STREAM_TYPE_SPLICE_INFO /* 134 */:
            case FirebaseError.ERROR_WEAK_PASSWORD /* 17026 */:
            case 21358:
            case 2274716:
                return 3;
            case 160:
            case 166:
            case 174:
            case 183:
            case 187:
            case 224:
            case 225:
            case 16868:
            case 18407:
            case 19899:
            case 20532:
            case 20533:
            case 21936:
            case 21968:
            case 25152:
            case 28032:
            case 30113:
            case 30320:
            case 290298740:
            case 357149030:
            case 374648427:
            case 408125543:
            case 440786851:
            case 475249515:
            case 524531317:
                return 1;
            case 161:
            case 163:
            case 165:
            case 16877:
            case 16981:
            case 18402:
            case 21419:
            case 25506:
            case 30322:
                return 4;
            case 181:
            case 17545:
            case 21969:
            case 21970:
            case 21971:
            case 21972:
            case 21973:
            case 21974:
            case 21975:
            case 21976:
            case 21977:
            case 21978:
            case 30323:
            case 30324:
            case 30325:
                return 5;
            default:
                return 0;
        }
    }

    /* renamed from: h */
    public final int m2549h(ExtractorInput extractorInput, Track track, int i, boolean z) {
        int sampleData;
        int sampleData2;
        boolean z2;
        boolean z3;
        int i2;
        if ("S_TEXT/UTF8".equals(track.codecId)) {
            m2550i(extractorInput, f10186c0, i);
            int i3 = this.f10211T;
            m2547f();
            return i3;
        }
        if ("S_TEXT/ASS".equals(track.codecId)) {
            m2550i(extractorInput, f10188e0, i);
            int i4 = this.f10211T;
            m2547f();
            return i4;
        }
        if ("S_TEXT/WEBVTT".equals(track.codecId)) {
            m2550i(extractorInput, f10189f0, i);
            int i5 = this.f10211T;
            m2547f();
            return i5;
        }
        TrackOutput trackOutput = track.output;
        boolean z4 = this.f10213V;
        boolean z5 = true;
        ParsableByteArray parsableByteArray = this.f10229j;
        if (!z4) {
            boolean z6 = track.hasContentEncryption;
            ParsableByteArray parsableByteArray2 = this.f10226g;
            if (z6) {
                this.f10206O &= -1073741825;
                int i6 = 128;
                if (!this.f10214W) {
                    extractorInput.readFully(parsableByteArray2.getData(), 0, 1);
                    this.f10210S++;
                    if ((parsableByteArray2.getData()[0] & 128) != 128) {
                        this.f10217Z = parsableByteArray2.getData()[0];
                        this.f10214W = true;
                    } else {
                        throw ParserException.createForMalformedContainer("Extension bit is set in signal byte", null);
                    }
                }
                byte b = this.f10217Z;
                if ((b & 1) == 1) {
                    if ((b & 2) == 2) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    this.f10206O |= 1073741824;
                    if (!this.f10219a0) {
                        ParsableByteArray parsableByteArray3 = this.f10231l;
                        extractorInput.readFully(parsableByteArray3.getData(), 0, 8);
                        this.f10210S += 8;
                        this.f10219a0 = true;
                        byte[] data = parsableByteArray2.getData();
                        if (!z3) {
                            i6 = 0;
                        }
                        data[0] = (byte) (i6 | 8);
                        parsableByteArray2.setPosition(0);
                        trackOutput.sampleData(parsableByteArray2, 1, 1);
                        this.f10211T++;
                        parsableByteArray3.setPosition(0);
                        trackOutput.sampleData(parsableByteArray3, 8, 1);
                        this.f10211T += 8;
                    }
                    if (z3) {
                        if (!this.f10215X) {
                            extractorInput.readFully(parsableByteArray2.getData(), 0, 1);
                            this.f10210S++;
                            parsableByteArray2.setPosition(0);
                            this.f10216Y = parsableByteArray2.readUnsignedByte();
                            this.f10215X = true;
                        }
                        int i7 = this.f10216Y * 4;
                        parsableByteArray2.reset(i7);
                        extractorInput.readFully(parsableByteArray2.getData(), 0, i7);
                        this.f10210S += i7;
                        short s = (short) ((this.f10216Y / 2) + 1);
                        int i8 = (s * 6) + 2;
                        ByteBuffer byteBuffer = this.f10234o;
                        if (byteBuffer == null || byteBuffer.capacity() < i8) {
                            this.f10234o = ByteBuffer.allocate(i8);
                        }
                        this.f10234o.position(0);
                        this.f10234o.putShort(s);
                        int i9 = 0;
                        int i10 = 0;
                        while (true) {
                            i2 = this.f10216Y;
                            if (i9 >= i2) {
                                break;
                            }
                            int readUnsignedIntToInt = parsableByteArray2.readUnsignedIntToInt();
                            if (i9 % 2 == 0) {
                                this.f10234o.putShort((short) (readUnsignedIntToInt - i10));
                            } else {
                                this.f10234o.putInt(readUnsignedIntToInt - i10);
                            }
                            i9++;
                            i10 = readUnsignedIntToInt;
                        }
                        int i11 = (i - this.f10210S) - i10;
                        if (i2 % 2 == 1) {
                            this.f10234o.putInt(i11);
                        } else {
                            this.f10234o.putShort((short) i11);
                            this.f10234o.putInt(0);
                        }
                        byte[] array = this.f10234o.array();
                        ParsableByteArray parsableByteArray4 = this.f10232m;
                        parsableByteArray4.reset(array, i8);
                        trackOutput.sampleData(parsableByteArray4, i8, 1);
                        this.f10211T += i8;
                    }
                }
            } else {
                byte[] bArr = track.sampleStrippedBytes;
                if (bArr != null) {
                    parsableByteArray.reset(bArr, bArr.length);
                }
            }
            if ("A_OPUS".equals(track.codecId)) {
                z2 = z;
            } else if (track.maxBlockAdditionId > 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2) {
                this.f10206O |= 268435456;
                this.f10233n.reset(0);
                int limit = (parsableByteArray.limit() + i) - this.f10210S;
                parsableByteArray2.reset(4);
                parsableByteArray2.getData()[0] = (byte) ((limit >> 24) & 255);
                parsableByteArray2.getData()[1] = (byte) ((limit >> 16) & 255);
                parsableByteArray2.getData()[2] = (byte) ((limit >> 8) & 255);
                parsableByteArray2.getData()[3] = (byte) (limit & 255);
                trackOutput.sampleData(parsableByteArray2, 4, 2);
                this.f10211T += 4;
            }
            this.f10213V = true;
        }
        int limit2 = parsableByteArray.limit() + i;
        if (!"V_MPEG4/ISO/AVC".equals(track.codecId) && !"V_MPEGH/ISO/HEVC".equals(track.codecId)) {
            if (track.trueHdSampleRechunker != null) {
                if (parsableByteArray.limit() != 0) {
                    z5 = false;
                }
                Assertions.checkState(z5);
                track.trueHdSampleRechunker.startSample(extractorInput);
            }
            while (true) {
                int i12 = this.f10210S;
                if (i12 >= limit2) {
                    break;
                }
                int i13 = limit2 - i12;
                int bytesLeft = parsableByteArray.bytesLeft();
                if (bytesLeft > 0) {
                    sampleData2 = Math.min(i13, bytesLeft);
                    trackOutput.sampleData(parsableByteArray, sampleData2);
                } else {
                    sampleData2 = trackOutput.sampleData((DataReader) extractorInput, i13, false);
                }
                this.f10210S += sampleData2;
                this.f10211T += sampleData2;
            }
        } else {
            ParsableByteArray parsableByteArray5 = this.f10225f;
            byte[] data2 = parsableByteArray5.getData();
            data2[0] = 0;
            data2[1] = 0;
            data2[2] = 0;
            int i14 = track.nalUnitLengthFieldLength;
            int i15 = 4 - i14;
            while (this.f10210S < limit2) {
                int i16 = this.f10212U;
                if (i16 == 0) {
                    int min = Math.min(i14, parsableByteArray.bytesLeft());
                    extractorInput.readFully(data2, i15 + min, i14 - min);
                    if (min > 0) {
                        parsableByteArray.readBytes(data2, i15, min);
                    }
                    this.f10210S += i14;
                    parsableByteArray5.setPosition(0);
                    this.f10212U = parsableByteArray5.readUnsignedIntToInt();
                    ParsableByteArray parsableByteArray6 = this.f10224e;
                    parsableByteArray6.setPosition(0);
                    trackOutput.sampleData(parsableByteArray6, 4);
                    this.f10211T += 4;
                } else {
                    int bytesLeft2 = parsableByteArray.bytesLeft();
                    if (bytesLeft2 > 0) {
                        sampleData = Math.min(i16, bytesLeft2);
                        trackOutput.sampleData(parsableByteArray, sampleData);
                    } else {
                        sampleData = trackOutput.sampleData((DataReader) extractorInput, i16, false);
                    }
                    this.f10210S += sampleData;
                    this.f10211T += sampleData;
                    this.f10212U -= sampleData;
                }
            }
        }
        if ("A_VORBIS".equals(track.codecId)) {
            ParsableByteArray parsableByteArray7 = this.f10227h;
            parsableByteArray7.setPosition(0);
            trackOutput.sampleData(parsableByteArray7, 4);
            this.f10211T += 4;
        }
        int i17 = this.f10211T;
        m2547f();
        return i17;
    }

    public void handleBlockAddIDExtraData(Track track, ExtractorInput extractorInput, int i) {
        int i2 = track.f10246a;
        if (i2 != 1685485123 && i2 != 1685480259) {
            extractorInput.skipFully(i);
            return;
        }
        byte[] bArr = new byte[i];
        track.dolbyVisionConfigBytes = bArr;
        extractorInput.readFully(bArr, 0, i);
    }

    public void handleBlockAdditionalData(Track track, int i, ExtractorInput extractorInput, int i2) {
        if (i == 4 && "V_VP9".equals(track.codecId)) {
            ParsableByteArray parsableByteArray = this.f10233n;
            parsableByteArray.reset(i2);
            extractorInput.readFully(parsableByteArray.getData(), 0, i2);
            return;
        }
        extractorInput.skipFully(i2);
    }

    /* renamed from: i */
    public final void m2550i(ExtractorInput extractorInput, byte[] bArr, int i) {
        int length = bArr.length + i;
        ParsableByteArray parsableByteArray = this.f10230k;
        if (parsableByteArray.capacity() < length) {
            parsableByteArray.reset(Arrays.copyOf(bArr, length + i));
        } else {
            System.arraycopy(bArr, 0, parsableByteArray.getData(), 0, bArr.length);
        }
        extractorInput.readFully(parsableByteArray.getData(), bArr.length, i);
        parsableByteArray.setPosition(0);
        parsableByteArray.setLimit(length);
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public final void init(ExtractorOutput extractorOutput) {
        this.f10221b0 = extractorOutput;
    }

    @CallSuper
    public void integerElement(int i, long j) {
        if (i != 20529) {
            if (i != 20530) {
                boolean z = false;
                switch (i) {
                    case 131:
                        getCurrentTrack(i).type = (int) j;
                        return;
                    case 136:
                        Track currentTrack = getCurrentTrack(i);
                        if (j == 1) {
                            z = true;
                        }
                        currentTrack.flagDefault = z;
                        return;
                    case 155:
                        this.f10200I = m2548g(j);
                        return;
                    case 159:
                        getCurrentTrack(i).channelCount = (int) j;
                        return;
                    case CardPresenter.CARD_HEIGHT /* 176 */:
                        getCurrentTrack(i).width = (int) j;
                        return;
                    case 179:
                        m2543a(i);
                        this.f10194C.add(m2548g(j));
                        return;
                    case 186:
                        getCurrentTrack(i).height = (int) j;
                        return;
                    case 215:
                        getCurrentTrack(i).number = (int) j;
                        return;
                    case 231:
                        this.f10193B = m2548g(j);
                        return;
                    case 238:
                        this.f10207P = (int) j;
                        return;
                    case 241:
                        if (!this.f10196E) {
                            m2543a(i);
                            this.f10195D.add(j);
                            this.f10196E = true;
                            return;
                        }
                        return;
                    case 251:
                        this.f10208Q = true;
                        return;
                    case 16871:
                        getCurrentTrack(i).f10246a = (int) j;
                        return;
                    case 16980:
                        if (j != 3) {
                            throw ParserException.createForMalformedContainer("ContentCompAlgo " + j + " not supported", null);
                        }
                        return;
                    case 17029:
                        if (j < 1 || j > 2) {
                            throw ParserException.createForMalformedContainer("DocTypeReadVersion " + j + " not supported", null);
                        }
                        return;
                    case 17143:
                        if (j != 1) {
                            throw ParserException.createForMalformedContainer("EBMLReadVersion " + j + " not supported", null);
                        }
                        return;
                    case 18401:
                        if (j != 5) {
                            throw ParserException.createForMalformedContainer("ContentEncAlgo " + j + " not supported", null);
                        }
                        return;
                    case 18408:
                        if (j != 1) {
                            throw ParserException.createForMalformedContainer("AESSettingsCipherMode " + j + " not supported", null);
                        }
                        return;
                    case 21420:
                        this.f10243x = j + this.f10236q;
                        return;
                    case 21432:
                        int i2 = (int) j;
                        m2544b(i);
                        if (i2 != 0) {
                            if (i2 != 1) {
                                if (i2 != 3) {
                                    if (i2 == 15) {
                                        this.f10240u.stereoMode = 3;
                                        return;
                                    }
                                    return;
                                }
                                this.f10240u.stereoMode = 1;
                                return;
                            }
                            this.f10240u.stereoMode = 2;
                            return;
                        }
                        this.f10240u.stereoMode = 0;
                        return;
                    case 21680:
                        getCurrentTrack(i).displayWidth = (int) j;
                        return;
                    case 21682:
                        getCurrentTrack(i).displayUnit = (int) j;
                        return;
                    case 21690:
                        getCurrentTrack(i).displayHeight = (int) j;
                        return;
                    case 21930:
                        Track currentTrack2 = getCurrentTrack(i);
                        if (j == 1) {
                            z = true;
                        }
                        currentTrack2.flagForced = z;
                        return;
                    case 21998:
                        getCurrentTrack(i).maxBlockAdditionId = (int) j;
                        return;
                    case 22186:
                        getCurrentTrack(i).codecDelayNs = j;
                        return;
                    case 22203:
                        getCurrentTrack(i).seekPreRollNs = j;
                        return;
                    case 25188:
                        getCurrentTrack(i).audioBitDepth = (int) j;
                        return;
                    case 30114:
                        this.f10209R = j;
                        return;
                    case 30321:
                        m2544b(i);
                        int i3 = (int) j;
                        if (i3 != 0) {
                            if (i3 != 1) {
                                if (i3 != 2) {
                                    if (i3 == 3) {
                                        this.f10240u.projectionType = 3;
                                        return;
                                    }
                                    return;
                                }
                                this.f10240u.projectionType = 2;
                                return;
                            }
                            this.f10240u.projectionType = 1;
                            return;
                        }
                        this.f10240u.projectionType = 0;
                        return;
                    case 2352003:
                        getCurrentTrack(i).defaultSampleDurationNs = (int) j;
                        return;
                    case 2807729:
                        this.f10237r = j;
                        return;
                    default:
                        switch (i) {
                            case 21945:
                                m2544b(i);
                                int i4 = (int) j;
                                if (i4 != 1) {
                                    if (i4 == 2) {
                                        this.f10240u.colorRange = 1;
                                        return;
                                    }
                                    return;
                                }
                                this.f10240u.colorRange = 2;
                                return;
                            case 21946:
                                m2544b(i);
                                int isoTransferCharacteristicsToColorTransfer = ColorInfo.isoTransferCharacteristicsToColorTransfer((int) j);
                                if (isoTransferCharacteristicsToColorTransfer != -1) {
                                    this.f10240u.colorTransfer = isoTransferCharacteristicsToColorTransfer;
                                    return;
                                }
                                return;
                            case 21947:
                                m2544b(i);
                                this.f10240u.hasColorInfo = true;
                                int isoColorPrimariesToColorSpace = ColorInfo.isoColorPrimariesToColorSpace((int) j);
                                if (isoColorPrimariesToColorSpace != -1) {
                                    this.f10240u.colorSpace = isoColorPrimariesToColorSpace;
                                    return;
                                }
                                return;
                            case 21948:
                                getCurrentTrack(i).maxContentLuminance = (int) j;
                                return;
                            case 21949:
                                getCurrentTrack(i).maxFrameAverageLuminance = (int) j;
                                return;
                            default:
                                return;
                        }
                }
            }
            if (j != 1) {
                throw ParserException.createForMalformedContainer("ContentEncodingScope " + j + " not supported", null);
            }
            return;
        }
        if (j == 0) {
            return;
        }
        throw ParserException.createForMalformedContainer("ContentEncodingOrder " + j + " not supported", null);
    }

    @CallSuper
    public boolean isLevel1Element(int i) {
        return i == 357149030 || i == 524531317 || i == 475249515 || i == 374648427;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x003c, code lost:
    
        r5 = true;
     */
    @Override // com.google.android.exoplayer2.extractor.Extractor
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int read(ExtractorInput extractorInput, PositionHolder positionHolder) {
        String str;
        double longBitsToDouble;
        int m4508b;
        int m4507a;
        int i = 0;
        this.f10197F = false;
        boolean z = true;
        while (z && !this.f10197F) {
            q00 q00Var = this.f10218a;
            Assertions.checkStateNotNull(q00Var.f25360d);
            while (true) {
                ArrayDeque arrayDeque = q00Var.f25358b;
                p00 p00Var = (p00) arrayDeque.peek();
                if (p00Var != null && extractorInput.getPosition() >= p00Var.f24971b) {
                    q00Var.f25360d.endMasterElement(((p00) arrayDeque.pop()).f24970a);
                    break;
                }
                int i2 = q00Var.f25361e;
                d13 d13Var = q00Var.f25359c;
                if (i2 == 0) {
                    long m4509c = d13Var.m4509c(extractorInput, true, false, 4);
                    if (m4509c == -2) {
                        extractorInput.resetPeekPosition();
                        while (true) {
                            byte[] bArr = q00Var.f25357a;
                            extractorInput.peekFully(bArr, 0, 4);
                            m4508b = d13.m4508b(bArr[0]);
                            if (m4508b != -1 && m4508b <= 4) {
                                m4507a = (int) d13.m4507a(bArr, m4508b, false);
                                if (((MatroskaExtractor) q00Var.f25360d.f7833b).isLevel1Element(m4507a)) {
                                    break;
                                }
                            }
                            extractorInput.skipFully(1);
                        }
                        extractorInput.skipFully(m4508b);
                        m4509c = m4507a;
                    }
                    if (m4509c == -1) {
                        z = false;
                        break;
                    }
                    q00Var.f25362f = (int) m4509c;
                    q00Var.f25361e = 1;
                }
                if (q00Var.f25361e == 1) {
                    q00Var.f25363g = d13Var.m4509c(extractorInput, false, true, 8);
                    q00Var.f25361e = 2;
                }
                int elementType = ((MatroskaExtractor) q00Var.f25360d.f7833b).getElementType(q00Var.f25362f);
                if (elementType != 0) {
                    if (elementType != 1) {
                        if (elementType != 2) {
                            if (elementType != 3) {
                                if (elementType != 4) {
                                    if (elementType == 5) {
                                        long j = q00Var.f25363g;
                                        if (j != 4 && j != 8) {
                                            throw ParserException.createForMalformedContainer("Invalid float size: " + q00Var.f25363g, null);
                                        }
                                        b01 b01Var = q00Var.f25360d;
                                        int i3 = q00Var.f25362f;
                                        int i4 = (int) j;
                                        long m6941a = q00Var.m6941a(extractorInput, i4);
                                        if (i4 == 4) {
                                            longBitsToDouble = Float.intBitsToFloat((int) m6941a);
                                        } else {
                                            longBitsToDouble = Double.longBitsToDouble(m6941a);
                                        }
                                        b01Var.floatElement(i3, longBitsToDouble);
                                        q00Var.f25361e = 0;
                                    } else {
                                        throw ParserException.createForMalformedContainer("Invalid element type " + elementType, null);
                                    }
                                } else {
                                    q00Var.f25360d.binaryElement(q00Var.f25362f, (int) q00Var.f25363g, extractorInput);
                                    q00Var.f25361e = 0;
                                }
                            } else {
                                long j2 = q00Var.f25363g;
                                if (j2 <= 2147483647L) {
                                    b01 b01Var2 = q00Var.f25360d;
                                    int i5 = q00Var.f25362f;
                                    int i6 = (int) j2;
                                    if (i6 == 0) {
                                        str = "";
                                    } else {
                                        byte[] bArr2 = new byte[i6];
                                        extractorInput.readFully(bArr2, 0, i6);
                                        while (i6 > 0 && bArr2[i6 - 1] == 0) {
                                            i6--;
                                        }
                                        str = new String(bArr2, 0, i6);
                                    }
                                    b01Var2.stringElement(i5, str);
                                    q00Var.f25361e = 0;
                                } else {
                                    throw ParserException.createForMalformedContainer("String element size: " + q00Var.f25363g, null);
                                }
                            }
                        } else {
                            long j3 = q00Var.f25363g;
                            if (j3 <= 8) {
                                q00Var.f25360d.integerElement(q00Var.f25362f, q00Var.m6941a(extractorInput, (int) j3));
                                q00Var.f25361e = 0;
                            } else {
                                throw ParserException.createForMalformedContainer("Invalid integer size: " + q00Var.f25363g, null);
                            }
                        }
                    } else {
                        long position = extractorInput.getPosition();
                        arrayDeque.push(new p00(q00Var.f25362f, q00Var.f25363g + position));
                        q00Var.f25360d.startMasterElement(q00Var.f25362f, position, q00Var.f25363g);
                        q00Var.f25361e = 0;
                    }
                } else {
                    extractorInput.skipFully((int) q00Var.f25363g);
                    q00Var.f25361e = 0;
                }
            }
            if (z) {
                long position2 = extractorInput.getPosition();
                if (this.f10244y) {
                    this.f10192A = position2;
                    positionHolder.position = this.f10245z;
                    this.f10244y = false;
                } else if (this.f10241v) {
                    long j4 = this.f10192A;
                    if (j4 != -1) {
                        positionHolder.position = j4;
                        this.f10192A = -1L;
                    }
                } else {
                    continue;
                }
                return 1;
            }
        }
        if (z) {
            return 0;
        }
        while (true) {
            SparseArray sparseArray = this.f10222c;
            if (i >= sparseArray.size()) {
                return -1;
            }
            Track track = (Track) sparseArray.valueAt(i);
            Assertions.checkNotNull(track.output);
            track.outputPendingSampleMetadata();
            i++;
        }
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public final void release() {
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    @CallSuper
    public void seek(long j, long j2) {
        this.f10193B = C0643C.TIME_UNSET;
        int i = 0;
        this.f10198G = 0;
        q00 q00Var = this.f10218a;
        q00Var.f25361e = 0;
        q00Var.f25358b.clear();
        d13 d13Var = q00Var.f25359c;
        d13Var.f16214a = 0;
        d13Var.f16215b = 0;
        d13 d13Var2 = this.f10220b;
        d13Var2.f16214a = 0;
        d13Var2.f16215b = 0;
        m2547f();
        while (true) {
            SparseArray sparseArray = this.f10222c;
            if (i < sparseArray.size()) {
                ((Track) sparseArray.valueAt(i)).reset();
                i++;
            } else {
                return;
            }
        }
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public final boolean sniff(ExtractorInput extractorInput) {
        C1582ne c1582ne = new C1582ne(3);
        long length = extractorInput.getLength();
        long j = 1024;
        if (length != -1 && length <= 1024) {
            j = length;
        }
        int i = (int) j;
        ParsableByteArray parsableByteArray = (ParsableByteArray) c1582ne.f23337b;
        extractorInput.peekFully(parsableByteArray.getData(), 0, 4);
        c1582ne.f23336a = 4;
        for (long readUnsignedInt = parsableByteArray.readUnsignedInt(); readUnsignedInt != 440786851; readUnsignedInt = ((readUnsignedInt << 8) & (-256)) | (parsableByteArray.getData()[0] & 255)) {
            int i2 = c1582ne.f23336a + 1;
            c1582ne.f23336a = i2;
            if (i2 == i) {
                return false;
            }
            extractorInput.peekFully(parsableByteArray.getData(), 0, 1);
        }
        long m6344c = c1582ne.m6344c(extractorInput);
        long j2 = c1582ne.f23336a;
        if (m6344c == Long.MIN_VALUE) {
            return false;
        }
        if (length != -1 && j2 + m6344c >= length) {
            return false;
        }
        while (true) {
            long j3 = c1582ne.f23336a;
            long j4 = j2 + m6344c;
            if (j3 < j4) {
                if (c1582ne.m6344c(extractorInput) == Long.MIN_VALUE) {
                    return false;
                }
                long m6344c2 = c1582ne.m6344c(extractorInput);
                if (m6344c2 < 0 || m6344c2 > 2147483647L) {
                    return false;
                }
                if (m6344c2 != 0) {
                    int i3 = (int) m6344c2;
                    extractorInput.advancePeekPosition(i3);
                    c1582ne.f23336a += i3;
                }
            } else {
                if (j3 != j4) {
                    return false;
                }
                return true;
            }
        }
    }

    @CallSuper
    public void startMasterElement(int i, long j, long j2) {
        Assertions.checkStateNotNull(this.f10221b0);
        if (i != 160) {
            if (i != 174) {
                if (i != 187) {
                    if (i != 19899) {
                        if (i != 20533) {
                            if (i != 21968) {
                                if (i != 408125543) {
                                    if (i != 475249515) {
                                        if (i == 524531317 && !this.f10241v) {
                                            if (this.f10223d && this.f10245z != -1) {
                                                this.f10244y = true;
                                                return;
                                            } else {
                                                this.f10221b0.seekMap(new SeekMap.Unseekable(this.f10239t));
                                                this.f10241v = true;
                                                return;
                                            }
                                        }
                                        return;
                                    }
                                    this.f10194C = new LongArray();
                                    this.f10195D = new LongArray();
                                    return;
                                }
                                long j3 = this.f10236q;
                                if (j3 != -1 && j3 != j) {
                                    throw ParserException.createForMalformedContainer("Multiple Segment elements not supported", null);
                                }
                                this.f10236q = j;
                                this.f10235p = j2;
                                return;
                            }
                            getCurrentTrack(i).hasColorInfo = true;
                            return;
                        }
                        getCurrentTrack(i).hasContentEncryption = true;
                        return;
                    }
                    this.f10242w = -1;
                    this.f10243x = -1L;
                    return;
                }
                this.f10196E = false;
                return;
            }
            this.f10240u = new Track();
            return;
        }
        this.f10208Q = false;
        this.f10209R = 0L;
    }

    @CallSuper
    public void stringElement(int i, String str) {
        if (i != 134) {
            if (i != 17026) {
                if (i != 21358) {
                    if (i == 2274716) {
                        getCurrentTrack(i).f10247b = str;
                        return;
                    }
                    return;
                }
                getCurrentTrack(i).name = str;
                return;
            }
            if (!"webm".equals(str) && !"matroska".equals(str)) {
                throw ParserException.createForMalformedContainer("DocType " + str + " not supported", null);
            }
            return;
        }
        getCurrentTrack(i).codecId = str;
    }

    public MatroskaExtractor(int i) {
        q00 q00Var = new q00();
        this.f10236q = -1L;
        this.f10237r = C0643C.TIME_UNSET;
        this.f10238s = C0643C.TIME_UNSET;
        this.f10239t = C0643C.TIME_UNSET;
        this.f10245z = -1L;
        this.f10192A = -1L;
        this.f10193B = C0643C.TIME_UNSET;
        this.f10218a = q00Var;
        q00Var.f25360d = new b01(22, this);
        this.f10223d = (i & 1) == 0;
        this.f10220b = new d13();
        this.f10222c = new SparseArray();
        this.f10226g = new ParsableByteArray(4);
        this.f10227h = new ParsableByteArray(ByteBuffer.allocate(4).putInt(-1).array());
        this.f10228i = new ParsableByteArray(4);
        this.f10224e = new ParsableByteArray(NalUnitUtil.NAL_START_CODE);
        this.f10225f = new ParsableByteArray(4);
        this.f10229j = new ParsableByteArray();
        this.f10230k = new ParsableByteArray();
        this.f10231l = new ParsableByteArray(8);
        this.f10232m = new ParsableByteArray();
        this.f10233n = new ParsableByteArray();
        this.f10203L = new int[1];
    }
}
