package p000;

import io.reactivex.rxjava3.core.ObservableEmitter;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Cancellable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import io.reactivex.rxjava3.operators.SpscLinkedArrayQueue;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes2.dex */
public final class av1 extends AtomicInteger implements ObservableEmitter {
    private static final long serialVersionUID = 4883307006032401862L;

    /* renamed from: a */
    public final zu1 f7752a;

    /* renamed from: b */
    public final AtomicThrowable f7753b = new AtomicThrowable();

    /* renamed from: c */
    public final SpscLinkedArrayQueue f7754c = new SpscLinkedArrayQueue(16);

    /* renamed from: d */
    public volatile boolean f7755d;

    public av1(zu1 zu1Var) {
        this.f7752a = zu1Var;
    }

    /* renamed from: a */
    public final void m1969a() {
        boolean z;
        zu1 zu1Var = this.f7752a;
        SpscLinkedArrayQueue spscLinkedArrayQueue = this.f7754c;
        AtomicThrowable atomicThrowable = this.f7753b;
        int i = 1;
        while (!zu1Var.isDisposed()) {
            if (atomicThrowable.get() != null) {
                spscLinkedArrayQueue.clear();
                atomicThrowable.tryTerminateConsumer(zu1Var);
                return;
            }
            boolean z2 = this.f7755d;
            Object poll = spscLinkedArrayQueue.poll();
            if (poll == null) {
                z = true;
            } else {
                z = false;
            }
            if (z2 && z) {
                zu1Var.onComplete();
                return;
            } else if (z) {
                i = addAndGet(-i);
                if (i == 0) {
                    return;
                }
            } else {
                zu1Var.onNext(poll);
            }
        }
        spscLinkedArrayQueue.clear();
    }

    @Override // io.reactivex.rxjava3.core.ObservableEmitter
    public final boolean isDisposed() {
        return this.f7752a.isDisposed();
    }

    @Override // io.reactivex.rxjava3.core.Emitter
    public final void onComplete() {
        if (!this.f7755d && !this.f7752a.isDisposed()) {
            this.f7755d = true;
            if (getAndIncrement() == 0) {
                m1969a();
            }
        }
    }

    @Override // io.reactivex.rxjava3.core.Emitter
    public final void onError(Throwable th) {
        if (!tryOnError(th)) {
            RxJavaPlugins.onError(th);
        }
    }

    @Override // io.reactivex.rxjava3.core.Emitter
    public final void onNext(Object obj) {
        if (!this.f7755d && !this.f7752a.isDisposed()) {
            if (obj == null) {
                onError(ExceptionHelper.createNullPointerException("onNext called with a null value."));
                return;
            }
            if (get() == 0 && compareAndSet(0, 1)) {
                this.f7752a.onNext(obj);
                if (decrementAndGet() == 0) {
                    return;
                }
            } else {
                SpscLinkedArrayQueue spscLinkedArrayQueue = this.f7754c;
                synchronized (spscLinkedArrayQueue) {
                    spscLinkedArrayQueue.offer(obj);
                }
                if (getAndIncrement() != 0) {
                    return;
                }
            }
            m1969a();
        }
    }

    @Override // io.reactivex.rxjava3.core.ObservableEmitter
    public final void setCancellable(Cancellable cancellable) {
        this.f7752a.setCancellable(cancellable);
    }

    @Override // io.reactivex.rxjava3.core.ObservableEmitter
    public final void setDisposable(Disposable disposable) {
        zu1 zu1Var = this.f7752a;
        zu1Var.getClass();
        DisposableHelper.set(zu1Var, disposable);
    }

    @Override // java.util.concurrent.atomic.AtomicInteger
    public final String toString() {
        return this.f7752a.toString();
    }

    @Override // io.reactivex.rxjava3.core.ObservableEmitter
    public final boolean tryOnError(Throwable th) {
        if (!this.f7755d && !this.f7752a.isDisposed()) {
            if (th == null) {
                th = ExceptionHelper.createNullPointerException("onError called with a null Throwable.");
            }
            if (this.f7753b.tryAddThrowable(th)) {
                this.f7755d = true;
                if (getAndIncrement() == 0) {
                    m1969a();
                }
                return true;
            }
        }
        return false;
    }

    @Override // io.reactivex.rxjava3.core.ObservableEmitter
    public final ObservableEmitter serialize() {
        return this;
    }
}
