package io.reactivex.rxjava3.internal.operators.mixed;

import io.reactivex.rxjava3.core.MaybeSource;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.functions.Function;
import p000.ui1;

/* loaded from: classes2.dex */
public final class MaybeFlatMapObservable<T, R> extends Observable<R> {

    /* renamed from: a */
    public final MaybeSource f19289a;

    /* renamed from: b */
    public final Function f19290b;

    public MaybeFlatMapObservable(MaybeSource<T> maybeSource, Function<? super T, ? extends ObservableSource<? extends R>> function) {
        this.f19289a = maybeSource;
        this.f19290b = function;
    }

    @Override // io.reactivex.rxjava3.core.Observable
    public void subscribeActual(Observer<? super R> observer) {
        ui1 ui1Var = new ui1(observer, this.f19290b);
        observer.onSubscribe(ui1Var);
        this.f19289a.subscribe(ui1Var);
    }
}
