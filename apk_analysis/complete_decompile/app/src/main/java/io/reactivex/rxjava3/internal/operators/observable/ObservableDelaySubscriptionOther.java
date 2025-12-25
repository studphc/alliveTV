package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.internal.disposables.SequentialDisposable;
import p000.iv1;

/* loaded from: classes2.dex */
public final class ObservableDelaySubscriptionOther<T, U> extends Observable<T> {

    /* renamed from: a */
    public final ObservableSource f19395a;

    /* renamed from: b */
    public final ObservableSource f19396b;

    public ObservableDelaySubscriptionOther(ObservableSource<? extends T> observableSource, ObservableSource<U> observableSource2) {
        this.f19395a = observableSource;
        this.f19396b = observableSource2;
    }

    @Override // io.reactivex.rxjava3.core.Observable
    public void subscribeActual(Observer<? super T> observer) {
        SequentialDisposable sequentialDisposable = new SequentialDisposable();
        observer.onSubscribe(sequentialDisposable);
        this.f19396b.subscribe(new iv1(this, sequentialDisposable, observer));
    }
}
