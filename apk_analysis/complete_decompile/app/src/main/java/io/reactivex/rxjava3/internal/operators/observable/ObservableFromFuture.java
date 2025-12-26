package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.internal.observers.DeferredScalarDisposable;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public final class ObservableFromFuture<T> extends Observable<T> {

    /* renamed from: a */
    public final Future f19440a;

    /* renamed from: b */
    public final long f19441b;

    /* renamed from: c */
    public final TimeUnit f19442c;

    public ObservableFromFuture(Future<? extends T> future, long j, TimeUnit timeUnit) {
        this.f19440a = future;
        this.f19441b = j;
        this.f19442c = timeUnit;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.reactivex.rxjava3.core.Observable
    public void subscribeActual(Observer<? super T> observer) {
        Object obj;
        DeferredScalarDisposable deferredScalarDisposable = new DeferredScalarDisposable(observer);
        observer.onSubscribe(deferredScalarDisposable);
        if (!deferredScalarDisposable.isDisposed()) {
            try {
                TimeUnit timeUnit = this.f19442c;
                Future future = this.f19440a;
                if (timeUnit != null) {
                    obj = future.get(this.f19441b, timeUnit);
                } else {
                    obj = future.get();
                }
                deferredScalarDisposable.complete(ExceptionHelper.nullCheck(obj, "Future returned a null value."));
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                if (!deferredScalarDisposable.isDisposed()) {
                    observer.onError(th);
                }
            }
        }
    }
}
