package io.reactivex.rxjava3.internal.observers;

import io.reactivex.rxjava3.annotations.Nullable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;

/* loaded from: classes2.dex */
public class DeferredScalarDisposable<T> extends BasicIntQueueDisposable<T> {
    private static final long serialVersionUID = -5502432239815349361L;
    protected final Observer<? super T> downstream;
    protected T value;

    public DeferredScalarDisposable(Observer<? super T> observer) {
        this.downstream = observer;
    }

    @Override // io.reactivex.rxjava3.operators.SimpleQueue
    public final void clear() {
        lazySet(32);
        this.value = null;
    }

    public final void complete(T t) {
        int i = get();
        if ((i & 54) != 0) {
            return;
        }
        Observer<? super T> observer = this.downstream;
        if (i == 8) {
            this.value = t;
            lazySet(16);
            observer.onNext(null);
        } else {
            lazySet(2);
            observer.onNext(t);
        }
        if (get() != 4) {
            observer.onComplete();
        }
    }

    public void dispose() {
        set(4);
        this.value = null;
    }

    public final void error(Throwable th) {
        if ((get() & 54) != 0) {
            RxJavaPlugins.onError(th);
        } else {
            lazySet(2);
            this.downstream.onError(th);
        }
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final boolean isDisposed() {
        if (get() == 4) {
            return true;
        }
        return false;
    }

    @Override // io.reactivex.rxjava3.operators.SimpleQueue
    public final boolean isEmpty() {
        if (get() != 16) {
            return true;
        }
        return false;
    }

    public void onComplete() {
        complete();
    }

    public void onError(Throwable th) {
        error(th);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onSuccess(Object obj) {
        complete(obj);
    }

    @Override // io.reactivex.rxjava3.operators.SimpleQueue
    @Nullable
    public final T poll() {
        if (get() != 16) {
            return null;
        }
        T t = this.value;
        this.value = null;
        lazySet(32);
        return t;
    }

    @Override // io.reactivex.rxjava3.operators.QueueFuseable
    public final int requestFusion(int i) {
        if ((i & 2) != 0) {
            lazySet(8);
            return 2;
        }
        return 0;
    }

    public final boolean tryDispose() {
        if (getAndSet(4) != 4) {
            return true;
        }
        return false;
    }

    public final void complete() {
        if ((get() & 54) != 0) {
            return;
        }
        lazySet(2);
        this.downstream.onComplete();
    }
}
