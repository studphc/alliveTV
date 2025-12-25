package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import org.reactivestreams.Subscriber;
import p000.AbstractC1215g0;
import p000.iq0;

/* loaded from: classes2.dex */
public final class FlowableSkip<T> extends AbstractC1215g0 {

    /* renamed from: b */
    public final long f19017b;

    public FlowableSkip(Flowable<T> flowable, long j) {
        super(flowable);
        this.f19017b = j;
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    public void subscribeActual(Subscriber<? super T> subscriber) {
        this.source.subscribe((FlowableSubscriber<? super Object>) new iq0(subscriber, this.f19017b));
    }
}
