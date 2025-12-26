package p000;

import com.google.android.exoplayer2.extractor.BinarySearchSeeker;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.FlacFrameReader;
import com.google.android.exoplayer2.extractor.FlacStreamMetadata;

/* loaded from: classes.dex */
public final class pe0 implements BinarySearchSeeker.TimestampSeeker {

    /* renamed from: a */
    public final FlacStreamMetadata f25132a;

    /* renamed from: b */
    public final int f25133b;

    /* renamed from: c */
    public final FlacFrameReader.SampleNumberHolder f25134c = new FlacFrameReader.SampleNumberHolder();

    public pe0(FlacStreamMetadata flacStreamMetadata, int i) {
        this.f25132a = flacStreamMetadata;
        this.f25133b = i;
    }

    /* renamed from: a */
    public final long m6913a(ExtractorInput extractorInput) {
        FlacFrameReader.SampleNumberHolder sampleNumberHolder;
        FlacStreamMetadata flacStreamMetadata;
        while (true) {
            long peekPosition = extractorInput.getPeekPosition();
            long length = extractorInput.getLength() - 6;
            sampleNumberHolder = this.f25134c;
            flacStreamMetadata = this.f25132a;
            if (peekPosition >= length || FlacFrameReader.checkFrameHeaderFromPeek(extractorInput, flacStreamMetadata, this.f25133b, sampleNumberHolder)) {
                break;
            }
            extractorInput.advancePeekPosition(1);
        }
        if (extractorInput.getPeekPosition() >= extractorInput.getLength() - 6) {
            extractorInput.advancePeekPosition((int) (extractorInput.getLength() - extractorInput.getPeekPosition()));
            return flacStreamMetadata.totalSamples;
        }
        return sampleNumberHolder.sampleNumber;
    }

    @Override // com.google.android.exoplayer2.extractor.BinarySearchSeeker.TimestampSeeker
    public final /* synthetic */ void onSeekFinished() {
        AbstractC1390kg.m5527a(this);
    }

    @Override // com.google.android.exoplayer2.extractor.BinarySearchSeeker.TimestampSeeker
    public final BinarySearchSeeker.TimestampSearchResult searchForTimestamp(ExtractorInput extractorInput, long j) {
        long position = extractorInput.getPosition();
        long m6913a = m6913a(extractorInput);
        long peekPosition = extractorInput.getPeekPosition();
        extractorInput.advancePeekPosition(Math.max(6, this.f25132a.minFrameSize));
        long m6913a2 = m6913a(extractorInput);
        long peekPosition2 = extractorInput.getPeekPosition();
        if (m6913a <= j && m6913a2 > j) {
            return BinarySearchSeeker.TimestampSearchResult.targetFoundResult(peekPosition);
        }
        if (m6913a2 <= j) {
            return BinarySearchSeeker.TimestampSearchResult.underestimatedResult(m6913a2, peekPosition2);
        }
        return BinarySearchSeeker.TimestampSearchResult.overestimatedResult(m6913a, position);
    }
}
