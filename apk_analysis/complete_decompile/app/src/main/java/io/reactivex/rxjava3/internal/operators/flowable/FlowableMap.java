package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.operators.ConditionalSubscriber;
import org.reactivestreams.Subscriber;
import p000.AbstractC1215g0;
import p000.kl0;
import p000.pn0;

/* loaded from: classes2.dex */
public final class FlowableMap<T, U> extends AbstractC1215g0 {

    /* renamed from: b */
    public final Function f18928b;

    public FlowableMap(Flowable<T> flowable, Function<? super T, ? extends U> function) {
        super(flowable);
        this.f18928b = function;
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    public void subscribeActual(Subscriber<? super U> subscriber) {
        boolean z = subscriber instanceof ConditionalSubscriber;
        Function function = this.f18928b;
        if (z) {
            this.source.subscribe((FlowableSubscriber<? super Object>) new pn0((ConditionalSubscriber) subscriber, function, 0));
        } else {
            this.source.subscribe((FlowableSubscriber<? super Object>) new kl0(subscriber, function, 1));
        }
    }
}
