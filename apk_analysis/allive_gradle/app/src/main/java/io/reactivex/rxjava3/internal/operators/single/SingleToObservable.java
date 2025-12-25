package io.reactivex.rxjava3.internal.operators.single;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.core.SingleSource;
import io.reactivex.rxjava3.internal.observers.DeferredScalarDisposable;

/* loaded from: classes2.dex */
public final class SingleToObservable<T> extends Observable<T> {

    /* renamed from: a */
    public final SingleSource f19816a;

    public SingleToObservable(SingleSource<? extends T> singleSource) {
        this.f19816a = singleSource;
    }

    public static <T> SingleObserver<T> create(Observer<? super T> observer) {
        return (SingleObserver<T>) new DeferredScalarDisposable(observer);
    }

    @Override // io.reactivex.rxjava3.core.Observable
    public void subscribeActual(Observer<? super T> observer) {
        this.f19816a.subscribe(create(observer));
    }
}
