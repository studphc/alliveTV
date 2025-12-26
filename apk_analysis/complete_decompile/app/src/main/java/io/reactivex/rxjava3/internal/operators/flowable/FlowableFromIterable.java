package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.internal.subscriptions.EmptySubscription;
import io.reactivex.rxjava3.operators.ConditionalSubscriber;
import java.util.Iterator;
import org.reactivestreams.Subscriber;
import p000.mm0;
import p000.nm0;

/* loaded from: classes2.dex */
public final class FlowableFromIterable<T> extends Flowable<T> {

    /* renamed from: b */
    public final Iterable f18875b;

    public FlowableFromIterable(Iterable<? extends T> iterable) {
        this.f18875b = iterable;
    }

    public static <T> void subscribe(Subscriber<? super T> subscriber, Iterator<? extends T> it) {
        try {
            if (!it.hasNext()) {
                EmptySubscription.complete(subscriber);
            } else if (subscriber instanceof ConditionalSubscriber) {
                subscriber.onSubscribe(new mm0((ConditionalSubscriber) subscriber, it));
            } else {
                subscriber.onSubscribe(new nm0(subscriber, it));
            }
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            EmptySubscription.error(th, subscriber);
        }
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    public void subscribeActual(Subscriber<? super T> subscriber) {
        try {
            subscribe(subscriber, this.f18875b.iterator());
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            EmptySubscription.error(th, subscriber);
        }
    }
}
