package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import p000.AbstractC1607o2;
import p000.iv1;

/* loaded from: classes2.dex */
public final class ObservableSwitchIfEmpty<T> extends AbstractC1607o2 {

    /* renamed from: a */
    public final ObservableSource f19569a;

    public ObservableSwitchIfEmpty(ObservableSource<T> observableSource, ObservableSource<? extends T> observableSource2) {
        super(observableSource);
        this.f19569a = observableSource2;
    }

    @Override // io.reactivex.rxjava3.core.Observable
    public void subscribeActual(Observer<? super T> observer) {
        iv1 iv1Var = new iv1(this.f19569a, observer);
        observer.onSubscribe(iv1Var.f20277c);
        this.source.subscribe(iv1Var);
    }
}
