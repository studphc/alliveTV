package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.operators.ConditionalSubscriber;
import org.reactivestreams.Subscriber;
import p000.AbstractC1215g0;
import p000.nl0;
import p000.ol0;

/* loaded from: classes2.dex */
public final class FlowableDoOnEach<T> extends AbstractC1215g0 {

    /* renamed from: b */
    public final Consumer f18820b;

    /* renamed from: c */
    public final Consumer f18821c;

    /* renamed from: d */
    public final Action f18822d;

    /* renamed from: e */
    public final Action f18823e;

    public FlowableDoOnEach(Flowable<T> flowable, Consumer<? super T> consumer, Consumer<? super Throwable> consumer2, Action action, Action action2) {
        super(flowable);
        this.f18820b = consumer;
        this.f18821c = consumer2;
        this.f18822d = action;
        this.f18823e = action2;
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    public void subscribeActual(Subscriber<? super T> subscriber) {
        if (subscriber instanceof ConditionalSubscriber) {
            this.source.subscribe((FlowableSubscriber<? super Object>) new nl0((ConditionalSubscriber) subscriber, this.f18820b, this.f18821c, this.f18822d, this.f18823e));
        } else {
            this.source.subscribe((FlowableSubscriber<? super Object>) new ol0(subscriber, this.f18820b, this.f18821c, this.f18822d, this.f18823e));
        }
    }
}
