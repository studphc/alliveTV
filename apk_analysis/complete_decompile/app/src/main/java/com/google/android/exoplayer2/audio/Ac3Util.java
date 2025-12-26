package com.google.android.exoplayer2.audio;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.extractor.p002ts.PsExtractor;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.ParsableBitArray;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.nio.ByteBuffer;
import okhttp3.internal.http.HttpStatusCodesKt;
import okio.Utf8;

/* loaded from: classes.dex */
public final class Ac3Util {
    public static final int AC3_MAX_RATE_BYTES_PER_SECOND = 80000;
    public static final int E_AC3_MAX_RATE_BYTES_PER_SECOND = 768000;
    public static final int TRUEHD_MAX_RATE_BYTES_PER_SECOND = 3062500;
    public static final int TRUEHD_RECHUNK_SAMPLE_COUNT = 16;
    public static final int TRUEHD_SYNCFRAME_PREFIX_LENGTH = 10;

    /* renamed from: a */
    public static final int[] f9630a = {1, 2, 3, 6};

    /* renamed from: b */
    public static final int[] f9631b = {OpusUtil.SAMPLE_RATE, 44100, 32000};

    /* renamed from: c */
    public static final int[] f9632c = {24000, 22050, AacUtil.AAC_HE_V1_MAX_RATE_BYTES_PER_SECOND};

    /* renamed from: d */
    public static final int[] f9633d = {2, 1, 2, 3, 3, 4, 4, 5};

    /* renamed from: e */
    public static final int[] f9634e = {32, 40, 48, 56, 64, 80, 96, 112, 128, 160, PsExtractor.AUDIO_STREAM, 224, 256, 320, 384, 448, 512, 576, 640};

    /* renamed from: f */
    public static final int[] f9635f = {69, 87, 104, 121, 139, 174, HttpStatusCodesKt.HTTP_ALREADY_REPORTED, 243, 278, 348, HttpStatusCodesKt.HTTP_EXPECTATION_FAILED, 487, 557, 696, 835, 975, 1114, 1253, 1393};

    /* loaded from: classes.dex */
    public static final class SyncFrameInfo {
        public static final int STREAM_TYPE_TYPE0 = 0;
        public static final int STREAM_TYPE_TYPE1 = 1;
        public static final int STREAM_TYPE_TYPE2 = 2;
        public static final int STREAM_TYPE_UNDEFINED = -1;
        public final int channelCount;
        public final int frameSize;

        @Nullable
        public final String mimeType;
        public final int sampleCount;
        public final int sampleRate;
        public final int streamType;

        @Target({ElementType.TYPE_USE})
        @Documented
        @Retention(RetentionPolicy.SOURCE)
        /* loaded from: classes.dex */
        public @interface StreamType {
        }

        public SyncFrameInfo(String str, int i, int i2, int i3, int i4, int i5) {
            this.mimeType = str;
            this.streamType = i;
            this.channelCount = i2;
            this.sampleRate = i3;
            this.frameSize = i4;
            this.sampleCount = i5;
        }
    }

    /* renamed from: a */
    public static int m2444a(int i, int i2) {
        int i3 = i2 / 2;
        if (i >= 0 && i < 3 && i2 >= 0 && i3 < 19) {
            int i4 = f9631b[i];
            if (i4 == 44100) {
                return ((i2 % 2) + f9635f[i3]) * 2;
            }
            int i5 = f9634e[i3];
            if (i4 == 32000) {
                return i5 * 6;
            }
            return i5 * 4;
        }
        return -1;
    }

    public static int findTrueHdSyncframeOffset(ByteBuffer byteBuffer) {
        int position = byteBuffer.position();
        int limit = byteBuffer.limit() - 10;
        for (int i = position; i <= limit; i++) {
            if ((Util.getBigEndianInt(byteBuffer, i + 4) & (-2)) == -126718022) {
                return i - position;
            }
        }
        return -1;
    }

    public static Format parseAc3AnnexFFormat(ParsableByteArray parsableByteArray, String str, String str2, @Nullable DrmInitData drmInitData) {
        int i = f9631b[(parsableByteArray.readUnsignedByte() & PsExtractor.AUDIO_STREAM) >> 6];
        int readUnsignedByte = parsableByteArray.readUnsignedByte();
        int i2 = f9633d[(readUnsignedByte & 56) >> 3];
        if ((readUnsignedByte & 4) != 0) {
            i2++;
        }
        return new Format.Builder().setId(str).setSampleMimeType(MimeTypes.AUDIO_AC3).setChannelCount(i2).setSampleRate(i).setDrmInitData(drmInitData).setLanguage(str2).build();
    }

    public static int parseAc3SyncframeAudioSampleCount(ByteBuffer byteBuffer) {
        int i = 3;
        if (((byteBuffer.get(byteBuffer.position() + 5) & 248) >> 3) > 10) {
            if (((byteBuffer.get(byteBuffer.position() + 4) & 192) >> 6) != 3) {
                i = (byteBuffer.get(byteBuffer.position() + 4) & 48) >> 4;
            }
            return f9630a[i] * 256;
        }
        return 1536;
    }

    public static SyncFrameInfo parseAc3SyncframeInfo(ParsableBitArray parsableBitArray) {
        boolean z;
        String str;
        int m2444a;
        int i;
        int i2;
        int i3;
        int i4;
        String str2;
        int readBits;
        int i5;
        int i6;
        String str3;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int position = parsableBitArray.getPosition();
        parsableBitArray.skipBits(40);
        if (parsableBitArray.readBits(5) > 10) {
            z = true;
        } else {
            z = false;
        }
        parsableBitArray.setPosition(position);
        int[] iArr = f9633d;
        int[] iArr2 = f9631b;
        int i12 = -1;
        if (z) {
            parsableBitArray.skipBits(16);
            int readBits2 = parsableBitArray.readBits(2);
            if (readBits2 != 0) {
                if (readBits2 != 1) {
                    if (readBits2 == 2) {
                        i12 = 2;
                    }
                } else {
                    i12 = 1;
                }
            } else {
                i12 = 0;
            }
            parsableBitArray.skipBits(3);
            m2444a = (parsableBitArray.readBits(11) + 1) * 2;
            int readBits3 = parsableBitArray.readBits(2);
            if (readBits3 == 3) {
                i2 = f9632c[parsableBitArray.readBits(2)];
                readBits = 3;
                i5 = 6;
            } else {
                readBits = parsableBitArray.readBits(2);
                int i13 = f9630a[readBits];
                i2 = iArr2[readBits3];
                i5 = i13;
            }
            i3 = i5 * 256;
            int readBits4 = parsableBitArray.readBits(3);
            boolean readBit = parsableBitArray.readBit();
            int i14 = iArr[readBits4] + (readBit ? 1 : 0);
            parsableBitArray.skipBits(10);
            if (parsableBitArray.readBit()) {
                parsableBitArray.skipBits(8);
            }
            if (readBits4 == 0) {
                parsableBitArray.skipBits(5);
                if (parsableBitArray.readBit()) {
                    parsableBitArray.skipBits(8);
                }
            }
            if (i12 == 1 && parsableBitArray.readBit()) {
                parsableBitArray.skipBits(16);
            }
            if (parsableBitArray.readBit()) {
                if (readBits4 > 2) {
                    parsableBitArray.skipBits(2);
                }
                if ((readBits4 & 1) != 0 && readBits4 > 2) {
                    i8 = 6;
                    parsableBitArray.skipBits(6);
                } else {
                    i8 = 6;
                }
                if ((readBits4 & 4) != 0) {
                    parsableBitArray.skipBits(i8);
                }
                if (readBit && parsableBitArray.readBit()) {
                    parsableBitArray.skipBits(5);
                }
                if (i12 == 0) {
                    if (parsableBitArray.readBit()) {
                        i9 = 6;
                        parsableBitArray.skipBits(6);
                    } else {
                        i9 = 6;
                    }
                    if (readBits4 == 0 && parsableBitArray.readBit()) {
                        parsableBitArray.skipBits(i9);
                    }
                    if (parsableBitArray.readBit()) {
                        parsableBitArray.skipBits(i9);
                    }
                    int readBits5 = parsableBitArray.readBits(2);
                    if (readBits5 == 1) {
                        parsableBitArray.skipBits(5);
                        i11 = 2;
                    } else {
                        if (readBits5 == 2) {
                            parsableBitArray.skipBits(12);
                        } else if (readBits5 == 3) {
                            int readBits6 = parsableBitArray.readBits(5);
                            if (parsableBitArray.readBit()) {
                                parsableBitArray.skipBits(5);
                                if (parsableBitArray.readBit()) {
                                    parsableBitArray.skipBits(4);
                                }
                                if (parsableBitArray.readBit()) {
                                    parsableBitArray.skipBits(4);
                                }
                                if (parsableBitArray.readBit()) {
                                    parsableBitArray.skipBits(4);
                                }
                                if (parsableBitArray.readBit()) {
                                    parsableBitArray.skipBits(4);
                                }
                                if (parsableBitArray.readBit()) {
                                    parsableBitArray.skipBits(4);
                                }
                                if (parsableBitArray.readBit()) {
                                    parsableBitArray.skipBits(4);
                                }
                                if (parsableBitArray.readBit()) {
                                    parsableBitArray.skipBits(4);
                                }
                                if (parsableBitArray.readBit()) {
                                    if (parsableBitArray.readBit()) {
                                        parsableBitArray.skipBits(4);
                                    }
                                    if (parsableBitArray.readBit()) {
                                        parsableBitArray.skipBits(4);
                                    }
                                }
                            }
                            if (parsableBitArray.readBit()) {
                                parsableBitArray.skipBits(5);
                                if (parsableBitArray.readBit()) {
                                    parsableBitArray.skipBits(7);
                                    if (parsableBitArray.readBit()) {
                                        i10 = 8;
                                        parsableBitArray.skipBits(8);
                                        i11 = 2;
                                        parsableBitArray.skipBits((readBits6 + 2) * i10);
                                        parsableBitArray.byteAlign();
                                    }
                                }
                            }
                            i10 = 8;
                            i11 = 2;
                            parsableBitArray.skipBits((readBits6 + 2) * i10);
                            parsableBitArray.byteAlign();
                        }
                        i11 = 2;
                    }
                    if (readBits4 < i11) {
                        if (parsableBitArray.readBit()) {
                            parsableBitArray.skipBits(14);
                        }
                        if (readBits4 == 0 && parsableBitArray.readBit()) {
                            parsableBitArray.skipBits(14);
                        }
                    }
                    if (parsableBitArray.readBit()) {
                        if (readBits == 0) {
                            parsableBitArray.skipBits(5);
                        } else {
                            for (int i15 = 0; i15 < i5; i15++) {
                                if (parsableBitArray.readBit()) {
                                    parsableBitArray.skipBits(5);
                                }
                            }
                        }
                    }
                }
            }
            if (parsableBitArray.readBit()) {
                parsableBitArray.skipBits(5);
                if (readBits4 == 2) {
                    parsableBitArray.skipBits(4);
                }
                if (readBits4 >= 6) {
                    parsableBitArray.skipBits(2);
                }
                if (parsableBitArray.readBit()) {
                    i7 = 8;
                    parsableBitArray.skipBits(8);
                } else {
                    i7 = 8;
                }
                if (readBits4 == 0 && parsableBitArray.readBit()) {
                    parsableBitArray.skipBits(i7);
                }
                if (readBits3 < 3) {
                    parsableBitArray.skipBit();
                }
            }
            if (i12 == 0 && readBits != 3) {
                parsableBitArray.skipBit();
            }
            if (i12 == 2 && (readBits == 3 || parsableBitArray.readBit())) {
                i6 = 6;
                parsableBitArray.skipBits(6);
            } else {
                i6 = 6;
            }
            if (parsableBitArray.readBit() && parsableBitArray.readBits(i6) == 1 && parsableBitArray.readBits(8) == 1) {
                str3 = MimeTypes.AUDIO_E_AC3_JOC;
            } else {
                str3 = MimeTypes.AUDIO_E_AC3;
            }
            str2 = str3;
            i4 = i14;
        } else {
            parsableBitArray.skipBits(32);
            int readBits7 = parsableBitArray.readBits(2);
            if (readBits7 == 3) {
                str = null;
            } else {
                str = MimeTypes.AUDIO_AC3;
            }
            m2444a = m2444a(readBits7, parsableBitArray.readBits(6));
            parsableBitArray.skipBits(8);
            int readBits8 = parsableBitArray.readBits(3);
            if ((readBits8 & 1) != 0 && readBits8 != 1) {
                i = 2;
                parsableBitArray.skipBits(2);
            } else {
                i = 2;
            }
            if ((readBits8 & 4) != 0) {
                parsableBitArray.skipBits(i);
            }
            if (readBits8 == i) {
                parsableBitArray.skipBits(i);
            }
            if (readBits7 < 3) {
                i2 = iArr2[readBits7];
            } else {
                i2 = -1;
            }
            i3 = 1536;
            i4 = iArr[readBits8] + (parsableBitArray.readBit() ? 1 : 0);
            str2 = str;
        }
        return new SyncFrameInfo(str2, i12, i4, i2, m2444a, i3);
    }

    public static int parseAc3SyncframeSize(byte[] bArr) {
        if (bArr.length < 6) {
            return -1;
        }
        if (((bArr[5] & 248) >> 3) > 10) {
            return (((bArr[3] & 255) | ((bArr[2] & 7) << 8)) + 1) * 2;
        }
        byte b = bArr[4];
        return m2444a((b & 192) >> 6, b & Utf8.REPLACEMENT_BYTE);
    }

    public static Format parseEAc3AnnexFFormat(ParsableByteArray parsableByteArray, String str, String str2, @Nullable DrmInitData drmInitData) {
        String str3;
        parsableByteArray.skipBytes(2);
        int i = f9631b[(parsableByteArray.readUnsignedByte() & PsExtractor.AUDIO_STREAM) >> 6];
        int readUnsignedByte = parsableByteArray.readUnsignedByte();
        int i2 = f9633d[(readUnsignedByte & 14) >> 1];
        if ((readUnsignedByte & 1) != 0) {
            i2++;
        }
        if (((parsableByteArray.readUnsignedByte() & 30) >> 1) > 0 && (2 & parsableByteArray.readUnsignedByte()) != 0) {
            i2 += 2;
        }
        if (parsableByteArray.bytesLeft() > 0 && (parsableByteArray.readUnsignedByte() & 1) != 0) {
            str3 = MimeTypes.AUDIO_E_AC3_JOC;
        } else {
            str3 = MimeTypes.AUDIO_E_AC3;
        }
        return new Format.Builder().setId(str).setSampleMimeType(str3).setChannelCount(i2).setSampleRate(i).setDrmInitData(drmInitData).setLanguage(str2).build();
    }

    public static int parseTrueHdSyncframeAudioSampleCount(byte[] bArr) {
        if (bArr[4] == -8 && bArr[5] == 114 && bArr[6] == 111) {
            byte b = bArr[7];
            if ((b & 254) == 186) {
                return 40 << ((bArr[(b & 255) == 187 ? '\t' : '\b'] >> 4) & 7);
            }
        }
        return 0;
    }

    public static int parseTrueHdSyncframeAudioSampleCount(ByteBuffer byteBuffer, int i) {
        return 40 << ((byteBuffer.get((byteBuffer.position() + i) + ((byteBuffer.get((byteBuffer.position() + i) + 7) & 255) == 187 ? 9 : 8)) >> 4) & 7);
    }
}
