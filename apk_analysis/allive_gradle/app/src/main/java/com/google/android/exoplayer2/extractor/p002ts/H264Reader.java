package com.google.android.exoplayer2.extractor.p002ts;

import android.util.SparseArray;
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
import java.util.ArrayList;
import java.util.Arrays;
import p000.gr1;
import p000.uy0;
import p000.vy0;

/* loaded from: classes.dex */
public final class H264Reader implements ElementaryStreamReader {

    /* renamed from: a */
    public final SeiReader f10447a;

    /* renamed from: b */
    public final boolean f10448b;

    /* renamed from: c */
    public final boolean f10449c;

    /* renamed from: g */
    public long f10453g;

    /* renamed from: i */
    public String f10455i;

    /* renamed from: j */
    public TrackOutput f10456j;

    /* renamed from: k */
    public vy0 f10457k;

    /* renamed from: l */
    public boolean f10458l;

    /* renamed from: n */
    public boolean f10460n;

    /* renamed from: h */
    public final boolean[] f10454h = new boolean[3];

    /* renamed from: d */
    public final gr1 f10450d = new gr1(7);

    /* renamed from: e */
    public final gr1 f10451e = new gr1(8);

    /* renamed from: f */
    public final gr1 f10452f = new gr1(6);

    /* renamed from: m */
    public long f10459m = C0643C.TIME_UNSET;

    /* renamed from: o */
    public final ParsableByteArray f10461o = new ParsableByteArray();

    public H264Reader(SeiReader seiReader, boolean z, boolean z2) {
        this.f10447a = seiReader;
        this.f10448b = z;
        this.f10449c = z2;
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0111  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x013a  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x010c  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x00fc  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void m2565a(byte[] bArr, int i, int i2) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        if (!this.f10458l || this.f10457k.f27995c) {
            this.f10450d.m4980a(bArr, i, i2);
            this.f10451e.m4980a(bArr, i, i2);
        }
        this.f10452f.m4980a(bArr, i, i2);
        vy0 vy0Var = this.f10457k;
        if (vy0Var.f28003k) {
            int i9 = i2 - i;
            byte[] bArr2 = vy0Var.f27999g;
            int length = bArr2.length;
            int i10 = vy0Var.f28000h + i9;
            if (length < i10) {
                vy0Var.f27999g = Arrays.copyOf(bArr2, i10 * 2);
            }
            System.arraycopy(bArr, i, vy0Var.f27999g, vy0Var.f28000h, i9);
            int i11 = vy0Var.f28000h + i9;
            vy0Var.f28000h = i11;
            byte[] bArr3 = vy0Var.f27999g;
            ParsableNalUnitBitArray parsableNalUnitBitArray = vy0Var.f27998f;
            parsableNalUnitBitArray.reset(bArr3, 0, i11);
            if (parsableNalUnitBitArray.canReadBits(8)) {
                parsableNalUnitBitArray.skipBit();
                int readBits = parsableNalUnitBitArray.readBits(2);
                parsableNalUnitBitArray.skipBits(5);
                if (parsableNalUnitBitArray.canReadExpGolombCodedNum()) {
                    parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
                    if (parsableNalUnitBitArray.canReadExpGolombCodedNum()) {
                        int readUnsignedExpGolombCodedInt = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
                        if (!vy0Var.f27995c) {
                            vy0Var.f28003k = false;
                            uy0 uy0Var = vy0Var.f28006n;
                            uy0Var.f27532e = readUnsignedExpGolombCodedInt;
                            uy0Var.f27529b = true;
                            return;
                        }
                        if (parsableNalUnitBitArray.canReadExpGolombCodedNum()) {
                            int readUnsignedExpGolombCodedInt2 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
                            SparseArray sparseArray = vy0Var.f27997e;
                            if (sparseArray.indexOfKey(readUnsignedExpGolombCodedInt2) < 0) {
                                vy0Var.f28003k = false;
                                return;
                            }
                            NalUnitUtil.PpsData ppsData = (NalUnitUtil.PpsData) sparseArray.get(readUnsignedExpGolombCodedInt2);
                            NalUnitUtil.SpsData spsData = (NalUnitUtil.SpsData) vy0Var.f27996d.get(ppsData.seqParameterSetId);
                            if (spsData.separateColorPlaneFlag) {
                                if (parsableNalUnitBitArray.canReadBits(2)) {
                                    parsableNalUnitBitArray.skipBits(2);
                                } else {
                                    return;
                                }
                            }
                            if (parsableNalUnitBitArray.canReadBits(spsData.frameNumLength)) {
                                int readBits2 = parsableNalUnitBitArray.readBits(spsData.frameNumLength);
                                if (!spsData.frameMbsOnlyFlag) {
                                    if (parsableNalUnitBitArray.canReadBits(1)) {
                                        z = parsableNalUnitBitArray.readBit();
                                        if (z) {
                                            if (parsableNalUnitBitArray.canReadBits(1)) {
                                                z2 = parsableNalUnitBitArray.readBit();
                                                z3 = true;
                                                if (vy0Var.f28001i != 5) {
                                                    z4 = true;
                                                } else {
                                                    z4 = false;
                                                }
                                                if (!z4) {
                                                    if (parsableNalUnitBitArray.canReadExpGolombCodedNum()) {
                                                        i3 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
                                                    } else {
                                                        return;
                                                    }
                                                } else {
                                                    i3 = 0;
                                                }
                                                i4 = spsData.picOrderCountType;
                                                if (i4 != 0) {
                                                    if (parsableNalUnitBitArray.canReadBits(spsData.picOrderCntLsbLength)) {
                                                        int readBits3 = parsableNalUnitBitArray.readBits(spsData.picOrderCntLsbLength);
                                                        if (ppsData.bottomFieldPicOrderInFramePresentFlag && !z) {
                                                            if (parsableNalUnitBitArray.canReadExpGolombCodedNum()) {
                                                                i5 = parsableNalUnitBitArray.readSignedExpGolombCodedInt();
                                                                i8 = readBits3;
                                                            } else {
                                                                return;
                                                            }
                                                        } else {
                                                            i8 = readBits3;
                                                            i5 = 0;
                                                        }
                                                        i6 = 0;
                                                        i7 = 0;
                                                    } else {
                                                        return;
                                                    }
                                                } else {
                                                    if (i4 == 1 && !spsData.deltaPicOrderAlwaysZeroFlag) {
                                                        if (parsableNalUnitBitArray.canReadExpGolombCodedNum()) {
                                                            int readSignedExpGolombCodedInt = parsableNalUnitBitArray.readSignedExpGolombCodedInt();
                                                            if (ppsData.bottomFieldPicOrderInFramePresentFlag && !z) {
                                                                if (parsableNalUnitBitArray.canReadExpGolombCodedNum()) {
                                                                    i7 = readSignedExpGolombCodedInt;
                                                                    i8 = 0;
                                                                    i6 = parsableNalUnitBitArray.readSignedExpGolombCodedInt();
                                                                    i5 = 0;
                                                                } else {
                                                                    return;
                                                                }
                                                            } else {
                                                                i7 = readSignedExpGolombCodedInt;
                                                                i5 = 0;
                                                                i6 = 0;
                                                            }
                                                        } else {
                                                            return;
                                                        }
                                                    } else {
                                                        i5 = 0;
                                                        i6 = 0;
                                                        i7 = 0;
                                                    }
                                                    i8 = 0;
                                                }
                                                uy0 uy0Var2 = vy0Var.f28006n;
                                                uy0Var2.f27530c = spsData;
                                                uy0Var2.f27531d = readBits;
                                                uy0Var2.f27532e = readUnsignedExpGolombCodedInt;
                                                uy0Var2.f27533f = readBits2;
                                                uy0Var2.f27534g = readUnsignedExpGolombCodedInt2;
                                                uy0Var2.f27535h = z;
                                                uy0Var2.f27536i = z3;
                                                uy0Var2.f27537j = z2;
                                                uy0Var2.f27538k = z4;
                                                uy0Var2.f27539l = i3;
                                                uy0Var2.f27540m = i8;
                                                uy0Var2.f27541n = i5;
                                                uy0Var2.f27542o = i7;
                                                uy0Var2.f27543p = i6;
                                                uy0Var2.f27528a = true;
                                                uy0Var2.f27529b = true;
                                                vy0Var.f28003k = false;
                                            }
                                            return;
                                        }
                                        z2 = false;
                                    } else {
                                        return;
                                    }
                                } else {
                                    z = false;
                                    z2 = false;
                                }
                                z3 = z2;
                                if (vy0Var.f28001i != 5) {
                                }
                                if (!z4) {
                                }
                                i4 = spsData.picOrderCountType;
                                if (i4 != 0) {
                                }
                                uy0 uy0Var22 = vy0Var.f28006n;
                                uy0Var22.f27530c = spsData;
                                uy0Var22.f27531d = readBits;
                                uy0Var22.f27532e = readUnsignedExpGolombCodedInt;
                                uy0Var22.f27533f = readBits2;
                                uy0Var22.f27534g = readUnsignedExpGolombCodedInt2;
                                uy0Var22.f27535h = z;
                                uy0Var22.f27536i = z3;
                                uy0Var22.f27537j = z2;
                                uy0Var22.f27538k = z4;
                                uy0Var22.f27539l = i3;
                                uy0Var22.f27540m = i8;
                                uy0Var22.f27541n = i5;
                                uy0Var22.f27542o = i7;
                                uy0Var22.f27543p = i6;
                                uy0Var22.f27528a = true;
                                uy0Var22.f27529b = true;
                                vy0Var.f28003k = false;
                            }
                        }
                    }
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:37:0x01b3, code lost:
    
        if (r6.f27537j == r9.f27537j) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x01bd, code lost:
    
        if (r15 != 0) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x01d1, code lost:
    
        if (r6.f27541n == r9.f27541n) goto L70;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x01e4, code lost:
    
        if (r6.f27543p == r9.f27543p) goto L78;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x01f2, code lost:
    
        if (r6.f27539l == r9.f27539l) goto L84;
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x028e, code lost:
    
        if (r1 != 1) goto L129;
     */
    /* JADX WARN: Removed duplicated region for block: B:100:0x02ae A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:101:0x0291  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x024d  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0210  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x014d  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0171  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x023b  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0255 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0263  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x026c  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x028d  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0296  */
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
        gr1 gr1Var;
        vy0 vy0Var;
        boolean z;
        boolean z2;
        long j;
        boolean z3;
        int i5;
        boolean z4;
        boolean z5;
        int i6;
        vy0 vy0Var2;
        int i7;
        boolean z6;
        int i8;
        Assertions.checkStateNotNull(this.f10456j);
        Util.castNonNull(this.f10457k);
        int position = parsableByteArray.getPosition();
        int limit = parsableByteArray.limit();
        byte[] data = parsableByteArray.getData();
        this.f10453g += parsableByteArray.bytesLeft();
        this.f10456j.sampleData(parsableByteArray, parsableByteArray.bytesLeft());
        while (true) {
            int findNalUnit = NalUnitUtil.findNalUnit(data, position, limit, this.f10454h);
            if (findNalUnit == limit) {
                m2565a(data, position, limit);
                return;
            }
            int nalUnitType = NalUnitUtil.getNalUnitType(data, findNalUnit);
            int i9 = findNalUnit - position;
            if (i9 > 0) {
                m2565a(data, position, findNalUnit);
            }
            int i10 = limit - findNalUnit;
            long j2 = this.f10453g - i10;
            if (i9 < 0) {
                i = -i9;
            } else {
                i = 0;
            }
            long j3 = this.f10459m;
            boolean z7 = this.f10458l;
            gr1 gr1Var2 = this.f10451e;
            gr1 gr1Var3 = this.f10450d;
            if (!z7 || this.f10457k.f27995c) {
                gr1Var3.m4981b(i);
                gr1Var2.m4981b(i);
                if (!this.f10458l) {
                    if (gr1Var3.f17811c && gr1Var2.f17811c) {
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(Arrays.copyOf(gr1Var3.f17812d, gr1Var3.f17813e));
                        arrayList.add(Arrays.copyOf(gr1Var2.f17812d, gr1Var2.f17813e));
                        i2 = limit;
                        NalUnitUtil.SpsData parseSpsNalUnit = NalUnitUtil.parseSpsNalUnit(gr1Var3.f17812d, 3, gr1Var3.f17813e);
                        bArr = data;
                        NalUnitUtil.PpsData parsePpsNalUnit = NalUnitUtil.parsePpsNalUnit(gr1Var2.f17812d, 3, gr1Var2.f17813e);
                        i3 = findNalUnit;
                        i4 = nalUnitType;
                        this.f10456j.format(new Format.Builder().setId(this.f10455i).setSampleMimeType(MimeTypes.VIDEO_H264).setCodecs(CodecSpecificDataUtil.buildAvcCodecString(parseSpsNalUnit.profileIdc, parseSpsNalUnit.constraintsFlagsAndReservedZero2Bits, parseSpsNalUnit.levelIdc)).setWidth(parseSpsNalUnit.width).setHeight(parseSpsNalUnit.height).setPixelWidthHeightRatio(parseSpsNalUnit.pixelWidthHeightRatio).setInitializationData(arrayList).build());
                        this.f10458l = true;
                        this.f10457k.f27996d.append(parseSpsNalUnit.seqParameterSetId, parseSpsNalUnit);
                        this.f10457k.f27997e.append(parsePpsNalUnit.picParameterSetId, parsePpsNalUnit);
                        gr1Var3.m4982c();
                        gr1Var2.m4982c();
                    }
                } else {
                    i2 = limit;
                    bArr = data;
                    i3 = findNalUnit;
                    i4 = nalUnitType;
                    if (gr1Var3.f17811c) {
                        NalUnitUtil.SpsData parseSpsNalUnit2 = NalUnitUtil.parseSpsNalUnit(gr1Var3.f17812d, 3, gr1Var3.f17813e);
                        this.f10457k.f27996d.append(parseSpsNalUnit2.seqParameterSetId, parseSpsNalUnit2);
                        gr1Var3.m4982c();
                    } else if (gr1Var2.f17811c) {
                        NalUnitUtil.PpsData parsePpsNalUnit2 = NalUnitUtil.parsePpsNalUnit(gr1Var2.f17812d, 3, gr1Var2.f17813e);
                        this.f10457k.f27997e.append(parsePpsNalUnit2.picParameterSetId, parsePpsNalUnit2);
                        gr1Var2.m4982c();
                    }
                }
                gr1Var = this.f10452f;
                if (gr1Var.m4981b(i)) {
                    int unescapeStream = NalUnitUtil.unescapeStream(gr1Var.f17812d, gr1Var.f17813e);
                    byte[] bArr2 = gr1Var.f17812d;
                    ParsableByteArray parsableByteArray2 = this.f10461o;
                    parsableByteArray2.reset(bArr2, unescapeStream);
                    parsableByteArray2.setPosition(4);
                    this.f10447a.consume(j3, parsableByteArray2);
                }
                vy0Var = this.f10457k;
                z = this.f10458l;
                boolean z8 = this.f10460n;
                if (vy0Var.f28001i != 9) {
                    if (vy0Var.f27995c) {
                        uy0 uy0Var = vy0Var.f28006n;
                        uy0 uy0Var2 = vy0Var.f28005m;
                        if (uy0Var.f27528a) {
                            if (uy0Var2.f27528a) {
                                NalUnitUtil.SpsData spsData = (NalUnitUtil.SpsData) Assertions.checkStateNotNull(uy0Var.f27530c);
                                NalUnitUtil.SpsData spsData2 = (NalUnitUtil.SpsData) Assertions.checkStateNotNull(uy0Var2.f27530c);
                                if (uy0Var.f27533f == uy0Var2.f27533f) {
                                    if (uy0Var.f27534g == uy0Var2.f27534g) {
                                        if (uy0Var.f27535h == uy0Var2.f27535h) {
                                            if (uy0Var.f27536i) {
                                                if (uy0Var2.f27536i) {
                                                }
                                            }
                                            int i11 = uy0Var.f27531d;
                                            int i12 = uy0Var2.f27531d;
                                            if (i11 != i12) {
                                                if (i11 != 0) {
                                                }
                                            }
                                            int i13 = spsData.picOrderCountType;
                                            if (i13 == 0) {
                                                if (spsData2.picOrderCountType == 0) {
                                                    if (uy0Var.f27540m == uy0Var2.f27540m) {
                                                    }
                                                }
                                            }
                                            if (i13 == 1) {
                                                if (spsData2.picOrderCountType == 1) {
                                                    if (uy0Var.f27542o == uy0Var2.f27542o) {
                                                    }
                                                }
                                            }
                                            boolean z9 = uy0Var.f27538k;
                                            if (z9 == uy0Var2.f27538k) {
                                                if (z9) {
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    z2 = z8;
                    if (!vy0Var.f27994b) {
                        uy0 uy0Var3 = vy0Var.f28006n;
                        if (uy0Var3.f27529b && ((i8 = uy0Var3.f27532e) == 7 || i8 == 2)) {
                            z6 = true;
                        } else {
                            z6 = false;
                        }
                        z3 = z6;
                    } else {
                        z3 = z2;
                    }
                    boolean z10 = vy0Var.f28010r;
                    i5 = vy0Var.f28001i;
                    if (i5 == 5 && (!z3 || i5 != 1)) {
                        z4 = false;
                    } else {
                        z4 = true;
                    }
                    z5 = z10 | z4;
                    vy0Var.f28010r = z5;
                    if (z5) {
                        this.f10460n = false;
                    }
                    long j4 = this.f10459m;
                    if (this.f10458l || this.f10457k.f27995c) {
                        i6 = i4;
                        gr1Var3.m4983d(i6);
                        gr1Var2.m4983d(i6);
                    } else {
                        i6 = i4;
                    }
                    gr1Var.m4983d(i6);
                    vy0Var2 = this.f10457k;
                    vy0Var2.f28001i = i6;
                    vy0Var2.f28004l = j4;
                    vy0Var2.f28002j = j2;
                    if (!vy0Var2.f27994b) {
                        i7 = 1;
                    } else {
                        i7 = 1;
                    }
                    if (vy0Var2.f27995c) {
                        if (i6 != 5 && i6 != i7 && i6 != 2) {
                        }
                        uy0 uy0Var4 = vy0Var2.f28005m;
                        vy0Var2.f28005m = vy0Var2.f28006n;
                        vy0Var2.f28006n = uy0Var4;
                        uy0Var4.f27529b = false;
                        uy0Var4.f27528a = false;
                        vy0Var2.f28000h = 0;
                        vy0Var2.f28003k = true;
                    }
                    position = i3 + 3;
                    limit = i2;
                    data = bArr;
                }
                if (z && vy0Var.f28007o) {
                    long j5 = vy0Var.f28002j;
                    int i14 = i10 + ((int) (j2 - j5));
                    j = vy0Var.f28009q;
                    if (j != C0643C.TIME_UNSET) {
                        z2 = z8;
                        vy0Var.f27993a.sampleMetadata(j, vy0Var.f28010r ? 1 : 0, (int) (j5 - vy0Var.f28008p), i14, null);
                        vy0Var.f28008p = vy0Var.f28002j;
                        vy0Var.f28009q = vy0Var.f28004l;
                        vy0Var.f28010r = false;
                        vy0Var.f28007o = true;
                        if (!vy0Var.f27994b) {
                        }
                        boolean z102 = vy0Var.f28010r;
                        i5 = vy0Var.f28001i;
                        if (i5 == 5) {
                        }
                        z4 = true;
                        z5 = z102 | z4;
                        vy0Var.f28010r = z5;
                        if (z5) {
                        }
                        long j42 = this.f10459m;
                        if (this.f10458l) {
                        }
                        i6 = i4;
                        gr1Var3.m4983d(i6);
                        gr1Var2.m4983d(i6);
                        gr1Var.m4983d(i6);
                        vy0Var2 = this.f10457k;
                        vy0Var2.f28001i = i6;
                        vy0Var2.f28004l = j42;
                        vy0Var2.f28002j = j2;
                        if (!vy0Var2.f27994b) {
                        }
                        if (vy0Var2.f27995c) {
                        }
                        position = i3 + 3;
                        limit = i2;
                        data = bArr;
                    }
                }
                z2 = z8;
                vy0Var.f28008p = vy0Var.f28002j;
                vy0Var.f28009q = vy0Var.f28004l;
                vy0Var.f28010r = false;
                vy0Var.f28007o = true;
                if (!vy0Var.f27994b) {
                }
                boolean z1022 = vy0Var.f28010r;
                i5 = vy0Var.f28001i;
                if (i5 == 5) {
                }
                z4 = true;
                z5 = z1022 | z4;
                vy0Var.f28010r = z5;
                if (z5) {
                }
                long j422 = this.f10459m;
                if (this.f10458l) {
                }
                i6 = i4;
                gr1Var3.m4983d(i6);
                gr1Var2.m4983d(i6);
                gr1Var.m4983d(i6);
                vy0Var2 = this.f10457k;
                vy0Var2.f28001i = i6;
                vy0Var2.f28004l = j422;
                vy0Var2.f28002j = j2;
                if (!vy0Var2.f27994b) {
                }
                if (vy0Var2.f27995c) {
                }
                position = i3 + 3;
                limit = i2;
                data = bArr;
            }
            i2 = limit;
            bArr = data;
            i3 = findNalUnit;
            i4 = nalUnitType;
            gr1Var = this.f10452f;
            if (gr1Var.m4981b(i)) {
            }
            vy0Var = this.f10457k;
            z = this.f10458l;
            boolean z82 = this.f10460n;
            if (vy0Var.f28001i != 9) {
            }
            if (z) {
                long j52 = vy0Var.f28002j;
                int i142 = i10 + ((int) (j2 - j52));
                j = vy0Var.f28009q;
                if (j != C0643C.TIME_UNSET) {
                }
            }
            z2 = z82;
            vy0Var.f28008p = vy0Var.f28002j;
            vy0Var.f28009q = vy0Var.f28004l;
            vy0Var.f28010r = false;
            vy0Var.f28007o = true;
            if (!vy0Var.f27994b) {
            }
            boolean z10222 = vy0Var.f28010r;
            i5 = vy0Var.f28001i;
            if (i5 == 5) {
            }
            z4 = true;
            z5 = z10222 | z4;
            vy0Var.f28010r = z5;
            if (z5) {
            }
            long j4222 = this.f10459m;
            if (this.f10458l) {
            }
            i6 = i4;
            gr1Var3.m4983d(i6);
            gr1Var2.m4983d(i6);
            gr1Var.m4983d(i6);
            vy0Var2 = this.f10457k;
            vy0Var2.f28001i = i6;
            vy0Var2.f28004l = j4222;
            vy0Var2.f28002j = j2;
            if (!vy0Var2.f27994b) {
            }
            if (vy0Var2.f27995c) {
            }
            position = i3 + 3;
            limit = i2;
            data = bArr;
        }
    }

    @Override // com.google.android.exoplayer2.extractor.p002ts.ElementaryStreamReader
    public void createTracks(ExtractorOutput extractorOutput, TsPayloadReader.TrackIdGenerator trackIdGenerator) {
        trackIdGenerator.generateNewId();
        this.f10455i = trackIdGenerator.getFormatId();
        TrackOutput track = extractorOutput.track(trackIdGenerator.getTrackId(), 2);
        this.f10456j = track;
        this.f10457k = new vy0(track, this.f10448b, this.f10449c);
        this.f10447a.createTracks(extractorOutput, trackIdGenerator);
    }

    @Override // com.google.android.exoplayer2.extractor.p002ts.ElementaryStreamReader
    public void packetFinished() {
    }

    @Override // com.google.android.exoplayer2.extractor.p002ts.ElementaryStreamReader
    public void packetStarted(long j, int i) {
        boolean z;
        if (j != C0643C.TIME_UNSET) {
            this.f10459m = j;
        }
        boolean z2 = this.f10460n;
        if ((i & 2) != 0) {
            z = true;
        } else {
            z = false;
        }
        this.f10460n = z2 | z;
    }

    @Override // com.google.android.exoplayer2.extractor.p002ts.ElementaryStreamReader
    public void seek() {
        this.f10453g = 0L;
        this.f10460n = false;
        this.f10459m = C0643C.TIME_UNSET;
        NalUnitUtil.clearPrefixFlags(this.f10454h);
        this.f10450d.m4982c();
        this.f10451e.m4982c();
        this.f10452f.m4982c();
        vy0 vy0Var = this.f10457k;
        if (vy0Var != null) {
            vy0Var.f28003k = false;
            vy0Var.f28007o = false;
            uy0 uy0Var = vy0Var.f28006n;
            uy0Var.f27529b = false;
            uy0Var.f27528a = false;
        }
    }
}
