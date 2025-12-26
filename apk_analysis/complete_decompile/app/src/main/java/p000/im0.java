package p000;

import io.reactivex.rxjava3.internal.subscriptions.BasicQueueSubscription;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import java.util.Objects;

/* loaded from: classes2.dex */
public abstract class im0 extends BasicQueueSubscription {
    private static final long serialVersionUID = -2252972430506210021L;

    /* renamed from: a */
    public final Object[] f18463a;

    /* renamed from: b */
    public int f18464b;

    /* renamed from: c */
    public volatile boolean f18465c;

    public im0(Object[] objArr) {
        this.f18463a = objArr;
    }

    /* renamed from: a */
    public abstract void mo4956a();

    @Override // org.reactivestreams.Subscription
    public final void cancel() {
        this.f18465c = true;
    }

    @Override // io.reactivex.rxjava3.operators.SimpleQueue
    public final void clear() {
        this.f18464b = this.f18463a.length;
    }

    /* renamed from: e */
    public abstract void mo4957e(long j);

    @Override // io.reactivex.rxjava3.operators.SimpleQueue
    public final boolean isEmpty() {
        if (this.f18464b == this.f18463a.length) {
            return true;
        }
        return false;
    }

    @Override // io.reactivex.rxjava3.operators.SimpleQueue
    public final Object poll() {
        int i = this.f18464b;
        Object[] objArr = this.f18463a;
        if (i == objArr.length) {
            return null;
        }
        this.f18464b = i + 1;
        Object obj = objArr[i];
        Objects.requireNonNull(obj, "array element is null");
        return obj;
    }

    @Override // org.reactivestreams.Subscription
    public final void request(long j) {
        if (SubscriptionHelper.validate(j) && BackpressureHelper.add(this, j) == 0) {
            if (j == Long.MAX_VALUE) {
                mo4956a();
            } else {
                mo4957e(j);
            }
        }
    }

    @Override // io.reactivex.rxjava3.operators.QueueFuseable
    public final int requestFusion(int i) {
        return i & 1;
    }
}
