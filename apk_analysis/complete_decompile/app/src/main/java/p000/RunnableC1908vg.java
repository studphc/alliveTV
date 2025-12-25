package p000;

import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.MissingBackpressureException;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.BlockingHelper;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import io.reactivex.rxjava3.operators.SpscArrayQueue;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import org.reactivestreams.Subscription;

/* renamed from: vg */
/* loaded from: classes2.dex */
public final class RunnableC1908vg extends AtomicReference implements FlowableSubscriber, Iterator, Runnable, Disposable {
    private static final long serialVersionUID = 6695226475494099826L;

    /* renamed from: a */
    public final SpscArrayQueue f27764a;

    /* renamed from: b */
    public final long f27765b;

    /* renamed from: c */
    public final long f27766c;

    /* renamed from: d */
    public final ReentrantLock f27767d;

    /* renamed from: e */
    public final Condition f27768e;

    /* renamed from: f */
    public long f27769f;

    /* renamed from: g */
    public volatile boolean f27770g;

    /* renamed from: h */
    public volatile Throwable f27771h;

    public RunnableC1908vg(int i) {
        this.f27764a = new SpscArrayQueue(i);
        this.f27765b = i;
        this.f27766c = i - (i >> 2);
        ReentrantLock reentrantLock = new ReentrantLock();
        this.f27767d = reentrantLock;
        this.f27768e = reentrantLock.newCondition();
    }

    /* renamed from: a */
    public final void m7910a() {
        ReentrantLock reentrantLock = this.f27767d;
        reentrantLock.lock();
        try {
            this.f27768e.signalAll();
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final void dispose() {
        SubscriptionHelper.cancel(this);
        m7910a();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        while (!isDisposed()) {
            boolean z = this.f27770g;
            boolean isEmpty = this.f27764a.isEmpty();
            if (z) {
                Throwable th = this.f27771h;
                if (th == null) {
                    if (isEmpty) {
                        return false;
                    }
                } else {
                    throw ExceptionHelper.wrapOrThrow(th);
                }
            }
            if (isEmpty) {
                BlockingHelper.verifyNonBlocking();
                this.f27767d.lock();
                while (!this.f27770g && this.f27764a.isEmpty() && !isDisposed()) {
                    try {
                        try {
                            this.f27768e.await();
                        } catch (InterruptedException e) {
                            run();
                            throw ExceptionHelper.wrapOrThrow(e);
                        }
                    } finally {
                        this.f27767d.unlock();
                    }
                }
            } else {
                return true;
            }
        }
        Throwable th2 = this.f27771h;
        if (th2 == null) {
            return false;
        }
        throw ExceptionHelper.wrapOrThrow(th2);
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final boolean isDisposed() {
        if (get() == SubscriptionHelper.CANCELLED) {
            return true;
        }
        return false;
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (hasNext()) {
            Object poll = this.f27764a.poll();
            long j = this.f27769f + 1;
            if (j == this.f27766c) {
                this.f27769f = 0L;
                ((Subscription) get()).request(j);
            } else {
                this.f27769f = j;
            }
            return poll;
        }
        throw new NoSuchElementException();
    }

    @Override // org.reactivestreams.Subscriber
    public final void onComplete() {
        this.f27770g = true;
        m7910a();
    }

    @Override // org.reactivestreams.Subscriber
    public final void onError(Throwable th) {
        this.f27771h = th;
        this.f27770g = true;
        m7910a();
    }

    @Override // org.reactivestreams.Subscriber
    public final void onNext(Object obj) {
        if (!this.f27764a.offer(obj)) {
            SubscriptionHelper.cancel(this);
            onError(new MissingBackpressureException("Queue full?!"));
        } else {
            m7910a();
        }
    }

    @Override // io.reactivex.rxjava3.core.FlowableSubscriber, org.reactivestreams.Subscriber
    public final void onSubscribe(Subscription subscription) {
        SubscriptionHelper.setOnce(this, subscription, this.f27765b);
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("remove");
    }

    @Override // java.lang.Runnable
    public final void run() {
        SubscriptionHelper.cancel(this);
        m7910a();
    }
}
