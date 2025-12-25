package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.core.Scheduler;
import org.reactivestreams.Subscriber;
import p000.AbstractC1215g0;
import p000.tr0;

/* loaded from: classes2.dex */
public final class FlowableUnsubscribeOn<T> extends AbstractC1215g0 {

    /* renamed from: b */
    public final Scheduler f19067b;

    public FlowableUnsubscribeOn(Flowable<T> flowable, Scheduler scheduler) {
        super(flowable);
        this.f19067b = scheduler;
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    public void subscribeActual(Subscriber<? super T> subscriber) {
        this.source.subscribe((FlowableSubscriber<? super Object>) new tr0(subscriber, this.f19067b));
    }
}
