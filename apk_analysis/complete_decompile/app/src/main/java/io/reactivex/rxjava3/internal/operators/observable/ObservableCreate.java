package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableOnSubscribe;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.exceptions.Exceptions;
import p000.zu1;

/* loaded from: classes2.dex */
public final class ObservableCreate<T> extends Observable<T> {

    /* renamed from: a */
    public final ObservableOnSubscribe f19385a;

    public ObservableCreate(ObservableOnSubscribe<T> observableOnSubscribe) {
        this.f19385a = observableOnSubscribe;
    }

    @Override // io.reactivex.rxjava3.core.Observable
    public void subscribeActual(Observer<? super T> observer) {
        zu1 zu1Var = new zu1(observer);
        observer.onSubscribe(zu1Var);
        try {
            this.f19385a.subscribe(zu1Var);
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            zu1Var.onError(th);
        }
    }
}
