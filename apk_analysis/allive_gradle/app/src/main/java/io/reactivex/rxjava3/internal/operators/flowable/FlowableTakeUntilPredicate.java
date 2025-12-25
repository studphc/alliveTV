package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.functions.Predicate;
import org.reactivestreams.Subscriber;
import p000.AbstractC1215g0;
import p000.nq0;

/* loaded from: classes2.dex */
public final class FlowableTakeUntilPredicate<T> extends AbstractC1215g0 {

    /* renamed from: b */
    public final Predicate f19043b;

    public FlowableTakeUntilPredicate(Flowable<T> flowable, Predicate<? super T> predicate) {
        super(flowable);
        this.f19043b = predicate;
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    public void subscribeActual(Subscriber<? super T> subscriber) {
        this.source.subscribe((FlowableSubscriber<? super Object>) new nq0(subscriber, this.f19043b, 1));
    }
}
