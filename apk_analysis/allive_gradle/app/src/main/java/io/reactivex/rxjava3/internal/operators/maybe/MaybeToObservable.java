package io.reactivex.rxjava3.internal.operators.maybe;

import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.MaybeSource;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.internal.fuseable.HasUpstreamMaybeSource;
import io.reactivex.rxjava3.internal.observers.DeferredScalarDisposable;

/* loaded from: classes2.dex */
public final class MaybeToObservable<T> extends Observable<T> implements HasUpstreamMaybeSource<T> {

    /* renamed from: a */
    public final MaybeSource f19217a;

    public MaybeToObservable(MaybeSource<T> maybeSource) {
        this.f19217a = maybeSource;
    }

    public static <T> MaybeObserver<T> create(Observer<? super T> observer) {
        return (MaybeObserver<T>) new DeferredScalarDisposable(observer);
    }

    @Override // io.reactivex.rxjava3.internal.fuseable.HasUpstreamMaybeSource
    public MaybeSource<T> source() {
        return this.f19217a;
    }

    @Override // io.reactivex.rxjava3.core.Observable
    public void subscribeActual(Observer<? super T> observer) {
        this.f19217a.subscribe(create(observer));
    }
}
