package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.subscriptions.EmptySubscription;
import io.reactivex.rxjava3.processors.FlowableProcessor;
import io.reactivex.rxjava3.processors.UnicastProcessor;
import io.reactivex.rxjava3.subscribers.SerializedSubscriber;
import java.util.Objects;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import p000.AbstractC1215g0;
import p000.cp0;
import p000.dp0;

/* loaded from: classes2.dex */
public final class FlowableRetryWhen<T> extends AbstractC1215g0 {

    /* renamed from: b */
    public final Function f18993b;

    public FlowableRetryWhen(Flowable<T> flowable, Function<? super Flowable<Throwable>, ? extends Publisher<?>> function) {
        super(flowable);
        this.f18993b = function;
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    public void subscribeActual(Subscriber<? super T> subscriber) {
        SerializedSubscriber serializedSubscriber = new SerializedSubscriber(subscriber);
        FlowableProcessor<T> serialized = UnicastProcessor.create(8).toSerialized();
        try {
            Object apply = this.f18993b.apply(serialized);
            Objects.requireNonNull(apply, "handler returned a null Publisher");
            Publisher publisher = (Publisher) apply;
            cp0 cp0Var = new cp0(this.source);
            dp0 dp0Var = new dp0(serializedSubscriber, serialized, cp0Var);
            cp0Var.f16045d = dp0Var;
            subscriber.onSubscribe(dp0Var);
            publisher.subscribe(cp0Var);
            cp0Var.onNext(0);
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            EmptySubscription.error(th, subscriber);
        }
    }
}
