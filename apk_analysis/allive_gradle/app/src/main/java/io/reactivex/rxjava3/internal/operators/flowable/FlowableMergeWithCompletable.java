package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.CompletableSource;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import org.reactivestreams.Subscriber;
import p000.AbstractC1215g0;
import p000.tn0;

/* loaded from: classes2.dex */
public final class FlowableMergeWithCompletable<T> extends AbstractC1215g0 {

    /* renamed from: b */
    public final CompletableSource f18934b;

    public FlowableMergeWithCompletable(Flowable<T> flowable, CompletableSource completableSource) {
        super(flowable);
        this.f18934b = completableSource;
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    public void subscribeActual(Subscriber<? super T> subscriber) {
        tn0 tn0Var = new tn0(subscriber);
        subscriber.onSubscribe(tn0Var);
        this.source.subscribe((FlowableSubscriber<? super Object>) tn0Var);
        this.f18934b.subscribe(tn0Var.f26895c);
    }
}
