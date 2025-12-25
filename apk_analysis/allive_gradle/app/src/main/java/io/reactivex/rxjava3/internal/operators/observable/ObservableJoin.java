package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.functions.BiFunction;
import io.reactivex.rxjava3.functions.Function;
import p000.AbstractC1607o2;
import p000.ow1;
import p000.sw1;

/* loaded from: classes2.dex */
public final class ObservableJoin<TLeft, TRight, TLeftEnd, TRightEnd, R> extends AbstractC1607o2 {

    /* renamed from: a */
    public final ObservableSource f19479a;

    /* renamed from: b */
    public final Function f19480b;

    /* renamed from: c */
    public final Function f19481c;

    /* renamed from: d */
    public final BiFunction f19482d;

    public ObservableJoin(ObservableSource<TLeft> observableSource, ObservableSource<? extends TRight> observableSource2, Function<? super TLeft, ? extends ObservableSource<TLeftEnd>> function, Function<? super TRight, ? extends ObservableSource<TRightEnd>> function2, BiFunction<? super TLeft, ? super TRight, ? extends R> biFunction) {
        super(observableSource);
        this.f19479a = observableSource2;
        this.f19480b = function;
        this.f19481c = function2;
        this.f19482d = biFunction;
    }

    @Override // io.reactivex.rxjava3.core.Observable
    public void subscribeActual(Observer<? super R> observer) {
        sw1 sw1Var = new sw1(observer, this.f19480b, this.f19481c, this.f19482d);
        observer.onSubscribe(sw1Var);
        ow1 ow1Var = new ow1(sw1Var, true);
        CompositeDisposable compositeDisposable = sw1Var.f26596c;
        compositeDisposable.add(ow1Var);
        ow1 ow1Var2 = new ow1(sw1Var, false);
        compositeDisposable.add(ow1Var2);
        this.source.subscribe(ow1Var);
        this.f19479a.subscribe(ow1Var2);
    }
}
