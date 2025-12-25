package p000;

import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class kk0 extends DeferredScalarSubscription implements FlowableSubscriber {
    private static final long serialVersionUID = 4973004223787171406L;

    /* renamed from: a */
    public Subscription f20882a;

    /* renamed from: b */
    public long f20883b;

    @Override // io.reactivex.rxjava3.internal.subscriptions.DeferredScalarSubscription, org.reactivestreams.Subscription
    public final void cancel() {
        super.cancel();
        this.f20882a.cancel();
    }

    @Override // org.reactivestreams.Subscriber
    public final void onComplete() {
        complete(Long.valueOf(this.f20883b));
    }

    @Override // org.reactivestreams.Subscriber
    public final void onError(Throwable th) {
        this.downstream.onError(th);
    }

    @Override // org.reactivestreams.Subscriber
    public final void onNext(Object obj) {
        this.f20883b++;
    }

    @Override // io.reactivex.rxjava3.core.FlowableSubscriber, org.reactivestreams.Subscriber
    public final void onSubscribe(Subscription subscription) {
        if (SubscriptionHelper.validate(this.f20882a, subscription)) {
            this.f20882a = subscription;
            this.downstream.onSubscribe(this);
            subscription.request(Long.MAX_VALUE);
        }
    }
}
