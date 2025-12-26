package io.reactivex.rxjava3.internal.operators.single;

import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.core.SingleSource;
import p000.pj2;

/* loaded from: classes2.dex */
public final class SingleObserveOn<T> extends Single<T> {

    /* renamed from: a */
    public final SingleSource f19790a;

    /* renamed from: b */
    public final Scheduler f19791b;

    public SingleObserveOn(SingleSource<T> singleSource, Scheduler scheduler) {
        this.f19790a = singleSource;
        this.f19791b = scheduler;
    }

    @Override // io.reactivex.rxjava3.core.Single
    public void subscribeActual(SingleObserver<? super T> singleObserver) {
        this.f19790a.subscribe(new pj2(singleObserver, this.f19791b));
    }
}
