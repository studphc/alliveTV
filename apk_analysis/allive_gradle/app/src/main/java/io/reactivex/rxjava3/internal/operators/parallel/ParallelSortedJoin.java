package io.reactivex.rxjava3.internal.operators.parallel;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.parallel.ParallelFlowable;
import java.util.Comparator;
import java.util.List;
import org.reactivestreams.Subscriber;
import p000.d32;

/* loaded from: classes2.dex */
public final class ParallelSortedJoin<T> extends Flowable<T> {

    /* renamed from: b */
    public final ParallelFlowable f19705b;

    /* renamed from: c */
    public final Comparator f19706c;

    public ParallelSortedJoin(ParallelFlowable<List<T>> parallelFlowable, Comparator<? super T> comparator) {
        this.f19705b = parallelFlowable;
        this.f19706c = comparator;
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    public void subscribeActual(Subscriber<? super T> subscriber) {
        ParallelFlowable parallelFlowable = this.f19705b;
        d32 d32Var = new d32(subscriber, parallelFlowable.parallelism(), this.f19706c);
        subscriber.onSubscribe(d32Var);
        parallelFlowable.subscribe(d32Var.f16228b);
    }
}
