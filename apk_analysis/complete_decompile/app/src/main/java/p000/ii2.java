package p000;

import com.google.android.exoplayer2.FormatHolder;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.source.SampleStream;
import com.google.android.exoplayer2.source.SilenceMediaSource;
import com.google.android.exoplayer2.util.Util;

/* loaded from: classes.dex */
public final class ii2 implements SampleStream {

    /* renamed from: a */
    public final long f18424a;

    /* renamed from: b */
    public boolean f18425b;

    /* renamed from: c */
    public long f18426c;

    public ii2(long j) {
        String str = SilenceMediaSource.MEDIA_ID;
        this.f18424a = Util.getPcmFrameSize(2, 2) * ((j * 44100) / 1000000);
        m5246a(0L);
    }

    /* renamed from: a */
    public final void m5246a(long j) {
        String str = SilenceMediaSource.MEDIA_ID;
        this.f18426c = Util.constrainValue(Util.getPcmFrameSize(2, 2) * ((j * 44100) / 1000000), 0L, this.f18424a);
    }

    @Override // com.google.android.exoplayer2.source.SampleStream
    public final boolean isReady() {
        return true;
    }

    @Override // com.google.android.exoplayer2.source.SampleStream
    public final int readData(FormatHolder formatHolder, DecoderInputBuffer decoderInputBuffer, int i) {
        if (this.f18425b && (i & 2) == 0) {
            long j = this.f18426c;
            long j2 = this.f18424a - j;
            if (j2 == 0) {
                decoderInputBuffer.addFlag(4);
                return -4;
            }
            String str = SilenceMediaSource.MEDIA_ID;
            decoderInputBuffer.timeUs = ((j / Util.getPcmFrameSize(2, 2)) * 1000000) / 44100;
            decoderInputBuffer.addFlag(1);
            byte[] bArr = SilenceMediaSource.f11053l;
            int min = (int) Math.min(bArr.length, j2);
            if ((4 & i) == 0) {
                decoderInputBuffer.ensureSpaceForWrite(min);
                decoderInputBuffer.data.put(bArr, 0, min);
            }
            if ((i & 1) == 0) {
                this.f18426c += min;
            }
            return -4;
        }
        formatHolder.format = SilenceMediaSource.f11051j;
        this.f18425b = true;
        return -5;
    }

    @Override // com.google.android.exoplayer2.source.SampleStream
    public final int skipData(long j) {
        long j2 = this.f18426c;
        m5246a(j);
        return (int) ((this.f18426c - j2) / SilenceMediaSource.f11053l.length);
    }

    @Override // com.google.android.exoplayer2.source.SampleStream
    public final void maybeThrowError() {
    }
}
