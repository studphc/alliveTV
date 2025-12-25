package com.google.android.exoplayer2.extractor.p002ts;

import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.p002ts.TsPayloadReader;
import com.google.android.exoplayer2.util.ParsableBitArray;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.TimestampAdjuster;
import com.google.android.exoplayer2.util.Util;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* renamed from: com.google.android.exoplayer2.extractor.ts.b */
/* loaded from: classes.dex */
public final class C0670b implements SectionPayloadReader {

    /* renamed from: a */
    public final ParsableBitArray f10575a = new ParsableBitArray(new byte[5]);

    /* renamed from: b */
    public final SparseArray f10576b = new SparseArray();

    /* renamed from: c */
    public final SparseIntArray f10577c = new SparseIntArray();

    /* renamed from: d */
    public final int f10578d;

    /* renamed from: e */
    public final /* synthetic */ TsExtractor f10579e;

    public C0670b(TsExtractor tsExtractor, int i) {
        this.f10579e = tsExtractor;
        this.f10578d = i;
    }

    /* JADX WARN: Code restructure failed: missing block: B:59:0x0153, code lost:
    
        if (r31.readUnsignedByte() == 21) goto L42;
     */
    @Override // com.google.android.exoplayer2.extractor.p002ts.SectionPayloadReader
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void consume(ParsableByteArray parsableByteArray) {
        TimestampAdjuster timestampAdjuster;
        SparseBooleanArray sparseBooleanArray;
        SparseArray sparseArray;
        int i;
        TimestampAdjuster timestampAdjuster2;
        int i2;
        SparseArray sparseArray2;
        int i3;
        char c;
        TsPayloadReader.Factory factory;
        TsPayloadReader createPayloadReader;
        SparseIntArray sparseIntArray;
        int i4;
        SparseArray sparseArray3;
        SparseIntArray sparseIntArray2;
        TsPayloadReader.Factory factory2;
        if (parsableByteArray.readUnsignedByte() != 2) {
            return;
        }
        TsExtractor tsExtractor = this.f10579e;
        int i5 = tsExtractor.f10549a;
        List list = tsExtractor.f10551c;
        if (i5 != 1 && i5 != 2 && tsExtractor.f10561m != 1) {
            timestampAdjuster = new TimestampAdjuster(((TimestampAdjuster) list.get(0)).getFirstSampleTimestampUs());
            list.add(timestampAdjuster);
        } else {
            timestampAdjuster = (TimestampAdjuster) list.get(0);
        }
        if ((parsableByteArray.readUnsignedByte() & 128) == 0) {
            return;
        }
        parsableByteArray.skipBytes(1);
        int readUnsignedShort = parsableByteArray.readUnsignedShort();
        int i6 = 3;
        parsableByteArray.skipBytes(3);
        ParsableBitArray parsableBitArray = this.f10575a;
        parsableByteArray.readBytes(parsableBitArray, 2);
        parsableBitArray.skipBits(3);
        int i7 = 13;
        tsExtractor.f10567s = parsableBitArray.readBits(13);
        parsableByteArray.readBytes(parsableBitArray, 2);
        int i8 = 4;
        parsableBitArray.skipBits(4);
        parsableByteArray.skipBytes(parsableBitArray.readBits(12));
        TsPayloadReader.Factory factory3 = tsExtractor.f10554f;
        int i9 = tsExtractor.f10549a;
        if (i9 == 2 && tsExtractor.f10565q == null) {
            TsPayloadReader createPayloadReader2 = factory3.createPayloadReader(21, new TsPayloadReader.EsInfo(21, null, null, Util.EMPTY_BYTE_ARRAY));
            tsExtractor.f10565q = createPayloadReader2;
            if (createPayloadReader2 != null) {
                createPayloadReader2.init(timestampAdjuster, tsExtractor.f10560l, new TsPayloadReader.TrackIdGenerator(readUnsignedShort, 21, 8192));
            }
        }
        SparseArray sparseArray4 = this.f10576b;
        sparseArray4.clear();
        SparseIntArray sparseIntArray3 = this.f10577c;
        sparseIntArray3.clear();
        int bytesLeft = parsableByteArray.bytesLeft();
        while (true) {
            sparseBooleanArray = tsExtractor.f10556h;
            if (bytesLeft <= 0) {
                break;
            }
            parsableByteArray.readBytes(parsableBitArray, 5);
            int readBits = parsableBitArray.readBits(8);
            parsableBitArray.skipBits(i6);
            int readBits2 = parsableBitArray.readBits(i7);
            parsableBitArray.skipBits(i8);
            int readBits3 = parsableBitArray.readBits(12);
            int position = parsableByteArray.getPosition();
            int i10 = position + readBits3;
            int i11 = readUnsignedShort;
            ParsableBitArray parsableBitArray2 = parsableBitArray;
            int i12 = -1;
            String str = null;
            TimestampAdjuster timestampAdjuster3 = timestampAdjuster;
            ArrayList arrayList = null;
            while (true) {
                if (parsableByteArray.getPosition() < i10) {
                    int readUnsignedByte = parsableByteArray.readUnsignedByte();
                    sparseArray2 = sparseArray4;
                    int position2 = parsableByteArray.getPosition() + parsableByteArray.readUnsignedByte();
                    if (position2 > i10) {
                        break;
                    }
                    int i13 = readBits2;
                    if (readUnsignedByte == 5) {
                        long readUnsignedInt = parsableByteArray.readUnsignedInt();
                        if (readUnsignedInt == 1094921523) {
                            i12 = 129;
                        } else if (readUnsignedInt == 1161904947) {
                            i12 = 135;
                        } else {
                            if (readUnsignedInt != 1094921524) {
                                if (readUnsignedInt == 1212503619) {
                                    i12 = 36;
                                }
                            }
                            i12 = 172;
                        }
                        sparseIntArray2 = sparseIntArray3;
                        factory2 = factory3;
                    } else if (readUnsignedByte == 106) {
                        sparseIntArray2 = sparseIntArray3;
                        factory2 = factory3;
                        i12 = 129;
                    } else {
                        if (readUnsignedByte == 122) {
                            sparseIntArray2 = sparseIntArray3;
                            i12 = 135;
                            factory2 = factory3;
                        } else if (readUnsignedByte != 127) {
                            if (readUnsignedByte == 123) {
                                sparseIntArray2 = sparseIntArray3;
                                i12 = 138;
                                factory2 = factory3;
                            } else if (readUnsignedByte == 10) {
                                str = parsableByteArray.readString(3).trim();
                                sparseIntArray2 = sparseIntArray3;
                                factory2 = factory3;
                            } else if (readUnsignedByte == 89) {
                                arrayList = new ArrayList();
                                while (parsableByteArray.getPosition() < position2) {
                                    String trim = parsableByteArray.readString(3).trim();
                                    int readUnsignedByte2 = parsableByteArray.readUnsignedByte();
                                    SparseIntArray sparseIntArray4 = sparseIntArray3;
                                    byte[] bArr = new byte[4];
                                    parsableByteArray.readBytes(bArr, 0, 4);
                                    arrayList.add(new TsPayloadReader.DvbSubtitleInfo(trim, readUnsignedByte2, bArr));
                                    sparseIntArray3 = sparseIntArray4;
                                    factory3 = factory3;
                                }
                                sparseIntArray2 = sparseIntArray3;
                                factory2 = factory3;
                                i12 = 89;
                            } else {
                                sparseIntArray2 = sparseIntArray3;
                                factory2 = factory3;
                                if (readUnsignedByte == 111) {
                                    i12 = 257;
                                }
                            }
                        }
                        parsableByteArray.skipBytes(position2 - parsableByteArray.getPosition());
                        sparseIntArray3 = sparseIntArray2;
                        factory3 = factory2;
                        sparseArray4 = sparseArray2;
                        readBits2 = i13;
                    }
                    parsableByteArray.skipBytes(position2 - parsableByteArray.getPosition());
                    sparseIntArray3 = sparseIntArray2;
                    factory3 = factory2;
                    sparseArray4 = sparseArray2;
                    readBits2 = i13;
                } else {
                    sparseArray2 = sparseArray4;
                    break;
                }
            }
            SparseIntArray sparseIntArray5 = sparseIntArray3;
            int i14 = readBits2;
            TsPayloadReader.Factory factory4 = factory3;
            parsableByteArray.setPosition(i10);
            TsPayloadReader.EsInfo esInfo = new TsPayloadReader.EsInfo(i12, str, arrayList, Arrays.copyOfRange(parsableByteArray.getData(), position, i10));
            if (readBits == 6 || readBits == 5) {
                readBits = esInfo.streamType;
            }
            bytesLeft -= readBits3 + 5;
            if (i9 == 2) {
                i3 = readBits;
            } else {
                i3 = i14;
            }
            if (sparseBooleanArray.get(i3)) {
                sparseIntArray = sparseIntArray5;
                factory = factory4;
                sparseArray3 = sparseArray2;
                c = 21;
            } else {
                c = 21;
                if (i9 == 2 && readBits == 21) {
                    createPayloadReader = tsExtractor.f10565q;
                    factory = factory4;
                } else {
                    factory = factory4;
                    createPayloadReader = factory.createPayloadReader(readBits, esInfo);
                }
                sparseIntArray = sparseIntArray5;
                if (i9 == 2) {
                    i4 = i14;
                    if (i4 >= sparseIntArray.get(i3, 8192)) {
                        sparseArray3 = sparseArray2;
                    }
                } else {
                    i4 = i14;
                }
                sparseIntArray.put(i3, i4);
                sparseArray3 = sparseArray2;
                sparseArray3.put(i3, createPayloadReader);
            }
            sparseArray4 = sparseArray3;
            i8 = 4;
            factory3 = factory;
            timestampAdjuster = timestampAdjuster3;
            parsableBitArray = parsableBitArray2;
            i7 = 13;
            i6 = 3;
            sparseIntArray3 = sparseIntArray;
            readUnsignedShort = i11;
        }
        SparseArray sparseArray5 = sparseArray4;
        TimestampAdjuster timestampAdjuster4 = timestampAdjuster;
        SparseIntArray sparseIntArray6 = sparseIntArray3;
        int i15 = readUnsignedShort;
        int size = sparseIntArray6.size();
        int i16 = 0;
        while (true) {
            sparseArray = tsExtractor.f10555g;
            if (i16 >= size) {
                break;
            }
            int keyAt = sparseIntArray6.keyAt(i16);
            int valueAt = sparseIntArray6.valueAt(i16);
            sparseBooleanArray.put(keyAt, true);
            tsExtractor.f10557i.put(valueAt, true);
            TsPayloadReader tsPayloadReader = (TsPayloadReader) sparseArray5.valueAt(i16);
            if (tsPayloadReader != null) {
                if (tsPayloadReader != tsExtractor.f10565q) {
                    ExtractorOutput extractorOutput = tsExtractor.f10560l;
                    i2 = i15;
                    TsPayloadReader.TrackIdGenerator trackIdGenerator = new TsPayloadReader.TrackIdGenerator(i2, keyAt, 8192);
                    timestampAdjuster2 = timestampAdjuster4;
                    tsPayloadReader.init(timestampAdjuster2, extractorOutput, trackIdGenerator);
                } else {
                    timestampAdjuster2 = timestampAdjuster4;
                    i2 = i15;
                }
                sparseArray.put(valueAt, tsPayloadReader);
            } else {
                timestampAdjuster2 = timestampAdjuster4;
                i2 = i15;
            }
            i16++;
            timestampAdjuster4 = timestampAdjuster2;
            i15 = i2;
        }
        if (i9 == 2) {
            if (!tsExtractor.f10562n) {
                tsExtractor.f10560l.endTracks();
                tsExtractor.f10561m = 0;
                tsExtractor.f10562n = true;
            }
            return;
        }
        sparseArray.remove(this.f10578d);
        if (i9 == 1) {
            i = 0;
        } else {
            i = tsExtractor.f10561m - 1;
        }
        tsExtractor.f10561m = i;
        if (i == 0) {
            tsExtractor.f10560l.endTracks();
            tsExtractor.f10562n = true;
        }
    }

    @Override // com.google.android.exoplayer2.extractor.p002ts.SectionPayloadReader
    public final void init(TimestampAdjuster timestampAdjuster, ExtractorOutput extractorOutput, TsPayloadReader.TrackIdGenerator trackIdGenerator) {
    }
}
