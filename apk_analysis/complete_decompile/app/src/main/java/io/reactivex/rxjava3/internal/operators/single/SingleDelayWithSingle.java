package io.reactivex.rxjava3.internal.operators.single;

import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.core.SingleSource;
import p000.ti2;

/* loaded from: classes2.dex */
public final class SingleDelayWithSingle<T, U> extends Single<T> {

    /* renamed from: a */
    public final SingleSource f19732a;

    /* renamed from: b */
    public final SingleSource f19733b;

    public SingleDelayWithSingle(SingleSource<T> singleSource, SingleSource<U> singleSource2) {
        this.f19732a = singleSource;
        this.f19733b = singleSource2;
    }

    @Override // io.reactivex.rxjava3.core.Single
    public void subscribeActual(SingleObserver<? super T> singleObserver) {
        this.f19733b.subscribe(new ti2(singleObserver, this.f19732a));
    }
}
