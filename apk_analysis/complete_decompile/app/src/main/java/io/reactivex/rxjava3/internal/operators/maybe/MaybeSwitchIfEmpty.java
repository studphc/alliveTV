package io.reactivex.rxjava3.internal.operators.maybe;

import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.MaybeSource;
import p000.AbstractC0003a2;
import p000.kj1;

/* loaded from: classes2.dex */
public final class MaybeSwitchIfEmpty<T> extends AbstractC0003a2 {

    /* renamed from: a */
    public final MaybeSource f19200a;

    public MaybeSwitchIfEmpty(MaybeSource<T> maybeSource, MaybeSource<? extends T> maybeSource2) {
        super(maybeSource);
        this.f19200a = maybeSource2;
    }

    @Override // io.reactivex.rxjava3.core.Maybe
    public void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        this.source.subscribe(new kj1(maybeObserver, this.f19200a));
    }
}
