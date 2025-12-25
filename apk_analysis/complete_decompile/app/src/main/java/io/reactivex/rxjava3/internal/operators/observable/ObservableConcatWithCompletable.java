package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.CompletableSource;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import p000.AbstractC1607o2;
import p000.vu1;

/* loaded from: classes2.dex */
public final class ObservableConcatWithCompletable<T> extends AbstractC1607o2 {

    /* renamed from: a */
    public final CompletableSource f19381a;

    public ObservableConcatWithCompletable(Observable<T> observable, CompletableSource completableSource) {
        super(observable);
        this.f19381a = completableSource;
    }

    @Override // io.reactivex.rxjava3.core.Observable
    public void subscribeActual(Observer<? super T> observer) {
        this.source.subscribe(new vu1(observer, this.f19381a));
    }
}
