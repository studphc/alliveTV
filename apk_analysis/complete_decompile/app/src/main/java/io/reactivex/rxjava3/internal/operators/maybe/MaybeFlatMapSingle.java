package io.reactivex.rxjava3.internal.operators.maybe;

import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.MaybeSource;
import io.reactivex.rxjava3.core.SingleSource;
import io.reactivex.rxjava3.functions.Function;
import p000.wi1;

/* loaded from: classes2.dex */
public final class MaybeFlatMapSingle<T, R> extends Maybe<R> {

    /* renamed from: a */
    public final MaybeSource f19167a;

    /* renamed from: b */
    public final Function f19168b;

    public MaybeFlatMapSingle(MaybeSource<T> maybeSource, Function<? super T, ? extends SingleSource<? extends R>> function) {
        this.f19167a = maybeSource;
        this.f19168b = function;
    }

    @Override // io.reactivex.rxjava3.core.Maybe
    public void subscribeActual(MaybeObserver<? super R> maybeObserver) {
        this.f19167a.subscribe(new wi1(maybeObserver, this.f19168b));
    }
}
