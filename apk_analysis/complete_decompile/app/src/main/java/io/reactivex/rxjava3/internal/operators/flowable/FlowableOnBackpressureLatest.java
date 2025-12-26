package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import org.reactivestreams.Subscriber;
import p000.AbstractC1214g;
import p000.AbstractC1215g0;

/* loaded from: classes2.dex */
public final class FlowableOnBackpressureLatest<T> extends AbstractC1215g0 {
    public FlowableOnBackpressureLatest(Flowable<T> flowable) {
        super(flowable);
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    public void subscribeActual(Subscriber<? super T> subscriber) {
        this.source.subscribe((FlowableSubscriber<? super Object>) new AbstractC1214g(subscriber));
    }
}
