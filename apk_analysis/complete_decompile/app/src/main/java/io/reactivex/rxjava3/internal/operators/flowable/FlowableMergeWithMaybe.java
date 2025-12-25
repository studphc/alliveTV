package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.core.MaybeSource;
import org.reactivestreams.Subscriber;
import p000.AbstractC1215g0;
import p000.vn0;

/* loaded from: classes2.dex */
public final class FlowableMergeWithMaybe<T> extends AbstractC1215g0 {

    /* renamed from: b */
    public final MaybeSource f18935b;

    public FlowableMergeWithMaybe(Flowable<T> flowable, MaybeSource<? extends T> maybeSource) {
        super(flowable);
        this.f18935b = maybeSource;
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    public void subscribeActual(Subscriber<? super T> subscriber) {
        vn0 vn0Var = new vn0(subscriber);
        subscriber.onSubscribe(vn0Var);
        this.source.subscribe((FlowableSubscriber<? super Object>) vn0Var);
        this.f18935b.subscribe(vn0Var.f27882c);
    }
}
