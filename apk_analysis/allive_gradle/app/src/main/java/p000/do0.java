package p000;

import io.reactivex.rxjava3.core.BackpressureOverflowStrategy;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.exceptions.MissingBackpressureException;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.ArrayDeque;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class do0 extends AtomicInteger implements FlowableSubscriber, Subscription {
    private static final long serialVersionUID = 3240706908776709697L;

    /* renamed from: a */
    public final Subscriber f16447a;

    /* renamed from: b */
    public final Action f16448b;

    /* renamed from: c */
    public final BackpressureOverflowStrategy f16449c;

    /* renamed from: d */
    public final long f16450d;

    /* renamed from: e */
    public final AtomicLong f16451e = new AtomicLong();

    /* renamed from: f */
    public final ArrayDeque f16452f = new ArrayDeque();

    /* renamed from: g */
    public Subscription f16453g;

    /* renamed from: h */
    public volatile boolean f16454h;

    /* renamed from: i */
    public volatile boolean f16455i;

    /* renamed from: j */
    public Throwable f16456j;

    public do0(Subscriber subscriber, Action action, BackpressureOverflowStrategy backpressureOverflowStrategy, long j) {
        this.f16447a = subscriber;
        this.f16448b = action;
        this.f16449c = backpressureOverflowStrategy;
        this.f16450d = j;
    }

    /* renamed from: a */
    public static void m4595a(ArrayDeque arrayDeque) {
        synchronized (arrayDeque) {
            arrayDeque.clear();
        }
    }

    /* renamed from: b */
    public final void m4596b() {
        boolean isEmpty;
        Object poll;
        boolean z;
        if (getAndIncrement() != 0) {
            return;
        }
        ArrayDeque arrayDeque = this.f16452f;
        Subscriber subscriber = this.f16447a;
        int i = 1;
        do {
            long j = this.f16451e.get();
            long j2 = 0;
            while (j2 != j) {
                if (this.f16454h) {
                    m4595a(arrayDeque);
                    return;
                }
                boolean z2 = this.f16455i;
                synchronized (arrayDeque) {
                    poll = arrayDeque.poll();
                }
                if (poll == null) {
                    z = true;
                } else {
                    z = false;
                }
                if (z2) {
                    Throwable th = this.f16456j;
                    if (th != null) {
                        m4595a(arrayDeque);
                        subscriber.onError(th);
                        return;
                    } else if (z) {
                        subscriber.onComplete();
                        return;
                    }
                }
                if (z) {
                    break;
                }
                subscriber.onNext(poll);
                j2++;
            }
            if (j2 == j) {
                if (this.f16454h) {
                    m4595a(arrayDeque);
                    return;
                }
                boolean z3 = this.f16455i;
                synchronized (arrayDeque) {
                    isEmpty = arrayDeque.isEmpty();
                }
                if (z3) {
                    Throwable th2 = this.f16456j;
                    if (th2 != null) {
                        m4595a(arrayDeque);
                        subscriber.onError(th2);
                        return;
                    } else if (isEmpty) {
                        subscriber.onComplete();
                        return;
                    }
                }
            }
            if (j2 != 0) {
                BackpressureHelper.produced(this.f16451e, j2);
            }
            i = addAndGet(-i);
        } while (i != 0);
    }

    @Override // org.reactivestreams.Subscription
    public final void cancel() {
        this.f16454h = true;
        this.f16453g.cancel();
        if (getAndIncrement() == 0) {
            m4595a(this.f16452f);
        }
    }

    @Override // org.reactivestreams.Subscriber
    public final void onComplete() {
        this.f16455i = true;
        m4596b();
    }

    @Override // org.reactivestreams.Subscriber
    public final void onError(Throwable th) {
        if (this.f16455i) {
            RxJavaPlugins.onError(th);
            return;
        }
        this.f16456j = th;
        this.f16455i = true;
        m4596b();
    }

    @Override // org.reactivestreams.Subscriber
    public final void onNext(Object obj) {
        boolean z;
        boolean z2;
        if (this.f16455i) {
            return;
        }
        ArrayDeque arrayDeque = this.f16452f;
        synchronized (arrayDeque) {
            try {
                z = false;
                if (arrayDeque.size() == this.f16450d) {
                    int i = co0.f8431a[this.f16449c.ordinal()];
                    z2 = true;
                    if (i != 1) {
                        if (i == 2) {
                            arrayDeque.poll();
                            arrayDeque.offer(obj);
                        }
                    } else {
                        arrayDeque.pollLast();
                        arrayDeque.offer(obj);
                    }
                    z2 = false;
                    z = true;
                } else {
                    arrayDeque.offer(obj);
                    z2 = false;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (z) {
            Action action = this.f16448b;
            if (action != null) {
                try {
                    action.run();
                    return;
                } catch (Throwable th2) {
                    Exceptions.throwIfFatal(th2);
                    this.f16453g.cancel();
                    onError(th2);
                    return;
                }
            }
            return;
        }
        if (z2) {
            this.f16453g.cancel();
            onError(new MissingBackpressureException());
        } else {
            m4596b();
        }
    }

    @Override // io.reactivex.rxjava3.core.FlowableSubscriber, org.reactivestreams.Subscriber
    public final void onSubscribe(Subscription subscription) {
        if (SubscriptionHelper.validate(this.f16453g, subscription)) {
            this.f16453g = subscription;
            this.f16447a.onSubscribe(this);
            subscription.request(Long.MAX_VALUE);
        }
    }

    @Override // org.reactivestreams.Subscription
    public final void request(long j) {
        if (SubscriptionHelper.validate(j)) {
            BackpressureHelper.add(this.f16451e, j);
            m4596b();
        }
    }
}
