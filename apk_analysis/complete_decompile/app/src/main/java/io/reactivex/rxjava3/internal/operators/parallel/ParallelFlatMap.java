package io.reactivex.rxjava3.internal.operators.parallel;

import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableFlatMap;
import io.reactivex.rxjava3.parallel.ParallelFlowable;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;

/* loaded from: classes2.dex */
public final class ParallelFlatMap<T, R> extends ParallelFlowable<R> {

    /* renamed from: a */
    public final ParallelFlowable f19668a;

    /* renamed from: b */
    public final Function f19669b;

    /* renamed from: c */
    public final boolean f19670c;

    /* renamed from: d */
    public final int f19671d;

    /* renamed from: e */
    public final int f19672e;

    public ParallelFlatMap(ParallelFlowable<T> parallelFlowable, Function<? super T, ? extends Publisher<? extends R>> function, boolean z, int i, int i2) {
        this.f19668a = parallelFlowable;
        this.f19669b = function;
        this.f19670c = z;
        this.f19671d = i;
        this.f19672e = i2;
    }

    @Override // io.reactivex.rxjava3.parallel.ParallelFlowable
    public int parallelism() {
        return this.f19668a.parallelism();
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
            subscriberArr2[i] = FlowableFlatMap.subscribe(onSubscribe[i], this.f19669b, this.f19670c, this.f19671d, this.f19672e);
        }
        this.f19668a.subscribe(subscriberArr2);
    }
}
