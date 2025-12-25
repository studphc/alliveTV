package p000;

import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import java.io.Serializable;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class gp0 extends AtomicLong implements Subscription, Disposable {
    private static final long serialVersionUID = -4453897557930727610L;

    /* renamed from: a */
    public final mp0 f17784a;

    /* renamed from: b */
    public final Subscriber f17785b;

    /* renamed from: c */
    public Serializable f17786c;

    /* renamed from: d */
    public final AtomicLong f17787d = new AtomicLong();

    /* renamed from: e */
    public boolean f17788e;

    /* renamed from: f */
    public boolean f17789f;

    public gp0(mp0 mp0Var, Subscriber subscriber) {
        this.f17784a = mp0Var;
        this.f17785b = subscriber;
    }

    @Override // org.reactivestreams.Subscription
    public final void cancel() {
        dispose();
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final void dispose() {
        if (getAndSet(Long.MIN_VALUE) != Long.MIN_VALUE) {
            mp0 mp0Var = this.f17784a;
            mp0Var.m6207b(this);
            mp0Var.m6206a();
            this.f17786c = null;
        }
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final boolean isDisposed() {
        if (get() == Long.MIN_VALUE) {
            return true;
        }
        return false;
    }

    @Override // org.reactivestreams.Subscription
    public final void request(long j) {
        if (SubscriptionHelper.validate(j) && BackpressureHelper.addCancel(this, j) != Long.MIN_VALUE) {
            BackpressureHelper.add(this.f17787d, j);
            mp0 mp0Var = this.f17784a;
            mp0Var.m6206a();
            mp0Var.f23038a.mo4742c(this);
        }
    }
}
