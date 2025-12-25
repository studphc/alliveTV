package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;

/* loaded from: classes2.dex */
public final class ObservableNever extends Observable<Object> {
    public static final Observable<Object> INSTANCE = new Observable<>();

    @Override // io.reactivex.rxjava3.core.Observable
    public void subscribeActual(Observer<? super Object> observer) {
        observer.onSubscribe(EmptyDisposable.NEVER);
    }
}
