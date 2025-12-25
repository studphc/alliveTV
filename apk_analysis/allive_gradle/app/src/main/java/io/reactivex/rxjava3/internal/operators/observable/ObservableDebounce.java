package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.observers.SerializedObserver;
import p000.AbstractC1607o2;
import p000.cv1;

/* loaded from: classes2.dex */
public final class ObservableDebounce<T, U> extends AbstractC1607o2 {

    /* renamed from: a */
    public final Function f19386a;

    public ObservableDebounce(ObservableSource<T> observableSource, Function<? super T, ? extends ObservableSource<U>> function) {
        super(observableSource);
        this.f19386a = function;
    }

    @Override // io.reactivex.rxjava3.core.Observable
    public void subscribeActual(Observer<? super T> observer) {
        this.source.subscribe(new cv1(new SerializedObserver(observer), this.f19386a));
    }
}
