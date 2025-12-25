package p000;

import io.reactivex.rxjava3.functions.Supplier;

/* loaded from: classes2.dex */
public final class kp0 implements Supplier {

    /* renamed from: a */
    public final int f22133a;

    /* renamed from: b */
    public final boolean f22134b;

    public kp0(int i, boolean z) {
        this.f22133a = i;
        this.f22134b = z;
    }

    @Override // io.reactivex.rxjava3.functions.Supplier
    public final Object get() {
        return new pp0(this.f22133a, this.f22134b);
    }
}
