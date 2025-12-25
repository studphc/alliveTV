package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.observers.SerializedObserver;
import p000.AbstractC1607o2;

/* loaded from: classes2.dex */
public final class ObservableSerialized<T> extends AbstractC1607o2 {
    public ObservableSerialized(Observable<T> observable) {
        super(observable);
    }

    @Override // io.reactivex.rxjava3.core.Observable
    public void subscribeActual(Observer<? super T> observer) {
        this.source.subscribe(new SerializedObserver(observer));
    }
}
