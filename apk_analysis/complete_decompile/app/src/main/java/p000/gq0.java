package p000;

import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.BiPredicate;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import io.reactivex.rxjava3.operators.SimpleQueue;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes2.dex */
public final class gq0 extends AtomicInteger implements Disposable, eq0 {
    private static final long serialVersionUID = -6178010334400373240L;

    /* renamed from: a */
    public final SingleObserver f17792a;

    /* renamed from: b */
    public final BiPredicate f17793b;

    /* renamed from: c */
    public final fq0 f17794c;

    /* renamed from: d */
    public final fq0 f17795d;

    /* renamed from: e */
    public final AtomicThrowable f17796e = new AtomicThrowable();

    /* renamed from: f */
    public Object f17797f;

    /* renamed from: g */
    public Object f17798g;

    public gq0(SingleObserver singleObserver, int i, BiPredicate biPredicate) {
        this.f17792a = singleObserver;
        this.f17793b = biPredicate;
        this.f17794c = new fq0(this, i);
        this.f17795d = new fq0(this, i);
    }

    @Override // p000.eq0
    /* renamed from: a */
    public final void mo4601a(Throwable th) {
        if (this.f17796e.tryAddThrowableOrReport(th)) {
            drain();
        }
    }

    /* renamed from: b */
    public final void m4978b() {
        fq0 fq0Var = this.f17794c;
        fq0Var.getClass();
        SubscriptionHelper.cancel(fq0Var);
        fq0Var.m4825a();
        fq0 fq0Var2 = this.f17795d;
        fq0Var2.getClass();
        SubscriptionHelper.cancel(fq0Var2);
        fq0Var2.m4825a();
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final void dispose() {
        fq0 fq0Var = this.f17794c;
        fq0Var.getClass();
        SubscriptionHelper.cancel(fq0Var);
        fq0 fq0Var2 = this.f17795d;
        fq0Var2.getClass();
        SubscriptionHelper.cancel(fq0Var2);
        this.f17796e.tryTerminateAndReport();
        if (getAndIncrement() == 0) {
            fq0Var.m4825a();
            fq0Var2.m4825a();
        }
    }

    @Override // p000.eq0
    public final void drain() {
        boolean z;
        if (getAndIncrement() != 0) {
            return;
        }
        int i = 1;
        do {
            SimpleQueue simpleQueue = this.f17794c.f17366e;
            SimpleQueue simpleQueue2 = this.f17795d.f17366e;
            if (simpleQueue != null && simpleQueue2 != null) {
                while (!isDisposed()) {
                    if (this.f17796e.get() != null) {
                        m4978b();
                        this.f17796e.tryTerminateConsumer(this.f17792a);
                        return;
                    }
                    boolean z2 = this.f17794c.f17367f;
                    Object obj = this.f17797f;
                    if (obj == null) {
                        try {
                            obj = simpleQueue.poll();
                            this.f17797f = obj;
                        } catch (Throwable th) {
                            Exceptions.throwIfFatal(th);
                            m4978b();
                            this.f17796e.tryAddThrowableOrReport(th);
                            this.f17796e.tryTerminateConsumer(this.f17792a);
                            return;
                        }
                    }
                    boolean z3 = false;
                    if (obj == null) {
                        z = true;
                    } else {
                        z = false;
                    }
                    boolean z4 = this.f17795d.f17367f;
                    Object obj2 = this.f17798g;
                    if (obj2 == null) {
                        try {
                            obj2 = simpleQueue2.poll();
                            this.f17798g = obj2;
                        } catch (Throwable th2) {
                            Exceptions.throwIfFatal(th2);
                            m4978b();
                            this.f17796e.tryAddThrowableOrReport(th2);
                            this.f17796e.tryTerminateConsumer(this.f17792a);
                            return;
                        }
                    }
                    if (obj2 == null) {
                        z3 = true;
                    }
                    if (z2 && z4 && z && z3) {
                        this.f17792a.onSuccess(Boolean.TRUE);
                        return;
                    }
                    if (z2 && z4 && z != z3) {
                        m4978b();
                        this.f17792a.onSuccess(Boolean.FALSE);
                        return;
                    }
                    if (!z && !z3) {
                        try {
                            if (!this.f17793b.test(obj, obj2)) {
                                m4978b();
                                this.f17792a.onSuccess(Boolean.FALSE);
                                return;
                            } else {
                                this.f17797f = null;
                                this.f17798g = null;
                                this.f17794c.m4826b();
                                this.f17795d.m4826b();
                            }
                        } catch (Throwable th3) {
                            Exceptions.throwIfFatal(th3);
                            m4978b();
                            this.f17796e.tryAddThrowableOrReport(th3);
                            this.f17796e.tryTerminateConsumer(this.f17792a);
                            return;
                        }
                    }
                }
                this.f17794c.m4825a();
                this.f17795d.m4825a();
                return;
            }
            if (isDisposed()) {
                this.f17794c.m4825a();
                this.f17795d.m4825a();
                return;
            } else if (this.f17796e.get() != null) {
                m4978b();
                this.f17796e.tryTerminateConsumer(this.f17792a);
                return;
            }
            i = addAndGet(-i);
        } while (i != 0);
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final boolean isDisposed() {
        if (this.f17794c.get() == SubscriptionHelper.CANCELLED) {
            return true;
        }
        return false;
    }
}
