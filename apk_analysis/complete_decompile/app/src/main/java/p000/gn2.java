package p000;

import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.ForwardingExtractorInput;
import com.google.android.exoplayer2.util.Assertions;

/* loaded from: classes.dex */
public final class gn2 extends ForwardingExtractorInput {

    /* renamed from: b */
    public final long f17776b;

    public gn2(ExtractorInput extractorInput, long j) {
        super(extractorInput);
        boolean z;
        if (extractorInput.getPosition() >= j) {
            z = true;
        } else {
            z = false;
        }
        Assertions.checkArgument(z);
        this.f17776b = j;
    }

    @Override // com.google.android.exoplayer2.extractor.ForwardingExtractorInput, com.google.android.exoplayer2.extractor.ExtractorInput
    public final long getLength() {
        return super.getLength() - this.f17776b;
    }

    @Override // com.google.android.exoplayer2.extractor.ForwardingExtractorInput, com.google.android.exoplayer2.extractor.ExtractorInput
    public final long getPeekPosition() {
        return super.getPeekPosition() - this.f17776b;
    }

    @Override // com.google.android.exoplayer2.extractor.ForwardingExtractorInput, com.google.android.exoplayer2.extractor.ExtractorInput
    public final long getPosition() {
        return super.getPosition() - this.f17776b;
    }

    @Override // com.google.android.exoplayer2.extractor.ForwardingExtractorInput, com.google.android.exoplayer2.extractor.ExtractorInput
    public final void setRetryPosition(long j, Throwable th) {
        super.setRetryPosition(j + this.f17776b, th);
    }
}
