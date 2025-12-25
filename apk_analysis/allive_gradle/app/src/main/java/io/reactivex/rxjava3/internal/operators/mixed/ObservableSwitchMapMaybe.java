package io.reactivex.rxjava3.internal.operators.mixed;

import io.reactivex.rxjava3.core.MaybeSource;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.functions.Function;
import p000.dz1;
import p000.yy2;

/* loaded from: classes2.dex */
public final class ObservableSwitchMapMaybe<T, R> extends Observable<R> {

    /* renamed from: a */
    public final Observable f19308a;

    /* renamed from: b */
    public final Function f19309b;

    /* renamed from: c */
    public final boolean f19310c;

    public ObservableSwitchMapMaybe(Observable<T> observable, Function<? super T, ? extends MaybeSource<? extends R>> function, boolean z) {
        this.f19308a = observable;
        this.f19309b = function;
        this.f19310c = z;
    }

    @Override // io.reactivex.rxjava3.core.Observable
    public void subscribeActual(Observer<? super R> observer) {
        Observable observable = this.f19308a;
        Function function = this.f19309b;
        if (!yy2.m8345T(observable, function, observer)) {
            observable.subscribe(new dz1(observer, function, this.f19310c));
        }
    }
}
