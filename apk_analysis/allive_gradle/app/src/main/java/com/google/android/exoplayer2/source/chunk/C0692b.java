package com.google.android.exoplayer2.source.chunk;

import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.source.chunk.ChunkExtractor;

/* renamed from: com.google.android.exoplayer2.source.chunk.b */
/* loaded from: classes.dex */
public final class C0692b implements ExtractorOutput {

    /* renamed from: a */
    public final /* synthetic */ MediaParserChunkExtractor f11207a;

    public C0692b(MediaParserChunkExtractor mediaParserChunkExtractor) {
        this.f11207a = mediaParserChunkExtractor;
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorOutput
    public final void endTracks() {
        MediaParserChunkExtractor mediaParserChunkExtractor = this.f11207a;
        mediaParserChunkExtractor.f11195h = mediaParserChunkExtractor.f11188a.getSampleFormats();
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorOutput
    public final void seekMap(SeekMap seekMap) {
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorOutput
    public final TrackOutput track(int i, int i2) {
        MediaParserChunkExtractor mediaParserChunkExtractor = this.f11207a;
        ChunkExtractor.TrackOutputProvider trackOutputProvider = mediaParserChunkExtractor.f11194g;
        if (trackOutputProvider != null) {
            return trackOutputProvider.track(i, i2);
        }
        return mediaParserChunkExtractor.f11192e;
    }
}
