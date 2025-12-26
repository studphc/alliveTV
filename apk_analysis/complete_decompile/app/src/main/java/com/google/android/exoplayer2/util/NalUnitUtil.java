package com.google.android.exoplayer2.util;

import androidx.annotation.Nullable;
import com.google.common.base.Ascii;
import java.nio.ByteBuffer;
import java.util.Arrays;
import p000.AbstractC1726qj;

/* loaded from: classes.dex */
public final class NalUnitUtil {
    public static final int EXTENDED_SAR = 255;
    public static final int NAL_UNIT_TYPE_AUD = 9;
    public static final int NAL_UNIT_TYPE_IDR = 5;
    public static final int NAL_UNIT_TYPE_NON_IDR = 1;
    public static final int NAL_UNIT_TYPE_PARTITION_A = 2;
    public static final int NAL_UNIT_TYPE_PPS = 8;
    public static final int NAL_UNIT_TYPE_SEI = 6;
    public static final int NAL_UNIT_TYPE_SPS = 7;
    public static final byte[] NAL_START_CODE = {0, 0, 0, 1};
    public static final float[] ASPECT_RATIO_IDC_VALUES = {1.0f, 1.0f, 1.0909091f, 0.90909094f, 1.4545455f, 1.2121212f, 2.1818182f, 1.8181819f, 2.909091f, 2.4242425f, 1.6363636f, 1.3636364f, 1.939394f, 1.6161616f, 1.3333334f, 1.5f, 2.0f};

    /* renamed from: a */
    public static final Object f12730a = new Object();

    /* renamed from: b */
    public static int[] f12731b = new int[10];

    /* loaded from: classes.dex */
    public static final class H265SpsData {
        public final int[] constraintBytes;
        public final int generalLevelIdc;
        public final int generalProfileCompatibilityFlags;
        public final int generalProfileIdc;
        public final int generalProfileSpace;
        public final boolean generalTierFlag;
        public final int height;
        public final float pixelWidthHeightRatio;
        public final int seqParameterSetId;
        public final int width;

        public H265SpsData(int i, boolean z, int i2, int i3, int[] iArr, int i4, int i5, int i6, int i7, float f) {
            this.generalProfileSpace = i;
            this.generalTierFlag = z;
            this.generalProfileIdc = i2;
            this.generalProfileCompatibilityFlags = i3;
            this.constraintBytes = iArr;
            this.generalLevelIdc = i4;
            this.seqParameterSetId = i5;
            this.width = i6;
            this.height = i7;
            this.pixelWidthHeightRatio = f;
        }
    }

    /* loaded from: classes.dex */
    public static final class PpsData {
        public final boolean bottomFieldPicOrderInFramePresentFlag;
        public final int picParameterSetId;
        public final int seqParameterSetId;

        public PpsData(int i, int i2, boolean z) {
            this.picParameterSetId = i;
            this.seqParameterSetId = i2;
            this.bottomFieldPicOrderInFramePresentFlag = z;
        }
    }

    /* loaded from: classes.dex */
    public static final class SpsData {
        public final int constraintsFlagsAndReservedZero2Bits;
        public final boolean deltaPicOrderAlwaysZeroFlag;
        public final boolean frameMbsOnlyFlag;
        public final int frameNumLength;
        public final int height;
        public final int levelIdc;
        public final int maxNumRefFrames;
        public final int picOrderCntLsbLength;
        public final int picOrderCountType;
        public final float pixelWidthHeightRatio;
        public final int profileIdc;
        public final boolean separateColorPlaneFlag;
        public final int seqParameterSetId;
        public final int width;

        public SpsData(int i, int i2, int i3, int i4, int i5, int i6, int i7, float f, boolean z, boolean z2, int i8, int i9, int i10, boolean z3) {
            this.profileIdc = i;
            this.constraintsFlagsAndReservedZero2Bits = i2;
            this.levelIdc = i3;
            this.seqParameterSetId = i4;
            this.maxNumRefFrames = i5;
            this.width = i6;
            this.height = i7;
            this.pixelWidthHeightRatio = f;
            this.separateColorPlaneFlag = z;
            this.frameMbsOnlyFlag = z2;
            this.frameNumLength = i8;
            this.picOrderCountType = i9;
            this.picOrderCntLsbLength = i10;
            this.deltaPicOrderAlwaysZeroFlag = z3;
        }
    }

    public static void clearPrefixFlags(boolean[] zArr) {
        zArr[0] = false;
        zArr[1] = false;
        zArr[2] = false;
    }

    public static void discardToSps(ByteBuffer byteBuffer) {
        int position = byteBuffer.position();
        int i = 0;
        int i2 = 0;
        while (true) {
            int i3 = i + 1;
            if (i3 < position) {
                int i4 = byteBuffer.get(i) & 255;
                if (i2 == 3) {
                    if (i4 == 1 && (byteBuffer.get(i3) & Ascii.f14467US) == 7) {
                        ByteBuffer duplicate = byteBuffer.duplicate();
                        duplicate.position(i - 3);
                        duplicate.limit(position);
                        byteBuffer.position(0);
                        byteBuffer.put(duplicate);
                        return;
                    }
                } else if (i4 == 0) {
                    i2++;
                }
                if (i4 != 0) {
                    i2 = 0;
                }
                i = i3;
            } else {
                byteBuffer.clear();
                return;
            }
        }
    }

    public static int findNalUnit(byte[] bArr, int i, int i2, boolean[] zArr) {
        boolean z;
        boolean z2;
        boolean z3;
        int i3 = i2 - i;
        boolean z4 = false;
        if (i3 >= 0) {
            z = true;
        } else {
            z = false;
        }
        Assertions.checkState(z);
        if (i3 == 0) {
            return i2;
        }
        if (zArr[0]) {
            clearPrefixFlags(zArr);
            return i - 3;
        }
        if (i3 > 1 && zArr[1] && bArr[i] == 1) {
            clearPrefixFlags(zArr);
            return i - 2;
        }
        if (i3 > 2 && zArr[2] && bArr[i] == 0 && bArr[i + 1] == 1) {
            clearPrefixFlags(zArr);
            return i - 1;
        }
        int i4 = i2 - 1;
        int i5 = i + 2;
        while (i5 < i4) {
            byte b = bArr[i5];
            if ((b & 254) == 0) {
                int i6 = i5 - 2;
                if (bArr[i6] == 0 && bArr[i5 - 1] == 0 && b == 1) {
                    clearPrefixFlags(zArr);
                    return i6;
                }
                i5 -= 2;
            }
            i5 += 3;
        }
        if (i3 <= 2 ? !(i3 != 2 ? !zArr[1] || bArr[i4] != 1 : !zArr[2] || bArr[i2 - 2] != 0 || bArr[i4] != 1) : !(bArr[i2 - 3] != 0 || bArr[i2 - 2] != 0 || bArr[i4] != 1)) {
            z2 = true;
        } else {
            z2 = false;
        }
        zArr[0] = z2;
        if (i3 <= 1 ? !(!zArr[2] || bArr[i4] != 0) : !(bArr[i2 - 2] != 0 || bArr[i4] != 0)) {
            z3 = true;
        } else {
            z3 = false;
        }
        zArr[1] = z3;
        if (bArr[i4] == 0) {
            z4 = true;
        }
        zArr[2] = z4;
        return i2;
    }

    public static int getH265NalUnitType(byte[] bArr, int i) {
        return (bArr[i + 3] & 126) >> 1;
    }

    public static int getNalUnitType(byte[] bArr, int i) {
        return bArr[i + 3] & Ascii.f14467US;
    }

    public static boolean isNalUnitSei(@Nullable String str, byte b) {
        if (MimeTypes.VIDEO_H264.equals(str) && (b & Ascii.f14467US) == 6) {
            return true;
        }
        if (MimeTypes.VIDEO_H265.equals(str) && ((b & 126) >> 1) == 39) {
            return true;
        }
        return false;
    }

    public static H265SpsData parseH265SpsNalUnit(byte[] bArr, int i, int i2) {
        return parseH265SpsNalUnitPayload(bArr, i + 2, i2);
    }

    public static H265SpsData parseH265SpsNalUnitPayload(byte[] bArr, int i, int i2) {
        int i3;
        int i4;
        int i5;
        int i6;
        int[] iArr;
        int i7;
        boolean z;
        int[] iArr2;
        int i8;
        int i9;
        int i10;
        ParsableNalUnitBitArray parsableNalUnitBitArray = new ParsableNalUnitBitArray(bArr, i, i2);
        int i11 = 4;
        parsableNalUnitBitArray.skipBits(4);
        int readBits = parsableNalUnitBitArray.readBits(3);
        parsableNalUnitBitArray.skipBit();
        int readBits2 = parsableNalUnitBitArray.readBits(2);
        boolean readBit = parsableNalUnitBitArray.readBit();
        int readBits3 = parsableNalUnitBitArray.readBits(5);
        int i12 = 0;
        for (int i13 = 0; i13 < 32; i13++) {
            if (parsableNalUnitBitArray.readBit()) {
                i12 |= 1 << i13;
            }
        }
        int i14 = 6;
        int[] iArr3 = new int[6];
        for (int i15 = 0; i15 < 6; i15++) {
            iArr3[i15] = parsableNalUnitBitArray.readBits(8);
        }
        int readBits4 = parsableNalUnitBitArray.readBits(8);
        int i16 = 0;
        for (int i17 = 0; i17 < readBits; i17++) {
            if (parsableNalUnitBitArray.readBit()) {
                i16 += 89;
            }
            if (parsableNalUnitBitArray.readBit()) {
                i16 += 8;
            }
        }
        parsableNalUnitBitArray.skipBits(i16);
        if (readBits > 0) {
            parsableNalUnitBitArray.skipBits((8 - readBits) * 2);
        }
        int readUnsignedExpGolombCodedInt = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
        int readUnsignedExpGolombCodedInt2 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
        if (readUnsignedExpGolombCodedInt2 == 3) {
            parsableNalUnitBitArray.skipBit();
        }
        int readUnsignedExpGolombCodedInt3 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
        int readUnsignedExpGolombCodedInt4 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
        if (parsableNalUnitBitArray.readBit()) {
            int readUnsignedExpGolombCodedInt5 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
            int readUnsignedExpGolombCodedInt6 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
            int readUnsignedExpGolombCodedInt7 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
            int readUnsignedExpGolombCodedInt8 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
            if (readUnsignedExpGolombCodedInt2 != 1 && readUnsignedExpGolombCodedInt2 != 2) {
                i9 = 1;
            } else {
                i9 = 2;
            }
            if (readUnsignedExpGolombCodedInt2 == 1) {
                i10 = 2;
            } else {
                i10 = 1;
            }
            readUnsignedExpGolombCodedInt3 -= (readUnsignedExpGolombCodedInt5 + readUnsignedExpGolombCodedInt6) * i9;
            readUnsignedExpGolombCodedInt4 -= (readUnsignedExpGolombCodedInt7 + readUnsignedExpGolombCodedInt8) * i10;
        }
        int i18 = readUnsignedExpGolombCodedInt4;
        int i19 = readUnsignedExpGolombCodedInt3;
        parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
        parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
        int readUnsignedExpGolombCodedInt9 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
        if (parsableNalUnitBitArray.readBit()) {
            i3 = 0;
        } else {
            i3 = readBits;
        }
        for (int i20 = i3; i20 <= readBits; i20++) {
            parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
            parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
            parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
        }
        parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
        parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
        parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
        parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
        parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
        parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
        if (parsableNalUnitBitArray.readBit() && parsableNalUnitBitArray.readBit()) {
            int i21 = 0;
            while (i21 < i11) {
                int i22 = 0;
                while (i22 < i14) {
                    if (!parsableNalUnitBitArray.readBit()) {
                        parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
                    } else {
                        int min = Math.min(64, 1 << ((i21 << 1) + 4));
                        if (i21 > 1) {
                            parsableNalUnitBitArray.readSignedExpGolombCodedInt();
                        }
                        for (int i23 = 0; i23 < min; i23++) {
                            parsableNalUnitBitArray.readSignedExpGolombCodedInt();
                        }
                    }
                    if (i21 == 3) {
                        i8 = 3;
                    } else {
                        i8 = 1;
                    }
                    i22 += i8;
                    i14 = 6;
                }
                i21++;
                i11 = 4;
                i14 = 6;
            }
        }
        parsableNalUnitBitArray.skipBits(2);
        if (parsableNalUnitBitArray.readBit()) {
            parsableNalUnitBitArray.skipBits(8);
            parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
            parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
            parsableNalUnitBitArray.skipBit();
        }
        int readUnsignedExpGolombCodedInt10 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
        int[] iArr4 = new int[0];
        int[] iArr5 = new int[0];
        int i24 = -1;
        int i25 = 0;
        int i26 = -1;
        while (i25 < readUnsignedExpGolombCodedInt10) {
            if (i25 != 0 && parsableNalUnitBitArray.readBit()) {
                int i27 = i24 + i26;
                int readUnsignedExpGolombCodedInt11 = (1 - ((parsableNalUnitBitArray.readBit() ? 1 : 0) * 2)) * (parsableNalUnitBitArray.readUnsignedExpGolombCodedInt() + 1);
                i4 = readUnsignedExpGolombCodedInt10;
                int i28 = i27 + 1;
                i7 = readBits4;
                boolean[] zArr = new boolean[i28];
                iArr = iArr3;
                for (int i29 = 0; i29 <= i27; i29++) {
                    if (!parsableNalUnitBitArray.readBit()) {
                        zArr[i29] = parsableNalUnitBitArray.readBit();
                    } else {
                        zArr[i29] = true;
                    }
                }
                int[] iArr6 = new int[i28];
                int[] iArr7 = new int[i28];
                int i30 = 0;
                for (int i31 = i26 - 1; i31 >= 0; i31--) {
                    int i32 = iArr5[i31] + readUnsignedExpGolombCodedInt11;
                    if (i32 < 0 && zArr[i24 + i31]) {
                        iArr6[i30] = i32;
                        i30++;
                    }
                }
                if (readUnsignedExpGolombCodedInt11 < 0 && zArr[i27]) {
                    iArr6[i30] = readUnsignedExpGolombCodedInt11;
                    i30++;
                }
                i6 = i12;
                int i33 = i30;
                i5 = readBits3;
                for (int i34 = 0; i34 < i24; i34++) {
                    int i35 = iArr4[i34] + readUnsignedExpGolombCodedInt11;
                    if (i35 < 0 && zArr[i34]) {
                        iArr6[i33] = i35;
                        i33++;
                    }
                }
                int[] copyOf = Arrays.copyOf(iArr6, i33);
                int i36 = 0;
                for (int i37 = i24 - 1; i37 >= 0; i37--) {
                    int i38 = iArr4[i37] + readUnsignedExpGolombCodedInt11;
                    if (i38 > 0 && zArr[i37]) {
                        iArr7[i36] = i38;
                        i36++;
                    }
                }
                if (readUnsignedExpGolombCodedInt11 > 0 && zArr[i27]) {
                    iArr7[i36] = readUnsignedExpGolombCodedInt11;
                    i36++;
                }
                int i39 = i36;
                for (int i40 = 0; i40 < i26; i40++) {
                    int i41 = iArr5[i40] + readUnsignedExpGolombCodedInt11;
                    if (i41 > 0 && zArr[i24 + i40]) {
                        iArr7[i39] = i41;
                        i39++;
                    }
                }
                iArr2 = Arrays.copyOf(iArr7, i39);
                i26 = i39;
                iArr4 = copyOf;
                i24 = i33;
                z = true;
            } else {
                i4 = readUnsignedExpGolombCodedInt10;
                i5 = readBits3;
                i6 = i12;
                iArr = iArr3;
                i7 = readBits4;
                int readUnsignedExpGolombCodedInt12 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
                i26 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
                iArr4 = new int[readUnsignedExpGolombCodedInt12];
                for (int i42 = 0; i42 < readUnsignedExpGolombCodedInt12; i42++) {
                    iArr4[i42] = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt() + 1;
                    parsableNalUnitBitArray.skipBit();
                }
                z = true;
                int[] iArr8 = new int[i26];
                for (int i43 = 0; i43 < i26; i43++) {
                    iArr8[i43] = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt() + 1;
                    parsableNalUnitBitArray.skipBit();
                }
                i24 = readUnsignedExpGolombCodedInt12;
                iArr2 = iArr8;
            }
            i25++;
            readBits4 = i7;
            iArr3 = iArr;
            i12 = i6;
            readBits3 = i5;
            iArr5 = iArr2;
            readUnsignedExpGolombCodedInt10 = i4;
        }
        int i44 = readBits3;
        int i45 = i12;
        int[] iArr9 = iArr3;
        int i46 = readBits4;
        if (parsableNalUnitBitArray.readBit()) {
            for (int i47 = 0; i47 < parsableNalUnitBitArray.readUnsignedExpGolombCodedInt(); i47++) {
                parsableNalUnitBitArray.skipBits(readUnsignedExpGolombCodedInt9 + 5);
            }
        }
        parsableNalUnitBitArray.skipBits(2);
        float f = 1.0f;
        if (parsableNalUnitBitArray.readBit()) {
            if (parsableNalUnitBitArray.readBit()) {
                int readBits5 = parsableNalUnitBitArray.readBits(8);
                if (readBits5 == 255) {
                    int readBits6 = parsableNalUnitBitArray.readBits(16);
                    int readBits7 = parsableNalUnitBitArray.readBits(16);
                    if (readBits6 != 0 && readBits7 != 0) {
                        f = readBits6 / readBits7;
                    }
                } else {
                    float[] fArr = ASPECT_RATIO_IDC_VALUES;
                    if (readBits5 < fArr.length) {
                        f = fArr[readBits5];
                    } else {
                        AbstractC1726qj.m7036A(readBits5, "Unexpected aspect_ratio_idc value: ", "NalUnitUtil");
                    }
                }
            }
            if (parsableNalUnitBitArray.readBit()) {
                parsableNalUnitBitArray.skipBit();
            }
            if (parsableNalUnitBitArray.readBit()) {
                parsableNalUnitBitArray.skipBits(4);
                if (parsableNalUnitBitArray.readBit()) {
                    parsableNalUnitBitArray.skipBits(24);
                }
            }
            if (parsableNalUnitBitArray.readBit()) {
                parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
                parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
            }
            parsableNalUnitBitArray.skipBit();
            if (parsableNalUnitBitArray.readBit()) {
                i18 *= 2;
            }
        }
        return new H265SpsData(readBits2, readBit, i44, i45, iArr9, i46, readUnsignedExpGolombCodedInt, i19, i18, f);
    }

    public static PpsData parsePpsNalUnit(byte[] bArr, int i, int i2) {
        return parsePpsNalUnitPayload(bArr, i + 1, i2);
    }

    public static PpsData parsePpsNalUnitPayload(byte[] bArr, int i, int i2) {
        ParsableNalUnitBitArray parsableNalUnitBitArray = new ParsableNalUnitBitArray(bArr, i, i2);
        int readUnsignedExpGolombCodedInt = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
        int readUnsignedExpGolombCodedInt2 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
        parsableNalUnitBitArray.skipBit();
        return new PpsData(readUnsignedExpGolombCodedInt, readUnsignedExpGolombCodedInt2, parsableNalUnitBitArray.readBit());
    }

    public static SpsData parseSpsNalUnit(byte[] bArr, int i, int i2) {
        return parseSpsNalUnitPayload(bArr, i + 1, i2);
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0106  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0158  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x016b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static SpsData parseSpsNalUnitPayload(byte[] bArr, int i, int i2) {
        int readUnsignedExpGolombCodedInt;
        boolean z;
        int i3;
        int i4;
        int i5;
        int i6;
        boolean z2;
        boolean readBit;
        int readBits;
        int i7;
        int i8;
        int i9;
        int i10;
        ParsableNalUnitBitArray parsableNalUnitBitArray = new ParsableNalUnitBitArray(bArr, i, i2);
        int readBits2 = parsableNalUnitBitArray.readBits(8);
        int readBits3 = parsableNalUnitBitArray.readBits(8);
        int readBits4 = parsableNalUnitBitArray.readBits(8);
        int readUnsignedExpGolombCodedInt2 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
        int i11 = 1;
        if (readBits2 != 100 && readBits2 != 110 && readBits2 != 122 && readBits2 != 244 && readBits2 != 44 && readBits2 != 83 && readBits2 != 86 && readBits2 != 118 && readBits2 != 128 && readBits2 != 138) {
            readUnsignedExpGolombCodedInt = 1;
            z = false;
        } else {
            readUnsignedExpGolombCodedInt = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
            if (readUnsignedExpGolombCodedInt == 3) {
                z = parsableNalUnitBitArray.readBit();
            } else {
                z = false;
            }
            parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
            parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
            parsableNalUnitBitArray.skipBit();
            if (parsableNalUnitBitArray.readBit()) {
                if (readUnsignedExpGolombCodedInt != 3) {
                    i3 = 8;
                } else {
                    i3 = 12;
                }
                for (int i12 = 0; i12 < i3; i12++) {
                    if (parsableNalUnitBitArray.readBit()) {
                        if (i12 < 6) {
                            i4 = 16;
                        } else {
                            i4 = 64;
                        }
                        int i13 = 8;
                        int i14 = 8;
                        for (int i15 = 0; i15 < i4; i15++) {
                            if (i13 != 0) {
                                i13 = ((parsableNalUnitBitArray.readSignedExpGolombCodedInt() + i14) + 256) % 256;
                            }
                            if (i13 != 0) {
                                i14 = i13;
                            }
                        }
                    }
                }
            }
        }
        int readUnsignedExpGolombCodedInt3 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt() + 4;
        int readUnsignedExpGolombCodedInt4 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
        if (readUnsignedExpGolombCodedInt4 == 0) {
            i5 = readUnsignedExpGolombCodedInt;
            i6 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt() + 4;
        } else {
            if (readUnsignedExpGolombCodedInt4 == 1) {
                boolean readBit2 = parsableNalUnitBitArray.readBit();
                parsableNalUnitBitArray.readSignedExpGolombCodedInt();
                parsableNalUnitBitArray.readSignedExpGolombCodedInt();
                i5 = readUnsignedExpGolombCodedInt;
                long readUnsignedExpGolombCodedInt5 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
                for (int i16 = 0; i16 < readUnsignedExpGolombCodedInt5; i16++) {
                    parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
                }
                z2 = readBit2;
                i6 = 0;
                int readUnsignedExpGolombCodedInt6 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
                parsableNalUnitBitArray.skipBit();
                int readUnsignedExpGolombCodedInt7 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt() + 1;
                int readUnsignedExpGolombCodedInt8 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt() + 1;
                readBit = parsableNalUnitBitArray.readBit();
                int i17 = (2 - (readBit ? 1 : 0)) * readUnsignedExpGolombCodedInt8;
                if (!readBit) {
                    parsableNalUnitBitArray.skipBit();
                }
                parsableNalUnitBitArray.skipBit();
                int i18 = readUnsignedExpGolombCodedInt7 * 16;
                int i19 = i17 * 16;
                if (parsableNalUnitBitArray.readBit()) {
                    int readUnsignedExpGolombCodedInt9 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
                    int readUnsignedExpGolombCodedInt10 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
                    int readUnsignedExpGolombCodedInt11 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
                    int readUnsignedExpGolombCodedInt12 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
                    if (i5 == 0) {
                        i10 = 2 - (readBit ? 1 : 0);
                    } else {
                        int i20 = i5;
                        if (i20 == 3) {
                            i8 = 1;
                            i7 = 1;
                        } else {
                            i7 = 2;
                            i8 = 1;
                        }
                        if (i20 == i8) {
                            i9 = 2;
                        } else {
                            i9 = i8;
                        }
                        i10 = (2 - (readBit ? 1 : 0)) * i9;
                        i11 = i7;
                    }
                    i18 -= (readUnsignedExpGolombCodedInt9 + readUnsignedExpGolombCodedInt10) * i11;
                    i19 -= (readUnsignedExpGolombCodedInt11 + readUnsignedExpGolombCodedInt12) * i10;
                }
                int i21 = i18;
                int i22 = i19;
                float f = 1.0f;
                if (parsableNalUnitBitArray.readBit() && parsableNalUnitBitArray.readBit()) {
                    readBits = parsableNalUnitBitArray.readBits(8);
                    if (readBits != 255) {
                        int readBits5 = parsableNalUnitBitArray.readBits(16);
                        int readBits6 = parsableNalUnitBitArray.readBits(16);
                        if (readBits5 != 0 && readBits6 != 0) {
                            f = readBits5 / readBits6;
                        }
                    } else {
                        float[] fArr = ASPECT_RATIO_IDC_VALUES;
                        if (readBits < fArr.length) {
                            f = fArr[readBits];
                        } else {
                            AbstractC1726qj.m7036A(readBits, "Unexpected aspect_ratio_idc value: ", "NalUnitUtil");
                        }
                    }
                }
                return new SpsData(readBits2, readBits3, readBits4, readUnsignedExpGolombCodedInt2, readUnsignedExpGolombCodedInt6, i21, i22, f, z, readBit, readUnsignedExpGolombCodedInt3, readUnsignedExpGolombCodedInt4, i6, z2);
            }
            i5 = readUnsignedExpGolombCodedInt;
            i6 = 0;
        }
        z2 = false;
        int readUnsignedExpGolombCodedInt62 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
        parsableNalUnitBitArray.skipBit();
        int readUnsignedExpGolombCodedInt72 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt() + 1;
        int readUnsignedExpGolombCodedInt82 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt() + 1;
        readBit = parsableNalUnitBitArray.readBit();
        int i172 = (2 - (readBit ? 1 : 0)) * readUnsignedExpGolombCodedInt82;
        if (!readBit) {
        }
        parsableNalUnitBitArray.skipBit();
        int i182 = readUnsignedExpGolombCodedInt72 * 16;
        int i192 = i172 * 16;
        if (parsableNalUnitBitArray.readBit()) {
        }
        int i212 = i182;
        int i222 = i192;
        float f2 = 1.0f;
        if (parsableNalUnitBitArray.readBit()) {
            readBits = parsableNalUnitBitArray.readBits(8);
            if (readBits != 255) {
            }
        }
        return new SpsData(readBits2, readBits3, readBits4, readUnsignedExpGolombCodedInt2, readUnsignedExpGolombCodedInt62, i212, i222, f2, z, readBit, readUnsignedExpGolombCodedInt3, readUnsignedExpGolombCodedInt4, i6, z2);
    }

    public static int unescapeStream(byte[] bArr, int i) {
        int i2;
        synchronized (f12730a) {
            int i3 = 0;
            int i4 = 0;
            while (i3 < i) {
                while (true) {
                    if (i3 < i - 2) {
                        try {
                            if (bArr[i3] == 0 && bArr[i3 + 1] == 0 && bArr[i3 + 2] == 3) {
                                break;
                            }
                            i3++;
                        } catch (Throwable th) {
                            throw th;
                        }
                    } else {
                        i3 = i;
                        break;
                    }
                }
                if (i3 < i) {
                    int[] iArr = f12731b;
                    if (iArr.length <= i4) {
                        f12731b = Arrays.copyOf(iArr, iArr.length * 2);
                    }
                    f12731b[i4] = i3;
                    i3 += 3;
                    i4++;
                }
            }
            i2 = i - i4;
            int i5 = 0;
            int i6 = 0;
            for (int i7 = 0; i7 < i4; i7++) {
                int i8 = f12731b[i7] - i6;
                System.arraycopy(bArr, i6, bArr, i5, i8);
                int i9 = i5 + i8;
                int i10 = i9 + 1;
                bArr[i9] = 0;
                i5 = i9 + 2;
                bArr[i10] = 0;
                i6 += i8 + 3;
            }
            System.arraycopy(bArr, i6, bArr, i5, i2 - i5);
        }
        return i2;
    }
}
