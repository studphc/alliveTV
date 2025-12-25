package p000;

import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.internal.queue.MpscLinkedQueue;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public abstract class es0 extends AtomicInteger implements FlowableSubscriber, Subscription {
    private static final long serialVersionUID = 5724293814035355511L;

    /* renamed from: a */
    public final Subscriber f16959a;

    /* renamed from: c */
    public final long f16961c;

    /* renamed from: d */
    public final TimeUnit f16962d;

    /* renamed from: e */
    public final int f16963e;

    /* renamed from: g */
    public long f16965g;

    /* renamed from: h */
    public volatile boolean f16966h;

    /* renamed from: i */
    public Throwable f16967i;

    /* renamed from: j */
    public Subscription f16968j;

    /* renamed from: l */
    public volatile boolean f16970l;

    /* renamed from: b */
    public final MpscLinkedQueue f16960b = new MpscLinkedQueue();

    /* renamed from: f */
    public final AtomicLong f16964f = new AtomicLong();

    /* renamed from: k */
    public final AtomicBoolean f16969k = new AtomicBoolean();

    /* renamed from: m */
    public final AtomicInteger f16971m = new AtomicInteger(1);

    public es0(Subscriber subscriber, long j, TimeUnit timeUnit, int i) {
        this.f16959a = subscriber;
        this.f16961c = j;
        this.f16962d = timeUnit;
        this.f16963e = i;
    }

    /* renamed from: a */
    public abstract void mo4750a();

    /* renamed from: b */
    public abstract void mo4751b();

    /* renamed from: c */
    public abstract void mo4752c();

    @Override // org.reactivestreams.Subscription
    public final void cancel() {
        if (this.f16969k.compareAndSet(false, true)) {
            m4753d();
        }
    }

    /* renamed from: d */
    public final void m4753d() {
        if (this.f16971m.decrementAndGet() == 0) {
            mo4750a();
            this.f16968j.cancel();
            this.f16970l = true;
            mo4752c();
        }
    }

    @Override // org.reactivestreams.Subscriber
    public final void onComplete() {
        this.f16966h = true;
        mo4752c();
    }

    @Override // org.reactivestreams.Subscriber
    public final void onError(Throwable th) {
        this.f16967i = th;
        this.f16966h = true;
        mo4752c();
    }

    @Override // org.reactivestreams.Subscriber
    public final void onNext(Object obj) {
        this.f16960b.offer(obj);
        mo4752c();
    }

    @Override // io.reactivex.rxjava3.core.FlowableSubscriber, org.reactivestreams.Subscriber
    public final void onSubscribe(Subscription subscription) {
        if (SubscriptionHelper.validate(this.f16968j, subscription)) {
            this.f16968j = subscription;
            this.f16959a.onSubscribe(this);
            mo4751b();
        }
    }

    @Override // org.reactivestreams.Subscription
    public final void request(long j) {
        if (SubscriptionHelper.validate(j)) {
            BackpressureHelper.add(this.f16964f, j);
        }
    }

    public void run() {
        m4753d();
    }
}
