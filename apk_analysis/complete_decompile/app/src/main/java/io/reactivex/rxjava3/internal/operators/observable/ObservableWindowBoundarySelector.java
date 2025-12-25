package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.functions.Function;
import p000.AbstractC1607o2;
import p000.f02;

/* loaded from: classes2.dex */
public final class ObservableWindowBoundarySelector<T, B, V> extends AbstractC1607o2 {

    /* renamed from: a */
    public final ObservableSource f19616a;

    /* renamed from: b */
    public final Function f19617b;

    /* renamed from: c */
    public final int f19618c;

    public ObservableWindowBoundarySelector(ObservableSource<T> observableSource, ObservableSource<B> observableSource2, Function<? super B, ? extends ObservableSource<V>> function, int i) {
        super(observableSource);
        this.f19616a = observableSource2;
        this.f19617b = function;
        this.f19618c = i;
    }

    @Override // io.reactivex.rxjava3.core.Observable
    public void subscribeActual(Observer<? super Observable<T>> observer) {
        this.source.subscribe(new f02(observer, this.f19616a, this.f19617b, this.f19618c));
    }
}
