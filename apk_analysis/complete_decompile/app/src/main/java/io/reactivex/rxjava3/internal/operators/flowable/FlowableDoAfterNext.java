package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.operators.ConditionalSubscriber;
import org.reactivestreams.Subscriber;
import p000.AbstractC1215g0;
import p000.jl0;
import p000.kl0;

/* loaded from: classes2.dex */
public final class FlowableDoAfterNext<T> extends AbstractC1215g0 {

    /* renamed from: b */
    public final Consumer f18818b;

    public FlowableDoAfterNext(Flowable<T> flowable, Consumer<? super T> consumer) {
        super(flowable);
        this.f18818b = consumer;
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    public void subscribeActual(Subscriber<? super T> subscriber) {
        boolean z = subscriber instanceof ConditionalSubscriber;
        Consumer consumer = this.f18818b;
        if (z) {
            this.source.subscribe((FlowableSubscriber<? super Object>) new jl0((ConditionalSubscriber) subscriber, consumer, 0));
        } else {
            this.source.subscribe((FlowableSubscriber<? super Object>) new kl0(subscriber, consumer, 0));
        }
    }
}
