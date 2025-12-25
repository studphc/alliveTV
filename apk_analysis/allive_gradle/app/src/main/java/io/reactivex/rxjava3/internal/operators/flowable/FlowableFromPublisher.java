package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;

/* loaded from: classes2.dex */
public final class FlowableFromPublisher<T> extends Flowable<T> {

    /* renamed from: b */
    public final Publisher f18877b;

    public FlowableFromPublisher(Publisher<? extends T> publisher) {
        this.f18877b = publisher;
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    public void subscribeActual(Subscriber<? super T> subscriber) {
        this.f18877b.subscribe(subscriber);
    }
}
