package okhttp3.internal.http2;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

/* renamed from: okhttp3.internal.http2.a */
/* loaded from: classes2.dex */
public final class C1634a extends Lambda implements Function0 {

    /* renamed from: b */
    public final /* synthetic */ Http2Connection f24526b;

    /* renamed from: c */
    public final /* synthetic */ Ref.ObjectRef f24527c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1634a(Http2Connection http2Connection, Ref.ObjectRef objectRef) {
        super(0);
        this.f24526b = http2Connection;
        this.f24527c = objectRef;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        Http2Connection http2Connection = this.f24526b;
        http2Connection.getCom.google.android.gms.common.internal.ServiceSpecificExtraArgs.CastExtraArgs.LISTENER java.lang.String().onSettings(http2Connection, (Settings) this.f24527c.element);
        return Unit.INSTANCE;
    }
}
