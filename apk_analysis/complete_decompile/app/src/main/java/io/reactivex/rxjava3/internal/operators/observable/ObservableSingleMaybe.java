package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.ObservableSource;
import p000.jv1;

/* loaded from: classes2.dex */
public final class ObservableSingleMaybe<T> extends Maybe<T> {

    /* renamed from: a */
    public final ObservableSource f19556a;

    public ObservableSingleMaybe(ObservableSource<T> observableSource) {
        this.f19556a = observableSource;
    }

    @Override // io.reactivex.rxjava3.core.Maybe
    public void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        this.f19556a.subscribe(new jv1(maybeObserver));
    }
}
