package p000;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import io.reactivex.rxjava3.operators.SpscArrayQueue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class xn0 extends AtomicInteger implements FlowableSubscriber, Subscription {
    private static final long serialVersionUID = -4592979584110982903L;

    /* renamed from: a */
    public final Subscriber f28641a;

    /* renamed from: b */
    public final AtomicReference f28642b = new AtomicReference();

    /* renamed from: c */
    public final wn0 f28643c = new wn0(this);

    /* renamed from: d */
    public final AtomicThrowable f28644d = new AtomicThrowable();

    /* renamed from: e */
    public final AtomicLong f28645e = new AtomicLong();

    /* renamed from: f */
    public final int f28646f;

    /* renamed from: g */
    public final int f28647g;

    /* renamed from: h */
    public volatile SpscArrayQueue f28648h;

    /* renamed from: i */
    public Object f28649i;

    /* renamed from: j */
    public volatile boolean f28650j;

    /* renamed from: k */
    public volatile boolean f28651k;

    /* renamed from: l */
    public volatile int f28652l;

    /* renamed from: m */
    public long f28653m;

    /* renamed from: n */
    public int f28654n;

    public xn0(Subscriber subscriber) {
        this.f28641a = subscriber;
        int bufferSize = Flowable.bufferSize();
        this.f28646f = bufferSize;
        this.f28647g = bufferSize - (bufferSize >> 2);
    }

    /* renamed from: a */
    public final void m8174a() {
        boolean z;
        Object obj;
        boolean z2;
        Subscriber subscriber = this.f28641a;
        long j = this.f28653m;
        int i = this.f28654n;
        int i2 = this.f28647g;
        int i3 = 1;
        int i4 = 1;
        while (true) {
            long j2 = this.f28645e.get();
            while (j != j2) {
                if (this.f28650j) {
                    this.f28649i = null;
                    this.f28648h = null;
                    return;
                }
                if (this.f28644d.get() != null) {
                    this.f28649i = null;
                    this.f28648h = null;
                    this.f28644d.tryTerminateConsumer(this.f28641a);
                    return;
                }
                int i5 = this.f28652l;
                if (i5 == i3) {
                    Object obj2 = this.f28649i;
                    this.f28649i = null;
                    this.f28652l = 2;
                    subscriber.onNext(obj2);
                    j++;
                } else {
                    boolean z3 = this.f28651k;
                    SpscArrayQueue spscArrayQueue = this.f28648h;
                    if (spscArrayQueue != null) {
                        obj = spscArrayQueue.poll();
                    } else {
                        obj = null;
                    }
                    if (obj == null) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (z3 && z2 && i5 == 2) {
                        this.f28648h = null;
                        subscriber.onComplete();
                        return;
                    } else {
                        if (z2) {
                            break;
                        }
                        subscriber.onNext(obj);
                        j++;
                        i++;
                        if (i == i2) {
                            ((Subscription) this.f28642b.get()).request(i2);
                            i = 0;
                        }
                        i3 = 1;
                    }
                }
            }
            if (j == j2) {
                if (this.f28650j) {
                    this.f28649i = null;
                    this.f28648h = null;
                    return;
                }
                if (this.f28644d.get() != null) {
                    this.f28649i = null;
                    this.f28648h = null;
                    this.f28644d.tryTerminateConsumer(this.f28641a);
                    return;
                }
                boolean z4 = this.f28651k;
                SpscArrayQueue spscArrayQueue2 = this.f28648h;
                if (spscArrayQueue2 != null && !spscArrayQueue2.isEmpty()) {
                    z = false;
                } else {
                    z = true;
                }
                if (z4 && z && this.f28652l == 2) {
                    this.f28648h = null;
                    subscriber.onComplete();
                    return;
                }
            }
            this.f28653m = j;
            this.f28654n = i;
            i4 = addAndGet(-i4);
            if (i4 == 0) {
                return;
            } else {
                i3 = 1;
            }
        }
    }

    @Override // org.reactivestreams.Subscription
    public final void cancel() {
        this.f28650j = true;
        SubscriptionHelper.cancel(this.f28642b);
        DisposableHelper.dispose(this.f28643c);
        this.f28644d.tryTerminateAndReport();
        if (getAndIncrement() == 0) {
            this.f28648h = null;
            this.f28649i = null;
        }
    }

    @Override // org.reactivestreams.Subscriber
    public final void onComplete() {
        this.f28651k = true;
        if (getAndIncrement() == 0) {
            m8174a();
        }
    }

    @Override // org.reactivestreams.Subscriber
    public final void onError(Throwable th) {
        if (this.f28644d.tryAddThrowableOrReport(th)) {
            DisposableHelper.dispose(this.f28643c);
            if (getAndIncrement() == 0) {
                m8174a();
            }
        }
    }

    @Override // org.reactivestreams.Subscriber
    public final void onNext(Object obj) {
        if (compareAndSet(0, 1)) {
            long j = this.f28653m;
            if (this.f28645e.get() != j) {
                SpscArrayQueue spscArrayQueue = this.f28648h;
                if (spscArrayQueue != null && !spscArrayQueue.isEmpty()) {
                    spscArrayQueue.offer(obj);
                } else {
                    this.f28653m = j + 1;
                    this.f28641a.onNext(obj);
                    int i = this.f28654n + 1;
                    if (i == this.f28647g) {
                        this.f28654n = 0;
                        ((Subscription) this.f28642b.get()).request(i);
                    } else {
                        this.f28654n = i;
                    }
                }
            } else {
                SpscArrayQueue spscArrayQueue2 = this.f28648h;
                if (spscArrayQueue2 == null) {
                    spscArrayQueue2 = new SpscArrayQueue(Flowable.bufferSize());
                    this.f28648h = spscArrayQueue2;
                }
                spscArrayQueue2.offer(obj);
            }
            if (decrementAndGet() == 0) {
                return;
            }
        } else {
            SpscArrayQueue spscArrayQueue3 = this.f28648h;
            if (spscArrayQueue3 == null) {
                spscArrayQueue3 = new SpscArrayQueue(Flowable.bufferSize());
                this.f28648h = spscArrayQueue3;
            }
            spscArrayQueue3.offer(obj);
            if (getAndIncrement() != 0) {
                return;
            }
        }
        m8174a();
    }

    @Override // io.reactivex.rxjava3.core.FlowableSubscriber, org.reactivestreams.Subscriber
    public final void onSubscribe(Subscription subscription) {
        SubscriptionHelper.setOnce(this.f28642b, subscription, this.f28646f);
    }

    @Override // org.reactivestreams.Subscription
    public final void request(long j) {
        BackpressureHelper.add(this.f28645e, j);
        if (getAndIncrement() == 0) {
            m8174a();
        }
    }
}
