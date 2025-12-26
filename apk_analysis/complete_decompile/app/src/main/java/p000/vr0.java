package p000;

import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import io.reactivex.rxjava3.processors.FlowableProcessor;
import io.reactivex.rxjava3.processors.UnicastProcessor;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class vr0 extends AtomicInteger implements FlowableSubscriber, Subscription, Runnable {
    private static final long serialVersionUID = -2365647875069161133L;

    /* renamed from: a */
    public final Subscriber f27931a;

    /* renamed from: b */
    public final long f27932b;

    /* renamed from: c */
    public final AtomicBoolean f27933c;

    /* renamed from: d */
    public final int f27934d;

    /* renamed from: e */
    public long f27935e;

    /* renamed from: f */
    public Subscription f27936f;

    /* renamed from: g */
    public UnicastProcessor f27937g;

    public vr0(Subscriber subscriber, long j, int i) {
        super(1);
        this.f27931a = subscriber;
        this.f27932b = j;
        this.f27933c = new AtomicBoolean();
        this.f27934d = i;
    }

    @Override // org.reactivestreams.Subscription
    public final void cancel() {
        if (this.f27933c.compareAndSet(false, true)) {
            run();
        }
    }

    @Override // org.reactivestreams.Subscriber
    public final void onComplete() {
        UnicastProcessor unicastProcessor = this.f27937g;
        if (unicastProcessor != null) {
            this.f27937g = null;
            unicastProcessor.onComplete();
        }
        this.f27931a.onComplete();
    }

    @Override // org.reactivestreams.Subscriber
    public final void onError(Throwable th) {
        UnicastProcessor unicastProcessor = this.f27937g;
        if (unicastProcessor != null) {
            this.f27937g = null;
            unicastProcessor.onError(th);
        }
        this.f27931a.onError(th);
    }

    @Override // org.reactivestreams.Subscriber
    public final void onNext(Object obj) {
        hp0 hp0Var;
        long j = this.f27935e;
        UnicastProcessor unicastProcessor = this.f27937g;
        if (j == 0) {
            getAndIncrement();
            unicastProcessor = UnicastProcessor.create(this.f27934d, this);
            this.f27937g = unicastProcessor;
            hp0Var = new hp0(unicastProcessor);
            this.f27931a.onNext(hp0Var);
        } else {
            hp0Var = null;
        }
        long j2 = j + 1;
        unicastProcessor.onNext(obj);
        if (j2 == this.f27932b) {
            this.f27935e = 0L;
            this.f27937g = null;
            unicastProcessor.onComplete();
        } else {
            this.f27935e = j2;
        }
        if (hp0Var != null && hp0Var.m5121e()) {
            ((FlowableProcessor) hp0Var.f18124d).onComplete();
        }
    }

    @Override // io.reactivex.rxjava3.core.FlowableSubscriber, org.reactivestreams.Subscriber
    public final void onSubscribe(Subscription subscription) {
        if (SubscriptionHelper.validate(this.f27936f, subscription)) {
            this.f27936f = subscription;
            this.f27931a.onSubscribe(this);
        }
    }

    @Override // org.reactivestreams.Subscription
    public final void request(long j) {
        if (SubscriptionHelper.validate(j)) {
            this.f27936f.request(BackpressureHelper.multiplyCap(this.f27932b, j));
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (decrementAndGet() == 0) {
            this.f27936f.cancel();
        }
    }
}
