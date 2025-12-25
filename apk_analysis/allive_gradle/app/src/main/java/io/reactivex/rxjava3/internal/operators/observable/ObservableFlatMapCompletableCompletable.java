package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.CompletableSource;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.fuseable.FuseToObservable;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import p000.yv1;

/* loaded from: classes2.dex */
public final class ObservableFlatMapCompletableCompletable<T> extends Completable implements FuseToObservable<T> {

    /* renamed from: a */
    public final ObservableSource f19426a;

    /* renamed from: b */
    public final Function f19427b;

    /* renamed from: c */
    public final boolean f19428c;

    public ObservableFlatMapCompletableCompletable(ObservableSource<T> observableSource, Function<? super T, ? extends CompletableSource> function, boolean z) {
        this.f19426a = observableSource;
        this.f19427b = function;
        this.f19428c = z;
    }

    @Override // io.reactivex.rxjava3.internal.fuseable.FuseToObservable
    public Observable<T> fuseToObservable() {
        return RxJavaPlugins.onAssembly(new ObservableFlatMapCompletable(this.f19426a, this.f19427b, this.f19428c));
    }

    @Override // io.reactivex.rxjava3.core.Completable
    public void subscribeActual(CompletableObserver completableObserver) {
        this.f19426a.subscribe(new yv1(completableObserver, this.f19427b, this.f19428c));
    }
}
