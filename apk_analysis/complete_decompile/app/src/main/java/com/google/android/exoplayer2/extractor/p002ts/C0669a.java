package com.google.android.exoplayer2.extractor.p002ts;

import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.p002ts.TsPayloadReader;
import com.google.android.exoplayer2.util.ParsableBitArray;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.TimestampAdjuster;

/* renamed from: com.google.android.exoplayer2.extractor.ts.a */
/* loaded from: classes.dex */
public final class C0669a implements SectionPayloadReader {

    /* renamed from: a */
    public final ParsableBitArray f10573a = new ParsableBitArray(new byte[4]);

    /* renamed from: b */
    public final /* synthetic */ TsExtractor f10574b;

    public C0669a(TsExtractor tsExtractor) {
        this.f10574b = tsExtractor;
    }

    @Override // com.google.android.exoplayer2.extractor.p002ts.SectionPayloadReader
    public final void consume(ParsableByteArray parsableByteArray) {
        TsExtractor tsExtractor;
        if (parsableByteArray.readUnsignedByte() != 0 || (parsableByteArray.readUnsignedByte() & 128) == 0) {
            return;
        }
        parsableByteArray.skipBytes(6);
        int bytesLeft = parsableByteArray.bytesLeft() / 4;
        int i = 0;
        while (true) {
            tsExtractor = this.f10574b;
            if (i >= bytesLeft) {
                break;
            }
            ParsableBitArray parsableBitArray = this.f10573a;
            parsableByteArray.readBytes(parsableBitArray, 4);
            int readBits = parsableBitArray.readBits(16);
            parsableBitArray.skipBits(3);
            if (readBits == 0) {
                parsableBitArray.skipBits(13);
            } else {
                int readBits2 = parsableBitArray.readBits(13);
                if (tsExtractor.f10555g.get(readBits2) == null) {
                    tsExtractor.f10555g.put(readBits2, new SectionReader(new C0670b(tsExtractor, readBits2)));
                    tsExtractor.f10561m++;
                }
            }
            i++;
        }
        if (tsExtractor.f10549a != 2) {
            tsExtractor.f10555g.remove(0);
        }
    }

    @Override // com.google.android.exoplayer2.extractor.p002ts.SectionPayloadReader
    public final void init(TimestampAdjuster timestampAdjuster, ExtractorOutput extractorOutput, TsPayloadReader.TrackIdGenerator trackIdGenerator) {
    }
}
