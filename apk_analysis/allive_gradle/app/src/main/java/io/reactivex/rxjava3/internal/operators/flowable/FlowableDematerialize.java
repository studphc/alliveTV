package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.core.Notification;
import io.reactivex.rxjava3.functions.Function;
import org.reactivestreams.Subscriber;
import p000.AbstractC1215g0;
import p000.el0;

/* loaded from: classes2.dex */
public final class FlowableDematerialize<T, R> extends AbstractC1215g0 {

    /* renamed from: b */
    public final Function f18813b;

    public FlowableDematerialize(Flowable<T> flowable, Function<? super T, ? extends Notification<R>> function) {
        super(flowable);
        this.f18813b = function;
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    public void subscribeActual(Subscriber<? super R> subscriber) {
        this.source.subscribe((FlowableSubscriber<? super Object>) new el0(subscriber, this.f18813b, 0));
    }
}
