package io.reactivex.rxjava3.internal.operators.maybe;

import io.reactivex.rxjava3.core.MaybeSource;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.functions.BiPredicate;
import p000.ki1;

/* loaded from: classes2.dex */
public final class MaybeEqualSingle<T> extends Single<Boolean> {

    /* renamed from: a */
    public final MaybeSource f19148a;

    /* renamed from: b */
    public final MaybeSource f19149b;

    /* renamed from: c */
    public final BiPredicate f19150c;

    public MaybeEqualSingle(MaybeSource<? extends T> maybeSource, MaybeSource<? extends T> maybeSource2, BiPredicate<? super T, ? super T> biPredicate) {
        this.f19148a = maybeSource;
        this.f19149b = maybeSource2;
        this.f19150c = biPredicate;
    }

    @Override // io.reactivex.rxjava3.core.Single
    public void subscribeActual(SingleObserver<? super Boolean> singleObserver) {
        ki1 ki1Var = new ki1(singleObserver, this.f19150c);
        singleObserver.onSubscribe(ki1Var);
        this.f19148a.subscribe(ki1Var.f20860b);
        this.f19149b.subscribe(ki1Var.f20861c);
    }
}
