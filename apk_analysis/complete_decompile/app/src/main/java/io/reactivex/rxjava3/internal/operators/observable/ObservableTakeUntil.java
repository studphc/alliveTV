package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import p000.AbstractC1607o2;
import p000.kz1;

/* loaded from: classes2.dex */
public final class ObservableTakeUntil<T, U> extends AbstractC1607o2 {

    /* renamed from: a */
    public final ObservableSource f19581a;

    public ObservableTakeUntil(ObservableSource<T> observableSource, ObservableSource<? extends U> observableSource2) {
        super(observableSource);
        this.f19581a = observableSource2;
    }

    @Override // io.reactivex.rxjava3.core.Observable
    public void subscribeActual(Observer<? super T> observer) {
        kz1 kz1Var = new kz1(observer);
        observer.onSubscribe(kz1Var);
        this.f19581a.subscribe(kz1Var.f22256c);
        this.source.subscribe(kz1Var);
    }
}
