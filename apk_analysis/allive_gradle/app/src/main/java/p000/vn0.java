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
public final class vn0 extends AtomicInteger implements FlowableSubscriber, Subscription {
    private static final long serialVersionUID = -4592979584110982903L;

    /* renamed from: a */
    public final Subscriber f27880a;

    /* renamed from: b */
    public final AtomicReference f27881b = new AtomicReference();

    /* renamed from: c */
    public final un0 f27882c = new un0(this);

    /* renamed from: d */
    public final AtomicThrowable f27883d = new AtomicThrowable();

    /* renamed from: e */
    public final AtomicLong f27884e = new AtomicLong();

    /* renamed from: f */
    public final int f27885f;

    /* renamed from: g */
    public final int f27886g;

    /* renamed from: h */
    public volatile SpscArrayQueue f27887h;

    /* renamed from: i */
    public Object f27888i;

    /* renamed from: j */
    public volatile boolean f27889j;

    /* renamed from: k */
    public volatile boolean f27890k;

    /* renamed from: l */
    public volatile int f27891l;

    /* renamed from: m */
    public long f27892m;

    /* renamed from: n */
    public int f27893n;

    public vn0(Subscriber subscriber) {
        this.f27880a = subscriber;
        int bufferSize = Flowable.bufferSize();
        this.f27885f = bufferSize;
        this.f27886g = bufferSize - (bufferSize >> 2);
    }

    /* renamed from: a */
    public final void m7925a() {
        boolean z;
        Object obj;
        boolean z2;
        Subscriber subscriber = this.f27880a;
        long j = this.f27892m;
        int i = this.f27893n;
        int i2 = this.f27886g;
        int i3 = 1;
        int i4 = 1;
        while (true) {
            long j2 = this.f27884e.get();
            while (j != j2) {
                if (this.f27889j) {
                    this.f27888i = null;
                    this.f27887h = null;
                    return;
                }
                if (this.f27883d.get() != null) {
                    this.f27888i = null;
                    this.f27887h = null;
                    this.f27883d.tryTerminateConsumer(this.f27880a);
                    return;
                }
                int i5 = this.f27891l;
                if (i5 == i3) {
                    Object obj2 = this.f27888i;
                    this.f27888i = null;
                    this.f27891l = 2;
                    subscriber.onNext(obj2);
                    j++;
                } else {
                    boolean z3 = this.f27890k;
                    SpscArrayQueue spscArrayQueue = this.f27887h;
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
                        this.f27887h = null;
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
                            ((Subscription) this.f27881b.get()).request(i2);
                            i = 0;
                        }
                        i3 = 1;
                    }
                }
            }
            if (j == j2) {
                if (this.f27889j) {
                    this.f27888i = null;
                    this.f27887h = null;
                    return;
                }
                if (this.f27883d.get() != null) {
                    this.f27888i = null;
                    this.f27887h = null;
                    this.f27883d.tryTerminateConsumer(this.f27880a);
                    return;
                }
                boolean z4 = this.f27890k;
                SpscArrayQueue spscArrayQueue2 = this.f27887h;
                if (spscArrayQueue2 != null && !spscArrayQueue2.isEmpty()) {
                    z = false;
                } else {
                    z = true;
                }
                if (z4 && z && this.f27891l == 2) {
                    this.f27887h = null;
                    subscriber.onComplete();
                    return;
                }
            }
            this.f27892m = j;
            this.f27893n = i;
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
        this.f27889j = true;
        SubscriptionHelper.cancel(this.f27881b);
        DisposableHelper.dispose(this.f27882c);
        this.f27883d.tryTerminateAndReport();
        if (getAndIncrement() == 0) {
            this.f27887h = null;
            this.f27888i = null;
        }
    }

    @Override // org.reactivestreams.Subscriber
    public final void onComplete() {
        this.f27890k = true;
        if (getAndIncrement() == 0) {
            m7925a();
        }
    }

    @Override // org.reactivestreams.Subscriber
    public final void onError(Throwable th) {
        if (this.f27883d.tryAddThrowableOrReport(th)) {
            DisposableHelper.dispose(this.f27882c);
            if (getAndIncrement() == 0) {
                m7925a();
            }
        }
    }

    @Override // org.reactivestreams.Subscriber
    public final void onNext(Object obj) {
        if (compareAndSet(0, 1)) {
            long j = this.f27892m;
            if (this.f27884e.get() != j) {
                SpscArrayQueue spscArrayQueue = this.f27887h;
                if (spscArrayQueue != null && !spscArrayQueue.isEmpty()) {
                    spscArrayQueue.offer(obj);
                } else {
                    this.f27892m = j + 1;
                    this.f27880a.onNext(obj);
                    int i = this.f27893n + 1;
                    if (i == this.f27886g) {
                        this.f27893n = 0;
                        ((Subscription) this.f27881b.get()).request(i);
                    } else {
                        this.f27893n = i;
                    }
                }
            } else {
                SpscArrayQueue spscArrayQueue2 = this.f27887h;
                if (spscArrayQueue2 == null) {
                    spscArrayQueue2 = new SpscArrayQueue(Flowable.bufferSize());
                    this.f27887h = spscArrayQueue2;
                }
                spscArrayQueue2.offer(obj);
            }
            if (decrementAndGet() == 0) {
                return;
            }
        } else {
            SpscArrayQueue spscArrayQueue3 = this.f27887h;
            if (spscArrayQueue3 == null) {
                spscArrayQueue3 = new SpscArrayQueue(Flowable.bufferSize());
                this.f27887h = spscArrayQueue3;
            }
            spscArrayQueue3.offer(obj);
            if (getAndIncrement() != 0) {
                return;
            }
        }
        m7925a();
    }

    @Override // io.reactivex.rxjava3.core.FlowableSubscriber, org.reactivestreams.Subscriber
    public final void onSubscribe(Subscription subscription) {
        SubscriptionHelper.setOnce(this.f27881b, subscription, this.f27885f);
    }

    @Override // org.reactivestreams.Subscription
    public final void request(long j) {
        BackpressureHelper.add(this.f27884e, j);
        if (getAndIncrement() == 0) {
            m7925a();
        }
    }
}
