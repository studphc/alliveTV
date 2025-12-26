package p000;

import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal._UtilCommonKt;
import okhttp3.internal.http1.Http1ExchangeCodec;
import okio.Buffer;
import okio.BufferedSink;
import okio.ForwardingTimeout;
import okio.Sink;
import okio.Timeout;

/* loaded from: classes2.dex */
public final class c11 implements Sink {

    /* renamed from: a */
    public final ForwardingTimeout f8226a;

    /* renamed from: b */
    public boolean f8227b;

    /* renamed from: c */
    public final /* synthetic */ Http1ExchangeCodec f8228c;

    public c11(Http1ExchangeCodec http1ExchangeCodec) {
        BufferedSink bufferedSink;
        this.f8228c = http1ExchangeCodec;
        bufferedSink = http1ExchangeCodec.f24409d;
        this.f8226a = new ForwardingTimeout(bufferedSink.getF24748a());
    }

    @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        if (this.f8227b) {
            return;
        }
        this.f8227b = true;
        Http1ExchangeCodec http1ExchangeCodec = this.f8228c;
        Http1ExchangeCodec.access$detachTimeout(http1ExchangeCodec, this.f8226a);
        http1ExchangeCodec.f24410e = 3;
    }

    @Override // okio.Sink, java.io.Flushable
    public final void flush() {
        BufferedSink bufferedSink;
        if (!this.f8227b) {
            bufferedSink = this.f8228c.f24409d;
            bufferedSink.flush();
        }
    }

    @Override // okio.Sink
    /* renamed from: timeout */
    public final Timeout getF24748a() {
        return this.f8226a;
    }

    @Override // okio.Sink
    public final void write(Buffer source, long j) {
        BufferedSink bufferedSink;
        Intrinsics.checkNotNullParameter(source, "source");
        if (!this.f8227b) {
            _UtilCommonKt.checkOffsetAndCount(source.size(), 0L, j);
            bufferedSink = this.f8228c.f24409d;
            bufferedSink.write(source, j);
            return;
        }
        throw new IllegalStateException("closed");
    }
}
