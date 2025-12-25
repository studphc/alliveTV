package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.functions.Function;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import p000.kl0;

/* loaded from: classes2.dex */
public final class FlowableMapPublisher<T, U> extends Flowable<U> {

    /* renamed from: b */
    public final Publisher f18932b;

    /* renamed from: c */
    public final Function f18933c;

    public FlowableMapPublisher(Publisher<T> publisher, Function<? super T, ? extends U> function) {
        this.f18932b = publisher;
        this.f18933c = function;
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    public void subscribeActual(Subscriber<? super U> subscriber) {
        this.f18932b.subscribe(new kl0(subscriber, this.f18933c, 1));
    }
}
