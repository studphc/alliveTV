package io.reactivex.rxjava3.internal.operators.single;

import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Objects;
import java.util.concurrent.Callable;
import p000.AbstractC0002a1;
import p000.g50;

/* loaded from: classes2.dex */
public final class SingleFromCallable<T> extends Single<T> {

    /* renamed from: a */
    public final Callable f19779a;

    public SingleFromCallable(Callable<? extends T> callable) {
        this.f19779a = callable;
    }

    @Override // io.reactivex.rxjava3.core.Single
    public void subscribeActual(SingleObserver<? super T> singleObserver) {
        Disposable m4920b = g50.m4920b();
        singleObserver.onSubscribe(m4920b);
        if (m4920b.isDisposed()) {
            return;
        }
        try {
            AbstractC0002a1 abstractC0002a1 = (Object) this.f19779a.call();
            Objects.requireNonNull(abstractC0002a1, "The callable returned a null value");
            if (!m4920b.isDisposed()) {
                singleObserver.onSuccess(abstractC0002a1);
            }
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            if (!m4920b.isDisposed()) {
                singleObserver.onError(th);
            } else {
                RxJavaPlugins.onError(th);
            }
        }
    }
}
