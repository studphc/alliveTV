package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.functions.LongConsumer;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import p000.AbstractC1215g0;
import p000.pl0;

/* loaded from: classes2.dex */
public final class FlowableDoOnLifecycle<T> extends AbstractC1215g0 {

    /* renamed from: b */
    public final Consumer f18824b;

    /* renamed from: c */
    public final LongConsumer f18825c;

    /* renamed from: d */
    public final Action f18826d;

    public FlowableDoOnLifecycle(Flowable<T> flowable, Consumer<? super Subscription> consumer, LongConsumer longConsumer, Action action) {
        super(flowable);
        this.f18824b = consumer;
        this.f18825c = longConsumer;
        this.f18826d = action;
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    public void subscribeActual(Subscriber<? super T> subscriber) {
        this.source.subscribe((FlowableSubscriber<? super Object>) new pl0(subscriber, this.f18824b, this.f18825c, this.f18826d));
    }
}
