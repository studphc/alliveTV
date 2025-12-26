package io.reactivex.rxjava3.internal.operators.maybe;

import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.MaybeSource;
import p000.AbstractC0003a2;
import p000.hi1;

/* loaded from: classes2.dex */
public final class MaybeIsEmpty<T> extends AbstractC0003a2 {
    public MaybeIsEmpty(MaybeSource<T> maybeSource) {
        super(maybeSource);
    }

    @Override // io.reactivex.rxjava3.core.Maybe
    public void subscribeActual(MaybeObserver<? super Boolean> maybeObserver) {
        this.source.subscribe(new hi1(maybeObserver, 3));
    }
}
