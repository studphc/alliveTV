package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.functions.Function;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import p000.AbstractC1215g0;
import p000.ds0;

/* loaded from: classes2.dex */
public final class FlowableWindowBoundarySelector<T, B, V> extends AbstractC1215g0 {

    /* renamed from: b */
    public final Publisher f19077b;

    /* renamed from: c */
    public final Function f19078c;

    /* renamed from: d */
    public final int f19079d;

    public FlowableWindowBoundarySelector(Flowable<T> flowable, Publisher<B> publisher, Function<? super B, ? extends Publisher<V>> function, int i) {
        super(flowable);
        this.f19077b = publisher;
        this.f19078c = function;
        this.f19079d = i;
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    public void subscribeActual(Subscriber<? super Flowable<T>> subscriber) {
        this.source.subscribe((FlowableSubscriber<? super Object>) new ds0(subscriber, this.f19077b, this.f19078c, this.f19079d));
    }
}
