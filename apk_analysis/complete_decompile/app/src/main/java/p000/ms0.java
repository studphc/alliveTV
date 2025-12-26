package p000;

import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import io.reactivex.rxjava3.operators.SimpleQueue;
import java.util.Arrays;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class ms0 extends AtomicInteger implements Subscription {
    private static final long serialVersionUID = -2434867452883857743L;

    /* renamed from: a */
    public final Subscriber f23093a;

    /* renamed from: b */
    public final ns0[] f23094b;

    /* renamed from: c */
    public final Function f23095c;

    /* renamed from: d */
    public final AtomicLong f23096d;

    /* renamed from: e */
    public final AtomicThrowable f23097e;

    /* renamed from: f */
    public final boolean f23098f;

    /* renamed from: g */
    public volatile boolean f23099g;

    /* renamed from: h */
    public final Object[] f23100h;

    public ms0(Subscriber subscriber, Function function, boolean z, int i, int i2) {
        this.f23093a = subscriber;
        this.f23095c = function;
        this.f23098f = z;
        ns0[] ns0VarArr = new ns0[i];
        for (int i3 = 0; i3 < i; i3++) {
            ns0VarArr[i3] = new ns0(this, i2);
        }
        this.f23100h = new Object[i];
        this.f23094b = ns0VarArr;
        this.f23096d = new AtomicLong();
        this.f23097e = new AtomicThrowable();
    }

    /* renamed from: a */
    public final void m6244a() {
        for (ns0 ns0Var : this.f23094b) {
            ns0Var.getClass();
            SubscriptionHelper.cancel(ns0Var);
        }
    }

    /* renamed from: b */
    public final void m6245b() {
        Object obj;
        boolean z;
        Object obj2;
        boolean z2;
        if (getAndIncrement() != 0) {
            return;
        }
        Subscriber<?> subscriber = this.f23093a;
        ns0[] ns0VarArr = this.f23094b;
        int length = ns0VarArr.length;
        Object[] objArr = this.f23100h;
        int i = 1;
        do {
            long j = this.f23096d.get();
            long j2 = 0;
            while (j != j2) {
                if (this.f23099g) {
                    return;
                }
                if (!this.f23098f && this.f23097e.get() != null) {
                    m6244a();
                    this.f23097e.tryTerminateConsumer(subscriber);
                    return;
                }
                boolean z3 = false;
                for (int i2 = 0; i2 < length; i2++) {
                    ns0 ns0Var = ns0VarArr[i2];
                    if (objArr[i2] == null) {
                        boolean z4 = ns0Var.f23478f;
                        SimpleQueue simpleQueue = ns0Var.f23476d;
                        if (simpleQueue != null) {
                            try {
                                obj2 = simpleQueue.poll();
                            } catch (Throwable th) {
                                Exceptions.throwIfFatal(th);
                                this.f23097e.tryAddThrowableOrReport(th);
                                if (!this.f23098f) {
                                    m6244a();
                                    this.f23097e.tryTerminateConsumer(subscriber);
                                    return;
                                } else {
                                    obj2 = null;
                                    z4 = true;
                                }
                            }
                        } else {
                            obj2 = null;
                        }
                        if (obj2 == null) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        if (z4 && z2) {
                            m6244a();
                            this.f23097e.tryTerminateConsumer(subscriber);
                            return;
                        } else if (!z2) {
                            objArr[i2] = obj2;
                        } else {
                            z3 = true;
                        }
                    }
                }
                if (z3) {
                    break;
                }
                try {
                    Object apply = this.f23095c.apply(objArr.clone());
                    Objects.requireNonNull(apply, "The zipper returned a null value");
                    subscriber.onNext(apply);
                    j2++;
                    Arrays.fill(objArr, (Object) null);
                } catch (Throwable th2) {
                    Exceptions.throwIfFatal(th2);
                    m6244a();
                    this.f23097e.tryAddThrowableOrReport(th2);
                    this.f23097e.tryTerminateConsumer(subscriber);
                    return;
                }
            }
            if (j == j2) {
                if (this.f23099g) {
                    return;
                }
                if (!this.f23098f && this.f23097e.get() != null) {
                    m6244a();
                    this.f23097e.tryTerminateConsumer(subscriber);
                    return;
                }
                for (int i3 = 0; i3 < length; i3++) {
                    ns0 ns0Var2 = ns0VarArr[i3];
                    if (objArr[i3] == null) {
                        boolean z5 = ns0Var2.f23478f;
                        SimpleQueue simpleQueue2 = ns0Var2.f23476d;
                        if (simpleQueue2 != null) {
                            try {
                                obj = simpleQueue2.poll();
                            } catch (Throwable th3) {
                                Exceptions.throwIfFatal(th3);
                                this.f23097e.tryAddThrowableOrReport(th3);
                                if (!this.f23098f) {
                                    m6244a();
                                    this.f23097e.tryTerminateConsumer(subscriber);
                                    return;
                                } else {
                                    obj = null;
                                    z5 = true;
                                }
                            }
                        } else {
                            obj = null;
                        }
                        if (obj == null) {
                            z = true;
                        } else {
                            z = false;
                        }
                        if (z5 && z) {
                            m6244a();
                            this.f23097e.tryTerminateConsumer(subscriber);
                            return;
                        } else if (!z) {
                            objArr[i3] = obj;
                        }
                    }
                }
            }
            if (j2 != 0) {
                for (ns0 ns0Var3 : ns0VarArr) {
                    ns0Var3.request(j2);
                }
                if (j != Long.MAX_VALUE) {
                    this.f23096d.addAndGet(-j2);
                }
            }
            i = addAndGet(-i);
        } while (i != 0);
    }

    @Override // org.reactivestreams.Subscription
    public final void cancel() {
        if (!this.f23099g) {
            this.f23099g = true;
            m6244a();
        }
    }

    @Override // org.reactivestreams.Subscription
    public final void request(long j) {
        if (SubscriptionHelper.validate(j)) {
            BackpressureHelper.add(this.f23096d, j);
            m6245b();
        }
    }
}
