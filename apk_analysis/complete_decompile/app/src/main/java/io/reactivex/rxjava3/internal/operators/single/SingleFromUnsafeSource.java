package io.reactivex.rxjava3.internal.operators.single;

import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.core.SingleSource;

/* loaded from: classes2.dex */
public final class SingleFromUnsafeSource<T> extends Single<T> {

    /* renamed from: a */
    public final SingleSource f19782a;

    public SingleFromUnsafeSource(SingleSource<T> singleSource) {
        this.f19782a = singleSource;
    }

    @Override // io.reactivex.rxjava3.core.Single
    public void subscribeActual(SingleObserver<? super T> singleObserver) {
        this.f19782a.subscribe(singleObserver);
    }
}
