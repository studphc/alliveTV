package io.reactivex.rxjava3.internal.jdk8;

import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.operators.ConditionalSubscriber;
import io.reactivex.rxjava3.parallel.ParallelFlowable;
import java.util.Optional;
import org.reactivestreams.Subscriber;
import p000.p22;

/* loaded from: classes2.dex */
public final class ParallelMapOptional<T, R> extends ParallelFlowable<R> {

    /* renamed from: a */
    public final ParallelFlowable f18575a;

    /* renamed from: b */
    public final Function f18576b;

    public ParallelMapOptional(ParallelFlowable<T> parallelFlowable, Function<? super T, Optional<? extends R>> function) {
        this.f18575a = parallelFlowable;
        this.f18576b = function;
    }

    @Override // io.reactivex.rxjava3.parallel.ParallelFlowable
    public int parallelism() {
        return this.f18575a.parallelism();
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
            Function function = this.f18576b;
            if (z) {
                subscriberArr2[i] = new p22((ConditionalSubscriber) subscriber, function, 1);
            } else {
                subscriberArr2[i] = new p22(subscriber, function, 2);
            }
        }
        this.f18575a.subscribe(subscriberArr2);
    }
}
