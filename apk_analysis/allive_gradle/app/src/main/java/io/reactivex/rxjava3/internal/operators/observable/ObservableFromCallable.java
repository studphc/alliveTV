package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.observers.DeferredScalarDisposable;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.Callable;

/* loaded from: classes2.dex */
public final class ObservableFromCallable<T> extends Observable<T> implements Supplier<T> {

    /* renamed from: a */
    public final Callable f19436a;

    public ObservableFromCallable(Callable<? extends T> callable) {
        this.f19436a = callable;
    }

    @Override // io.reactivex.rxjava3.functions.Supplier
    public T get() {
        return (T) ExceptionHelper.nullCheck(this.f19436a.call(), "The Callable returned a null value.");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.reactivex.rxjava3.core.Observable
    public void subscribeActual(Observer<? super T> observer) {
        DeferredScalarDisposable deferredScalarDisposable = new DeferredScalarDisposable(observer);
        observer.onSubscribe(deferredScalarDisposable);
        if (deferredScalarDisposable.isDisposed()) {
            return;
        }
        try {
            deferredScalarDisposable.complete(ExceptionHelper.nullCheck(this.f19436a.call(), "Callable returned a null value."));
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            if (!deferredScalarDisposable.isDisposed()) {
                observer.onError(th);
            } else {
                RxJavaPlugins.onError(th);
            }
        }
    }
}
