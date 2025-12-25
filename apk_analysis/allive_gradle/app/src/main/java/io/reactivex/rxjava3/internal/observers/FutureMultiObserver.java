package io.reactivex.rxjava3.internal.observers;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.util.BlockingHelper;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class FutureMultiObserver<T> extends CountDownLatch implements MaybeObserver<T>, SingleObserver<T>, CompletableObserver, Future<T>, Disposable {

    /* renamed from: a */
    public Object f18615a;

    /* renamed from: b */
    public Throwable f18616b;

    /* renamed from: c */
    public final AtomicReference f18617c;

    public FutureMultiObserver() {
        super(1);
        this.f18617c = new AtomicReference();
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean z) {
        DisposableHelper disposableHelper;
        while (true) {
            AtomicReference atomicReference = this.f18617c;
            Disposable disposable = (Disposable) atomicReference.get();
            if (disposable == this || disposable == (disposableHelper = DisposableHelper.DISPOSED)) {
                return false;
            }
            while (!atomicReference.compareAndSet(disposable, disposableHelper)) {
                if (atomicReference.get() != disposable) {
                    break;
                }
            }
            if (disposable != null) {
                disposable.dispose();
            }
            countDown();
            return true;
        }
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public void dispose() {
    }

    @Override // java.util.concurrent.Future
    public T get() {
        if (getCount() != 0) {
            BlockingHelper.verifyNonBlocking();
            await();
        }
        if (!isCancelled()) {
            Throwable th = this.f18616b;
            if (th == null) {
                return (T) this.f18615a;
            }
            throw new ExecutionException(th);
        }
        throw new CancellationException();
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        return DisposableHelper.isDisposed((Disposable) this.f18617c.get());
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public boolean isDisposed() {
        return isDone();
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        if (getCount() == 0) {
            return true;
        }
        return false;
    }

    @Override // io.reactivex.rxjava3.core.MaybeObserver
    public void onComplete() {
        AtomicReference atomicReference = this.f18617c;
        Disposable disposable = (Disposable) atomicReference.get();
        if (disposable == DisposableHelper.DISPOSED) {
            return;
        }
        while (!atomicReference.compareAndSet(disposable, this) && atomicReference.get() == disposable) {
        }
        countDown();
    }

    @Override // io.reactivex.rxjava3.core.MaybeObserver
    public void onError(Throwable th) {
        while (true) {
            AtomicReference atomicReference = this.f18617c;
            Disposable disposable = (Disposable) atomicReference.get();
            if (disposable == DisposableHelper.DISPOSED) {
                RxJavaPlugins.onError(th);
                return;
            }
            this.f18616b = th;
            while (!atomicReference.compareAndSet(disposable, this)) {
                if (atomicReference.get() != disposable) {
                    break;
                }
            }
            countDown();
            return;
        }
    }

    @Override // io.reactivex.rxjava3.core.MaybeObserver
    public void onSubscribe(Disposable disposable) {
        DisposableHelper.setOnce(this.f18617c, disposable);
    }

    @Override // io.reactivex.rxjava3.core.MaybeObserver
    public void onSuccess(T t) {
        AtomicReference atomicReference = this.f18617c;
        Disposable disposable = (Disposable) atomicReference.get();
        if (disposable == DisposableHelper.DISPOSED) {
            return;
        }
        this.f18615a = t;
        while (!atomicReference.compareAndSet(disposable, this) && atomicReference.get() == disposable) {
        }
        countDown();
    }

    @Override // java.util.concurrent.Future
    public T get(long j, @NonNull TimeUnit timeUnit) {
        if (getCount() != 0) {
            BlockingHelper.verifyNonBlocking();
            if (!await(j, timeUnit)) {
                throw new TimeoutException(ExceptionHelper.timeoutMessage(j, timeUnit));
            }
        }
        if (!isCancelled()) {
            Throwable th = this.f18616b;
            if (th == null) {
                return (T) this.f18615a;
            }
            throw new ExecutionException(th);
        }
        throw new CancellationException();
    }
}
