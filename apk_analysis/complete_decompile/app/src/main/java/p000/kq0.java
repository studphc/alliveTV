package p000;

import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import io.reactivex.rxjava3.operators.SpscLinkedArrayQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class kq0 extends AtomicInteger implements FlowableSubscriber, Subscription {
    private static final long serialVersionUID = -5677354903406201275L;

    /* renamed from: a */
    public final Subscriber f22149a;

    /* renamed from: b */
    public final long f22150b;

    /* renamed from: c */
    public final TimeUnit f22151c;

    /* renamed from: d */
    public final Scheduler f22152d;

    /* renamed from: e */
    public final SpscLinkedArrayQueue f22153e;

    /* renamed from: f */
    public final boolean f22154f;

    /* renamed from: g */
    public Subscription f22155g;

    /* renamed from: h */
    public final AtomicLong f22156h = new AtomicLong();

    /* renamed from: i */
    public volatile boolean f22157i;

    /* renamed from: j */
    public volatile boolean f22158j;

    /* renamed from: k */
    public Throwable f22159k;

    public kq0(Subscriber subscriber, long j, TimeUnit timeUnit, Scheduler scheduler, int i, boolean z) {
        this.f22149a = subscriber;
        this.f22150b = j;
        this.f22151c = timeUnit;
        this.f22152d = scheduler;
        this.f22153e = new SpscLinkedArrayQueue(i);
        this.f22154f = z;
    }

    /* renamed from: a */
    public final void m5762a() {
        boolean z;
        if (getAndIncrement() != 0) {
            return;
        }
        Subscriber subscriber = this.f22149a;
        SpscLinkedArrayQueue spscLinkedArrayQueue = this.f22153e;
        boolean z2 = this.f22154f;
        TimeUnit timeUnit = this.f22151c;
        Scheduler scheduler = this.f22152d;
        long j = this.f22150b;
        int i = 1;
        do {
            long j2 = this.f22156h.get();
            long j3 = 0;
            while (j3 != j2) {
                boolean z3 = this.f22158j;
                Long l = (Long) spscLinkedArrayQueue.peek();
                if (l == null) {
                    z = true;
                } else {
                    z = false;
                }
                long now = scheduler.now(timeUnit);
                if (!z && l.longValue() > now - j) {
                    z = true;
                }
                if (this.f22157i) {
                    this.f22153e.clear();
                    return;
                }
                if (z3) {
                    if (z2) {
                        if (z) {
                            Throwable th = this.f22159k;
                            if (th != null) {
                                subscriber.onError(th);
                                return;
                            } else {
                                subscriber.onComplete();
                                return;
                            }
                        }
                    } else {
                        Throwable th2 = this.f22159k;
                        if (th2 != null) {
                            this.f22153e.clear();
                            subscriber.onError(th2);
                            return;
                        } else if (z) {
                            subscriber.onComplete();
                            return;
                        }
                    }
                }
                if (z) {
                    break;
                }
                spscLinkedArrayQueue.poll();
                subscriber.onNext(spscLinkedArrayQueue.poll());
                j3++;
            }
            if (j3 != 0) {
                BackpressureHelper.produced(this.f22156h, j3);
            }
            i = addAndGet(-i);
        } while (i != 0);
    }

    @Override // org.reactivestreams.Subscription
    public final void cancel() {
        if (!this.f22157i) {
            this.f22157i = true;
            this.f22155g.cancel();
            if (getAndIncrement() == 0) {
                this.f22153e.clear();
            }
        }
    }

    @Override // org.reactivestreams.Subscriber
    public final void onComplete() {
        this.f22158j = true;
        m5762a();
    }

    @Override // org.reactivestreams.Subscriber
    public final void onError(Throwable th) {
        this.f22159k = th;
        this.f22158j = true;
        m5762a();
    }

    @Override // org.reactivestreams.Subscriber
    public final void onNext(Object obj) {
        this.f22153e.offer(Long.valueOf(this.f22152d.now(this.f22151c)), obj);
        m5762a();
    }

    @Override // io.reactivex.rxjava3.core.FlowableSubscriber, org.reactivestreams.Subscriber
    public final void onSubscribe(Subscription subscription) {
        if (SubscriptionHelper.validate(this.f22155g, subscription)) {
            this.f22155g = subscription;
            this.f22149a.onSubscribe(this);
            subscription.request(Long.MAX_VALUE);
        }
    }

    @Override // org.reactivestreams.Subscription
    public final void request(long j) {
        if (SubscriptionHelper.validate(j)) {
            BackpressureHelper.add(this.f22156h, j);
            m5762a();
        }
    }
}
