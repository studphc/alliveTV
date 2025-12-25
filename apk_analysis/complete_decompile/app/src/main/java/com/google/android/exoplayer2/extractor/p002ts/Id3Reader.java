package com.google.android.exoplayer2.extractor.p002ts;

import com.google.android.exoplayer2.C0643C;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.extractor.p002ts.TsPayloadReader;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.ParsableByteArray;

/* loaded from: classes.dex */
public final class Id3Reader implements ElementaryStreamReader {

    /* renamed from: b */
    public TrackOutput f10477b;

    /* renamed from: c */
    public boolean f10478c;

    /* renamed from: e */
    public int f10480e;

    /* renamed from: f */
    public int f10481f;

    /* renamed from: a */
    public final ParsableByteArray f10476a = new ParsableByteArray(10);

    /* renamed from: d */
    public long f10479d = C0643C.TIME_UNSET;

    @Override // com.google.android.exoplayer2.extractor.p002ts.ElementaryStreamReader
    public void consume(ParsableByteArray parsableByteArray) {
        Assertions.checkStateNotNull(this.f10477b);
        if (!this.f10478c) {
            return;
        }
        int bytesLeft = parsableByteArray.bytesLeft();
        int i = this.f10481f;
        if (i < 10) {
            int min = Math.min(bytesLeft, 10 - i);
            byte[] data = parsableByteArray.getData();
            int position = parsableByteArray.getPosition();
            ParsableByteArray parsableByteArray2 = this.f10476a;
            System.arraycopy(data, position, parsableByteArray2.getData(), this.f10481f, min);
            if (this.f10481f + min == 10) {
                parsableByteArray2.setPosition(0);
                if (73 == parsableByteArray2.readUnsignedByte() && 68 == parsableByteArray2.readUnsignedByte() && 51 == parsableByteArray2.readUnsignedByte()) {
                    parsableByteArray2.skipBytes(3);
                    this.f10480e = parsableByteArray2.readSynchSafeInt() + 10;
                } else {
                    Log.m3027w("Id3Reader", "Discarding invalid ID3 tag");
                    this.f10478c = false;
                    return;
                }
            }
        }
        int min2 = Math.min(bytesLeft, this.f10480e - this.f10481f);
        this.f10477b.sampleData(parsableByteArray, min2);
        this.f10481f += min2;
    }

    @Override // com.google.android.exoplayer2.extractor.p002ts.ElementaryStreamReader
    public void createTracks(ExtractorOutput extractorOutput, TsPayloadReader.TrackIdGenerator trackIdGenerator) {
        trackIdGenerator.generateNewId();
        TrackOutput track = extractorOutput.track(trackIdGenerator.getTrackId(), 5);
        this.f10477b = track;
        track.format(new Format.Builder().setId(trackIdGenerator.getFormatId()).setSampleMimeType(MimeTypes.APPLICATION_ID3).build());
    }

    @Override // com.google.android.exoplayer2.extractor.p002ts.ElementaryStreamReader
    public void packetFinished() {
        int i;
        Assertions.checkStateNotNull(this.f10477b);
        if (this.f10478c && (i = this.f10480e) != 0 && this.f10481f == i) {
            long j = this.f10479d;
            if (j != C0643C.TIME_UNSET) {
                this.f10477b.sampleMetadata(j, 1, i, 0, null);
            }
            this.f10478c = false;
        }
    }

    @Override // com.google.android.exoplayer2.extractor.p002ts.ElementaryStreamReader
    public void packetStarted(long j, int i) {
        if ((i & 4) == 0) {
            return;
        }
        this.f10478c = true;
        if (j != C0643C.TIME_UNSET) {
            this.f10479d = j;
        }
        this.f10480e = 0;
        this.f10481f = 0;
    }

    @Override // com.google.android.exoplayer2.extractor.p002ts.ElementaryStreamReader
    public void seek() {
        this.f10478c = false;
        this.f10479d = C0643C.TIME_UNSET;
    }
}
