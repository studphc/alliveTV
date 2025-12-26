package p000;

import com.google.android.exoplayer2.C0643C;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.PositionHolder;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.util.MimeTypes;

/* loaded from: classes.dex */
public final class b10 implements Extractor {

    /* renamed from: a */
    public final Format f7848a;

    public b10(Format format) {
        this.f7848a = format;
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public final void init(ExtractorOutput extractorOutput) {
        TrackOutput track = extractorOutput.track(0, 3);
        extractorOutput.seekMap(new SeekMap.Unseekable(C0643C.TIME_UNSET));
        extractorOutput.endTracks();
        Format format = this.f7848a;
        track.format(format.buildUpon().setSampleMimeType(MimeTypes.TEXT_UNKNOWN).setCodecs(format.sampleMimeType).build());
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public final int read(ExtractorInput extractorInput, PositionHolder positionHolder) {
        if (extractorInput.skip(Integer.MAX_VALUE) == -1) {
            return -1;
        }
        return 0;
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public final boolean sniff(ExtractorInput extractorInput) {
        return true;
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public final void release() {
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public final void seek(long j, long j2) {
    }
}
