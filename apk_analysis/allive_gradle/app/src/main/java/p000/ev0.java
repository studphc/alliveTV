package p000;

import io.reactivex.rxjava3.functions.Supplier;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public final class ev0 implements Supplier {

    /* renamed from: a */
    public final int f16989a;

    public ev0(int i) {
        this.f16989a = i;
    }

    @Override // io.reactivex.rxjava3.functions.Supplier
    public final Object get() {
        return new ArrayList(this.f16989a);
    }
}
