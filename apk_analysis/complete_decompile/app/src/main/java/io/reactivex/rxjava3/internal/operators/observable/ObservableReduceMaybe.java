package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.functions.BiFunction;
import p000.bu1;

/* loaded from: classes2.dex */
public final class ObservableReduceMaybe<T> extends Maybe<T> {

    /* renamed from: a */
    public final ObservableSource f19511a;

    /* renamed from: b */
    public final BiFunction f19512b;

    public ObservableReduceMaybe(ObservableSource<T> observableSource, BiFunction<T, T, T> biFunction) {
        this.f19511a = observableSource;
        this.f19512b = biFunction;
    }

    @Override // io.reactivex.rxjava3.core.Maybe
    public void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        this.f19511a.subscribe(new bu1(maybeObserver, this.f19512b));
    }
}
