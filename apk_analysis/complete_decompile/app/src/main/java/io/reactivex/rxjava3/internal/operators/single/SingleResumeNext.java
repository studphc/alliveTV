package io.reactivex.rxjava3.internal.operators.single;

import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.core.SingleSource;
import io.reactivex.rxjava3.functions.Function;
import p000.qj2;

/* loaded from: classes2.dex */
public final class SingleResumeNext<T> extends Single<T> {

    /* renamed from: a */
    public final SingleSource f19797a;

    /* renamed from: b */
    public final Function f19798b;

    public SingleResumeNext(SingleSource<? extends T> singleSource, Function<? super Throwable, ? extends SingleSource<? extends T>> function) {
        this.f19797a = singleSource;
        this.f19798b = function;
    }

    @Override // io.reactivex.rxjava3.core.Single
    public void subscribeActual(SingleObserver<? super T> singleObserver) {
        this.f19797a.subscribe(new qj2(singleObserver, this.f19798b));
    }
}
