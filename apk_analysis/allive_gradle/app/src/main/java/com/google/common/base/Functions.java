package com.google.common.base;

import com.google.common.annotations.GwtCompatible;
import java.util.Map;
import p000.fv0;
import p000.jv0;
import p000.kv0;
import p000.lv0;
import p000.ov0;
import p000.sv0;
import p000.tv0;
import p000.uv0;

@GwtCompatible
/* loaded from: classes.dex */
public final class Functions {
    public static <A, B, C> Function<A, C> compose(Function<B, C> function, Function<A, ? extends B> function2) {
        return new kv0(function, function2);
    }

    public static <E> Function<Object, E> constant(E e) {
        return new fv0(e);
    }

    public static <K, V> Function<K, V> forMap(Map<K, V> map) {
        return new lv0(map);
    }

    public static <T> Function<T, Boolean> forPredicate(Predicate<T> predicate) {
        return new sv0(predicate);
    }

    public static <F, T> Function<F, T> forSupplier(Supplier<T> supplier) {
        return new tv0(supplier);
    }

    public static <E> Function<E, E> identity() {
        return ov0.f24920a;
    }

    public static Function<Object, String> toStringFunction() {
        return uv0.f27465a;
    }

    public static <K, V> Function<K, V> forMap(Map<K, ? extends V> map, V v) {
        return new jv0(map, v);
    }
}
