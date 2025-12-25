package io.reactivex.rxjava3.internal.operators.maybe;

import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.MaybeSource;
import p000.AbstractC0003a2;
import p000.sj1;

/* loaded from: classes2.dex */
public final class MaybeTimeoutMaybe<T, U> extends AbstractC0003a2 {

    /* renamed from: a */
    public final MaybeSource f19209a;

    /* renamed from: b */
    public final MaybeSource f19210b;

    public MaybeTimeoutMaybe(MaybeSource<T> maybeSource, MaybeSource<U> maybeSource2, MaybeSource<? extends T> maybeSource3) {
        super(maybeSource);
        this.f19209a = maybeSource2;
        this.f19210b = maybeSource3;
    }

    @Override // io.reactivex.rxjava3.core.Maybe
    public void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        sj1 sj1Var = new sj1(maybeObserver, this.f19210b);
        maybeObserver.onSubscribe(sj1Var);
        this.f19209a.subscribe(sj1Var.f26453b);
        this.source.subscribe(sj1Var);
    }
}
