package io.reactivex.rxjava3.internal.jdk8;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.internal.subscriptions.EmptySubscription;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import org.reactivestreams.Subscriber;
import p000.jj0;

/* loaded from: classes2.dex */
public final class FlowableCollectWithCollector<T, A, R> extends Flowable<R> {

    /* renamed from: b */
    public final Flowable f18529b;

    /* renamed from: c */
    public final Collector f18530c;

    public FlowableCollectWithCollector(Flowable<T> flowable, Collector<? super T, A, R> collector) {
        this.f18529b = flowable;
        this.f18530c = collector;
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    public void subscribeActual(@NonNull Subscriber<? super R> subscriber) {
        Supplier supplier;
        Object obj;
        BiConsumer accumulator;
        Function finisher;
        try {
            supplier = this.f18530c.supplier();
            obj = supplier.get();
            accumulator = this.f18530c.accumulator();
            finisher = this.f18530c.finisher();
            this.f18529b.subscribe((FlowableSubscriber) new jj0(subscriber, obj, accumulator, finisher));
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            EmptySubscription.error(th, subscriber);
        }
    }
}
