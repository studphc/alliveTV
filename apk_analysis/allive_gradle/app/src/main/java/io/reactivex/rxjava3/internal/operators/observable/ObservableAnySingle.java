package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.functions.Predicate;
import io.reactivex.rxjava3.internal.fuseable.FuseToObservable;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import p000.lt1;

/* loaded from: classes2.dex */
public final class ObservableAnySingle<T> extends Single<Boolean> implements FuseToObservable<Boolean> {

    /* renamed from: a */
    public final ObservableSource f19328a;

    /* renamed from: b */
    public final Predicate f19329b;

    public ObservableAnySingle(ObservableSource<T> observableSource, Predicate<? super T> predicate) {
        this.f19328a = observableSource;
        this.f19329b = predicate;
    }

    @Override // io.reactivex.rxjava3.internal.fuseable.FuseToObservable
    public Observable<Boolean> fuseToObservable() {
        return RxJavaPlugins.onAssembly(new ObservableAny(this.f19328a, this.f19329b));
    }

    @Override // io.reactivex.rxjava3.core.Single
    public void subscribeActual(SingleObserver<? super Boolean> singleObserver) {
        this.f19328a.subscribe(new lt1(singleObserver, this.f19329b, 1));
    }
}
