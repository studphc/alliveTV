package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.core.SingleSource;
import org.reactivestreams.Subscriber;
import p000.AbstractC1215g0;
import p000.jk0;

/* loaded from: classes2.dex */
public final class FlowableConcatWithSingle<T> extends AbstractC1215g0 {

    /* renamed from: b */
    public final SingleSource f18798b;

    public FlowableConcatWithSingle(Flowable<T> flowable, SingleSource<? extends T> singleSource) {
        super(flowable);
        this.f18798b = singleSource;
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    public void subscribeActual(Subscriber<? super T> subscriber) {
        this.source.subscribe((FlowableSubscriber<? super Object>) new jk0(subscriber, this.f18798b));
    }
}
