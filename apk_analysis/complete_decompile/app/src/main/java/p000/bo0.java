package p000;

import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.exceptions.MissingBackpressureException;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import io.reactivex.rxjava3.operators.SimplePlainQueue;
import io.reactivex.rxjava3.operators.SpscArrayQueue;
import io.reactivex.rxjava3.operators.SpscLinkedArrayQueue;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class bo0 extends BasicIntQueueSubscription implements FlowableSubscriber {
    private static final long serialVersionUID = -2514538129242366402L;

    /* renamed from: a */
    public final Subscriber f8107a;

    /* renamed from: b */
    public final SimplePlainQueue f8108b;

    /* renamed from: c */
    public final boolean f8109c;

    /* renamed from: d */
    public final Action f8110d;

    /* renamed from: e */
    public Subscription f8111e;

    /* renamed from: f */
    public volatile boolean f8112f;

    /* renamed from: g */
    public volatile boolean f8113g;

    /* renamed from: h */
    public Throwable f8114h;

    /* renamed from: i */
    public final AtomicLong f8115i = new AtomicLong();

    /* renamed from: j */
    public boolean f8116j;

    public bo0(Subscriber subscriber, int i, boolean z, boolean z2, Action action) {
        SimplePlainQueue spscArrayQueue;
        this.f8107a = subscriber;
        this.f8110d = action;
        this.f8109c = z2;
        if (z) {
            spscArrayQueue = new SpscLinkedArrayQueue(i);
        } else {
            spscArrayQueue = new SpscArrayQueue(i);
        }
        this.f8108b = spscArrayQueue;
    }

    @Override // org.reactivestreams.Subscription
    public final void cancel() {
        if (!this.f8112f) {
            this.f8112f = true;
            this.f8111e.cancel();
            if (!this.f8116j && getAndIncrement() == 0) {
                this.f8108b.clear();
            }
        }
    }

    @Override // io.reactivex.rxjava3.operators.SimpleQueue
    public final void clear() {
        this.f8108b.clear();
    }

    public final void drain() {
        boolean z;
        if (getAndIncrement() == 0) {
            SimplePlainQueue simplePlainQueue = this.f8108b;
            Subscriber subscriber = this.f8107a;
            int i = 1;
            while (!m2123e(subscriber, this.f8113g, simplePlainQueue.isEmpty())) {
                long j = this.f8115i.get();
                long j2 = 0;
                while (j2 != j) {
                    boolean z2 = this.f8113g;
                    Object poll = simplePlainQueue.poll();
                    if (poll == null) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (m2123e(subscriber, z2, z)) {
                        return;
                    }
                    if (z) {
                        break;
                    }
                    subscriber.onNext(poll);
                    j2++;
                }
                if (j2 == j && m2123e(subscriber, this.f8113g, simplePlainQueue.isEmpty())) {
                    return;
                }
                if (j2 != 0 && j != Long.MAX_VALUE) {
                    this.f8115i.addAndGet(-j2);
                }
                i = addAndGet(-i);
                if (i == 0) {
                    return;
                }
            }
        }
    }

    /* renamed from: e */
    public final boolean m2123e(Subscriber subscriber, boolean z, boolean z2) {
        if (this.f8112f) {
            this.f8108b.clear();
            return true;
        }
        if (z) {
            if (this.f8109c) {
                if (z2) {
                    Throwable th = this.f8114h;
                    if (th != null) {
                        subscriber.onError(th);
                    } else {
                        subscriber.onComplete();
                    }
                    return true;
                }
                return false;
            }
            Throwable th2 = this.f8114h;
            if (th2 != null) {
                this.f8108b.clear();
                subscriber.onError(th2);
                return true;
            }
            if (z2) {
                subscriber.onComplete();
                return true;
            }
            return false;
        }
        return false;
    }

    @Override // io.reactivex.rxjava3.operators.SimpleQueue
    public final boolean isEmpty() {
        return this.f8108b.isEmpty();
    }

    @Override // org.reactivestreams.Subscriber
    public final void onComplete() {
        this.f8113g = true;
        if (this.f8116j) {
            this.f8107a.onComplete();
        } else {
            drain();
        }
    }

    @Override // org.reactivestreams.Subscriber
    public final void onError(Throwable th) {
        this.f8114h = th;
        this.f8113g = true;
        if (this.f8116j) {
            this.f8107a.onError(th);
        } else {
            drain();
        }
    }

    @Override // org.reactivestreams.Subscriber
    public final void onNext(Object obj) {
        if (!this.f8108b.offer(obj)) {
            this.f8111e.cancel();
            MissingBackpressureException missingBackpressureException = new MissingBackpressureException("Buffer is full");
            try {
                this.f8110d.run();
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                missingBackpressureException.initCause(th);
            }
            onError(missingBackpressureException);
            return;
        }
        if (this.f8116j) {
            this.f8107a.onNext(null);
        } else {
            drain();
        }
    }

    @Override // io.reactivex.rxjava3.core.FlowableSubscriber, org.reactivestreams.Subscriber
    public final void onSubscribe(Subscription subscription) {
        if (SubscriptionHelper.validate(this.f8111e, subscription)) {
            this.f8111e = subscription;
            this.f8107a.onSubscribe(this);
            subscription.request(Long.MAX_VALUE);
        }
    }

    @Override // io.reactivex.rxjava3.operators.SimpleQueue
    public final Object poll() {
        return this.f8108b.poll();
    }

    @Override // org.reactivestreams.Subscription
    public final void request(long j) {
        if (!this.f8116j && SubscriptionHelper.validate(j)) {
            BackpressureHelper.add(this.f8115i, j);
            drain();
        }
    }

    @Override // io.reactivex.rxjava3.operators.QueueFuseable
    public final int requestFusion(int i) {
        if ((i & 2) != 0) {
            this.f8116j = true;
            return 2;
        }
        return 0;
    }
}
