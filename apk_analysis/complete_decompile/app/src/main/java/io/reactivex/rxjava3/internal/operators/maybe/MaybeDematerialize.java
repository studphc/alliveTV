package io.reactivex.rxjava3.internal.operators.maybe;

import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.Notification;
import io.reactivex.rxjava3.functions.Function;
import p000.AbstractC0003a2;
import p000.gi1;

/* loaded from: classes2.dex */
public final class MaybeDematerialize<T, R> extends AbstractC0003a2 {

    /* renamed from: a */
    public final Function f19140a;

    public MaybeDematerialize(Maybe<T> maybe, Function<? super T, Notification<R>> function) {
        super(maybe);
        this.f19140a = function;
    }

    @Override // io.reactivex.rxjava3.core.Maybe
    public void subscribeActual(MaybeObserver<? super R> maybeObserver) {
        this.source.subscribe(new gi1(0, maybeObserver, this.f19140a));
    }
}
