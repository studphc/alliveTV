package io.reactivex.rxjava3.internal.operators.single;

import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.core.SingleSource;
import p000.ri2;

/* loaded from: classes2.dex */
public final class SingleDelayWithObservable<T, U> extends Single<T> {

    /* renamed from: a */
    public final SingleSource f19728a;

    /* renamed from: b */
    public final ObservableSource f19729b;

    public SingleDelayWithObservable(SingleSource<T> singleSource, ObservableSource<U> observableSource) {
        this.f19728a = singleSource;
        this.f19729b = observableSource;
    }

    @Override // io.reactivex.rxjava3.core.Single
    public void subscribeActual(SingleObserver<? super T> singleObserver) {
        this.f19729b.subscribe(new ri2(singleObserver, this.f19728a));
    }
}
