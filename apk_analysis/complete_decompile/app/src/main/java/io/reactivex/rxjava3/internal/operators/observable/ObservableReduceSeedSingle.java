package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.functions.BiFunction;
import p000.uw1;

/* loaded from: classes2.dex */
public final class ObservableReduceSeedSingle<T, R> extends Single<R> {

    /* renamed from: a */
    public final ObservableSource f19513a;

    /* renamed from: b */
    public final Object f19514b;

    /* renamed from: c */
    public final BiFunction f19515c;

    public ObservableReduceSeedSingle(ObservableSource<T> observableSource, R r, BiFunction<R, ? super T, R> biFunction) {
        this.f19513a = observableSource;
        this.f19514b = r;
        this.f19515c = biFunction;
    }

    @Override // io.reactivex.rxjava3.core.Single
    public void subscribeActual(SingleObserver<? super R> singleObserver) {
        this.f19513a.subscribe(new uw1(singleObserver, this.f19515c, this.f19514b));
    }
}
