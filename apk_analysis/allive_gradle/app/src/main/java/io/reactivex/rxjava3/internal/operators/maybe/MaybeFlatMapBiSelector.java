package io.reactivex.rxjava3.internal.operators.maybe;

import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.MaybeSource;
import io.reactivex.rxjava3.functions.BiFunction;
import io.reactivex.rxjava3.functions.Function;
import p000.AbstractC0003a2;
import p000.oi1;

/* loaded from: classes2.dex */
public final class MaybeFlatMapBiSelector<T, U, R> extends AbstractC0003a2 {

    /* renamed from: a */
    public final Function f19156a;

    /* renamed from: b */
    public final BiFunction f19157b;

    public MaybeFlatMapBiSelector(MaybeSource<T> maybeSource, Function<? super T, ? extends MaybeSource<? extends U>> function, BiFunction<? super T, ? super U, ? extends R> biFunction) {
        super(maybeSource);
        this.f19156a = function;
        this.f19157b = biFunction;
    }

    @Override // io.reactivex.rxjava3.core.Maybe
    public void subscribeActual(MaybeObserver<? super R> maybeObserver) {
        this.source.subscribe(new oi1(maybeObserver, this.f19156a, this.f19157b));
    }
}
