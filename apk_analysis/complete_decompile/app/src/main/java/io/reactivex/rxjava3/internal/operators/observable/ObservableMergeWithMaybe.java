package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.MaybeSource;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import p000.AbstractC1607o2;
import p000.ax1;

/* loaded from: classes2.dex */
public final class ObservableMergeWithMaybe<T> extends AbstractC1607o2 {

    /* renamed from: a */
    public final MaybeSource f19493a;

    public ObservableMergeWithMaybe(Observable<T> observable, MaybeSource<? extends T> maybeSource) {
        super(observable);
        this.f19493a = maybeSource;
    }

    @Override // io.reactivex.rxjava3.core.Observable
    public void subscribeActual(Observer<? super T> observer) {
        ax1 ax1Var = new ax1(observer);
        observer.onSubscribe(ax1Var);
        this.source.subscribe(ax1Var);
        this.f19493a.subscribe(ax1Var.f7781c);
    }
}
