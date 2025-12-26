package io.reactivex.rxjava3.internal.operators.maybe;

import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.MaybeSource;
import p000.AbstractC0003a2;
import p000.nj1;

/* loaded from: classes2.dex */
public final class MaybeTakeUntilMaybe<T, U> extends AbstractC0003a2 {

    /* renamed from: a */
    public final MaybeSource f19203a;

    public MaybeTakeUntilMaybe(MaybeSource<T> maybeSource, MaybeSource<U> maybeSource2) {
        super(maybeSource);
        this.f19203a = maybeSource2;
    }

    @Override // io.reactivex.rxjava3.core.Maybe
    public void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        nj1 nj1Var = new nj1(maybeObserver);
        maybeObserver.onSubscribe(nj1Var);
        this.f19203a.subscribe(nj1Var.f23382b);
        this.source.subscribe(nj1Var);
    }
}
