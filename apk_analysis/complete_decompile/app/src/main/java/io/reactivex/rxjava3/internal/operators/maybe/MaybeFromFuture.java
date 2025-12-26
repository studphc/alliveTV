package io.reactivex.rxjava3.internal.operators.maybe;

import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import p000.a10;
import p000.g50;

/* loaded from: classes2.dex */
public final class MaybeFromFuture<T> extends Maybe<T> {

    /* renamed from: a */
    public final Future f19173a;

    /* renamed from: b */
    public final long f19174b;

    /* renamed from: c */
    public final TimeUnit f19175c;

    public MaybeFromFuture(Future<? extends T> future, long j, TimeUnit timeUnit) {
        this.f19173a = future;
        this.f19174b = j;
        this.f19175c = timeUnit;
    }

    @Override // io.reactivex.rxjava3.core.Maybe
    public void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        a10 a10Var;
        Disposable m4920b = g50.m4920b();
        maybeObserver.onSubscribe(m4920b);
        if (!m4920b.isDisposed()) {
            try {
                long j = this.f19174b;
                Future future = this.f19173a;
                if (j <= 0) {
                    a10Var = (Object) future.get();
                } else {
                    a10Var = (Object) future.get(j, this.f19175c);
                }
                if (!m4920b.isDisposed()) {
                    if (a10Var == null) {
                        maybeObserver.onComplete();
                    } else {
                        maybeObserver.onSuccess(a10Var);
                    }
                }
            } catch (Throwable th) {
                th = th;
                Exceptions.throwIfFatal(th);
                if (th instanceof ExecutionException) {
                    th = th.getCause();
                }
                Exceptions.throwIfFatal(th);
                if (!m4920b.isDisposed()) {
                    maybeObserver.onError(th);
                }
            }
        }
    }
}
