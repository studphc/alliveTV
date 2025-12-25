package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import p000.dl0;

/* loaded from: classes2.dex */
public final class FlowableDelaySubscriptionOther<T, U> extends Flowable<T> {

    /* renamed from: b */
    public final Publisher f18811b;

    /* renamed from: c */
    public final Publisher f18812c;

    public FlowableDelaySubscriptionOther(Publisher<? extends T> publisher, Publisher<U> publisher2) {
        this.f18811b = publisher;
        this.f18812c = publisher2;
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    public void subscribeActual(Subscriber<? super T> subscriber) {
        dl0 dl0Var = new dl0(this.f18811b, subscriber);
        subscriber.onSubscribe(dl0Var);
        this.f18812c.subscribe(dl0Var.f16406c);
    }
}
