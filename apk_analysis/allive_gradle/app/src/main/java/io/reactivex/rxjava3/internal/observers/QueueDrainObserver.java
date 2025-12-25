package io.reactivex.rxjava3.internal.observers;

import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.util.ObservableQueueDrain;
import io.reactivex.rxjava3.internal.util.QueueDrainHelper;
import io.reactivex.rxjava3.operators.SimplePlainQueue;
import java.util.concurrent.atomic.AtomicInteger;
import p000.p63;

/* loaded from: classes2.dex */
public abstract class QueueDrainObserver<T, U, V> extends p63 implements Observer<T>, ObservableQueueDrain<U, V> {
    protected volatile boolean cancelled;
    protected volatile boolean done;
    protected final Observer<? super V> downstream;
    protected Throwable error;

    /* renamed from: f */
    public final AtomicInteger f18630f = new AtomicInteger();
    protected final SimplePlainQueue<U> queue;

    public QueueDrainObserver(Observer<? super V> observer, SimplePlainQueue<U> simplePlainQueue) {
        this.downstream = observer;
        this.queue = simplePlainQueue;
    }

    @Override // io.reactivex.rxjava3.internal.util.ObservableQueueDrain
    public void accept(Observer<? super V> observer, U u) {
    }

    @Override // io.reactivex.rxjava3.internal.util.ObservableQueueDrain
    public final boolean cancelled() {
        return this.cancelled;
    }

    @Override // io.reactivex.rxjava3.internal.util.ObservableQueueDrain
    public final boolean done() {
        return this.done;
    }

    @Override // io.reactivex.rxjava3.internal.util.ObservableQueueDrain
    public final boolean enter() {
        if (this.f18630f.getAndIncrement() == 0) {
            return true;
        }
        return false;
    }

    @Override // io.reactivex.rxjava3.internal.util.ObservableQueueDrain
    public final Throwable error() {
        return this.error;
    }

    public final void fastPathEmit(U u, boolean z, Disposable disposable) {
        Observer<? super V> observer = this.downstream;
        SimplePlainQueue<U> simplePlainQueue = this.queue;
        AtomicInteger atomicInteger = this.f18630f;
        if (atomicInteger.get() == 0 && atomicInteger.compareAndSet(0, 1)) {
            accept(observer, u);
            if (leave(-1) == 0) {
                return;
            }
        } else {
            simplePlainQueue.offer(u);
            if (!enter()) {
                return;
            }
        }
        QueueDrainHelper.drainLoop(simplePlainQueue, observer, z, disposable, this);
    }

    public final void fastPathOrderedEmit(U u, boolean z, Disposable disposable) {
        Observer<? super V> observer = this.downstream;
        SimplePlainQueue<U> simplePlainQueue = this.queue;
        AtomicInteger atomicInteger = this.f18630f;
        if (atomicInteger.get() == 0 && atomicInteger.compareAndSet(0, 1)) {
            if (simplePlainQueue.isEmpty()) {
                accept(observer, u);
                if (leave(-1) == 0) {
                    return;
                }
            } else {
                simplePlainQueue.offer(u);
            }
        } else {
            simplePlainQueue.offer(u);
            if (!enter()) {
                return;
            }
        }
        QueueDrainHelper.drainLoop(simplePlainQueue, observer, z, disposable, this);
    }

    @Override // io.reactivex.rxjava3.internal.util.ObservableQueueDrain
    public final int leave(int i) {
        return this.f18630f.addAndGet(i);
    }
}
