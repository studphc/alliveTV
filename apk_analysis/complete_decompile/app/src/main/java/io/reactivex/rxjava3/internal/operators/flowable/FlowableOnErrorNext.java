package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.functions.Function;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import p000.AbstractC1215g0;
import p000.jo0;

/* loaded from: classes2.dex */
public final class FlowableOnErrorNext<T> extends AbstractC1215g0 {

    /* renamed from: b */
    public final Function f18955b;

    public FlowableOnErrorNext(Flowable<T> flowable, Function<? super Throwable, ? extends Publisher<? extends T>> function) {
        super(flowable);
        this.f18955b = function;
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    public void subscribeActual(Subscriber<? super T> subscriber) {
        jo0 jo0Var = new jo0(subscriber, this.f18955b);
        subscriber.onSubscribe(jo0Var);
        this.source.subscribe((FlowableSubscriber<? super Object>) jo0Var);
    }
}
