package io.reactivex.rxjava3.internal.operators.maybe;

import io.reactivex.rxjava3.core.MaybeSource;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.internal.fuseable.HasUpstreamMaybeSource;
import p000.xh1;

/* loaded from: classes2.dex */
public final class MaybeToSingle<T> extends Single<T> implements HasUpstreamMaybeSource<T> {

    /* renamed from: a */
    public final MaybeSource f19219a;

    /* renamed from: b */
    public final Object f19220b;

    public MaybeToSingle(MaybeSource<T> maybeSource, T t) {
        this.f19219a = maybeSource;
        this.f19220b = t;
    }

    @Override // io.reactivex.rxjava3.internal.fuseable.HasUpstreamMaybeSource
    public MaybeSource<T> source() {
        return this.f19219a;
    }

    @Override // io.reactivex.rxjava3.core.Single
    public void subscribeActual(SingleObserver<? super T> singleObserver) {
        this.f19219a.subscribe(new xh1(singleObserver, this.f19220b, 1));
    }
}
