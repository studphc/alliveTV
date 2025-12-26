package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.functions.BiFunction;
import p000.AbstractC1607o2;
import p000.ny1;

/* loaded from: classes2.dex */
public final class ObservableScan<T> extends AbstractC1607o2 {

    /* renamed from: a */
    public final BiFunction f19545a;

    public ObservableScan(ObservableSource<T> observableSource, BiFunction<T, T, T> biFunction) {
        super(observableSource);
        this.f19545a = biFunction;
    }

    @Override // io.reactivex.rxjava3.core.Observable
    public void subscribeActual(Observer<? super T> observer) {
        this.source.subscribe(new ny1(observer, this.f19545a));
    }
}
