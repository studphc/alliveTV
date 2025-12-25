package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.fuseable.CancellableQueueFuseable;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import org.reactivestreams.Subscriber;

/* loaded from: classes2.dex */
public final class FlowableFromRunnable<T> extends Flowable<T> implements Supplier<T> {

    /* renamed from: b */
    public final Runnable f18878b;

    public FlowableFromRunnable(Runnable runnable) {
        this.f18878b = runnable;
    }

    @Override // io.reactivex.rxjava3.functions.Supplier
    public T get() {
        this.f18878b.run();
        return null;
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    public void subscribeActual(Subscriber<? super T> subscriber) {
        CancellableQueueFuseable cancellableQueueFuseable = new CancellableQueueFuseable();
        subscriber.onSubscribe(cancellableQueueFuseable);
        if (!cancellableQueueFuseable.isDisposed()) {
            try {
                this.f18878b.run();
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
