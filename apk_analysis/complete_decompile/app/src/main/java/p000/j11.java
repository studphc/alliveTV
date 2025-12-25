package p000;

import java.io.IOException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import okhttp3.internal.http2.Http2Connection;

/* loaded from: classes2.dex */
public final class j11 extends Lambda implements Function0 {

    /* renamed from: b */
    public final /* synthetic */ Http2Connection f20340b;

    /* renamed from: c */
    public final /* synthetic */ int f20341c;

    /* renamed from: d */
    public final /* synthetic */ long f20342d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j11(Http2Connection http2Connection, int i, long j) {
        super(0);
        this.f20340b = http2Connection;
        this.f20341c = i;
        this.f20342d = j;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        Http2Connection http2Connection = this.f20340b;
        try {
            http2Connection.getWriter().windowUpdate(this.f20341c, this.f20342d);
        } catch (IOException e) {
            Http2Connection.access$failConnection(http2Connection, e);
        }
        return Unit.INSTANCE;
    }
}
