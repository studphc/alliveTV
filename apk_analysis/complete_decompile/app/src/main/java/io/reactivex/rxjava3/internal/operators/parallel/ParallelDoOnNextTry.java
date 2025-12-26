package io.reactivex.rxjava3.internal.operators.parallel;

import io.reactivex.rxjava3.functions.BiFunction;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.operators.ConditionalSubscriber;
import io.reactivex.rxjava3.parallel.ParallelFailureHandling;
import io.reactivex.rxjava3.parallel.ParallelFlowable;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import org.reactivestreams.Subscriber;
import p000.f22;

/* loaded from: classes2.dex */
public final class ParallelDoOnNextTry<T> extends ParallelFlowable<T> {

    /* renamed from: a */
    public final ParallelFlowable f19660a;

    /* renamed from: b */
    public final Consumer f19661b;

    /* renamed from: c */
    public final BiFunction f19662c;

    public ParallelDoOnNextTry(ParallelFlowable<T> parallelFlowable, Consumer<? super T> consumer, BiFunction<? super Long, ? super Throwable, ParallelFailureHandling> biFunction) {
        this.f19660a = parallelFlowable;
        this.f19661b = consumer;
        this.f19662c = biFunction;
    }

    @Override // io.reactivex.rxjava3.parallel.ParallelFlowable
    public int parallelism() {
        return this.f19660a.parallelism();
    }

    @Override // io.reactivex.rxjava3.parallel.ParallelFlowable
    public void subscribe(Subscriber<? super T>[] subscriberArr) {
        Subscriber<?>[] onSubscribe = RxJavaPlugins.onSubscribe(this, subscriberArr);
        if (!validate(onSubscribe)) {
            return;
        }
        int length = onSubscribe.length;
        Subscriber<? super T>[] subscriberArr2 = new Subscriber[length];
        for (int i = 0; i < length; i++) {
            Subscriber<?> subscriber = onSubscribe[i];
            boolean z = subscriber instanceof ConditionalSubscriber;
            BiFunction biFunction = this.f19662c;
            Consumer consumer = this.f19661b;
            if (z) {
                subscriberArr2[i] = new f22((ConditionalSubscriber) subscriber, consumer, biFunction, 0);
            } else {
                subscriberArr2[i] = new f22(subscriber, consumer, biFunction, 1);
            }
        }
        this.f19660a.subscribe(subscriberArr2);
    }
}
