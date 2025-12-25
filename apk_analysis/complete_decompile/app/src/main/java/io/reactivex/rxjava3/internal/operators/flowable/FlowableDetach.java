package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import org.reactivestreams.Subscriber;
import p000.AbstractC1215g0;
import p000.fl0;

/* loaded from: classes2.dex */
public final class FlowableDetach<T> extends AbstractC1215g0 {
    public FlowableDetach(Flowable<T> flowable) {
        super(flowable);
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    public void subscribeActual(Subscriber<? super T> subscriber) {
        Flowable<Object> flowable = this.source;
        fl0 fl0Var = new fl0();
        fl0Var.f17313b = subscriber;
        flowable.subscribe((FlowableSubscriber<? super Object>) fl0Var);
    }
}
