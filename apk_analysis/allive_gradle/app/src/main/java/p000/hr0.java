package p000;

import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.exceptions.MissingBackpressureException;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class hr0 extends AtomicInteger implements FlowableSubscriber, Subscription, Runnable {
    private static final long serialVersionUID = -8296689127439125014L;

    /* renamed from: a */
    public final Subscriber f18137a;

    /* renamed from: b */
    public final long f18138b;

    /* renamed from: c */
    public final TimeUnit f18139c;

    /* renamed from: d */
    public final Scheduler.Worker f18140d;

    /* renamed from: e */
    public final boolean f18141e;

    /* renamed from: f */
    public final AtomicReference f18142f = new AtomicReference();

    /* renamed from: g */
    public final AtomicLong f18143g = new AtomicLong();

    /* renamed from: h */
    public Subscription f18144h;

    /* renamed from: i */
    public volatile boolean f18145i;

    /* renamed from: j */
    public Throwable f18146j;

    /* renamed from: k */
    public volatile boolean f18147k;

    /* renamed from: l */
    public volatile boolean f18148l;

    /* renamed from: m */
    public long f18149m;

    /* renamed from: n */
    public boolean f18150n;

    public hr0(Subscriber subscriber, long j, TimeUnit timeUnit, Scheduler.Worker worker, boolean z) {
        this.f18137a = subscriber;
        this.f18138b = j;
        this.f18139c = timeUnit;
        this.f18140d = worker;
        this.f18141e = z;
    }

    /* renamed from: a */
    public final void m5124a() {
        boolean z;
        if (getAndIncrement() != 0) {
            return;
        }
        AtomicReference atomicReference = this.f18142f;
        AtomicLong atomicLong = this.f18143g;
        Subscriber subscriber = this.f18137a;
        int i = 1;
        while (!this.f18147k) {
            boolean z2 = this.f18145i;
            if (z2 && this.f18146j != null) {
                atomicReference.lazySet(null);
                subscriber.onError(this.f18146j);
                this.f18140d.dispose();
                return;
            }
            if (atomicReference.get() == null) {
                z = true;
            } else {
                z = false;
            }
            if (z2) {
                if (!z && this.f18141e) {
                    Object andSet = atomicReference.getAndSet(null);
                    long j = this.f18149m;
                    if (j != atomicLong.get()) {
                        this.f18149m = j + 1;
                        subscriber.onNext(andSet);
                        subscriber.onComplete();
                    } else {
                        subscriber.onError(new MissingBackpressureException("Could not emit final value due to lack of requests"));
                    }
                } else {
                    atomicReference.lazySet(null);
                    subscriber.onComplete();
                }
                this.f18140d.dispose();
                return;
            }
            if (z) {
                if (this.f18148l) {
                    this.f18150n = false;
                    this.f18148l = false;
                }
            } else if (!this.f18150n || this.f18148l) {
                Object andSet2 = atomicReference.getAndSet(null);
                long j2 = this.f18149m;
                if (j2 != atomicLong.get()) {
                    subscriber.onNext(andSet2);
                    this.f18149m = j2 + 1;
                    this.f18148l = false;
                    this.f18150n = true;
                    this.f18140d.schedule(this, this.f18138b, this.f18139c);
                } else {
                    this.f18144h.cancel();
                    subscriber.onError(new MissingBackpressureException("Could not emit value due to lack of requests"));
                    this.f18140d.dispose();
                    return;
                }
            }
            i = addAndGet(-i);
            if (i == 0) {
                return;
            }
        }
        atomicReference.lazySet(null);
    }

    @Override // org.reactivestreams.Subscription
    public final void cancel() {
        this.f18147k = true;
        this.f18144h.cancel();
        this.f18140d.dispose();
        if (getAndIncrement() == 0) {
            this.f18142f.lazySet(null);
        }
    }

    @Override // org.reactivestreams.Subscriber
    public final void onComplete() {
        this.f18145i = true;
        m5124a();
    }

    @Override // org.reactivestreams.Subscriber
    public final void onError(Throwable th) {
        this.f18146j = th;
        this.f18145i = true;
        m5124a();
    }

    @Override // org.reactivestreams.Subscriber
    public final void onNext(Object obj) {
        this.f18142f.set(obj);
        m5124a();
    }

    @Override // io.reactivex.rxjava3.core.FlowableSubscriber, org.reactivestreams.Subscriber
    public final void onSubscribe(Subscription subscription) {
        if (SubscriptionHelper.validate(this.f18144h, subscription)) {
            this.f18144h = subscription;
            this.f18137a.onSubscribe(this);
            subscription.request(Long.MAX_VALUE);
        }
    }

    @Override // org.reactivestreams.Subscription
    public final void request(long j) {
        if (SubscriptionHelper.validate(j)) {
            BackpressureHelper.add(this.f18143g, j);
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f18148l = true;
        m5124a();
    }
}
