package com.google.android.exoplayer2.util;

import android.util.Pair;
import androidx.annotation.Nullable;
import androidx.exifinterface.media.ExifInterface;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public final class CodecSpecificDataUtil {

    /* renamed from: a */
    public static final byte[] f12669a = {0, 0, 0, 1};

    /* renamed from: b */
    public static final String[] f12670b = {"", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "B", "C"};

    public static String buildAvcCodecString(int i, int i2, int i3) {
        return String.format("avc1.%02X%02X%02X", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3));
    }

    public static List<byte[]> buildCea708InitializationData(boolean z) {
        byte[] bArr;
        if (z) {
            bArr = new byte[]{1};
        } else {
            bArr = new byte[]{0};
        }
        return Collections.singletonList(bArr);
    }

    public static String buildHevcCodecString(int i, boolean z, int i2, int i3, int[] iArr, int i4) {
        char c;
        String str = f12670b[i];
        Integer valueOf = Integer.valueOf(i2);
        Integer valueOf2 = Integer.valueOf(i3);
        if (z) {
            c = 'H';
        } else {
            c = 'L';
        }
        StringBuilder sb = new StringBuilder(Util.formatInvariant("hvc1.%s%d.%X.%c%d", str, valueOf, valueOf2, Character.valueOf(c), Integer.valueOf(i4)));
        int length = iArr.length;
        while (length > 0 && iArr[length - 1] == 0) {
            length--;
        }
        for (int i5 = 0; i5 < length; i5++) {
            sb.append(String.format(".%02X", Integer.valueOf(iArr[i5])));
        }
        return sb.toString();
    }

    public static byte[] buildNalUnit(byte[] bArr, int i, int i2) {
        byte[] bArr2 = new byte[i2 + 4];
        System.arraycopy(f12669a, 0, bArr2, 0, 4);
        System.arraycopy(bArr, i, bArr2, 4, i2);
        return bArr2;
    }

    public static Pair<Integer, Integer> getVideoResolutionFromMpeg4VideoConfig(byte[] bArr) {
        boolean z;
        boolean z2;
        boolean z3;
        ParsableByteArray parsableByteArray = new ParsableByteArray(bArr);
        int i = 0;
        int i2 = 0;
        while (true) {
            int i3 = i2 + 3;
            if (i3 < bArr.length) {
                if (parsableByteArray.readUnsignedInt24() == 1 && (bArr[i3] & 240) == 32) {
                    z = true;
                    break;
                }
                parsableByteArray.setPosition(parsableByteArray.getPosition() - 2);
                i2++;
            } else {
                z = false;
                break;
            }
        }
        Assertions.checkArgument(z, "Invalid input: VOL not found.");
        ParsableBitArray parsableBitArray = new ParsableBitArray(bArr);
        parsableBitArray.skipBits((i2 + 4) * 8);
        parsableBitArray.skipBits(1);
        parsableBitArray.skipBits(8);
        if (parsableBitArray.readBit()) {
            parsableBitArray.skipBits(4);
            parsableBitArray.skipBits(3);
        }
        if (parsableBitArray.readBits(4) == 15) {
            parsableBitArray.skipBits(8);
            parsableBitArray.skipBits(8);
        }
        if (parsableBitArray.readBit()) {
            parsableBitArray.skipBits(2);
            parsableBitArray.skipBits(1);
            if (parsableBitArray.readBit()) {
                parsableBitArray.skipBits(79);
            }
        }
        if (parsableBitArray.readBits(2) == 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        Assertions.checkArgument(z2, "Only supports rectangular video object layer shape.");
        Assertions.checkArgument(parsableBitArray.readBit());
        int readBits = parsableBitArray.readBits(16);
        Assertions.checkArgument(parsableBitArray.readBit());
        if (parsableBitArray.readBit()) {
            if (readBits > 0) {
                z3 = true;
            } else {
                z3 = false;
            }
            Assertions.checkArgument(z3);
            for (int i4 = readBits - 1; i4 > 0; i4 >>= 1) {
                i++;
            }
            parsableBitArray.skipBits(i);
        }
        Assertions.checkArgument(parsableBitArray.readBit());
        int readBits2 = parsableBitArray.readBits(13);
        Assertions.checkArgument(parsableBitArray.readBit());
        int readBits3 = parsableBitArray.readBits(13);
        Assertions.checkArgument(parsableBitArray.readBit());
        parsableBitArray.skipBits(1);
        return Pair.create(Integer.valueOf(readBits2), Integer.valueOf(readBits3));
    }

    public static Pair<Integer, Integer> parseAlacAudioSpecificConfig(byte[] bArr) {
        ParsableByteArray parsableByteArray = new ParsableByteArray(bArr);
        parsableByteArray.setPosition(9);
        int readUnsignedByte = parsableByteArray.readUnsignedByte();
        parsableByteArray.setPosition(20);
        return Pair.create(Integer.valueOf(parsableByteArray.readUnsignedIntToInt()), Integer.valueOf(readUnsignedByte));
    }

    public static boolean parseCea708InitializationData(List<byte[]> list) {
        if (list.size() != 1 || list.get(0).length != 1 || list.get(0)[0] != 1) {
            return false;
        }
        return true;
    }

    @Nullable
    public static byte[][] splitNalUnits(byte[] bArr) {
        int length;
        if (bArr.length > 4) {
            int i = 0;
            while (true) {
                byte[] bArr2 = f12669a;
                if (i < 4) {
                    if (bArr[i] != bArr2[i]) {
                        return null;
                    }
                    i++;
                } else {
                    ArrayList arrayList = new ArrayList();
                    int i2 = 0;
                    do {
                        arrayList.add(Integer.valueOf(i2));
                        i2 += 4;
                        int length2 = bArr.length - 4;
                        while (true) {
                            if (i2 <= length2) {
                                if (bArr.length - i2 > 4) {
                                    for (int i3 = 0; i3 < 4; i3++) {
                                        if (bArr[i2 + i3] != bArr2[i3]) {
                                            break;
                                        }
                                    }
                                    break;
                                }
                                i2++;
                            } else {
                                i2 = -1;
                                break;
                            }
                        }
                    } while (i2 != -1);
                    byte[][] bArr3 = new byte[arrayList.size()];
                    for (int i4 = 0; i4 < arrayList.size(); i4++) {
                        int intValue = ((Integer) arrayList.get(i4)).intValue();
                        if (i4 < arrayList.size() - 1) {
                            length = ((Integer) arrayList.get(i4 + 1)).intValue();
                        } else {
                            length = bArr.length;
                        }
                        int i5 = length - intValue;
                        byte[] bArr4 = new byte[i5];
                        System.arraycopy(bArr, intValue, bArr4, 0, i5);
                        bArr3[i4] = bArr4;
                    }
                    return bArr3;
                }
            }
        } else {
            return null;
        }
    }
}
