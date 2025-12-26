package p000;

import io.reactivex.rxjava3.functions.Function;

/* loaded from: classes2.dex */
public final class nv0 implements Function {
    public final String toString() {
        return "IdentityFunction";
    }

    @Override // io.reactivex.rxjava3.functions.Function
    public final Object apply(Object obj) {
        return obj;
    }
}
