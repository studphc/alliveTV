package io.reactivex.rxjava3.internal.operators.mixed;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.core.SingleSource;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.util.ErrorMode;
import p000.uu1;
import p000.yy2;

/* loaded from: classes2.dex */
public final class ObservableConcatMapSingle<T, R> extends Observable<R> {

    /* renamed from: a */
    public final ObservableSource f19301a;

    /* renamed from: b */
    public final Function f19302b;

    /* renamed from: c */
    public final ErrorMode f19303c;

    /* renamed from: d */
    public final int f19304d;

    public ObservableConcatMapSingle(ObservableSource<T> observableSource, Function<? super T, ? extends SingleSource<? extends R>> function, ErrorMode errorMode, int i) {
        this.f19301a = observableSource;
        this.f19302b = function;
        this.f19303c = errorMode;
        this.f19304d = i;
    }

    @Override // io.reactivex.rxjava3.core.Observable
    public void subscribeActual(Observer<? super R> observer) {
        ObservableSource observableSource = this.f19301a;
        Function function = this.f19302b;
        if (!yy2.m8346U(observableSource, function, observer)) {
            observableSource.subscribe(new uu1(observer, function, this.f19304d, this.f19303c));
        }
    }
}
