package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.functions.BiFunction;
import io.reactivex.rxjava3.functions.Function;
import p000.AbstractC1607o2;
import p000.lw1;
import p000.ow1;

/* loaded from: classes2.dex */
public final class ObservableGroupJoin<TLeft, TRight, TLeftEnd, TRightEnd, R> extends AbstractC1607o2 {

    /* renamed from: a */
    public final ObservableSource f19464a;

    /* renamed from: b */
    public final Function f19465b;

    /* renamed from: c */
    public final Function f19466c;

    /* renamed from: d */
    public final BiFunction f19467d;

    public ObservableGroupJoin(ObservableSource<TLeft> observableSource, ObservableSource<? extends TRight> observableSource2, Function<? super TLeft, ? extends ObservableSource<TLeftEnd>> function, Function<? super TRight, ? extends ObservableSource<TRightEnd>> function2, BiFunction<? super TLeft, ? super Observable<TRight>, ? extends R> biFunction) {
        super(observableSource);
        this.f19464a = observableSource2;
        this.f19465b = function;
        this.f19466c = function2;
        this.f19467d = biFunction;
    }

    @Override // io.reactivex.rxjava3.core.Observable
    public void subscribeActual(Observer<? super R> observer) {
        lw1 lw1Var = new lw1(observer, this.f19465b, this.f19466c, this.f19467d);
        observer.onSubscribe(lw1Var);
        ow1 ow1Var = new ow1(lw1Var, true);
        CompositeDisposable compositeDisposable = lw1Var.f22688c;
        compositeDisposable.add(ow1Var);
        ow1 ow1Var2 = new ow1(lw1Var, false);
        compositeDisposable.add(ow1Var2);
        this.source.subscribe(ow1Var);
        this.f19464a.subscribe(ow1Var2);
    }
}
