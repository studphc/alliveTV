package p000;

import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.BiPredicate;
import io.reactivex.rxjava3.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import io.reactivex.rxjava3.operators.SimpleQueue;
import java.util.concurrent.atomic.AtomicInteger;
import org.reactivestreams.Subscriber;

/* loaded from: classes2.dex */
public final class dq0 extends DeferredScalarSubscription implements eq0 {
    private static final long serialVersionUID = -6178010334400373240L;

    /* renamed from: a */
    public final BiPredicate f16484a;

    /* renamed from: b */
    public final fq0 f16485b;

    /* renamed from: c */
    public final fq0 f16486c;

    /* renamed from: d */
    public final AtomicThrowable f16487d;

    /* renamed from: e */
    public final AtomicInteger f16488e;

    /* renamed from: f */
    public Object f16489f;

    /* renamed from: g */
    public Object f16490g;

    public dq0(Subscriber subscriber, int i, BiPredicate biPredicate) {
        super(subscriber);
        this.f16484a = biPredicate;
        this.f16488e = new AtomicInteger();
        this.f16485b = new fq0(this, i);
        this.f16486c = new fq0(this, i);
        this.f16487d = new AtomicThrowable();
    }

    @Override // p000.eq0
    /* renamed from: a */
    public final void mo4601a(Throwable th) {
        if (this.f16487d.tryAddThrowableOrReport(th)) {
            drain();
        }
    }

    @Override // io.reactivex.rxjava3.internal.subscriptions.DeferredScalarSubscription, org.reactivestreams.Subscription
    public final void cancel() {
        super.cancel();
        fq0 fq0Var = this.f16485b;
        fq0Var.getClass();
        SubscriptionHelper.cancel(fq0Var);
        fq0 fq0Var2 = this.f16486c;
        fq0Var2.getClass();
        SubscriptionHelper.cancel(fq0Var2);
        this.f16487d.tryTerminateAndReport();
        if (this.f16488e.getAndIncrement() == 0) {
            fq0Var.m4825a();
            fq0Var2.m4825a();
        }
    }

    @Override // p000.eq0
    public final void drain() {
        boolean z;
        if (this.f16488e.getAndIncrement() != 0) {
            return;
        }
        int i = 1;
        do {
            SimpleQueue simpleQueue = this.f16485b.f17366e;
            SimpleQueue simpleQueue2 = this.f16486c.f17366e;
            if (simpleQueue != null && simpleQueue2 != null) {
                while (!isCancelled()) {
                    if (this.f16487d.get() != null) {
                        m4602e();
                        this.f16487d.tryTerminateConsumer(this.downstream);
                        return;
                    }
                    boolean z2 = this.f16485b.f17367f;
                    Object obj = this.f16489f;
                    if (obj == null) {
                        try {
                            obj = simpleQueue.poll();
                            this.f16489f = obj;
                        } catch (Throwable th) {
                            Exceptions.throwIfFatal(th);
                            m4602e();
                            this.f16487d.tryAddThrowableOrReport(th);
                            this.f16487d.tryTerminateConsumer(this.downstream);
                            return;
                        }
                    }
                    boolean z3 = false;
                    if (obj == null) {
                        z = true;
                    } else {
                        z = false;
                    }
                    boolean z4 = this.f16486c.f17367f;
                    Object obj2 = this.f16490g;
                    if (obj2 == null) {
                        try {
                            obj2 = simpleQueue2.poll();
                            this.f16490g = obj2;
                        } catch (Throwable th2) {
                            Exceptions.throwIfFatal(th2);
                            m4602e();
                            this.f16487d.tryAddThrowableOrReport(th2);
                            this.f16487d.tryTerminateConsumer(this.downstream);
                            return;
                        }
                    }
                    if (obj2 == null) {
                        z3 = true;
                    }
                    if (z2 && z4 && z && z3) {
                        complete(Boolean.TRUE);
                        return;
                    }
                    if (z2 && z4 && z != z3) {
                        m4602e();
                        complete(Boolean.FALSE);
                        return;
                    }
                    if (!z && !z3) {
                        try {
                            if (!this.f16484a.test(obj, obj2)) {
                                m4602e();
                                complete(Boolean.FALSE);
                                return;
                            } else {
                                this.f16489f = null;
                                this.f16490g = null;
                                this.f16485b.m4826b();
                                this.f16486c.m4826b();
                            }
                        } catch (Throwable th3) {
                            Exceptions.throwIfFatal(th3);
                            m4602e();
                            this.f16487d.tryAddThrowableOrReport(th3);
                            this.f16487d.tryTerminateConsumer(this.downstream);
                            return;
                        }
                    }
                }
                this.f16485b.m4825a();
                this.f16486c.m4825a();
                return;
            }
            if (isCancelled()) {
                this.f16485b.m4825a();
                this.f16486c.m4825a();
                return;
            } else if (this.f16487d.get() != null) {
                m4602e();
                this.f16487d.tryTerminateConsumer(this.downstream);
                return;
            }
            i = this.f16488e.addAndGet(-i);
        } while (i != 0);
    }

    /* renamed from: e */
    public final void m4602e() {
        fq0 fq0Var = this.f16485b;
        fq0Var.getClass();
        SubscriptionHelper.cancel(fq0Var);
        fq0Var.m4825a();
        fq0 fq0Var2 = this.f16486c;
        fq0Var2.getClass();
        SubscriptionHelper.cancel(fq0Var2);
        fq0Var2.m4825a();
    }
}
