package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.subscriptions.EmptySubscription;
import java.util.Objects;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;

/* loaded from: classes2.dex */
public final class FlowableDefer<T> extends Flowable<T> {

    /* renamed from: b */
    public final Supplier f18806b;

    public FlowableDefer(Supplier<? extends Publisher<? extends T>> supplier) {
        this.f18806b = supplier;
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    public void subscribeActual(Subscriber<? super T> subscriber) {
        try {
            Object obj = this.f18806b.get();
            Objects.requireNonNull(obj, "The publisher supplied is null");
            ((Publisher) obj).subscribe(subscriber);
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            EmptySubscription.error(th, subscriber);
        }
    }
}
