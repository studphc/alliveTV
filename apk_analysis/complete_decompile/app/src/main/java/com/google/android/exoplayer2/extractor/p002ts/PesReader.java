package com.google.android.exoplayer2.extractor.p002ts;

import com.google.android.exoplayer2.C0643C;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.p002ts.TsPayloadReader;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.ParsableBitArray;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.TimestampAdjuster;
import p000.AbstractC1726qj;

/* loaded from: classes.dex */
public final class PesReader implements TsPayloadReader {

    /* renamed from: a */
    public final ElementaryStreamReader f10518a;

    /* renamed from: b */
    public final ParsableBitArray f10519b = new ParsableBitArray(new byte[10]);

    /* renamed from: c */
    public int f10520c = 0;

    /* renamed from: d */
    public int f10521d;

    /* renamed from: e */
    public TimestampAdjuster f10522e;

    /* renamed from: f */
    public boolean f10523f;

    /* renamed from: g */
    public boolean f10524g;

    /* renamed from: h */
    public boolean f10525h;

    /* renamed from: i */
    public int f10526i;

    /* renamed from: j */
    public int f10527j;

    /* renamed from: k */
    public boolean f10528k;

    /* renamed from: l */
    public long f10529l;

    public PesReader(ElementaryStreamReader elementaryStreamReader) {
        this.f10518a = elementaryStreamReader;
    }

    /* renamed from: a */
    public final boolean m2567a(ParsableByteArray parsableByteArray, byte[] bArr, int i) {
        int min = Math.min(parsableByteArray.bytesLeft(), i - this.f10521d);
        if (min <= 0) {
            return true;
        }
        if (bArr == null) {
            parsableByteArray.skipBytes(min);
        } else {
            parsableByteArray.readBytes(bArr, this.f10521d, min);
        }
        int i2 = this.f10521d + min;
        this.f10521d = i2;
        if (i2 == i) {
            return true;
        }
        return false;
    }

    @Override // com.google.android.exoplayer2.extractor.p002ts.TsPayloadReader
    public final void consume(ParsableByteArray parsableByteArray, int i) {
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        Assertions.checkStateNotNull(this.f10522e);
        int i7 = i & 1;
        ElementaryStreamReader elementaryStreamReader = this.f10518a;
        int i8 = -1;
        int i9 = 3;
        int i10 = 2;
        if (i7 != 0) {
            int i11 = this.f10520c;
            if (i11 != 0 && i11 != 1) {
                if (i11 != 2) {
                    if (i11 == 3) {
                        if (this.f10527j != -1) {
                            Log.m3027w("PesReader", "Unexpected start indicator: expected " + this.f10527j + " more bytes");
                        }
                        elementaryStreamReader.packetFinished();
                    } else {
                        throw new IllegalStateException();
                    }
                } else {
                    Log.m3027w("PesReader", "Unexpected start indicator reading extended header");
                }
            }
            this.f10520c = 1;
            this.f10521d = 0;
        }
        int i12 = i;
        while (parsableByteArray.bytesLeft() > 0) {
            int i13 = this.f10520c;
            if (i13 != 0) {
                ParsableBitArray parsableBitArray = this.f10519b;
                if (i13 != 1) {
                    if (i13 != i10) {
                        if (i13 == i9) {
                            int bytesLeft = parsableByteArray.bytesLeft();
                            int i14 = this.f10527j;
                            if (i14 == i8) {
                                i6 = 0;
                            } else {
                                i6 = bytesLeft - i14;
                            }
                            if (i6 > 0) {
                                bytesLeft -= i6;
                                parsableByteArray.setLimit(parsableByteArray.getPosition() + bytesLeft);
                            }
                            elementaryStreamReader.consume(parsableByteArray);
                            int i15 = this.f10527j;
                            if (i15 != i8) {
                                int i16 = i15 - bytesLeft;
                                this.f10527j = i16;
                                if (i16 == 0) {
                                    elementaryStreamReader.packetFinished();
                                    this.f10520c = 1;
                                    this.f10521d = 0;
                                }
                            }
                            i2 = i10;
                            int i17 = i9;
                            i3 = i8;
                            i4 = i17;
                        } else {
                            throw new IllegalStateException();
                        }
                    } else {
                        if (m2567a(parsableByteArray, parsableBitArray.data, Math.min(10, this.f10526i)) && m2567a(parsableByteArray, null, this.f10526i)) {
                            parsableBitArray.setPosition(0);
                            this.f10529l = C0643C.TIME_UNSET;
                            int i18 = 4;
                            if (this.f10523f) {
                                parsableBitArray.skipBits(4);
                                parsableBitArray.skipBits(1);
                                parsableBitArray.skipBits(1);
                                long readBits = (parsableBitArray.readBits(15) << 15) | (parsableBitArray.readBits(i9) << 30) | parsableBitArray.readBits(15);
                                parsableBitArray.skipBits(1);
                                if (!this.f10525h && this.f10524g) {
                                    parsableBitArray.skipBits(4);
                                    parsableBitArray.skipBits(1);
                                    parsableBitArray.skipBits(1);
                                    parsableBitArray.skipBits(1);
                                    this.f10522e.adjustTsTimestamp((parsableBitArray.readBits(3) << 30) | (parsableBitArray.readBits(15) << 15) | parsableBitArray.readBits(15));
                                    this.f10525h = true;
                                }
                                this.f10529l = this.f10522e.adjustTsTimestamp(readBits);
                            }
                            if (!this.f10528k) {
                                i18 = 0;
                            }
                            i12 |= i18;
                            elementaryStreamReader.packetStarted(this.f10529l, i12);
                            this.f10520c = 3;
                            this.f10521d = 0;
                            i9 = 3;
                            i8 = -1;
                            i10 = 2;
                        } else {
                            i4 = i9;
                            i2 = i10;
                            i3 = -1;
                        }
                    }
                } else {
                    i4 = i9;
                    if (m2567a(parsableByteArray, parsableBitArray.data, 9)) {
                        parsableBitArray.setPosition(0);
                        int readBits2 = parsableBitArray.readBits(24);
                        if (readBits2 != 1) {
                            AbstractC1726qj.m7036A(readBits2, "Unexpected start code prefix: ", "PesReader");
                            this.f10527j = -1;
                            i5 = 0;
                            i3 = -1;
                            i2 = 2;
                        } else {
                            parsableBitArray.skipBits(8);
                            int readBits3 = parsableBitArray.readBits(16);
                            parsableBitArray.skipBits(5);
                            this.f10528k = parsableBitArray.readBit();
                            i2 = 2;
                            parsableBitArray.skipBits(2);
                            this.f10523f = parsableBitArray.readBit();
                            this.f10524g = parsableBitArray.readBit();
                            parsableBitArray.skipBits(6);
                            int readBits4 = parsableBitArray.readBits(8);
                            this.f10526i = readBits4;
                            if (readBits3 == 0) {
                                this.f10527j = -1;
                                i3 = -1;
                            } else {
                                int i19 = (readBits3 - 3) - readBits4;
                                this.f10527j = i19;
                                if (i19 < 0) {
                                    Log.m3027w("PesReader", "Found negative packet payload size: " + this.f10527j);
                                    i3 = -1;
                                    this.f10527j = -1;
                                } else {
                                    i3 = -1;
                                }
                            }
                            i5 = 2;
                        }
                        this.f10520c = i5;
                        this.f10521d = 0;
                    } else {
                        i3 = -1;
                        i2 = 2;
                    }
                }
            } else {
                i2 = i10;
                int i20 = i9;
                i3 = i8;
                i4 = i20;
                parsableByteArray.skipBytes(parsableByteArray.bytesLeft());
            }
            i10 = i2;
            int i21 = i3;
            i9 = i4;
            i8 = i21;
        }
    }

    @Override // com.google.android.exoplayer2.extractor.p002ts.TsPayloadReader
    public void init(TimestampAdjuster timestampAdjuster, ExtractorOutput extractorOutput, TsPayloadReader.TrackIdGenerator trackIdGenerator) {
        this.f10522e = timestampAdjuster;
        this.f10518a.createTracks(extractorOutput, trackIdGenerator);
    }

    @Override // com.google.android.exoplayer2.extractor.p002ts.TsPayloadReader
    public final void seek() {
        this.f10520c = 0;
        this.f10521d = 0;
        this.f10525h = false;
        this.f10518a.seek();
    }
}
