package p000;

import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.exceptions.MissingBackpressureException;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import io.reactivex.rxjava3.operators.QueueSubscription;
import io.reactivex.rxjava3.operators.SimpleQueue;
import io.reactivex.rxjava3.operators.SpscArrayQueue;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Iterator;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Stream;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class em0 extends AtomicInteger implements FlowableSubscriber, Subscription {
    private static final long serialVersionUID = -5127032662980523968L;

    /* renamed from: a */
    public final Subscriber f16894a;

    /* renamed from: b */
    public final Function f16895b;

    /* renamed from: c */
    public final int f16896c;

    /* renamed from: e */
    public SimpleQueue f16898e;

    /* renamed from: f */
    public Subscription f16899f;

    /* renamed from: g */
    public Iterator f16900g;

    /* renamed from: h */
    public AutoCloseable f16901h;

    /* renamed from: i */
    public volatile boolean f16902i;

    /* renamed from: j */
    public volatile boolean f16903j;

    /* renamed from: l */
    public long f16905l;

    /* renamed from: m */
    public int f16906m;

    /* renamed from: n */
    public int f16907n;

    /* renamed from: d */
    public final AtomicLong f16897d = new AtomicLong();

    /* renamed from: k */
    public final AtomicThrowable f16904k = new AtomicThrowable();

    public em0(Subscriber subscriber, Function function, int i) {
        this.f16894a = subscriber;
        this.f16895b = function;
        this.f16896c = i;
    }

    /* JADX WARN: Type inference failed for: r12v0 */
    /* JADX WARN: Type inference failed for: r12v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r12v2 */
    /* renamed from: a */
    public final void m4734a() {
        boolean z;
        int i;
        if (getAndIncrement() != 0) {
            return;
        }
        Subscriber subscriber = this.f16894a;
        SimpleQueue simpleQueue = this.f16898e;
        AtomicThrowable atomicThrowable = this.f16904k;
        Iterator it = this.f16900g;
        long j = this.f16897d.get();
        long j2 = this.f16905l;
        int i2 = this.f16896c;
        int i3 = i2 - (i2 >> 2);
        int i4 = 0;
        ?? r12 = 1;
        if (this.f16907n != 1) {
            z = true;
        } else {
            z = false;
        }
        long j3 = j2;
        int i5 = 1;
        long j4 = j;
        Iterator it2 = it;
        while (true) {
            if (this.f16902i) {
                simpleQueue.clear();
                try {
                    this.f16900g = null;
                    AutoCloseable autoCloseable = this.f16901h;
                    this.f16901h = null;
                    if (autoCloseable != null) {
                        autoCloseable.close();
                    }
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    RxJavaPlugins.onError(th);
                }
            } else {
                boolean z2 = this.f16903j;
                if (atomicThrowable.get() != null) {
                    subscriber.onError(atomicThrowable.get());
                    this.f16902i = r12;
                } else {
                    if (it2 == null) {
                        try {
                            Object poll = simpleQueue.poll();
                            if (poll == null) {
                                i = r12;
                            } else {
                                i = i4;
                            }
                            if (z2 && i != 0) {
                                subscriber.onComplete();
                                this.f16902i = r12;
                            } else if (i == 0) {
                                if (z) {
                                    int i6 = this.f16906m + r12;
                                    this.f16906m = i6;
                                    if (i6 == i3) {
                                        this.f16906m = i4;
                                        this.f16899f.request(i3);
                                    }
                                }
                                try {
                                    Object apply = this.f16895b.apply(poll);
                                    Objects.requireNonNull(apply, "The mapper returned a null Stream");
                                    Stream m5549q = ki0.m5549q(apply);
                                    it2 = m5549q.iterator();
                                    if (it2.hasNext()) {
                                        this.f16900g = it2;
                                        this.f16901h = m5549q;
                                    } else {
                                        it2 = null;
                                    }
                                } catch (Throwable th2) {
                                    Exceptions.throwIfFatal(th2);
                                    m4735b(th2, subscriber);
                                }
                            }
                        } catch (Throwable th3) {
                            Exceptions.throwIfFatal(th3);
                            m4735b(th3, subscriber);
                        }
                    }
                    if (it2 != null && j3 != j4) {
                        try {
                            Object next = it2.next();
                            Objects.requireNonNull(next, "The Stream.Iterator returned a null value");
                            if (!this.f16902i) {
                                subscriber.onNext(next);
                                j3++;
                                if (!this.f16902i) {
                                    try {
                                        if (!it2.hasNext()) {
                                            try {
                                                this.f16900g = null;
                                                AutoCloseable autoCloseable2 = this.f16901h;
                                                this.f16901h = null;
                                                if (autoCloseable2 != null) {
                                                    autoCloseable2.close();
                                                }
                                                it2 = null;
                                            } catch (Throwable th4) {
                                                th = th4;
                                                it2 = null;
                                                Exceptions.throwIfFatal(th);
                                                m4735b(th, subscriber);
                                                i4 = 0;
                                                r12 = 1;
                                            }
                                        }
                                    } catch (Throwable th5) {
                                        th = th5;
                                    }
                                }
                            }
                        } catch (Throwable th6) {
                            Exceptions.throwIfFatal(th6);
                            m4735b(th6, subscriber);
                        }
                    }
                }
                i4 = 0;
                r12 = 1;
            }
            this.f16905l = j3;
            i5 = addAndGet(-i5);
            if (i5 == 0) {
                return;
            }
            j4 = this.f16897d.get();
            i4 = 0;
            r12 = 1;
        }
    }

    /* renamed from: b */
    public final void m4735b(Throwable th, Subscriber subscriber) {
        if (this.f16904k.compareAndSet(null, th)) {
            this.f16899f.cancel();
            this.f16902i = true;
            subscriber.onError(th);
            return;
        }
        RxJavaPlugins.onError(th);
    }

    @Override // org.reactivestreams.Subscription
    public final void cancel() {
        this.f16902i = true;
        this.f16899f.cancel();
        m4734a();
    }

    @Override // org.reactivestreams.Subscriber
    public final void onComplete() {
        this.f16903j = true;
        m4734a();
    }

    @Override // org.reactivestreams.Subscriber
    public final void onError(Throwable th) {
        if (this.f16904k.compareAndSet(null, th)) {
            this.f16903j = true;
            m4734a();
        } else {
            RxJavaPlugins.onError(th);
        }
    }

    @Override // org.reactivestreams.Subscriber
    public final void onNext(Object obj) {
        if (this.f16907n != 2 && !this.f16898e.offer(obj)) {
            this.f16899f.cancel();
            onError(new MissingBackpressureException("Queue full?!"));
        } else {
            m4734a();
        }
    }

    @Override // io.reactivex.rxjava3.core.FlowableSubscriber, org.reactivestreams.Subscriber
    public final void onSubscribe(Subscription subscription) {
        if (SubscriptionHelper.validate(this.f16899f, subscription)) {
            this.f16899f = subscription;
            if (subscription instanceof QueueSubscription) {
                QueueSubscription queueSubscription = (QueueSubscription) subscription;
                int requestFusion = queueSubscription.requestFusion(7);
                if (requestFusion == 1) {
                    this.f16907n = requestFusion;
                    this.f16898e = queueSubscription;
                    this.f16903j = true;
                    this.f16894a.onSubscribe(this);
                    return;
                }
                if (requestFusion == 2) {
                    this.f16907n = requestFusion;
                    this.f16898e = queueSubscription;
                    this.f16894a.onSubscribe(this);
                    subscription.request(this.f16896c);
                    return;
                }
            }
            this.f16898e = new SpscArrayQueue(this.f16896c);
            this.f16894a.onSubscribe(this);
            subscription.request(this.f16896c);
        }
    }

    @Override // org.reactivestreams.Subscription
    public final void request(long j) {
        if (SubscriptionHelper.validate(j)) {
            BackpressureHelper.add(this.f16897d, j);
            m4734a();
        }
    }
}
