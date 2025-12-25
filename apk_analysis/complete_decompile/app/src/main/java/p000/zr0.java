package p000;

import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.exceptions.MissingBackpressureException;
import io.reactivex.rxjava3.internal.queue.MpscLinkedQueue;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import io.reactivex.rxjava3.processors.UnicastProcessor;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class zr0 extends AtomicInteger implements FlowableSubscriber, Subscription, Runnable {

    /* renamed from: m */
    public static final Object f29491m = new Object();
    private static final long serialVersionUID = 2233020065421370272L;

    /* renamed from: a */
    public final Subscriber f29492a;

    /* renamed from: b */
    public final int f29493b;

    /* renamed from: c */
    public final yr0 f29494c = new yr0(this);

    /* renamed from: d */
    public final AtomicReference f29495d = new AtomicReference();

    /* renamed from: e */
    public final AtomicInteger f29496e = new AtomicInteger(1);

    /* renamed from: f */
    public final MpscLinkedQueue f29497f = new MpscLinkedQueue();

    /* renamed from: g */
    public final AtomicThrowable f29498g = new AtomicThrowable();

    /* renamed from: h */
    public final AtomicBoolean f29499h = new AtomicBoolean();

    /* renamed from: i */
    public final AtomicLong f29500i = new AtomicLong();

    /* renamed from: j */
    public volatile boolean f29501j;

    /* renamed from: k */
    public UnicastProcessor f29502k;

    /* renamed from: l */
    public long f29503l;

    public zr0(Subscriber subscriber, int i) {
        this.f29492a = subscriber;
        this.f29493b = i;
    }

    /* renamed from: a */
    public final void m8426a() {
        boolean z;
        if (getAndIncrement() != 0) {
            return;
        }
        Subscriber subscriber = this.f29492a;
        MpscLinkedQueue mpscLinkedQueue = this.f29497f;
        AtomicThrowable atomicThrowable = this.f29498g;
        long j = this.f29503l;
        int i = 1;
        while (this.f29496e.get() != 0) {
            UnicastProcessor unicastProcessor = this.f29502k;
            boolean z2 = this.f29501j;
            if (z2 && atomicThrowable.get() != null) {
                mpscLinkedQueue.clear();
                Throwable terminate = atomicThrowable.terminate();
                if (unicastProcessor != null) {
                    this.f29502k = null;
                    unicastProcessor.onError(terminate);
                }
                subscriber.onError(terminate);
                return;
            }
            Object poll = mpscLinkedQueue.poll();
            if (poll == null) {
                z = true;
            } else {
                z = false;
            }
            if (z2 && z) {
                Throwable terminate2 = atomicThrowable.terminate();
                if (terminate2 == null) {
                    if (unicastProcessor != null) {
                        this.f29502k = null;
                        unicastProcessor.onComplete();
                    }
                    subscriber.onComplete();
                    return;
                }
                if (unicastProcessor != null) {
                    this.f29502k = null;
                    unicastProcessor.onError(terminate2);
                }
                subscriber.onError(terminate2);
                return;
            }
            if (z) {
                this.f29503l = j;
                i = addAndGet(-i);
                if (i == 0) {
                    return;
                }
            } else if (poll != f29491m) {
                unicastProcessor.onNext(poll);
            } else {
                if (unicastProcessor != null) {
                    this.f29502k = null;
                    unicastProcessor.onComplete();
                }
                if (!this.f29499h.get()) {
                    UnicastProcessor create = UnicastProcessor.create(this.f29493b, this);
                    this.f29502k = create;
                    this.f29496e.getAndIncrement();
                    if (j != this.f29500i.get()) {
                        j++;
                        hp0 hp0Var = new hp0(create);
                        subscriber.onNext(hp0Var);
                        if (hp0Var.m5121e()) {
                            create.onComplete();
                        }
                    } else {
                        SubscriptionHelper.cancel(this.f29495d);
                        this.f29494c.dispose();
                        atomicThrowable.tryAddThrowableOrReport(new MissingBackpressureException("Could not deliver a window due to lack of requests"));
                        this.f29501j = true;
                    }
                }
            }
        }
        mpscLinkedQueue.clear();
        this.f29502k = null;
    }

    @Override // org.reactivestreams.Subscription
    public final void cancel() {
        if (this.f29499h.compareAndSet(false, true)) {
            this.f29494c.dispose();
            if (this.f29496e.decrementAndGet() == 0) {
                SubscriptionHelper.cancel(this.f29495d);
            }
        }
    }

    @Override // org.reactivestreams.Subscriber
    public final void onComplete() {
        this.f29494c.dispose();
        this.f29501j = true;
        m8426a();
    }

    @Override // org.reactivestreams.Subscriber
    public final void onError(Throwable th) {
        this.f29494c.dispose();
        if (this.f29498g.tryAddThrowableOrReport(th)) {
            this.f29501j = true;
            m8426a();
        }
    }

    @Override // org.reactivestreams.Subscriber
    public final void onNext(Object obj) {
        this.f29497f.offer(obj);
        m8426a();
    }

    @Override // io.reactivex.rxjava3.core.FlowableSubscriber, org.reactivestreams.Subscriber
    public final void onSubscribe(Subscription subscription) {
        SubscriptionHelper.setOnce(this.f29495d, subscription, Long.MAX_VALUE);
    }

    @Override // org.reactivestreams.Subscription
    public final void request(long j) {
        BackpressureHelper.add(this.f29500i, j);
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.f29496e.decrementAndGet() == 0) {
            SubscriptionHelper.cancel(this.f29495d);
        }
    }
}
