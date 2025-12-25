package io.reactivex.rxjava3.internal.operators.single;

import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.core.SingleSource;
import io.reactivex.rxjava3.functions.Function;
import p000.ij2;

/* loaded from: classes2.dex */
public final class SingleFlatMapNotification<T, R> extends Single<R> {

    /* renamed from: a */
    public final SingleSource f19774a;

    /* renamed from: b */
    public final Function f19775b;

    /* renamed from: c */
    public final Function f19776c;

    public SingleFlatMapNotification(SingleSource<T> singleSource, Function<? super T, ? extends SingleSource<? extends R>> function, Function<? super Throwable, ? extends SingleSource<? extends R>> function2) {
        this.f19774a = singleSource;
        this.f19775b = function;
        this.f19776c = function2;
    }

    @Override // io.reactivex.rxjava3.core.Single
    public void subscribeActual(SingleObserver<? super R> singleObserver) {
        this.f19774a.subscribe(new ij2(singleObserver, this.f19775b, this.f19776c));
    }
}
