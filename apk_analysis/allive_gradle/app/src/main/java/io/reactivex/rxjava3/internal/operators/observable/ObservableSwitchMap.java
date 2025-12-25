package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.functions.Function;
import p000.AbstractC1607o2;
import p000.zy1;

/* loaded from: classes2.dex */
public final class ObservableSwitchMap<T, R> extends AbstractC1607o2 {

    /* renamed from: a */
    public final Function f19570a;

    /* renamed from: b */
    public final int f19571b;

    /* renamed from: c */
    public final boolean f19572c;

    public ObservableSwitchMap(ObservableSource<T> observableSource, Function<? super T, ? extends ObservableSource<? extends R>> function, int i, boolean z) {
        super(observableSource);
        this.f19570a = function;
        this.f19571b = i;
        this.f19572c = z;
    }

    @Override // io.reactivex.rxjava3.core.Observable
    public void subscribeActual(Observer<? super R> observer) {
        ObservableSource<Object> observableSource = this.source;
        Function function = this.f19570a;
        if (ObservableScalarXMap.tryScalarXMapSubscribe(observableSource, observer, function)) {
            return;
        }
        this.source.subscribe(new zy1(observer, function, this.f19571b, this.f19572c));
    }
}
