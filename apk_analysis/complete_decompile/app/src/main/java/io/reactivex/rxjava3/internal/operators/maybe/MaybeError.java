package io.reactivex.rxjava3.internal.operators.maybe;

import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.MaybeObserver;
import p000.g50;

/* loaded from: classes2.dex */
public final class MaybeError<T> extends Maybe<T> {

    /* renamed from: a */
    public final Throwable f19151a;

    public MaybeError(Throwable th) {
        this.f19151a = th;
    }

    @Override // io.reactivex.rxjava3.core.Maybe
    public void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        maybeObserver.onSubscribe(g50.m4919a());
        maybeObserver.onError(this.f19151a);
    }
}
