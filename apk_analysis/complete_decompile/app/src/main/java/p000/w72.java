package p000;

import com.google.android.exoplayer2.FormatHolder;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.source.C0707m;
import com.google.android.exoplayer2.source.SampleQueue;
import com.google.android.exoplayer2.source.SampleStream;

/* loaded from: classes.dex */
public final class w72 implements SampleStream {

    /* renamed from: a */
    public final int f28088a;

    /* renamed from: b */
    public final /* synthetic */ C0707m f28089b;

    public w72(C0707m c0707m, int i) {
        this.f28089b = c0707m;
        this.f28088a = i;
    }

    @Override // com.google.android.exoplayer2.source.SampleStream
    public final boolean isReady() {
        C0707m c0707m = this.f28089b;
        if (!c0707m.m2824j() && c0707m.f11578s[this.f28088a].isReady(c0707m.f11558K)) {
            return true;
        }
        return false;
    }

    @Override // com.google.android.exoplayer2.source.SampleStream
    public final void maybeThrowError() {
        C0707m c0707m = this.f28089b;
        c0707m.f11578s[this.f28088a].maybeThrowError();
        c0707m.f11570k.maybeThrowError(c0707m.f11563d.getMinimumLoadableRetryCount(c0707m.f11549B));
    }

    @Override // com.google.android.exoplayer2.source.SampleStream
    public final int readData(FormatHolder formatHolder, DecoderInputBuffer decoderInputBuffer, int i) {
        C0707m c0707m = this.f28089b;
        if (c0707m.m2824j()) {
            return -3;
        }
        int i2 = this.f28088a;
        c0707m.m2820f(i2);
        int read = c0707m.f11578s[i2].read(formatHolder, decoderInputBuffer, i, c0707m.f11558K);
        if (read == -3) {
            c0707m.m2821g(i2);
        }
        return read;
    }

    @Override // com.google.android.exoplayer2.source.SampleStream
    public final int skipData(long j) {
        C0707m c0707m = this.f28089b;
        if (c0707m.m2824j()) {
            return 0;
        }
        int i = this.f28088a;
        c0707m.m2820f(i);
        SampleQueue sampleQueue = c0707m.f11578s[i];
        int skipCount = sampleQueue.getSkipCount(j, c0707m.f11558K);
        sampleQueue.skip(skipCount);
        if (skipCount == 0) {
            c0707m.m2821g(i);
            return skipCount;
        }
        return skipCount;
    }
}
