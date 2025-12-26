package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.internal.subscriptions.ScalarSubscription;
import io.reactivex.rxjava3.operators.ScalarSupplier;
import org.reactivestreams.Subscriber;

/* loaded from: classes2.dex */
public final class FlowableJust<T> extends Flowable<T> implements ScalarSupplier<T> {

    /* renamed from: b */
    public final Object f18923b;

    public FlowableJust(T t) {
        this.f18923b = t;
    }

    @Override // io.reactivex.rxjava3.operators.ScalarSupplier, io.reactivex.rxjava3.functions.Supplier
    public T get() {
        return (T) this.f18923b;
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    public void subscribeActual(Subscriber<? super T> subscriber) {
        subscriber.onSubscribe(new ScalarSubscription(subscriber, this.f18923b));
    }
}
