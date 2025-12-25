package p000;

import com.google.android.exoplayer2.FormatHolder;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.source.MediaLoadData;
import com.google.android.exoplayer2.source.MediaSourceEventListener;
import com.google.android.exoplayer2.source.SampleStream;
import com.google.android.exoplayer2.source.ads.ServerSideAdInsertionMediaSource;
import com.google.android.exoplayer2.source.ads.ServerSideAdInsertionUtil;
import com.google.android.exoplayer2.util.Util;

/* loaded from: classes.dex */
public final class yg2 implements SampleStream {

    /* renamed from: a */
    public final xg2 f28947a;

    /* renamed from: b */
    public final int f28948b;

    public yg2(xg2 xg2Var, int i) {
        this.f28947a = xg2Var;
        this.f28948b = i;
    }

    @Override // com.google.android.exoplayer2.source.SampleStream
    public final boolean isReady() {
        return ((SampleStream) Util.castNonNull(this.f28947a.f28550a.f200j[this.f28948b])).isReady();
    }

    @Override // com.google.android.exoplayer2.source.SampleStream
    public final void maybeThrowError() {
        ((SampleStream) Util.castNonNull(this.f28947a.f28550a.f200j[this.f28948b])).maybeThrowError();
    }

    @Override // com.google.android.exoplayer2.source.SampleStream
    public final int readData(FormatHolder formatHolder, DecoderInputBuffer decoderInputBuffer, int i) {
        MediaLoadData mediaLoadData;
        MediaLoadData mediaLoadData2;
        xg2 xg2Var = this.f28947a;
        ah2 ah2Var = xg2Var.f28550a;
        SampleStream[] sampleStreamArr = ah2Var.f200j;
        int i2 = this.f28948b;
        int readData = ((SampleStream) Util.castNonNull(sampleStreamArr[i2])).readData(formatHolder, decoderInputBuffer, i | 5);
        long m89b = ah2Var.m89b(xg2Var, decoderInputBuffer.timeUs);
        MediaSourceEventListener.EventDispatcher eventDispatcher = xg2Var.f28552c;
        if ((readData == -4 && m89b == Long.MIN_VALUE) || (readData == -3 && ah2Var.m88a(xg2Var) == Long.MIN_VALUE && !decoderInputBuffer.waitingForKeys)) {
            boolean[] zArr = xg2Var.f28556g;
            if (!zArr[i2] && (mediaLoadData2 = ah2Var.f201k[i2]) != null) {
                zArr[i2] = true;
                eventDispatcher.downstreamFormatChanged(ServerSideAdInsertionMediaSource.m2759b(xg2Var, mediaLoadData2, ah2Var.f195e));
            }
            decoderInputBuffer.clear();
            decoderInputBuffer.addFlag(4);
            return -4;
        }
        if (readData == -4) {
            boolean[] zArr2 = xg2Var.f28556g;
            if (!zArr2[i2] && (mediaLoadData = ah2Var.f201k[i2]) != null) {
                zArr2[i2] = true;
                eventDispatcher.downstreamFormatChanged(ServerSideAdInsertionMediaSource.m2759b(xg2Var, mediaLoadData, ah2Var.f195e));
            }
            ((SampleStream) Util.castNonNull(ah2Var.f200j[i2])).readData(formatHolder, decoderInputBuffer, i);
            decoderInputBuffer.timeUs = m89b;
            return readData;
        }
        return readData;
    }

    @Override // com.google.android.exoplayer2.source.SampleStream
    public final int skipData(long j) {
        xg2 xg2Var = this.f28947a;
        ah2 ah2Var = xg2Var.f28550a;
        ah2Var.getClass();
        return ((SampleStream) Util.castNonNull(ah2Var.f200j[this.f28948b])).skipData(ServerSideAdInsertionUtil.getStreamPositionUs(j, xg2Var.f28551b, ah2Var.f195e));
    }
}
