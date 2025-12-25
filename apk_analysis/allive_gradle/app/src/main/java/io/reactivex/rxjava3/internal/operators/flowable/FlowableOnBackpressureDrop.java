package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.functions.Consumer;
import org.reactivestreams.Subscriber;
import p000.AbstractC1215g0;
import p000.eo0;

/* loaded from: classes2.dex */
public final class FlowableOnBackpressureDrop<T> extends AbstractC1215g0 implements Consumer<T> {

    /* renamed from: b */
    public final Consumer f18947b;

    public FlowableOnBackpressureDrop(Flowable<T> flowable) {
        super(flowable);
        this.f18947b = this;
    }

    @Override // io.reactivex.rxjava3.functions.Consumer
    public void accept(T t) {
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    public void subscribeActual(Subscriber<? super T> subscriber) {
        this.source.subscribe((FlowableSubscriber<? super Object>) new eo0(subscriber, this.f18947b));
    }

    public FlowableOnBackpressureDrop(Flowable<T> flowable, Consumer<? super T> consumer) {
        super(flowable);
        this.f18947b = consumer;
    }
}
