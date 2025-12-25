package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import p000.uw1;

/* loaded from: classes2.dex */
public final class ObservableLastSingle<T> extends Single<T> {

    /* renamed from: a */
    public final ObservableSource f19485a;

    /* renamed from: b */
    public final Object f19486b;

    public ObservableLastSingle(ObservableSource<T> observableSource, T t) {
        this.f19485a = observableSource;
        this.f19486b = t;
    }

    @Override // io.reactivex.rxjava3.core.Single
    public void subscribeActual(SingleObserver<? super T> singleObserver) {
        this.f19485a.subscribe(new uw1(singleObserver, this.f19486b));
    }
}
