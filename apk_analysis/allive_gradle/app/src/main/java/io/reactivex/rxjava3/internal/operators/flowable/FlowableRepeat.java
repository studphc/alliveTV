package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionArbiter;
import org.reactivestreams.Subscriber;
import p000.AbstractC1215g0;
import p000.zo0;

/* loaded from: classes2.dex */
public final class FlowableRepeat<T> extends AbstractC1215g0 {

    /* renamed from: b */
    public final long f18982b;

    public FlowableRepeat(Flowable<T> flowable, long j) {
        super(flowable);
        this.f18982b = j;
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    public void subscribeActual(Subscriber<? super T> subscriber) {
        SubscriptionArbiter subscriptionArbiter = new SubscriptionArbiter(false);
        subscriber.onSubscribe(subscriptionArbiter);
        long j = this.f18982b;
        long j2 = Long.MAX_VALUE;
        if (j != Long.MAX_VALUE) {
            j2 = j - 1;
        }
        new zo0(subscriber, j2, subscriptionArbiter, this.source).m8421a();
    }
}
