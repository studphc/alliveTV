package io.reactivex.rxjava3.internal.operators.single;

import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.core.SingleSource;
import io.reactivex.rxjava3.functions.Function;
import p000.xi1;

/* loaded from: classes2.dex */
public final class SingleMap<T, R> extends Single<R> {

    /* renamed from: a */
    public final SingleSource f19787a;

    /* renamed from: b */
    public final Function f19788b;

    public SingleMap(SingleSource<? extends T> singleSource, Function<? super T, ? extends R> function) {
        this.f19787a = singleSource;
        this.f19788b = function;
    }

    @Override // io.reactivex.rxjava3.core.Single
    public void subscribeActual(SingleObserver<? super R> singleObserver) {
        this.f19787a.subscribe(new xi1(8, singleObserver, this.f19788b));
    }
}
