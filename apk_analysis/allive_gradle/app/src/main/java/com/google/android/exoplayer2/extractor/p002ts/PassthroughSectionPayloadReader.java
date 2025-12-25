package com.google.android.exoplayer2.extractor.p002ts;

import com.google.android.exoplayer2.C0643C;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.extractor.p002ts.TsPayloadReader;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.TimestampAdjuster;
import com.google.android.exoplayer2.util.Util;

/* loaded from: classes.dex */
public final class PassthroughSectionPayloadReader implements SectionPayloadReader {

    /* renamed from: a */
    public Format f10515a;

    /* renamed from: b */
    public TimestampAdjuster f10516b;

    /* renamed from: c */
    public TrackOutput f10517c;

    public PassthroughSectionPayloadReader(String str) {
        this.f10515a = new Format.Builder().setSampleMimeType(str).build();
    }

    @Override // com.google.android.exoplayer2.extractor.p002ts.SectionPayloadReader
    public void consume(ParsableByteArray parsableByteArray) {
        Assertions.checkStateNotNull(this.f10516b);
        Util.castNonNull(this.f10517c);
        long lastAdjustedTimestampUs = this.f10516b.getLastAdjustedTimestampUs();
        long timestampOffsetUs = this.f10516b.getTimestampOffsetUs();
        if (lastAdjustedTimestampUs != C0643C.TIME_UNSET && timestampOffsetUs != C0643C.TIME_UNSET) {
            Format format = this.f10515a;
            if (timestampOffsetUs != format.subsampleOffsetUs) {
                Format build = format.buildUpon().setSubsampleOffsetUs(timestampOffsetUs).build();
                this.f10515a = build;
                this.f10517c.format(build);
            }
            int bytesLeft = parsableByteArray.bytesLeft();
            this.f10517c.sampleData(parsableByteArray, bytesLeft);
            this.f10517c.sampleMetadata(lastAdjustedTimestampUs, 1, bytesLeft, 0, null);
        }
    }

    @Override // com.google.android.exoplayer2.extractor.p002ts.SectionPayloadReader
    public void init(TimestampAdjuster timestampAdjuster, ExtractorOutput extractorOutput, TsPayloadReader.TrackIdGenerator trackIdGenerator) {
        this.f10516b = timestampAdjuster;
        trackIdGenerator.generateNewId();
        TrackOutput track = extractorOutput.track(trackIdGenerator.getTrackId(), 5);
        this.f10517c = track;
        track.format(this.f10515a);
    }
}
