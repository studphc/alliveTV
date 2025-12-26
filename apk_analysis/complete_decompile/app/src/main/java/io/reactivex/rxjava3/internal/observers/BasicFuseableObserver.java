package io.reactivex.rxjava3.internal.observers;

import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.operators.QueueDisposable;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;

/* loaded from: classes2.dex */
public abstract class BasicFuseableObserver<T, R> implements Observer<T>, QueueDisposable<R> {
    protected boolean done;
    protected final Observer<? super R> downstream;

    /* renamed from: qd */
    protected QueueDisposable<T> f18587qd;
    protected int sourceMode;
    protected Disposable upstream;

    public BasicFuseableObserver(Observer<? super R> observer) {
        this.downstream = observer;
    }

    public void afterDownstream() {
    }

    public boolean beforeDownstream() {
        return true;
    }

    @Override // io.reactivex.rxjava3.operators.SimpleQueue
    public void clear() {
        this.f18587qd.clear();
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public void dispose() {
        this.upstream.dispose();
    }

    public final void fail(Throwable th) {
        Exceptions.throwIfFatal(th);
        this.upstream.dispose();
        onError(th);
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public boolean isDisposed() {
        return this.upstream.isDisposed();
    }

    @Override // io.reactivex.rxjava3.operators.SimpleQueue
    public boolean isEmpty() {
        return this.f18587qd.isEmpty();
    }

    @Override // io.reactivex.rxjava3.operators.SimpleQueue, java.util.Queue
    public final boolean offer(R r) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public void onComplete() {
        if (this.done) {
            return;
        }
        this.done = true;
        this.downstream.onComplete();
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public void onError(Throwable th) {
        if (this.done) {
            RxJavaPlugins.onError(th);
        } else {
            this.done = true;
            this.downstream.onError(th);
        }
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onSubscribe(Disposable disposable) {
        if (DisposableHelper.validate(this.upstream, disposable)) {
            this.upstream = disposable;
            if (disposable instanceof QueueDisposable) {
                this.f18587qd = (QueueDisposable) disposable;
            }
            if (beforeDownstream()) {
                this.downstream.onSubscribe(this);
                afterDownstream();
            }
        }
    }

    @Override // io.reactivex.rxjava3.operators.QueueFuseable
    public int requestFusion(int i) {
        return transitiveBoundaryFusion(i);
    }

    public final int transitiveBoundaryFusion(int i) {
        QueueDisposable<T> queueDisposable = this.f18587qd;
        if (queueDisposable != null && (i & 4) == 0) {
            int requestFusion = queueDisposable.requestFusion(i);
            if (requestFusion != 0) {
                this.sourceMode = requestFusion;
            }
            return requestFusion;
        }
        return 0;
    }

    @Override // io.reactivex.rxjava3.operators.SimpleQueue
    public final boolean offer(R r, R r2) {
        throw new UnsupportedOperationException("Should not be called!");
    }
}
