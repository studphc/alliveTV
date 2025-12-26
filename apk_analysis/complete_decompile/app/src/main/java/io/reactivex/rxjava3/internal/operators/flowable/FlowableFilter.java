package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.functions.Predicate;
import io.reactivex.rxjava3.operators.ConditionalSubscriber;
import org.reactivestreams.Subscriber;
import p000.AbstractC1215g0;
import p000.jl0;
import p000.tl0;

/* loaded from: classes2.dex */
public final class FlowableFilter<T> extends AbstractC1215g0 {

    /* renamed from: b */
    public final Predicate f18838b;

    public FlowableFilter(Flowable<T> flowable, Predicate<? super T> predicate) {
        super(flowable);
        this.f18838b = predicate;
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    public void subscribeActual(Subscriber<? super T> subscriber) {
        boolean z = subscriber instanceof ConditionalSubscriber;
        Predicate predicate = this.f18838b;
        if (z) {
            this.source.subscribe((FlowableSubscriber<? super Object>) new jl0((ConditionalSubscriber) subscriber, predicate, 1));
        } else {
            this.source.subscribe((FlowableSubscriber<? super Object>) new tl0(subscriber, predicate, 0));
        }
    }
}
