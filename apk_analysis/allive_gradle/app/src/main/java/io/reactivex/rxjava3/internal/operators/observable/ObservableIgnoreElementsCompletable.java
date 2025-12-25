package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.internal.fuseable.FuseToObservable;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import p000.kv1;

/* loaded from: classes2.dex */
public final class ObservableIgnoreElementsCompletable<T> extends Completable implements FuseToObservable<T> {

    /* renamed from: a */
    public final ObservableSource f19468a;

    public ObservableIgnoreElementsCompletable(ObservableSource<T> observableSource) {
        this.f19468a = observableSource;
    }

    @Override // io.reactivex.rxjava3.internal.fuseable.FuseToObservable
    public Observable<T> fuseToObservable() {
        return RxJavaPlugins.onAssembly(new ObservableIgnoreElements(this.f19468a));
    }

    @Override // io.reactivex.rxjava3.core.Completable
    public void subscribeActual(CompletableObserver completableObserver) {
        this.f19468a.subscribe(new kv1(4, completableObserver));
    }
}
