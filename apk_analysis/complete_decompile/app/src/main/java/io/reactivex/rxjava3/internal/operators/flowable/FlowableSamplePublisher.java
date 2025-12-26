package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.subscribers.SerializedSubscriber;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import p000.up0;
import p000.wp0;

/* loaded from: classes2.dex */
public final class FlowableSamplePublisher<T> extends Flowable<T> {

    /* renamed from: b */
    public final Publisher f18994b;

    /* renamed from: c */
    public final Publisher f18995c;

    /* renamed from: d */
    public final boolean f18996d;

    public FlowableSamplePublisher(Publisher<T> publisher, Publisher<?> publisher2, boolean z) {
        this.f18994b = publisher;
        this.f18995c = publisher2;
        this.f18996d = z;
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    public void subscribeActual(Subscriber<? super T> subscriber) {
        SerializedSubscriber serializedSubscriber = new SerializedSubscriber(subscriber);
        boolean z = this.f18996d;
        Publisher publisher = this.f18995c;
        Publisher publisher2 = this.f18994b;
        if (z) {
            publisher2.subscribe(new up0(serializedSubscriber, publisher));
        } else {
            publisher2.subscribe(new wp0(serializedSubscriber, publisher));
        }
    }
}
