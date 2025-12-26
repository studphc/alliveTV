package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.functions.Supplier;
import java.util.Collection;
import p000.AbstractC1607o2;
import p000.rt1;

/* loaded from: classes2.dex */
public final class ObservableBufferBoundary<T, U extends Collection<? super T>, Open, Close> extends AbstractC1607o2 {

    /* renamed from: a */
    public final Supplier f19337a;

    /* renamed from: b */
    public final ObservableSource f19338b;

    /* renamed from: c */
    public final Function f19339c;

    public ObservableBufferBoundary(ObservableSource<T> observableSource, ObservableSource<? extends Open> observableSource2, Function<? super Open, ? extends ObservableSource<? extends Close>> function, Supplier<U> supplier) {
        super(observableSource);
        this.f19338b = observableSource2;
        this.f19339c = function;
        this.f19337a = supplier;
    }

    @Override // io.reactivex.rxjava3.core.Observable
    public void subscribeActual(Observer<? super U> observer) {
        rt1 rt1Var = new rt1(observer, this.f19338b, this.f19339c, this.f19337a);
        observer.onSubscribe(rt1Var);
        this.source.subscribe(rt1Var);
    }
}
