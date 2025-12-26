package p000;

import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.BiFunction;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import io.reactivex.rxjava3.operators.SpscArrayQueue;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class cq0 extends AtomicInteger implements FlowableSubscriber, Subscription {
    private static final long serialVersionUID = -1776795561228106469L;

    /* renamed from: a */
    public final Subscriber f16071a;

    /* renamed from: b */
    public final BiFunction f16072b;

    /* renamed from: c */
    public final SpscArrayQueue f16073c;

    /* renamed from: d */
    public final AtomicLong f16074d;

    /* renamed from: e */
    public final int f16075e;

    /* renamed from: f */
    public final int f16076f;

    /* renamed from: g */
    public volatile boolean f16077g;

    /* renamed from: h */
    public volatile boolean f16078h;

    /* renamed from: i */
    public Throwable f16079i;

    /* renamed from: j */
    public Subscription f16080j;

    /* renamed from: k */
    public Object f16081k;

    /* renamed from: l */
    public int f16082l;

    public cq0(Subscriber subscriber, BiFunction biFunction, Object obj, int i) {
        this.f16071a = subscriber;
        this.f16072b = biFunction;
        this.f16081k = obj;
        this.f16075e = i;
        this.f16076f = i - (i >> 2);
        SpscArrayQueue spscArrayQueue = new SpscArrayQueue(i);
        this.f16073c = spscArrayQueue;
        spscArrayQueue.offer(obj);
        this.f16074d = new AtomicLong();
    }

    /* renamed from: a */
    public final void m4486a() {
        boolean z;
        Throwable th;
        if (getAndIncrement() != 0) {
            return;
        }
        Subscriber subscriber = this.f16071a;
        SpscArrayQueue spscArrayQueue = this.f16073c;
        int i = this.f16076f;
        int i2 = this.f16082l;
        int i3 = 1;
        do {
            long j = this.f16074d.get();
            long j2 = 0;
            while (j2 != j) {
                if (this.f16077g) {
                    spscArrayQueue.clear();
                    return;
                }
                boolean z2 = this.f16078h;
                if (z2 && (th = this.f16079i) != null) {
                    spscArrayQueue.clear();
                    subscriber.onError(th);
                    return;
                }
                E poll = spscArrayQueue.poll();
                if (poll == 0) {
                    z = true;
                } else {
                    z = false;
                }
                if (z2 && z) {
                    subscriber.onComplete();
                    return;
                }
                if (z) {
                    break;
                }
                subscriber.onNext(poll);
                j2++;
                i2++;
                if (i2 == i) {
                    this.f16080j.request(i);
                    i2 = 0;
                }
            }
            if (j2 == j && this.f16078h) {
                Throwable th2 = this.f16079i;
                if (th2 != null) {
                    spscArrayQueue.clear();
                    subscriber.onError(th2);
                    return;
                } else if (spscArrayQueue.isEmpty()) {
                    subscriber.onComplete();
                    return;
                }
            }
            if (j2 != 0) {
                BackpressureHelper.produced(this.f16074d, j2);
            }
            this.f16082l = i2;
            i3 = addAndGet(-i3);
        } while (i3 != 0);
    }

    @Override // org.reactivestreams.Subscription
    public final void cancel() {
        this.f16077g = true;
        this.f16080j.cancel();
        if (getAndIncrement() == 0) {
            this.f16073c.clear();
        }
    }

    @Override // org.reactivestreams.Subscriber
    public final void onComplete() {
        if (this.f16078h) {
            return;
        }
        this.f16078h = true;
        m4486a();
    }

    @Override // org.reactivestreams.Subscriber
    public final void onError(Throwable th) {
        if (this.f16078h) {
            RxJavaPlugins.onError(th);
            return;
        }
        this.f16079i = th;
        this.f16078h = true;
        m4486a();
    }

    @Override // org.reactivestreams.Subscriber
    public final void onNext(Object obj) {
        if (this.f16078h) {
            return;
        }
        try {
            Object apply = this.f16072b.apply(this.f16081k, obj);
            Objects.requireNonNull(apply, "The accumulator returned a null value");
            this.f16081k = apply;
            this.f16073c.offer(apply);
            m4486a();
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            this.f16080j.cancel();
            onError(th);
        }
    }

    @Override // io.reactivex.rxjava3.core.FlowableSubscriber, org.reactivestreams.Subscriber
    public final void onSubscribe(Subscription subscription) {
        if (SubscriptionHelper.validate(this.f16080j, subscription)) {
            this.f16080j = subscription;
            this.f16071a.onSubscribe(this);
            subscription.request(this.f16075e - 1);
        }
    }

    @Override // org.reactivestreams.Subscription
    public final void request(long j) {
        if (SubscriptionHelper.validate(j)) {
            BackpressureHelper.add(this.f16074d, j);
            m4486a();
        }
    }
}
