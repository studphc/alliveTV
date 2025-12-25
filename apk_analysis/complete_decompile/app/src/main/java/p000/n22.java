package p000;

import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public abstract class n22 extends AtomicInteger implements Subscription {
    private static final long serialVersionUID = 3100232009247827843L;

    /* renamed from: a */
    public final Subscriber f23201a;

    /* renamed from: b */
    public final l22[] f23202b;

    /* renamed from: e */
    public volatile boolean f23205e;

    /* renamed from: c */
    public final AtomicThrowable f23203c = new AtomicThrowable();

    /* renamed from: d */
    public final AtomicLong f23204d = new AtomicLong();

    /* renamed from: f */
    public final AtomicInteger f23206f = new AtomicInteger();

    public n22(Subscriber subscriber, int i, int i2) {
        this.f23201a = subscriber;
        l22[] l22VarArr = new l22[i];
        for (int i3 = 0; i3 < i; i3++) {
            l22VarArr[i3] = new l22(this, i2);
        }
        this.f23202b = l22VarArr;
        this.f23206f.lazySet(i);
    }

    /* renamed from: a */
    public final void m6271a() {
        for (l22 l22Var : this.f23202b) {
            l22Var.getClass();
            SubscriptionHelper.cancel(l22Var);
        }
    }

    /* renamed from: b */
    public final void m6272b() {
        for (l22 l22Var : this.f23202b) {
            l22Var.f22307e = null;
        }
    }

    /* renamed from: c */
    public abstract void mo6010c();

    @Override // org.reactivestreams.Subscription
    public final void cancel() {
        if (!this.f23205e) {
            this.f23205e = true;
            m6271a();
            if (getAndIncrement() == 0) {
                m6272b();
            }
        }
    }

    /* renamed from: d */
    public abstract void mo6011d();

    /* renamed from: e */
    public abstract void mo6012e(Throwable th);

    /* renamed from: f */
    public abstract void mo6013f(l22 l22Var, Object obj);

    @Override // org.reactivestreams.Subscription
    public final void request(long j) {
        if (SubscriptionHelper.validate(j)) {
            BackpressureHelper.add(this.f23204d, j);
            mo6010c();
        }
    }
}
