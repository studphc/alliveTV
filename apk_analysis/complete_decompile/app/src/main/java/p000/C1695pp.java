package p000;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.FormatHolder;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.source.ClippingMediaPeriod;
import com.google.android.exoplayer2.source.SampleStream;
import com.google.android.exoplayer2.util.Assertions;

/* renamed from: pp */
/* loaded from: classes.dex */
public final class C1695pp implements SampleStream {

    /* renamed from: a */
    public final SampleStream f25243a;

    /* renamed from: b */
    public boolean f25244b;

    /* renamed from: c */
    public final /* synthetic */ ClippingMediaPeriod f25245c;

    public C1695pp(ClippingMediaPeriod clippingMediaPeriod, SampleStream sampleStream) {
        this.f25245c = clippingMediaPeriod;
        this.f25243a = sampleStream;
    }

    @Override // com.google.android.exoplayer2.source.SampleStream
    public final boolean isReady() {
        if (!this.f25245c.m2726a() && this.f25243a.isReady()) {
            return true;
        }
        return false;
    }

    @Override // com.google.android.exoplayer2.source.SampleStream
    public final void maybeThrowError() {
        this.f25243a.maybeThrowError();
    }

    @Override // com.google.android.exoplayer2.source.SampleStream
    public final int readData(FormatHolder formatHolder, DecoderInputBuffer decoderInputBuffer, int i) {
        ClippingMediaPeriod clippingMediaPeriod = this.f25245c;
        if (clippingMediaPeriod.m2726a()) {
            return -3;
        }
        if (this.f25244b) {
            decoderInputBuffer.setFlags(4);
            return -4;
        }
        int readData = this.f25243a.readData(formatHolder, decoderInputBuffer, i);
        if (readData == -5) {
            Format format = (Format) Assertions.checkNotNull(formatHolder.format);
            int i2 = format.encoderDelay;
            if (i2 != 0 || format.encoderPadding != 0) {
                int i3 = 0;
                if (clippingMediaPeriod.f10912d != 0) {
                    i2 = 0;
                }
                if (clippingMediaPeriod.f10913e == Long.MIN_VALUE) {
                    i3 = format.encoderPadding;
                }
                formatHolder.format = format.buildUpon().setEncoderDelay(i2).setEncoderPadding(i3).build();
            }
            return -5;
        }
        long j = clippingMediaPeriod.f10913e;
        if (j != Long.MIN_VALUE && ((readData == -4 && decoderInputBuffer.timeUs >= j) || (readData == -3 && clippingMediaPeriod.getBufferedPositionUs() == Long.MIN_VALUE && !decoderInputBuffer.waitingForKeys))) {
            decoderInputBuffer.clear();
            decoderInputBuffer.setFlags(4);
            this.f25244b = true;
            return -4;
        }
        return readData;
    }

    @Override // com.google.android.exoplayer2.source.SampleStream
    public final int skipData(long j) {
        if (this.f25245c.m2726a()) {
            return -3;
        }
        return this.f25243a.skipData(j);
    }
}
