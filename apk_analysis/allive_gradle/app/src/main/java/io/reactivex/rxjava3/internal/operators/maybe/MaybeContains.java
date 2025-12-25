package io.reactivex.rxjava3.internal.operators.maybe;

import io.reactivex.rxjava3.core.MaybeSource;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.internal.fuseable.HasUpstreamMaybeSource;
import p000.xh1;

/* loaded from: classes2.dex */
public final class MaybeContains<T> extends Single<Boolean> implements HasUpstreamMaybeSource<T> {

    /* renamed from: a */
    public final MaybeSource f19127a;

    /* renamed from: b */
    public final Object f19128b;

    public MaybeContains(MaybeSource<T> maybeSource, Object obj) {
        this.f19127a = maybeSource;
        this.f19128b = obj;
    }

    @Override // io.reactivex.rxjava3.internal.fuseable.HasUpstreamMaybeSource
    public MaybeSource<T> source() {
        return this.f19127a;
    }

    @Override // io.reactivex.rxjava3.core.Single
    public void subscribeActual(SingleObserver<? super Boolean> singleObserver) {
        this.f19127a.subscribe(new xh1(singleObserver, this.f19128b, 0));
    }
}
