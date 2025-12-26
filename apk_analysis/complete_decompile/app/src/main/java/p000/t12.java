package p000;

import java.io.OutputStream;
import kotlin.jvm.internal.Intrinsics;
import okio.Buffer;
import okio.Segment;
import okio.SegmentPool;
import okio.Sink;
import okio.Timeout;
import okio._UtilKt;

/* loaded from: classes2.dex */
public final class t12 implements Sink {

    /* renamed from: a */
    public final OutputStream f26658a;

    /* renamed from: b */
    public final Timeout f26659b;

    public t12(OutputStream out, Timeout timeout) {
        Intrinsics.checkNotNullParameter(out, "out");
        Intrinsics.checkNotNullParameter(timeout, "timeout");
        this.f26658a = out;
        this.f26659b = timeout;
    }

    @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.f26658a.close();
    }

    @Override // okio.Sink, java.io.Flushable
    public final void flush() {
        this.f26658a.flush();
    }

    @Override // okio.Sink
    /* renamed from: timeout */
    public final Timeout getF24748a() {
        return this.f26659b;
    }

    public final String toString() {
        return "sink(" + this.f26658a + ')';
    }

    @Override // okio.Sink
    public final void write(Buffer source, long j) {
        Intrinsics.checkNotNullParameter(source, "source");
        _UtilKt.checkOffsetAndCount(source.size(), 0L, j);
        while (j > 0) {
            this.f26659b.throwIfReached();
            Segment segment = source.head;
            Intrinsics.checkNotNull(segment);
            int min = (int) Math.min(j, segment.limit - segment.pos);
            this.f26658a.write(segment.data, segment.pos, min);
            segment.pos += min;
            long j2 = min;
            j -= j2;
            source.setSize$okio(source.size() - j2);
            if (segment.pos == segment.limit) {
                source.head = segment.pop();
                SegmentPool.recycle(segment);
            }
        }
    }
}
