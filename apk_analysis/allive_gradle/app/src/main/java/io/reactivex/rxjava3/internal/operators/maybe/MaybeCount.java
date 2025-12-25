package io.reactivex.rxjava3.internal.operators.maybe;

import io.reactivex.rxjava3.core.MaybeSource;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.internal.fuseable.HasUpstreamMaybeSource;
import p000.yh1;

/* loaded from: classes2.dex */
public final class MaybeCount<T> extends Single<Long> implements HasUpstreamMaybeSource<T> {

    /* renamed from: a */
    public final MaybeSource f19129a;

    public MaybeCount(MaybeSource<T> maybeSource) {
        this.f19129a = maybeSource;
    }

    @Override // io.reactivex.rxjava3.internal.fuseable.HasUpstreamMaybeSource
    public MaybeSource<T> source() {
        return this.f19129a;
    }

    @Override // io.reactivex.rxjava3.core.Single
    public void subscribeActual(SingleObserver<? super Long> singleObserver) {
        this.f19129a.subscribe(new yh1(singleObserver, 0));
    }
}
