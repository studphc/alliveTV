package com.google.android.exoplayer2.extractor.p002ts;

import com.google.android.exoplayer2.C0643C;
import com.google.android.exoplayer2.util.ParsableByteArray;

/* loaded from: classes.dex */
public final class TsUtil {
    public static int findSyncBytePosition(byte[] bArr, int i, int i2) {
        while (i < i2 && bArr[i] != 71) {
            i++;
        }
        return i;
    }

    public static boolean isStartOfTsPacket(byte[] bArr, int i, int i2, int i3) {
        int i4 = 0;
        for (int i5 = -4; i5 <= 4; i5++) {
            int i6 = (i5 * TsExtractor.TS_PACKET_SIZE) + i3;
            if (i6 >= i && i6 < i2 && bArr[i6] == 71) {
                i4++;
                if (i4 == 5) {
                    return true;
                }
            } else {
                i4 = 0;
            }
        }
        return false;
    }

    public static long readPcrFromPacket(ParsableByteArray parsableByteArray, int i, int i2) {
        parsableByteArray.setPosition(i);
        if (parsableByteArray.bytesLeft() < 5) {
            return C0643C.TIME_UNSET;
        }
        int readInt = parsableByteArray.readInt();
        if ((8388608 & readInt) != 0 || ((2096896 & readInt) >> 8) != i2 || (readInt & 32) == 0 || parsableByteArray.readUnsignedByte() < 7 || parsableByteArray.bytesLeft() < 7 || (parsableByteArray.readUnsignedByte() & 16) != 16) {
            return C0643C.TIME_UNSET;
        }
        parsableByteArray.readBytes(new byte[6], 0, 6);
        return ((r0[0] & 255) << 25) | ((r0[1] & 255) << 17) | ((r0[2] & 255) << 9) | ((r0[3] & 255) << 1) | ((r0[4] & 255) >> 7);
    }
}
