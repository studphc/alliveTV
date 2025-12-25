package p000;

import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionArbiter;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class nr0 implements FlowableSubscriber {

    /* renamed from: a */
    public final Subscriber f23464a;

    /* renamed from: b */
    public final SubscriptionArbiter f23465b;

    public nr0(Subscriber subscriber, SubscriptionArbiter subscriptionArbiter) {
        this.f23464a = subscriber;
        this.f23465b = subscriptionArbiter;
    }

    @Override // org.reactivestreams.Subscriber
    public final void onComplete() {
        this.f23464a.onComplete();
    }

    @Override // org.reactivestreams.Subscriber
    public final void onError(Throwable th) {
        this.f23464a.onError(th);
    }

    @Override // org.reactivestreams.Subscriber
    public final void onNext(Object obj) {
        this.f23464a.onNext(obj);
    }

    @Override // io.reactivex.rxjava3.core.FlowableSubscriber, org.reactivestreams.Subscriber
    public final void onSubscribe(Subscription subscription) {
        this.f23465b.setSubscription(subscription);
    }
}
