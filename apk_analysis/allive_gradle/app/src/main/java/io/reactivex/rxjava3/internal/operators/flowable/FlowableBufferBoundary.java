package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.functions.Supplier;
import java.util.Collection;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import p000.AbstractC1215g0;
import p000.xi0;

/* loaded from: classes2.dex */
public final class FlowableBufferBoundary<T, U extends Collection<? super T>, Open, Close> extends AbstractC1215g0 {

    /* renamed from: b */
    public final Supplier f18745b;

    /* renamed from: c */
    public final Publisher f18746c;

    /* renamed from: d */
    public final Function f18747d;

    public FlowableBufferBoundary(Flowable<T> flowable, Publisher<? extends Open> publisher, Function<? super Open, ? extends Publisher<? extends Close>> function, Supplier<U> supplier) {
        super(flowable);
        this.f18746c = publisher;
        this.f18747d = function;
        this.f18745b = supplier;
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    public void subscribeActual(Subscriber<? super U> subscriber) {
        xi0 xi0Var = new xi0(subscriber, this.f18746c, this.f18747d, this.f18745b);
        subscriber.onSubscribe(xi0Var);
        this.source.subscribe((FlowableSubscriber<? super Object>) xi0Var);
    }
}
