package com.google.android.exoplayer2.video;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.util.CodecSpecificDataUtil;
import com.google.android.exoplayer2.util.NalUnitUtil;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public final class AvcConfig {

    @Nullable
    public final String codecs;
    public final int height;
    public final List<byte[]> initializationData;
    public final int nalUnitLengthFieldLength;
    public final float pixelWidthHeightRatio;
    public final int width;

    public AvcConfig(ArrayList arrayList, int i, int i2, int i3, float f, String str) {
        this.initializationData = arrayList;
        this.nalUnitLengthFieldLength = i;
        this.width = i2;
        this.height = i3;
        this.pixelWidthHeightRatio = f;
        this.codecs = str;
    }

    public static AvcConfig parse(ParsableByteArray parsableByteArray) {
        int i;
        int i2;
        float f;
        String str;
        try {
            parsableByteArray.skipBytes(4);
            int readUnsignedByte = (parsableByteArray.readUnsignedByte() & 3) + 1;
            if (readUnsignedByte != 3) {
                ArrayList arrayList = new ArrayList();
                int readUnsignedByte2 = parsableByteArray.readUnsignedByte() & 31;
                for (int i3 = 0; i3 < readUnsignedByte2; i3++) {
                    int readUnsignedShort = parsableByteArray.readUnsignedShort();
                    int position = parsableByteArray.getPosition();
                    parsableByteArray.skipBytes(readUnsignedShort);
                    arrayList.add(CodecSpecificDataUtil.buildNalUnit(parsableByteArray.getData(), position, readUnsignedShort));
                }
                int readUnsignedByte3 = parsableByteArray.readUnsignedByte();
                for (int i4 = 0; i4 < readUnsignedByte3; i4++) {
                    int readUnsignedShort2 = parsableByteArray.readUnsignedShort();
                    int position2 = parsableByteArray.getPosition();
                    parsableByteArray.skipBytes(readUnsignedShort2);
                    arrayList.add(CodecSpecificDataUtil.buildNalUnit(parsableByteArray.getData(), position2, readUnsignedShort2));
                }
                if (readUnsignedByte2 > 0) {
                    NalUnitUtil.SpsData parseSpsNalUnit = NalUnitUtil.parseSpsNalUnit((byte[]) arrayList.get(0), readUnsignedByte, ((byte[]) arrayList.get(0)).length);
                    int i5 = parseSpsNalUnit.width;
                    int i6 = parseSpsNalUnit.height;
                    float f2 = parseSpsNalUnit.pixelWidthHeightRatio;
                    str = CodecSpecificDataUtil.buildAvcCodecString(parseSpsNalUnit.profileIdc, parseSpsNalUnit.constraintsFlagsAndReservedZero2Bits, parseSpsNalUnit.levelIdc);
                    i = i5;
                    i2 = i6;
                    f = f2;
                } else {
                    i = -1;
                    i2 = -1;
                    f = 1.0f;
                    str = null;
                }
                return new AvcConfig(arrayList, readUnsignedByte, i, i2, f, str);
            }
            throw new IllegalStateException();
        } catch (ArrayIndexOutOfBoundsException e) {
            throw ParserException.createForMalformedContainer("Error parsing AVC config", e);
        }
    }
}
