package io.reactivex.rxjava3.internal.operators.single;

import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.core.SingleSource;
import io.reactivex.rxjava3.functions.Consumer;
import p000.mi1;

/* loaded from: classes2.dex */
public final class SingleDoAfterSuccess<T> extends Single<T> {

    /* renamed from: a */
    public final SingleSource f19737a;

    /* renamed from: b */
    public final Consumer f19738b;

    public SingleDoAfterSuccess(SingleSource<T> singleSource, Consumer<? super T> consumer) {
        this.f19737a = singleSource;
        this.f19738b = consumer;
    }

    @Override // io.reactivex.rxjava3.core.Single
    public void subscribeActual(SingleObserver<? super T> singleObserver) {
        this.f19737a.subscribe(new mi1(1, singleObserver, this.f19738b));
    }
}
