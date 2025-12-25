package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.functions.BiFunction;
import org.reactivestreams.Subscriber;
import p000.AbstractC1215g0;
import p000.bq0;

/* loaded from: classes2.dex */
public final class FlowableScan<T> extends AbstractC1215g0 {

    /* renamed from: b */
    public final BiFunction f19001b;

    public FlowableScan(Flowable<T> flowable, BiFunction<T, T, T> biFunction) {
        super(flowable);
        this.f19001b = biFunction;
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    public void subscribeActual(Subscriber<? super T> subscriber) {
        this.source.subscribe((FlowableSubscriber<? super Object>) new bq0(subscriber, this.f19001b));
    }
}
