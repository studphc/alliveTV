package com.google.android.exoplayer2.extractor.p002ts;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.C0643C;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.audio.DtsUtil;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.extractor.p002ts.TsPayloadReader;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.ParsableByteArray;

/* loaded from: classes.dex */
public final class DtsReader implements ElementaryStreamReader {

    /* renamed from: b */
    public final String f10402b;

    /* renamed from: c */
    public String f10403c;

    /* renamed from: d */
    public TrackOutput f10404d;

    /* renamed from: f */
    public int f10406f;

    /* renamed from: g */
    public int f10407g;

    /* renamed from: h */
    public long f10408h;

    /* renamed from: i */
    public Format f10409i;

    /* renamed from: j */
    public int f10410j;

    /* renamed from: a */
    public final ParsableByteArray f10401a = new ParsableByteArray(new byte[18]);

    /* renamed from: e */
    public int f10405e = 0;

    /* renamed from: k */
    public long f10411k = C0643C.TIME_UNSET;

    public DtsReader(@Nullable String str) {
        this.f10402b = str;
    }

    @Override // com.google.android.exoplayer2.extractor.p002ts.ElementaryStreamReader
    public void consume(ParsableByteArray parsableByteArray) {
        Assertions.checkStateNotNull(this.f10404d);
        while (parsableByteArray.bytesLeft() > 0) {
            int i = this.f10405e;
            ParsableByteArray parsableByteArray2 = this.f10401a;
            if (i == 0) {
                while (true) {
                    if (parsableByteArray.bytesLeft() > 0) {
                        int i2 = this.f10407g << 8;
                        this.f10407g = i2;
                        int readUnsignedByte = i2 | parsableByteArray.readUnsignedByte();
                        this.f10407g = readUnsignedByte;
                        if (DtsUtil.isSyncWord(readUnsignedByte)) {
                            byte[] data = parsableByteArray2.getData();
                            int i3 = this.f10407g;
                            data[0] = (byte) ((i3 >> 24) & 255);
                            data[1] = (byte) ((i3 >> 16) & 255);
                            data[2] = (byte) ((i3 >> 8) & 255);
                            data[3] = (byte) (i3 & 255);
                            this.f10406f = 4;
                            this.f10407g = 0;
                            this.f10405e = 1;
                            break;
                        }
                    }
                }
            } else if (i != 1) {
                if (i == 2) {
                    int min = Math.min(parsableByteArray.bytesLeft(), this.f10410j - this.f10406f);
                    this.f10404d.sampleData(parsableByteArray, min);
                    int i4 = this.f10406f + min;
                    this.f10406f = i4;
                    int i5 = this.f10410j;
                    if (i4 == i5) {
                        long j = this.f10411k;
                        if (j != C0643C.TIME_UNSET) {
                            this.f10404d.sampleMetadata(j, 1, i5, 0, null);
                            this.f10411k += this.f10408h;
                        }
                        this.f10405e = 0;
                    }
                } else {
                    throw new IllegalStateException();
                }
            } else {
                byte[] data2 = parsableByteArray2.getData();
                int min2 = Math.min(parsableByteArray.bytesLeft(), 18 - this.f10406f);
                parsableByteArray.readBytes(data2, this.f10406f, min2);
                int i6 = this.f10406f + min2;
                this.f10406f = i6;
                if (i6 == 18) {
                    byte[] data3 = parsableByteArray2.getData();
                    if (this.f10409i == null) {
                        Format parseDtsFormat = DtsUtil.parseDtsFormat(data3, this.f10403c, this.f10402b, null);
                        this.f10409i = parseDtsFormat;
                        this.f10404d.format(parseDtsFormat);
                    }
                    this.f10410j = DtsUtil.getDtsFrameSize(data3);
                    this.f10408h = (int) ((DtsUtil.parseDtsAudioSampleCount(data3) * 1000000) / this.f10409i.sampleRate);
                    parsableByteArray2.setPosition(0);
                    this.f10404d.sampleData(parsableByteArray2, 18);
                    this.f10405e = 2;
                }
            }
        }
    }

    @Override // com.google.android.exoplayer2.extractor.p002ts.ElementaryStreamReader
    public void createTracks(ExtractorOutput extractorOutput, TsPayloadReader.TrackIdGenerator trackIdGenerator) {
        trackIdGenerator.generateNewId();
        this.f10403c = trackIdGenerator.getFormatId();
        this.f10404d = extractorOutput.track(trackIdGenerator.getTrackId(), 1);
    }

    @Override // com.google.android.exoplayer2.extractor.p002ts.ElementaryStreamReader
    public void packetFinished() {
    }

    @Override // com.google.android.exoplayer2.extractor.p002ts.ElementaryStreamReader
    public void packetStarted(long j, int i) {
        if (j != C0643C.TIME_UNSET) {
            this.f10411k = j;
        }
    }

    @Override // com.google.android.exoplayer2.extractor.p002ts.ElementaryStreamReader
    public void seek() {
        this.f10405e = 0;
        this.f10406f = 0;
        this.f10407g = 0;
        this.f10411k = C0643C.TIME_UNSET;
    }
}
