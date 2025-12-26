package p000;

import io.reactivex.rxjava3.internal.subscriptions.BasicQueueSubscription;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;

/* loaded from: classes2.dex */
public abstract class qo0 extends BasicQueueSubscription {
    private static final long serialVersionUID = -2252972430506210021L;

    /* renamed from: a */
    public final int f25703a;

    /* renamed from: b */
    public int f25704b;

    /* renamed from: c */
    public volatile boolean f25705c;

    public qo0(int i, int i2) {
        this.f25704b = i;
        this.f25703a = i2;
    }

    /* renamed from: a */
    public abstract void mo7114a();

    @Override // org.reactivestreams.Subscription
    public final void cancel() {
        this.f25705c = true;
    }

    @Override // io.reactivex.rxjava3.operators.SimpleQueue
    public final void clear() {
        this.f25704b = this.f25703a;
    }

    /* renamed from: e */
    public abstract void mo7115e(long j);

    @Override // io.reactivex.rxjava3.operators.SimpleQueue
    public final boolean isEmpty() {
        if (this.f25704b == this.f25703a) {
            return true;
        }
        return false;
    }

    @Override // io.reactivex.rxjava3.operators.SimpleQueue
    public final Object poll() {
        int i = this.f25704b;
        if (i == this.f25703a) {
            return null;
        }
        this.f25704b = i + 1;
        return Integer.valueOf(i);
    }

    @Override // org.reactivestreams.Subscription
    public final void request(long j) {
        if (SubscriptionHelper.validate(j) && BackpressureHelper.add(this, j) == 0) {
            if (j == Long.MAX_VALUE) {
                mo7114a();
            } else {
                mo7115e(j);
            }
        }
    }

    @Override // io.reactivex.rxjava3.operators.QueueFuseable
    public final int requestFusion(int i) {
        return i & 1;
    }
}
