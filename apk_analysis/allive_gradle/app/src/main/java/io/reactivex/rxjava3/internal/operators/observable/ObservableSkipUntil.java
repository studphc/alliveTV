package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.internal.disposables.ArrayCompositeDisposable;
import io.reactivex.rxjava3.observers.SerializedObserver;
import p000.AbstractC1607o2;
import p000.ty1;
import p000.uy1;

/* loaded from: classes2.dex */
public final class ObservableSkipUntil<T, U> extends AbstractC1607o2 {

    /* renamed from: a */
    public final ObservableSource f19566a;

    public ObservableSkipUntil(ObservableSource<T> observableSource, ObservableSource<U> observableSource2) {
        super(observableSource);
        this.f19566a = observableSource2;
    }

    @Override // io.reactivex.rxjava3.core.Observable
    public void subscribeActual(Observer<? super T> observer) {
        SerializedObserver serializedObserver = new SerializedObserver(observer);
        ArrayCompositeDisposable arrayCompositeDisposable = new ArrayCompositeDisposable(2);
        serializedObserver.onSubscribe(arrayCompositeDisposable);
        uy1 uy1Var = new uy1(serializedObserver, arrayCompositeDisposable);
        this.f19566a.subscribe(new ty1(arrayCompositeDisposable, uy1Var, serializedObserver));
        this.source.subscribe(uy1Var);
    }
}
