package com.google.android.exoplayer2.video;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Point;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.util.Pair;
import android.view.Surface;
import androidx.annotation.CallSuper;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.google.android.exoplayer2.C0643C;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.FormatHolder;
import com.google.android.exoplayer2.decoder.DecoderCounters;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.decoder.DecoderReuseEvaluation;
import com.google.android.exoplayer2.extractor.p002ts.TsExtractor;
import com.google.android.exoplayer2.mediacodec.MediaCodecAdapter;
import com.google.android.exoplayer2.mediacodec.MediaCodecDecoderException;
import com.google.android.exoplayer2.mediacodec.MediaCodecInfo;
import com.google.android.exoplayer2.mediacodec.MediaCodecRenderer;
import com.google.android.exoplayer2.mediacodec.MediaCodecSelector;
import com.google.android.exoplayer2.mediacodec.MediaCodecUtil;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.MediaFormatUtil;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.TraceUtil;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.video.VideoRendererEventListener;
import com.google.android.gms.common.Scopes;
import com.google.common.base.Ascii;
import com.google.common.collect.ImmutableList;
import java.nio.ByteBuffer;
import java.util.Collection;
import java.util.List;
import kotlin.text.Typography;
import p000.gl1;
import p000.qa2;

/* loaded from: classes.dex */
public class MediaCodecVideoRenderer extends MediaCodecRenderer {

    /* renamed from: o1 */
    public static final int[] f12828o1 = {1920, 1600, 1440, 1280, 960, 854, 640, 540, 480};

    /* renamed from: p1 */
    public static boolean f12829p1;

    /* renamed from: q1 */
    public static boolean f12830q1;

    /* renamed from: F0 */
    public final Context f12831F0;

    /* renamed from: G0 */
    public final VideoFrameReleaseHelper f12832G0;

    /* renamed from: H0 */
    public final VideoRendererEventListener.EventDispatcher f12833H0;

    /* renamed from: I0 */
    public final long f12834I0;

    /* renamed from: J0 */
    public final int f12835J0;

    /* renamed from: K0 */
    public final boolean f12836K0;

    /* renamed from: L0 */
    public CodecMaxValues f12837L0;

    /* renamed from: M0 */
    public boolean f12838M0;

    /* renamed from: N0 */
    public boolean f12839N0;

    /* renamed from: O0 */
    public Surface f12840O0;

    /* renamed from: P0 */
    public PlaceholderSurface f12841P0;

    /* renamed from: Q0 */
    public boolean f12842Q0;

    /* renamed from: R0 */
    public int f12843R0;

    /* renamed from: S0 */
    public boolean f12844S0;

    /* renamed from: T0 */
    public boolean f12845T0;

    /* renamed from: U0 */
    public boolean f12846U0;

    /* renamed from: V0 */
    public long f12847V0;

    /* renamed from: W0 */
    public long f12848W0;

    /* renamed from: X0 */
    public long f12849X0;

    /* renamed from: Y0 */
    public int f12850Y0;

    /* renamed from: Z0 */
    public int f12851Z0;

    /* renamed from: a1 */
    public int f12852a1;

    /* renamed from: b1 */
    public long f12853b1;

    /* renamed from: c1 */
    public long f12854c1;

    /* renamed from: d1 */
    public long f12855d1;

    /* renamed from: e1 */
    public int f12856e1;

    /* renamed from: f1 */
    public int f12857f1;

    /* renamed from: g1 */
    public int f12858g1;

    /* renamed from: h1 */
    public int f12859h1;

    /* renamed from: i1 */
    public float f12860i1;

    /* renamed from: j1 */
    public VideoSize f12861j1;

    /* renamed from: k1 */
    public boolean f12862k1;

    /* renamed from: l1 */
    public int f12863l1;

    /* renamed from: m1 */
    public gl1 f12864m1;

    /* renamed from: n1 */
    public VideoFrameMetadataListener f12865n1;

    /* loaded from: classes.dex */
    public static final class CodecMaxValues {
        public final int height;
        public final int inputSize;
        public final int width;

        public CodecMaxValues(int i, int i2, int i3) {
            this.width = i;
            this.height = i2;
            this.inputSize = i3;
        }
    }

    public MediaCodecVideoRenderer(Context context, MediaCodecSelector mediaCodecSelector) {
        this(context, mediaCodecSelector, 0L);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x007b, code lost:
    
        if (r9.equals(com.google.android.exoplayer2.util.MimeTypes.VIDEO_AV1) == false) goto L18;
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:17:0x0088. Please report as an issue. */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int getCodecMaxInputSize(MediaCodecInfo mediaCodecInfo, Format format) {
        int i;
        int intValue;
        int i2 = 4;
        char c = 1;
        int i3 = format.width;
        int i4 = format.height;
        if (i3 == -1 || i4 == -1) {
            return -1;
        }
        String str = format.sampleMimeType;
        if (MimeTypes.VIDEO_DOLBY_VISION.equals(str)) {
            Pair<Integer, Integer> codecProfileAndLevel = MediaCodecUtil.getCodecProfileAndLevel(format);
            if (codecProfileAndLevel != null && ((intValue = ((Integer) codecProfileAndLevel.first).intValue()) == 512 || intValue == 1 || intValue == 2)) {
                str = MimeTypes.VIDEO_H264;
            } else {
                str = MimeTypes.VIDEO_H265;
            }
        }
        str.getClass();
        switch (str.hashCode()) {
            case -1664118616:
                if (str.equals(MimeTypes.VIDEO_H263)) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            case -1662735862:
                break;
            case -1662541442:
                if (str.equals(MimeTypes.VIDEO_H265)) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            case 1187890754:
                if (str.equals(MimeTypes.VIDEO_MP4V)) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            case 1331836730:
                if (str.equals(MimeTypes.VIDEO_H264)) {
                    c = 4;
                    break;
                }
                c = 65535;
                break;
            case 1599127256:
                if (str.equals(MimeTypes.VIDEO_VP8)) {
                    c = 5;
                    break;
                }
                c = 65535;
                break;
            case 1599127257:
                if (str.equals(MimeTypes.VIDEO_VP9)) {
                    c = 6;
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
            case 3:
            case 5:
                i = i3 * i4;
                i2 = 2;
                return (i * 3) / (i2 * 2);
            case 2:
            case 6:
                i = i3 * i4;
                return (i * 3) / (i2 * 2);
            case 4:
                String str2 = Util.MODEL;
                if ("BRAVIA 4K 2015".equals(str2) || ("Amazon".equals(Util.MANUFACTURER) && ("KFSOWI".equals(str2) || ("AFTS".equals(str2) && mediaCodecInfo.secure)))) {
                    return -1;
                }
                i = Util.ceilDivide(i4, 16) * Util.ceilDivide(i3, 16) * 256;
                i2 = 2;
                return (i * 3) / (i2 * 2);
            default:
                return -1;
        }
    }

    public static int getMaxInputSize(MediaCodecInfo mediaCodecInfo, Format format) {
        if (format.maxInputSize != -1) {
            int size = format.initializationData.size();
            int i = 0;
            for (int i2 = 0; i2 < size; i2++) {
                i += format.initializationData.get(i2).length;
            }
            return format.maxInputSize + i;
        }
        return getCodecMaxInputSize(mediaCodecInfo, format);
    }

    /* renamed from: r */
    public static ImmutableList m3057r(MediaCodecSelector mediaCodecSelector, Format format, boolean z, boolean z2) {
        String str = format.sampleMimeType;
        if (str == null) {
            return ImmutableList.m3902of();
        }
        List<MediaCodecInfo> decoderInfos = mediaCodecSelector.getDecoderInfos(str, z, z2);
        String alternativeCodecMimeType = MediaCodecUtil.getAlternativeCodecMimeType(format);
        if (alternativeCodecMimeType == null) {
            return ImmutableList.copyOf((Collection) decoderInfos);
        }
        return ImmutableList.builder().addAll((Iterable) decoderInfos).addAll((Iterable) mediaCodecSelector.getDecoderInfos(alternativeCodecMimeType, z, z2)).build();
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public DecoderReuseEvaluation canReuseCodec(MediaCodecInfo mediaCodecInfo, Format format, Format format2) {
        int i;
        DecoderReuseEvaluation canReuseCodec = mediaCodecInfo.canReuseCodec(format, format2);
        int i2 = canReuseCodec.discardReasons;
        int i3 = format2.width;
        CodecMaxValues codecMaxValues = this.f12837L0;
        if (i3 > codecMaxValues.width || format2.height > codecMaxValues.height) {
            i2 |= 256;
        }
        if (getMaxInputSize(mediaCodecInfo, format2) > this.f12837L0.inputSize) {
            i2 |= 64;
        }
        int i4 = i2;
        String str = mediaCodecInfo.name;
        if (i4 != 0) {
            i = 0;
        } else {
            i = canReuseCodec.result;
        }
        return new DecoderReuseEvaluation(str, format, format2, i, i4);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:406:0x06d9, code lost:
    
        if (r13.equals("A10-70L") == false) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x084f, code lost:
    
        if (r0.equals("AFTN") == false) goto L622;
     */
    /* JADX WARN: Removed duplicated region for block: B:17:0x008f A[FALL_THROUGH] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean codecNeedsSetOutputSurfaceWorkaround(String str) {
        boolean z;
        char c = 26;
        char c2 = 2;
        boolean z2 = false;
        if (str.startsWith("OMX.google")) {
            return false;
        }
        synchronized (MediaCodecVideoRenderer.class) {
            try {
                if (!f12829p1) {
                    int i = Util.SDK_INT;
                    if (i <= 28) {
                        String str2 = Util.DEVICE;
                        str2.getClass();
                        switch (str2.hashCode()) {
                            case -1339091551:
                                if (str2.equals("dangal")) {
                                    z = false;
                                    break;
                                }
                                z = -1;
                                break;
                            case -1220081023:
                                if (str2.equals("dangalFHD")) {
                                    z = true;
                                    break;
                                }
                                z = -1;
                                break;
                            case -1220066608:
                                if (str2.equals("dangalUHD")) {
                                    z = 2;
                                    break;
                                }
                                z = -1;
                                break;
                            case -1012436106:
                                if (str2.equals("oneday")) {
                                    z = 3;
                                    break;
                                }
                                z = -1;
                                break;
                            case -760312546:
                                if (str2.equals("aquaman")) {
                                    z = 4;
                                    break;
                                }
                                z = -1;
                                break;
                            case -64886864:
                                if (str2.equals("magnolia")) {
                                    z = 5;
                                    break;
                                }
                                z = -1;
                                break;
                            case 3415681:
                                if (str2.equals("once")) {
                                    z = 6;
                                    break;
                                }
                                z = -1;
                                break;
                            case 825323514:
                                if (str2.equals("machuca")) {
                                    z = 7;
                                    break;
                                }
                                z = -1;
                                break;
                            default:
                                z = -1;
                                break;
                        }
                        switch (z) {
                            case false:
                            case true:
                            case true:
                            case true:
                            case true:
                            case true:
                            case true:
                            case true:
                                z2 = true;
                                break;
                        }
                        f12830q1 = z2;
                        f12829p1 = true;
                    }
                    if (i > 27 || !"HWEML".equals(Util.DEVICE)) {
                        if (i <= 26) {
                            String str3 = Util.DEVICE;
                            str3.getClass();
                            switch (str3.hashCode()) {
                                case -2144781245:
                                    if (str3.equals("GIONEE_SWW1609")) {
                                        c = 0;
                                        break;
                                    }
                                    c = 65535;
                                    break;
                                case -2144781185:
                                    if (str3.equals("GIONEE_SWW1627")) {
                                        c = 1;
                                        break;
                                    }
                                    c = 65535;
                                    break;
                                case -2144781160:
                                    if (str3.equals("GIONEE_SWW1631")) {
                                        c = 2;
                                        break;
                                    }
                                    c = 65535;
                                    break;
                                case -2097309513:
                                    if (str3.equals("K50a40")) {
                                        c = 3;
                                        break;
                                    }
                                    c = 65535;
                                    break;
                                case -2022874474:
                                    if (str3.equals("CP8676_I02")) {
                                        c = 4;
                                        break;
                                    }
                                    c = 65535;
                                    break;
                                case -1978993182:
                                    if (str3.equals("NX541J")) {
                                        c = 5;
                                        break;
                                    }
                                    c = 65535;
                                    break;
                                case -1978990237:
                                    if (str3.equals("NX573J")) {
                                        c = 6;
                                        break;
                                    }
                                    c = 65535;
                                    break;
                                case -1936688988:
                                    if (str3.equals("PGN528")) {
                                        c = 7;
                                        break;
                                    }
                                    c = 65535;
                                    break;
                                case -1936688066:
                                    if (str3.equals("PGN610")) {
                                        c = '\b';
                                        break;
                                    }
                                    c = 65535;
                                    break;
                                case -1936688065:
                                    if (str3.equals("PGN611")) {
                                        c = '\t';
                                        break;
                                    }
                                    c = 65535;
                                    break;
                                case -1931988508:
                                    if (str3.equals("AquaPowerM")) {
                                        c = '\n';
                                        break;
                                    }
                                    c = 65535;
                                    break;
                                case -1885099851:
                                    if (str3.equals("RAIJIN")) {
                                        c = 11;
                                        break;
                                    }
                                    c = 65535;
                                    break;
                                case -1696512866:
                                    if (str3.equals("XT1663")) {
                                        c = '\f';
                                        break;
                                    }
                                    c = 65535;
                                    break;
                                case -1680025915:
                                    if (str3.equals("ComioS1")) {
                                        c = '\r';
                                        break;
                                    }
                                    c = 65535;
                                    break;
                                case -1615810839:
                                    if (str3.equals("Phantom6")) {
                                        c = 14;
                                        break;
                                    }
                                    c = 65535;
                                    break;
                                case -1600724499:
                                    if (str3.equals("pacificrim")) {
                                        c = 15;
                                        break;
                                    }
                                    c = 65535;
                                    break;
                                case -1554255044:
                                    if (str3.equals("vernee_M5")) {
                                        c = 16;
                                        break;
                                    }
                                    c = 65535;
                                    break;
                                case -1481772737:
                                    if (str3.equals("panell_dl")) {
                                        c = 17;
                                        break;
                                    }
                                    c = 65535;
                                    break;
                                case -1481772730:
                                    if (str3.equals("panell_ds")) {
                                        c = 18;
                                        break;
                                    }
                                    c = 65535;
                                    break;
                                case -1481772729:
                                    if (str3.equals("panell_dt")) {
                                        c = 19;
                                        break;
                                    }
                                    c = 65535;
                                    break;
                                case -1320080169:
                                    if (str3.equals("GiONEE_GBL7319")) {
                                        c = 20;
                                        break;
                                    }
                                    c = 65535;
                                    break;
                                case -1217592143:
                                    if (str3.equals("BRAVIA_ATV2")) {
                                        c = 21;
                                        break;
                                    }
                                    c = 65535;
                                    break;
                                case -1180384755:
                                    if (str3.equals("iris60")) {
                                        c = 22;
                                        break;
                                    }
                                    c = 65535;
                                    break;
                                case -1139198265:
                                    if (str3.equals("Slate_Pro")) {
                                        c = 23;
                                        break;
                                    }
                                    c = 65535;
                                    break;
                                case -1052835013:
                                    if (str3.equals("namath")) {
                                        c = 24;
                                        break;
                                    }
                                    c = 65535;
                                    break;
                                case -993250464:
                                    if (str3.equals("A10-70F")) {
                                        c = 25;
                                        break;
                                    }
                                    c = 65535;
                                    break;
                                case -993250458:
                                    break;
                                case -965403638:
                                    if (str3.equals("s905x018")) {
                                        c = 27;
                                        break;
                                    }
                                    c = 65535;
                                    break;
                                case -958336948:
                                    if (str3.equals("ELUGA_Ray_X")) {
                                        c = 28;
                                        break;
                                    }
                                    c = 65535;
                                    break;
                                case -879245230:
                                    if (str3.equals("tcl_eu")) {
                                        c = 29;
                                        break;
                                    }
                                    c = 65535;
                                    break;
                                case -842500323:
                                    if (str3.equals("nicklaus_f")) {
                                        c = 30;
                                        break;
                                    }
                                    c = 65535;
                                    break;
                                case -821392978:
                                    if (str3.equals("A7000-a")) {
                                        c = 31;
                                        break;
                                    }
                                    c = 65535;
                                    break;
                                case -797483286:
                                    if (str3.equals("SVP-DTV15")) {
                                        c = ' ';
                                        break;
                                    }
                                    c = 65535;
                                    break;
                                case -794946968:
                                    if (str3.equals("watson")) {
                                        c = '!';
                                        break;
                                    }
                                    c = 65535;
                                    break;
                                case -788334647:
                                    if (str3.equals("whyred")) {
                                        c = Typography.quote;
                                        break;
                                    }
                                    c = 65535;
                                    break;
                                case -782144577:
                                    if (str3.equals("OnePlus5T")) {
                                        c = '#';
                                        break;
                                    }
                                    c = 65535;
                                    break;
                                case -575125681:
                                    if (str3.equals("GiONEE_CBL7513")) {
                                        c = Typography.dollar;
                                        break;
                                    }
                                    c = 65535;
                                    break;
                                case -521118391:
                                    if (str3.equals("GIONEE_GBL7360")) {
                                        c = '%';
                                        break;
                                    }
                                    c = 65535;
                                    break;
                                case -430914369:
                                    if (str3.equals("Pixi4-7_3G")) {
                                        c = Typography.amp;
                                        break;
                                    }
                                    c = 65535;
                                    break;
                                case -290434366:
                                    if (str3.equals("taido_row")) {
                                        c = '\'';
                                        break;
                                    }
                                    c = 65535;
                                    break;
                                case -282781963:
                                    if (str3.equals("BLACK-1X")) {
                                        c = '(';
                                        break;
                                    }
                                    c = 65535;
                                    break;
                                case -277133239:
                                    if (str3.equals("Z12_PRO")) {
                                        c = ')';
                                        break;
                                    }
                                    c = 65535;
                                    break;
                                case -173639913:
                                    if (str3.equals("ELUGA_A3_Pro")) {
                                        c = '*';
                                        break;
                                    }
                                    c = 65535;
                                    break;
                                case -56598463:
                                    if (str3.equals("woods_fn")) {
                                        c = '+';
                                        break;
                                    }
                                    c = 65535;
                                    break;
                                case 2126:
                                    if (str3.equals("C1")) {
                                        c = ',';
                                        break;
                                    }
                                    c = 65535;
                                    break;
                                case 2564:
                                    if (str3.equals("Q5")) {
                                        c = '-';
                                        break;
                                    }
                                    c = 65535;
                                    break;
                                case 2715:
                                    if (str3.equals("V1")) {
                                        c = '.';
                                        break;
                                    }
                                    c = 65535;
                                    break;
                                case 2719:
                                    if (str3.equals("V5")) {
                                        c = '/';
                                        break;
                                    }
                                    c = 65535;
                                    break;
                                case 3091:
                                    if (str3.equals("b5")) {
                                        c = '0';
                                        break;
                                    }
                                    c = 65535;
                                    break;
                                case 3483:
                                    if (str3.equals("mh")) {
                                        c = '1';
                                        break;
                                    }
                                    c = 65535;
                                    break;
                                case 73405:
                                    if (str3.equals("JGZ")) {
                                        c = '2';
                                        break;
                                    }
                                    c = 65535;
                                    break;
                                case 75537:
                                    if (str3.equals("M04")) {
                                        c = '3';
                                        break;
                                    }
                                    c = 65535;
                                    break;
                                case 75739:
                                    if (str3.equals("M5c")) {
                                        c = '4';
                                        break;
                                    }
                                    c = 65535;
                                    break;
                                case 76779:
                                    if (str3.equals("MX6")) {
                                        c = '5';
                                        break;
                                    }
                                    c = 65535;
                                    break;
                                case 78669:
                                    if (str3.equals("P85")) {
                                        c = '6';
                                        break;
                                    }
                                    c = 65535;
                                    break;
                                case 79305:
                                    if (str3.equals("PLE")) {
                                        c = '7';
                                        break;
                                    }
                                    c = 65535;
                                    break;
                                case 80618:
                                    if (str3.equals("QX1")) {
                                        c = '8';
                                        break;
                                    }
                                    c = 65535;
                                    break;
                                case 88274:
                                    if (str3.equals("Z80")) {
                                        c = '9';
                                        break;
                                    }
                                    c = 65535;
                                    break;
                                case 98846:
                                    if (str3.equals("cv1")) {
                                        c = ':';
                                        break;
                                    }
                                    c = 65535;
                                    break;
                                case 98848:
                                    if (str3.equals("cv3")) {
                                        c = ';';
                                        break;
                                    }
                                    c = 65535;
                                    break;
                                case 99329:
                                    if (str3.equals("deb")) {
                                        c = Typography.less;
                                        break;
                                    }
                                    c = 65535;
                                    break;
                                case 101481:
                                    if (str3.equals("flo")) {
                                        c = '=';
                                        break;
                                    }
                                    c = 65535;
                                    break;
                                case 1513190:
                                    if (str3.equals("1601")) {
                                        c = Typography.greater;
                                        break;
                                    }
                                    c = 65535;
                                    break;
                                case 1514184:
                                    if (str3.equals("1713")) {
                                        c = '?';
                                        break;
                                    }
                                    c = 65535;
                                    break;
                                case 1514185:
                                    if (str3.equals("1714")) {
                                        c = '@';
                                        break;
                                    }
                                    c = 65535;
                                    break;
                                case 2133089:
                                    if (str3.equals("F01H")) {
                                        c = 'A';
                                        break;
                                    }
                                    c = 65535;
                                    break;
                                case 2133091:
                                    if (str3.equals("F01J")) {
                                        c = 'B';
                                        break;
                                    }
                                    c = 65535;
                                    break;
                                case 2133120:
                                    if (str3.equals("F02H")) {
                                        c = 'C';
                                        break;
                                    }
                                    c = 65535;
                                    break;
                                case 2133151:
                                    if (str3.equals("F03H")) {
                                        c = 'D';
                                        break;
                                    }
                                    c = 65535;
                                    break;
                                case 2133182:
                                    if (str3.equals("F04H")) {
                                        c = 'E';
                                        break;
                                    }
                                    c = 65535;
                                    break;
                                case 2133184:
                                    if (str3.equals("F04J")) {
                                        c = 'F';
                                        break;
                                    }
                                    c = 65535;
                                    break;
                                case 2436959:
                                    if (str3.equals("P681")) {
                                        c = 'G';
                                        break;
                                    }
                                    c = 65535;
                                    break;
                                case 2463773:
                                    if (str3.equals("Q350")) {
                                        c = 'H';
                                        break;
                                    }
                                    c = 65535;
                                    break;
                                case 2464648:
                                    if (str3.equals("Q427")) {
                                        c = 'I';
                                        break;
                                    }
                                    c = 65535;
                                    break;
                                case 2689555:
                                    if (str3.equals("XE2X")) {
                                        c = 'J';
                                        break;
                                    }
                                    c = 65535;
                                    break;
                                case 3154429:
                                    if (str3.equals("fugu")) {
                                        c = 'K';
                                        break;
                                    }
                                    c = 65535;
                                    break;
                                case 3284551:
                                    if (str3.equals("kate")) {
                                        c = 'L';
                                        break;
                                    }
                                    c = 65535;
                                    break;
                                case 3351335:
                                    if (str3.equals("mido")) {
                                        c = 'M';
                                        break;
                                    }
                                    c = 65535;
                                    break;
                                case 3386211:
                                    if (str3.equals("p212")) {
                                        c = 'N';
                                        break;
                                    }
                                    c = 65535;
                                    break;
                                case 41325051:
                                    if (str3.equals("MEIZU_M5")) {
                                        c = 'O';
                                        break;
                                    }
                                    c = 65535;
                                    break;
                                case 51349633:
                                    if (str3.equals("601LV")) {
                                        c = 'P';
                                        break;
                                    }
                                    c = 65535;
                                    break;
                                case 51350594:
                                    if (str3.equals("602LV")) {
                                        c = 'Q';
                                        break;
                                    }
                                    c = 65535;
                                    break;
                                case 55178625:
                                    if (str3.equals("Aura_Note_2")) {
                                        c = 'R';
                                        break;
                                    }
                                    c = 65535;
                                    break;
                                case 61542055:
                                    if (str3.equals("A1601")) {
                                        c = 'S';
                                        break;
                                    }
                                    c = 65535;
                                    break;
                                case 65355429:
                                    if (str3.equals("E5643")) {
                                        c = 'T';
                                        break;
                                    }
                                    c = 65535;
                                    break;
                                case 66214468:
                                    if (str3.equals("F3111")) {
                                        c = 'U';
                                        break;
                                    }
                                    c = 65535;
                                    break;
                                case 66214470:
                                    if (str3.equals("F3113")) {
                                        c = 'V';
                                        break;
                                    }
                                    c = 65535;
                                    break;
                                case 66214473:
                                    if (str3.equals("F3116")) {
                                        c = 'W';
                                        break;
                                    }
                                    c = 65535;
                                    break;
                                case 66215429:
                                    if (str3.equals("F3211")) {
                                        c = 'X';
                                        break;
                                    }
                                    c = 65535;
                                    break;
                                case 66215431:
                                    if (str3.equals("F3213")) {
                                        c = 'Y';
                                        break;
                                    }
                                    c = 65535;
                                    break;
                                case 66215433:
                                    if (str3.equals("F3215")) {
                                        c = 'Z';
                                        break;
                                    }
                                    c = 65535;
                                    break;
                                case 66216390:
                                    if (str3.equals("F3311")) {
                                        c = '[';
                                        break;
                                    }
                                    c = 65535;
                                    break;
                                case 76402249:
                                    if (str3.equals("PRO7S")) {
                                        c = '\\';
                                        break;
                                    }
                                    c = 65535;
                                    break;
                                case 76404105:
                                    if (str3.equals("Q4260")) {
                                        c = ']';
                                        break;
                                    }
                                    c = 65535;
                                    break;
                                case 76404911:
                                    if (str3.equals("Q4310")) {
                                        c = '^';
                                        break;
                                    }
                                    c = 65535;
                                    break;
                                case 80963634:
                                    if (str3.equals("V23GB")) {
                                        c = '_';
                                        break;
                                    }
                                    c = 65535;
                                    break;
                                case 82882791:
                                    if (str3.equals("X3_HK")) {
                                        c = '`';
                                        break;
                                    }
                                    c = 65535;
                                    break;
                                case 98715550:
                                    if (str3.equals("i9031")) {
                                        c = 'a';
                                        break;
                                    }
                                    c = 65535;
                                    break;
                                case 101370885:
                                    if (str3.equals("l5460")) {
                                        c = 'b';
                                        break;
                                    }
                                    c = 65535;
                                    break;
                                case 102844228:
                                    if (str3.equals("le_x6")) {
                                        c = 'c';
                                        break;
                                    }
                                    c = 65535;
                                    break;
                                case 165221241:
                                    if (str3.equals("A2016a40")) {
                                        c = 'd';
                                        break;
                                    }
                                    c = 65535;
                                    break;
                                case 182191441:
                                    if (str3.equals("CPY83_I00")) {
                                        c = 'e';
                                        break;
                                    }
                                    c = 65535;
                                    break;
                                case 245388979:
                                    if (str3.equals("marino_f")) {
                                        c = 'f';
                                        break;
                                    }
                                    c = 65535;
                                    break;
                                case 287431619:
                                    if (str3.equals("griffin")) {
                                        c = 'g';
                                        break;
                                    }
                                    c = 65535;
                                    break;
                                case 307593612:
                                    if (str3.equals("A7010a48")) {
                                        c = 'h';
                                        break;
                                    }
                                    c = 65535;
                                    break;
                                case 308517133:
                                    if (str3.equals("A7020a48")) {
                                        c = 'i';
                                        break;
                                    }
                                    c = 65535;
                                    break;
                                case 316215098:
                                    if (str3.equals("TB3-730F")) {
                                        c = 'j';
                                        break;
                                    }
                                    c = 65535;
                                    break;
                                case 316215116:
                                    if (str3.equals("TB3-730X")) {
                                        c = 'k';
                                        break;
                                    }
                                    c = 65535;
                                    break;
                                case 316246811:
                                    if (str3.equals("TB3-850F")) {
                                        c = 'l';
                                        break;
                                    }
                                    c = 65535;
                                    break;
                                case 316246818:
                                    if (str3.equals("TB3-850M")) {
                                        c = 'm';
                                        break;
                                    }
                                    c = 65535;
                                    break;
                                case 407160593:
                                    if (str3.equals("Pixi5-10_4G")) {
                                        c = 'n';
                                        break;
                                    }
                                    c = 65535;
                                    break;
                                case 507412548:
                                    if (str3.equals("QM16XE_U")) {
                                        c = 'o';
                                        break;
                                    }
                                    c = 65535;
                                    break;
                                case 793982701:
                                    if (str3.equals("GIONEE_WBL5708")) {
                                        c = 'p';
                                        break;
                                    }
                                    c = 65535;
                                    break;
                                case 794038622:
                                    if (str3.equals("GIONEE_WBL7365")) {
                                        c = 'q';
                                        break;
                                    }
                                    c = 65535;
                                    break;
                                case 794040393:
                                    if (str3.equals("GIONEE_WBL7519")) {
                                        c = 'r';
                                        break;
                                    }
                                    c = 65535;
                                    break;
                                case 835649806:
                                    if (str3.equals("manning")) {
                                        c = 's';
                                        break;
                                    }
                                    c = 65535;
                                    break;
                                case 917340916:
                                    if (str3.equals("A7000plus")) {
                                        c = 't';
                                        break;
                                    }
                                    c = 65535;
                                    break;
                                case 958008161:
                                    if (str3.equals("j2xlteins")) {
                                        c = 'u';
                                        break;
                                    }
                                    c = 65535;
                                    break;
                                case 1060579533:
                                    if (str3.equals("panell_d")) {
                                        c = 'v';
                                        break;
                                    }
                                    c = 65535;
                                    break;
                                case 1150207623:
                                    if (str3.equals("LS-5017")) {
                                        c = 'w';
                                        break;
                                    }
                                    c = 65535;
                                    break;
                                case 1176899427:
                                    if (str3.equals("itel_S41")) {
                                        c = 'x';
                                        break;
                                    }
                                    c = 65535;
                                    break;
                                case 1280332038:
                                    if (str3.equals("hwALE-H")) {
                                        c = 'y';
                                        break;
                                    }
                                    c = 65535;
                                    break;
                                case 1306947716:
                                    if (str3.equals("EverStar_S")) {
                                        c = 'z';
                                        break;
                                    }
                                    c = 65535;
                                    break;
                                case 1349174697:
                                    if (str3.equals("htc_e56ml_dtul")) {
                                        c = '{';
                                        break;
                                    }
                                    c = 65535;
                                    break;
                                case 1522194893:
                                    if (str3.equals("woods_f")) {
                                        c = '|';
                                        break;
                                    }
                                    c = 65535;
                                    break;
                                case 1691543273:
                                    if (str3.equals("CPH1609")) {
                                        c = '}';
                                        break;
                                    }
                                    c = 65535;
                                    break;
                                case 1691544261:
                                    if (str3.equals("CPH1715")) {
                                        c = '~';
                                        break;
                                    }
                                    c = 65535;
                                    break;
                                case 1709443163:
                                    if (str3.equals("iball8735_9806")) {
                                        c = Ascii.MAX;
                                        break;
                                    }
                                    c = 65535;
                                    break;
                                case 1865889110:
                                    if (str3.equals("santoni")) {
                                        c = 128;
                                        break;
                                    }
                                    c = 65535;
                                    break;
                                case 1906253259:
                                    if (str3.equals("PB2-670M")) {
                                        c = 129;
                                        break;
                                    }
                                    c = 65535;
                                    break;
                                case 1977196784:
                                    if (str3.equals("Infinix-X572")) {
                                        c = 130;
                                        break;
                                    }
                                    c = 65535;
                                    break;
                                case 2006372676:
                                    if (str3.equals("BRAVIA_ATV3_4K")) {
                                        c = 131;
                                        break;
                                    }
                                    c = 65535;
                                    break;
                                case 2019281702:
                                    if (str3.equals("DM-01K")) {
                                        c = 132;
                                        break;
                                    }
                                    c = 65535;
                                    break;
                                case 2029784656:
                                    if (str3.equals("HWBLN-H")) {
                                        c = 133;
                                        break;
                                    }
                                    c = 65535;
                                    break;
                                case 2030379515:
                                    if (str3.equals("HWCAM-H")) {
                                        c = 134;
                                        break;
                                    }
                                    c = 65535;
                                    break;
                                case 2033393791:
                                    if (str3.equals("ASUS_X00AD_2")) {
                                        c = 135;
                                        break;
                                    }
                                    c = 65535;
                                    break;
                                case 2047190025:
                                    if (str3.equals("ELUGA_Note")) {
                                        c = 136;
                                        break;
                                    }
                                    c = 65535;
                                    break;
                                case 2047252157:
                                    if (str3.equals("ELUGA_Prim")) {
                                        c = 137;
                                        break;
                                    }
                                    c = 65535;
                                    break;
                                case 2048319463:
                                    if (str3.equals("HWVNS-H")) {
                                        c = 138;
                                        break;
                                    }
                                    c = 65535;
                                    break;
                                case 2048855701:
                                    if (str3.equals("HWWAS-H")) {
                                        c = 139;
                                        break;
                                    }
                                    c = 65535;
                                    break;
                                default:
                                    c = 65535;
                                    break;
                            }
                            switch (c) {
                                default:
                                    String str4 = Util.MODEL;
                                    str4.getClass();
                                    switch (str4.hashCode()) {
                                        case -594534941:
                                            if (str4.equals("JSN-L21")) {
                                                c2 = 0;
                                                break;
                                            }
                                            c2 = 65535;
                                            break;
                                        case 2006354:
                                            if (str4.equals("AFTA")) {
                                                c2 = 1;
                                                break;
                                            }
                                            c2 = 65535;
                                            break;
                                        case 2006367:
                                            break;
                                        default:
                                            c2 = 65535;
                                            break;
                                    }
                                    switch (c2) {
                                    }
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
                                case '!':
                                case '\"':
                                case '#':
                                case '$':
                                case '%':
                                case '&':
                                case '\'':
                                case '(':
                                case ')':
                                case '*':
                                case '+':
                                case ',':
                                case '-':
                                case '.':
                                case '/':
                                case '0':
                                case '1':
                                case '2':
                                case '3':
                                case '4':
                                case '5':
                                case '6':
                                case '7':
                                case '8':
                                case '9':
                                case ':':
                                case ';':
                                case '<':
                                case '=':
                                case '>':
                                case '?':
                                case '@':
                                case 'A':
                                case 'B':
                                case 'C':
                                case 'D':
                                case 'E':
                                case 'F':
                                case 'G':
                                case 'H':
                                case 'I':
                                case 'J':
                                case 'K':
                                case 'L':
                                case 'M':
                                case 'N':
                                case 'O':
                                case 'P':
                                case 'Q':
                                case 'R':
                                case 'S':
                                case 'T':
                                case 'U':
                                case 'V':
                                case 'W':
                                case 'X':
                                case 'Y':
                                case 'Z':
                                case '[':
                                case '\\':
                                case ']':
                                case '^':
                                case '_':
                                case '`':
                                case 'a':
                                case 'b':
                                case 'c':
                                case 'd':
                                case 'e':
                                case 'f':
                                case 'g':
                                case 'h':
                                case 'i':
                                case 'j':
                                case 'k':
                                case 'l':
                                case 'm':
                                case 'n':
                                case 'o':
                                case 'p':
                                case 'q':
                                case 'r':
                                case 's':
                                case 't':
                                case 'u':
                                case 'v':
                                case 'w':
                                case 'x':
                                case 'y':
                                case 'z':
                                case '{':
                                case '|':
                                case '}':
                                case '~':
                                case 127:
                                case 128:
                                case TsExtractor.TS_STREAM_TYPE_AC3 /* 129 */:
                                case TsExtractor.TS_STREAM_TYPE_HDMV_DTS /* 130 */:
                                case 131:
                                case 132:
                                case 133:
                                case TsExtractor.TS_STREAM_TYPE_SPLICE_INFO /* 134 */:
                                case TsExtractor.TS_STREAM_TYPE_E_AC3 /* 135 */:
                                case 136:
                                case 137:
                                case TsExtractor.TS_STREAM_TYPE_DTS /* 138 */:
                                case 139:
                                    break;
                            }
                        }
                        f12830q1 = z2;
                        f12829p1 = true;
                    }
                    z2 = true;
                    f12830q1 = z2;
                    f12829p1 = true;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return f12830q1;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public MediaCodecDecoderException createDecoderException(Throwable th, @Nullable MediaCodecInfo mediaCodecInfo) {
        return new MediaCodecVideoDecoderException(th, mediaCodecInfo, this.f12840O0);
    }

    public void dropOutputBuffer(MediaCodecAdapter mediaCodecAdapter, int i, long j) {
        TraceUtil.beginSection("dropVideoBuffer");
        mediaCodecAdapter.releaseOutputBuffer(i, false);
        TraceUtil.endSection();
        updateDroppedBufferCounters(0, 1);
    }

    public CodecMaxValues getCodecMaxValues(MediaCodecInfo mediaCodecInfo, Format format, Format[] formatArr) {
        int i;
        Point point;
        int i2;
        int i3;
        boolean z;
        int codecMaxInputSize;
        Format format2 = format;
        int i4 = format2.width;
        int i5 = format2.height;
        int maxInputSize = getMaxInputSize(mediaCodecInfo, format);
        boolean z2 = true;
        if (formatArr.length == 1) {
            if (maxInputSize != -1 && (codecMaxInputSize = getCodecMaxInputSize(mediaCodecInfo, format)) != -1) {
                maxInputSize = Math.min((int) (maxInputSize * 1.5f), codecMaxInputSize);
            }
            return new CodecMaxValues(i4, i5, maxInputSize);
        }
        int length = formatArr.length;
        int i6 = 0;
        boolean z3 = false;
        for (int i7 = 0; i7 < length; i7++) {
            Format format3 = formatArr[i7];
            if (format2.colorInfo != null && format3.colorInfo == null) {
                format3 = format3.buildUpon().setColorInfo(format2.colorInfo).build();
            }
            if (mediaCodecInfo.canReuseCodec(format2, format3).result != 0) {
                int i8 = format3.width;
                if (i8 != -1 && format3.height != -1) {
                    z = false;
                } else {
                    z = true;
                }
                z3 |= z;
                i4 = Math.max(i4, i8);
                i5 = Math.max(i5, format3.height);
                maxInputSize = Math.max(maxInputSize, getMaxInputSize(mediaCodecInfo, format3));
            }
        }
        if (z3) {
            Log.m3027w("MediaCodecVideoRenderer", "Resolutions unknown. Codec max resolution: " + i4 + "x" + i5);
            int i9 = format2.height;
            int i10 = format2.width;
            if (i9 <= i10) {
                z2 = false;
            }
            if (z2) {
                i = i9;
            } else {
                i = i10;
            }
            if (z2) {
                i9 = i10;
            }
            float f = i9 / i;
            int[] iArr = f12828o1;
            while (i6 < 9) {
                int i11 = iArr[i6];
                int i12 = (int) (i11 * f);
                if (i11 <= i || i12 <= i9) {
                    break;
                }
                int i13 = i9;
                if (Util.SDK_INT >= 21) {
                    if (z2) {
                        i3 = i12;
                    } else {
                        i3 = i11;
                    }
                    if (!z2) {
                        i11 = i12;
                    }
                    point = mediaCodecInfo.alignVideoSizeV21(i3, i11);
                    if (mediaCodecInfo.isVideoSizeAndRateSupportedV21(point.x, point.y, format2.frameRate)) {
                        break;
                    }
                    i6++;
                    format2 = format;
                    i9 = i13;
                } else {
                    try {
                        int ceilDivide = Util.ceilDivide(i11, 16) * 16;
                        int ceilDivide2 = Util.ceilDivide(i12, 16) * 16;
                        if (ceilDivide * ceilDivide2 <= MediaCodecUtil.maxH264DecodableFrameSize()) {
                            if (z2) {
                                i2 = ceilDivide2;
                            } else {
                                i2 = ceilDivide;
                            }
                            if (!z2) {
                                ceilDivide = ceilDivide2;
                            }
                            point = new Point(i2, ceilDivide);
                        } else {
                            i6++;
                            format2 = format;
                            i9 = i13;
                        }
                    } catch (MediaCodecUtil.DecoderQueryException unused) {
                    }
                }
            }
            point = null;
            if (point != null) {
                i4 = Math.max(i4, point.x);
                i5 = Math.max(i5, point.y);
                maxInputSize = Math.max(maxInputSize, getCodecMaxInputSize(mediaCodecInfo, format.buildUpon().setWidth(i4).setHeight(i5).build()));
                Log.m3027w("MediaCodecVideoRenderer", "Codec max resolution adjusted to: " + i4 + "x" + i5);
            }
        }
        return new CodecMaxValues(i4, i5, maxInputSize);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public boolean getCodecNeedsEosPropagation() {
        if (this.f12862k1 && Util.SDK_INT < 23) {
            return true;
        }
        return false;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public float getCodecOperatingRateV23(float f, Format format, Format[] formatArr) {
        float f2 = -1.0f;
        for (Format format2 : formatArr) {
            float f3 = format2.frameRate;
            if (f3 != -1.0f) {
                f2 = Math.max(f2, f3);
            }
        }
        if (f2 == -1.0f) {
            return -1.0f;
        }
        return f2 * f;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public List<MediaCodecInfo> getDecoderInfos(MediaCodecSelector mediaCodecSelector, Format format, boolean z) {
        return MediaCodecUtil.getDecoderInfosSortedByFormatSupport(m3057r(mediaCodecSelector, format, z, this.f12862k1), format);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    @TargetApi(17)
    public MediaCodecAdapter.Configuration getMediaCodecConfiguration(MediaCodecInfo mediaCodecInfo, Format format, @Nullable MediaCrypto mediaCrypto, float f) {
        int i;
        PlaceholderSurface placeholderSurface = this.f12841P0;
        if (placeholderSurface != null && placeholderSurface.secure != mediaCodecInfo.secure) {
            if (this.f12840O0 == placeholderSurface) {
                this.f12840O0 = null;
            }
            placeholderSurface.release();
            this.f12841P0 = null;
        }
        String str = mediaCodecInfo.codecMimeType;
        CodecMaxValues codecMaxValues = getCodecMaxValues(mediaCodecInfo, format, getStreamFormats());
        this.f12837L0 = codecMaxValues;
        if (this.f12862k1) {
            i = this.f12863l1;
        } else {
            i = 0;
        }
        MediaFormat mediaFormat = getMediaFormat(format, str, codecMaxValues, f, this.f12836K0, i);
        if (this.f12840O0 == null) {
            if (m3061u(mediaCodecInfo)) {
                if (this.f12841P0 == null) {
                    this.f12841P0 = PlaceholderSurface.newInstanceV17(this.f12831F0, mediaCodecInfo.secure);
                }
                this.f12840O0 = this.f12841P0;
            } else {
                throw new IllegalStateException();
            }
        }
        return MediaCodecAdapter.Configuration.createForVideoDecoding(mediaCodecInfo, mediaFormat, format, this.f12840O0, mediaCrypto);
    }

    @SuppressLint({"InlinedApi"})
    @TargetApi(21)
    public MediaFormat getMediaFormat(Format format, String str, CodecMaxValues codecMaxValues, float f, boolean z, int i) {
        Pair<Integer, Integer> codecProfileAndLevel;
        MediaFormat mediaFormat = new MediaFormat();
        mediaFormat.setString("mime", str);
        mediaFormat.setInteger("width", format.width);
        mediaFormat.setInteger("height", format.height);
        MediaFormatUtil.setCsdBuffers(mediaFormat, format.initializationData);
        MediaFormatUtil.maybeSetFloat(mediaFormat, "frame-rate", format.frameRate);
        MediaFormatUtil.maybeSetInteger(mediaFormat, "rotation-degrees", format.rotationDegrees);
        MediaFormatUtil.maybeSetColorInfo(mediaFormat, format.colorInfo);
        if (MimeTypes.VIDEO_DOLBY_VISION.equals(format.sampleMimeType) && (codecProfileAndLevel = MediaCodecUtil.getCodecProfileAndLevel(format)) != null) {
            MediaFormatUtil.maybeSetInteger(mediaFormat, Scopes.PROFILE, ((Integer) codecProfileAndLevel.first).intValue());
        }
        mediaFormat.setInteger("max-width", codecMaxValues.width);
        mediaFormat.setInteger("max-height", codecMaxValues.height);
        MediaFormatUtil.maybeSetInteger(mediaFormat, "max-input-size", codecMaxValues.inputSize);
        if (Util.SDK_INT >= 23) {
            mediaFormat.setInteger("priority", 0);
            if (f != -1.0f) {
                mediaFormat.setFloat("operating-rate", f);
            }
        }
        if (z) {
            mediaFormat.setInteger("no-post-process", 1);
            mediaFormat.setInteger("auto-frc", 0);
        }
        if (i != 0) {
            mediaFormat.setFeatureEnabled("tunneled-playback", true);
            mediaFormat.setInteger("audio-session-id", i);
        }
        return mediaFormat;
    }

    @Override // com.google.android.exoplayer2.Renderer, com.google.android.exoplayer2.RendererCapabilities
    public String getName() {
        return "MediaCodecVideoRenderer";
    }

    public Surface getSurface() {
        return this.f12840O0;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    @TargetApi(29)
    public void handleInputBufferSupplementalData(DecoderInputBuffer decoderInputBuffer) {
        if (!this.f12839N0) {
            return;
        }
        ByteBuffer byteBuffer = (ByteBuffer) Assertions.checkNotNull(decoderInputBuffer.supplementalData);
        if (byteBuffer.remaining() >= 7) {
            byte b = byteBuffer.get();
            short s = byteBuffer.getShort();
            short s2 = byteBuffer.getShort();
            byte b2 = byteBuffer.get();
            byte b3 = byteBuffer.get();
            byteBuffer.position(0);
            if (b == -75 && s == 60 && s2 == 1 && b2 == 4 && b3 == 0) {
                byte[] bArr = new byte[byteBuffer.remaining()];
                byteBuffer.get(bArr);
                byteBuffer.position(0);
                MediaCodecAdapter codec = getCodec();
                Bundle bundle = new Bundle();
                bundle.putByteArray("hdr10-plus-info", bArr);
                codec.setParameters(bundle);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0, types: [com.google.android.exoplayer2.BaseRenderer, com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.video.MediaCodecVideoRenderer] */
    /* JADX WARN: Type inference failed for: r7v9, types: [android.view.Surface] */
    @Override // com.google.android.exoplayer2.BaseRenderer, com.google.android.exoplayer2.PlayerMessage.Target
    public void handleMessage(int i, @Nullable Object obj) {
        PlaceholderSurface placeholderSurface;
        long j;
        VideoFrameReleaseHelper videoFrameReleaseHelper = this.f12832G0;
        if (i != 1) {
            if (i != 7) {
                if (i != 10) {
                    if (i != 4) {
                        if (i != 5) {
                            super.handleMessage(i, obj);
                            return;
                        } else {
                            videoFrameReleaseHelper.setChangeFrameRateStrategy(((Integer) obj).intValue());
                            return;
                        }
                    }
                    this.f12843R0 = ((Integer) obj).intValue();
                    MediaCodecAdapter codec = getCodec();
                    if (codec != null) {
                        codec.setVideoScalingMode(this.f12843R0);
                        return;
                    }
                    return;
                }
                int intValue = ((Integer) obj).intValue();
                if (this.f12863l1 != intValue) {
                    this.f12863l1 = intValue;
                    if (this.f12862k1) {
                        releaseCodec();
                        return;
                    }
                    return;
                }
                return;
            }
            this.f12865n1 = (VideoFrameMetadataListener) obj;
            return;
        }
        if (obj instanceof Surface) {
            placeholderSurface = (Surface) obj;
        } else {
            placeholderSurface = null;
        }
        if (placeholderSurface == null) {
            PlaceholderSurface placeholderSurface2 = this.f12841P0;
            if (placeholderSurface2 != null) {
                placeholderSurface = placeholderSurface2;
            } else {
                MediaCodecInfo codecInfo = getCodecInfo();
                if (codecInfo != null && m3061u(codecInfo)) {
                    placeholderSurface = PlaceholderSurface.newInstanceV17(this.f12831F0, codecInfo.secure);
                    this.f12841P0 = placeholderSurface;
                }
            }
        }
        Surface surface = this.f12840O0;
        VideoRendererEventListener.EventDispatcher eventDispatcher = this.f12833H0;
        if (surface != placeholderSurface) {
            this.f12840O0 = placeholderSurface;
            videoFrameReleaseHelper.onSurfaceChanged(placeholderSurface);
            this.f12842Q0 = false;
            int state = getState();
            MediaCodecAdapter codec2 = getCodec();
            if (codec2 != null) {
                if (Util.SDK_INT >= 23 && placeholderSurface != null && !this.f12838M0) {
                    setOutputSurfaceV23(codec2, placeholderSurface);
                } else {
                    releaseCodec();
                    maybeInitCodecOrBypass();
                }
            }
            if (placeholderSurface != null && placeholderSurface != this.f12841P0) {
                VideoSize videoSize = this.f12861j1;
                if (videoSize != null) {
                    eventDispatcher.videoSizeChanged(videoSize);
                }
                m3058q();
                if (state == 2) {
                    long j2 = this.f12834I0;
                    if (j2 > 0) {
                        j = SystemClock.elapsedRealtime() + j2;
                    } else {
                        j = C0643C.TIME_UNSET;
                    }
                    this.f12848W0 = j;
                    return;
                }
                return;
            }
            this.f12861j1 = null;
            m3058q();
            return;
        }
        if (placeholderSurface != null && placeholderSurface != this.f12841P0) {
            VideoSize videoSize2 = this.f12861j1;
            if (videoSize2 != null) {
                eventDispatcher.videoSizeChanged(videoSize2);
            }
            if (this.f12842Q0) {
                eventDispatcher.renderedFirstFrame(this.f12840O0);
            }
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.Renderer
    public boolean isReady() {
        PlaceholderSurface placeholderSurface;
        if (super.isReady() && (this.f12844S0 || (((placeholderSurface = this.f12841P0) != null && this.f12840O0 == placeholderSurface) || getCodec() == null || this.f12862k1))) {
            this.f12848W0 = C0643C.TIME_UNSET;
            return true;
        }
        if (this.f12848W0 == C0643C.TIME_UNSET) {
            return false;
        }
        if (SystemClock.elapsedRealtime() < this.f12848W0) {
            return true;
        }
        this.f12848W0 = C0643C.TIME_UNSET;
        return false;
    }

    public boolean maybeDropBuffersToKeyframe(long j, boolean z) {
        int skipSource = skipSource(j);
        if (skipSource == 0) {
            return false;
        }
        if (z) {
            DecoderCounters decoderCounters = this.decoderCounters;
            decoderCounters.skippedInputBufferCount += skipSource;
            decoderCounters.skippedOutputBufferCount += this.f12852a1;
        } else {
            this.decoderCounters.droppedToKeyframeCount++;
            updateDroppedBufferCounters(skipSource, this.f12852a1);
        }
        flushOrReinitializeCodec();
        return true;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public void onCodecError(Exception exc) {
        Log.m3024e("MediaCodecVideoRenderer", "Video codec error", exc);
        this.f12833H0.videoCodecError(exc);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public void onCodecInitialized(String str, MediaCodecAdapter.Configuration configuration, long j, long j2) {
        this.f12833H0.decoderInitialized(str, j, j2);
        this.f12838M0 = codecNeedsSetOutputSurfaceWorkaround(str);
        this.f12839N0 = ((MediaCodecInfo) Assertions.checkNotNull(getCodecInfo())).isHdr10PlusOutOfBandMetadataSupported();
        if (Util.SDK_INT >= 23 && this.f12862k1) {
            this.f12864m1 = new gl1(this, (MediaCodecAdapter) Assertions.checkNotNull(getCodec()));
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public void onCodecReleased(String str) {
        this.f12833H0.decoderReleased(str);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.BaseRenderer
    public void onDisabled() {
        VideoRendererEventListener.EventDispatcher eventDispatcher = this.f12833H0;
        this.f12861j1 = null;
        m3058q();
        this.f12842Q0 = false;
        this.f12864m1 = null;
        try {
            super.onDisabled();
        } finally {
            eventDispatcher.disabled(this.decoderCounters);
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.BaseRenderer
    public void onEnabled(boolean z, boolean z2) {
        boolean z3;
        super.onEnabled(z, z2);
        boolean z4 = getConfiguration().tunneling;
        if (z4 && this.f12863l1 == 0) {
            z3 = false;
        } else {
            z3 = true;
        }
        Assertions.checkState(z3);
        if (this.f12862k1 != z4) {
            this.f12862k1 = z4;
            releaseCodec();
        }
        this.f12833H0.enabled(this.decoderCounters);
        this.f12845T0 = z2;
        this.f12846U0 = false;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    @Nullable
    public DecoderReuseEvaluation onInputFormatChanged(FormatHolder formatHolder) {
        DecoderReuseEvaluation onInputFormatChanged = super.onInputFormatChanged(formatHolder);
        this.f12833H0.inputFormatChanged(formatHolder.format, onInputFormatChanged);
        return onInputFormatChanged;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public void onOutputFormatChanged(Format format, @Nullable MediaFormat mediaFormat) {
        boolean z;
        int integer;
        int integer2;
        MediaCodecAdapter codec = getCodec();
        if (codec != null) {
            codec.setVideoScalingMode(this.f12843R0);
        }
        if (this.f12862k1) {
            this.f12857f1 = format.width;
            this.f12858g1 = format.height;
        } else {
            Assertions.checkNotNull(mediaFormat);
            if (mediaFormat.containsKey("crop-right") && mediaFormat.containsKey("crop-left") && mediaFormat.containsKey("crop-bottom") && mediaFormat.containsKey("crop-top")) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                integer = (mediaFormat.getInteger("crop-right") - mediaFormat.getInteger("crop-left")) + 1;
            } else {
                integer = mediaFormat.getInteger("width");
            }
            this.f12857f1 = integer;
            if (z) {
                integer2 = (mediaFormat.getInteger("crop-bottom") - mediaFormat.getInteger("crop-top")) + 1;
            } else {
                integer2 = mediaFormat.getInteger("height");
            }
            this.f12858g1 = integer2;
        }
        float f = format.pixelWidthHeightRatio;
        this.f12860i1 = f;
        if (Util.SDK_INT >= 21) {
            int i = format.rotationDegrees;
            if (i == 90 || i == 270) {
                int i2 = this.f12857f1;
                this.f12857f1 = this.f12858g1;
                this.f12858g1 = i2;
                this.f12860i1 = 1.0f / f;
            }
        } else {
            this.f12859h1 = format.rotationDegrees;
        }
        this.f12832G0.onFormatChanged(format.frameRate);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.BaseRenderer
    public void onPositionReset(long j, boolean z) {
        super.onPositionReset(j, z);
        m3058q();
        this.f12832G0.onPositionReset();
        long j2 = C0643C.TIME_UNSET;
        this.f12853b1 = C0643C.TIME_UNSET;
        this.f12847V0 = C0643C.TIME_UNSET;
        this.f12851Z0 = 0;
        if (z) {
            long j3 = this.f12834I0;
            if (j3 > 0) {
                j2 = SystemClock.elapsedRealtime() + j3;
            }
            this.f12848W0 = j2;
            return;
        }
        this.f12848W0 = C0643C.TIME_UNSET;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    @CallSuper
    public void onProcessedOutputBuffer(long j) {
        super.onProcessedOutputBuffer(j);
        if (!this.f12862k1) {
            this.f12852a1--;
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public void onProcessedStreamChange() {
        super.onProcessedStreamChange();
        m3058q();
    }

    public void onProcessedTunneledBuffer(long j) {
        updateOutputFormatForTime(j);
        m3060t();
        this.decoderCounters.renderedOutputBufferCount++;
        m3059s();
        onProcessedOutputBuffer(j);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    @CallSuper
    public void onQueueInputBuffer(DecoderInputBuffer decoderInputBuffer) {
        boolean z = this.f12862k1;
        if (!z) {
            this.f12852a1++;
        }
        if (Util.SDK_INT < 23 && z) {
            onProcessedTunneledBuffer(decoderInputBuffer.timeUs);
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.BaseRenderer
    @TargetApi(17)
    public void onReset() {
        try {
            super.onReset();
            PlaceholderSurface placeholderSurface = this.f12841P0;
            if (placeholderSurface != null) {
                if (this.f12840O0 == placeholderSurface) {
                    this.f12840O0 = null;
                }
                placeholderSurface.release();
                this.f12841P0 = null;
            }
        } catch (Throwable th) {
            if (this.f12841P0 != null) {
                Surface surface = this.f12840O0;
                PlaceholderSurface placeholderSurface2 = this.f12841P0;
                if (surface == placeholderSurface2) {
                    this.f12840O0 = null;
                }
                placeholderSurface2.release();
                this.f12841P0 = null;
            }
            throw th;
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.BaseRenderer
    public void onStarted() {
        super.onStarted();
        this.f12850Y0 = 0;
        this.f12849X0 = SystemClock.elapsedRealtime();
        this.f12854c1 = SystemClock.elapsedRealtime() * 1000;
        this.f12855d1 = 0L;
        this.f12856e1 = 0;
        this.f12832G0.onStarted();
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.BaseRenderer
    public void onStopped() {
        this.f12848W0 = C0643C.TIME_UNSET;
        int i = this.f12850Y0;
        VideoRendererEventListener.EventDispatcher eventDispatcher = this.f12833H0;
        if (i > 0) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            eventDispatcher.droppedFrames(this.f12850Y0, elapsedRealtime - this.f12849X0);
            this.f12850Y0 = 0;
            this.f12849X0 = elapsedRealtime;
        }
        int i2 = this.f12856e1;
        if (i2 != 0) {
            eventDispatcher.reportVideoFrameProcessingOffset(this.f12855d1, i2);
            this.f12855d1 = 0L;
            this.f12856e1 = 0;
        }
        this.f12832G0.onStopped();
        super.onStopped();
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public boolean processOutputBuffer(long j, long j2, @Nullable MediaCodecAdapter mediaCodecAdapter, @Nullable ByteBuffer byteBuffer, int i, int i2, int i3, long j3, boolean z, boolean z2, Format format) {
        long j4;
        boolean z3;
        long j5;
        int i4;
        long j6;
        Assertions.checkNotNull(mediaCodecAdapter);
        if (this.f12847V0 == C0643C.TIME_UNSET) {
            this.f12847V0 = j;
        }
        long j7 = this.f12853b1;
        VideoFrameReleaseHelper videoFrameReleaseHelper = this.f12832G0;
        if (j3 != j7) {
            videoFrameReleaseHelper.onNextFrame(j3);
            this.f12853b1 = j3;
        }
        long outputStreamOffsetUs = getOutputStreamOffsetUs();
        long j8 = j3 - outputStreamOffsetUs;
        if (z && !z2) {
            skipOutputBuffer(mediaCodecAdapter, i, j8);
            return true;
        }
        double playbackSpeed = getPlaybackSpeed();
        boolean z4 = getState() == 2;
        long elapsedRealtime = SystemClock.elapsedRealtime() * 1000;
        long j9 = (long) ((j3 - j) / playbackSpeed);
        if (z4) {
            j9 -= elapsedRealtime - j2;
        }
        if (this.f12840O0 == this.f12841P0) {
            if (j9 >= -30000) {
                return false;
            }
            skipOutputBuffer(mediaCodecAdapter, i, j8);
            updateVideoFrameProcessingOffsetCounters(j9);
            return true;
        }
        long j10 = elapsedRealtime - this.f12854c1;
        if (this.f12846U0 ? this.f12844S0 : !(z4 || this.f12845T0)) {
            j4 = j8;
            z3 = false;
        } else {
            j4 = j8;
            z3 = true;
        }
        if (this.f12848W0 == C0643C.TIME_UNSET && j >= outputStreamOffsetUs && (z3 || (z4 && shouldForceRenderOutputBuffer(j9, j10)))) {
            long nanoTime = System.nanoTime();
            VideoFrameMetadataListener videoFrameMetadataListener = this.f12865n1;
            if (videoFrameMetadataListener != null) {
                i4 = 21;
                j6 = j4;
                videoFrameMetadataListener.onVideoFrameAboutToBeRendered(j6, nanoTime, format, getCodecOutputMediaFormat());
            } else {
                i4 = 21;
                j6 = j4;
            }
            if (Util.SDK_INT >= i4) {
                renderOutputBufferV21(mediaCodecAdapter, i, j6, nanoTime);
            } else {
                renderOutputBuffer(mediaCodecAdapter, i, j6);
            }
            updateVideoFrameProcessingOffsetCounters(j9);
            return true;
        }
        long j11 = j4;
        if (z4 && j != this.f12847V0) {
            long nanoTime2 = System.nanoTime();
            long adjustReleaseTime = videoFrameReleaseHelper.adjustReleaseTime((j9 * 1000) + nanoTime2);
            long j12 = (adjustReleaseTime - nanoTime2) / 1000;
            boolean z5 = this.f12848W0 != C0643C.TIME_UNSET;
            if (shouldDropBuffersToKeyframe(j12, j2, z2) && maybeDropBuffersToKeyframe(j, z5)) {
                return false;
            }
            if (shouldDropOutputBuffer(j12, j2, z2)) {
                if (z5) {
                    skipOutputBuffer(mediaCodecAdapter, i, j11);
                } else {
                    dropOutputBuffer(mediaCodecAdapter, i, j11);
                }
                updateVideoFrameProcessingOffsetCounters(j12);
                return true;
            }
            if (Util.SDK_INT >= 21) {
                if (j12 < 50000) {
                    VideoFrameMetadataListener videoFrameMetadataListener2 = this.f12865n1;
                    if (videoFrameMetadataListener2 != null) {
                        j5 = j12;
                        videoFrameMetadataListener2.onVideoFrameAboutToBeRendered(j11, adjustReleaseTime, format, getCodecOutputMediaFormat());
                    } else {
                        j5 = j12;
                    }
                    renderOutputBufferV21(mediaCodecAdapter, i, j11, adjustReleaseTime);
                    updateVideoFrameProcessingOffsetCounters(j5);
                    return true;
                }
            } else if (j12 < 30000) {
                if (j12 > 11000) {
                    try {
                        Thread.sleep((j12 - 10000) / 1000);
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                        return false;
                    }
                }
                VideoFrameMetadataListener videoFrameMetadataListener3 = this.f12865n1;
                if (videoFrameMetadataListener3 != null) {
                    videoFrameMetadataListener3.onVideoFrameAboutToBeRendered(j11, adjustReleaseTime, format, getCodecOutputMediaFormat());
                }
                renderOutputBuffer(mediaCodecAdapter, i, j11);
                updateVideoFrameProcessingOffsetCounters(j12);
                return true;
            }
        }
        return false;
    }

    /* renamed from: q */
    public final void m3058q() {
        MediaCodecAdapter codec;
        this.f12844S0 = false;
        if (Util.SDK_INT >= 23 && this.f12862k1 && (codec = getCodec()) != null) {
            this.f12864m1 = new gl1(this, codec);
        }
    }

    public void renderOutputBuffer(MediaCodecAdapter mediaCodecAdapter, int i, long j) {
        m3060t();
        TraceUtil.beginSection("releaseOutputBuffer");
        mediaCodecAdapter.releaseOutputBuffer(i, true);
        TraceUtil.endSection();
        this.f12854c1 = SystemClock.elapsedRealtime() * 1000;
        this.decoderCounters.renderedOutputBufferCount++;
        this.f12851Z0 = 0;
        m3059s();
    }

    @RequiresApi(21)
    public void renderOutputBufferV21(MediaCodecAdapter mediaCodecAdapter, int i, long j, long j2) {
        m3060t();
        TraceUtil.beginSection("releaseOutputBuffer");
        mediaCodecAdapter.releaseOutputBuffer(i, j2);
        TraceUtil.endSection();
        this.f12854c1 = SystemClock.elapsedRealtime() * 1000;
        this.decoderCounters.renderedOutputBufferCount++;
        this.f12851Z0 = 0;
        m3059s();
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    @CallSuper
    public void resetCodecStateForFlush() {
        super.resetCodecStateForFlush();
        this.f12852a1 = 0;
    }

    /* renamed from: s */
    public final void m3059s() {
        this.f12846U0 = true;
        if (!this.f12844S0) {
            this.f12844S0 = true;
            this.f12833H0.renderedFirstFrame(this.f12840O0);
            this.f12842Q0 = true;
        }
    }

    @RequiresApi(23)
    public void setOutputSurfaceV23(MediaCodecAdapter mediaCodecAdapter, Surface surface) {
        mediaCodecAdapter.setOutputSurface(surface);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.BaseRenderer, com.google.android.exoplayer2.Renderer
    public void setPlaybackSpeed(float f, float f2) {
        super.setPlaybackSpeed(f, f2);
        this.f12832G0.onPlaybackSpeed(f);
    }

    public boolean shouldDropBuffersToKeyframe(long j, long j2, boolean z) {
        return j < -500000 && !z;
    }

    public boolean shouldDropOutputBuffer(long j, long j2, boolean z) {
        return j < -30000 && !z;
    }

    public boolean shouldForceRenderOutputBuffer(long j, long j2) {
        return j < -30000 && j2 > 100000;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public boolean shouldInitCodec(MediaCodecInfo mediaCodecInfo) {
        if (this.f12840O0 == null && !m3061u(mediaCodecInfo)) {
            return false;
        }
        return true;
    }

    public void skipOutputBuffer(MediaCodecAdapter mediaCodecAdapter, int i, long j) {
        TraceUtil.beginSection("skipVideoBuffer");
        mediaCodecAdapter.releaseOutputBuffer(i, false);
        TraceUtil.endSection();
        this.decoderCounters.skippedOutputBufferCount++;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public int supportsFormat(MediaCodecSelector mediaCodecSelector, Format format) {
        boolean z;
        boolean z2;
        int i;
        int i2;
        int i3;
        int i4;
        int i5 = 0;
        if (!MimeTypes.isVideo(format.sampleMimeType)) {
            return qa2.m7011a(0);
        }
        if (format.drmInitData != null) {
            z = true;
        } else {
            z = false;
        }
        ImmutableList m3057r = m3057r(mediaCodecSelector, format, z, false);
        if (z && m3057r.isEmpty()) {
            m3057r = m3057r(mediaCodecSelector, format, false, false);
        }
        if (m3057r.isEmpty()) {
            return qa2.m7011a(1);
        }
        if (!MediaCodecRenderer.supportsFormatDrm(format)) {
            return qa2.m7011a(2);
        }
        MediaCodecInfo mediaCodecInfo = (MediaCodecInfo) m3057r.get(0);
        boolean isFormatSupported = mediaCodecInfo.isFormatSupported(format);
        if (!isFormatSupported) {
            for (int i6 = 1; i6 < m3057r.size(); i6++) {
                MediaCodecInfo mediaCodecInfo2 = (MediaCodecInfo) m3057r.get(i6);
                if (mediaCodecInfo2.isFormatSupported(format)) {
                    z2 = false;
                    isFormatSupported = true;
                    mediaCodecInfo = mediaCodecInfo2;
                    break;
                }
            }
        }
        z2 = true;
        if (isFormatSupported) {
            i = 4;
        } else {
            i = 3;
        }
        if (mediaCodecInfo.isSeamlessAdaptationSupported(format)) {
            i2 = 16;
        } else {
            i2 = 8;
        }
        if (mediaCodecInfo.hardwareAccelerated) {
            i3 = 64;
        } else {
            i3 = 0;
        }
        if (z2) {
            i4 = 128;
        } else {
            i4 = 0;
        }
        if (isFormatSupported) {
            ImmutableList m3057r2 = m3057r(mediaCodecSelector, format, z, true);
            if (!m3057r2.isEmpty()) {
                MediaCodecInfo mediaCodecInfo3 = MediaCodecUtil.getDecoderInfosSortedByFormatSupport(m3057r2, format).get(0);
                if (mediaCodecInfo3.isFormatSupported(format) && mediaCodecInfo3.isSeamlessAdaptationSupported(format)) {
                    i5 = 32;
                }
            }
        }
        return qa2.m7013c(i, i2, i5, i3, i4);
    }

    /* renamed from: t */
    public final void m3060t() {
        int i = this.f12857f1;
        if (i != -1 || this.f12858g1 != -1) {
            VideoSize videoSize = this.f12861j1;
            if (videoSize == null || videoSize.width != i || videoSize.height != this.f12858g1 || videoSize.unappliedRotationDegrees != this.f12859h1 || videoSize.pixelWidthHeightRatio != this.f12860i1) {
                VideoSize videoSize2 = new VideoSize(this.f12857f1, this.f12858g1, this.f12859h1, this.f12860i1);
                this.f12861j1 = videoSize2;
                this.f12833H0.videoSizeChanged(videoSize2);
            }
        }
    }

    /* renamed from: u */
    public final boolean m3061u(MediaCodecInfo mediaCodecInfo) {
        if (Util.SDK_INT >= 23 && !this.f12862k1 && !codecNeedsSetOutputSurfaceWorkaround(mediaCodecInfo.name) && (!mediaCodecInfo.secure || PlaceholderSurface.isSecureSupported(this.f12831F0))) {
            return true;
        }
        return false;
    }

    public void updateDroppedBufferCounters(int i, int i2) {
        int i3;
        DecoderCounters decoderCounters = this.decoderCounters;
        decoderCounters.droppedInputBufferCount += i;
        int i4 = i + i2;
        decoderCounters.droppedBufferCount += i4;
        this.f12850Y0 += i4;
        int i5 = this.f12851Z0 + i4;
        this.f12851Z0 = i5;
        decoderCounters.maxConsecutiveDroppedBufferCount = Math.max(i5, decoderCounters.maxConsecutiveDroppedBufferCount);
        int i6 = this.f12835J0;
        if (i6 > 0 && (i3 = this.f12850Y0) >= i6 && i3 > 0) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            this.f12833H0.droppedFrames(this.f12850Y0, elapsedRealtime - this.f12849X0);
            this.f12850Y0 = 0;
            this.f12849X0 = elapsedRealtime;
        }
    }

    public void updateVideoFrameProcessingOffsetCounters(long j) {
        this.decoderCounters.addVideoFrameProcessingOffset(j);
        this.f12855d1 += j;
        this.f12856e1++;
    }

    public MediaCodecVideoRenderer(Context context, MediaCodecSelector mediaCodecSelector, long j) {
        this(context, mediaCodecSelector, j, null, null, 0);
    }

    public MediaCodecVideoRenderer(Context context, MediaCodecSelector mediaCodecSelector, long j, @Nullable Handler handler, @Nullable VideoRendererEventListener videoRendererEventListener, int i) {
        this(context, MediaCodecAdapter.Factory.DEFAULT, mediaCodecSelector, j, false, handler, videoRendererEventListener, i, 30.0f);
    }

    public MediaCodecVideoRenderer(Context context, MediaCodecSelector mediaCodecSelector, long j, boolean z, @Nullable Handler handler, @Nullable VideoRendererEventListener videoRendererEventListener, int i) {
        this(context, MediaCodecAdapter.Factory.DEFAULT, mediaCodecSelector, j, z, handler, videoRendererEventListener, i, 30.0f);
    }

    public MediaCodecVideoRenderer(Context context, MediaCodecAdapter.Factory factory, MediaCodecSelector mediaCodecSelector, long j, boolean z, @Nullable Handler handler, @Nullable VideoRendererEventListener videoRendererEventListener, int i) {
        this(context, factory, mediaCodecSelector, j, z, handler, videoRendererEventListener, i, 30.0f);
    }

    public MediaCodecVideoRenderer(Context context, MediaCodecAdapter.Factory factory, MediaCodecSelector mediaCodecSelector, long j, boolean z, @Nullable Handler handler, @Nullable VideoRendererEventListener videoRendererEventListener, int i, float f) {
        super(2, factory, mediaCodecSelector, z, f);
        this.f12834I0 = j;
        this.f12835J0 = i;
        Context applicationContext = context.getApplicationContext();
        this.f12831F0 = applicationContext;
        this.f12832G0 = new VideoFrameReleaseHelper(applicationContext);
        this.f12833H0 = new VideoRendererEventListener.EventDispatcher(handler, videoRendererEventListener);
        this.f12836K0 = "NVIDIA".equals(Util.MANUFACTURER);
        this.f12848W0 = C0643C.TIME_UNSET;
        this.f12857f1 = -1;
        this.f12858g1 = -1;
        this.f12860i1 = -1.0f;
        this.f12843R0 = 1;
        this.f12863l1 = 0;
        this.f12861j1 = null;
    }
}
