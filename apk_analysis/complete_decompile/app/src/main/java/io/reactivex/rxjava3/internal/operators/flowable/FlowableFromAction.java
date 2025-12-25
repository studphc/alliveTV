package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.fuseable.CancellableQueueFuseable;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import org.reactivestreams.Subscriber;

/* loaded from: classes2.dex */
public final class FlowableFromAction<T> extends Flowable<T> implements Supplier<T> {

    /* renamed from: b */
    public final Action f18866b;

    public FlowableFromAction(Action action) {
        this.f18866b = action;
    }

    @Override // io.reactivex.rxjava3.functions.Supplier
    public T get() {
        this.f18866b.run();
        return null;
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    public void subscribeActual(Subscriber<? super T> subscriber) {
        CancellableQueueFuseable cancellableQueueFuseable = new CancellableQueueFuseable();
        subscriber.onSubscribe(cancellableQueueFuseable);
        if (!cancellableQueueFuseable.isDisposed()) {
            try {
                this.f18866b.run();
                if (!cancellableQueueFuseable.isDisposed()) {
                    subscriber.onComplete();
                }
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                if (!cancellableQueueFuseable.isDisposed()) {
                    subscriber.onError(th);
                } else {
                    RxJavaPlugins.onError(th);
                }
            }
        }
    }
}
