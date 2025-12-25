package io.reactivex.rxjava3.internal.operators.parallel;

import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.BiConsumer;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.subscriptions.EmptySubscription;
import io.reactivex.rxjava3.parallel.ParallelFlowable;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Objects;
import org.reactivestreams.Subscriber;
import p000.a22;

/* loaded from: classes2.dex */
public final class ParallelCollect<T, C> extends ParallelFlowable<C> {

    /* renamed from: a */
    public final ParallelFlowable f19653a;

    /* renamed from: b */
    public final Supplier f19654b;

    /* renamed from: c */
    public final BiConsumer f19655c;

    public ParallelCollect(ParallelFlowable<? extends T> parallelFlowable, Supplier<? extends C> supplier, BiConsumer<? super C, ? super T> biConsumer) {
        this.f19653a = parallelFlowable;
        this.f19654b = supplier;
        this.f19655c = biConsumer;
    }

    @Override // io.reactivex.rxjava3.parallel.ParallelFlowable
    public int parallelism() {
        return this.f19653a.parallelism();
    }

    @Override // io.reactivex.rxjava3.parallel.ParallelFlowable
    public void subscribe(Subscriber<? super C>[] subscriberArr) {
        Subscriber<?>[] onSubscribe = RxJavaPlugins.onSubscribe(this, subscriberArr);
        if (!validate(onSubscribe)) {
            return;
        }
        int length = onSubscribe.length;
        Subscriber<? super T>[] subscriberArr2 = new Subscriber[length];
        for (int i = 0; i < length; i++) {
            try {
                Object obj = this.f19654b.get();
                Objects.requireNonNull(obj, "The initialSupplier returned a null value");
                subscriberArr2[i] = new a22(onSubscribe[i], obj, this.f19655c);
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                for (Subscriber<?> subscriber : onSubscribe) {
                    EmptySubscription.error(th, subscriber);
                }
                return;
            }
        }
        this.f19653a.subscribe(subscriberArr2);
    }
}
