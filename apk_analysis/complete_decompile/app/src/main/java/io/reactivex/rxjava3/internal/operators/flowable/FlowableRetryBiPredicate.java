package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.functions.BiPredicate;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionArbiter;
import org.reactivestreams.Subscriber;
import p000.AbstractC1215g0;
import p000.rp0;

/* loaded from: classes2.dex */
public final class FlowableRetryBiPredicate<T> extends AbstractC1215g0 {

    /* renamed from: b */
    public final BiPredicate f18990b;

    public FlowableRetryBiPredicate(Flowable<T> flowable, BiPredicate<? super Integer, ? super Throwable> biPredicate) {
        super(flowable);
        this.f18990b = biPredicate;
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    public void subscribeActual(Subscriber<? super T> subscriber) {
        SubscriptionArbiter subscriptionArbiter = new SubscriptionArbiter(false);
        subscriber.onSubscribe(subscriptionArbiter);
        new rp0(subscriber, this.f18990b, subscriptionArbiter, this.source).m7295a();
    }
}
