package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import p000.ar0;

/* loaded from: classes2.dex */
public final class FlowableTakePublisher<T> extends Flowable<T> {

    /* renamed from: b */
    public final Publisher f19040b;

    /* renamed from: c */
    public final long f19041c;

    public FlowableTakePublisher(Publisher<T> publisher, long j) {
        this.f19040b = publisher;
        this.f19041c = j;
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    public void subscribeActual(Subscriber<? super T> subscriber) {
        this.f19040b.subscribe(new ar0(subscriber, this.f19041c));
    }
}
