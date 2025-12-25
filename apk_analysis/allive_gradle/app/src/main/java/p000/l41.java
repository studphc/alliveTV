package p000;

import java.io.IOException;
import java.io.InputStream;
import kotlin.jvm.internal.Intrinsics;
import okio.Buffer;
import okio.Okio;
import okio.Segment;
import okio.SegmentPool;
import okio.Source;
import okio.Timeout;

/* loaded from: classes2.dex */
public final class l41 implements Source {

    /* renamed from: a */
    public final InputStream f22323a;

    /* renamed from: b */
    public final Timeout f22324b;

    public l41(InputStream input, Timeout timeout) {
        Intrinsics.checkNotNullParameter(input, "input");
        Intrinsics.checkNotNullParameter(timeout, "timeout");
        this.f22323a = input;
        this.f22324b = timeout;
    }

    @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.f22323a.close();
    }

    @Override // okio.Source
    public final long read(Buffer sink, long j) {
        Intrinsics.checkNotNullParameter(sink, "sink");
        if (j == 0) {
            return 0L;
        }
        if (j >= 0) {
            try {
                this.f22324b.throwIfReached();
                Segment writableSegment$okio = sink.writableSegment$okio(1);
                int read = this.f22323a.read(writableSegment$okio.data, writableSegment$okio.limit, (int) Math.min(j, 8192 - writableSegment$okio.limit));
                if (read == -1) {
                    if (writableSegment$okio.pos == writableSegment$okio.limit) {
                        sink.head = writableSegment$okio.pop();
                        SegmentPool.recycle(writableSegment$okio);
                        return -1L;
                    }
                    return -1L;
                }
                writableSegment$okio.limit += read;
                long j2 = read;
                sink.setSize$okio(sink.size() + j2);
                return j2;
            } catch (AssertionError e) {
                if (Okio.isAndroidGetsocknameError(e)) {
                    throw new IOException(e);
                }
                throw e;
            }
        }
        throw new IllegalArgumentException(ye0.m8294n(j, "byteCount < 0: ").toString());
    }

    @Override // okio.Source
    /* renamed from: timeout */
    public final Timeout getF24243a() {
        return this.f22324b;
    }

    public final String toString() {
        return "source(" + this.f22323a + ')';
    }
}
