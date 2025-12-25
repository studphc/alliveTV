package p000;

import com.google.android.exoplayer2.FormatHolder;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.source.SampleStream;

/* loaded from: classes.dex */
public final class mn1 implements SampleStream {

    /* renamed from: a */
    public final SampleStream f23006a;

    /* renamed from: b */
    public final long f23007b;

    public mn1(SampleStream sampleStream, long j) {
        this.f23006a = sampleStream;
        this.f23007b = j;
    }

    @Override // com.google.android.exoplayer2.source.SampleStream
    public final boolean isReady() {
        return this.f23006a.isReady();
    }

    @Override // com.google.android.exoplayer2.source.SampleStream
    public final void maybeThrowError() {
        this.f23006a.maybeThrowError();
    }

    @Override // com.google.android.exoplayer2.source.SampleStream
    public final int readData(FormatHolder formatHolder, DecoderInputBuffer decoderInputBuffer, int i) {
        int readData = this.f23006a.readData(formatHolder, decoderInputBuffer, i);
        if (readData == -4) {
            decoderInputBuffer.timeUs = Math.max(0L, decoderInputBuffer.timeUs + this.f23007b);
        }
        return readData;
    }

    @Override // com.google.android.exoplayer2.source.SampleStream
    public final int skipData(long j) {
        return this.f23006a.skipData(j - this.f23007b);
    }
}
