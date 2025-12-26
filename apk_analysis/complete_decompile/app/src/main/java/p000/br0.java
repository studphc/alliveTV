package p000;

import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import java.util.ArrayDeque;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class br0 extends ArrayDeque implements FlowableSubscriber, Subscription {
    private static final long serialVersionUID = 7240042530241604978L;

    /* renamed from: a */
    public final Subscriber f8135a;

    /* renamed from: b */
    public final int f8136b;

    /* renamed from: c */
    public Subscription f8137c;

    /* renamed from: d */
    public volatile boolean f8138d;

    /* renamed from: e */
    public volatile boolean f8139e;

    /* renamed from: f */
    public final AtomicLong f8140f = new AtomicLong();

    /* renamed from: g */
    public final AtomicInteger f8141g = new AtomicInteger();

    public br0(Subscriber subscriber, int i) {
        this.f8135a = subscriber;
        this.f8136b = i;
    }

    /* renamed from: a */
    public final void m2127a() {
        if (this.f8141g.getAndIncrement() == 0) {
            Subscriber subscriber = this.f8135a;
            long j = this.f8140f.get();
            while (!this.f8139e) {
                if (this.f8138d) {
                    long j2 = 0;
                    while (j2 != j) {
                        if (this.f8139e) {
                            return;
                        }
                        Object poll = poll();
                        if (poll == null) {
                            subscriber.onComplete();
                            return;
                        } else {
                            subscriber.onNext(poll);
                            j2++;
                        }
                    }
                    if (isEmpty()) {
                        subscriber.onComplete();
                        return;
                    } else if (j2 != 0) {
                        j = BackpressureHelper.produced(this.f8140f, j2);
                    }
                }
                if (this.f8141g.decrementAndGet() == 0) {
                    return;
                }
            }
        }
    }

    @Override // org.reactivestreams.Subscription
    public final void cancel() {
        this.f8139e = true;
        this.f8137c.cancel();
    }

    @Override // org.reactivestreams.Subscriber
    public final void onComplete() {
        this.f8138d = true;
        m2127a();
    }

    @Override // org.reactivestreams.Subscriber
    public final void onError(Throwable th) {
        this.f8135a.onError(th);
    }

    @Override // org.reactivestreams.Subscriber
    public final void onNext(Object obj) {
        if (this.f8136b == size()) {
            poll();
        }
        offer(obj);
    }

    @Override // io.reactivex.rxjava3.core.FlowableSubscriber, org.reactivestreams.Subscriber
    public final void onSubscribe(Subscription subscription) {
        if (SubscriptionHelper.validate(this.f8137c, subscription)) {
            this.f8137c = subscription;
            this.f8135a.onSubscribe(this);
            subscription.request(Long.MAX_VALUE);
        }
    }

    @Override // org.reactivestreams.Subscription
    public final void request(long j) {
        if (SubscriptionHelper.validate(j)) {
            BackpressureHelper.add(this.f8140f, j);
            m2127a();
        }
    }
}
