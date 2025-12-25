package p000;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import okhttp3.internal.http2.Http2Connection;
import okhttp3.internal.ws.RealWebSocket;

/* loaded from: classes2.dex */
public final class e11 extends Lambda implements Function0 {

    /* renamed from: b */
    public final /* synthetic */ int f16643b;

    /* renamed from: c */
    public final /* synthetic */ long f16644c;

    /* renamed from: d */
    public final /* synthetic */ Object f16645d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ e11(Object obj, long j, int i) {
        super(0);
        this.f16643b = i;
        this.f16645d = obj;
        this.f16644c = j;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        boolean z;
        switch (this.f16643b) {
            case 0:
                Http2Connection http2Connection = (Http2Connection) this.f16645d;
                synchronized (http2Connection) {
                    if (Http2Connection.access$getIntervalPongsReceived$p(http2Connection) < Http2Connection.access$getIntervalPingsSent$p(http2Connection)) {
                        z = true;
                    } else {
                        Http2Connection.access$setIntervalPingsSent$p(http2Connection, Http2Connection.access$getIntervalPingsSent$p(http2Connection) + 1);
                        z = false;
                    }
                }
                if (z) {
                    Http2Connection.access$failConnection((Http2Connection) this.f16645d, null);
                    return -1L;
                }
                ((Http2Connection) this.f16645d).writePing(false, 1, 0);
                return Long.valueOf(this.f16644c);
            default:
                ((RealWebSocket) this.f16645d).writePingFrame$okhttp();
                return Long.valueOf(this.f16644c);
        }
    }
}
