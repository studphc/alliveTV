package p000;

import java.net.ProtocolException;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal._UtilJvmKt;
import okhttp3.internal.http1.Http1ExchangeCodec;
import okio.Buffer;

/* loaded from: classes2.dex */
public final class b11 extends y01 {

    /* renamed from: d */
    public long f7849d;

    /* renamed from: e */
    public final /* synthetic */ Http1ExchangeCodec f7850e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b11(Http1ExchangeCodec http1ExchangeCodec, long j) {
        super(http1ExchangeCodec);
        this.f7850e = http1ExchangeCodec;
        this.f7849d = j;
        if (j == 0) {
            m8207a();
        }
    }

    @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        if (this.f28781b) {
            return;
        }
        if (this.f7849d != 0 && !_UtilJvmKt.discard(this, 100, TimeUnit.MILLISECONDS)) {
            this.f7850e.getCarrier().noNewExchanges();
            m8207a();
        }
        this.f28781b = true;
    }

    @Override // p000.y01, okio.Source
    public final long read(Buffer sink, long j) {
        Intrinsics.checkNotNullParameter(sink, "sink");
        if (j >= 0) {
            if (!this.f28781b) {
                long j2 = this.f7849d;
                if (j2 == 0) {
                    return -1L;
                }
                long read = super.read(sink, Math.min(j2, j));
                if (read != -1) {
                    long j3 = this.f7849d - read;
                    this.f7849d = j3;
                    if (j3 == 0) {
                        m8207a();
                    }
                    return read;
                }
                this.f7850e.getCarrier().noNewExchanges();
                ProtocolException protocolException = new ProtocolException("unexpected end of stream");
                m8207a();
                throw protocolException;
            }
            throw new IllegalStateException("closed");
        }
        throw new IllegalArgumentException(ye0.m8294n(j, "byteCount < 0: ").toString());
    }
}
