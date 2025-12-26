package io.reactivex.rxjava3.internal.operators.parallel;

import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.operators.ConditionalSubscriber;
import io.reactivex.rxjava3.parallel.ParallelFlowable;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import org.reactivestreams.Subscriber;
import p000.el0;
import p000.p22;

/* loaded from: classes2.dex */
public final class ParallelMap<T, R> extends ParallelFlowable<R> {

    /* renamed from: a */
    public final ParallelFlowable f19683a;

    /* renamed from: b */
    public final Function f19684b;

    public ParallelMap(ParallelFlowable<T> parallelFlowable, Function<? super T, ? extends R> function) {
        this.f19683a = parallelFlowable;
        this.f19684b = function;
    }

    @Override // io.reactivex.rxjava3.parallel.ParallelFlowable
    public int parallelism() {
        return this.f19683a.parallelism();
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
            Subscriber<?> subscriber = onSubscribe[i];
            boolean z = subscriber instanceof ConditionalSubscriber;
            Function function = this.f19684b;
            if (z) {
                subscriberArr2[i] = new p22((ConditionalSubscriber) subscriber, function, 0);
            } else {
                subscriberArr2[i] = new el0(subscriber, function, 1);
            }
        }
        this.f19683a.subscribe(subscriberArr2);
    }
}
