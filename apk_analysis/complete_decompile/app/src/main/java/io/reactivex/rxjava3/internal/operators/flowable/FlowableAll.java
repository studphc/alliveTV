package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.functions.Predicate;
import org.reactivestreams.Subscriber;
import p000.AbstractC1215g0;
import p000.oi0;

/* loaded from: classes2.dex */
public final class FlowableAll<T> extends AbstractC1215g0 {

    /* renamed from: b */
    public final Predicate f18730b;

    public FlowableAll(Flowable<T> flowable, Predicate<? super T> predicate) {
        super(flowable);
        this.f18730b = predicate;
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    public void subscribeActual(Subscriber<? super Boolean> subscriber) {
        this.source.subscribe((FlowableSubscriber<? super Object>) new oi0(subscriber, this.f18730b));
    }
}
