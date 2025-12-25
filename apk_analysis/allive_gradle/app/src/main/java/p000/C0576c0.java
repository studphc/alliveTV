package p000;

import com.google.common.base.Supplier;
import com.google.common.util.concurrent.AbstractExecutionThreadService;

/* renamed from: c0 */
/* loaded from: classes2.dex */
public final class C0576c0 implements Supplier {

    /* renamed from: a */
    public final /* synthetic */ C1105d0 f8212a;

    public C0576c0(C1105d0 c1105d0) {
        this.f8212a = c1105d0;
    }

    @Override // com.google.common.base.Supplier
    public final Object get() {
        return ((AbstractExecutionThreadService) this.f8212a.f16190q).serviceName();
    }
}
