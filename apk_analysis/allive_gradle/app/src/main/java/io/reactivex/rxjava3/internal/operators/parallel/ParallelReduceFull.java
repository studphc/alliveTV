package io.reactivex.rxjava3.internal.operators.parallel;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.functions.BiFunction;
import io.reactivex.rxjava3.parallel.ParallelFlowable;
import org.reactivestreams.Subscriber;
import p000.w22;

/* loaded from: classes2.dex */
public final class ParallelReduceFull<T> extends Flowable<T> {

    /* renamed from: b */
    public final ParallelFlowable f19700b;

    /* renamed from: c */
    public final BiFunction f19701c;

    public ParallelReduceFull(ParallelFlowable<? extends T> parallelFlowable, BiFunction<T, T, T> biFunction) {
        this.f19700b = parallelFlowable;
        this.f19701c = biFunction;
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    public void subscribeActual(Subscriber<? super T> subscriber) {
        ParallelFlowable parallelFlowable = this.f19700b;
        w22 w22Var = new w22(subscriber, parallelFlowable.parallelism(), this.f19701c);
        subscriber.onSubscribe(w22Var);
        parallelFlowable.subscribe(w22Var.f28048a);
    }
}
