package io.reactivex.rxjava3.internal.operators.maybe;

import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import p000.g50;

/* loaded from: classes2.dex */
public final class MaybeFromRunnable<T> extends Maybe<T> implements Supplier<T> {

    /* renamed from: a */
    public final Runnable f19176a;

    public MaybeFromRunnable(Runnable runnable) {
        this.f19176a = runnable;
    }

    @Override // io.reactivex.rxjava3.functions.Supplier
    public T get() {
        this.f19176a.run();
        return null;
    }

    @Override // io.reactivex.rxjava3.core.Maybe
    public void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        Disposable m4920b = g50.m4920b();
        maybeObserver.onSubscribe(m4920b);
        if (!m4920b.isDisposed()) {
            try {
                this.f19176a.run();
                if (!m4920b.isDisposed()) {
                    maybeObserver.onComplete();
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
