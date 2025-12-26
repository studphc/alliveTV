package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.FormatHolder;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.MimeTypes;

/* renamed from: com.google.android.exoplayer2.source.o */
/* loaded from: classes.dex */
public final class C0709o implements SampleStream {

    /* renamed from: a */
    public int f11615a;

    /* renamed from: b */
    public boolean f11616b;

    /* renamed from: c */
    public final /* synthetic */ C0710p f11617c;

    public C0709o(C0710p c0710p) {
        this.f11617c = c0710p;
    }

    /* renamed from: a */
    public final void m2827a() {
        if (!this.f11616b) {
            C0710p c0710p = this.f11617c;
            c0710p.f11622e.downstreamFormatChanged(MimeTypes.getTrackType(c0710p.f11627j.sampleMimeType), c0710p.f11627j, 0, null, 0L);
            this.f11616b = true;
        }
    }

    @Override // com.google.android.exoplayer2.source.SampleStream
    public final boolean isReady() {
        return this.f11617c.f11629l;
    }

    @Override // com.google.android.exoplayer2.source.SampleStream
    public final void maybeThrowError() {
        C0710p c0710p = this.f11617c;
        if (!c0710p.f11628k) {
            c0710p.f11626i.maybeThrowError();
        }
    }

    @Override // com.google.android.exoplayer2.source.SampleStream
    public final int readData(FormatHolder formatHolder, DecoderInputBuffer decoderInputBuffer, int i) {
        m2827a();
        C0710p c0710p = this.f11617c;
        boolean z = c0710p.f11629l;
        if (z && c0710p.f11630m == null) {
            this.f11615a = 2;
        }
        int i2 = this.f11615a;
        if (i2 == 2) {
            decoderInputBuffer.addFlag(4);
            return -4;
        }
        if ((i & 2) == 0 && i2 != 0) {
            if (!z) {
                return -3;
            }
            Assertions.checkNotNull(c0710p.f11630m);
            decoderInputBuffer.addFlag(1);
            decoderInputBuffer.timeUs = 0L;
            if ((i & 4) == 0) {
                decoderInputBuffer.ensureSpaceForWrite(c0710p.f11631n);
                decoderInputBuffer.data.put(c0710p.f11630m, 0, c0710p.f11631n);
            }
            if ((i & 1) == 0) {
                this.f11615a = 2;
            }
            return -4;
        }
        formatHolder.format = c0710p.f11627j;
        this.f11615a = 1;
        return -5;
    }

    @Override // com.google.android.exoplayer2.source.SampleStream
    public final int skipData(long j) {
        m2827a();
        if (j > 0 && this.f11615a != 2) {
            this.f11615a = 2;
            return 1;
        }
        return 0;
    }
}
