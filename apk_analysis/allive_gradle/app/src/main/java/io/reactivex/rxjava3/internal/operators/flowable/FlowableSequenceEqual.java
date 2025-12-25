package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.functions.BiPredicate;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import p000.dq0;

/* loaded from: classes2.dex */
public final class FlowableSequenceEqual<T> extends Flowable<Boolean> {

    /* renamed from: b */
    public final Publisher f19004b;

    /* renamed from: c */
    public final Publisher f19005c;

    /* renamed from: d */
    public final BiPredicate f19006d;

    /* renamed from: e */
    public final int f19007e;

    public FlowableSequenceEqual(Publisher<? extends T> publisher, Publisher<? extends T> publisher2, BiPredicate<? super T, ? super T> biPredicate, int i) {
        this.f19004b = publisher;
        this.f19005c = publisher2;
        this.f19006d = biPredicate;
        this.f19007e = i;
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    public void subscribeActual(Subscriber<? super Boolean> subscriber) {
        dq0 dq0Var = new dq0(subscriber, this.f19007e, this.f19006d);
        subscriber.onSubscribe(dq0Var);
        this.f19004b.subscribe(dq0Var.f16485b);
        this.f19005c.subscribe(dq0Var.f16486c);
    }
}
