package p000;

import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.http1.Http1ExchangeCodec;
import okio.Buffer;
import okio.BufferedSink;
import okio.ForwardingTimeout;
import okio.Sink;
import okio.Timeout;

/* loaded from: classes2.dex */
public final class z01 implements Sink {

    /* renamed from: a */
    public final ForwardingTimeout f29211a;

    /* renamed from: b */
    public boolean f29212b;

    /* renamed from: c */
    public final /* synthetic */ Http1ExchangeCodec f29213c;

    public z01(Http1ExchangeCodec http1ExchangeCodec) {
        BufferedSink bufferedSink;
        this.f29213c = http1ExchangeCodec;
        bufferedSink = http1ExchangeCodec.f24409d;
        this.f29211a = new ForwardingTimeout(bufferedSink.getF24748a());
    }

    @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
    public final synchronized void close() {
        BufferedSink bufferedSink;
        if (this.f29212b) {
            return;
        }
        this.f29212b = true;
        bufferedSink = this.f29213c.f24409d;
        bufferedSink.writeUtf8("0\r\n\r\n");
        Http1ExchangeCodec.access$detachTimeout(this.f29213c, this.f29211a);
        this.f29213c.f24410e = 3;
    }

    @Override // okio.Sink, java.io.Flushable
    public final synchronized void flush() {
        BufferedSink bufferedSink;
        if (!this.f29212b) {
            bufferedSink = this.f29213c.f24409d;
            bufferedSink.flush();
        }
    }

    @Override // okio.Sink
    /* renamed from: timeout */
    public final Timeout getF24748a() {
        return this.f29211a;
    }

    @Override // okio.Sink
    public final void write(Buffer source, long j) {
        BufferedSink bufferedSink;
        BufferedSink bufferedSink2;
        BufferedSink bufferedSink3;
        BufferedSink bufferedSink4;
        Intrinsics.checkNotNullParameter(source, "source");
        if (!this.f29212b) {
            if (j == 0) {
                return;
            }
            Http1ExchangeCodec http1ExchangeCodec = this.f29213c;
            bufferedSink = http1ExchangeCodec.f24409d;
            bufferedSink.writeHexadecimalUnsignedLong(j);
            bufferedSink2 = http1ExchangeCodec.f24409d;
            bufferedSink2.writeUtf8("\r\n");
            bufferedSink3 = http1ExchangeCodec.f24409d;
            bufferedSink3.write(source, j);
            bufferedSink4 = http1ExchangeCodec.f24409d;
            bufferedSink4.writeUtf8("\r\n");
            return;
        }
        throw new IllegalStateException("closed");
    }
}
