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
public final class dr0 extends AtomicInteger implements FlowableSubscriber, Subscription {
    private static final long serialVersionUID = -5677354903406201275L;

    /* renamed from: a */
    public final Subscriber f16498a;

    /* renamed from: b */
    public final long f16499b;

    /* renamed from: c */
    public final long f16500c;

    /* renamed from: d */
    public final TimeUnit f16501d;

    /* renamed from: e */
    public final Scheduler f16502e;

    /* renamed from: f */
    public final SpscLinkedArrayQueue f16503f;

    /* renamed from: g */
    public final boolean f16504g;

    /* renamed from: h */
    public Subscription f16505h;

    /* renamed from: i */
    public final AtomicLong f16506i = new AtomicLong();

    /* renamed from: j */
    public volatile boolean f16507j;

    /* renamed from: k */
    public volatile boolean f16508k;

    /* renamed from: l */
    public Throwable f16509l;

    public dr0(int i, long j, long j2, Scheduler scheduler, TimeUnit timeUnit, Subscriber subscriber, boolean z) {
        this.f16498a = subscriber;
        this.f16499b = j;
        this.f16500c = j2;
        this.f16501d = timeUnit;
        this.f16502e = scheduler;
        this.f16503f = new SpscLinkedArrayQueue(i);
        this.f16504g = z;
    }

    /* renamed from: a */
    public final boolean m4603a(Subscriber subscriber, boolean z, boolean z2) {
        if (this.f16507j) {
            this.f16503f.clear();
            return true;
        }
        if (z2) {
            if (z) {
                Throwable th = this.f16509l;
                if (th != null) {
                    subscriber.onError(th);
                } else {
                    subscriber.onComplete();
                }
                return true;
            }
            return false;
        }
        Throwable th2 = this.f16509l;
        if (th2 != null) {
            this.f16503f.clear();
            subscriber.onError(th2);
            return true;
        }
        if (z) {
            subscriber.onComplete();
            return true;
        }
        return false;
    }

    /* renamed from: b */
    public final void m4604b() {
        boolean z;
        if (getAndIncrement() != 0) {
            return;
        }
        Subscriber subscriber = this.f16498a;
        SpscLinkedArrayQueue spscLinkedArrayQueue = this.f16503f;
        boolean z2 = this.f16504g;
        int i = 1;
        do {
            if (this.f16508k) {
                if (m4603a(subscriber, spscLinkedArrayQueue.isEmpty(), z2)) {
                    return;
                }
                long j = this.f16506i.get();
                long j2 = 0;
                while (true) {
                    if (spscLinkedArrayQueue.peek() == null) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (m4603a(subscriber, z, z2)) {
                        return;
                    }
                    if (j == j2) {
                        if (j2 != 0) {
                            BackpressureHelper.produced(this.f16506i, j2);
                        }
                    } else {
                        spscLinkedArrayQueue.poll();
                        subscriber.onNext(spscLinkedArrayQueue.poll());
                        j2++;
                    }
                }
            }
            i = addAndGet(-i);
        } while (i != 0);
    }

    /* renamed from: c */
    public final void m4605c(long j, SpscLinkedArrayQueue spscLinkedArrayQueue) {
        boolean z;
        long j2 = this.f16499b;
        if (j2 == Long.MAX_VALUE) {
            z = true;
        } else {
            z = false;
        }
        while (!spscLinkedArrayQueue.isEmpty()) {
            if (((Long) spscLinkedArrayQueue.peek()).longValue() < j - this.f16500c || (!z && (spscLinkedArrayQueue.size() >> 1) > j2)) {
                spscLinkedArrayQueue.poll();
                spscLinkedArrayQueue.poll();
            } else {
                return;
            }
        }
    }

    @Override // org.reactivestreams.Subscription
    public final void cancel() {
        if (!this.f16507j) {
            this.f16507j = true;
            this.f16505h.cancel();
            if (getAndIncrement() == 0) {
                this.f16503f.clear();
            }
        }
    }

    @Override // org.reactivestreams.Subscriber
    public final void onComplete() {
        m4605c(this.f16502e.now(this.f16501d), this.f16503f);
        this.f16508k = true;
        m4604b();
    }

    @Override // org.reactivestreams.Subscriber
    public final void onError(Throwable th) {
        if (this.f16504g) {
            m4605c(this.f16502e.now(this.f16501d), this.f16503f);
        }
        this.f16509l = th;
        this.f16508k = true;
        m4604b();
    }

    @Override // org.reactivestreams.Subscriber
    public final void onNext(Object obj) {
        long now = this.f16502e.now(this.f16501d);
        Long valueOf = Long.valueOf(now);
        SpscLinkedArrayQueue spscLinkedArrayQueue = this.f16503f;
        spscLinkedArrayQueue.offer(valueOf, obj);
        m4605c(now, spscLinkedArrayQueue);
    }

    @Override // io.reactivex.rxjava3.core.FlowableSubscriber, org.reactivestreams.Subscriber
    public final void onSubscribe(Subscription subscription) {
        if (SubscriptionHelper.validate(this.f16505h, subscription)) {
            this.f16505h = subscription;
            this.f16498a.onSubscribe(this);
            subscription.request(Long.MAX_VALUE);
        }
    }

    @Override // org.reactivestreams.Subscription
    public final void request(long j) {
        if (SubscriptionHelper.validate(j)) {
            BackpressureHelper.add(this.f16506i, j);
            m4604b();
        }
    }
}
