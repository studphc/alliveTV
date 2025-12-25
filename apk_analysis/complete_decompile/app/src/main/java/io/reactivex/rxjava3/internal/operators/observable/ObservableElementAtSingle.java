package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.internal.fuseable.FuseToObservable;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import p000.sv1;

/* loaded from: classes2.dex */
public final class ObservableElementAtSingle<T> extends Single<T> implements FuseToObservable<T> {

    /* renamed from: a */
    public final ObservableSource f19415a;

    /* renamed from: b */
    public final long f19416b;

    /* renamed from: c */
    public final Object f19417c;

    public ObservableElementAtSingle(ObservableSource<T> observableSource, long j, T t) {
        this.f19415a = observableSource;
        this.f19416b = j;
        this.f19417c = t;
    }

    @Override // io.reactivex.rxjava3.internal.fuseable.FuseToObservable
    public Observable<T> fuseToObservable() {
        return RxJavaPlugins.onAssembly(new ObservableElementAt(this.f19415a, this.f19416b, this.f19417c, true));
    }

    @Override // io.reactivex.rxjava3.core.Single
    public void subscribeActual(SingleObserver<? super T> singleObserver) {
        this.f19415a.subscribe(new sv1(singleObserver, this.f19416b, this.f19417c));
    }
}
