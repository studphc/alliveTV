package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.functions.BiFunction;
import org.reactivestreams.Subscriber;
import p000.AbstractC1215g0;
import p000.wo0;

/* loaded from: classes2.dex */
public final class FlowableReduce<T> extends AbstractC1215g0 {

    /* renamed from: b */
    public final BiFunction f18967b;

    public FlowableReduce(Flowable<T> flowable, BiFunction<T, T, T> biFunction) {
        super(flowable);
        this.f18967b = biFunction;
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    public void subscribeActual(Subscriber<? super T> subscriber) {
        this.source.subscribe((FlowableSubscriber<? super Object>) new wo0(subscriber, this.f18967b));
    }
}
