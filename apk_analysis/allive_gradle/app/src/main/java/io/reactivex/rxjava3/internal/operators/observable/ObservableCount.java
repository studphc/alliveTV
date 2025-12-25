package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import p000.AbstractC1607o2;
import p000.yu1;

/* loaded from: classes2.dex */
public final class ObservableCount<T> extends AbstractC1607o2 {
    public ObservableCount(ObservableSource<T> observableSource) {
        super(observableSource);
    }

    @Override // io.reactivex.rxjava3.core.Observable
    public void subscribeActual(Observer<? super Long> observer) {
        this.source.subscribe(new yu1(0, observer));
    }
}
