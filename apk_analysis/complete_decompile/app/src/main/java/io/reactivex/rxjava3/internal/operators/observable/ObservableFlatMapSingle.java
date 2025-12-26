package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.core.SingleSource;
import io.reactivex.rxjava3.functions.Function;
import p000.AbstractC1607o2;
import p000.cw1;

/* loaded from: classes2.dex */
public final class ObservableFlatMapSingle<T, R> extends AbstractC1607o2 {

    /* renamed from: a */
    public final Function f19431a;

    /* renamed from: b */
    public final boolean f19432b;

    public ObservableFlatMapSingle(ObservableSource<T> observableSource, Function<? super T, ? extends SingleSource<? extends R>> function, boolean z) {
        super(observableSource);
        this.f19431a = function;
        this.f19432b = z;
    }

    @Override // io.reactivex.rxjava3.core.Observable
    public void subscribeActual(Observer<? super R> observer) {
        this.source.subscribe(new cw1(observer, this.f19431a, this.f19432b));
    }
}
