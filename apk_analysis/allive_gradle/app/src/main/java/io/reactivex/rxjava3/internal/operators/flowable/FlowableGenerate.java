package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Emitter;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.BiFunction;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.subscriptions.EmptySubscription;
import org.reactivestreams.Subscriber;
import p000.sm0;

/* loaded from: classes2.dex */
public final class FlowableGenerate<T, S> extends Flowable<T> {

    /* renamed from: b */
    public final Supplier f18880b;

    /* renamed from: c */
    public final BiFunction f18881c;

    /* renamed from: d */
    public final Consumer f18882d;

    public FlowableGenerate(Supplier<S> supplier, BiFunction<S, Emitter<T>, S> biFunction, Consumer<? super S> consumer) {
        this.f18880b = supplier;
        this.f18881c = biFunction;
        this.f18882d = consumer;
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    public void subscribeActual(Subscriber<? super T> subscriber) {
        try {
            subscriber.onSubscribe(new sm0(subscriber, this.f18881c, this.f18882d, this.f18880b.get()));
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            EmptySubscription.error(th, subscriber);
        }
    }
}
