package io.reactivex.rxjava3.subscribers;

import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.EndConsumerHelper;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public abstract class DefaultSubscriber<T> implements FlowableSubscriber<T> {

    /* renamed from: a */
    public Subscription f20147a;

    public final void cancel() {
        Subscription subscription = this.f20147a;
        this.f20147a = SubscriptionHelper.CANCELLED;
        subscription.cancel();
    }

    public void onStart() {
        request(Long.MAX_VALUE);
    }

    @Override // io.reactivex.rxjava3.core.FlowableSubscriber, org.reactivestreams.Subscriber
    public final void onSubscribe(Subscription subscription) {
        if (EndConsumerHelper.validate(this.f20147a, subscription, getClass())) {
            this.f20147a = subscription;
            onStart();
        }
    }

    public final void request(long j) {
        Subscription subscription = this.f20147a;
        if (subscription != null) {
            subscription.request(j);
        }
    }
}
