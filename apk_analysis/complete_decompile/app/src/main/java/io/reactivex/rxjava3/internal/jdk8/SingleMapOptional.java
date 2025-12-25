package io.reactivex.rxjava3.internal.jdk8;

import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.functions.Function;
import java.util.Optional;
import p000.ui2;

/* loaded from: classes2.dex */
public final class SingleMapOptional<T, R> extends Maybe<R> {

    /* renamed from: a */
    public final Single f18585a;

    /* renamed from: b */
    public final Function f18586b;

    public SingleMapOptional(Single<T> single, Function<? super T, Optional<? extends R>> function) {
        this.f18585a = single;
        this.f18586b = function;
    }

    @Override // io.reactivex.rxjava3.core.Maybe
    public void subscribeActual(MaybeObserver<? super R> maybeObserver) {
        this.f18585a.subscribe(new ui2(1, maybeObserver, this.f18586b));
    }
}
