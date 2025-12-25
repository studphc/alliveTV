package io.reactivex.rxjava3.internal.operators.mixed;

import io.reactivex.rxjava3.core.MaybeSource;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.util.ErrorMode;
import p000.ou1;
import p000.yy2;

/* loaded from: classes2.dex */
public final class ObservableConcatMapMaybe<T, R> extends Observable<R> {

    /* renamed from: a */
    public final Observable f19297a;

    /* renamed from: b */
    public final Function f19298b;

    /* renamed from: c */
    public final ErrorMode f19299c;

    /* renamed from: d */
    public final int f19300d;

    public ObservableConcatMapMaybe(Observable<T> observable, Function<? super T, ? extends MaybeSource<? extends R>> function, ErrorMode errorMode, int i) {
        this.f19297a = observable;
        this.f19298b = function;
        this.f19299c = errorMode;
        this.f19300d = i;
    }

    @Override // io.reactivex.rxjava3.core.Observable
    public void subscribeActual(Observer<? super R> observer) {
        Observable observable = this.f19297a;
        Function function = this.f19298b;
        if (!yy2.m8345T(observable, function, observer)) {
            observable.subscribe(new ou1(observer, function, this.f19300d, this.f19299c));
        }
    }
}
