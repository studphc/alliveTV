package p000;

import io.reactivex.rxjava3.core.FlowableEmitter;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Cancellable;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import io.reactivex.rxjava3.operators.SpscLinkedArrayQueue;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes2.dex */
public final class uk0 extends AtomicInteger implements FlowableEmitter {
    private static final long serialVersionUID = 4883307006032401862L;

    /* renamed from: a */
    public final nk0 f27300a;

    /* renamed from: b */
    public final AtomicThrowable f27301b = new AtomicThrowable();

    /* renamed from: c */
    public final SpscLinkedArrayQueue f27302c = new SpscLinkedArrayQueue(16);

    /* renamed from: d */
    public volatile boolean f27303d;

    public uk0(nk0 nk0Var) {
        this.f27300a = nk0Var;
    }

    /* renamed from: a */
    public final void m7706a() {
        boolean z;
        nk0 nk0Var = this.f27300a;
        SpscLinkedArrayQueue spscLinkedArrayQueue = this.f27302c;
        AtomicThrowable atomicThrowable = this.f27301b;
        int i = 1;
        while (!nk0Var.f23386b.isDisposed()) {
            if (atomicThrowable.get() != null) {
                spscLinkedArrayQueue.clear();
                atomicThrowable.tryTerminateConsumer(nk0Var);
                return;
            }
            boolean z2 = this.f27303d;
            T poll = spscLinkedArrayQueue.poll();
            if (poll == 0) {
                z = true;
            } else {
                z = false;
            }
            if (z2 && z) {
                nk0Var.onComplete();
                return;
            } else if (z) {
                i = addAndGet(-i);
                if (i == 0) {
                    return;
                }
            } else {
                nk0Var.onNext(poll);
            }
        }
        spscLinkedArrayQueue.clear();
    }

    @Override // io.reactivex.rxjava3.core.FlowableEmitter
    public final boolean isCancelled() {
        return this.f27300a.f23386b.isDisposed();
    }

    @Override // io.reactivex.rxjava3.core.Emitter
    public final void onComplete() {
        if (!this.f27300a.f23386b.isDisposed() && !this.f27303d) {
            this.f27303d = true;
            if (getAndIncrement() == 0) {
                m7706a();
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
        if (!this.f27300a.f23386b.isDisposed() && !this.f27303d) {
            if (obj == null) {
                onError(ExceptionHelper.createNullPointerException("onNext called with a null value."));
                return;
            }
            if (get() == 0 && compareAndSet(0, 1)) {
                this.f27300a.onNext(obj);
                if (decrementAndGet() == 0) {
                    return;
                }
            } else {
                SpscLinkedArrayQueue spscLinkedArrayQueue = this.f27302c;
                synchronized (spscLinkedArrayQueue) {
                    spscLinkedArrayQueue.offer(obj);
                }
                if (getAndIncrement() != 0) {
                    return;
                }
            }
            m7706a();
        }
    }

    @Override // io.reactivex.rxjava3.core.FlowableEmitter
    public final long requested() {
        return this.f27300a.get();
    }

    @Override // io.reactivex.rxjava3.core.FlowableEmitter
    public final void setCancellable(Cancellable cancellable) {
        this.f27300a.setCancellable(cancellable);
    }

    @Override // io.reactivex.rxjava3.core.FlowableEmitter
    public final void setDisposable(Disposable disposable) {
        this.f27300a.setDisposable(disposable);
    }

    @Override // java.util.concurrent.atomic.AtomicInteger
    public final String toString() {
        return this.f27300a.toString();
    }

    @Override // io.reactivex.rxjava3.core.FlowableEmitter
    public final boolean tryOnError(Throwable th) {
        if (!this.f27300a.f23386b.isDisposed() && !this.f27303d) {
            if (th == null) {
                th = ExceptionHelper.createNullPointerException("onError called with a null Throwable.");
            }
            if (this.f27301b.tryAddThrowable(th)) {
                this.f27303d = true;
                if (getAndIncrement() == 0) {
                    m7706a();
                }
                return true;
            }
        }
        return false;
    }

    @Override // io.reactivex.rxjava3.core.FlowableEmitter
    public final FlowableEmitter serialize() {
        return this;
    }
}
