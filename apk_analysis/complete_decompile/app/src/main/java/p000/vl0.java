package p000;

import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.exceptions.MissingBackpressureException;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import io.reactivex.rxjava3.operators.SimplePlainQueue;
import io.reactivex.rxjava3.operators.SimpleQueue;
import io.reactivex.rxjava3.operators.SpscArrayQueue;
import io.reactivex.rxjava3.operators.SpscLinkedArrayQueue;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class vl0 extends AtomicInteger implements FlowableSubscriber, Subscription {

    /* renamed from: r */
    public static final ul0[] f27835r = new ul0[0];

    /* renamed from: s */
    public static final ul0[] f27836s = new ul0[0];
    private static final long serialVersionUID = -2117620485640801370L;

    /* renamed from: a */
    public final Subscriber f27837a;

    /* renamed from: b */
    public final Function f27838b;

    /* renamed from: c */
    public final boolean f27839c;

    /* renamed from: d */
    public final int f27840d;

    /* renamed from: e */
    public final int f27841e;

    /* renamed from: f */
    public volatile SimplePlainQueue f27842f;

    /* renamed from: g */
    public volatile boolean f27843g;

    /* renamed from: h */
    public final AtomicThrowable f27844h = new AtomicThrowable();

    /* renamed from: i */
    public volatile boolean f27845i;

    /* renamed from: j */
    public final AtomicReference f27846j;

    /* renamed from: k */
    public final AtomicLong f27847k;

    /* renamed from: l */
    public Subscription f27848l;

    /* renamed from: m */
    public long f27849m;

    /* renamed from: n */
    public long f27850n;

    /* renamed from: o */
    public int f27851o;

    /* renamed from: p */
    public int f27852p;

    /* renamed from: q */
    public final int f27853q;

    public vl0(Subscriber subscriber, Function function, boolean z, int i, int i2) {
        AtomicReference atomicReference = new AtomicReference();
        this.f27846j = atomicReference;
        this.f27847k = new AtomicLong();
        this.f27837a = subscriber;
        this.f27838b = function;
        this.f27839c = z;
        this.f27840d = i;
        this.f27841e = i2;
        this.f27853q = Math.max(1, i >> 1);
        atomicReference.lazySet(f27835r);
    }

    /* renamed from: a */
    public final boolean m7918a() {
        if (this.f27845i) {
            SimplePlainQueue simplePlainQueue = this.f27842f;
            if (simplePlainQueue != null) {
                simplePlainQueue.clear();
            }
            return true;
        }
        if (!this.f27839c && this.f27844h.get() != null) {
            SimplePlainQueue simplePlainQueue2 = this.f27842f;
            if (simplePlainQueue2 != null) {
                simplePlainQueue2.clear();
            }
            this.f27844h.tryTerminateConsumer(this.f27837a);
            return true;
        }
        return false;
    }

    /* renamed from: b */
    public final void m7919b() {
        if (getAndIncrement() == 0) {
            m7920c();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:104:0x0121, code lost:
    
        r5 = Long.MAX_VALUE;
     */
    /* JADX WARN: Code restructure failed: missing block: B:105:0x012c, code lost:
    
        r10 = r12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x0115, code lost:
    
        if (r10 == r12) goto L88;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x0117, code lost:
    
        if (r9 != false) goto L86;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x0119, code lost:
    
        r5 = r24.f27847k.addAndGet(-r10);
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x0126, code lost:
    
        r7.m7737a(r10);
        r10 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x012f, code lost:
    
        if (r5 == r10) goto L144;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x0131, code lost:
    
        if (r22 != null) goto L93;
     */
    /* renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void m7920c() {
        boolean z;
        long j;
        long j2;
        long j3;
        boolean z2;
        int i;
        int i2;
        Object obj;
        long j4;
        Subscriber subscriber = this.f27837a;
        int i3 = 1;
        while (!m7918a()) {
            SimplePlainQueue simplePlainQueue = this.f27842f;
            long j5 = this.f27847k.get();
            if (j5 == Long.MAX_VALUE) {
                z = true;
            } else {
                z = false;
            }
            long j6 = 0;
            if (simplePlainQueue != null) {
                long j7 = 0;
                j = 0;
                while (j5 != 0) {
                    Object poll = simplePlainQueue.poll();
                    if (m7918a()) {
                        return;
                    }
                    if (poll == null) {
                        break;
                    }
                    subscriber.onNext(poll);
                    j++;
                    j7++;
                    j5--;
                }
                if (j7 != 0) {
                    if (z) {
                        j5 = Long.MAX_VALUE;
                    } else {
                        j5 = this.f27847k.addAndGet(-j7);
                    }
                }
            } else {
                j = 0;
            }
            boolean z3 = this.f27843g;
            SimplePlainQueue simplePlainQueue2 = this.f27842f;
            ul0[] ul0VarArr = (ul0[]) this.f27846j.get();
            int length = ul0VarArr.length;
            if (z3 && ((simplePlainQueue2 == null || simplePlainQueue2.isEmpty()) && length == 0)) {
                this.f27844h.tryTerminateConsumer(this.f27837a);
                return;
            }
            int i4 = i3;
            if (length != 0) {
                long j8 = this.f27850n;
                int i5 = this.f27851o;
                if (length <= i5 || ul0VarArr[i5].f27313a != j8) {
                    if (length <= i5) {
                        i5 = 0;
                    }
                    for (int i6 = 0; i6 < length && ul0VarArr[i5].f27313a != j8; i6++) {
                        i5++;
                        if (i5 == length) {
                            i5 = 0;
                        }
                    }
                    this.f27851o = i5;
                    this.f27850n = ul0VarArr[i5].f27313a;
                }
                int i7 = i5;
                boolean z4 = false;
                int i8 = 0;
                while (true) {
                    if (i8 < length) {
                        if (m7918a()) {
                            return;
                        }
                        ul0 ul0Var = ul0VarArr[i7];
                        Object obj2 = null;
                        while (true) {
                            SimpleQueue simpleQueue = ul0Var.f27318f;
                            if (simpleQueue == null) {
                                i = length;
                                break;
                            }
                            i = length;
                            obj = obj2;
                            long j9 = j6;
                            while (true) {
                                if (j5 != j6) {
                                    if (m7918a()) {
                                        return;
                                    }
                                    try {
                                        Object poll2 = simpleQueue.poll();
                                        if (poll2 == null) {
                                            obj = poll2;
                                            j4 = 0;
                                            break;
                                        } else {
                                            subscriber.onNext(poll2);
                                            j5--;
                                            j9++;
                                            obj = poll2;
                                            j6 = 0;
                                        }
                                    } catch (Throwable th) {
                                        Exceptions.throwIfFatal(th);
                                        SubscriptionHelper.cancel(ul0Var);
                                        this.f27844h.tryAddThrowableOrReport(th);
                                        if (!this.f27839c) {
                                            this.f27848l.cancel();
                                        }
                                        if (m7918a()) {
                                            return;
                                        }
                                        m7922e(ul0Var);
                                        i8++;
                                        i2 = i;
                                        z4 = true;
                                    }
                                } else {
                                    j4 = j6;
                                    break;
                                }
                            }
                            length = i;
                            obj2 = obj;
                            j6 = 0;
                        }
                        boolean z5 = ul0Var.f27317e;
                        SimpleQueue simpleQueue2 = ul0Var.f27318f;
                        if (z5 && (simpleQueue2 == null || simpleQueue2.isEmpty())) {
                            m7922e(ul0Var);
                            if (m7918a()) {
                                return;
                            }
                            j++;
                            z4 = true;
                        }
                        if (j5 == 0) {
                            z2 = z4;
                            break;
                        }
                        i7++;
                        i2 = i;
                        if (i7 == i2) {
                            i7 = 0;
                        }
                        i8++;
                        length = i2;
                        j6 = 0;
                    } else {
                        z2 = z4;
                        break;
                    }
                }
                this.f27851o = i7;
                this.f27850n = ul0VarArr[i7].f27313a;
                j3 = j;
                j2 = 0;
            } else {
                j2 = 0;
                j3 = j;
                z2 = false;
            }
            if (j3 != j2 && !this.f27845i) {
                this.f27848l.request(j3);
            }
            if (z2) {
                i3 = i4;
            } else {
                i3 = addAndGet(-i4);
                if (i3 == 0) {
                    return;
                }
            }
        }
    }

    @Override // org.reactivestreams.Subscription
    public final void cancel() {
        SimplePlainQueue simplePlainQueue;
        if (!this.f27845i) {
            this.f27845i = true;
            this.f27848l.cancel();
            AtomicReference atomicReference = this.f27846j;
            ul0[] ul0VarArr = f27836s;
            ul0[] ul0VarArr2 = (ul0[]) atomicReference.getAndSet(ul0VarArr);
            if (ul0VarArr2 != ul0VarArr) {
                for (ul0 ul0Var : ul0VarArr2) {
                    ul0Var.getClass();
                    SubscriptionHelper.cancel(ul0Var);
                }
                this.f27844h.tryTerminateAndReport();
            }
            if (getAndIncrement() == 0 && (simplePlainQueue = this.f27842f) != null) {
                simplePlainQueue.clear();
            }
        }
    }

    /* renamed from: d */
    public final SimplePlainQueue m7921d() {
        SimplePlainQueue simplePlainQueue = this.f27842f;
        if (simplePlainQueue == null) {
            if (this.f27840d == Integer.MAX_VALUE) {
                simplePlainQueue = new SpscLinkedArrayQueue(this.f27841e);
            } else {
                simplePlainQueue = new SpscArrayQueue(this.f27840d);
            }
            this.f27842f = simplePlainQueue;
        }
        return simplePlainQueue;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: e */
    public final void m7922e(ul0 ul0Var) {
        ul0[] ul0VarArr;
        while (true) {
            AtomicReference atomicReference = this.f27846j;
            ul0[] ul0VarArr2 = (ul0[]) atomicReference.get();
            int length = ul0VarArr2.length;
            if (length == 0) {
                return;
            }
            int i = 0;
            while (true) {
                if (i < length) {
                    if (ul0VarArr2[i] == ul0Var) {
                        break;
                    } else {
                        i++;
                    }
                } else {
                    i = -1;
                    break;
                }
            }
            if (i < 0) {
                return;
            }
            if (length == 1) {
                ul0VarArr = f27835r;
            } else {
                ul0[] ul0VarArr3 = new ul0[length - 1];
                System.arraycopy(ul0VarArr2, 0, ul0VarArr3, 0, i);
                System.arraycopy(ul0VarArr2, i + 1, ul0VarArr3, i, (length - i) - 1);
                ul0VarArr = ul0VarArr3;
            }
            while (!atomicReference.compareAndSet(ul0VarArr2, ul0VarArr)) {
                if (atomicReference.get() != ul0VarArr2) {
                    break;
                }
            }
            return;
        }
    }

    @Override // org.reactivestreams.Subscriber
    public final void onComplete() {
        if (this.f27843g) {
            return;
        }
        this.f27843g = true;
        m7919b();
    }

    @Override // org.reactivestreams.Subscriber
    public final void onError(Throwable th) {
        if (this.f27843g) {
            RxJavaPlugins.onError(th);
            return;
        }
        if (this.f27844h.tryAddThrowableOrReport(th)) {
            this.f27843g = true;
            if (!this.f27839c) {
                for (ul0 ul0Var : (ul0[]) this.f27846j.getAndSet(f27836s)) {
                    ul0Var.getClass();
                    SubscriptionHelper.cancel(ul0Var);
                }
            }
            m7919b();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.reactivestreams.Subscriber
    public final void onNext(Object obj) {
        if (this.f27843g) {
            return;
        }
        try {
            Object apply = this.f27838b.apply(obj);
            Objects.requireNonNull(apply, "The mapper returned a null Publisher");
            Publisher publisher = (Publisher) apply;
            if (publisher instanceof Supplier) {
                try {
                    Object obj2 = ((Supplier) publisher).get();
                    if (obj2 != null) {
                        if (get() == 0 && compareAndSet(0, 1)) {
                            long j = this.f27847k.get();
                            SimplePlainQueue simplePlainQueue = this.f27842f;
                            if (j != 0 && (simplePlainQueue == null || simplePlainQueue.isEmpty())) {
                                this.f27837a.onNext(obj2);
                                if (j != Long.MAX_VALUE) {
                                    this.f27847k.decrementAndGet();
                                }
                                if (this.f27840d != Integer.MAX_VALUE && !this.f27845i) {
                                    int i = this.f27852p + 1;
                                    this.f27852p = i;
                                    int i2 = this.f27853q;
                                    if (i == i2) {
                                        this.f27852p = 0;
                                        this.f27848l.request(i2);
                                    }
                                }
                            } else {
                                if (simplePlainQueue == null) {
                                    simplePlainQueue = m7921d();
                                }
                                if (!simplePlainQueue.offer(obj2)) {
                                    onError(new MissingBackpressureException("Scalar queue full?!"));
                                }
                            }
                            if (decrementAndGet() == 0) {
                                return;
                            }
                        } else if (!m7921d().offer(obj2)) {
                            onError(new MissingBackpressureException("Scalar queue full?!"));
                            return;
                        } else if (getAndIncrement() != 0) {
                            return;
                        }
                        m7920c();
                        return;
                    }
                    if (this.f27840d != Integer.MAX_VALUE && !this.f27845i) {
                        int i3 = this.f27852p + 1;
                        this.f27852p = i3;
                        int i4 = this.f27853q;
                        if (i3 == i4) {
                            this.f27852p = 0;
                            this.f27848l.request(i4);
                            return;
                        }
                        return;
                    }
                    return;
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    this.f27844h.tryAddThrowableOrReport(th);
                    m7919b();
                    return;
                }
            }
            int i5 = this.f27841e;
            long j2 = this.f27849m;
            this.f27849m = 1 + j2;
            ul0 ul0Var = new ul0(this, i5, j2);
            while (true) {
                AtomicReference atomicReference = this.f27846j;
                ul0[] ul0VarArr = (ul0[]) atomicReference.get();
                if (ul0VarArr == f27836s) {
                    SubscriptionHelper.cancel(ul0Var);
                    return;
                }
                int length = ul0VarArr.length;
                ul0[] ul0VarArr2 = new ul0[length + 1];
                System.arraycopy(ul0VarArr, 0, ul0VarArr2, 0, length);
                ul0VarArr2[length] = ul0Var;
                while (!atomicReference.compareAndSet(ul0VarArr, ul0VarArr2)) {
                    if (atomicReference.get() != ul0VarArr) {
                        break;
                    }
                }
                publisher.subscribe(ul0Var);
                return;
            }
        } catch (Throwable th2) {
            Exceptions.throwIfFatal(th2);
            this.f27848l.cancel();
            onError(th2);
        }
    }

    @Override // io.reactivex.rxjava3.core.FlowableSubscriber, org.reactivestreams.Subscriber
    public final void onSubscribe(Subscription subscription) {
        if (SubscriptionHelper.validate(this.f27848l, subscription)) {
            this.f27848l = subscription;
            this.f27837a.onSubscribe(this);
            if (!this.f27845i) {
                int i = this.f27840d;
                if (i == Integer.MAX_VALUE) {
                    subscription.request(Long.MAX_VALUE);
                } else {
                    subscription.request(i);
                }
            }
        }
    }

    @Override // org.reactivestreams.Subscription
    public final void request(long j) {
        if (SubscriptionHelper.validate(j)) {
            BackpressureHelper.add(this.f27847k, j);
            m7919b();
        }
    }
}
