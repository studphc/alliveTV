package p000;

import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class cs0 extends AtomicReference implements FlowableSubscriber {
    private static final long serialVersionUID = -3326496781427702834L;

    /* renamed from: a */
    public final ds0 f16096a;

    public cs0(ds0 ds0Var) {
        this.f16096a = ds0Var;
    }

    @Override // org.reactivestreams.Subscriber
    public final void onComplete() {
        ds0 ds0Var = this.f16096a;
        ds0Var.f16527o = true;
        ds0Var.m4606a();
    }

    @Override // org.reactivestreams.Subscriber
    public final void onError(Throwable th) {
        ds0 ds0Var = this.f16096a;
        ds0Var.f16529q.cancel();
        ds0Var.f16517e.dispose();
        if (ds0Var.f16528p.tryAddThrowableOrReport(th)) {
            ds0Var.f16526n = true;
            ds0Var.m4606a();
        }
    }

    @Override // org.reactivestreams.Subscriber
    public final void onNext(Object obj) {
        ds0 ds0Var = this.f16096a;
        ds0Var.f16520h.offer(new bs0(obj));
        ds0Var.m4606a();
    }

    @Override // io.reactivex.rxjava3.core.FlowableSubscriber, org.reactivestreams.Subscriber
    public final void onSubscribe(Subscription subscription) {
        if (SubscriptionHelper.setOnce(this, subscription)) {
            subscription.request(Long.MAX_VALUE);
        }
    }
}
