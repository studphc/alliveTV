package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import org.reactivestreams.Subscriber;
import p000.AbstractC1215g0;
import p000.br0;

/* loaded from: classes2.dex */
public final class FlowableTakeLast<T> extends AbstractC1215g0 {

    /* renamed from: b */
    public final int f19033b;

    public FlowableTakeLast(Flowable<T> flowable, int i) {
        super(flowable);
        this.f19033b = i;
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    public void subscribeActual(Subscriber<? super T> subscriber) {
        this.source.subscribe((FlowableSubscriber<? super Object>) new br0(subscriber, this.f19033b));
    }
}
