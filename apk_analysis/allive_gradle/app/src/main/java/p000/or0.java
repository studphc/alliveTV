package p000;

import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.internal.disposables.SequentialDisposable;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionArbiter;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class or0 extends SubscriptionArbiter implements FlowableSubscriber, qr0 {
    private static final long serialVersionUID = 3764492702657003550L;

    /* renamed from: h */
    public final Subscriber f24871h;

    /* renamed from: i */
    public final long f24872i;

    /* renamed from: j */
    public final TimeUnit f24873j;

    /* renamed from: k */
    public final Scheduler.Worker f24874k;

    /* renamed from: l */
    public final SequentialDisposable f24875l;

    /* renamed from: m */
    public final AtomicReference f24876m;

    /* renamed from: n */
    public final AtomicLong f24877n;

    /* renamed from: o */
    public long f24878o;

    /* renamed from: p */
    public Publisher f24879p;

    public or0(Subscriber subscriber, long j, TimeUnit timeUnit, Scheduler.Worker worker, Publisher publisher) {
        super(true);
        this.f24871h = subscriber;
        this.f24872i = j;
        this.f24873j = timeUnit;
        this.f24874k = worker;
        this.f24879p = publisher;
        this.f24875l = new SequentialDisposable();
        this.f24876m = new AtomicReference();
        this.f24877n = new AtomicLong();
    }

    @Override // p000.qr0
    /* renamed from: a */
    public final void mo5780a(long j) {
        if (this.f24877n.compareAndSet(j, Long.MAX_VALUE)) {
            SubscriptionHelper.cancel(this.f24876m);
            long j2 = this.f24878o;
            if (j2 != 0) {
                produced(j2);
            }
            Publisher publisher = this.f24879p;
            this.f24879p = null;
            publisher.subscribe(new nr0(this.f24871h, this));
            this.f24874k.dispose();
        }
    }

    @Override // io.reactivex.rxjava3.internal.subscriptions.SubscriptionArbiter, org.reactivestreams.Subscription
    public final void cancel() {
        super.cancel();
        this.f24874k.dispose();
    }

    @Override // org.reactivestreams.Subscriber
    public final void onComplete() {
        if (this.f24877n.getAndSet(Long.MAX_VALUE) != Long.MAX_VALUE) {
            this.f24875l.dispose();
            this.f24871h.onComplete();
            this.f24874k.dispose();
        }
    }

    @Override // org.reactivestreams.Subscriber
    public final void onError(Throwable th) {
        if (this.f24877n.getAndSet(Long.MAX_VALUE) != Long.MAX_VALUE) {
            this.f24875l.dispose();
            this.f24871h.onError(th);
            this.f24874k.dispose();
            return;
        }
        RxJavaPlugins.onError(th);
    }

    @Override // org.reactivestreams.Subscriber
    public final void onNext(Object obj) {
        AtomicLong atomicLong = this.f24877n;
        long j = atomicLong.get();
        if (j != Long.MAX_VALUE) {
            long j2 = j + 1;
            if (atomicLong.compareAndSet(j, j2)) {
                SequentialDisposable sequentialDisposable = this.f24875l;
                sequentialDisposable.get().dispose();
                this.f24878o++;
                this.f24871h.onNext(obj);
                sequentialDisposable.replace(this.f24874k.schedule(new pq0(j2, this), this.f24872i, this.f24873j));
            }
        }
    }

    @Override // io.reactivex.rxjava3.internal.subscriptions.SubscriptionArbiter, io.reactivex.rxjava3.core.FlowableSubscriber, org.reactivestreams.Subscriber
    public final void onSubscribe(Subscription subscription) {
        if (SubscriptionHelper.setOnce(this.f24876m, subscription)) {
            setSubscription(subscription);
        }
    }
}
