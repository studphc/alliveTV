package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.functions.Predicate;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionArbiter;
import org.reactivestreams.Subscriber;
import p000.AbstractC1215g0;
import p000.sp0;

/* loaded from: classes2.dex */
public final class FlowableRetryPredicate<T> extends AbstractC1215g0 {

    /* renamed from: b */
    public final Predicate f18991b;

    /* renamed from: c */
    public final long f18992c;

    public FlowableRetryPredicate(Flowable<T> flowable, long j, Predicate<? super Throwable> predicate) {
        super(flowable);
        this.f18991b = predicate;
        this.f18992c = j;
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    public void subscribeActual(Subscriber<? super T> subscriber) {
        SubscriptionArbiter subscriptionArbiter = new SubscriptionArbiter(false);
        subscriber.onSubscribe(subscriptionArbiter);
        new sp0(subscriber, this.f18992c, this.f18991b, subscriptionArbiter, this.source).m7396a();
    }
}
