package p000;

import com.google.android.exoplayer2.source.chunk.BaseMediaChunkIterator;
import com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifest;
import com.google.android.exoplayer2.upstream.DataSpec;

/* loaded from: classes.dex */
public final class i10 extends BaseMediaChunkIterator {

    /* renamed from: d */
    public final SsManifest.StreamElement f18248d;

    /* renamed from: e */
    public final int f18249e;

    public i10(SsManifest.StreamElement streamElement, int i, int i2) {
        super(i2, streamElement.chunkCount - 1);
        this.f18248d = streamElement;
        this.f18249e = i;
    }

    @Override // com.google.android.exoplayer2.source.chunk.MediaChunkIterator
    public final long getChunkEndTimeUs() {
        return this.f18248d.getChunkDurationUs((int) getCurrentIndex()) + getChunkStartTimeUs();
    }

    @Override // com.google.android.exoplayer2.source.chunk.MediaChunkIterator
    public final long getChunkStartTimeUs() {
        checkInBounds();
        return this.f18248d.getStartTimeUs((int) getCurrentIndex());
    }

    @Override // com.google.android.exoplayer2.source.chunk.MediaChunkIterator
    public final DataSpec getDataSpec() {
        checkInBounds();
        return new DataSpec(this.f18248d.buildRequestUri(this.f18249e, (int) getCurrentIndex()));
    }
}
