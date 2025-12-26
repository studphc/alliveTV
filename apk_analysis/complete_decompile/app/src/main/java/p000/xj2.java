package p000;

import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class xj2 extends AtomicReference implements FlowableSubscriber {
    private static final long serialVersionUID = 5170026210238877381L;

    /* renamed from: a */
    public final wj2 f28591a;

    public xj2(wj2 wj2Var) {
        this.f28591a = wj2Var;
    }

    @Override // org.reactivestreams.Subscriber
    public final void onComplete() {
        Object obj = get();
        SubscriptionHelper subscriptionHelper = SubscriptionHelper.CANCELLED;
        if (obj != subscriptionHelper) {
            lazySet(subscriptionHelper);
            this.f28591a.m8061a(new CancellationException());
        }
    }

    @Override // org.reactivestreams.Subscriber
    public final void onError(Throwable th) {
        this.f28591a.m8061a(th);
    }

    @Override // org.reactivestreams.Subscriber
    public final void onNext(Object obj) {
        if (SubscriptionHelper.cancel(this)) {
            this.f28591a.m8061a(new CancellationException());
        }
    }

    @Override // io.reactivex.rxjava3.core.FlowableSubscriber, org.reactivestreams.Subscriber
    public final void onSubscribe(Subscription subscription) {
        SubscriptionHelper.setOnce(this, subscription, Long.MAX_VALUE);
    }
}
