package p000;

import java.io.IOException;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import okhttp3.internal.http2.ErrorCode;
import okhttp3.internal.http2.Http2Connection;
import okhttp3.internal.http2.PushObserver;
import okio.Buffer;

/* loaded from: classes2.dex */
public final class f11 extends Lambda implements Function0 {

    /* renamed from: b */
    public final /* synthetic */ Http2Connection f17076b;

    /* renamed from: c */
    public final /* synthetic */ int f17077c;

    /* renamed from: d */
    public final /* synthetic */ Buffer f17078d;

    /* renamed from: e */
    public final /* synthetic */ int f17079e;

    /* renamed from: f */
    public final /* synthetic */ boolean f17080f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f11(Http2Connection http2Connection, int i, Buffer buffer, int i2, boolean z) {
        super(0);
        this.f17076b = http2Connection;
        this.f17077c = i;
        this.f17078d = buffer;
        this.f17079e = i2;
        this.f17080f = z;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        PushObserver pushObserver;
        Set set;
        Http2Connection http2Connection = this.f17076b;
        int i = this.f17077c;
        Buffer buffer = this.f17078d;
        int i2 = this.f17079e;
        boolean z = this.f17080f;
        try {
            pushObserver = http2Connection.f24445l;
            boolean onData = pushObserver.onData(i, buffer, i2, z);
            if (onData) {
                http2Connection.getWriter().rstStream(i, ErrorCode.CANCEL);
            }
            if (onData || z) {
                synchronized (http2Connection) {
                    set = http2Connection.f24433C;
                    set.remove(Integer.valueOf(i));
                }
            }
        } catch (IOException unused) {
        }
        return Unit.INSTANCE;
    }
}
