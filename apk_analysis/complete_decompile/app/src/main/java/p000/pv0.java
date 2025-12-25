package p000;

import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.functions.Supplier;
import java.util.concurrent.Callable;

/* loaded from: classes2.dex */
public final class pv0 implements Callable, Supplier, Function {

    /* renamed from: a */
    public final Object f25311a;

    public pv0(Object obj) {
        this.f25311a = obj;
    }

    @Override // io.reactivex.rxjava3.functions.Function
    public final Object apply(Object obj) {
        return this.f25311a;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        return this.f25311a;
    }

    @Override // io.reactivex.rxjava3.functions.Supplier
    public final Object get() {
        return this.f25311a;
    }
}
