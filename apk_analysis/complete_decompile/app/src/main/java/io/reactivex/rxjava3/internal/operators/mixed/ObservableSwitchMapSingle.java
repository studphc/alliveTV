package io.reactivex.rxjava3.internal.operators.mixed;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.core.SingleSource;
import io.reactivex.rxjava3.functions.Function;
import p000.fz1;
import p000.yy2;

/* loaded from: classes2.dex */
public final class ObservableSwitchMapSingle<T, R> extends Observable<R> {

    /* renamed from: a */
    public final Observable f19311a;

    /* renamed from: b */
    public final Function f19312b;

    /* renamed from: c */
    public final boolean f19313c;

    public ObservableSwitchMapSingle(Observable<T> observable, Function<? super T, ? extends SingleSource<? extends R>> function, boolean z) {
        this.f19311a = observable;
        this.f19312b = function;
        this.f19313c = z;
    }

    @Override // io.reactivex.rxjava3.core.Observable
    public void subscribeActual(Observer<? super R> observer) {
        Observable observable = this.f19311a;
        Function function = this.f19312b;
        if (!yy2.m8346U(observable, function, observer)) {
            observable.subscribe(new fz1(observer, function, this.f19313c));
        }
    }
}
