package p000;

import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class qq0 extends AtomicReference implements FlowableSubscriber, Subscription, Runnable {
    private static final long serialVersionUID = 8094547886072529208L;

    /* renamed from: a */
    public final Subscriber f25722a;

    /* renamed from: b */
    public final Scheduler.Worker f25723b;

    /* renamed from: c */
    public final AtomicReference f25724c = new AtomicReference();

    /* renamed from: d */
    public final AtomicLong f25725d = new AtomicLong();

    /* renamed from: e */
    public final boolean f25726e;

    /* renamed from: f */
    public Publisher f25727f;

    public qq0(Subscriber subscriber, Scheduler.Worker worker, Publisher publisher, boolean z) {
        this.f25722a = subscriber;
        this.f25723b = worker;
        this.f25727f = publisher;
        this.f25726e = !z;
    }

    /* renamed from: a */
    public final void m7116a(long j, Subscription subscription) {
        if (!this.f25726e && Thread.currentThread() != get()) {
            this.f25723b.schedule(new pq0(subscription, j, 0));
        } else {
            subscription.request(j);
        }
    }

    @Override // org.reactivestreams.Subscription
    public final void cancel() {
        SubscriptionHelper.cancel(this.f25724c);
        this.f25723b.dispose();
    }

    @Override // org.reactivestreams.Subscriber
    public final void onComplete() {
        this.f25722a.onComplete();
        this.f25723b.dispose();
    }

    @Override // org.reactivestreams.Subscriber
    public final void onError(Throwable th) {
        this.f25722a.onError(th);
        this.f25723b.dispose();
    }

    @Override // org.reactivestreams.Subscriber
    public final void onNext(Object obj) {
        this.f25722a.onNext(obj);
    }

    @Override // io.reactivex.rxjava3.core.FlowableSubscriber, org.reactivestreams.Subscriber
    public final void onSubscribe(Subscription subscription) {
        if (SubscriptionHelper.setOnce(this.f25724c, subscription)) {
            long andSet = this.f25725d.getAndSet(0L);
            if (andSet != 0) {
                m7116a(andSet, subscription);
            }
        }
    }

    @Override // org.reactivestreams.Subscription
    public final void request(long j) {
        if (SubscriptionHelper.validate(j)) {
            AtomicReference atomicReference = this.f25724c;
            Subscription subscription = (Subscription) atomicReference.get();
            if (subscription != null) {
                m7116a(j, subscription);
                return;
            }
            AtomicLong atomicLong = this.f25725d;
            BackpressureHelper.add(atomicLong, j);
            Subscription subscription2 = (Subscription) atomicReference.get();
            if (subscription2 != null) {
                long andSet = atomicLong.getAndSet(0L);
                if (andSet != 0) {
                    m7116a(andSet, subscription2);
                }
            }
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        lazySet(Thread.currentThread());
        Publisher publisher = this.f25727f;
        this.f25727f = null;
        publisher.subscribe(this);
    }
}
