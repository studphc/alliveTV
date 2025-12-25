package p000;

import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class lo0 extends AtomicLong implements Subscription {
    private static final long serialVersionUID = 2845000326761540265L;

    /* renamed from: a */
    public final Subscriber f22593a;

    /* renamed from: b */
    public final mo0 f22594b;

    /* renamed from: c */
    public long f22595c;

    public lo0(Subscriber subscriber, mo0 mo0Var) {
        this.f22593a = subscriber;
        this.f22594b = mo0Var;
    }

    /* renamed from: a */
    public final boolean m5961a() {
        if (get() == Long.MIN_VALUE) {
            return true;
        }
        return false;
    }

    @Override // org.reactivestreams.Subscription
    public final void cancel() {
        if (getAndSet(Long.MIN_VALUE) != Long.MIN_VALUE) {
            mo0 mo0Var = this.f22594b;
            mo0Var.m6202c(this);
            mo0Var.m6201b();
        }
    }

    @Override // org.reactivestreams.Subscription
    public final void request(long j) {
        if (SubscriptionHelper.validate(j)) {
            BackpressureHelper.addCancel(this, j);
            this.f22594b.m6201b();
        }
    }
}
