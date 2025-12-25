package io.reactivex.rxjava3.internal.operators.parallel;

import io.reactivex.rxjava3.functions.Predicate;
import io.reactivex.rxjava3.operators.ConditionalSubscriber;
import io.reactivex.rxjava3.parallel.ParallelFlowable;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import org.reactivestreams.Subscriber;
import p000.g22;

/* loaded from: classes2.dex */
public final class ParallelFilter<T> extends ParallelFlowable<T> {

    /* renamed from: a */
    public final ParallelFlowable f19663a;

    /* renamed from: b */
    public final Predicate f19664b;

    public ParallelFilter(ParallelFlowable<T> parallelFlowable, Predicate<? super T> predicate) {
        this.f19663a = parallelFlowable;
        this.f19664b = predicate;
    }

    @Override // io.reactivex.rxjava3.parallel.ParallelFlowable
    public int parallelism() {
        return this.f19663a.parallelism();
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
            Predicate predicate = this.f19664b;
            if (z) {
                subscriberArr2[i] = new g22((ConditionalSubscriber) subscriber, predicate, 0);
            } else {
                subscriberArr2[i] = new g22(subscriber, predicate, 1);
            }
        }
        this.f19663a.subscribe(subscriberArr2);
    }
}
