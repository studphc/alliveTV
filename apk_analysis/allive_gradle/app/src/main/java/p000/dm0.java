package p000;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.core.SingleSource;
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
public final class dm0 extends AtomicInteger implements FlowableSubscriber, Subscription {
    private static final long serialVersionUID = 8600231336733376951L;

    /* renamed from: a */
    public final Subscriber f16416a;

    /* renamed from: b */
    public final boolean f16417b;

    /* renamed from: c */
    public final int f16418c;

    /* renamed from: h */
    public final Function f16423h;

    /* renamed from: j */
    public Subscription f16425j;

    /* renamed from: k */
    public volatile boolean f16426k;

    /* renamed from: d */
    public final AtomicLong f16419d = new AtomicLong();

    /* renamed from: e */
    public final CompositeDisposable f16420e = new CompositeDisposable();

    /* renamed from: g */
    public final AtomicThrowable f16422g = new AtomicThrowable();

    /* renamed from: f */
    public final AtomicInteger f16421f = new AtomicInteger(1);

    /* renamed from: i */
    public final AtomicReference f16424i = new AtomicReference();

    public dm0(int i, Function function, Subscriber subscriber, boolean z) {
        this.f16416a = subscriber;
        this.f16423h = function;
        this.f16417b = z;
        this.f16418c = i;
    }

    /* renamed from: a */
    public final void m4590a() {
        SpscLinkedArrayQueue spscLinkedArrayQueue = (SpscLinkedArrayQueue) this.f16424i.get();
        if (spscLinkedArrayQueue != null) {
            spscLinkedArrayQueue.clear();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x006b, code lost:
    
        if (r10 != r6) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x006f, code lost:
    
        if (r17.f16426k == false) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0077, code lost:
    
        if (r17.f16417b != false) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0081, code lost:
    
        if (r17.f16422g.get() == null) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0083, code lost:
    
        m4590a();
        r17.f16422g.tryTerminateConsumer(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x008b, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0090, code lost:
    
        if (r2.get() != 0) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0092, code lost:
    
        r6 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0095, code lost:
    
        r7 = (io.reactivex.rxjava3.operators.SpscLinkedArrayQueue) r3.get();
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x009b, code lost:
    
        if (r7 == null) goto L53;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00a1, code lost:
    
        if (r7.isEmpty() == false) goto L54;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00a4, code lost:
    
        if (r6 == false) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x00a6, code lost:
    
        if (r13 == false) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00a8, code lost:
    
        r17.f16422g.tryTerminateConsumer(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x00ad, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x00a3, code lost:
    
        r13 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x0094, code lost:
    
        r6 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0071, code lost:
    
        m4590a();
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x0074, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x00b0, code lost:
    
        if (r10 == 0) goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x00b2, code lost:
    
        io.reactivex.rxjava3.internal.util.BackpressureHelper.produced(r17.f16419d, r10);
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x00bc, code lost:
    
        if (r17.f16418c == Integer.MAX_VALUE) goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x00be, code lost:
    
        r17.f16425j.request(r10);
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x00c3, code lost:
    
        r5 = addAndGet(-r5);
     */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void m4591b() {
        boolean z;
        Object obj;
        boolean z2;
        Subscriber<?> subscriber = this.f16416a;
        AtomicInteger atomicInteger = this.f16421f;
        AtomicReference atomicReference = this.f16424i;
        int i = 1;
        do {
            long j = this.f16419d.get();
            long j2 = 0;
            while (true) {
                boolean z3 = false;
                if (j2 == j) {
                    break;
                }
                if (this.f16426k) {
                    m4590a();
                    return;
                }
                if (!this.f16417b && this.f16422g.get() != null) {
                    m4590a();
                    this.f16422g.tryTerminateConsumer(this.f16416a);
                    return;
                }
                if (atomicInteger.get() == 0) {
                    z = true;
                } else {
                    z = false;
                }
                SpscLinkedArrayQueue spscLinkedArrayQueue = (SpscLinkedArrayQueue) atomicReference.get();
                if (spscLinkedArrayQueue != null) {
                    obj = spscLinkedArrayQueue.poll();
                } else {
                    obj = null;
                }
                if (obj == null) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (z && z2) {
                    this.f16422g.tryTerminateConsumer(subscriber);
                    return;
                } else {
                    if (z2) {
                        break;
                    }
                    subscriber.onNext(obj);
                    j2++;
                }
            }
        } while (i != 0);
    }

    /* renamed from: c */
    public final SpscLinkedArrayQueue m4592c() {
        AtomicReference atomicReference = this.f16424i;
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
        this.f16426k = true;
        this.f16425j.cancel();
        this.f16420e.dispose();
        this.f16422g.tryTerminateAndReport();
    }

    @Override // org.reactivestreams.Subscriber
    public final void onComplete() {
        this.f16421f.decrementAndGet();
        if (getAndIncrement() == 0) {
            m4591b();
        }
    }

    @Override // org.reactivestreams.Subscriber
    public final void onError(Throwable th) {
        this.f16421f.decrementAndGet();
        if (this.f16422g.tryAddThrowableOrReport(th)) {
            if (!this.f16417b) {
                this.f16420e.dispose();
            }
            if (getAndIncrement() == 0) {
                m4591b();
            }
        }
    }

    @Override // org.reactivestreams.Subscriber
    public final void onNext(Object obj) {
        try {
            Object apply = this.f16423h.apply(obj);
            Objects.requireNonNull(apply, "The mapper returned a null SingleSource");
            SingleSource singleSource = (SingleSource) apply;
            this.f16421f.getAndIncrement();
            cm0 cm0Var = new cm0(this);
            if (!this.f16426k && this.f16420e.add(cm0Var)) {
                singleSource.subscribe(cm0Var);
            }
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            this.f16425j.cancel();
            onError(th);
        }
    }

    @Override // io.reactivex.rxjava3.core.FlowableSubscriber, org.reactivestreams.Subscriber
    public final void onSubscribe(Subscription subscription) {
        if (SubscriptionHelper.validate(this.f16425j, subscription)) {
            this.f16425j = subscription;
            this.f16416a.onSubscribe(this);
            int i = this.f16418c;
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
            BackpressureHelper.add(this.f16419d, j);
            if (getAndIncrement() == 0) {
                m4591b();
            }
        }
    }
}
