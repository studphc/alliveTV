package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import p000.AbstractC1215g0;
import p000.fr0;

/* loaded from: classes2.dex */
public final class FlowableTakeUntil<T, U> extends AbstractC1215g0 {

    /* renamed from: b */
    public final Publisher f19042b;

    public FlowableTakeUntil(Flowable<T> flowable, Publisher<? extends U> publisher) {
        super(flowable);
        this.f19042b = publisher;
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    public void subscribeActual(Subscriber<? super T> subscriber) {
        fr0 fr0Var = new fr0(subscriber);
        subscriber.onSubscribe(fr0Var);
        this.f19042b.subscribe(fr0Var.f17373e);
        this.source.subscribe((FlowableSubscriber<? super Object>) fr0Var);
    }
}
