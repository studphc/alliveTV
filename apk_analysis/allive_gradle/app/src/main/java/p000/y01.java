package p000;

import java.io.IOException;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.http1.Http1ExchangeCodec;
import okio.Buffer;
import okio.BufferedSource;
import okio.ForwardingTimeout;
import okio.Source;
import okio.Timeout;

/* loaded from: classes2.dex */
public abstract class y01 implements Source {

    /* renamed from: a */
    public final ForwardingTimeout f28780a;

    /* renamed from: b */
    public boolean f28781b;

    /* renamed from: c */
    public final /* synthetic */ Http1ExchangeCodec f28782c;

    public y01(Http1ExchangeCodec http1ExchangeCodec) {
        BufferedSource bufferedSource;
        this.f28782c = http1ExchangeCodec;
        bufferedSource = http1ExchangeCodec.f24408c;
        this.f28780a = new ForwardingTimeout(bufferedSource.getF24750a());
    }

    /* renamed from: a */
    public final void m8207a() {
        int i;
        int i2;
        int i3;
        Http1ExchangeCodec http1ExchangeCodec = this.f28782c;
        i = http1ExchangeCodec.f24410e;
        if (i != 6) {
            i2 = http1ExchangeCodec.f24410e;
            if (i2 == 5) {
                Http1ExchangeCodec.access$detachTimeout(http1ExchangeCodec, this.f28780a);
                http1ExchangeCodec.f24410e = 6;
            } else {
                StringBuilder sb = new StringBuilder("state: ");
                i3 = http1ExchangeCodec.f24410e;
                sb.append(i3);
                throw new IllegalStateException(sb.toString());
            }
        }
    }

    @Override // okio.Source
    public long read(Buffer sink, long j) {
        BufferedSource bufferedSource;
        Http1ExchangeCodec http1ExchangeCodec = this.f28782c;
        Intrinsics.checkNotNullParameter(sink, "sink");
        try {
            bufferedSource = http1ExchangeCodec.f24408c;
            return bufferedSource.read(sink, j);
        } catch (IOException e) {
            http1ExchangeCodec.getCarrier().noNewExchanges();
            m8207a();
            throw e;
        }
    }

    @Override // okio.Source
    /* renamed from: timeout */
    public final Timeout getF24750a() {
        return this.f28780a;
    }
}
