package io.reactivex.rxjava3.internal.operators.single;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.SingleSource;
import io.reactivex.rxjava3.internal.subscriptions.DeferredScalarSubscription;
import org.reactivestreams.Subscriber;

/* loaded from: classes2.dex */
public final class SingleToFlowable<T> extends Flowable<T> {

    /* renamed from: b */
    public final SingleSource f19815b;

    public SingleToFlowable(SingleSource<? extends T> singleSource) {
        this.f19815b = singleSource;
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    public void subscribeActual(Subscriber<? super T> subscriber) {
        this.f19815b.subscribe(new DeferredScalarSubscription(subscriber));
    }
}
