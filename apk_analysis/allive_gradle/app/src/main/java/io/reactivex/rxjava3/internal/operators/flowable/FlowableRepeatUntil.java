package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.functions.BooleanSupplier;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionArbiter;
import org.reactivestreams.Subscriber;
import p000.AbstractC1215g0;
import p000.ap0;

/* loaded from: classes2.dex */
public final class FlowableRepeatUntil<T> extends AbstractC1215g0 {

    /* renamed from: b */
    public final BooleanSupplier f18983b;

    public FlowableRepeatUntil(Flowable<T> flowable, BooleanSupplier booleanSupplier) {
        super(flowable);
        this.f18983b = booleanSupplier;
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    public void subscribeActual(Subscriber<? super T> subscriber) {
        SubscriptionArbiter subscriptionArbiter = new SubscriptionArbiter(false);
        subscriber.onSubscribe(subscriptionArbiter);
        new ap0(subscriber, this.f18983b, subscriptionArbiter, this.source).m1956a();
    }
}
