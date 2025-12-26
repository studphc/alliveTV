package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.internal.operators.observable.ObservableScalarXMap;
import io.reactivex.rxjava3.operators.ScalarSupplier;

/* loaded from: classes2.dex */
public final class ObservableJust<T> extends Observable<T> implements ScalarSupplier<T> {

    /* renamed from: a */
    public final Object f19483a;

    public ObservableJust(T t) {
        this.f19483a = t;
    }

    @Override // io.reactivex.rxjava3.operators.ScalarSupplier, io.reactivex.rxjava3.functions.Supplier
    public T get() {
        return (T) this.f19483a;
    }

    @Override // io.reactivex.rxjava3.core.Observable
    public void subscribeActual(Observer<? super T> observer) {
        ObservableScalarXMap.ScalarDisposable scalarDisposable = new ObservableScalarXMap.ScalarDisposable(observer, this.f19483a);
        observer.onSubscribe(scalarDisposable);
        scalarDisposable.run();
    }
}
