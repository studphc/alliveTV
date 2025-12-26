package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.exceptions.CompositeException;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.subscriptions.EmptySubscription;
import java.util.Objects;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import p000.ur0;

/* loaded from: classes2.dex */
public final class FlowableUsing<T, D> extends Flowable<T> {

    /* renamed from: b */
    public final Supplier f19068b;

    /* renamed from: c */
    public final Function f19069c;

    /* renamed from: d */
    public final Consumer f19070d;

    /* renamed from: e */
    public final boolean f19071e;

    public FlowableUsing(Supplier<? extends D> supplier, Function<? super D, ? extends Publisher<? extends T>> function, Consumer<? super D> consumer, boolean z) {
        this.f19068b = supplier;
        this.f19069c = function;
        this.f19070d = consumer;
        this.f19071e = z;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.reactivex.rxjava3.core.Flowable
    public void subscribeActual(Subscriber<? super T> subscriber) {
        Consumer consumer = this.f19070d;
        try {
            Object obj = this.f19068b.get();
            try {
                Object apply = this.f19069c.apply(obj);
                Objects.requireNonNull(apply, "The sourceSupplier returned a null Publisher");
                ((Publisher) apply).subscribe(new ur0(subscriber, obj, consumer, this.f19071e));
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                try {
                    consumer.accept(obj);
                    EmptySubscription.error(th, subscriber);
                } catch (Throwable th2) {
                    Exceptions.throwIfFatal(th2);
                    EmptySubscription.error(new CompositeException(th, th2), subscriber);
                }
            }
        } catch (Throwable th3) {
            Exceptions.throwIfFatal(th3);
            EmptySubscription.error(th3, subscriber);
        }
    }
}
