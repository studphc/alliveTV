package com.google.android.exoplayer2.extractor;

import android.util.Base64;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.extractor.p002ts.PsExtractor;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.flac.PictureFrame;
import com.google.android.exoplayer2.metadata.vorbis.VorbisComment;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import p000.ye0;

/* loaded from: classes.dex */
public final class VorbisUtil {

    /* loaded from: classes.dex */
    public static final class CommentHeader {
        public final String[] comments;
        public final int length;
        public final String vendor;

        public CommentHeader(String str, String[] strArr, int i) {
            this.vendor = str;
            this.comments = strArr;
            this.length = i;
        }
    }

    /* loaded from: classes.dex */
    public static final class Mode {
        public final boolean blockFlag;
        public final int mapping;
        public final int transformType;
        public final int windowType;

        public Mode(boolean z, int i, int i2, int i3) {
            this.blockFlag = z;
            this.windowType = i;
            this.transformType = i2;
            this.mapping = i3;
        }
    }

    /* loaded from: classes.dex */
    public static final class VorbisIdHeader {
        public final int bitrateMaximum;
        public final int bitrateMinimum;
        public final int bitrateNominal;
        public final int blockSize0;
        public final int blockSize1;
        public final int channels;
        public final byte[] data;
        public final boolean framingFlag;
        public final int sampleRate;
        public final int version;

        public VorbisIdHeader(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z, byte[] bArr) {
            this.version = i;
            this.channels = i2;
            this.sampleRate = i3;
            this.bitrateMaximum = i4;
            this.bitrateNominal = i5;
            this.bitrateMinimum = i6;
            this.blockSize0 = i7;
            this.blockSize1 = i8;
            this.framingFlag = z;
            this.data = bArr;
        }
    }

    public static int iLog(int i) {
        int i2 = 0;
        while (i > 0) {
            i2++;
            i >>>= 1;
        }
        return i2;
    }

    @Nullable
    public static Metadata parseVorbisComments(List<String> list) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            String str = list.get(i);
            String[] splitAtFirst = Util.splitAtFirst(str, "=");
            if (splitAtFirst.length != 2) {
                ye0.m8279B("Failed to parse Vorbis comment: ", str, "VorbisUtil");
            } else if (splitAtFirst[0].equals("METADATA_BLOCK_PICTURE")) {
                try {
                    arrayList.add(PictureFrame.fromPictureBlock(new ParsableByteArray(Base64.decode(splitAtFirst[1], 0))));
                } catch (RuntimeException e) {
                    Log.m3028w("VorbisUtil", "Failed to parse vorbis picture", e);
                }
            } else {
                arrayList.add(new VorbisComment(splitAtFirst[0], splitAtFirst[1]));
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return new Metadata(arrayList);
    }

    public static CommentHeader readVorbisCommentHeader(ParsableByteArray parsableByteArray) {
        return readVorbisCommentHeader(parsableByteArray, true, true);
    }

    public static VorbisIdHeader readVorbisIdentificationHeader(ParsableByteArray parsableByteArray) {
        boolean z = true;
        verifyVorbisHeaderCapturePattern(1, parsableByteArray, false);
        int readLittleEndianUnsignedIntToInt = parsableByteArray.readLittleEndianUnsignedIntToInt();
        int readUnsignedByte = parsableByteArray.readUnsignedByte();
        int readLittleEndianUnsignedIntToInt2 = parsableByteArray.readLittleEndianUnsignedIntToInt();
        int readLittleEndianInt = parsableByteArray.readLittleEndianInt();
        if (readLittleEndianInt <= 0) {
            readLittleEndianInt = -1;
        }
        int readLittleEndianInt2 = parsableByteArray.readLittleEndianInt();
        if (readLittleEndianInt2 <= 0) {
            readLittleEndianInt2 = -1;
        }
        int readLittleEndianInt3 = parsableByteArray.readLittleEndianInt();
        if (readLittleEndianInt3 <= 0) {
            readLittleEndianInt3 = -1;
        }
        int readUnsignedByte2 = parsableByteArray.readUnsignedByte();
        int pow = (int) Math.pow(2.0d, readUnsignedByte2 & 15);
        int pow2 = (int) Math.pow(2.0d, (readUnsignedByte2 & PsExtractor.VIDEO_STREAM_MASK) >> 4);
        if ((parsableByteArray.readUnsignedByte() & 1) <= 0) {
            z = false;
        }
        return new VorbisIdHeader(readLittleEndianUnsignedIntToInt, readUnsignedByte, readLittleEndianUnsignedIntToInt2, readLittleEndianInt, readLittleEndianInt2, readLittleEndianInt3, pow, pow2, z, Arrays.copyOf(parsableByteArray.getData(), parsableByteArray.limit()));
    }

    public static Mode[] readVorbisModes(ParsableByteArray parsableByteArray, int i) {
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8 = 5;
        int i9 = 0;
        verifyVorbisHeaderCapturePattern(5, parsableByteArray, false);
        int i10 = 1;
        int readUnsignedByte = parsableByteArray.readUnsignedByte() + 1;
        VorbisBitArray vorbisBitArray = new VorbisBitArray(parsableByteArray.getData());
        vorbisBitArray.skipBits(parsableByteArray.getPosition() * 8);
        int i11 = 0;
        while (i11 < readUnsignedByte) {
            if (vorbisBitArray.readBits(24) == 5653314) {
                int readBits = vorbisBitArray.readBits(16);
                int readBits2 = vorbisBitArray.readBits(24);
                long[] jArr = new long[readBits2];
                long j = 0;
                if (!vorbisBitArray.readBit()) {
                    boolean readBit = vorbisBitArray.readBit();
                    while (i9 < readBits2) {
                        if (readBit) {
                            if (vorbisBitArray.readBit()) {
                                i7 = readBits;
                                jArr[i9] = vorbisBitArray.readBits(5) + 1;
                            } else {
                                i7 = readBits;
                                jArr[i9] = 0;
                            }
                        } else {
                            i7 = readBits;
                            jArr[i9] = vorbisBitArray.readBits(5) + i10;
                        }
                        i9++;
                        readBits = i7;
                    }
                    i6 = readBits;
                } else {
                    i6 = readBits;
                    int readBits3 = vorbisBitArray.readBits(5) + i10;
                    int i12 = 0;
                    while (i12 < readBits2) {
                        int readBits4 = vorbisBitArray.readBits(iLog(readBits2 - i12));
                        int i13 = 0;
                        while (i13 < readBits4 && i12 < readBits2) {
                            jArr[i12] = readBits3;
                            i12++;
                            i13++;
                            vorbisBitArray = vorbisBitArray;
                        }
                        readBits3++;
                        vorbisBitArray = vorbisBitArray;
                    }
                }
                VorbisBitArray vorbisBitArray2 = vorbisBitArray;
                int readBits5 = vorbisBitArray2.readBits(4);
                if (readBits5 <= 2) {
                    if (readBits5 == 1 || readBits5 == 2) {
                        vorbisBitArray2.skipBits(32);
                        vorbisBitArray2.skipBits(32);
                        int readBits6 = vorbisBitArray2.readBits(4) + 1;
                        vorbisBitArray2.skipBits(1);
                        if (readBits5 == 1) {
                            if (i6 != 0) {
                                j = (long) Math.floor(Math.pow(readBits2, 1.0d / i6));
                            }
                        } else {
                            j = readBits2 * i6;
                        }
                        vorbisBitArray2.skipBits((int) (readBits6 * j));
                    }
                    i11++;
                    vorbisBitArray = vorbisBitArray2;
                    i9 = 0;
                    i10 = 1;
                } else {
                    throw ParserException.createForMalformedContainer("lookup type greater than 2 not decodable: " + readBits5, null);
                }
            } else {
                throw ParserException.createForMalformedContainer("expected code book to start with [0x56, 0x43, 0x42] at " + vorbisBitArray.getPosition(), null);
            }
        }
        VorbisBitArray vorbisBitArray3 = vorbisBitArray;
        int readBits7 = vorbisBitArray3.readBits(6) + 1;
        for (int i14 = 0; i14 < readBits7; i14++) {
            if (vorbisBitArray3.readBits(16) != 0) {
                throw ParserException.createForMalformedContainer("placeholder of time domain transforms not zeroed out", null);
            }
        }
        int i15 = 1;
        int readBits8 = vorbisBitArray3.readBits(6) + 1;
        int i16 = 0;
        while (true) {
            int i17 = 3;
            if (i16 < readBits8) {
                int readBits9 = vorbisBitArray3.readBits(16);
                if (readBits9 != 0) {
                    if (readBits9 == i15) {
                        int readBits10 = vorbisBitArray3.readBits(i8);
                        int[] iArr = new int[readBits10];
                        int i18 = -1;
                        for (int i19 = 0; i19 < readBits10; i19++) {
                            int readBits11 = vorbisBitArray3.readBits(4);
                            iArr[i19] = readBits11;
                            if (readBits11 > i18) {
                                i18 = readBits11;
                            }
                        }
                        int i20 = i18 + 1;
                        int[] iArr2 = new int[i20];
                        int i21 = 0;
                        while (i21 < i20) {
                            int i22 = 1;
                            iArr2[i21] = vorbisBitArray3.readBits(i17) + 1;
                            int readBits12 = vorbisBitArray3.readBits(2);
                            int i23 = 8;
                            if (readBits12 > 0) {
                                vorbisBitArray3.skipBits(8);
                            }
                            int i24 = 0;
                            while (true) {
                                int i25 = i22 << readBits12;
                                i5 = i21;
                                if (i24 < i25) {
                                    vorbisBitArray3.skipBits(i23);
                                    i24++;
                                    i21 = i5;
                                    i23 = 8;
                                    i22 = 1;
                                }
                            }
                            i21 = i5 + 1;
                            i17 = 3;
                        }
                        vorbisBitArray3.skipBits(2);
                        int readBits13 = vorbisBitArray3.readBits(4);
                        int i26 = 0;
                        int i27 = 0;
                        for (int i28 = 0; i28 < readBits10; i28++) {
                            i26 += iArr2[iArr[i28]];
                            while (i27 < i26) {
                                vorbisBitArray3.skipBits(readBits13);
                                i27++;
                            }
                        }
                    } else {
                        throw ParserException.createForMalformedContainer("floor type greater than 1 not decodable: " + readBits9, null);
                    }
                } else {
                    int i29 = 8;
                    vorbisBitArray3.skipBits(8);
                    vorbisBitArray3.skipBits(16);
                    vorbisBitArray3.skipBits(16);
                    vorbisBitArray3.skipBits(6);
                    vorbisBitArray3.skipBits(8);
                    int readBits14 = vorbisBitArray3.readBits(4) + 1;
                    int i30 = 0;
                    while (i30 < readBits14) {
                        vorbisBitArray3.skipBits(i29);
                        i30++;
                        i29 = 8;
                    }
                }
                i16++;
                i8 = 5;
                i15 = 1;
            } else {
                int i31 = 1;
                int readBits15 = vorbisBitArray3.readBits(6) + 1;
                int i32 = 0;
                while (i32 < readBits15) {
                    if (vorbisBitArray3.readBits(16) <= 2) {
                        vorbisBitArray3.skipBits(24);
                        vorbisBitArray3.skipBits(24);
                        vorbisBitArray3.skipBits(24);
                        int readBits16 = vorbisBitArray3.readBits(6) + i31;
                        int i33 = 8;
                        vorbisBitArray3.skipBits(8);
                        int[] iArr3 = new int[readBits16];
                        for (int i34 = 0; i34 < readBits16; i34++) {
                            int readBits17 = vorbisBitArray3.readBits(3);
                            if (vorbisBitArray3.readBit()) {
                                i4 = vorbisBitArray3.readBits(5);
                            } else {
                                i4 = 0;
                            }
                            iArr3[i34] = (i4 * 8) + readBits17;
                        }
                        int i35 = 0;
                        while (i35 < readBits16) {
                            int i36 = 0;
                            while (i36 < i33) {
                                if ((iArr3[i35] & (1 << i36)) != 0) {
                                    vorbisBitArray3.skipBits(i33);
                                }
                                i36++;
                                i33 = 8;
                            }
                            i35++;
                            i33 = 8;
                        }
                        i32++;
                        i31 = 1;
                    } else {
                        throw ParserException.createForMalformedContainer("residueType greater than 2 is not decodable", null);
                    }
                }
                int readBits18 = vorbisBitArray3.readBits(6) + 1;
                for (int i37 = 0; i37 < readBits18; i37++) {
                    int readBits19 = vorbisBitArray3.readBits(16);
                    if (readBits19 != 0) {
                        Log.m3023e("VorbisUtil", "mapping type other than 0 not supported: " + readBits19);
                    } else {
                        if (vorbisBitArray3.readBit()) {
                            i2 = 1;
                            i3 = vorbisBitArray3.readBits(4) + 1;
                        } else {
                            i2 = 1;
                            i3 = 1;
                        }
                        if (vorbisBitArray3.readBit()) {
                            int readBits20 = vorbisBitArray3.readBits(8) + i2;
                            for (int i38 = 0; i38 < readBits20; i38++) {
                                int i39 = i - 1;
                                vorbisBitArray3.skipBits(iLog(i39));
                                vorbisBitArray3.skipBits(iLog(i39));
                            }
                        }
                        if (vorbisBitArray3.readBits(2) == 0) {
                            if (i3 > 1) {
                                for (int i40 = 0; i40 < i; i40++) {
                                    vorbisBitArray3.skipBits(4);
                                }
                            }
                            for (int i41 = 0; i41 < i3; i41++) {
                                vorbisBitArray3.skipBits(8);
                                vorbisBitArray3.skipBits(8);
                                vorbisBitArray3.skipBits(8);
                            }
                        } else {
                            throw ParserException.createForMalformedContainer("to reserved bits must be zero after mapping coupling steps", null);
                        }
                    }
                }
                int readBits21 = vorbisBitArray3.readBits(6) + 1;
                Mode[] modeArr = new Mode[readBits21];
                for (int i42 = 0; i42 < readBits21; i42++) {
                    modeArr[i42] = new Mode(vorbisBitArray3.readBit(), vorbisBitArray3.readBits(16), vorbisBitArray3.readBits(16), vorbisBitArray3.readBits(8));
                }
                if (vorbisBitArray3.readBit()) {
                    return modeArr;
                }
                throw ParserException.createForMalformedContainer("framing bit after modes not set as expected", null);
            }
        }
    }

    public static boolean verifyVorbisHeaderCapturePattern(int i, ParsableByteArray parsableByteArray, boolean z) {
        if (parsableByteArray.bytesLeft() < 7) {
            if (z) {
                return false;
            }
            throw ParserException.createForMalformedContainer("too short header: " + parsableByteArray.bytesLeft(), null);
        }
        if (parsableByteArray.readUnsignedByte() != i) {
            if (z) {
                return false;
            }
            throw ParserException.createForMalformedContainer("expected header type " + Integer.toHexString(i), null);
        }
        if (parsableByteArray.readUnsignedByte() == 118 && parsableByteArray.readUnsignedByte() == 111 && parsableByteArray.readUnsignedByte() == 114 && parsableByteArray.readUnsignedByte() == 98 && parsableByteArray.readUnsignedByte() == 105 && parsableByteArray.readUnsignedByte() == 115) {
            return true;
        }
        if (z) {
            return false;
        }
        throw ParserException.createForMalformedContainer("expected characters 'vorbis'", null);
    }

    public static CommentHeader readVorbisCommentHeader(ParsableByteArray parsableByteArray, boolean z, boolean z2) {
        if (z) {
            verifyVorbisHeaderCapturePattern(3, parsableByteArray, false);
        }
        String readString = parsableByteArray.readString((int) parsableByteArray.readLittleEndianUnsignedInt());
        int length = readString.length();
        long readLittleEndianUnsignedInt = parsableByteArray.readLittleEndianUnsignedInt();
        String[] strArr = new String[(int) readLittleEndianUnsignedInt];
        int i = length + 15;
        for (int i2 = 0; i2 < readLittleEndianUnsignedInt; i2++) {
            String readString2 = parsableByteArray.readString((int) parsableByteArray.readLittleEndianUnsignedInt());
            strArr[i2] = readString2;
            i = i + 4 + readString2.length();
        }
        if (z2 && (parsableByteArray.readUnsignedByte() & 1) == 0) {
            throw ParserException.createForMalformedContainer("framing bit expected to be set", null);
        }
        return new CommentHeader(readString, strArr, i + 1);
    }
}
