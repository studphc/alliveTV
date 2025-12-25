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
public final class xr0 extends AtomicInteger implements FlowableSubscriber, Subscription, Runnable {
    private static final long serialVersionUID = -8792836352386833856L;

    /* renamed from: a */
    public final Subscriber f28709a;

    /* renamed from: b */
    public final long f28710b;

    /* renamed from: c */
    public final long f28711c;

    /* renamed from: d */
    public final AtomicBoolean f28712d;

    /* renamed from: e */
    public final AtomicBoolean f28713e;

    /* renamed from: f */
    public final int f28714f;

    /* renamed from: g */
    public long f28715g;

    /* renamed from: h */
    public Subscription f28716h;

    /* renamed from: i */
    public UnicastProcessor f28717i;

    public xr0(Subscriber subscriber, long j, long j2, int i) {
        super(1);
        this.f28709a = subscriber;
        this.f28710b = j;
        this.f28711c = j2;
        this.f28712d = new AtomicBoolean();
        this.f28713e = new AtomicBoolean();
        this.f28714f = i;
    }

    @Override // org.reactivestreams.Subscription
    public final void cancel() {
        if (this.f28712d.compareAndSet(false, true)) {
            run();
        }
    }

    @Override // org.reactivestreams.Subscriber
    public final void onComplete() {
        UnicastProcessor unicastProcessor = this.f28717i;
        if (unicastProcessor != null) {
            this.f28717i = null;
            unicastProcessor.onComplete();
        }
        this.f28709a.onComplete();
    }

    @Override // org.reactivestreams.Subscriber
    public final void onError(Throwable th) {
        UnicastProcessor unicastProcessor = this.f28717i;
        if (unicastProcessor != null) {
            this.f28717i = null;
            unicastProcessor.onError(th);
        }
        this.f28709a.onError(th);
    }

    @Override // org.reactivestreams.Subscriber
    public final void onNext(Object obj) {
        hp0 hp0Var;
        long j = this.f28715g;
        UnicastProcessor unicastProcessor = this.f28717i;
        if (j == 0) {
            getAndIncrement();
            unicastProcessor = UnicastProcessor.create(this.f28714f, this);
            this.f28717i = unicastProcessor;
            hp0Var = new hp0(unicastProcessor);
            this.f28709a.onNext(hp0Var);
        } else {
            hp0Var = null;
        }
        long j2 = j + 1;
        if (unicastProcessor != null) {
            unicastProcessor.onNext(obj);
        }
        if (j2 == this.f28710b) {
            this.f28717i = null;
            unicastProcessor.onComplete();
        }
        if (j2 == this.f28711c) {
            this.f28715g = 0L;
        } else {
            this.f28715g = j2;
        }
        if (hp0Var != null && hp0Var.m5121e()) {
            ((FlowableProcessor) hp0Var.f18124d).onComplete();
        }
    }

    @Override // io.reactivex.rxjava3.core.FlowableSubscriber, org.reactivestreams.Subscriber
    public final void onSubscribe(Subscription subscription) {
        if (SubscriptionHelper.validate(this.f28716h, subscription)) {
            this.f28716h = subscription;
            this.f28709a.onSubscribe(this);
        }
    }

    @Override // org.reactivestreams.Subscription
    public final void request(long j) {
        if (SubscriptionHelper.validate(j)) {
            AtomicBoolean atomicBoolean = this.f28713e;
            boolean z = atomicBoolean.get();
            long j2 = this.f28711c;
            if (!z && atomicBoolean.compareAndSet(false, true)) {
                long j3 = this.f28710b;
                this.f28716h.request(BackpressureHelper.addCap(BackpressureHelper.multiplyCap(j3, j), BackpressureHelper.multiplyCap(j2 - j3, j - 1)));
            } else {
                this.f28716h.request(BackpressureHelper.multiplyCap(j2, j));
            }
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (decrementAndGet() == 0) {
            this.f28716h.cancel();
        }
    }
}
