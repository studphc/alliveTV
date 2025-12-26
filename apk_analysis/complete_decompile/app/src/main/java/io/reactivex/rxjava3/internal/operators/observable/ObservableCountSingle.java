package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.internal.fuseable.FuseToObservable;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import p000.yu1;

/* loaded from: classes2.dex */
public final class ObservableCountSingle<T> extends Single<Long> implements FuseToObservable<Long> {

    /* renamed from: a */
    public final ObservableSource f19384a;

    public ObservableCountSingle(ObservableSource<T> observableSource) {
        this.f19384a = observableSource;
    }

    @Override // io.reactivex.rxjava3.internal.fuseable.FuseToObservable
    public Observable<Long> fuseToObservable() {
        return RxJavaPlugins.onAssembly(new ObservableCount(this.f19384a));
    }

    @Override // io.reactivex.rxjava3.core.Single
    public void subscribeActual(SingleObserver<? super Long> singleObserver) {
        this.f19384a.subscribe(new yu1(2, singleObserver));
    }
}
