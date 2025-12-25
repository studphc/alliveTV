package io.reactivex.rxjava3.internal.observers;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.CompositeException;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;

/* loaded from: classes2.dex */
public final class SafeMaybeObserver<T> implements MaybeObserver<T> {

    /* renamed from: a */
    public final MaybeObserver f18635a;

    /* renamed from: b */
    public boolean f18636b;

    public SafeMaybeObserver(MaybeObserver<? super T> maybeObserver) {
        this.f18635a = maybeObserver;
    }

    @Override // io.reactivex.rxjava3.core.MaybeObserver
    public void onComplete() {
        if (!this.f18636b) {
            try {
                this.f18635a.onComplete();
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                RxJavaPlugins.onError(th);
            }
        }
    }

    @Override // io.reactivex.rxjava3.core.MaybeObserver
    public void onError(@NonNull Throwable th) {
        if (this.f18636b) {
            RxJavaPlugins.onError(th);
            return;
        }
        try {
            this.f18635a.onError(th);
        } catch (Throwable th2) {
            Exceptions.throwIfFatal(th2);
            RxJavaPlugins.onError(new CompositeException(th, th2));
        }
    }

    @Override // io.reactivex.rxjava3.core.MaybeObserver
    public void onSubscribe(@NonNull Disposable disposable) {
        try {
            this.f18635a.onSubscribe(disposable);
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            this.f18636b = true;
            disposable.dispose();
            RxJavaPlugins.onError(th);
        }
    }

    @Override // io.reactivex.rxjava3.core.MaybeObserver
    public void onSuccess(@NonNull T t) {
        if (!this.f18636b) {
            try {
                this.f18635a.onSuccess(t);
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                RxJavaPlugins.onError(th);
            }
        }
    }
}
