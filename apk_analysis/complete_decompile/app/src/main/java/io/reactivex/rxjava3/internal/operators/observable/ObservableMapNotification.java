package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.functions.Supplier;
import p000.AbstractC1607o2;
import p000.ww1;

/* loaded from: classes2.dex */
public final class ObservableMapNotification<T, R> extends AbstractC1607o2 {

    /* renamed from: a */
    public final Function f19489a;

    /* renamed from: b */
    public final Function f19490b;

    /* renamed from: c */
    public final Supplier f19491c;

    public ObservableMapNotification(ObservableSource<T> observableSource, Function<? super T, ? extends ObservableSource<? extends R>> function, Function<? super Throwable, ? extends ObservableSource<? extends R>> function2, Supplier<? extends ObservableSource<? extends R>> supplier) {
        super(observableSource);
        this.f19489a = function;
        this.f19490b = function2;
        this.f19491c = supplier;
    }

    @Override // io.reactivex.rxjava3.core.Observable
    public void subscribeActual(Observer<? super ObservableSource<? extends R>> observer) {
        this.source.subscribe(new ww1(observer, this.f19489a, this.f19490b, this.f19491c));
    }
}
