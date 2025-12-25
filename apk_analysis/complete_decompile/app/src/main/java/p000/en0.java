package p000;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.functions.Supplier;

/* loaded from: classes2.dex */
public final class en0 implements Supplier {

    /* renamed from: a */
    public final /* synthetic */ int f16914a;

    /* renamed from: b */
    public final Object f16915b;

    public /* synthetic */ en0(int i, Object obj) {
        this.f16914a = i;
        this.f16915b = obj;
    }

    @Override // io.reactivex.rxjava3.functions.Supplier
    public final Object get() {
        switch (this.f16914a) {
            case 0:
                return ((Flowable) this.f16915b).replay();
            default:
                return ((Observable) this.f16915b).replay();
        }
    }
}
