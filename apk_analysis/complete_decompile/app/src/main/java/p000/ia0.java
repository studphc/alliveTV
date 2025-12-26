package p000;

import java.io.IOException;
import java.net.ProtocolException;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.connection.Exchange;
import okio.Buffer;
import okio.ForwardingSink;
import okio.Sink;

/* loaded from: classes2.dex */
public final class ia0 extends ForwardingSink {

    /* renamed from: b */
    public final long f18346b;

    /* renamed from: c */
    public boolean f18347c;

    /* renamed from: d */
    public long f18348d;

    /* renamed from: e */
    public boolean f18349e;

    /* renamed from: f */
    public final /* synthetic */ Exchange f18350f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ia0(Exchange exchange, Sink delegate, long j) {
        super(delegate);
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        this.f18350f = exchange;
        this.f18346b = j;
    }

    /* renamed from: a */
    public final IOException m5204a(IOException iOException) {
        if (this.f18347c) {
            return iOException;
        }
        this.f18347c = true;
        return this.f18350f.bodyComplete(this.f18348d, false, true, iOException);
    }

    @Override // okio.ForwardingSink, okio.Sink, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        if (this.f18349e) {
            return;
        }
        this.f18349e = true;
        long j = this.f18346b;
        if (j != -1 && this.f18348d != j) {
            throw new ProtocolException("unexpected end of stream");
        }
        try {
            super.close();
            m5204a(null);
        } catch (IOException e) {
            throw m5204a(e);
        }
    }

    @Override // okio.ForwardingSink, okio.Sink, java.io.Flushable
    public final void flush() {
        try {
            super.flush();
        } catch (IOException e) {
            throw m5204a(e);
        }
    }

    @Override // okio.ForwardingSink, okio.Sink
    public final void write(Buffer source, long j) {
        Intrinsics.checkNotNullParameter(source, "source");
        if (!this.f18349e) {
            long j2 = this.f18346b;
            if (j2 != -1 && this.f18348d + j > j2) {
                throw new ProtocolException("expected " + j2 + " bytes but received " + (this.f18348d + j));
            }
            try {
                super.write(source, j);
                this.f18348d += j;
                return;
            } catch (IOException e) {
                throw m5204a(e);
            }
        }
        throw new IllegalStateException("closed");
    }
}
