package io.reactivex.rxjava3.internal.jdk8;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.internal.subscriptions.EmptySubscription;
import io.reactivex.rxjava3.parallel.ParallelFlowable;
import java.util.stream.Collector;
import org.reactivestreams.Subscriber;
import p000.c22;

/* loaded from: classes2.dex */
public final class ParallelCollector<T, A, R> extends Flowable<R> {

    /* renamed from: b */
    public final ParallelFlowable f18570b;

    /* renamed from: c */
    public final Collector f18571c;

    public ParallelCollector(ParallelFlowable<? extends T> parallelFlowable, Collector<T, A, R> collector) {
        this.f18570b = parallelFlowable;
        this.f18571c = collector;
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    public void subscribeActual(Subscriber<? super R> subscriber) {
        ParallelFlowable parallelFlowable = this.f18570b;
        try {
            c22 c22Var = new c22(subscriber, parallelFlowable.parallelism(), this.f18571c);
            subscriber.onSubscribe(c22Var);
            parallelFlowable.subscribe(c22Var.f8233a);
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            EmptySubscription.error(th, subscriber);
        }
    }
}
