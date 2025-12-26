package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.ObservableSource;
import p000.tw1;

/* loaded from: classes2.dex */
public final class ObservableLastMaybe<T> extends Maybe<T> {

    /* renamed from: a */
    public final ObservableSource f19484a;

    public ObservableLastMaybe(ObservableSource<T> observableSource) {
        this.f19484a = observableSource;
    }

    @Override // io.reactivex.rxjava3.core.Maybe
    public void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        this.f19484a.subscribe(new tw1(0, maybeObserver));
    }
}
