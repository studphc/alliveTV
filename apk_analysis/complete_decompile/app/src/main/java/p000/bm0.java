package p000;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.core.MaybeSource;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import io.reactivex.rxjava3.operators.SpscLinkedArrayQueue;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class bm0 extends AtomicInteger implements FlowableSubscriber, Subscription {
    private static final long serialVersionUID = 8600231336733376951L;

    /* renamed from: a */
    public final Subscriber f8073a;

    /* renamed from: b */
    public final boolean f8074b;

    /* renamed from: c */
    public final int f8075c;

    /* renamed from: h */
    public final Function f8080h;

    /* renamed from: j */
    public Subscription f8082j;

    /* renamed from: k */
    public volatile boolean f8083k;

    /* renamed from: d */
    public final AtomicLong f8076d = new AtomicLong();

    /* renamed from: e */
    public final CompositeDisposable f8077e = new CompositeDisposable();

    /* renamed from: g */
    public final AtomicThrowable f8079g = new AtomicThrowable();

    /* renamed from: f */
    public final AtomicInteger f8078f = new AtomicInteger(1);

    /* renamed from: i */
    public final AtomicReference f8081i = new AtomicReference();

    public bm0(int i, Function function, Subscriber subscriber, boolean z) {
        this.f8073a = subscriber;
        this.f8080h = function;
        this.f8074b = z;
        this.f8075c = i;
    }

    /* renamed from: a */
    public final void m2106a() {
        SpscLinkedArrayQueue spscLinkedArrayQueue = (SpscLinkedArrayQueue) this.f8081i.get();
        if (spscLinkedArrayQueue != null) {
            spscLinkedArrayQueue.clear();
        }
    }

    /* renamed from: b */
    public final void m2107b() {
        boolean z;
        boolean z2;
        boolean z3;
        Object obj;
        boolean z4;
        Subscriber<?> subscriber = this.f8073a;
        AtomicInteger atomicInteger = this.f8078f;
        AtomicReference atomicReference = this.f8081i;
        int i = 1;
        do {
            long j = this.f8076d.get();
            long j2 = 0;
            while (true) {
                z = false;
                if (j2 == j) {
                    break;
                }
                if (this.f8083k) {
                    m2106a();
                    return;
                }
                if (!this.f8074b && this.f8079g.get() != null) {
                    m2106a();
                    this.f8079g.tryTerminateConsumer(subscriber);
                    return;
                }
                if (atomicInteger.get() == 0) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                SpscLinkedArrayQueue spscLinkedArrayQueue = (SpscLinkedArrayQueue) atomicReference.get();
                if (spscLinkedArrayQueue != null) {
                    obj = spscLinkedArrayQueue.poll();
                } else {
                    obj = null;
                }
                if (obj == null) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                if (z3 && z4) {
                    this.f8079g.tryTerminateConsumer(subscriber);
                    return;
                } else {
                    if (z4) {
                        break;
                    }
                    subscriber.onNext(obj);
                    j2++;
                }
            }
            if (j2 == j) {
                if (this.f8083k) {
                    m2106a();
                    return;
                }
                if (!this.f8074b && this.f8079g.get() != null) {
                    m2106a();
                    this.f8079g.tryTerminateConsumer(subscriber);
                    return;
                }
                if (atomicInteger.get() == 0) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                SpscLinkedArrayQueue spscLinkedArrayQueue2 = (SpscLinkedArrayQueue) atomicReference.get();
                if (spscLinkedArrayQueue2 == null || spscLinkedArrayQueue2.isEmpty()) {
                    z = true;
                }
                if (z2 && z) {
                    this.f8079g.tryTerminateConsumer(subscriber);
                    return;
                }
            }
            if (j2 != 0) {
                BackpressureHelper.produced(this.f8076d, j2);
                if (this.f8075c != Integer.MAX_VALUE) {
                    this.f8082j.request(j2);
                }
            }
            i = addAndGet(-i);
        } while (i != 0);
    }

    /* renamed from: c */
    public final SpscLinkedArrayQueue m2108c() {
        AtomicReference atomicReference = this.f8081i;
        SpscLinkedArrayQueue spscLinkedArrayQueue = (SpscLinkedArrayQueue) atomicReference.get();
        if (spscLinkedArrayQueue != null) {
            return spscLinkedArrayQueue;
        }
        SpscLinkedArrayQueue spscLinkedArrayQueue2 = new SpscLinkedArrayQueue(Flowable.bufferSize());
        while (!atomicReference.compareAndSet(null, spscLinkedArrayQueue2)) {
            if (atomicReference.get() != null) {
                return (SpscLinkedArrayQueue) atomicReference.get();
            }
        }
        return spscLinkedArrayQueue2;
    }

    @Override // org.reactivestreams.Subscription
    public final void cancel() {
        this.f8083k = true;
        this.f8082j.cancel();
        this.f8077e.dispose();
        this.f8079g.tryTerminateAndReport();
    }

    @Override // org.reactivestreams.Subscriber
    public final void onComplete() {
        this.f8078f.decrementAndGet();
        if (getAndIncrement() == 0) {
            m2107b();
        }
    }

    @Override // org.reactivestreams.Subscriber
    public final void onError(Throwable th) {
        this.f8078f.decrementAndGet();
        if (this.f8079g.tryAddThrowableOrReport(th)) {
            if (!this.f8074b) {
                this.f8077e.dispose();
            }
            if (getAndIncrement() == 0) {
                m2107b();
            }
        }
    }

    @Override // org.reactivestreams.Subscriber
    public final void onNext(Object obj) {
        try {
            Object apply = this.f8080h.apply(obj);
            Objects.requireNonNull(apply, "The mapper returned a null MaybeSource");
            MaybeSource maybeSource = (MaybeSource) apply;
            this.f8078f.getAndIncrement();
            am0 am0Var = new am0(this);
            if (!this.f8083k && this.f8077e.add(am0Var)) {
                maybeSource.subscribe(am0Var);
            }
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            this.f8082j.cancel();
            onError(th);
        }
    }

    @Override // io.reactivex.rxjava3.core.FlowableSubscriber, org.reactivestreams.Subscriber
    public final void onSubscribe(Subscription subscription) {
        if (SubscriptionHelper.validate(this.f8082j, subscription)) {
            this.f8082j = subscription;
            this.f8073a.onSubscribe(this);
            int i = this.f8075c;
            if (i == Integer.MAX_VALUE) {
                subscription.request(Long.MAX_VALUE);
            } else {
                subscription.request(i);
            }
        }
    }

    @Override // org.reactivestreams.Subscription
    public final void request(long j) {
        if (SubscriptionHelper.validate(j)) {
            BackpressureHelper.add(this.f8076d, j);
            if (getAndIncrement() == 0) {
                m2107b();
            }
        }
    }
}
