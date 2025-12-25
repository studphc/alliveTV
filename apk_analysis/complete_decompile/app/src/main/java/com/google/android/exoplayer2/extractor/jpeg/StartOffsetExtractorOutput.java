package com.google.android.exoplayer2.extractor.jpeg;

import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.extractor.TrackOutput;
import p000.hn2;

/* loaded from: classes.dex */
public final class StartOffsetExtractorOutput implements ExtractorOutput {

    /* renamed from: a */
    public final long f10184a;

    /* renamed from: b */
    public final ExtractorOutput f10185b;

    public StartOffsetExtractorOutput(long j, ExtractorOutput extractorOutput) {
        this.f10184a = j;
        this.f10185b = extractorOutput;
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorOutput
    public void endTracks() {
        this.f10185b.endTracks();
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorOutput
    public void seekMap(SeekMap seekMap) {
        this.f10185b.seekMap(new hn2(this, seekMap));
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorOutput
    public TrackOutput track(int i, int i2) {
        return this.f10185b.track(i, i2);
    }
}
