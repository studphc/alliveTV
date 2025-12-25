package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.core.SingleSource;
import org.reactivestreams.Subscriber;
import p000.AbstractC1215g0;
import p000.xn0;

/* loaded from: classes2.dex */
public final class FlowableMergeWithSingle<T> extends AbstractC1215g0 {

    /* renamed from: b */
    public final SingleSource f18936b;

    public FlowableMergeWithSingle(Flowable<T> flowable, SingleSource<? extends T> singleSource) {
        super(flowable);
        this.f18936b = singleSource;
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    public void subscribeActual(Subscriber<? super T> subscriber) {
        xn0 xn0Var = new xn0(subscriber);
        subscriber.onSubscribe(xn0Var);
        this.source.subscribe((FlowableSubscriber<? super Object>) xn0Var);
        this.f18936b.subscribe(xn0Var.f28643c);
    }
}
