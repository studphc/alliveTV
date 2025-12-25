package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Objects;
import org.reactivestreams.Subscriber;

/* loaded from: classes2.dex */
public final class FlowableFromSupplier<T> extends Flowable<T> implements Supplier<T> {

    /* renamed from: b */
    public final Supplier f18879b;

    public FlowableFromSupplier(Supplier<? extends T> supplier) {
        this.f18879b = supplier;
    }

    @Override // io.reactivex.rxjava3.functions.Supplier
    public T get() {
        T t = (T) this.f18879b.get();
        Objects.requireNonNull(t, "The supplier returned a null value");
        return t;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.reactivex.rxjava3.core.Flowable
    public void subscribeActual(Subscriber<? super T> subscriber) {
        DeferredScalarSubscription deferredScalarSubscription = new DeferredScalarSubscription(subscriber);
        subscriber.onSubscribe(deferredScalarSubscription);
        try {
            Object obj = this.f18879b.get();
            Objects.requireNonNull(obj, "The supplier returned a null value");
            deferredScalarSubscription.complete(obj);
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            if (deferredScalarSubscription.isCancelled()) {
                RxJavaPlugins.onError(th);
            } else {
                subscriber.onError(th);
            }
        }
    }
}
