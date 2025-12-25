package io.reactivex.rxjava3.internal.operators.maybe;

import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.MaybeSource;
import p000.AbstractC0003a2;
import p000.hi1;

/* loaded from: classes2.dex */
public final class MaybeDetach<T> extends AbstractC0003a2 {
    public MaybeDetach(MaybeSource<T> maybeSource) {
        super(maybeSource);
    }

    @Override // io.reactivex.rxjava3.core.Maybe
    public void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        MaybeSource<Object> maybeSource = this.source;
        hi1 hi1Var = new hi1();
        hi1Var.f18067b = maybeObserver;
        maybeSource.subscribe(hi1Var);
    }
}
