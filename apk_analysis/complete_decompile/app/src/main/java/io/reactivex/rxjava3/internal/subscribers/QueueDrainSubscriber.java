package io.reactivex.rxjava3.internal.subscribers;

import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.MissingBackpressureException;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import io.reactivex.rxjava3.internal.util.QueueDrain;
import io.reactivex.rxjava3.internal.util.QueueDrainHelper;
import io.reactivex.rxjava3.operators.SimplePlainQueue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;
import p000.o63;

/* loaded from: classes2.dex */
public abstract class QueueDrainSubscriber<T, U, V> extends o63 implements FlowableSubscriber<T>, QueueDrain<U, V> {
    protected volatile boolean cancelled;
    protected volatile boolean done;
    protected final Subscriber<? super V> downstream;
    protected Throwable error;
    protected final SimplePlainQueue<U> queue;

    /* renamed from: u */
    public final AtomicInteger f19922u = new AtomicInteger();

    /* renamed from: v */
    public final AtomicLong f19923v = new AtomicLong();

    public QueueDrainSubscriber(Subscriber<? super V> subscriber, SimplePlainQueue<U> simplePlainQueue) {
        this.downstream = subscriber;
        this.queue = simplePlainQueue;
    }

    public boolean accept(Subscriber<? super V> subscriber, U u) {
        return false;
    }

    @Override // io.reactivex.rxjava3.internal.util.QueueDrain
    public final boolean cancelled() {
        return this.cancelled;
    }

    @Override // io.reactivex.rxjava3.internal.util.QueueDrain
    public final boolean done() {
        return this.done;
    }

    @Override // io.reactivex.rxjava3.internal.util.QueueDrain
    public final boolean enter() {
        if (this.f19922u.getAndIncrement() == 0) {
            return true;
        }
        return false;
    }

    @Override // io.reactivex.rxjava3.internal.util.QueueDrain
    public final Throwable error() {
        return this.error;
    }

    public final boolean fastEnter() {
        AtomicInteger atomicInteger = this.f19922u;
        if (atomicInteger.get() != 0 || !atomicInteger.compareAndSet(0, 1)) {
            return false;
        }
        return true;
    }

    public final void fastPathEmitMax(U u, boolean z, Disposable disposable) {
        Subscriber<? super V> subscriber = this.downstream;
        SimplePlainQueue<U> simplePlainQueue = this.queue;
        if (fastEnter()) {
            long j = this.f19923v.get();
            if (j != 0) {
                if (accept(subscriber, u) && j != Long.MAX_VALUE) {
                    produced(1L);
                }
                if (leave(-1) == 0) {
                    return;
                }
            } else {
                disposable.dispose();
                subscriber.onError(new MissingBackpressureException("Could not emit buffer due to lack of requests"));
                return;
            }
        } else {
            simplePlainQueue.offer(u);
            if (!enter()) {
                return;
            }
        }
        QueueDrainHelper.drainMaxLoop(simplePlainQueue, subscriber, z, disposable, this);
    }

    public final void fastPathOrderedEmitMax(U u, boolean z, Disposable disposable) {
        Subscriber<? super V> subscriber = this.downstream;
        SimplePlainQueue<U> simplePlainQueue = this.queue;
        if (fastEnter()) {
            long j = this.f19923v.get();
            if (j != 0) {
                if (simplePlainQueue.isEmpty()) {
                    if (accept(subscriber, u) && j != Long.MAX_VALUE) {
                        produced(1L);
                    }
                    if (leave(-1) == 0) {
                        return;
                    }
                } else {
                    simplePlainQueue.offer(u);
                }
            } else {
                this.cancelled = true;
                disposable.dispose();
                subscriber.onError(new MissingBackpressureException("Could not emit buffer due to lack of requests"));
                return;
            }
        } else {
            simplePlainQueue.offer(u);
            if (!enter()) {
                return;
            }
        }
        QueueDrainHelper.drainMaxLoop(simplePlainQueue, subscriber, z, disposable, this);
    }

    @Override // io.reactivex.rxjava3.internal.util.QueueDrain
    public final int leave(int i) {
        return this.f19922u.addAndGet(i);
    }

    @Override // io.reactivex.rxjava3.internal.util.QueueDrain
    public final long produced(long j) {
        return this.f19923v.addAndGet(-j);
    }

    public void request(long j) {
        requested(j);
    }

    @Override // io.reactivex.rxjava3.internal.util.QueueDrain
    public final long requested() {
        return this.f19923v.get();
    }

    public final void requested(long j) {
        if (SubscriptionHelper.validate(j)) {
            BackpressureHelper.add(this.f19923v, j);
        }
    }
}
