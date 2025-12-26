package io.reactivex.rxjava3.internal.observers;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.CompositeException;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;

/* loaded from: classes2.dex */
public final class SafeSingleObserver<T> implements SingleObserver<T> {

    /* renamed from: a */
    public final SingleObserver f18637a;

    /* renamed from: b */
    public boolean f18638b;

    public SafeSingleObserver(SingleObserver<? super T> singleObserver) {
        this.f18637a = singleObserver;
    }

    @Override // io.reactivex.rxjava3.core.SingleObserver
    public void onError(@NonNull Throwable th) {
        if (this.f18638b) {
            RxJavaPlugins.onError(th);
            return;
        }
        try {
            this.f18637a.onError(th);
        } catch (Throwable th2) {
            Exceptions.throwIfFatal(th2);
            RxJavaPlugins.onError(new CompositeException(th, th2));
        }
    }

    @Override // io.reactivex.rxjava3.core.SingleObserver
    public void onSubscribe(@NonNull Disposable disposable) {
        try {
            this.f18637a.onSubscribe(disposable);
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            this.f18638b = true;
            disposable.dispose();
            RxJavaPlugins.onError(th);
        }
    }

    @Override // io.reactivex.rxjava3.core.SingleObserver
    public void onSuccess(@NonNull T t) {
        if (!this.f18638b) {
            try {
                this.f18637a.onSuccess(t);
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                RxJavaPlugins.onError(th);
            }
        }
    }
}
