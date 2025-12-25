package p000;

import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.exceptions.MissingBackpressureException;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.operators.QueueSubscription;
import io.reactivex.rxjava3.operators.SimpleQueue;
import io.reactivex.rxjava3.operators.SpscArrayQueue;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class mo0 extends AtomicInteger implements FlowableSubscriber, Disposable {

    /* renamed from: k */
    public static final lo0[] f23011k = new lo0[0];

    /* renamed from: l */
    public static final lo0[] f23012l = new lo0[0];
    private static final long serialVersionUID = -1672047311619175801L;

    /* renamed from: a */
    public final AtomicReference f23013a;

    /* renamed from: b */
    public final AtomicReference f23014b = new AtomicReference();

    /* renamed from: c */
    public final AtomicBoolean f23015c = new AtomicBoolean();

    /* renamed from: d */
    public final AtomicReference f23016d = new AtomicReference(f23011k);

    /* renamed from: e */
    public final int f23017e;

    /* renamed from: f */
    public volatile SimpleQueue f23018f;

    /* renamed from: g */
    public int f23019g;

    /* renamed from: h */
    public volatile boolean f23020h;

    /* renamed from: i */
    public Throwable f23021i;

    /* renamed from: j */
    public int f23022j;

    public mo0(AtomicReference atomicReference, int i) {
        this.f23013a = atomicReference;
        this.f23017e = i;
    }

    /* renamed from: a */
    public final boolean m6200a(boolean z, boolean z2) {
        if (!z || !z2) {
            return false;
        }
        Throwable th = this.f23021i;
        if (th != null) {
            m6203d(th);
            return true;
        }
        for (lo0 lo0Var : (lo0[]) this.f23016d.getAndSet(f23012l)) {
            if (!lo0Var.m5961a()) {
                lo0Var.f22593a.onComplete();
            }
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: b */
    public final void m6201b() {
        boolean z;
        boolean z2;
        if (getAndIncrement() != 0) {
            return;
        }
        SimpleQueue simpleQueue = this.f23018f;
        int i = this.f23022j;
        int i2 = this.f23017e;
        int i3 = i2 - (i2 >> 2);
        if (this.f23019g != 1) {
            z = true;
        } else {
            z = false;
        }
        int i4 = 1;
        SimpleQueue simpleQueue2 = simpleQueue;
        int i5 = i;
        while (true) {
            if (simpleQueue2 != null) {
                lo0[] lo0VarArr = (lo0[]) this.f23016d.get();
                long j = Long.MAX_VALUE;
                boolean z3 = false;
                for (lo0 lo0Var : lo0VarArr) {
                    long j2 = lo0Var.get();
                    if (j2 != Long.MIN_VALUE) {
                        j = Math.min(j2 - lo0Var.f22595c, j);
                        z3 = true;
                    }
                }
                if (!z3) {
                    j = 0;
                }
                for (long j3 = 0; j != j3; j3 = 0) {
                    boolean z4 = this.f23020h;
                    try {
                        Object poll = simpleQueue2.poll();
                        if (poll == null) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        if (m6200a(z4, z2)) {
                            return;
                        }
                        if (z2) {
                            break;
                        }
                        for (lo0 lo0Var2 : lo0VarArr) {
                            if (!lo0Var2.m5961a()) {
                                lo0Var2.f22593a.onNext(poll);
                                lo0Var2.f22595c++;
                            }
                        }
                        if (z && (i5 = i5 + 1) == i3) {
                            ((Subscription) this.f23014b.get()).request(i3);
                            i5 = 0;
                        }
                        j--;
                        if (lo0VarArr != this.f23016d.get()) {
                            break;
                        }
                    } catch (Throwable th) {
                        Exceptions.throwIfFatal(th);
                        ((Subscription) this.f23014b.get()).cancel();
                        simpleQueue2.clear();
                        this.f23020h = true;
                        m6203d(th);
                        return;
                    }
                }
                if (m6200a(this.f23020h, simpleQueue2.isEmpty())) {
                    return;
                }
            }
            this.f23022j = i5;
            i4 = addAndGet(-i4);
            if (i4 == 0) {
                return;
            }
            if (simpleQueue2 == null) {
                simpleQueue2 = this.f23018f;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: c */
    public final void m6202c(lo0 lo0Var) {
        lo0[] lo0VarArr;
        while (true) {
            AtomicReference atomicReference = this.f23016d;
            lo0[] lo0VarArr2 = (lo0[]) atomicReference.get();
            int length = lo0VarArr2.length;
            if (length != 0) {
                int i = 0;
                while (true) {
                    if (i < length) {
                        if (lo0VarArr2[i] == lo0Var) {
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
                    lo0VarArr = f23011k;
                } else {
                    lo0[] lo0VarArr3 = new lo0[length - 1];
                    System.arraycopy(lo0VarArr2, 0, lo0VarArr3, 0, i);
                    System.arraycopy(lo0VarArr2, i + 1, lo0VarArr3, i, (length - i) - 1);
                    lo0VarArr = lo0VarArr3;
                }
                while (!atomicReference.compareAndSet(lo0VarArr2, lo0VarArr)) {
                    if (atomicReference.get() != lo0VarArr2) {
                        break;
                    }
                }
                return;
            }
            return;
        }
    }

    /* renamed from: d */
    public final void m6203d(Throwable th) {
        for (lo0 lo0Var : (lo0[]) this.f23016d.getAndSet(f23012l)) {
            if (!lo0Var.m5961a()) {
                lo0Var.f22593a.onError(th);
            }
        }
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final void dispose() {
        AtomicReference atomicReference;
        this.f23016d.getAndSet(f23012l);
        do {
            atomicReference = this.f23013a;
            if (atomicReference.compareAndSet(this, null)) {
                break;
            }
        } while (atomicReference.get() == this);
        SubscriptionHelper.cancel(this.f23014b);
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final boolean isDisposed() {
        if (this.f23016d.get() == f23012l) {
            return true;
        }
        return false;
    }

    @Override // org.reactivestreams.Subscriber
    public final void onComplete() {
        this.f23020h = true;
        m6201b();
    }

    @Override // org.reactivestreams.Subscriber
    public final void onError(Throwable th) {
        if (this.f23020h) {
            RxJavaPlugins.onError(th);
            return;
        }
        this.f23021i = th;
        this.f23020h = true;
        m6201b();
    }

    @Override // org.reactivestreams.Subscriber
    public final void onNext(Object obj) {
        if (this.f23019g == 0 && !this.f23018f.offer(obj)) {
            onError(new MissingBackpressureException("Prefetch queue is full?!"));
        } else {
            m6201b();
        }
    }

    @Override // io.reactivex.rxjava3.core.FlowableSubscriber, org.reactivestreams.Subscriber
    public final void onSubscribe(Subscription subscription) {
        if (SubscriptionHelper.setOnce(this.f23014b, subscription)) {
            if (subscription instanceof QueueSubscription) {
                QueueSubscription queueSubscription = (QueueSubscription) subscription;
                int requestFusion = queueSubscription.requestFusion(7);
                if (requestFusion == 1) {
                    this.f23019g = requestFusion;
                    this.f23018f = queueSubscription;
                    this.f23020h = true;
                    m6201b();
                    return;
                }
                if (requestFusion == 2) {
                    this.f23019g = requestFusion;
                    this.f23018f = queueSubscription;
                    subscription.request(this.f23017e);
                    return;
                }
            }
            this.f23018f = new SpscArrayQueue(this.f23017e);
            subscription.request(this.f23017e);
        }
    }
}
