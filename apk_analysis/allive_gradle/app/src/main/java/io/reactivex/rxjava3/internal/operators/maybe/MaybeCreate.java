package io.reactivex.rxjava3.internal.operators.maybe;

import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.MaybeOnSubscribe;
import io.reactivex.rxjava3.exceptions.Exceptions;
import p000.zh1;

/* loaded from: classes2.dex */
public final class MaybeCreate<T> extends Maybe<T> {

    /* renamed from: a */
    public final MaybeOnSubscribe f19130a;

    public MaybeCreate(MaybeOnSubscribe<T> maybeOnSubscribe) {
        this.f19130a = maybeOnSubscribe;
    }

    @Override // io.reactivex.rxjava3.core.Maybe
    public void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        zh1 zh1Var = new zh1(maybeObserver);
        maybeObserver.onSubscribe(zh1Var);
        try {
            this.f19130a.subscribe(zh1Var);
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            zh1Var.onError(th);
        }
    }
}
