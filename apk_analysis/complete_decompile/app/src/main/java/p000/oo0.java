package p000;

import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class oo0 extends AtomicLong implements Subscription {
    private static final long serialVersionUID = 8664815189257569791L;

    /* renamed from: a */
    public final Subscriber f24845a;

    /* renamed from: b */
    public final no0 f24846b;

    /* renamed from: c */
    public long f24847c;

    public oo0(Subscriber subscriber, no0 no0Var) {
        this.f24845a = subscriber;
        this.f24846b = no0Var;
    }

    @Override // org.reactivestreams.Subscription
    public final void cancel() {
        if (getAndSet(Long.MIN_VALUE) != Long.MIN_VALUE) {
            no0 no0Var = this.f24846b;
            no0Var.m6392h(this);
            no0Var.m6390f();
        }
    }

    @Override // org.reactivestreams.Subscription
    public final void request(long j) {
        if (SubscriptionHelper.validate(j)) {
            BackpressureHelper.addCancel(this, j);
            this.f24846b.m6390f();
        }
    }
}
