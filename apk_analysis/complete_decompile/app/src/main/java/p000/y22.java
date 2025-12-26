package p000;

import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.exceptions.MissingBackpressureException;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import io.reactivex.rxjava3.operators.SpscArrayQueue;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public abstract class y22 extends AtomicInteger implements FlowableSubscriber, Subscription, Runnable {
    private static final long serialVersionUID = 9222303586456402150L;

    /* renamed from: a */
    public final int f28807a;

    /* renamed from: b */
    public final int f28808b;

    /* renamed from: c */
    public final SpscArrayQueue f28809c;

    /* renamed from: d */
    public final Scheduler.Worker f28810d;

    /* renamed from: e */
    public Subscription f28811e;

    /* renamed from: f */
    public volatile boolean f28812f;

    /* renamed from: g */
    public Throwable f28813g;

    /* renamed from: h */
    public final AtomicLong f28814h = new AtomicLong();

    /* renamed from: i */
    public volatile boolean f28815i;

    /* renamed from: j */
    public int f28816j;

    public y22(int i, SpscArrayQueue spscArrayQueue, Scheduler.Worker worker) {
        this.f28807a = i;
        this.f28809c = spscArrayQueue;
        this.f28808b = i - (i >> 2);
        this.f28810d = worker;
    }

    @Override // org.reactivestreams.Subscription
    public final void cancel() {
        if (!this.f28815i) {
            this.f28815i = true;
            this.f28811e.cancel();
            this.f28810d.dispose();
            if (getAndIncrement() == 0) {
                this.f28809c.clear();
            }
        }
    }

    @Override // org.reactivestreams.Subscriber
    public final void onComplete() {
        if (this.f28812f) {
            return;
        }
        this.f28812f = true;
        if (getAndIncrement() == 0) {
            this.f28810d.schedule(this);
        }
    }

    @Override // org.reactivestreams.Subscriber
    public final void onError(Throwable th) {
        if (this.f28812f) {
            RxJavaPlugins.onError(th);
            return;
        }
        this.f28813g = th;
        this.f28812f = true;
        if (getAndIncrement() == 0) {
            this.f28810d.schedule(this);
        }
    }

    @Override // org.reactivestreams.Subscriber
    public final void onNext(Object obj) {
        if (this.f28812f) {
            return;
        }
        if (!this.f28809c.offer(obj)) {
            this.f28811e.cancel();
            onError(new MissingBackpressureException("Queue is full?!"));
        } else if (getAndIncrement() == 0) {
            this.f28810d.schedule(this);
        }
    }

    @Override // org.reactivestreams.Subscription
    public final void request(long j) {
        if (SubscriptionHelper.validate(j)) {
            BackpressureHelper.add(this.f28814h, j);
            if (getAndIncrement() == 0) {
                this.f28810d.schedule(this);
            }
        }
    }
}
