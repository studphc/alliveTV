package p000;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.functions.Supplier;

/* loaded from: classes2.dex */
public final class zm0 implements Supplier {

    /* renamed from: a */
    public final /* synthetic */ int f29436a;

    /* renamed from: b */
    public final int f29437b;

    /* renamed from: c */
    public final boolean f29438c;

    /* renamed from: d */
    public final Object f29439d;

    public /* synthetic */ zm0(Object obj, int i, boolean z, int i2) {
        this.f29436a = i2;
        this.f29439d = obj;
        this.f29437b = i;
        this.f29438c = z;
    }

    @Override // io.reactivex.rxjava3.functions.Supplier
    public final Object get() {
        switch (this.f29436a) {
            case 0:
                return ((Flowable) this.f29439d).replay(this.f29437b, this.f29438c);
            default:
                return ((Observable) this.f29439d).replay(this.f29437b, this.f29438c);
        }
    }
}
