package io.reactivex.rxjava3.internal.operators.mixed;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.core.SingleSource;
import io.reactivex.rxjava3.functions.Function;
import p000.jj2;

/* loaded from: classes2.dex */
public final class SingleFlatMapObservable<T, R> extends Observable<R> {

    /* renamed from: a */
    public final SingleSource f19314a;

    /* renamed from: b */
    public final Function f19315b;

    public SingleFlatMapObservable(SingleSource<T> singleSource, Function<? super T, ? extends ObservableSource<? extends R>> function) {
        this.f19314a = singleSource;
        this.f19315b = function;
    }

    @Override // io.reactivex.rxjava3.core.Observable
    public void subscribeActual(Observer<? super R> observer) {
        jj2 jj2Var = new jj2(observer, this.f19315b);
        observer.onSubscribe(jj2Var);
        this.f19314a.subscribe(jj2Var);
    }
}
