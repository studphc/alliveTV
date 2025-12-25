package io.reactivex.rxjava3.internal.operators.single;

import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.core.SingleSource;
import io.reactivex.rxjava3.functions.Function;
import p000.cj2;

/* loaded from: classes2.dex */
public final class SingleFlatMap<T, R> extends Single<R> {

    /* renamed from: a */
    public final SingleSource f19761a;

    /* renamed from: b */
    public final Function f19762b;

    public SingleFlatMap(SingleSource<? extends T> singleSource, Function<? super T, ? extends SingleSource<? extends R>> function) {
        this.f19762b = function;
        this.f19761a = singleSource;
    }

    @Override // io.reactivex.rxjava3.core.Single
    public void subscribeActual(SingleObserver<? super R> singleObserver) {
        this.f19761a.subscribe(new cj2(singleObserver, this.f19762b));
    }
}
