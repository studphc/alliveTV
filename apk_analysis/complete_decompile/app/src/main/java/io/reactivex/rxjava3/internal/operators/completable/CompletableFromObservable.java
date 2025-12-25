package io.reactivex.rxjava3.internal.operators.completable;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.ObservableSource;
import p000.C1698ps;

/* loaded from: classes2.dex */
public final class CompletableFromObservable<T> extends Completable {

    /* renamed from: a */
    public final ObservableSource f18671a;

    public CompletableFromObservable(ObservableSource<T> observableSource) {
        this.f18671a = observableSource;
    }

    @Override // io.reactivex.rxjava3.core.Completable
    public void subscribeActual(CompletableObserver completableObserver) {
        this.f18671a.subscribe(new C1698ps(0, completableObserver));
    }
}
