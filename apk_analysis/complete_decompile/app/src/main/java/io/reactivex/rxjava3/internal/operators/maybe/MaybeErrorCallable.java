package io.reactivex.rxjava3.internal.operators.maybe;

import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import p000.g50;

/* loaded from: classes2.dex */
public final class MaybeErrorCallable<T> extends Maybe<T> {

    /* renamed from: a */
    public final Supplier f19152a;

    public MaybeErrorCallable(Supplier<? extends Throwable> supplier) {
        this.f19152a = supplier;
    }

    @Override // io.reactivex.rxjava3.core.Maybe
    public void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        maybeObserver.onSubscribe(g50.m4919a());
        try {
            th = (Throwable) ExceptionHelper.nullCheck(this.f19152a.get(), "Supplier returned a null Throwable.");
        } catch (Throwable th) {
            th = th;
            Exceptions.throwIfFatal(th);
        }
        maybeObserver.onError(th);
    }
}
