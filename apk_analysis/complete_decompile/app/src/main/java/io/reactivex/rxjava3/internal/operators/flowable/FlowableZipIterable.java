package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.BiFunction;
import io.reactivex.rxjava3.internal.subscriptions.EmptySubscription;
import java.util.Iterator;
import java.util.Objects;
import org.reactivestreams.Subscriber;
import p000.AbstractC1215g0;
import p000.bq0;

/* loaded from: classes2.dex */
public final class FlowableZipIterable<T, U, V> extends AbstractC1215g0 {

    /* renamed from: b */
    public final Iterable f19097b;

    /* renamed from: c */
    public final BiFunction f19098c;

    public FlowableZipIterable(Flowable<T> flowable, Iterable<U> iterable, BiFunction<? super T, ? super U, ? extends V> biFunction) {
        super(flowable);
        this.f19097b = iterable;
        this.f19098c = biFunction;
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    public void subscribeActual(Subscriber<? super V> subscriber) {
        try {
            Iterator<T> it = this.f19097b.iterator();
            Objects.requireNonNull(it, "The iterator returned by other is null");
            try {
                if (!it.hasNext()) {
                    EmptySubscription.complete(subscriber);
                } else {
                    this.source.subscribe((FlowableSubscriber<? super Object>) new bq0(subscriber, it, this.f19098c));
                }
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                EmptySubscription.error(th, subscriber);
            }
        } catch (Throwable th2) {
            Exceptions.throwIfFatal(th2);
            EmptySubscription.error(th2, subscriber);
        }
    }
}
