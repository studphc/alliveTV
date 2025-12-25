package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;

/* loaded from: classes2.dex */
public final class ObservableFromUnsafeSource<T> extends Observable<T> {

    /* renamed from: a */
    public final ObservableSource f19447a;

    public ObservableFromUnsafeSource(ObservableSource<T> observableSource) {
        this.f19447a = observableSource;
    }

    @Override // io.reactivex.rxjava3.core.Observable
    public void subscribeActual(Observer<? super T> observer) {
        this.f19447a.subscribe(observer);
    }
}
