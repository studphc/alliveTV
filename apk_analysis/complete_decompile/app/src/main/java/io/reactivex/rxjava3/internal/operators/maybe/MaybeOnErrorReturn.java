package io.reactivex.rxjava3.internal.operators.maybe;

import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.MaybeSource;
import io.reactivex.rxjava3.functions.Function;
import p000.AbstractC0003a2;
import p000.gi1;

/* loaded from: classes2.dex */
public final class MaybeOnErrorReturn<T> extends AbstractC0003a2 {

    /* renamed from: a */
    public final Function f19192a;

    public MaybeOnErrorReturn(MaybeSource<T> maybeSource, Function<? super Throwable, ? extends T> function) {
        super(maybeSource);
        this.f19192a = function;
    }

    @Override // io.reactivex.rxjava3.core.Maybe
    public void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        this.source.subscribe(new gi1(3, maybeObserver, this.f19192a));
    }
}
