package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.internal.subscriptions.DeferredScalarSubscription;
import org.reactivestreams.Subscriber;
import p000.AbstractC1215g0;

/* loaded from: classes2.dex */
public final class FlowableCount<T> extends AbstractC1215g0 {
    public FlowableCount(Flowable<T> flowable) {
        super(flowable);
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    public void subscribeActual(Subscriber<? super Long> subscriber) {
        this.source.subscribe((FlowableSubscriber<? super Object>) new DeferredScalarSubscription(subscriber));
    }
}
