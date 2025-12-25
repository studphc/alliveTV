package p000;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.exceptions.MissingBackpressureException;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.QueueDrainHelper;
import io.reactivex.rxjava3.operators.QueueSubscription;
import io.reactivex.rxjava3.operators.SimpleQueue;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class no0 extends Flowable implements FlowableSubscriber {

    /* renamed from: m */
    public static final oo0[] f23429m = new oo0[0];

    /* renamed from: n */
    public static final oo0[] f23430n = new oo0[0];

    /* renamed from: d */
    public final int f23433d;

    /* renamed from: e */
    public final int f23434e;

    /* renamed from: f */
    public final boolean f23435f;

    /* renamed from: h */
    public volatile SimpleQueue f23437h;

    /* renamed from: i */
    public int f23438i;

    /* renamed from: j */
    public volatile boolean f23439j;

    /* renamed from: k */
    public Throwable f23440k;

    /* renamed from: l */
    public int f23441l;

    /* renamed from: b */
    public final AtomicInteger f23431b = new AtomicInteger();

    /* renamed from: g */
    public final AtomicReference f23436g = new AtomicReference();

    /* renamed from: c */
    public final AtomicReference f23432c = new AtomicReference(f23429m);

    public no0(int i, boolean z) {
        this.f23433d = i;
        this.f23434e = i - (i >> 2);
        this.f23435f = z;
    }

    public final void dispose() {
        SimpleQueue simpleQueue;
        if (!this.f23439j) {
            SubscriptionHelper.cancel(this.f23436g);
            if (this.f23431b.getAndIncrement() == 0 && (simpleQueue = this.f23437h) != null) {
                simpleQueue.clear();
            }
        }
    }

    /* renamed from: e */
    public final void m6389e() {
        for (oo0 oo0Var : (oo0[]) this.f23432c.getAndSet(f23430n)) {
            if (oo0Var.get() != Long.MIN_VALUE) {
                oo0Var.f24845a.onComplete();
            }
        }
    }

    /* renamed from: f */
    public final void m6390f() {
        boolean z;
        AtomicReference atomicReference;
        Throwable th;
        boolean z2;
        Throwable th2;
        if (this.f23431b.getAndIncrement() != 0) {
            return;
        }
        SimpleQueue simpleQueue = this.f23437h;
        int i = this.f23441l;
        int i2 = this.f23434e;
        if (this.f23438i != 1) {
            z = true;
        } else {
            z = false;
        }
        AtomicReference atomicReference2 = this.f23432c;
        oo0[] oo0VarArr = (oo0[]) atomicReference2.get();
        int i3 = 1;
        while (true) {
            int length = oo0VarArr.length;
            if (simpleQueue != null && length != 0) {
                int length2 = oo0VarArr.length;
                long j = Long.MAX_VALUE;
                long j2 = Long.MAX_VALUE;
                int i4 = 0;
                while (i4 < length2) {
                    oo0 oo0Var = oo0VarArr[i4];
                    AtomicReference atomicReference3 = atomicReference2;
                    long j3 = oo0Var.get() - oo0Var.f24847c;
                    if (j3 != Long.MIN_VALUE) {
                        if (j2 > j3) {
                            j2 = j3;
                        }
                    } else {
                        length--;
                    }
                    i4++;
                    atomicReference2 = atomicReference3;
                }
                atomicReference = atomicReference2;
                long j4 = 0;
                if (length == 0) {
                    j2 = 0;
                }
                while (j2 != j4) {
                    if (this.f23436g.get() == SubscriptionHelper.CANCELLED) {
                        simpleQueue.clear();
                        return;
                    }
                    boolean z3 = this.f23439j;
                    if (z3 && !this.f23435f && (th2 = this.f23440k) != null) {
                        m6391g(th2);
                        return;
                    }
                    try {
                        Object poll = simpleQueue.poll();
                        if (poll == null) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        if (z3 && z2) {
                            Throwable th3 = this.f23440k;
                            if (th3 != null) {
                                m6391g(th3);
                                return;
                            } else {
                                m6389e();
                                return;
                            }
                        }
                        if (z2) {
                            break;
                        }
                        int length3 = oo0VarArr.length;
                        int i5 = 0;
                        boolean z4 = false;
                        while (i5 < length3) {
                            oo0 oo0Var2 = oo0VarArr[i5];
                            long j5 = oo0Var2.get();
                            if (j5 != Long.MIN_VALUE) {
                                if (j5 != j) {
                                    oo0Var2.f24847c++;
                                }
                                oo0Var2.f24845a.onNext(poll);
                            } else {
                                z4 = true;
                            }
                            i5++;
                            j = Long.MAX_VALUE;
                        }
                        j2--;
                        if (z && (i = i + 1) == i2) {
                            ((Subscription) this.f23436g.get()).request(i2);
                            i = 0;
                        }
                        oo0[] oo0VarArr2 = (oo0[]) atomicReference.get();
                        if (!z4 && oo0VarArr2 == oo0VarArr) {
                            j4 = 0;
                            j = Long.MAX_VALUE;
                        } else {
                            oo0VarArr = oo0VarArr2;
                            break;
                        }
                    } catch (Throwable th4) {
                        Exceptions.throwIfFatal(th4);
                        SubscriptionHelper.cancel(this.f23436g);
                        m6391g(th4);
                        return;
                    }
                }
                if (j2 == j4) {
                    if (this.f23436g.get() == SubscriptionHelper.CANCELLED) {
                        simpleQueue.clear();
                        return;
                    }
                    boolean z5 = this.f23439j;
                    if (z5 && !this.f23435f && (th = this.f23440k) != null) {
                        m6391g(th);
                        return;
                    }
                    if (z5 && simpleQueue.isEmpty()) {
                        Throwable th5 = this.f23440k;
                        if (th5 != null) {
                            m6391g(th5);
                            return;
                        } else {
                            m6389e();
                            return;
                        }
                    }
                }
            } else {
                atomicReference = atomicReference2;
            }
            this.f23441l = i;
            i3 = this.f23431b.addAndGet(-i3);
            if (i3 == 0) {
                return;
            }
            if (simpleQueue == null) {
                simpleQueue = this.f23437h;
            }
            oo0VarArr = (oo0[]) atomicReference.get();
            atomicReference2 = atomicReference;
        }
    }

    /* renamed from: g */
    public final void m6391g(Throwable th) {
        for (oo0 oo0Var : (oo0[]) this.f23432c.getAndSet(f23430n)) {
            if (oo0Var.get() != Long.MIN_VALUE) {
                oo0Var.f24845a.onError(th);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: h */
    public final void m6392h(oo0 oo0Var) {
        oo0[] oo0VarArr;
        while (true) {
            AtomicReference atomicReference = this.f23432c;
            oo0[] oo0VarArr2 = (oo0[]) atomicReference.get();
            int length = oo0VarArr2.length;
            if (length == 0) {
                return;
            }
            int i = 0;
            while (true) {
                if (i < length) {
                    if (oo0VarArr2[i] == oo0Var) {
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
                oo0VarArr = f23429m;
            } else {
                oo0[] oo0VarArr3 = new oo0[length - 1];
                System.arraycopy(oo0VarArr2, 0, oo0VarArr3, 0, i);
                System.arraycopy(oo0VarArr2, i + 1, oo0VarArr3, i, (length - i) - 1);
                oo0VarArr = oo0VarArr3;
            }
            while (!atomicReference.compareAndSet(oo0VarArr2, oo0VarArr)) {
                if (atomicReference.get() != oo0VarArr2) {
                    break;
                }
            }
            return;
        }
    }

    @Override // org.reactivestreams.Subscriber
    public final void onComplete() {
        if (!this.f23439j) {
            this.f23439j = true;
            m6390f();
        }
    }

    @Override // org.reactivestreams.Subscriber
    public final void onError(Throwable th) {
        if (this.f23439j) {
            RxJavaPlugins.onError(th);
            return;
        }
        this.f23440k = th;
        this.f23439j = true;
        m6390f();
    }

    @Override // org.reactivestreams.Subscriber
    public final void onNext(Object obj) {
        if (this.f23439j) {
            return;
        }
        if (this.f23438i == 0 && !this.f23437h.offer(obj)) {
            ((Subscription) this.f23436g.get()).cancel();
            onError(new MissingBackpressureException());
        } else {
            m6390f();
        }
    }

    @Override // io.reactivex.rxjava3.core.FlowableSubscriber, org.reactivestreams.Subscriber
    public final void onSubscribe(Subscription subscription) {
        if (SubscriptionHelper.setOnce(this.f23436g, subscription)) {
            if (subscription instanceof QueueSubscription) {
                QueueSubscription queueSubscription = (QueueSubscription) subscription;
                int requestFusion = queueSubscription.requestFusion(3);
                if (requestFusion == 1) {
                    this.f23438i = requestFusion;
                    this.f23437h = queueSubscription;
                    this.f23439j = true;
                    m6390f();
                    return;
                }
                if (requestFusion == 2) {
                    this.f23438i = requestFusion;
                    this.f23437h = queueSubscription;
                    QueueDrainHelper.request(subscription, this.f23433d);
                    return;
                }
            }
            this.f23437h = QueueDrainHelper.createQueue(this.f23433d);
            QueueDrainHelper.request(subscription, this.f23433d);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.reactivex.rxjava3.core.Flowable
    public final void subscribeActual(Subscriber subscriber) {
        oo0 oo0Var = new oo0(subscriber, this);
        subscriber.onSubscribe(oo0Var);
        while (true) {
            AtomicReference atomicReference = this.f23432c;
            oo0[] oo0VarArr = (oo0[]) atomicReference.get();
            if (oo0VarArr == f23430n) {
                Throwable th = this.f23440k;
                if (th != null) {
                    subscriber.onError(th);
                    return;
                } else {
                    subscriber.onComplete();
                    return;
                }
            }
            int length = oo0VarArr.length;
            oo0[] oo0VarArr2 = new oo0[length + 1];
            System.arraycopy(oo0VarArr, 0, oo0VarArr2, 0, length);
            oo0VarArr2[length] = oo0Var;
            while (!atomicReference.compareAndSet(oo0VarArr, oo0VarArr2)) {
                if (atomicReference.get() != oo0VarArr) {
                    break;
                }
            }
            if (oo0Var.get() == Long.MIN_VALUE) {
                m6392h(oo0Var);
                return;
            } else {
                m6390f();
                return;
            }
        }
    }
}
