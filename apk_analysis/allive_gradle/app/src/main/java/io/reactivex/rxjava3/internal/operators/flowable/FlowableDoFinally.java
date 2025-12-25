package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.operators.ConditionalSubscriber;
import org.reactivestreams.Subscriber;
import p000.AbstractC1215g0;
import p000.ll0;
import p000.ml0;

/* loaded from: classes2.dex */
public final class FlowableDoFinally<T> extends AbstractC1215g0 {

    /* renamed from: b */
    public final Action f18819b;

    public FlowableDoFinally(Flowable<T> flowable, Action action) {
        super(flowable);
        this.f18819b = action;
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    public void subscribeActual(Subscriber<? super T> subscriber) {
        boolean z = subscriber instanceof ConditionalSubscriber;
        Action action = this.f18819b;
        if (z) {
            this.source.subscribe((FlowableSubscriber<? super Object>) new ll0((ConditionalSubscriber) subscriber, action));
        } else {
            this.source.subscribe((FlowableSubscriber<? super Object>) new ml0(subscriber, action));
        }
    }
}
