package io.reactivex.rxjava3.internal.operators.parallel;

import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableFlattenIterable;
import io.reactivex.rxjava3.parallel.ParallelFlowable;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import org.reactivestreams.Subscriber;

/* loaded from: classes2.dex */
public final class ParallelFlatMapIterable<T, R> extends ParallelFlowable<R> {

    /* renamed from: a */
    public final ParallelFlowable f19673a;

    /* renamed from: b */
    public final Function f19674b;

    /* renamed from: c */
    public final int f19675c;

    public ParallelFlatMapIterable(ParallelFlowable<T> parallelFlowable, Function<? super T, ? extends Iterable<? extends R>> function, int i) {
        this.f19673a = parallelFlowable;
        this.f19674b = function;
        this.f19675c = i;
    }

    @Override // io.reactivex.rxjava3.parallel.ParallelFlowable
    public int parallelism() {
        return this.f19673a.parallelism();
    }

    @Override // io.reactivex.rxjava3.parallel.ParallelFlowable
    public void subscribe(Subscriber<? super R>[] subscriberArr) {
        Subscriber<?>[] onSubscribe = RxJavaPlugins.onSubscribe(this, subscriberArr);
        if (!validate(onSubscribe)) {
            return;
        }
        int length = onSubscribe.length;
        Subscriber<? super T>[] subscriberArr2 = new Subscriber[length];
        for (int i = 0; i < length; i++) {
            subscriberArr2[i] = FlowableFlattenIterable.subscribe(onSubscribe[i], this.f19674b, this.f19675c);
        }
        this.f19673a.subscribe(subscriberArr2);
    }
}
