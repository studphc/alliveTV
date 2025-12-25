package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.functions.Function;
import p000.AbstractC1607o2;
import p000.ex1;

/* loaded from: classes2.dex */
public final class ObservableOnErrorNext<T> extends AbstractC1607o2 {

    /* renamed from: a */
    public final Function f19502a;

    public ObservableOnErrorNext(ObservableSource<T> observableSource, Function<? super Throwable, ? extends ObservableSource<? extends T>> function) {
        super(observableSource);
        this.f19502a = function;
    }

    @Override // io.reactivex.rxjava3.core.Observable
    public void subscribeActual(Observer<? super T> observer) {
        ex1 ex1Var = new ex1(observer, this.f19502a);
        observer.onSubscribe(ex1Var.f17019c);
        this.source.subscribe(ex1Var);
    }
}
