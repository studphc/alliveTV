package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.internal.operators.flowable.FlowableGroupBy;
import io.reactivex.rxjava3.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.rxjava3.internal.subscriptions.EmptySubscription;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import io.reactivex.rxjava3.operators.SpscLinkedArrayQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;

/* renamed from: io.reactivex.rxjava3.internal.operators.flowable.b */
/* loaded from: classes2.dex */
public final class C1318b extends BasicIntQueueSubscription implements Publisher {
    private static final long serialVersionUID = -3852313036005250360L;

    /* renamed from: a */
    public final Object f19101a;

    /* renamed from: b */
    public final SpscLinkedArrayQueue f19102b;

    /* renamed from: c */
    public final FlowableGroupBy.GroupBySubscriber f19103c;

    /* renamed from: d */
    public final boolean f19104d;

    /* renamed from: f */
    public volatile boolean f19106f;

    /* renamed from: g */
    public Throwable f19107g;

    /* renamed from: j */
    public int f19110j;

    /* renamed from: e */
    public final AtomicLong f19105e = new AtomicLong();

    /* renamed from: h */
    public final AtomicBoolean f19108h = new AtomicBoolean();

    /* renamed from: i */
    public final AtomicReference f19109i = new AtomicReference();

    /* renamed from: k */
    public final AtomicInteger f19111k = new AtomicInteger();

    /* renamed from: l */
    public final AtomicBoolean f19112l = new AtomicBoolean();

    public C1318b(int i, FlowableGroupBy.GroupBySubscriber groupBySubscriber, Object obj, boolean z) {
        this.f19102b = new SpscLinkedArrayQueue(i);
        this.f19103c = groupBySubscriber;
        this.f19101a = obj;
        this.f19104d = z;
    }

    @Override // org.reactivestreams.Subscription
    public final void cancel() {
        if (this.f19108h.compareAndSet(false, true)) {
            if ((this.f19111k.get() & 2) == 0 && this.f19112l.compareAndSet(false, true)) {
                this.f19103c.cancel(this.f19101a);
            }
            drain();
        }
    }

    @Override // io.reactivex.rxjava3.operators.SimpleQueue
    public final void clear() {
        while (this.f19102b.poll() != null) {
            this.f19110j++;
        }
        m5284h();
    }

    /* JADX WARN: Code restructure failed: missing block: B:41:0x0019, code lost:
    
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void drain() {
        boolean z;
        if (getAndIncrement() != 0) {
            return;
        }
        SpscLinkedArrayQueue spscLinkedArrayQueue = this.f19102b;
        boolean z2 = this.f19104d;
        Subscriber subscriber = (Subscriber) this.f19109i.get();
        AtomicBoolean atomicBoolean = this.f19108h;
        Subscriber subscriber2 = subscriber;
        int i = 1;
        while (true) {
            boolean z3 = false;
            if (atomicBoolean.get()) {
                long j = 0;
                while (this.f19102b.poll() != null) {
                    j++;
                }
                m5282f(j, false);
            } else if (subscriber2 != null) {
                long j2 = this.f19105e.get();
                long j3 = 0;
                while (true) {
                    if (j3 == j2) {
                        break;
                    }
                    boolean z4 = this.f19106f;
                    Object poll = spscLinkedArrayQueue.poll();
                    if (poll == null) {
                        z = true;
                    } else {
                        z = z3;
                    }
                    long j4 = j3;
                    boolean z5 = z3;
                    if (!m5281e(z4, z, subscriber2, z2, j3, !z)) {
                        if (z) {
                            j3 = j4;
                            break;
                        } else {
                            subscriber2.onNext(poll);
                            j3 = j4 + 1;
                            z3 = z5;
                        }
                    }
                }
                if (j3 == j2) {
                    long j5 = j3;
                    if (m5281e(this.f19106f, spscLinkedArrayQueue.isEmpty(), subscriber2, z2, j3, false)) {
                        continue;
                    } else {
                        j3 = j5;
                    }
                }
                if (j3 != 0) {
                    BackpressureHelper.produced(this.f19105e, j3);
                    m5283g(j3);
                }
            }
            i = addAndGet(-i);
            if (i == 0) {
                return;
            }
            if (subscriber2 == null) {
                subscriber2 = (Subscriber) this.f19109i.get();
            }
        }
    }

    /* renamed from: e */
    public final boolean m5281e(boolean z, boolean z2, Subscriber subscriber, boolean z3, long j, boolean z4) {
        AtomicBoolean atomicBoolean = this.f19108h;
        boolean z5 = atomicBoolean.get();
        SpscLinkedArrayQueue spscLinkedArrayQueue = this.f19102b;
        if (z5) {
            while (spscLinkedArrayQueue.poll() != null) {
                j++;
            }
            m5282f(j, z4);
            return true;
        }
        if (z) {
            if (z3) {
                if (z2) {
                    atomicBoolean.lazySet(true);
                    Throwable th = this.f19107g;
                    if (th != null) {
                        subscriber.onError(th);
                    } else {
                        subscriber.onComplete();
                        m5282f(j, z4);
                    }
                    return true;
                }
                return false;
            }
            Throwable th2 = this.f19107g;
            if (th2 != null) {
                spscLinkedArrayQueue.clear();
                atomicBoolean.lazySet(true);
                subscriber.onError(th2);
                return true;
            }
            if (z2) {
                atomicBoolean.lazySet(true);
                subscriber.onComplete();
                m5282f(j, z4);
                return true;
            }
            return false;
        }
        return false;
    }

    /* renamed from: f */
    public final void m5282f(long j, boolean z) {
        if (z) {
            j++;
        }
        if (j != 0) {
            m5283g(j);
        }
    }

    /* renamed from: g */
    public final void m5283g(long j) {
        if ((this.f19111k.get() & 2) == 0) {
            this.f19103c.m5276b(j);
        }
    }

    /* renamed from: h */
    public final void m5284h() {
        int i = this.f19110j;
        if (i != 0) {
            this.f19110j = 0;
            m5283g(i);
        }
    }

    @Override // io.reactivex.rxjava3.operators.SimpleQueue
    public final boolean isEmpty() {
        if (this.f19102b.isEmpty()) {
            m5284h();
            return true;
        }
        m5284h();
        return false;
    }

    @Override // io.reactivex.rxjava3.operators.SimpleQueue
    public final Object poll() {
        Object poll = this.f19102b.poll();
        if (poll != null) {
            this.f19110j++;
            return poll;
        }
        m5284h();
        return null;
    }

    @Override // org.reactivestreams.Subscription
    public final void request(long j) {
        if (SubscriptionHelper.validate(j)) {
            BackpressureHelper.add(this.f19105e, j);
            drain();
        }
    }

    @Override // io.reactivex.rxjava3.operators.QueueFuseable
    public final int requestFusion(int i) {
        return 0;
    }

    @Override // org.reactivestreams.Publisher
    public final void subscribe(Subscriber subscriber) {
        AtomicInteger atomicInteger;
        int i;
        do {
            atomicInteger = this.f19111k;
            i = atomicInteger.get();
            if ((i & 1) != 0) {
                EmptySubscription.error(new IllegalStateException("Only one Subscriber allowed!"), subscriber);
                return;
            }
        } while (!atomicInteger.compareAndSet(i, i | 1));
        subscriber.onSubscribe(this);
        AtomicReference atomicReference = this.f19109i;
        atomicReference.lazySet(subscriber);
        if (this.f19108h.get()) {
            atomicReference.lazySet(null);
        } else {
            drain();
        }
    }
}
