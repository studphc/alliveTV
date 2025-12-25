package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.BiFunction;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.subscriptions.EmptySubscription;
import java.util.Objects;
import org.reactivestreams.Subscriber;
import p000.AbstractC1215g0;
import p000.cq0;

/* loaded from: classes2.dex */
public final class FlowableScanSeed<T, R> extends AbstractC1215g0 {

    /* renamed from: b */
    public final BiFunction f19002b;

    /* renamed from: c */
    public final Supplier f19003c;

    public FlowableScanSeed(Flowable<T> flowable, Supplier<R> supplier, BiFunction<R, ? super T, R> biFunction) {
        super(flowable);
        this.f19002b = biFunction;
        this.f19003c = supplier;
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    public void subscribeActual(Subscriber<? super R> subscriber) {
        try {
            Object obj = this.f19003c.get();
            Objects.requireNonNull(obj, "The seed supplied is null");
            this.source.subscribe((FlowableSubscriber<? super Object>) new cq0(subscriber, this.f19002b, obj, Flowable.bufferSize()));
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            EmptySubscription.error(th, subscriber);
        }
    }
}
