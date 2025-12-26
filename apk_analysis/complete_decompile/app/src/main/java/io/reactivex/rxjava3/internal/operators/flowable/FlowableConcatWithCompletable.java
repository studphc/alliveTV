package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.CompletableSource;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import org.reactivestreams.Subscriber;
import p000.AbstractC1215g0;
import p000.hk0;

/* loaded from: classes2.dex */
public final class FlowableConcatWithCompletable<T> extends AbstractC1215g0 {

    /* renamed from: b */
    public final CompletableSource f18796b;

    public FlowableConcatWithCompletable(Flowable<T> flowable, CompletableSource completableSource) {
        super(flowable);
        this.f18796b = completableSource;
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    public void subscribeActual(Subscriber<? super T> subscriber) {
        this.source.subscribe((FlowableSubscriber<? super Object>) new hk0(subscriber, this.f18796b));
    }
}
