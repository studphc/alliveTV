package io.reactivex.rxjava3.internal.operators.parallel;

import io.reactivex.rxjava3.functions.BiFunction;
import io.reactivex.rxjava3.functions.Predicate;
import io.reactivex.rxjava3.operators.ConditionalSubscriber;
import io.reactivex.rxjava3.parallel.ParallelFailureHandling;
import io.reactivex.rxjava3.parallel.ParallelFlowable;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import org.reactivestreams.Subscriber;
import p000.i22;

/* loaded from: classes2.dex */
public final class ParallelFilterTry<T> extends ParallelFlowable<T> {

    /* renamed from: a */
    public final ParallelFlowable f19665a;

    /* renamed from: b */
    public final Predicate f19666b;

    /* renamed from: c */
    public final BiFunction f19667c;

    public ParallelFilterTry(ParallelFlowable<T> parallelFlowable, Predicate<? super T> predicate, BiFunction<? super Long, ? super Throwable, ParallelFailureHandling> biFunction) {
        this.f19665a = parallelFlowable;
        this.f19666b = predicate;
        this.f19667c = biFunction;
    }

    @Override // io.reactivex.rxjava3.parallel.ParallelFlowable
    public int parallelism() {
        return this.f19665a.parallelism();
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
            BiFunction biFunction = this.f19667c;
            Predicate predicate = this.f19666b;
            if (z) {
                subscriberArr2[i] = new i22((ConditionalSubscriber) subscriber, predicate, biFunction, 0);
            } else {
                subscriberArr2[i] = new i22(subscriber, predicate, biFunction, 1);
            }
        }
        this.f19665a.subscribe(subscriberArr2);
    }
}
