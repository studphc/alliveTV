package com.google.android.exoplayer2.audio;

import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.ParsableBitArray;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import p000.ye0;

/* loaded from: classes.dex */
public final class AacUtil {
    public static final int AAC_ELD_MAX_RATE_BYTES_PER_SECOND = 8000;
    public static final int AAC_HE_AUDIO_SAMPLE_COUNT = 2048;
    public static final int AAC_HE_V2_MAX_RATE_BYTES_PER_SECOND = 7000;
    public static final int AAC_LC_AUDIO_SAMPLE_COUNT = 1024;
    public static final int AAC_LC_MAX_RATE_BYTES_PER_SECOND = 100000;
    public static final int AAC_LD_AUDIO_SAMPLE_COUNT = 512;
    public static final int AAC_XHE_AUDIO_SAMPLE_COUNT = 1024;
    public static final int AAC_XHE_MAX_RATE_BYTES_PER_SECOND = 256000;
    public static final int AUDIO_OBJECT_TYPE_AAC_ELD = 23;
    public static final int AUDIO_OBJECT_TYPE_AAC_ER_BSAC = 22;
    public static final int AUDIO_OBJECT_TYPE_AAC_LC = 2;
    public static final int AUDIO_OBJECT_TYPE_AAC_PS = 29;
    public static final int AUDIO_OBJECT_TYPE_AAC_SBR = 5;
    public static final int AUDIO_OBJECT_TYPE_AAC_XHE = 42;
    public static final int AAC_HE_V1_MAX_RATE_BYTES_PER_SECOND = 16000;

    /* renamed from: a */
    public static final int[] f9628a = {96000, 88200, 64000, OpusUtil.SAMPLE_RATE, 44100, 32000, 24000, 22050, AAC_HE_V1_MAX_RATE_BYTES_PER_SECOND, 12000, 11025, 8000, 7350};

    /* renamed from: b */
    public static final int[] f9629b = {0, 1, 2, 3, 4, 5, 6, 8, -1, -1, -1, 7, 8, -1, 8, -1};

    @Target({ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface AacAudioObjectType {
    }

    /* loaded from: classes.dex */
    public static final class Config {
        public final int channelCount;
        public final String codecs;
        public final int sampleRateHz;

        public Config(int i, int i2, String str) {
            this.sampleRateHz = i;
            this.channelCount = i2;
            this.codecs = str;
        }
    }

    /* renamed from: a */
    public static int m2443a(ParsableBitArray parsableBitArray) {
        int readBits = parsableBitArray.readBits(4);
        if (readBits == 15) {
            return parsableBitArray.readBits(24);
        }
        if (readBits < 13) {
            return f9628a[readBits];
        }
        throw ParserException.createForMalformedContainer(null, null);
    }

    public static byte[] buildAacLcAudioSpecificConfig(int i, int i2) {
        int i3 = -1;
        for (int i4 = 0; i4 < 13; i4++) {
            if (i == f9628a[i4]) {
                i3 = i4;
            }
        }
        int i5 = -1;
        for (int i6 = 0; i6 < 16; i6++) {
            if (i2 == f9629b[i6]) {
                i5 = i6;
            }
        }
        if (i != -1 && i5 != -1) {
            return buildAudioSpecificConfig(2, i3, i5);
        }
        throw new IllegalArgumentException(ye0.m8293m(i, "Invalid sample rate or number of channels: ", ", ", i2));
    }

    public static byte[] buildAudioSpecificConfig(int i, int i2, int i3) {
        return new byte[]{(byte) (((i << 3) & 248) | ((i2 >> 1) & 7)), (byte) (((i2 << 7) & 128) | ((i3 << 3) & 120))};
    }

    public static Config parseAudioSpecificConfig(byte[] bArr) {
        return parseAudioSpecificConfig(new ParsableBitArray(bArr), false);
    }

    public static Config parseAudioSpecificConfig(ParsableBitArray parsableBitArray, boolean z) {
        int readBits = parsableBitArray.readBits(5);
        if (readBits == 31) {
            readBits = parsableBitArray.readBits(6) + 32;
        }
        int m2443a = m2443a(parsableBitArray);
        int readBits2 = parsableBitArray.readBits(4);
        String m8291k = ye0.m8291k(readBits, "mp4a.40.");
        if (readBits == 5 || readBits == 29) {
            m2443a = m2443a(parsableBitArray);
            int readBits3 = parsableBitArray.readBits(5);
            if (readBits3 == 31) {
                readBits3 = parsableBitArray.readBits(6) + 32;
            }
            readBits = readBits3;
            if (readBits == 22) {
                readBits2 = parsableBitArray.readBits(4);
            }
        }
        if (z) {
            if (readBits != 1 && readBits != 2 && readBits != 3 && readBits != 4 && readBits != 6 && readBits != 7 && readBits != 17) {
                switch (readBits) {
                    case 19:
                    case 20:
                    case 21:
                    case 22:
                    case 23:
                        break;
                    default:
                        throw ParserException.createForUnsupportedContainerFeature("Unsupported audio object type: " + readBits);
                }
            }
            if (parsableBitArray.readBit()) {
                Log.m3027w("AacUtil", "Unexpected frameLengthFlag = 1");
            }
            if (parsableBitArray.readBit()) {
                parsableBitArray.skipBits(14);
            }
            boolean readBit = parsableBitArray.readBit();
            if (readBits2 != 0) {
                if (readBits == 6 || readBits == 20) {
                    parsableBitArray.skipBits(3);
                }
                if (readBit) {
                    if (readBits == 22) {
                        parsableBitArray.skipBits(16);
                    }
                    if (readBits == 17 || readBits == 19 || readBits == 20 || readBits == 23) {
                        parsableBitArray.skipBits(3);
                    }
                    parsableBitArray.skipBits(1);
                }
                switch (readBits) {
                    case 17:
                    case 19:
                    case 20:
                    case 21:
                    case 22:
                    case 23:
                        int readBits4 = parsableBitArray.readBits(2);
                        if (readBits4 == 2 || readBits4 == 3) {
                            throw ParserException.createForUnsupportedContainerFeature("Unsupported epConfig: " + readBits4);
                        }
                }
            } else {
                throw new UnsupportedOperationException();
            }
        }
        int i = f9629b[readBits2];
        if (i != -1) {
            return new Config(m2443a, i, m8291k);
        }
        throw ParserException.createForMalformedContainer(null, null);
    }
}
