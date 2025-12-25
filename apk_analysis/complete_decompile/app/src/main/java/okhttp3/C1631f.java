package okhttp3;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import okhttp3.internal.connection.Exchange;

/* renamed from: okhttp3.f */
/* loaded from: classes2.dex */
public final class C1631f extends Lambda implements Function0 {

    /* renamed from: b */
    public final /* synthetic */ Exchange f24140b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1631f(Exchange exchange) {
        super(0);
        this.f24140b = exchange;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        return this.f24140b.trailers();
    }
}
