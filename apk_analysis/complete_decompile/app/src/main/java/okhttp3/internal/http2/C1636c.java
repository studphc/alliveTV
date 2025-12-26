package okhttp3.internal.http2;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* renamed from: okhttp3.internal.http2.c */
/* loaded from: classes2.dex */
public final class C1636c extends Lambda implements Function0 {

    /* renamed from: b */
    public final /* synthetic */ Http2Connection f24530b;

    /* renamed from: c */
    public final /* synthetic */ int f24531c;

    /* renamed from: d */
    public final /* synthetic */ int f24532d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1636c(Http2Connection http2Connection, int i, int i2) {
        super(0);
        this.f24530b = http2Connection;
        this.f24531c = i;
        this.f24532d = i2;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        this.f24530b.writePing(true, this.f24531c, this.f24532d);
        return Unit.INSTANCE;
    }
}
