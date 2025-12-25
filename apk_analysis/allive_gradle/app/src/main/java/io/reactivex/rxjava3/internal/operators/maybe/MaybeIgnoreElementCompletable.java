package io.reactivex.rxjava3.internal.operators.maybe;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.MaybeSource;
import io.reactivex.rxjava3.internal.fuseable.FuseToMaybe;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import p000.oi1;

/* loaded from: classes2.dex */
public final class MaybeIgnoreElementCompletable<T> extends Completable implements FuseToMaybe<T> {

    /* renamed from: a */
    public final MaybeSource f19179a;

    public MaybeIgnoreElementCompletable(MaybeSource<T> maybeSource) {
        this.f19179a = maybeSource;
    }

    @Override // io.reactivex.rxjava3.internal.fuseable.FuseToMaybe
    public Maybe<T> fuseToMaybe() {
        return RxJavaPlugins.onAssembly(new MaybeIgnoreElement(this.f19179a));
    }

    @Override // io.reactivex.rxjava3.core.Completable
    public void subscribeActual(CompletableObserver completableObserver) {
        this.f19179a.subscribe(new oi1(completableObserver));
    }
}
