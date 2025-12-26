package com.google.android.exoplayer2.audio;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.util.MimeTypes;

/* loaded from: classes.dex */
public final class MpegAudioUtil {
    public static final int MAX_FRAME_SIZE_BYTES = 4096;

    /* renamed from: a */
    public static final String[] f9768a = {MimeTypes.AUDIO_MPEG_L1, MimeTypes.AUDIO_MPEG_L2, MimeTypes.AUDIO_MPEG};

    /* renamed from: b */
    public static final int[] f9769b = {44100, OpusUtil.SAMPLE_RATE, 32000};

    /* renamed from: c */
    public static final int[] f9770c = {32000, 64000, 96000, 128000, 160000, DtsUtil.DTS_MAX_RATE_BYTES_PER_SECOND, 224000, AacUtil.AAC_XHE_MAX_RATE_BYTES_PER_SECOND, 288000, 320000, 352000, 384000, 416000, 448000};

    /* renamed from: d */
    public static final int[] f9771d = {32000, OpusUtil.SAMPLE_RATE, 56000, 64000, Ac3Util.AC3_MAX_RATE_BYTES_PER_SECOND, 96000, 112000, 128000, 144000, 160000, 176000, DtsUtil.DTS_MAX_RATE_BYTES_PER_SECOND, 224000, AacUtil.AAC_XHE_MAX_RATE_BYTES_PER_SECOND};

    /* renamed from: e */
    public static final int[] f9772e = {32000, OpusUtil.SAMPLE_RATE, 56000, 64000, Ac3Util.AC3_MAX_RATE_BYTES_PER_SECOND, 96000, 112000, 128000, 160000, DtsUtil.DTS_MAX_RATE_BYTES_PER_SECOND, 224000, AacUtil.AAC_XHE_MAX_RATE_BYTES_PER_SECOND, 320000, 384000};
    public static final int MAX_RATE_BYTES_PER_SECOND = 40000;

    /* renamed from: f */
    public static final int[] f9773f = {32000, MAX_RATE_BYTES_PER_SECOND, OpusUtil.SAMPLE_RATE, 56000, 64000, Ac3Util.AC3_MAX_RATE_BYTES_PER_SECOND, 96000, 112000, 128000, 160000, DtsUtil.DTS_MAX_RATE_BYTES_PER_SECOND, 224000, AacUtil.AAC_XHE_MAX_RATE_BYTES_PER_SECOND, 320000};

    /* renamed from: g */
    public static final int[] f9774g = {8000, AacUtil.AAC_HE_V1_MAX_RATE_BYTES_PER_SECOND, 24000, 32000, MAX_RATE_BYTES_PER_SECOND, OpusUtil.SAMPLE_RATE, 56000, 64000, Ac3Util.AC3_MAX_RATE_BYTES_PER_SECOND, 96000, 112000, 128000, 144000, 160000};

    /* loaded from: classes.dex */
    public static final class Header {
        public int bitrate;
        public int channels;
        public int frameSize;

        @Nullable
        public String mimeType;
        public int sampleRate;
        public int samplesPerFrame;
        public int version;

        public boolean setForHeaderData(int i) {
            boolean z;
            int i2;
            int i3;
            int i4;
            int i5;
            int i6;
            int i7;
            if ((i & (-2097152)) == -2097152) {
                z = true;
            } else {
                z = false;
            }
            if (!z || (i2 = (i >>> 19) & 3) == 1 || (i3 = (i >>> 17) & 3) == 0 || (i4 = (i >>> 12) & 15) == 0 || i4 == 15 || (i5 = (i >>> 10) & 3) == 3) {
                return false;
            }
            this.version = i2;
            this.mimeType = MpegAudioUtil.f9768a[3 - i3];
            int i8 = MpegAudioUtil.f9769b[i5];
            this.sampleRate = i8;
            int i9 = 2;
            if (i2 == 2) {
                this.sampleRate = i8 / 2;
            } else if (i2 == 0) {
                this.sampleRate = i8 / 4;
            }
            int i10 = (i >>> 9) & 1;
            int i11 = 1152;
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 == 3) {
                        i11 = 384;
                    } else {
                        throw new IllegalArgumentException();
                    }
                }
            } else if (i2 != 3) {
                i11 = 576;
            }
            this.samplesPerFrame = i11;
            if (i3 == 3) {
                if (i2 == 3) {
                    i7 = MpegAudioUtil.f9770c[i4 - 1];
                } else {
                    i7 = MpegAudioUtil.f9771d[i4 - 1];
                }
                this.bitrate = i7;
                this.frameSize = (((i7 * 12) / this.sampleRate) + i10) * 4;
            } else {
                int i12 = 144;
                if (i2 == 3) {
                    if (i3 == 2) {
                        i6 = MpegAudioUtil.f9772e[i4 - 1];
                    } else {
                        i6 = MpegAudioUtil.f9773f[i4 - 1];
                    }
                    this.bitrate = i6;
                    this.frameSize = ((i6 * 144) / this.sampleRate) + i10;
                } else {
                    int i13 = MpegAudioUtil.f9774g[i4 - 1];
                    this.bitrate = i13;
                    if (i3 == 1) {
                        i12 = 72;
                    }
                    this.frameSize = ((i12 * i13) / this.sampleRate) + i10;
                }
            }
            if (((i >> 6) & 3) == 3) {
                i9 = 1;
            }
            this.channels = i9;
            return true;
        }
    }

    public static int getFrameSize(int i) {
        boolean z;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        if ((i & (-2097152)) == -2097152) {
            z = true;
        } else {
            z = false;
        }
        if (!z || (i2 = (i >>> 19) & 3) == 1 || (i3 = (i >>> 17) & 3) == 0 || (i4 = (i >>> 12) & 15) == 0 || i4 == 15 || (i5 = (i >>> 10) & 3) == 3) {
            return -1;
        }
        int i8 = f9769b[i5];
        if (i2 == 2) {
            i8 /= 2;
        } else if (i2 == 0) {
            i8 /= 4;
        }
        int i9 = (i >>> 9) & 1;
        if (i3 == 3) {
            if (i2 == 3) {
                i7 = f9770c[i4 - 1];
            } else {
                i7 = f9771d[i4 - 1];
            }
            return (((i7 * 12) / i8) + i9) * 4;
        }
        if (i2 == 3) {
            if (i3 == 2) {
                i6 = f9772e[i4 - 1];
            } else {
                i6 = f9773f[i4 - 1];
            }
        } else {
            i6 = f9774g[i4 - 1];
        }
        int i10 = 144;
        if (i2 == 3) {
            return ((i6 * 144) / i8) + i9;
        }
        if (i3 == 1) {
            i10 = 72;
        }
        return ((i10 * i6) / i8) + i9;
    }

    public static int parseMpegAudioFrameSampleCount(int i) {
        boolean z;
        int i2;
        int i3;
        if ((i & (-2097152)) == -2097152) {
            z = true;
        } else {
            z = false;
        }
        if (!z || (i2 = (i >>> 19) & 3) == 1 || (i3 = (i >>> 17) & 3) == 0) {
            return -1;
        }
        int i4 = (i >>> 12) & 15;
        int i5 = (i >>> 10) & 3;
        if (i4 == 0 || i4 == 15 || i5 == 3) {
            return -1;
        }
        if (i3 != 1) {
            if (i3 == 2) {
                return 1152;
            }
            if (i3 == 3) {
                return 384;
            }
            throw new IllegalArgumentException();
        }
        if (i2 == 3) {
            return 1152;
        }
        return 576;
    }
}
