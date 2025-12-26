package io.reactivex.rxjava3.internal.operators.single;

import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.core.SingleSource;
import p000.ek2;

/* loaded from: classes2.dex */
public final class SingleUnsubscribeOn<T> extends Single<T> {

    /* renamed from: a */
    public final SingleSource f19817a;

    /* renamed from: b */
    public final Scheduler f19818b;

    public SingleUnsubscribeOn(SingleSource<T> singleSource, Scheduler scheduler) {
        this.f19817a = singleSource;
        this.f19818b = scheduler;
    }

    @Override // io.reactivex.rxjava3.core.Single
    public void subscribeActual(SingleObserver<? super T> singleObserver) {
        this.f19817a.subscribe(new ek2(singleObserver, this.f19818b));
    }
}
