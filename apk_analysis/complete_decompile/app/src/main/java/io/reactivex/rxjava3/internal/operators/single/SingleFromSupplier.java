package io.reactivex.rxjava3.internal.operators.single;

import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Objects;
import p000.AbstractC0002a1;
import p000.g50;

/* loaded from: classes2.dex */
public final class SingleFromSupplier<T> extends Single<T> {

    /* renamed from: a */
    public final Supplier f19781a;

    public SingleFromSupplier(Supplier<? extends T> supplier) {
        this.f19781a = supplier;
    }

    @Override // io.reactivex.rxjava3.core.Single
    public void subscribeActual(SingleObserver<? super T> singleObserver) {
        Disposable m4920b = g50.m4920b();
        singleObserver.onSubscribe(m4920b);
        if (m4920b.isDisposed()) {
            return;
        }
        try {
            AbstractC0002a1 abstractC0002a1 = (Object) this.f19781a.get();
            Objects.requireNonNull(abstractC0002a1, "The supplier returned a null value");
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
