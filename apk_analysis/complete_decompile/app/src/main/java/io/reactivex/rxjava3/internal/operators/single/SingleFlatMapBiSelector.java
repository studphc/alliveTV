package io.reactivex.rxjava3.internal.operators.single;

import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.core.SingleSource;
import io.reactivex.rxjava3.functions.BiFunction;
import io.reactivex.rxjava3.functions.Function;
import p000.bj1;

/* loaded from: classes2.dex */
public final class SingleFlatMapBiSelector<T, U, R> extends Single<R> {

    /* renamed from: a */
    public final SingleSource f19763a;

    /* renamed from: b */
    public final Function f19764b;

    /* renamed from: c */
    public final BiFunction f19765c;

    public SingleFlatMapBiSelector(SingleSource<T> singleSource, Function<? super T, ? extends SingleSource<? extends U>> function, BiFunction<? super T, ? super U, ? extends R> biFunction) {
        this.f19763a = singleSource;
        this.f19764b = function;
        this.f19765c = biFunction;
    }

    @Override // io.reactivex.rxjava3.core.Single
    public void subscribeActual(SingleObserver<? super R> singleObserver) {
        this.f19763a.subscribe(new bj1(singleObserver, this.f19764b, this.f19765c));
    }
}
