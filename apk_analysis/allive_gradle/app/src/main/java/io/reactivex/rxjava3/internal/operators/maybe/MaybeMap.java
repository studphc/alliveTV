package io.reactivex.rxjava3.internal.operators.maybe;

import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.MaybeSource;
import io.reactivex.rxjava3.functions.Function;
import p000.AbstractC0003a2;
import p000.gi1;

/* loaded from: classes2.dex */
public final class MaybeMap<T, R> extends AbstractC0003a2 {

    /* renamed from: a */
    public final Function f19183a;

    public MaybeMap(MaybeSource<T> maybeSource, Function<? super T, ? extends R> function) {
        super(maybeSource);
        this.f19183a = function;
    }

    @Override // io.reactivex.rxjava3.core.Maybe
    public void subscribeActual(MaybeObserver<? super R> maybeObserver) {
        this.source.subscribe(new gi1(1, maybeObserver, this.f19183a));
    }
}
