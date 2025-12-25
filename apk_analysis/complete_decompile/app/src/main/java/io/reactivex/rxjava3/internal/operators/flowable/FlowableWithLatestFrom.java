package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.functions.BiFunction;
import io.reactivex.rxjava3.subscribers.SerializedSubscriber;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import p000.AbstractC1215g0;
import p000.js0;
import p000.xp0;

/* loaded from: classes2.dex */
public final class FlowableWithLatestFrom<T, U, R> extends AbstractC1215g0 {

    /* renamed from: b */
    public final BiFunction f19087b;

    /* renamed from: c */
    public final Publisher f19088c;

    public FlowableWithLatestFrom(Flowable<T> flowable, BiFunction<? super T, ? super U, ? extends R> biFunction, Publisher<? extends U> publisher) {
        super(flowable);
        this.f19087b = biFunction;
        this.f19088c = publisher;
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    public void subscribeActual(Subscriber<? super R> subscriber) {
        SerializedSubscriber serializedSubscriber = new SerializedSubscriber(subscriber);
        js0 js0Var = new js0(serializedSubscriber, this.f19087b);
        serializedSubscriber.onSubscribe(js0Var);
        this.f19088c.subscribe(new xp0(js0Var, 1));
        this.source.subscribe((FlowableSubscriber<? super Object>) js0Var);
    }
}
