package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import p000.AbstractC1215g0;
import p000.mq0;

/* loaded from: classes2.dex */
public final class FlowableSkipUntil<T, U> extends AbstractC1215g0 {

    /* renamed from: b */
    public final Publisher f19024b;

    public FlowableSkipUntil(Flowable<T> flowable, Publisher<U> publisher) {
        super(flowable);
        this.f19024b = publisher;
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    public void subscribeActual(Subscriber<? super T> subscriber) {
        mq0 mq0Var = new mq0(subscriber);
        subscriber.onSubscribe(mq0Var);
        this.f19024b.subscribe(mq0Var.f23055d);
        this.source.subscribe((FlowableSubscriber<? super Object>) mq0Var);
    }
}
