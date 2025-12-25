package io.reactivex.rxjava3.internal.operators.maybe;

import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.MaybeSource;
import io.reactivex.rxjava3.functions.Function;
import p000.AbstractC0003a2;
import p000.yi1;

/* loaded from: classes2.dex */
public final class MaybeFlatten<T, R> extends AbstractC0003a2 {

    /* renamed from: a */
    public final Function f19169a;

    public MaybeFlatten(MaybeSource<T> maybeSource, Function<? super T, ? extends MaybeSource<? extends R>> function) {
        super(maybeSource);
        this.f19169a = function;
    }

    @Override // io.reactivex.rxjava3.core.Maybe
    public void subscribeActual(MaybeObserver<? super R> maybeObserver) {
        this.source.subscribe(new yi1(maybeObserver, this.f19169a));
    }
}
