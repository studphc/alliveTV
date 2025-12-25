package io.reactivex.rxjava3.internal.jdk8;

import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.functions.Function;
import java.util.Optional;
import p000.gi1;

/* loaded from: classes2.dex */
public final class MaybeMapOptional<T, R> extends Maybe<R> {

    /* renamed from: a */
    public final Maybe f18552a;

    /* renamed from: b */
    public final Function f18553b;

    public MaybeMapOptional(Maybe<T> maybe, Function<? super T, Optional<? extends R>> function) {
        this.f18552a = maybe;
        this.f18553b = function;
    }

    @Override // io.reactivex.rxjava3.core.Maybe
    public void subscribeActual(MaybeObserver<? super R> maybeObserver) {
        this.f18552a.subscribe(new gi1(2, maybeObserver, this.f18553b));
    }
}
