package io.reactivex.rxjava3.internal.operators.parallel;

import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableConcatMap;
import io.reactivex.rxjava3.internal.util.ErrorMode;
import io.reactivex.rxjava3.parallel.ParallelFlowable;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Objects;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;

/* loaded from: classes2.dex */
public final class ParallelConcatMap<T, R> extends ParallelFlowable<R> {

    /* renamed from: a */
    public final ParallelFlowable f19656a;

    /* renamed from: b */
    public final Function f19657b;

    /* renamed from: c */
    public final int f19658c;

    /* renamed from: d */
    public final ErrorMode f19659d;

    public ParallelConcatMap(ParallelFlowable<T> parallelFlowable, Function<? super T, ? extends Publisher<? extends R>> function, int i, ErrorMode errorMode) {
        this.f19656a = parallelFlowable;
        Objects.requireNonNull(function, "mapper");
        this.f19657b = function;
        this.f19658c = i;
        Objects.requireNonNull(errorMode, "errorMode");
        this.f19659d = errorMode;
    }

    @Override // io.reactivex.rxjava3.parallel.ParallelFlowable
    public int parallelism() {
        return this.f19656a.parallelism();
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
            subscriberArr2[i] = FlowableConcatMap.subscribe(onSubscribe[i], this.f19657b, this.f19658c, this.f19659d);
        }
        this.f19656a.subscribe(subscriberArr2);
    }
}
