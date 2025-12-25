package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.fuseable.CancellableQueueFuseable;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;

/* loaded from: classes2.dex */
public final class ObservableFromRunnable<T> extends Observable<T> implements Supplier<T> {

    /* renamed from: a */
    public final Runnable f19445a;

    public ObservableFromRunnable(Runnable runnable) {
        this.f19445a = runnable;
    }

    @Override // io.reactivex.rxjava3.functions.Supplier
    public T get() {
        this.f19445a.run();
        return null;
    }

    @Override // io.reactivex.rxjava3.core.Observable
    public void subscribeActual(Observer<? super T> observer) {
        CancellableQueueFuseable cancellableQueueFuseable = new CancellableQueueFuseable();
        observer.onSubscribe(cancellableQueueFuseable);
        if (!cancellableQueueFuseable.isDisposed()) {
            try {
                this.f19445a.run();
                if (!cancellableQueueFuseable.isDisposed()) {
                    observer.onComplete();
                }
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                if (!cancellableQueueFuseable.isDisposed()) {
                    observer.onError(th);
                } else {
                    RxJavaPlugins.onError(th);
                }
            }
        }
    }
}
