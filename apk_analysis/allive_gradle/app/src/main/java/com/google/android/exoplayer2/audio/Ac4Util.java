package com.google.android.exoplayer2.audio;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.PlaybackException;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.ParsableBitArray;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.common.primitives.SignedBytes;
import java.nio.ByteBuffer;
import okhttp3.internal.http.HttpStatusCodesKt;

/* loaded from: classes.dex */
public final class Ac4Util {
    public static final int AC40_SYNCWORD = 44096;
    public static final int AC41_SYNCWORD = 44097;
    public static final int HEADER_SIZE_FOR_PARSER = 16;
    public static final int MAX_RATE_BYTES_PER_SECOND = 336000;
    public static final int SAMPLE_HEADER_SIZE = 7;

    /* renamed from: a */
    public static final int[] f9636a = {PlaybackException.ERROR_CODE_IO_NETWORK_CONNECTION_TIMEOUT, 2000, 1920, 1601, 1600, 1001, 1000, 960, 800, 800, 480, HttpStatusCodesKt.HTTP_BAD_REQUEST, HttpStatusCodesKt.HTTP_BAD_REQUEST, 2048};

    /* loaded from: classes.dex */
    public static final class SyncFrameInfo {
        public final int bitstreamVersion;
        public final int channelCount = 2;
        public final int frameSize;
        public final int sampleCount;
        public final int sampleRate;

        public SyncFrameInfo(int i, int i2, int i3, int i4) {
            this.bitstreamVersion = i;
            this.sampleRate = i2;
            this.frameSize = i3;
            this.sampleCount = i4;
        }
    }

    public static void getAc4SampleHeader(int i, ParsableByteArray parsableByteArray) {
        parsableByteArray.reset(7);
        byte[] data = parsableByteArray.getData();
        data[0] = -84;
        data[1] = SignedBytes.MAX_POWER_OF_TWO;
        data[2] = -1;
        data[3] = -1;
        data[4] = (byte) ((i >> 16) & 255);
        data[5] = (byte) ((i >> 8) & 255);
        data[6] = (byte) (i & 255);
    }

    public static Format parseAc4AnnexEFormat(ParsableByteArray parsableByteArray, String str, String str2, @Nullable DrmInitData drmInitData) {
        int i;
        parsableByteArray.skipBytes(1);
        if (((parsableByteArray.readUnsignedByte() & 32) >> 5) == 1) {
            i = OpusUtil.SAMPLE_RATE;
        } else {
            i = 44100;
        }
        return new Format.Builder().setId(str).setSampleMimeType(MimeTypes.AUDIO_AC4).setChannelCount(2).setSampleRate(i).setDrmInitData(drmInitData).setLanguage(str2).build();
    }

    public static int parseAc4SyncframeAudioSampleCount(ByteBuffer byteBuffer) {
        byte[] bArr = new byte[16];
        int position = byteBuffer.position();
        byteBuffer.get(bArr);
        byteBuffer.position(position);
        return parseAc4SyncframeInfo(new ParsableBitArray(bArr)).sampleCount;
    }

    /* JADX WARN: Code restructure failed: missing block: B:42:0x008c, code lost:
    
        if (r11 != 11) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0093, code lost:
    
        if (r11 != 11) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0098, code lost:
    
        if (r11 != 8) goto L50;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static SyncFrameInfo parseAc4SyncframeInfo(ParsableBitArray parsableBitArray) {
        int i;
        int i2;
        int readBits;
        int readBits2 = parsableBitArray.readBits(16);
        int readBits3 = parsableBitArray.readBits(16);
        if (readBits3 == 65535) {
            readBits3 = parsableBitArray.readBits(24);
            i = 7;
        } else {
            i = 4;
        }
        int i3 = readBits3 + i;
        if (readBits2 == 44097) {
            i3 += 2;
        }
        int readBits4 = parsableBitArray.readBits(2);
        int i4 = 0;
        if (readBits4 == 3) {
            int i5 = 0;
            while (true) {
                readBits = parsableBitArray.readBits(2) + i5;
                if (!parsableBitArray.readBit()) {
                    break;
                }
                i5 = (readBits + 1) << 2;
            }
            readBits4 += readBits;
        }
        int readBits5 = parsableBitArray.readBits(10);
        if (parsableBitArray.readBit() && parsableBitArray.readBits(3) > 0) {
            parsableBitArray.skipBits(2);
        }
        if (parsableBitArray.readBit()) {
            i2 = 48000;
        } else {
            i2 = 44100;
        }
        int readBits6 = parsableBitArray.readBits(4);
        int[] iArr = f9636a;
        if (i2 == 44100 && readBits6 == 13) {
            i4 = iArr[readBits6];
        } else if (i2 == 48000 && readBits6 < 14) {
            i4 = iArr[readBits6];
            int i6 = readBits5 % 5;
            if (i6 != 1) {
                if (i6 != 2) {
                    if (i6 != 3) {
                        if (i6 == 4) {
                            if (readBits6 != 3) {
                                if (readBits6 != 8) {
                                }
                            }
                            i4++;
                        }
                    }
                } else {
                    if (readBits6 != 8) {
                    }
                    i4++;
                }
            }
            if (readBits6 != 3) {
            }
            i4++;
        }
        return new SyncFrameInfo(readBits4, i2, i3, i4);
    }

    public static int parseAc4SyncframeSize(byte[] bArr, int i) {
        int i2 = 7;
        if (bArr.length < 7) {
            return -1;
        }
        int i3 = ((bArr[2] & 255) << 8) | (bArr[3] & 255);
        if (i3 == 65535) {
            i3 = ((bArr[4] & 255) << 16) | ((bArr[5] & 255) << 8) | (bArr[6] & 255);
        } else {
            i2 = 4;
        }
        if (i == 44097) {
            i2 += 2;
        }
        return i3 + i2;
    }
}
