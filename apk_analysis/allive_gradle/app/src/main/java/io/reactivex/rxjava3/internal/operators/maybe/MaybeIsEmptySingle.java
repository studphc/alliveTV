package io.reactivex.rxjava3.internal.operators.maybe;

import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.MaybeSource;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.internal.fuseable.FuseToMaybe;
import io.reactivex.rxjava3.internal.fuseable.HasUpstreamMaybeSource;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import p000.yh1;

/* loaded from: classes2.dex */
public final class MaybeIsEmptySingle<T> extends Single<Boolean> implements HasUpstreamMaybeSource<T>, FuseToMaybe<Boolean> {

    /* renamed from: a */
    public final MaybeSource f19180a;

    public MaybeIsEmptySingle(MaybeSource<T> maybeSource) {
        this.f19180a = maybeSource;
    }

    @Override // io.reactivex.rxjava3.internal.fuseable.FuseToMaybe
    public Maybe<Boolean> fuseToMaybe() {
        return RxJavaPlugins.onAssembly(new MaybeIsEmpty(this.f19180a));
    }

    @Override // io.reactivex.rxjava3.internal.fuseable.HasUpstreamMaybeSource
    public MaybeSource<T> source() {
        return this.f19180a;
    }

    @Override // io.reactivex.rxjava3.core.Single
    public void subscribeActual(SingleObserver<? super Boolean> singleObserver) {
        this.f19180a.subscribe(new yh1(singleObserver, 1));
    }
}
