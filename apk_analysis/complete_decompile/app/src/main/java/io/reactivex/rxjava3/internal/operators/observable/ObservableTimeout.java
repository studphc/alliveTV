package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.functions.Function;
import p000.AbstractC1607o2;
import p000.oz1;
import p000.pz1;
import p000.qz1;

/* loaded from: classes2.dex */
public final class ObservableTimeout<T, U, V> extends AbstractC1607o2 {

    /* renamed from: a */
    public final ObservableSource f19593a;

    /* renamed from: b */
    public final Function f19594b;

    /* renamed from: c */
    public final ObservableSource f19595c;

    public ObservableTimeout(Observable<T> observable, ObservableSource<U> observableSource, Function<? super T, ? extends ObservableSource<V>> function, ObservableSource<? extends T> observableSource2) {
        super(observable);
        this.f19593a = observableSource;
        this.f19594b = function;
        this.f19595c = observableSource2;
    }

    @Override // io.reactivex.rxjava3.core.Observable
    public void subscribeActual(Observer<? super T> observer) {
        ObservableSource observableSource = this.f19593a;
        Function function = this.f19594b;
        ObservableSource observableSource2 = this.f19595c;
        if (observableSource2 == null) {
            qz1 qz1Var = new qz1(observer, function);
            observer.onSubscribe(qz1Var);
            if (observableSource != null) {
                oz1 oz1Var = new oz1(0L, qz1Var);
                if (qz1Var.f25814c.replace(oz1Var)) {
                    observableSource.subscribe(oz1Var);
                }
            }
            this.source.subscribe(qz1Var);
            return;
        }
        pz1 pz1Var = new pz1(observableSource2, observer, function);
        observer.onSubscribe(pz1Var);
        if (observableSource != null) {
            oz1 oz1Var2 = new oz1(0L, pz1Var);
            if (pz1Var.f25348c.replace(oz1Var2)) {
                observableSource.subscribe(oz1Var2);
            }
        }
        this.source.subscribe(pz1Var);
    }
}
