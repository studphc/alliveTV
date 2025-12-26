package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import org.reactivestreams.Subscriber;
import p000.AbstractC1215g0;
import p000.ar0;

/* loaded from: classes2.dex */
public final class FlowableTake<T> extends AbstractC1215g0 {

    /* renamed from: b */
    public final long f19032b;

    public FlowableTake(Flowable<T> flowable, long j) {
        super(flowable);
        this.f19032b = j;
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    public void subscribeActual(Subscriber<? super T> subscriber) {
        this.source.subscribe((FlowableSubscriber<? super Object>) new ar0(subscriber, this.f19032b));
    }
}
