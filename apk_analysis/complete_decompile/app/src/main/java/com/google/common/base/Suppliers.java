package com.google.common.base;

import com.google.common.annotations.GwtCompatible;
import java.io.Serializable;
import java.util.concurrent.TimeUnit;
import p000.qq2;
import p000.rq2;
import p000.sq2;
import p000.tq2;
import p000.uq2;
import p000.vq2;
import p000.wq2;

@GwtCompatible
/* loaded from: classes.dex */
public final class Suppliers {
    public static <F, T> Supplier<T> compose(Function<? super F, T> function, Supplier<F> supplier) {
        return new tq2(function, supplier);
    }

    public static <T> Supplier<T> memoize(Supplier<T> supplier) {
        if (!(supplier instanceof sq2) && !(supplier instanceof rq2)) {
            if (supplier instanceof Serializable) {
                return new rq2(supplier);
            }
            sq2 sq2Var = (Supplier<T>) new Object();
            sq2Var.f26535a = (Supplier) Preconditions.checkNotNull(supplier);
            return sq2Var;
        }
        return supplier;
    }

    public static <T> Supplier<T> memoizeWithExpiration(Supplier<T> supplier, long j, TimeUnit timeUnit) {
        return new qq2(supplier, j, timeUnit);
    }

    public static <T> Supplier<T> ofInstance(T t) {
        return new vq2(t);
    }

    public static <T> Function<Supplier<T>, T> supplierFunction() {
        return uq2.f27411a;
    }

    public static <T> Supplier<T> synchronizedSupplier(Supplier<T> supplier) {
        return new wq2(supplier);
    }
}
