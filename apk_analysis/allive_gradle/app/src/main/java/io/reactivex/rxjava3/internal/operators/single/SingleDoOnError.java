package io.reactivex.rxjava3.internal.operators.single;

import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.core.SingleSource;
import io.reactivex.rxjava3.functions.Consumer;
import p000.xi1;

/* loaded from: classes2.dex */
public final class SingleDoOnError<T> extends Single<T> {

    /* renamed from: a */
    public final SingleSource f19745a;

    /* renamed from: b */
    public final Consumer f19746b;

    public SingleDoOnError(SingleSource<T> singleSource, Consumer<? super Throwable> consumer) {
        this.f19745a = singleSource;
        this.f19746b = consumer;
    }

    @Override // io.reactivex.rxjava3.core.Single
    public void subscribeActual(SingleObserver<? super T> singleObserver) {
        this.f19745a.subscribe(new xi1(this, singleObserver, 3));
    }
}
