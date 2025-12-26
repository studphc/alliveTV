package p000;

import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class cr0 extends DeferredScalarSubscription implements FlowableSubscriber {
    private static final long serialVersionUID = -5467847744262967226L;

    /* renamed from: a */
    public Subscription f16086a;

    @Override // io.reactivex.rxjava3.internal.subscriptions.DeferredScalarSubscription, org.reactivestreams.Subscription
    public final void cancel() {
        super.cancel();
        this.f16086a.cancel();
    }

    @Override // org.reactivestreams.Subscriber
    public final void onComplete() {
        T t = this.value;
        if (t != 0) {
            complete(t);
        } else {
            this.downstream.onComplete();
        }
    }

    @Override // org.reactivestreams.Subscriber
    public final void onError(Throwable th) {
        this.value = null;
        this.downstream.onError(th);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.reactivestreams.Subscriber
    public final void onNext(Object obj) {
        this.value = obj;
    }

    @Override // io.reactivex.rxjava3.core.FlowableSubscriber, org.reactivestreams.Subscriber
    public final void onSubscribe(Subscription subscription) {
        if (SubscriptionHelper.validate(this.f16086a, subscription)) {
            this.f16086a = subscription;
            this.downstream.onSubscribe(this);
            subscription.request(Long.MAX_VALUE);
        }
    }
}
