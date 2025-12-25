package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.subscriptions.EmptySubscription;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import org.reactivestreams.Subscriber;

/* loaded from: classes2.dex */
public final class FlowableError<T> extends Flowable<T> {

    /* renamed from: b */
    public final Supplier f18837b;

    public FlowableError(Supplier<? extends Throwable> supplier) {
        this.f18837b = supplier;
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    public void subscribeActual(Subscriber<? super T> subscriber) {
        try {
            th = (Throwable) ExceptionHelper.nullCheck(this.f18837b.get(), "Callable returned a null Throwable.");
        } catch (Throwable th) {
            th = th;
            Exceptions.throwIfFatal(th);
        }
        EmptySubscription.error(th, subscriber);
    }
}
