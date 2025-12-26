package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.internal.fuseable.FuseToObservable;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import p000.rv1;

/* loaded from: classes2.dex */
public final class ObservableElementAtMaybe<T> extends Maybe<T> implements FuseToObservable<T> {

    /* renamed from: a */
    public final ObservableSource f19413a;

    /* renamed from: b */
    public final long f19414b;

    public ObservableElementAtMaybe(ObservableSource<T> observableSource, long j) {
        this.f19413a = observableSource;
        this.f19414b = j;
    }

    @Override // io.reactivex.rxjava3.internal.fuseable.FuseToObservable
    public Observable<T> fuseToObservable() {
        return RxJavaPlugins.onAssembly(new ObservableElementAt(this.f19413a, this.f19414b, null, false));
    }

    @Override // io.reactivex.rxjava3.core.Maybe
    public void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        this.f19413a.subscribe(new rv1(maybeObserver, this.f19414b));
    }
}
