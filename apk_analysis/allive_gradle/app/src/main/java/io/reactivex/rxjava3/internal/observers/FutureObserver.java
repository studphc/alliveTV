package io.reactivex.rxjava3.internal.observers;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.util.BlockingHelper;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.NoSuchElementException;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class FutureObserver<T> extends CountDownLatch implements Observer<T>, Future<T>, Disposable {

    /* renamed from: a */
    public Object f18618a;

    /* renamed from: b */
    public Throwable f18619b;

    /* renamed from: c */
    public final AtomicReference f18620c;

    public FutureObserver() {
        super(1);
        this.f18620c = new AtomicReference();
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean z) {
        DisposableHelper disposableHelper;
        while (true) {
            AtomicReference atomicReference = this.f18620c;
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
            Throwable th = this.f18619b;
            if (th == null) {
                return (T) this.f18618a;
            }
            throw new ExecutionException(th);
        }
        throw new CancellationException();
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        return DisposableHelper.isDisposed((Disposable) this.f18620c.get());
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

    @Override // io.reactivex.rxjava3.core.Observer
    public void onComplete() {
        if (this.f18618a == null) {
            onError(new NoSuchElementException("The source is empty"));
            return;
        }
        AtomicReference atomicReference = this.f18620c;
        Disposable disposable = (Disposable) atomicReference.get();
        if (disposable == this || disposable == DisposableHelper.DISPOSED) {
            return;
        }
        while (!atomicReference.compareAndSet(disposable, this)) {
            if (atomicReference.get() != disposable) {
                return;
            }
        }
        countDown();
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0022, code lost:
    
        if (r0.get() == r1) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0018, code lost:
    
        r3.f18619b = r4;
        countDown();
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x001d, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x0010, code lost:
    
        if (r1 != io.reactivex.rxjava3.internal.disposables.DisposableHelper.DISPOSED) goto L8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0016, code lost:
    
        if (r0.compareAndSet(r1, r3) == false) goto L12;
     */
    @Override // io.reactivex.rxjava3.core.Observer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onError(Throwable th) {
        if (this.f18619b == null) {
            AtomicReference atomicReference = this.f18620c;
            Disposable disposable = (Disposable) atomicReference.get();
            if (disposable != this) {
            }
        }
        RxJavaPlugins.onError(th);
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public void onNext(T t) {
        if (this.f18618a != null) {
            ((Disposable) this.f18620c.get()).dispose();
            onError(new IndexOutOfBoundsException("More than one element received"));
        } else {
            this.f18618a = t;
        }
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public void onSubscribe(Disposable disposable) {
        DisposableHelper.setOnce(this.f18620c, disposable);
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
            Throwable th = this.f18619b;
            if (th == null) {
                return (T) this.f18618a;
            }
            throw new ExecutionException(th);
        }
        throw new CancellationException();
    }
}
