package p000;

import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.exceptions.MissingBackpressureException;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.operators.QueueSubscription;
import io.reactivex.rxjava3.operators.SimpleQueue;
import io.reactivex.rxjava3.operators.SpscArrayQueue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLongArray;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class k22 extends AtomicInteger implements FlowableSubscriber {
    private static final long serialVersionUID = -4470634016609963609L;

    /* renamed from: a */
    public final Subscriber[] f20727a;

    /* renamed from: b */
    public final AtomicLongArray f20728b;

    /* renamed from: c */
    public final long[] f20729c;

    /* renamed from: d */
    public final int f20730d;

    /* renamed from: e */
    public final int f20731e;

    /* renamed from: f */
    public Subscription f20732f;

    /* renamed from: g */
    public SimpleQueue f20733g;

    /* renamed from: h */
    public Throwable f20734h;

    /* renamed from: i */
    public volatile boolean f20735i;

    /* renamed from: j */
    public int f20736j;

    /* renamed from: k */
    public volatile boolean f20737k;

    /* renamed from: l */
    public final AtomicInteger f20738l = new AtomicInteger();

    /* renamed from: m */
    public int f20739m;

    /* renamed from: n */
    public int f20740n;

    public k22(Subscriber[] subscriberArr, int i) {
        this.f20727a = subscriberArr;
        this.f20730d = i;
        this.f20731e = i - (i >> 2);
        int length = subscriberArr.length;
        int i2 = length + length;
        AtomicLongArray atomicLongArray = new AtomicLongArray(i2 + 1);
        this.f20728b = atomicLongArray;
        atomicLongArray.lazySet(i2, length);
        this.f20729c = new long[length];
    }

    /* JADX WARN: Removed duplicated region for block: B:107:0x013c  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0148 A[SYNTHETIC] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void m5482a() {
        int i;
        Throwable th;
        if (getAndIncrement() != 0) {
            return;
        }
        long j = 1;
        if (this.f20740n == 1) {
            SimpleQueue simpleQueue = this.f20733g;
            Subscriber[] subscriberArr = this.f20727a;
            AtomicLongArray atomicLongArray = this.f20728b;
            long[] jArr = this.f20729c;
            int length = jArr.length;
            int i2 = this.f20736j;
            int i3 = 1;
            while (true) {
                int i4 = 0;
                while (!this.f20737k) {
                    if (simpleQueue.isEmpty()) {
                        for (Subscriber subscriber : subscriberArr) {
                            subscriber.onComplete();
                        }
                        return;
                    }
                    long j2 = atomicLongArray.get(i2);
                    long j3 = jArr[i2];
                    if (j2 != j3 && atomicLongArray.get(length + i2) == 0) {
                        try {
                            Object poll = simpleQueue.poll();
                            if (poll == null) {
                                for (Subscriber subscriber2 : subscriberArr) {
                                    subscriber2.onComplete();
                                }
                                return;
                            }
                            subscriberArr[i2].onNext(poll);
                            jArr[i2] = j3 + 1;
                            i4 = 0;
                        } catch (Throwable th2) {
                            Exceptions.throwIfFatal(th2);
                            this.f20732f.cancel();
                            for (Subscriber subscriber3 : subscriberArr) {
                                subscriber3.onError(th2);
                            }
                            return;
                        }
                    } else {
                        i4++;
                    }
                    i2++;
                    if (i2 == length) {
                        i2 = 0;
                    }
                    if (i4 == length) {
                        int i5 = get();
                        if (i5 == i3) {
                            this.f20736j = i2;
                            i3 = addAndGet(-i3);
                            if (i3 == 0) {
                                return;
                            }
                        } else {
                            i3 = i5;
                        }
                    }
                }
                simpleQueue.clear();
                return;
            }
        }
        SimpleQueue simpleQueue2 = this.f20733g;
        Subscriber[] subscriberArr2 = this.f20727a;
        AtomicLongArray atomicLongArray2 = this.f20728b;
        long[] jArr2 = this.f20729c;
        int length2 = jArr2.length;
        int i6 = this.f20736j;
        int i7 = this.f20739m;
        int i8 = 1;
        while (true) {
            int i9 = 0;
            while (!this.f20737k) {
                boolean z = this.f20735i;
                if (z && (th = this.f20734h) != null) {
                    simpleQueue2.clear();
                    for (Subscriber subscriber4 : subscriberArr2) {
                        subscriber4.onError(th);
                    }
                    return;
                }
                boolean isEmpty = simpleQueue2.isEmpty();
                if (z && isEmpty) {
                    for (Subscriber subscriber5 : subscriberArr2) {
                        subscriber5.onComplete();
                    }
                    return;
                }
                if (!isEmpty) {
                    long j4 = atomicLongArray2.get(i6);
                    long j5 = jArr2[i6];
                    if (j4 != j5 && atomicLongArray2.get(length2 + i6) == 0) {
                        try {
                            Object poll2 = simpleQueue2.poll();
                            if (poll2 != null) {
                                subscriberArr2[i6].onNext(poll2);
                                jArr2[i6] = j5 + j;
                                i7++;
                                if (i7 == this.f20731e) {
                                    this.f20732f.request(i7);
                                    i7 = 0;
                                }
                                i9 = 0;
                            }
                        } catch (Throwable th3) {
                            Exceptions.throwIfFatal(th3);
                            this.f20732f.cancel();
                            for (Subscriber subscriber6 : subscriberArr2) {
                                subscriber6.onError(th3);
                            }
                            return;
                        }
                    } else {
                        i9++;
                    }
                    i6++;
                    if (i6 == length2) {
                        i6 = 0;
                    }
                    if (i9 == length2) {
                        i = get();
                        if (i != i8) {
                            this.f20736j = i6;
                            this.f20739m = i7;
                            i = addAndGet(-i8);
                            if (i == 0) {
                                return;
                            }
                        }
                        i8 = i;
                        j = 1;
                    } else {
                        j = 1;
                    }
                }
                i = get();
                if (i != i8) {
                }
                i8 = i;
                j = 1;
            }
            simpleQueue2.clear();
            return;
        }
    }

    /* renamed from: b */
    public final void m5483b() {
        Subscriber[] subscriberArr = this.f20727a;
        int length = subscriberArr.length;
        int i = 0;
        while (i < length) {
            int i2 = i + 1;
            this.f20738l.lazySet(i2);
            subscriberArr[i].onSubscribe(new j22(this, i, length));
            i = i2;
        }
    }

    @Override // org.reactivestreams.Subscriber
    public final void onComplete() {
        this.f20735i = true;
        m5482a();
    }

    @Override // org.reactivestreams.Subscriber
    public final void onError(Throwable th) {
        this.f20734h = th;
        this.f20735i = true;
        m5482a();
    }

    @Override // org.reactivestreams.Subscriber
    public final void onNext(Object obj) {
        if (this.f20740n == 0 && !this.f20733g.offer(obj)) {
            this.f20732f.cancel();
            onError(new MissingBackpressureException("Queue is full?"));
        } else {
            m5482a();
        }
    }

    @Override // io.reactivex.rxjava3.core.FlowableSubscriber, org.reactivestreams.Subscriber
    public final void onSubscribe(Subscription subscription) {
        if (SubscriptionHelper.validate(this.f20732f, subscription)) {
            this.f20732f = subscription;
            if (subscription instanceof QueueSubscription) {
                QueueSubscription queueSubscription = (QueueSubscription) subscription;
                int requestFusion = queueSubscription.requestFusion(7);
                if (requestFusion == 1) {
                    this.f20740n = requestFusion;
                    this.f20733g = queueSubscription;
                    this.f20735i = true;
                    m5483b();
                    m5482a();
                    return;
                }
                if (requestFusion == 2) {
                    this.f20740n = requestFusion;
                    this.f20733g = queueSubscription;
                    m5483b();
                    subscription.request(this.f20730d);
                    return;
                }
            }
            this.f20733g = new SpscArrayQueue(this.f20730d);
            m5483b();
            subscription.request(this.f20730d);
        }
    }
}
