package io.reactivex.rxjava3.internal.operators.maybe;

import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.operators.ScalarSupplier;
import p000.g50;

/* loaded from: classes2.dex */
public final class MaybeJust<T> extends Maybe<T> implements ScalarSupplier<T> {

    /* renamed from: a */
    public final Object f19181a;

    public MaybeJust(T t) {
        this.f19181a = t;
    }

    @Override // io.reactivex.rxjava3.operators.ScalarSupplier, io.reactivex.rxjava3.functions.Supplier
    public T get() {
        return (T) this.f19181a;
    }

    @Override // io.reactivex.rxjava3.core.Maybe
    public void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        maybeObserver.onSubscribe(g50.m4919a());
        maybeObserver.onSuccess((Object) this.f19181a);
    }
}
