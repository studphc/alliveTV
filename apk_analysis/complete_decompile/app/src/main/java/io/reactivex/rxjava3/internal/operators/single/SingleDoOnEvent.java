package io.reactivex.rxjava3.internal.operators.single;

import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.core.SingleSource;
import io.reactivex.rxjava3.functions.BiConsumer;
import p000.xi1;

/* loaded from: classes2.dex */
public final class SingleDoOnEvent<T> extends Single<T> {

    /* renamed from: a */
    public final SingleSource f19747a;

    /* renamed from: b */
    public final BiConsumer f19748b;

    public SingleDoOnEvent(SingleSource<T> singleSource, BiConsumer<? super T, ? super Throwable> biConsumer) {
        this.f19747a = singleSource;
        this.f19748b = biConsumer;
    }

    @Override // io.reactivex.rxjava3.core.Single
    public void subscribeActual(SingleObserver<? super T> singleObserver) {
        this.f19747a.subscribe(new xi1(this, singleObserver, 4));
    }
}
