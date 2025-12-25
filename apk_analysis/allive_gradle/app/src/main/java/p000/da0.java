package p000;

import com.google.android.exoplayer2.C0643C;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.FormatHolder;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.metadata.emsg.EventMessageEncoder;
import com.google.android.exoplayer2.source.SampleStream;
import com.google.android.exoplayer2.source.dash.manifest.EventStream;
import com.google.android.exoplayer2.util.Util;

/* loaded from: classes.dex */
public final class da0 implements SampleStream {

    /* renamed from: a */
    public final Format f16304a;

    /* renamed from: c */
    public long[] f16306c;

    /* renamed from: d */
    public boolean f16307d;

    /* renamed from: e */
    public EventStream f16308e;

    /* renamed from: f */
    public boolean f16309f;

    /* renamed from: g */
    public int f16310g;

    /* renamed from: b */
    public final EventMessageEncoder f16305b = new EventMessageEncoder();

    /* renamed from: h */
    public long f16311h = C0643C.TIME_UNSET;

    public da0(EventStream eventStream, Format format, boolean z) {
        this.f16304a = format;
        this.f16308e = eventStream;
        this.f16306c = eventStream.presentationTimesUs;
        m4558a(eventStream, z);
    }

    /* renamed from: a */
    public final void m4558a(EventStream eventStream, boolean z) {
        long j;
        int i = this.f16310g;
        long j2 = C0643C.TIME_UNSET;
        if (i == 0) {
            j = -9223372036854775807L;
        } else {
            j = this.f16306c[i - 1];
        }
        this.f16307d = z;
        this.f16308e = eventStream;
        long[] jArr = eventStream.presentationTimesUs;
        this.f16306c = jArr;
        long j3 = this.f16311h;
        if (j3 != C0643C.TIME_UNSET) {
            int binarySearchCeil = Util.binarySearchCeil(jArr, j3, true, false);
            this.f16310g = binarySearchCeil;
            if (this.f16307d && binarySearchCeil == this.f16306c.length) {
                j2 = j3;
            }
            this.f16311h = j2;
            return;
        }
        if (j != C0643C.TIME_UNSET) {
            this.f16310g = Util.binarySearchCeil(jArr, j, false, false);
        }
    }

    @Override // com.google.android.exoplayer2.source.SampleStream
    public final boolean isReady() {
        return true;
    }

    @Override // com.google.android.exoplayer2.source.SampleStream
    public final int readData(FormatHolder formatHolder, DecoderInputBuffer decoderInputBuffer, int i) {
        boolean z;
        int i2 = this.f16310g;
        if (i2 == this.f16306c.length) {
            z = true;
        } else {
            z = false;
        }
        if (z && !this.f16307d) {
            decoderInputBuffer.setFlags(4);
            return -4;
        }
        if ((i & 2) == 0 && this.f16309f) {
            if (z) {
                return -3;
            }
            if ((i & 1) == 0) {
                this.f16310g = i2 + 1;
            }
            if ((i & 4) == 0) {
                byte[] encode = this.f16305b.encode(this.f16308e.events[i2]);
                decoderInputBuffer.ensureSpaceForWrite(encode.length);
                decoderInputBuffer.data.put(encode);
            }
            decoderInputBuffer.timeUs = this.f16306c[i2];
            decoderInputBuffer.setFlags(1);
            return -4;
        }
        formatHolder.format = this.f16304a;
        this.f16309f = true;
        return -5;
    }

    @Override // com.google.android.exoplayer2.source.SampleStream
    public final int skipData(long j) {
        int max = Math.max(this.f16310g, Util.binarySearchCeil(this.f16306c, j, true, false));
        int i = max - this.f16310g;
        this.f16310g = max;
        return i;
    }

    @Override // com.google.android.exoplayer2.source.SampleStream
    public final void maybeThrowError() {
    }
}
