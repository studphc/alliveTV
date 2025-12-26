package com.google.android.exoplayer2.extractor.p002ts;

import com.google.android.exoplayer2.C0643C;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.extractor.p002ts.TsPayloadReader;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.CodecSpecificDataUtil;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.NalUnitUtil;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.ParsableNalUnitBitArray;
import com.google.android.exoplayer2.util.Util;
import java.util.Collections;
import p000.AbstractC1726qj;
import p000.gr1;
import p000.wy0;

/* loaded from: classes.dex */
public final class H265Reader implements ElementaryStreamReader {

    /* renamed from: a */
    public final SeiReader f10462a;

    /* renamed from: b */
    public String f10463b;

    /* renamed from: c */
    public TrackOutput f10464c;

    /* renamed from: d */
    public wy0 f10465d;

    /* renamed from: e */
    public boolean f10466e;

    /* renamed from: l */
    public long f10473l;

    /* renamed from: f */
    public final boolean[] f10467f = new boolean[3];

    /* renamed from: g */
    public final gr1 f10468g = new gr1(32);

    /* renamed from: h */
    public final gr1 f10469h = new gr1(33);

    /* renamed from: i */
    public final gr1 f10470i = new gr1(34);

    /* renamed from: j */
    public final gr1 f10471j = new gr1(39);

    /* renamed from: k */
    public final gr1 f10472k = new gr1(40);

    /* renamed from: m */
    public long f10474m = C0643C.TIME_UNSET;

    /* renamed from: n */
    public final ParsableByteArray f10475n = new ParsableByteArray();

    public H265Reader(SeiReader seiReader) {
        this.f10462a = seiReader;
    }

    /* renamed from: a */
    public final void m2566a(byte[] bArr, int i, int i2) {
        boolean z;
        wy0 wy0Var = this.f10465d;
        if (wy0Var.f28389f) {
            int i3 = wy0Var.f28387d;
            int i4 = (i + 2) - i3;
            if (i4 < i2) {
                if ((bArr[i4] & 128) != 0) {
                    z = true;
                } else {
                    z = false;
                }
                wy0Var.f28390g = z;
                wy0Var.f28389f = false;
            } else {
                wy0Var.f28387d = (i2 - i) + i3;
            }
        }
        if (!this.f10466e) {
            this.f10468g.m4980a(bArr, i, i2);
            this.f10469h.m4980a(bArr, i, i2);
            this.f10470i.m4980a(bArr, i, i2);
        }
        this.f10471j.m4980a(bArr, i, i2);
        this.f10472k.m4980a(bArr, i, i2);
    }

    /* JADX WARN: Removed duplicated region for block: B:176:0x03aa  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x03c6  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x03f3  */
    /* JADX WARN: Removed duplicated region for block: B:200:0x043b  */
    /* JADX WARN: Removed duplicated region for block: B:205:0x0446  */
    /* JADX WARN: Removed duplicated region for block: B:209:0x0451  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00d5  */
    @Override // com.google.android.exoplayer2.extractor.p002ts.ElementaryStreamReader
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void consume(ParsableByteArray parsableByteArray) {
        int i;
        int i2;
        byte[] bArr;
        int i3;
        int i4;
        boolean z;
        gr1 gr1Var;
        gr1 gr1Var2;
        long j;
        int i5;
        gr1 gr1Var3;
        boolean m4981b;
        gr1 gr1Var4;
        int i6;
        boolean z2;
        boolean z3;
        boolean z4;
        int i7;
        int i8;
        long j2;
        int i9;
        int i10;
        int i11;
        Assertions.checkStateNotNull(this.f10464c);
        Util.castNonNull(this.f10465d);
        while (parsableByteArray.bytesLeft() > 0) {
            int position = parsableByteArray.getPosition();
            int limit = parsableByteArray.limit();
            byte[] data = parsableByteArray.getData();
            this.f10473l += parsableByteArray.bytesLeft();
            this.f10464c.sampleData(parsableByteArray, parsableByteArray.bytesLeft());
            while (position < limit) {
                int findNalUnit = NalUnitUtil.findNalUnit(data, position, limit, this.f10467f);
                if (findNalUnit == limit) {
                    m2566a(data, position, limit);
                    return;
                }
                int h265NalUnitType = NalUnitUtil.getH265NalUnitType(data, findNalUnit);
                int i12 = findNalUnit - position;
                if (i12 > 0) {
                    m2566a(data, position, findNalUnit);
                }
                int i13 = limit - findNalUnit;
                long j3 = this.f10473l - i13;
                if (i12 < 0) {
                    i = -i12;
                } else {
                    i = 0;
                }
                long j4 = this.f10474m;
                wy0 wy0Var = this.f10465d;
                boolean z5 = this.f10466e;
                if (wy0Var.f28393j && wy0Var.f28390g) {
                    wy0Var.f28396m = wy0Var.f28386c;
                    wy0Var.f28393j = false;
                } else if (wy0Var.f28391h || wy0Var.f28390g) {
                    if (z5 && wy0Var.f28392i) {
                        long j5 = wy0Var.f28385b;
                        i2 = limit;
                        int i14 = i13 + ((int) (j3 - j5));
                        long j6 = wy0Var.f28395l;
                        if (j6 != C0643C.TIME_UNSET) {
                            bArr = data;
                            i3 = findNalUnit;
                            i4 = h265NalUnitType;
                            wy0Var.f28384a.sampleMetadata(j6, wy0Var.f28396m ? 1 : 0, (int) (j5 - wy0Var.f28394k), i14, null);
                            wy0Var.f28394k = wy0Var.f28385b;
                            wy0Var.f28395l = wy0Var.f28388e;
                            wy0Var.f28396m = wy0Var.f28386c;
                            wy0Var.f28392i = true;
                            z = this.f10466e;
                            gr1 gr1Var5 = this.f10470i;
                            gr1 gr1Var6 = this.f10469h;
                            gr1 gr1Var7 = this.f10468g;
                            if (!z) {
                                gr1Var7.m4981b(i);
                                gr1Var6.m4981b(i);
                                gr1Var5.m4981b(i);
                                if (gr1Var7.f17811c && gr1Var6.f17811c && gr1Var5.f17811c) {
                                    TrackOutput trackOutput = this.f10464c;
                                    String str = this.f10463b;
                                    int i15 = gr1Var7.f17813e;
                                    byte[] bArr2 = new byte[gr1Var6.f17813e + i15 + gr1Var5.f17813e];
                                    System.arraycopy(gr1Var7.f17812d, 0, bArr2, 0, i15);
                                    i5 = i13;
                                    System.arraycopy(gr1Var6.f17812d, 0, bArr2, gr1Var7.f17813e, gr1Var6.f17813e);
                                    System.arraycopy(gr1Var5.f17812d, 0, bArr2, gr1Var7.f17813e + gr1Var6.f17813e, gr1Var5.f17813e);
                                    ParsableNalUnitBitArray parsableNalUnitBitArray = new ParsableNalUnitBitArray(gr1Var6.f17812d, 0, gr1Var6.f17813e);
                                    parsableNalUnitBitArray.skipBits(44);
                                    int readBits = parsableNalUnitBitArray.readBits(3);
                                    parsableNalUnitBitArray.skipBit();
                                    int readBits2 = parsableNalUnitBitArray.readBits(2);
                                    boolean readBit = parsableNalUnitBitArray.readBit();
                                    int readBits3 = parsableNalUnitBitArray.readBits(5);
                                    int i16 = 0;
                                    int i17 = 0;
                                    for (int i18 = 32; i16 < i18; i18 = 32) {
                                        if (parsableNalUnitBitArray.readBit()) {
                                            i17 |= 1 << i16;
                                        }
                                        i16++;
                                    }
                                    int[] iArr = new int[6];
                                    gr1Var = gr1Var5;
                                    gr1Var2 = gr1Var6;
                                    for (int i19 = 0; i19 < 6; i19++) {
                                        iArr[i19] = parsableNalUnitBitArray.readBits(8);
                                    }
                                    int readBits4 = parsableNalUnitBitArray.readBits(8);
                                    int i20 = 0;
                                    for (int i21 = 0; i21 < readBits; i21++) {
                                        if (parsableNalUnitBitArray.readBit()) {
                                            i20 += 89;
                                        }
                                        if (parsableNalUnitBitArray.readBit()) {
                                            i20 += 8;
                                        }
                                    }
                                    parsableNalUnitBitArray.skipBits(i20);
                                    if (readBits > 0) {
                                        parsableNalUnitBitArray.skipBits((8 - readBits) * 2);
                                    }
                                    parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
                                    int readUnsignedExpGolombCodedInt = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
                                    if (readUnsignedExpGolombCodedInt == 3) {
                                        parsableNalUnitBitArray.skipBit();
                                    }
                                    int readUnsignedExpGolombCodedInt2 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
                                    int readUnsignedExpGolombCodedInt3 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
                                    if (parsableNalUnitBitArray.readBit()) {
                                        int readUnsignedExpGolombCodedInt4 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
                                        int readUnsignedExpGolombCodedInt5 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
                                        int readUnsignedExpGolombCodedInt6 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
                                        int readUnsignedExpGolombCodedInt7 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
                                        if (readUnsignedExpGolombCodedInt != 1 && readUnsignedExpGolombCodedInt != 2) {
                                            gr1Var3 = gr1Var7;
                                            i10 = 1;
                                        } else {
                                            gr1Var3 = gr1Var7;
                                            i10 = 2;
                                        }
                                        if (readUnsignedExpGolombCodedInt == 1) {
                                            i11 = 2;
                                        } else {
                                            i11 = 1;
                                        }
                                        readUnsignedExpGolombCodedInt2 -= (readUnsignedExpGolombCodedInt4 + readUnsignedExpGolombCodedInt5) * i10;
                                        readUnsignedExpGolombCodedInt3 -= (readUnsignedExpGolombCodedInt6 + readUnsignedExpGolombCodedInt7) * i11;
                                    } else {
                                        gr1Var3 = gr1Var7;
                                    }
                                    parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
                                    parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
                                    int readUnsignedExpGolombCodedInt8 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
                                    if (parsableNalUnitBitArray.readBit()) {
                                        i7 = 0;
                                    } else {
                                        i7 = readBits;
                                    }
                                    while (i7 <= readBits) {
                                        parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
                                        parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
                                        parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
                                        i7++;
                                    }
                                    parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
                                    parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
                                    parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
                                    parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
                                    parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
                                    parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
                                    if (parsableNalUnitBitArray.readBit() && parsableNalUnitBitArray.readBit()) {
                                        int i22 = 0;
                                        for (int i23 = 4; i22 < i23; i23 = 4) {
                                            int i24 = 0;
                                            for (int i25 = 6; i24 < i25; i25 = 6) {
                                                if (!parsableNalUnitBitArray.readBit()) {
                                                    parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
                                                    j2 = j3;
                                                } else {
                                                    j2 = j3;
                                                    int min = Math.min(64, 1 << ((i22 << 1) + 4));
                                                    if (i22 > 1) {
                                                        parsableNalUnitBitArray.readSignedExpGolombCodedInt();
                                                    }
                                                    for (int i26 = 0; i26 < min; i26++) {
                                                        parsableNalUnitBitArray.readSignedExpGolombCodedInt();
                                                    }
                                                }
                                                if (i22 == 3) {
                                                    i9 = 3;
                                                } else {
                                                    i9 = 1;
                                                }
                                                i24 += i9;
                                                j3 = j2;
                                            }
                                            i22++;
                                            j3 = j3;
                                        }
                                    }
                                    j = j3;
                                    parsableNalUnitBitArray.skipBits(2);
                                    if (parsableNalUnitBitArray.readBit()) {
                                        parsableNalUnitBitArray.skipBits(8);
                                        parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
                                        parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
                                        parsableNalUnitBitArray.skipBit();
                                    }
                                    int readUnsignedExpGolombCodedInt9 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
                                    int i27 = 0;
                                    boolean z6 = false;
                                    int i28 = 0;
                                    while (i27 < readUnsignedExpGolombCodedInt9) {
                                        if (i27 != 0) {
                                            z6 = parsableNalUnitBitArray.readBit();
                                        }
                                        if (z6) {
                                            parsableNalUnitBitArray.skipBit();
                                            parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
                                            for (int i29 = 0; i29 <= i28; i29++) {
                                                if (parsableNalUnitBitArray.readBit()) {
                                                    parsableNalUnitBitArray.skipBit();
                                                }
                                            }
                                            i8 = readUnsignedExpGolombCodedInt9;
                                        } else {
                                            int readUnsignedExpGolombCodedInt10 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
                                            int readUnsignedExpGolombCodedInt11 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
                                            int i30 = readUnsignedExpGolombCodedInt10 + readUnsignedExpGolombCodedInt11;
                                            i8 = readUnsignedExpGolombCodedInt9;
                                            for (int i31 = 0; i31 < readUnsignedExpGolombCodedInt10; i31++) {
                                                parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
                                                parsableNalUnitBitArray.skipBit();
                                            }
                                            for (int i32 = 0; i32 < readUnsignedExpGolombCodedInt11; i32++) {
                                                parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
                                                parsableNalUnitBitArray.skipBit();
                                            }
                                            i28 = i30;
                                        }
                                        i27++;
                                        readUnsignedExpGolombCodedInt9 = i8;
                                    }
                                    if (parsableNalUnitBitArray.readBit()) {
                                        for (int i33 = 0; i33 < parsableNalUnitBitArray.readUnsignedExpGolombCodedInt(); i33++) {
                                            parsableNalUnitBitArray.skipBits(readUnsignedExpGolombCodedInt8 + 5);
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
                                                float[] fArr = NalUnitUtil.ASPECT_RATIO_IDC_VALUES;
                                                if (readBits5 < fArr.length) {
                                                    f = fArr[readBits5];
                                                } else {
                                                    AbstractC1726qj.m7036A(readBits5, "Unexpected aspect_ratio_idc value: ", "H265Reader");
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
                                            readUnsignedExpGolombCodedInt3 *= 2;
                                        }
                                    }
                                    trackOutput.format(new Format.Builder().setId(str).setSampleMimeType(MimeTypes.VIDEO_H265).setCodecs(CodecSpecificDataUtil.buildHevcCodecString(readBits2, readBit, readBits3, i17, iArr, readBits4)).setWidth(readUnsignedExpGolombCodedInt2).setHeight(readUnsignedExpGolombCodedInt3).setPixelWidthHeightRatio(f).setInitializationData(Collections.singletonList(bArr2)).build());
                                    this.f10466e = true;
                                    gr1 gr1Var8 = this.f10471j;
                                    m4981b = gr1Var8.m4981b(i);
                                    SeiReader seiReader = this.f10462a;
                                    ParsableByteArray parsableByteArray2 = this.f10475n;
                                    if (m4981b) {
                                        parsableByteArray2.reset(gr1Var8.f17812d, NalUnitUtil.unescapeStream(gr1Var8.f17812d, gr1Var8.f17813e));
                                        parsableByteArray2.skipBytes(5);
                                        seiReader.consume(j4, parsableByteArray2);
                                    }
                                    gr1Var4 = this.f10472k;
                                    if (gr1Var4.m4981b(i)) {
                                        parsableByteArray2.reset(gr1Var4.f17812d, NalUnitUtil.unescapeStream(gr1Var4.f17812d, gr1Var4.f17813e));
                                        parsableByteArray2.skipBytes(5);
                                        seiReader.consume(j4, parsableByteArray2);
                                    }
                                    long j7 = this.f10474m;
                                    wy0 wy0Var2 = this.f10465d;
                                    boolean z7 = this.f10466e;
                                    wy0Var2.f28390g = false;
                                    wy0Var2.f28391h = false;
                                    wy0Var2.f28388e = j7;
                                    wy0Var2.f28387d = 0;
                                    long j8 = j;
                                    wy0Var2.f28385b = j8;
                                    i6 = i4;
                                    if (i6 >= 32 || i6 == 40) {
                                        z2 = true;
                                        z3 = false;
                                    } else {
                                        if (wy0Var2.f28392i && !wy0Var2.f28393j) {
                                            if (z7) {
                                                long j9 = wy0Var2.f28395l;
                                                if (j9 != C0643C.TIME_UNSET) {
                                                    boolean z8 = wy0Var2.f28396m;
                                                    wy0Var2.f28384a.sampleMetadata(j9, z8 ? 1 : 0, (int) (j8 - wy0Var2.f28394k), i5, null);
                                                }
                                            }
                                            z3 = false;
                                            wy0Var2.f28392i = false;
                                        } else {
                                            z3 = false;
                                        }
                                        if ((32 <= i6 && i6 <= 35) || i6 == 39) {
                                            z2 = true;
                                            wy0Var2.f28391h = !wy0Var2.f28393j;
                                            wy0Var2.f28393j = true;
                                        } else {
                                            z2 = true;
                                        }
                                    }
                                    if (i6 < 16 && i6 <= 21) {
                                        z4 = z2;
                                    } else {
                                        z4 = z3;
                                    }
                                    wy0Var2.f28386c = z4;
                                    if (!z4 || i6 <= 9) {
                                        z3 = z2;
                                    }
                                    wy0Var2.f28389f = z3;
                                    if (!this.f10466e) {
                                        gr1Var3.m4983d(i6);
                                        gr1Var2.m4983d(i6);
                                        gr1Var.m4983d(i6);
                                    }
                                    gr1Var8.m4983d(i6);
                                    gr1Var4.m4983d(i6);
                                    position = i3 + 3;
                                    limit = i2;
                                    data = bArr;
                                }
                            }
                            gr1Var = gr1Var5;
                            gr1Var2 = gr1Var6;
                            j = j3;
                            i5 = i13;
                            gr1Var3 = gr1Var7;
                            gr1 gr1Var82 = this.f10471j;
                            m4981b = gr1Var82.m4981b(i);
                            SeiReader seiReader2 = this.f10462a;
                            ParsableByteArray parsableByteArray22 = this.f10475n;
                            if (m4981b) {
                            }
                            gr1Var4 = this.f10472k;
                            if (gr1Var4.m4981b(i)) {
                            }
                            long j72 = this.f10474m;
                            wy0 wy0Var22 = this.f10465d;
                            boolean z72 = this.f10466e;
                            wy0Var22.f28390g = false;
                            wy0Var22.f28391h = false;
                            wy0Var22.f28388e = j72;
                            wy0Var22.f28387d = 0;
                            long j82 = j;
                            wy0Var22.f28385b = j82;
                            i6 = i4;
                            if (i6 >= 32) {
                            }
                            z2 = true;
                            z3 = false;
                            if (i6 < 16) {
                            }
                            z4 = z3;
                            wy0Var22.f28386c = z4;
                            if (!z4) {
                            }
                            z3 = z2;
                            wy0Var22.f28389f = z3;
                            if (!this.f10466e) {
                            }
                            gr1Var82.m4983d(i6);
                            gr1Var4.m4983d(i6);
                            position = i3 + 3;
                            limit = i2;
                            data = bArr;
                        }
                    } else {
                        i2 = limit;
                    }
                    bArr = data;
                    i3 = findNalUnit;
                    i4 = h265NalUnitType;
                    wy0Var.f28394k = wy0Var.f28385b;
                    wy0Var.f28395l = wy0Var.f28388e;
                    wy0Var.f28396m = wy0Var.f28386c;
                    wy0Var.f28392i = true;
                    z = this.f10466e;
                    gr1 gr1Var52 = this.f10470i;
                    gr1 gr1Var62 = this.f10469h;
                    gr1 gr1Var72 = this.f10468g;
                    if (!z) {
                    }
                    gr1Var = gr1Var52;
                    gr1Var2 = gr1Var62;
                    j = j3;
                    i5 = i13;
                    gr1Var3 = gr1Var72;
                    gr1 gr1Var822 = this.f10471j;
                    m4981b = gr1Var822.m4981b(i);
                    SeiReader seiReader22 = this.f10462a;
                    ParsableByteArray parsableByteArray222 = this.f10475n;
                    if (m4981b) {
                    }
                    gr1Var4 = this.f10472k;
                    if (gr1Var4.m4981b(i)) {
                    }
                    long j722 = this.f10474m;
                    wy0 wy0Var222 = this.f10465d;
                    boolean z722 = this.f10466e;
                    wy0Var222.f28390g = false;
                    wy0Var222.f28391h = false;
                    wy0Var222.f28388e = j722;
                    wy0Var222.f28387d = 0;
                    long j822 = j;
                    wy0Var222.f28385b = j822;
                    i6 = i4;
                    if (i6 >= 32) {
                    }
                    z2 = true;
                    z3 = false;
                    if (i6 < 16) {
                    }
                    z4 = z3;
                    wy0Var222.f28386c = z4;
                    if (!z4) {
                    }
                    z3 = z2;
                    wy0Var222.f28389f = z3;
                    if (!this.f10466e) {
                    }
                    gr1Var822.m4983d(i6);
                    gr1Var4.m4983d(i6);
                    position = i3 + 3;
                    limit = i2;
                    data = bArr;
                }
                i2 = limit;
                bArr = data;
                i3 = findNalUnit;
                i4 = h265NalUnitType;
                z = this.f10466e;
                gr1 gr1Var522 = this.f10470i;
                gr1 gr1Var622 = this.f10469h;
                gr1 gr1Var722 = this.f10468g;
                if (!z) {
                }
                gr1Var = gr1Var522;
                gr1Var2 = gr1Var622;
                j = j3;
                i5 = i13;
                gr1Var3 = gr1Var722;
                gr1 gr1Var8222 = this.f10471j;
                m4981b = gr1Var8222.m4981b(i);
                SeiReader seiReader222 = this.f10462a;
                ParsableByteArray parsableByteArray2222 = this.f10475n;
                if (m4981b) {
                }
                gr1Var4 = this.f10472k;
                if (gr1Var4.m4981b(i)) {
                }
                long j7222 = this.f10474m;
                wy0 wy0Var2222 = this.f10465d;
                boolean z7222 = this.f10466e;
                wy0Var2222.f28390g = false;
                wy0Var2222.f28391h = false;
                wy0Var2222.f28388e = j7222;
                wy0Var2222.f28387d = 0;
                long j8222 = j;
                wy0Var2222.f28385b = j8222;
                i6 = i4;
                if (i6 >= 32) {
                }
                z2 = true;
                z3 = false;
                if (i6 < 16) {
                }
                z4 = z3;
                wy0Var2222.f28386c = z4;
                if (!z4) {
                }
                z3 = z2;
                wy0Var2222.f28389f = z3;
                if (!this.f10466e) {
                }
                gr1Var8222.m4983d(i6);
                gr1Var4.m4983d(i6);
                position = i3 + 3;
                limit = i2;
                data = bArr;
            }
        }
    }

    @Override // com.google.android.exoplayer2.extractor.p002ts.ElementaryStreamReader
    public void createTracks(ExtractorOutput extractorOutput, TsPayloadReader.TrackIdGenerator trackIdGenerator) {
        trackIdGenerator.generateNewId();
        this.f10463b = trackIdGenerator.getFormatId();
        TrackOutput track = extractorOutput.track(trackIdGenerator.getTrackId(), 2);
        this.f10464c = track;
        this.f10465d = new wy0(track);
        this.f10462a.createTracks(extractorOutput, trackIdGenerator);
    }

    @Override // com.google.android.exoplayer2.extractor.p002ts.ElementaryStreamReader
    public void packetFinished() {
    }

    @Override // com.google.android.exoplayer2.extractor.p002ts.ElementaryStreamReader
    public void packetStarted(long j, int i) {
        if (j != C0643C.TIME_UNSET) {
            this.f10474m = j;
        }
    }

    @Override // com.google.android.exoplayer2.extractor.p002ts.ElementaryStreamReader
    public void seek() {
        this.f10473l = 0L;
        this.f10474m = C0643C.TIME_UNSET;
        NalUnitUtil.clearPrefixFlags(this.f10467f);
        this.f10468g.m4982c();
        this.f10469h.m4982c();
        this.f10470i.m4982c();
        this.f10471j.m4982c();
        this.f10472k.m4982c();
        wy0 wy0Var = this.f10465d;
        if (wy0Var != null) {
            wy0Var.f28389f = false;
            wy0Var.f28390g = false;
            wy0Var.f28391h = false;
            wy0Var.f28392i = false;
            wy0Var.f28393j = false;
        }
    }
}
