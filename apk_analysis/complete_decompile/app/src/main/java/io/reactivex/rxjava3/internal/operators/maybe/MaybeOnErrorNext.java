package io.reactivex.rxjava3.internal.operators.maybe;

import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.MaybeSource;
import io.reactivex.rxjava3.functions.Function;
import p000.AbstractC0003a2;
import p000.hj1;

/* loaded from: classes2.dex */
public final class MaybeOnErrorNext<T> extends AbstractC0003a2 {

    /* renamed from: a */
    public final Function f19191a;

    public MaybeOnErrorNext(MaybeSource<T> maybeSource, Function<? super Throwable, ? extends MaybeSource<? extends T>> function) {
        super(maybeSource);
        this.f19191a = function;
    }

    @Override // io.reactivex.rxjava3.core.Maybe
    public void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        this.source.subscribe(new hj1(maybeObserver, this.f19191a));
    }
}
