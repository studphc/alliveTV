package p000;

import io.reactivex.rxjava3.internal.subscriptions.BasicQueueSubscription;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import java.util.Iterator;
import java.util.Objects;

/* loaded from: classes2.dex */
public abstract class lm0 extends BasicQueueSubscription {
    private static final long serialVersionUID = -2252972430506210021L;

    /* renamed from: a */
    public Iterator f22562a;

    /* renamed from: b */
    public volatile boolean f22563b;

    /* renamed from: c */
    public boolean f22564c;

    public lm0(Iterator it) {
        this.f22562a = it;
    }

    /* renamed from: a */
    public abstract void mo5956a();

    @Override // org.reactivestreams.Subscription
    public final void cancel() {
        this.f22563b = true;
    }

    @Override // io.reactivex.rxjava3.operators.SimpleQueue
    public final void clear() {
        this.f22562a = null;
    }

    /* renamed from: e */
    public abstract void mo5957e(long j);

    @Override // io.reactivex.rxjava3.operators.SimpleQueue
    public final boolean isEmpty() {
        Iterator it = this.f22562a;
        if (it != null) {
            if (this.f22564c && !it.hasNext()) {
                this.f22562a = null;
                return true;
            }
            return false;
        }
        return true;
    }

    @Override // io.reactivex.rxjava3.operators.SimpleQueue
    public final Object poll() {
        Iterator it = this.f22562a;
        if (it == null) {
            return null;
        }
        if (!this.f22564c) {
            this.f22564c = true;
        } else if (!it.hasNext()) {
            return null;
        }
        Object next = this.f22562a.next();
        Objects.requireNonNull(next, "Iterator.next() returned a null value");
        return next;
    }

    @Override // org.reactivestreams.Subscription
    public final void request(long j) {
        if (SubscriptionHelper.validate(j) && BackpressureHelper.add(this, j) == 0) {
            if (j == Long.MAX_VALUE) {
                mo5956a();
            } else {
                mo5957e(j);
            }
        }
    }

    @Override // io.reactivex.rxjava3.operators.QueueFuseable
    public final int requestFusion(int i) {
        return i & 1;
    }
}
