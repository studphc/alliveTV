package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import p000.AbstractC1215g0;
import p000.rq0;

/* loaded from: classes2.dex */
public final class FlowableSwitchIfEmpty<T> extends AbstractC1215g0 {

    /* renamed from: b */
    public final Publisher f19028b;

    public FlowableSwitchIfEmpty(Flowable<T> flowable, Publisher<? extends T> publisher) {
        super(flowable);
        this.f19028b = publisher;
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    public void subscribeActual(Subscriber<? super T> subscriber) {
        rq0 rq0Var = new rq0(this.f19028b, subscriber);
        subscriber.onSubscribe(rq0Var.f26109c);
        this.source.subscribe((FlowableSubscriber<? super Object>) rq0Var);
    }
}
