package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import p000.bu1;

/* loaded from: classes2.dex */
public final class ObservableSingleSingle<T> extends Single<T> {

    /* renamed from: a */
    public final ObservableSource f19557a;

    /* renamed from: b */
    public final Object f19558b;

    public ObservableSingleSingle(ObservableSource<? extends T> observableSource, T t) {
        this.f19557a = observableSource;
        this.f19558b = t;
    }

    @Override // io.reactivex.rxjava3.core.Single
    public void subscribeActual(SingleObserver<? super T> singleObserver) {
        this.f19557a.subscribe(new bu1(singleObserver, this.f19558b));
    }
}
