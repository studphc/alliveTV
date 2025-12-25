package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import p000.AbstractC1607o2;
import p000.kv1;

/* loaded from: classes2.dex */
public final class ObservableDetach<T> extends AbstractC1607o2 {
    public ObservableDetach(ObservableSource<T> observableSource) {
        super(observableSource);
    }

    @Override // io.reactivex.rxjava3.core.Observable
    public void subscribeActual(Observer<? super T> observer) {
        ObservableSource<Object> observableSource = this.source;
        kv1 kv1Var = new kv1();
        kv1Var.f22216b = observer;
        observableSource.subscribe(kv1Var);
    }
}
