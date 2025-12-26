package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import p000.AbstractC1607o2;
import p000.hz1;

/* loaded from: classes2.dex */
public final class ObservableTakeLast<T> extends AbstractC1607o2 {

    /* renamed from: a */
    public final int f19574a;

    public ObservableTakeLast(ObservableSource<T> observableSource, int i) {
        super(observableSource);
        this.f19574a = i;
    }

    @Override // io.reactivex.rxjava3.core.Observable
    public void subscribeActual(Observer<? super T> observer) {
        this.source.subscribe(new hz1(observer, this.f19574a));
    }
}
