package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import org.reactivestreams.Subscriber;

/* loaded from: classes2.dex */
public final class FlowableFromFuture<T> extends Flowable<T> {

    /* renamed from: b */
    public final Future f18872b;

    /* renamed from: c */
    public final long f18873c;

    /* renamed from: d */
    public final TimeUnit f18874d;

    public FlowableFromFuture(Future<? extends T> future, long j, TimeUnit timeUnit) {
        this.f18872b = future;
        this.f18873c = j;
        this.f18874d = timeUnit;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.reactivex.rxjava3.core.Flowable
    public void subscribeActual(Subscriber<? super T> subscriber) {
        Object obj;
        DeferredScalarSubscription deferredScalarSubscription = new DeferredScalarSubscription(subscriber);
        subscriber.onSubscribe(deferredScalarSubscription);
        try {
            TimeUnit timeUnit = this.f18874d;
            Future future = this.f18872b;
            if (timeUnit != null) {
                obj = future.get(this.f18873c, timeUnit);
            } else {
                obj = future.get();
            }
            if (obj == null) {
                subscriber.onError(ExceptionHelper.createNullPointerException("The future returned a null value."));
            } else {
                deferredScalarSubscription.complete(obj);
            }
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            if (!deferredScalarSubscription.isCancelled()) {
                subscriber.onError(th);
            }
        }
    }
}
