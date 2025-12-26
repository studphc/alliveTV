package p000;

import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.HalfSerializer;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class ls0 extends AtomicReference implements FlowableSubscriber {
    private static final long serialVersionUID = 3256684027868224024L;

    /* renamed from: a */
    public final ks0 f22654a;

    /* renamed from: b */
    public final int f22655b;

    /* renamed from: c */
    public boolean f22656c;

    public ls0(ks0 ks0Var, int i) {
        this.f22654a = ks0Var;
        this.f22655b = i;
    }

    @Override // org.reactivestreams.Subscriber
    public final void onComplete() {
        ks0 ks0Var = this.f22654a;
        int i = this.f22655b;
        if (!this.f22656c) {
            ks0Var.f22185h = true;
            SubscriptionHelper.cancel(ks0Var.f22182e);
            ks0Var.m5784a(i);
            HalfSerializer.onComplete((Subscriber<?>) ks0Var.f22178a, ks0Var, ks0Var.f22184g);
            return;
        }
        ks0Var.getClass();
    }

    @Override // org.reactivestreams.Subscriber
    public final void onError(Throwable th) {
        ks0 ks0Var = this.f22654a;
        int i = this.f22655b;
        ks0Var.f22185h = true;
        SubscriptionHelper.cancel(ks0Var.f22182e);
        ks0Var.m5784a(i);
        HalfSerializer.onError((Subscriber<?>) ks0Var.f22178a, th, ks0Var, ks0Var.f22184g);
    }

    @Override // org.reactivestreams.Subscriber
    public final void onNext(Object obj) {
        if (!this.f22656c) {
            this.f22656c = true;
        }
        this.f22654a.f22181d.set(this.f22655b, obj);
    }

    @Override // io.reactivex.rxjava3.core.FlowableSubscriber, org.reactivestreams.Subscriber
    public final void onSubscribe(Subscription subscription) {
        SubscriptionHelper.setOnce(this, subscription, Long.MAX_VALUE);
    }
}
