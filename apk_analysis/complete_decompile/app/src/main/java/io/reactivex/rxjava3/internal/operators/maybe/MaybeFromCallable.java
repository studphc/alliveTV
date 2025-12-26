package io.reactivex.rxjava3.internal.operators.maybe;

import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.Callable;
import p000.AbstractC0002a1;
import p000.g50;

/* loaded from: classes2.dex */
public final class MaybeFromCallable<T> extends Maybe<T> implements Supplier<T> {

    /* renamed from: a */
    public final Callable f19171a;

    public MaybeFromCallable(Callable<? extends T> callable) {
        this.f19171a = callable;
    }

    @Override // io.reactivex.rxjava3.functions.Supplier
    public T get() {
        return (T) this.f19171a.call();
    }

    @Override // io.reactivex.rxjava3.core.Maybe
    public void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        Disposable m4920b = g50.m4920b();
        maybeObserver.onSubscribe(m4920b);
        if (!m4920b.isDisposed()) {
            try {
                AbstractC0002a1 abstractC0002a1 = (Object) this.f19171a.call();
                if (!m4920b.isDisposed()) {
                    if (abstractC0002a1 == null) {
                        maybeObserver.onComplete();
                    } else {
                        maybeObserver.onSuccess(abstractC0002a1);
                    }
                }
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                if (!m4920b.isDisposed()) {
                    maybeObserver.onError(th);
                } else {
                    RxJavaPlugins.onError(th);
                }
            }
        }
    }
}
