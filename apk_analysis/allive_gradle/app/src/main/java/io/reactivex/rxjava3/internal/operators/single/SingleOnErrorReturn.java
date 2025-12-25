package io.reactivex.rxjava3.internal.operators.single;

import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.core.SingleSource;
import io.reactivex.rxjava3.functions.Function;
import p000.xi1;

/* loaded from: classes2.dex */
public final class SingleOnErrorReturn<T> extends Single<T> {

    /* renamed from: a */
    public final SingleSource f19794a;

    /* renamed from: b */
    public final Function f19795b;

    /* renamed from: c */
    public final Object f19796c;

    public SingleOnErrorReturn(SingleSource<? extends T> singleSource, Function<? super Throwable, ? extends T> function, T t) {
        this.f19794a = singleSource;
        this.f19795b = function;
        this.f19796c = t;
    }

    @Override // io.reactivex.rxjava3.core.Single
    public void subscribeActual(SingleObserver<? super T> singleObserver) {
        this.f19794a.subscribe(new xi1(this, singleObserver, 9));
    }
}
