package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.CompletableSource;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import p000.AbstractC1607o2;
import p000.yw1;

/* loaded from: classes2.dex */
public final class ObservableMergeWithCompletable<T> extends AbstractC1607o2 {

    /* renamed from: a */
    public final CompletableSource f19492a;

    public ObservableMergeWithCompletable(Observable<T> observable, CompletableSource completableSource) {
        super(observable);
        this.f19492a = completableSource;
    }

    @Override // io.reactivex.rxjava3.core.Observable
    public void subscribeActual(Observer<? super T> observer) {
        yw1 yw1Var = new yw1(observer);
        observer.onSubscribe(yw1Var);
        this.source.subscribe(yw1Var);
        this.f19492a.subscribe(yw1Var.f29152c);
    }
}
