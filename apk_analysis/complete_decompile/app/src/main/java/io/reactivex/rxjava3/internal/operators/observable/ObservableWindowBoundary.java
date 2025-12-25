package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import p000.AbstractC1607o2;
import p000.b02;

/* loaded from: classes2.dex */
public final class ObservableWindowBoundary<T, B> extends AbstractC1607o2 {

    /* renamed from: a */
    public final ObservableSource f19614a;

    /* renamed from: b */
    public final int f19615b;

    public ObservableWindowBoundary(ObservableSource<T> observableSource, ObservableSource<B> observableSource2, int i) {
        super(observableSource);
        this.f19614a = observableSource2;
        this.f19615b = i;
    }

    @Override // io.reactivex.rxjava3.core.Observable
    public void subscribeActual(Observer<? super Observable<T>> observer) {
        b02 b02Var = new b02(observer, this.f19615b);
        observer.onSubscribe(b02Var);
        this.f19614a.subscribe(b02Var.f7837c);
        this.source.subscribe(b02Var);
    }
}
