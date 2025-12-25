package com.google.android.exoplayer2.video;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.util.CodecSpecificDataUtil;
import com.google.android.exoplayer2.util.NalUnitUtil;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public final class HevcConfig {

    @Nullable
    public final String codecs;
    public final int height;
    public final List<byte[]> initializationData;
    public final int nalUnitLengthFieldLength;
    public final float pixelWidthHeightRatio;
    public final int width;

    public HevcConfig(List list, int i, int i2, int i3, float f, String str) {
        this.initializationData = list;
        this.nalUnitLengthFieldLength = i;
        this.width = i2;
        this.height = i3;
        this.pixelWidthHeightRatio = f;
        this.codecs = str;
    }

    public static HevcConfig parse(ParsableByteArray parsableByteArray) {
        List singletonList;
        int i;
        int i2;
        try {
            parsableByteArray.skipBytes(21);
            int readUnsignedByte = parsableByteArray.readUnsignedByte() & 3;
            int readUnsignedByte2 = parsableByteArray.readUnsignedByte();
            int position = parsableByteArray.getPosition();
            int i3 = 0;
            int i4 = 0;
            for (int i5 = 0; i5 < readUnsignedByte2; i5++) {
                parsableByteArray.skipBytes(1);
                int readUnsignedShort = parsableByteArray.readUnsignedShort();
                for (int i6 = 0; i6 < readUnsignedShort; i6++) {
                    int readUnsignedShort2 = parsableByteArray.readUnsignedShort();
                    i4 += readUnsignedShort2 + 4;
                    parsableByteArray.skipBytes(readUnsignedShort2);
                }
            }
            parsableByteArray.setPosition(position);
            byte[] bArr = new byte[i4];
            int i7 = -1;
            int i8 = -1;
            float f = 1.0f;
            String str = null;
            int i9 = 0;
            int i10 = 0;
            while (i9 < readUnsignedByte2) {
                int readUnsignedByte3 = parsableByteArray.readUnsignedByte() & 127;
                int readUnsignedShort3 = parsableByteArray.readUnsignedShort();
                int i11 = i3;
                while (i11 < readUnsignedShort3) {
                    int readUnsignedShort4 = parsableByteArray.readUnsignedShort();
                    byte[] bArr2 = NalUnitUtil.NAL_START_CODE;
                    int i12 = readUnsignedByte2;
                    System.arraycopy(bArr2, i3, bArr, i10, bArr2.length);
                    int length = i10 + bArr2.length;
                    System.arraycopy(parsableByteArray.getData(), parsableByteArray.getPosition(), bArr, length, readUnsignedShort4);
                    if (readUnsignedByte3 == 33 && i11 == 0) {
                        NalUnitUtil.H265SpsData parseH265SpsNalUnit = NalUnitUtil.parseH265SpsNalUnit(bArr, length, length + readUnsignedShort4);
                        int i13 = parseH265SpsNalUnit.width;
                        i8 = parseH265SpsNalUnit.height;
                        f = parseH265SpsNalUnit.pixelWidthHeightRatio;
                        i = readUnsignedByte3;
                        i2 = readUnsignedShort3;
                        i7 = i13;
                        str = CodecSpecificDataUtil.buildHevcCodecString(parseH265SpsNalUnit.generalProfileSpace, parseH265SpsNalUnit.generalTierFlag, parseH265SpsNalUnit.generalProfileIdc, parseH265SpsNalUnit.generalProfileCompatibilityFlags, parseH265SpsNalUnit.constraintBytes, parseH265SpsNalUnit.generalLevelIdc);
                    } else {
                        i = readUnsignedByte3;
                        i2 = readUnsignedShort3;
                    }
                    i10 = length + readUnsignedShort4;
                    parsableByteArray.skipBytes(readUnsignedShort4);
                    i11++;
                    readUnsignedByte2 = i12;
                    readUnsignedByte3 = i;
                    readUnsignedShort3 = i2;
                    i3 = 0;
                }
                i9++;
                i3 = 0;
            }
            if (i4 == 0) {
                singletonList = Collections.emptyList();
            } else {
                singletonList = Collections.singletonList(bArr);
            }
            return new HevcConfig(singletonList, readUnsignedByte + 1, i7, i8, f, str);
        } catch (ArrayIndexOutOfBoundsException e) {
            throw ParserException.createForMalformedContainer("Error parsing HEVC config", e);
        }
    }
}
