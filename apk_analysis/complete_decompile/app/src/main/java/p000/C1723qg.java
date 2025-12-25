package p000;

import kotlin.jvm.internal.Intrinsics;
import okio.Buffer;
import okio.Sink;
import okio.Timeout;

/* renamed from: qg */
/* loaded from: classes2.dex */
public final class C1723qg implements Sink {
    @Override // okio.Sink
    /* renamed from: timeout */
    public final Timeout getF24673a() {
        return Timeout.NONE;
    }

    @Override // okio.Sink
    public final void write(Buffer source, long j) {
        Intrinsics.checkNotNullParameter(source, "source");
        source.skip(j);
    }

    @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
    }

    @Override // okio.Sink, java.io.Flushable
    public final void flush() {
    }
}
