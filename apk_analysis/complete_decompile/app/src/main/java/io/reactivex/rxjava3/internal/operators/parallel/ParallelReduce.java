package io.reactivex.rxjava3.internal.operators.parallel;

import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.BiFunction;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.subscriptions.EmptySubscription;
import io.reactivex.rxjava3.parallel.ParallelFlowable;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Objects;
import org.reactivestreams.Subscriber;
import p000.u22;

/* loaded from: classes2.dex */
public final class ParallelReduce<T, R> extends ParallelFlowable<R> {

    /* renamed from: a */
    public final ParallelFlowable f19697a;

    /* renamed from: b */
    public final Supplier f19698b;

    /* renamed from: c */
    public final BiFunction f19699c;

    public ParallelReduce(ParallelFlowable<? extends T> parallelFlowable, Supplier<R> supplier, BiFunction<R, ? super T, R> biFunction) {
        this.f19697a = parallelFlowable;
        this.f19698b = supplier;
        this.f19699c = biFunction;
    }

    @Override // io.reactivex.rxjava3.parallel.ParallelFlowable
    public int parallelism() {
        return this.f19697a.parallelism();
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
            try {
                Object obj = this.f19698b.get();
                Objects.requireNonNull(obj, "The initialSupplier returned a null value");
                subscriberArr2[i] = new u22(onSubscribe[i], obj, this.f19699c);
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                for (Subscriber<?> subscriber : onSubscribe) {
                    EmptySubscription.error(th, subscriber);
                }
                return;
            }
        }
        this.f19697a.subscribe(subscriberArr2);
    }
}
