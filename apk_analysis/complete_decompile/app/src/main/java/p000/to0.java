package p000;

import io.reactivex.rxjava3.internal.subscriptions.BasicQueueSubscription;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;

/* loaded from: classes2.dex */
public abstract class to0 extends BasicQueueSubscription {
    private static final long serialVersionUID = -2252972430506210021L;

    /* renamed from: a */
    public final long f26907a;

    /* renamed from: b */
    public long f26908b;

    /* renamed from: c */
    public volatile boolean f26909c;

    public to0(long j, long j2) {
        this.f26908b = j;
        this.f26907a = j2;
    }

    /* renamed from: a */
    public abstract void mo7501a();

    @Override // org.reactivestreams.Subscription
    public final void cancel() {
        this.f26909c = true;
    }

    @Override // io.reactivex.rxjava3.operators.SimpleQueue
    public final void clear() {
        this.f26908b = this.f26907a;
    }

    /* renamed from: e */
    public abstract void mo7502e(long j);

    @Override // io.reactivex.rxjava3.operators.SimpleQueue
    public final boolean isEmpty() {
        if (this.f26908b == this.f26907a) {
            return true;
        }
        return false;
    }

    @Override // io.reactivex.rxjava3.operators.SimpleQueue
    public final Object poll() {
        long j = this.f26908b;
        if (j == this.f26907a) {
            return null;
        }
        this.f26908b = 1 + j;
        return Long.valueOf(j);
    }

    @Override // org.reactivestreams.Subscription
    public final void request(long j) {
        if (SubscriptionHelper.validate(j) && BackpressureHelper.add(this, j) == 0) {
            if (j == Long.MAX_VALUE) {
                mo7501a();
            } else {
                mo7502e(j);
            }
        }
    }

    @Override // io.reactivex.rxjava3.operators.QueueFuseable
    public final int requestFusion(int i) {
        return i & 1;
    }
}
