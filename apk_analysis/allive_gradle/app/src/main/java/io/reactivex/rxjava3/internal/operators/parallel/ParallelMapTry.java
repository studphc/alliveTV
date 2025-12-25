package io.reactivex.rxjava3.internal.operators.parallel;

import io.reactivex.rxjava3.functions.BiFunction;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.operators.ConditionalSubscriber;
import io.reactivex.rxjava3.parallel.ParallelFailureHandling;
import io.reactivex.rxjava3.parallel.ParallelFlowable;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import org.reactivestreams.Subscriber;
import p000.r22;
import p000.s22;

/* loaded from: classes2.dex */
public final class ParallelMapTry<T, R> extends ParallelFlowable<R> {

    /* renamed from: a */
    public final ParallelFlowable f19685a;

    /* renamed from: b */
    public final Function f19686b;

    /* renamed from: c */
    public final BiFunction f19687c;

    public ParallelMapTry(ParallelFlowable<T> parallelFlowable, Function<? super T, ? extends R> function, BiFunction<? super Long, ? super Throwable, ParallelFailureHandling> biFunction) {
        this.f19685a = parallelFlowable;
        this.f19686b = function;
        this.f19687c = biFunction;
    }

    @Override // io.reactivex.rxjava3.parallel.ParallelFlowable
    public int parallelism() {
        return this.f19685a.parallelism();
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
            BiFunction biFunction = this.f19687c;
            Function function = this.f19686b;
            if (z) {
                subscriberArr2[i] = new r22((ConditionalSubscriber) subscriber, function, biFunction, 0);
            } else {
                subscriberArr2[i] = new s22(subscriber, function, biFunction, 0);
            }
        }
        this.f19685a.subscribe(subscriberArr2);
    }
}
