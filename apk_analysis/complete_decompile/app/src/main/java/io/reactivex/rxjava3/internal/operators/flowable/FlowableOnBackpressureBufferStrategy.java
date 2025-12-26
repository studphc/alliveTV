package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.BackpressureOverflowStrategy;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.functions.Action;
import org.reactivestreams.Subscriber;
import p000.AbstractC1215g0;
import p000.do0;

/* loaded from: classes2.dex */
public final class FlowableOnBackpressureBufferStrategy<T> extends AbstractC1215g0 {

    /* renamed from: b */
    public final long f18944b;

    /* renamed from: c */
    public final Action f18945c;

    /* renamed from: d */
    public final BackpressureOverflowStrategy f18946d;

    public FlowableOnBackpressureBufferStrategy(Flowable<T> flowable, long j, Action action, BackpressureOverflowStrategy backpressureOverflowStrategy) {
        super(flowable);
        this.f18944b = j;
        this.f18945c = action;
        this.f18946d = backpressureOverflowStrategy;
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    public void subscribeActual(Subscriber<? super T> subscriber) {
        this.source.subscribe((FlowableSubscriber<? super Object>) new do0(subscriber, this.f18945c, this.f18946d, this.f18944b));
    }
}
