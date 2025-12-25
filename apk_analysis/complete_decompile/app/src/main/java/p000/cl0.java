package p000;

import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class cl0 extends AtomicReference implements FlowableSubscriber {
    private static final long serialVersionUID = -3892798459447644106L;

    /* renamed from: a */
    public final /* synthetic */ dl0 f8410a;

    public cl0(dl0 dl0Var) {
        this.f8410a = dl0Var;
    }

    @Override // org.reactivestreams.Subscriber
    public final void onComplete() {
        if (((Subscription) get()) != SubscriptionHelper.CANCELLED) {
            dl0 dl0Var = this.f8410a;
            dl0Var.f16405b.subscribe(dl0Var);
        }
    }

    @Override // org.reactivestreams.Subscriber
    public final void onError(Throwable th) {
        if (((Subscription) get()) != SubscriptionHelper.CANCELLED) {
            this.f8410a.f16404a.onError(th);
        } else {
            RxJavaPlugins.onError(th);
        }
    }

    @Override // org.reactivestreams.Subscriber
    public final void onNext(Object obj) {
        Subscription subscription = (Subscription) get();
        SubscriptionHelper subscriptionHelper = SubscriptionHelper.CANCELLED;
        if (subscription != subscriptionHelper) {
            lazySet(subscriptionHelper);
            subscription.cancel();
            dl0 dl0Var = this.f8410a;
            dl0Var.f16405b.subscribe(dl0Var);
        }
    }

    @Override // io.reactivex.rxjava3.core.FlowableSubscriber, org.reactivestreams.Subscriber
    public final void onSubscribe(Subscription subscription) {
        if (SubscriptionHelper.setOnce(this, subscription)) {
            subscription.request(Long.MAX_VALUE);
        }
    }
}
