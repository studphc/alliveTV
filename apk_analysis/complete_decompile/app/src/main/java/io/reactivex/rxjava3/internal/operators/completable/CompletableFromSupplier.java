package io.reactivex.rxjava3.internal.operators.completable;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import p000.g50;

/* loaded from: classes2.dex */
public final class CompletableFromSupplier extends Completable {

    /* renamed from: a */
    public final Supplier f18675a;

    public CompletableFromSupplier(Supplier<?> supplier) {
        this.f18675a = supplier;
    }

    @Override // io.reactivex.rxjava3.core.Completable
    public void subscribeActual(CompletableObserver completableObserver) {
        Disposable m4920b = g50.m4920b();
        completableObserver.onSubscribe(m4920b);
        try {
            this.f18675a.get();
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
