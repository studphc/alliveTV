package com.google.android.exoplayer2.mediacodec;

import android.graphics.Point;
import android.media.MediaCodecInfo;
import android.util.Pair;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.decoder.DecoderReuseEvaluation;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.Util;
import p000.AbstractC1726qj;
import p000.ye0;

/* loaded from: classes.dex */
public final class MediaCodecInfo {
    public static final int MAX_SUPPORTED_INSTANCES_UNKNOWN = -1;
    public static final String TAG = "MediaCodecInfo";

    /* renamed from: a */
    public final boolean f10652a;
    public final boolean adaptive;

    @Nullable
    public final MediaCodecInfo.CodecCapabilities capabilities;
    public final String codecMimeType;
    public final boolean hardwareAccelerated;
    public final String mimeType;
    public final String name;
    public final boolean secure;
    public final boolean softwareOnly;
    public final boolean tunneling;
    public final boolean vendor;

    public MediaCodecInfo(String str, String str2, String str3, MediaCodecInfo.CodecCapabilities codecCapabilities, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6) {
        this.name = (String) Assertions.checkNotNull(str);
        this.mimeType = str2;
        this.codecMimeType = str3;
        this.capabilities = codecCapabilities;
        this.hardwareAccelerated = z;
        this.softwareOnly = z2;
        this.vendor = z3;
        this.adaptive = z4;
        this.tunneling = z5;
        this.secure = z6;
        this.f10652a = MimeTypes.isVideo(str2);
    }

    /* renamed from: a */
    public static boolean m2644a(MediaCodecInfo.VideoCapabilities videoCapabilities, int i, int i2, double d) {
        int widthAlignment = videoCapabilities.getWidthAlignment();
        int heightAlignment = videoCapabilities.getHeightAlignment();
        Point point = new Point(Util.ceilDivide(i, widthAlignment) * widthAlignment, Util.ceilDivide(i2, heightAlignment) * heightAlignment);
        int i3 = point.x;
        int i4 = point.y;
        if (d != -1.0d && d >= 1.0d) {
            return videoCapabilities.areSizeAndRateSupported(i3, i4, Math.floor(d));
        }
        return videoCapabilities.isSizeSupported(i3, i4);
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x002c, code lost:
    
        if ("Nexus 10".equals(r3) == false) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x003c, code lost:
    
        if ("OMX.Exynos.AVC.Decoder.secure".equals(r12) == false) goto L20;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static MediaCodecInfo newInstance(String str, String str2, String str3, @Nullable MediaCodecInfo.CodecCapabilities codecCapabilities, boolean z, boolean z2, boolean z3, boolean z4, boolean z5) {
        boolean z6;
        boolean z7;
        boolean z8;
        int i;
        if (!z4 && codecCapabilities != null && (i = Util.SDK_INT) >= 19 && codecCapabilities.isFeatureSupported("adaptive-playback")) {
            if (i <= 22) {
                String str4 = Util.MODEL;
                if (!"ODROID-XU3".equals(str4)) {
                }
                if (!"OMX.Exynos.AVC.Decoder".equals(str)) {
                }
            }
            z6 = true;
            if (codecCapabilities == null && Util.SDK_INT >= 21 && codecCapabilities.isFeatureSupported("tunneled-playback")) {
                z7 = true;
            } else {
                z7 = false;
            }
            if (z5 && (codecCapabilities == null || Util.SDK_INT < 21 || !codecCapabilities.isFeatureSupported("secure-playback"))) {
                z8 = false;
            } else {
                z8 = true;
            }
            return new MediaCodecInfo(str, str2, str3, codecCapabilities, z, z2, z3, z6, z7, z8);
        }
        z6 = false;
        if (codecCapabilities == null) {
        }
        z7 = false;
        if (z5) {
        }
        z8 = true;
        return new MediaCodecInfo(str, str2, str3, codecCapabilities, z, z2, z3, z6, z7, z8);
    }

    @Nullable
    @RequiresApi(21)
    public Point alignVideoSizeV21(int i, int i2) {
        MediaCodecInfo.VideoCapabilities videoCapabilities;
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.capabilities;
        if (codecCapabilities == null || (videoCapabilities = codecCapabilities.getVideoCapabilities()) == null) {
            return null;
        }
        int widthAlignment = videoCapabilities.getWidthAlignment();
        int heightAlignment = videoCapabilities.getHeightAlignment();
        return new Point(Util.ceilDivide(i, widthAlignment) * widthAlignment, Util.ceilDivide(i2, heightAlignment) * heightAlignment);
    }

    /* renamed from: b */
    public final void m2645b(String str) {
        StringBuilder m7065u = AbstractC1726qj.m7065u("NoSupport [", str, "] [");
        m7065u.append(this.name);
        m7065u.append(", ");
        m7065u.append(this.mimeType);
        m7065u.append("] [");
        m7065u.append(Util.DEVICE_DEBUG_INFO);
        m7065u.append("]");
        Log.m3021d(TAG, m7065u.toString());
    }

    public DecoderReuseEvaluation canReuseCodec(Format format, Format format2) {
        int i;
        int i2;
        if (!Util.areEqual(format.sampleMimeType, format2.sampleMimeType)) {
            i = 8;
        } else {
            i = 0;
        }
        if (this.f10652a) {
            if (format.rotationDegrees != format2.rotationDegrees) {
                i |= 1024;
            }
            if (!this.adaptive && (format.width != format2.width || format.height != format2.height)) {
                i |= 512;
            }
            if (!Util.areEqual(format.colorInfo, format2.colorInfo)) {
                i |= 2048;
            }
            String str = this.name;
            if (Util.MODEL.startsWith("SM-T230") && "OMX.MARVELL.VIDEO.HW.CODA7542DECODER".equals(str) && !format.initializationDataEquals(format2)) {
                i |= 2;
            }
            if (i == 0) {
                String str2 = this.name;
                if (format.initializationDataEquals(format2)) {
                    i2 = 3;
                } else {
                    i2 = 2;
                }
                return new DecoderReuseEvaluation(str2, format, format2, i2, 0);
            }
        } else {
            if (format.channelCount != format2.channelCount) {
                i |= 4096;
            }
            if (format.sampleRate != format2.sampleRate) {
                i |= 8192;
            }
            if (format.pcmEncoding != format2.pcmEncoding) {
                i |= 16384;
            }
            if (i == 0 && MimeTypes.AUDIO_AAC.equals(this.mimeType)) {
                Pair<Integer, Integer> codecProfileAndLevel = MediaCodecUtil.getCodecProfileAndLevel(format);
                Pair<Integer, Integer> codecProfileAndLevel2 = MediaCodecUtil.getCodecProfileAndLevel(format2);
                if (codecProfileAndLevel != null && codecProfileAndLevel2 != null) {
                    int intValue = ((Integer) codecProfileAndLevel.first).intValue();
                    int intValue2 = ((Integer) codecProfileAndLevel2.first).intValue();
                    if (intValue == 42 && intValue2 == 42) {
                        return new DecoderReuseEvaluation(this.name, format, format2, 3, 0);
                    }
                }
            }
            if (!format.initializationDataEquals(format2)) {
                i |= 32;
            }
            if (MimeTypes.AUDIO_OPUS.equals(this.mimeType)) {
                i |= 2;
            }
            if (i == 0) {
                return new DecoderReuseEvaluation(this.name, format, format2, 1, 0);
            }
        }
        return new DecoderReuseEvaluation(this.name, format, format2, 0, i);
    }

    public int getMaxSupportedInstances() {
        MediaCodecInfo.CodecCapabilities codecCapabilities;
        if (Util.SDK_INT >= 23 && (codecCapabilities = this.capabilities) != null) {
            return codecCapabilities.getMaxSupportedInstances();
        }
        return -1;
    }

    public MediaCodecInfo.CodecProfileLevel[] getProfileLevels() {
        MediaCodecInfo.CodecProfileLevel[] codecProfileLevelArr;
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.capabilities;
        if (codecCapabilities == null || (codecProfileLevelArr = codecCapabilities.profileLevels) == null) {
            return new MediaCodecInfo.CodecProfileLevel[0];
        }
        return codecProfileLevelArr;
    }

    @RequiresApi(21)
    public boolean isAudioChannelCountSupportedV21(int i) {
        int i2;
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.capabilities;
        if (codecCapabilities == null) {
            m2645b("channelCount.caps");
            return false;
        }
        MediaCodecInfo.AudioCapabilities audioCapabilities = codecCapabilities.getAudioCapabilities();
        if (audioCapabilities == null) {
            m2645b("channelCount.aCaps");
            return false;
        }
        String str = this.name;
        String str2 = this.mimeType;
        int maxInputChannelCount = audioCapabilities.getMaxInputChannelCount();
        if (maxInputChannelCount <= 1 && ((Util.SDK_INT < 26 || maxInputChannelCount <= 0) && !MimeTypes.AUDIO_MPEG.equals(str2) && !MimeTypes.AUDIO_AMR_NB.equals(str2) && !MimeTypes.AUDIO_AMR_WB.equals(str2) && !MimeTypes.AUDIO_AAC.equals(str2) && !MimeTypes.AUDIO_VORBIS.equals(str2) && !MimeTypes.AUDIO_OPUS.equals(str2) && !MimeTypes.AUDIO_RAW.equals(str2) && !MimeTypes.AUDIO_FLAC.equals(str2) && !MimeTypes.AUDIO_ALAW.equals(str2) && !MimeTypes.AUDIO_MLAW.equals(str2) && !MimeTypes.AUDIO_MSGSM.equals(str2))) {
            if (MimeTypes.AUDIO_AC3.equals(str2)) {
                i2 = 6;
            } else if (MimeTypes.AUDIO_E_AC3.equals(str2)) {
                i2 = 16;
            } else {
                i2 = 30;
            }
            Log.m3027w(TAG, "AssumedMaxChannelAdjustment: " + str + ", [" + maxInputChannelCount + " to " + i2 + "]");
            maxInputChannelCount = i2;
        }
        if (maxInputChannelCount >= i) {
            return true;
        }
        m2645b("channelCount.support, " + i);
        return false;
    }

    @RequiresApi(21)
    public boolean isAudioSampleRateSupportedV21(int i) {
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.capabilities;
        if (codecCapabilities == null) {
            m2645b("sampleRate.caps");
            return false;
        }
        MediaCodecInfo.AudioCapabilities audioCapabilities = codecCapabilities.getAudioCapabilities();
        if (audioCapabilities == null) {
            m2645b("sampleRate.aCaps");
            return false;
        }
        if (!audioCapabilities.isSampleRateSupported(i)) {
            m2645b("sampleRate.support, " + i);
            return false;
        }
        return true;
    }

    public boolean isFormatSupported(Format format) {
        int i;
        Pair<Integer, Integer> codecProfileAndLevel;
        int i2;
        MediaCodecInfo.VideoCapabilities videoCapabilities;
        boolean z = false;
        if (!this.mimeType.equals(format.sampleMimeType) && !this.mimeType.equals(MediaCodecUtil.getAlternativeCodecMimeType(format))) {
            return false;
        }
        String str = format.codecs;
        boolean z2 = this.f10652a;
        if (str != null && (codecProfileAndLevel = MediaCodecUtil.getCodecProfileAndLevel(format)) != null) {
            int intValue = ((Integer) codecProfileAndLevel.first).intValue();
            int intValue2 = ((Integer) codecProfileAndLevel.second).intValue();
            int i3 = 8;
            if (MimeTypes.VIDEO_DOLBY_VISION.equals(format.sampleMimeType)) {
                if (MimeTypes.VIDEO_H264.equals(this.mimeType)) {
                    intValue2 = 0;
                    intValue = 8;
                } else if (MimeTypes.VIDEO_H265.equals(this.mimeType)) {
                    intValue2 = 0;
                    intValue = 2;
                }
            }
            if (z2 || intValue == 42) {
                MediaCodecInfo.CodecProfileLevel[] profileLevels = getProfileLevels();
                if (Util.SDK_INT <= 23 && MimeTypes.VIDEO_VP9.equals(this.mimeType) && profileLevels.length == 0) {
                    MediaCodecInfo.CodecCapabilities codecCapabilities = this.capabilities;
                    if (codecCapabilities != null && (videoCapabilities = codecCapabilities.getVideoCapabilities()) != null) {
                        i2 = videoCapabilities.getBitrateRange().getUpper().intValue();
                    } else {
                        i2 = 0;
                    }
                    if (i2 >= 180000000) {
                        i3 = 1024;
                    } else if (i2 >= 120000000) {
                        i3 = 512;
                    } else if (i2 >= 60000000) {
                        i3 = 256;
                    } else if (i2 >= 30000000) {
                        i3 = 128;
                    } else if (i2 >= 18000000) {
                        i3 = 64;
                    } else if (i2 >= 12000000) {
                        i3 = 32;
                    } else if (i2 >= 7200000) {
                        i3 = 16;
                    } else if (i2 < 3600000) {
                        if (i2 >= 1800000) {
                            i3 = 4;
                        } else if (i2 >= 800000) {
                            i3 = 2;
                        } else {
                            i3 = 1;
                        }
                    }
                    MediaCodecInfo.CodecProfileLevel codecProfileLevel = new MediaCodecInfo.CodecProfileLevel();
                    codecProfileLevel.profile = 1;
                    codecProfileLevel.level = i3;
                    profileLevels = new MediaCodecInfo.CodecProfileLevel[]{codecProfileLevel};
                }
                for (MediaCodecInfo.CodecProfileLevel codecProfileLevel2 : profileLevels) {
                    if (codecProfileLevel2.profile == intValue && codecProfileLevel2.level >= intValue2) {
                        if (MimeTypes.VIDEO_H265.equals(this.mimeType) && 2 == intValue) {
                            String str2 = Util.DEVICE;
                            if (!"sailfish".equals(str2) && !"marlin".equals(str2)) {
                            }
                        }
                    }
                }
                m2645b("codec.profileLevel, " + format.codecs + ", " + this.codecMimeType);
                return false;
            }
        }
        if (z2) {
            int i4 = format.width;
            if (i4 <= 0 || (i = format.height) <= 0) {
                return true;
            }
            if (Util.SDK_INT >= 21) {
                return isVideoSizeAndRateSupportedV21(i4, i, format.frameRate);
            }
            if (i4 * i <= MediaCodecUtil.maxH264DecodableFrameSize()) {
                z = true;
            }
            if (!z) {
                m2645b("legacyFrameSize, " + format.width + "x" + format.height);
            }
            return z;
        }
        if (Util.SDK_INT >= 21) {
            int i5 = format.sampleRate;
            if (i5 != -1 && !isAudioSampleRateSupportedV21(i5)) {
                return false;
            }
            int i6 = format.channelCount;
            if (i6 != -1 && !isAudioChannelCountSupportedV21(i6)) {
                return false;
            }
        }
        return true;
    }

    public boolean isHdr10PlusOutOfBandMetadataSupported() {
        if (Util.SDK_INT >= 29 && MimeTypes.VIDEO_VP9.equals(this.mimeType)) {
            for (MediaCodecInfo.CodecProfileLevel codecProfileLevel : getProfileLevels()) {
                if (codecProfileLevel.profile == 16384) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isSeamlessAdaptationSupported(Format format) {
        if (this.f10652a) {
            return this.adaptive;
        }
        Pair<Integer, Integer> codecProfileAndLevel = MediaCodecUtil.getCodecProfileAndLevel(format);
        return codecProfileAndLevel != null && ((Integer) codecProfileAndLevel.first).intValue() == 42;
    }

    @RequiresApi(21)
    public boolean isVideoSizeAndRateSupportedV21(int i, int i2, double d) {
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.capabilities;
        if (codecCapabilities == null) {
            m2645b("sizeAndRate.caps");
            return false;
        }
        MediaCodecInfo.VideoCapabilities videoCapabilities = codecCapabilities.getVideoCapabilities();
        if (videoCapabilities == null) {
            m2645b("sizeAndRate.vCaps");
            return false;
        }
        if (!m2644a(videoCapabilities, i, i2, d)) {
            if (i < i2 && ((!"OMX.MTK.VIDEO.DECODER.HEVC".equals(this.name) || !"mcv5a".equals(Util.DEVICE)) && m2644a(videoCapabilities, i2, i, d))) {
                StringBuilder m8302v = ye0.m8302v("sizeAndRate.rotated, ", i, "x", i2, "x");
                m8302v.append(d);
                StringBuilder m7065u = AbstractC1726qj.m7065u("AssumedSupport [", m8302v.toString(), "] [");
                m7065u.append(this.name);
                m7065u.append(", ");
                m7065u.append(this.mimeType);
                m7065u.append("] [");
                m7065u.append(Util.DEVICE_DEBUG_INFO);
                m7065u.append("]");
                Log.m3021d(TAG, m7065u.toString());
                return true;
            }
            StringBuilder m8302v2 = ye0.m8302v("sizeAndRate.support, ", i, "x", i2, "x");
            m8302v2.append(d);
            m2645b(m8302v2.toString());
            return false;
        }
        return true;
    }

    public String toString() {
        return this.name;
    }

    @Deprecated
    public boolean isSeamlessAdaptationSupported(Format format, Format format2, boolean z) {
        if (!z && format.colorInfo != null && format2.colorInfo == null) {
            format2 = format2.buildUpon().setColorInfo(format.colorInfo).build();
        }
        int i = canReuseCodec(format, format2).result;
        return i == 2 || i == 3;
    }
}
