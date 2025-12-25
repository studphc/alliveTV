package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.BiConsumer;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.subscriptions.EmptySubscription;
import java.util.Objects;
import org.reactivestreams.Subscriber;
import p000.AbstractC1215g0;
import p000.hj0;

/* loaded from: classes2.dex */
public final class FlowableCollect<T, U> extends AbstractC1215g0 {

    /* renamed from: b */
    public final Supplier f18768b;

    /* renamed from: c */
    public final BiConsumer f18769c;

    public FlowableCollect(Flowable<T> flowable, Supplier<? extends U> supplier, BiConsumer<? super U, ? super T> biConsumer) {
        super(flowable);
        this.f18768b = supplier;
        this.f18769c = biConsumer;
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    public void subscribeActual(Subscriber<? super U> subscriber) {
        try {
            Object obj = this.f18768b.get();
            Objects.requireNonNull(obj, "The initial value supplied is null");
            this.source.subscribe((FlowableSubscriber<? super Object>) new hj0(subscriber, obj, this.f18769c));
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            EmptySubscription.error(th, subscriber);
        }
    }
}
