package io.reactivex.rxjava3.internal.operators.completable;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import p000.g50;

/* loaded from: classes2.dex */
public final class CompletableFromRunnable extends Completable {

    /* renamed from: a */
    public final Runnable f18673a;

    public CompletableFromRunnable(Runnable runnable) {
        this.f18673a = runnable;
    }

    @Override // io.reactivex.rxjava3.core.Completable
    public void subscribeActual(CompletableObserver completableObserver) {
        Disposable m4920b = g50.m4920b();
        completableObserver.onSubscribe(m4920b);
        if (!m4920b.isDisposed()) {
            try {
                this.f18673a.run();
                if (!m4920b.isDisposed()) {
                    completableObserver.onComplete();
                }
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                if (!m4920b.isDisposed()) {
                    completableObserver.onError(th);
                } else {
                    RxJavaPlugins.onError(th);
                }
            }
        }
    }
}
