package io.reactivex.rxjava3.internal.operators.single;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.core.SingleSource;
import io.reactivex.rxjava3.functions.Function;
import p000.gj2;

/* loaded from: classes2.dex */
public final class SingleFlatMapIterableObservable<T, R> extends Observable<R> {

    /* renamed from: a */
    public final SingleSource f19770a;

    /* renamed from: b */
    public final Function f19771b;

    public SingleFlatMapIterableObservable(SingleSource<T> singleSource, Function<? super T, ? extends Iterable<? extends R>> function) {
        this.f19770a = singleSource;
        this.f19771b = function;
    }

    @Override // io.reactivex.rxjava3.core.Observable
    public void subscribeActual(Observer<? super R> observer) {
        this.f19770a.subscribe(new gj2(observer, this.f19771b));
    }
}
