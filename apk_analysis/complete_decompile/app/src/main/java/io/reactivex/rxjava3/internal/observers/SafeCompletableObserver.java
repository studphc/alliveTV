package io.reactivex.rxjava3.internal.observers;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.CompositeException;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;

/* loaded from: classes2.dex */
public final class SafeCompletableObserver implements CompletableObserver {

    /* renamed from: a */
    public final CompletableObserver f18633a;

    /* renamed from: b */
    public boolean f18634b;

    public SafeCompletableObserver(CompletableObserver completableObserver) {
        this.f18633a = completableObserver;
    }

    @Override // io.reactivex.rxjava3.core.CompletableObserver
    public void onComplete() {
        if (!this.f18634b) {
            try {
                this.f18633a.onComplete();
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                RxJavaPlugins.onError(th);
            }
        }
    }

    @Override // io.reactivex.rxjava3.core.CompletableObserver
    public void onError(@NonNull Throwable th) {
        if (this.f18634b) {
            RxJavaPlugins.onError(th);
            return;
        }
        try {
            this.f18633a.onError(th);
        } catch (Throwable th2) {
            Exceptions.throwIfFatal(th2);
            RxJavaPlugins.onError(new CompositeException(th, th2));
        }
    }

    @Override // io.reactivex.rxjava3.core.CompletableObserver
    public void onSubscribe(@NonNull Disposable disposable) {
        try {
            this.f18633a.onSubscribe(disposable);
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            this.f18634b = true;
            disposable.dispose();
            RxJavaPlugins.onError(th);
        }
    }
}
