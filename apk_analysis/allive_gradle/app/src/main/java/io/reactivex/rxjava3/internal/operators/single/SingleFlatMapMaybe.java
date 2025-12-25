package io.reactivex.rxjava3.internal.operators.single;

import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.MaybeSource;
import io.reactivex.rxjava3.core.SingleSource;
import io.reactivex.rxjava3.functions.Function;
import p000.hj2;

/* loaded from: classes2.dex */
public final class SingleFlatMapMaybe<T, R> extends Maybe<R> {

    /* renamed from: a */
    public final SingleSource f19772a;

    /* renamed from: b */
    public final Function f19773b;

    public SingleFlatMapMaybe(SingleSource<? extends T> singleSource, Function<? super T, ? extends MaybeSource<? extends R>> function) {
        this.f19773b = function;
        this.f19772a = singleSource;
    }

    @Override // io.reactivex.rxjava3.core.Maybe
    public void subscribeActual(MaybeObserver<? super R> maybeObserver) {
        this.f19772a.subscribe(new hj2(maybeObserver, this.f19773b));
    }
}
