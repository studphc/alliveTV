package io.reactivex.rxjava3.internal.jdk8;

import io.reactivex.rxjava3.functions.BiFunction;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.operators.ConditionalSubscriber;
import io.reactivex.rxjava3.parallel.ParallelFailureHandling;
import io.reactivex.rxjava3.parallel.ParallelFlowable;
import java.util.Optional;
import org.reactivestreams.Subscriber;
import p000.r22;
import p000.s22;

/* loaded from: classes2.dex */
public final class ParallelMapTryOptional<T, R> extends ParallelFlowable<R> {

    /* renamed from: a */
    public final ParallelFlowable f18577a;

    /* renamed from: b */
    public final Function f18578b;

    /* renamed from: c */
    public final BiFunction f18579c;

    public ParallelMapTryOptional(ParallelFlowable<T> parallelFlowable, Function<? super T, Optional<? extends R>> function, BiFunction<? super Long, ? super Throwable, ParallelFailureHandling> biFunction) {
        this.f18577a = parallelFlowable;
        this.f18578b = function;
        this.f18579c = biFunction;
    }

    @Override // io.reactivex.rxjava3.parallel.ParallelFlowable
    public int parallelism() {
        return this.f18577a.parallelism();
    }

    @Override // io.reactivex.rxjava3.parallel.ParallelFlowable
    public void subscribe(Subscriber<? super R>[] subscriberArr) {
        if (!validate(subscriberArr)) {
            return;
        }
        int length = subscriberArr.length;
        Subscriber<? super T>[] subscriberArr2 = new Subscriber[length];
        for (int i = 0; i < length; i++) {
            Subscriber<? super R> subscriber = subscriberArr[i];
            boolean z = subscriber instanceof ConditionalSubscriber;
            BiFunction biFunction = this.f18579c;
            Function function = this.f18578b;
            if (z) {
                subscriberArr2[i] = new r22((ConditionalSubscriber) subscriber, function, biFunction, 1);
            } else {
                subscriberArr2[i] = new s22(subscriber, function, biFunction, 1);
            }
        }
        this.f18577a.subscribe(subscriberArr2);
    }
}
