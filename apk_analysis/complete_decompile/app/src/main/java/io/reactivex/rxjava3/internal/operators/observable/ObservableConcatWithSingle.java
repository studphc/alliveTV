package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.core.SingleSource;
import p000.AbstractC1607o2;
import p000.xu1;

/* loaded from: classes2.dex */
public final class ObservableConcatWithSingle<T> extends AbstractC1607o2 {

    /* renamed from: a */
    public final SingleSource f19383a;

    public ObservableConcatWithSingle(Observable<T> observable, SingleSource<? extends T> singleSource) {
        super(observable);
        this.f19383a = singleSource;
    }

    @Override // io.reactivex.rxjava3.core.Observable
    public void subscribeActual(Observer<? super T> observer) {
        this.source.subscribe(new xu1(observer, this.f19383a));
    }
}
