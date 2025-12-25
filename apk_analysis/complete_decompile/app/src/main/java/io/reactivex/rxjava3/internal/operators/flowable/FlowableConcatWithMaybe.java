package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.core.MaybeSource;
import org.reactivestreams.Subscriber;
import p000.AbstractC1215g0;
import p000.ik0;

/* loaded from: classes2.dex */
public final class FlowableConcatWithMaybe<T> extends AbstractC1215g0 {

    /* renamed from: b */
    public final MaybeSource f18797b;

    public FlowableConcatWithMaybe(Flowable<T> flowable, MaybeSource<? extends T> maybeSource) {
        super(flowable);
        this.f18797b = maybeSource;
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    public void subscribeActual(Subscriber<? super T> subscriber) {
        this.source.subscribe((FlowableSubscriber<? super Object>) new ik0(subscriber, this.f18797b));
    }
}
