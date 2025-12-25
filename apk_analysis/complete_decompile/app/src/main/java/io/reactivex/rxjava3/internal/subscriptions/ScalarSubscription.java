package io.reactivex.rxjava3.internal.subscriptions;

import io.reactivex.rxjava3.annotations.Nullable;
import io.reactivex.rxjava3.operators.QueueSubscription;
import java.util.concurrent.atomic.AtomicInteger;
import org.reactivestreams.Subscriber;

/* loaded from: classes2.dex */
public final class ScalarSubscription<T> extends AtomicInteger implements QueueSubscription<T> {
    private static final long serialVersionUID = -3830916580126663321L;

    /* renamed from: a */
    public final Object f19935a;

    /* renamed from: b */
    public final Subscriber f19936b;

    public ScalarSubscription(Subscriber<? super T> subscriber, T t) {
        this.f19936b = subscriber;
        this.f19935a = t;
    }

    @Override // org.reactivestreams.Subscription
    public void cancel() {
        lazySet(2);
    }

    @Override // io.reactivex.rxjava3.operators.SimpleQueue
    public void clear() {
        lazySet(1);
    }

    public boolean isCancelled() {
        if (get() == 2) {
            return true;
        }
        return false;
    }

    @Override // io.reactivex.rxjava3.operators.SimpleQueue
    public boolean isEmpty() {
        if (get() != 0) {
            return true;
        }
        return false;
    }

    @Override // io.reactivex.rxjava3.operators.SimpleQueue, java.util.Queue
    public boolean offer(T t) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    @Override // io.reactivex.rxjava3.operators.SimpleQueue
    @Nullable
    public T poll() {
        if (get() == 0) {
            lazySet(1);
            return (T) this.f19935a;
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.reactivestreams.Subscription
    public void request(long j) {
        if (SubscriptionHelper.validate(j) && compareAndSet(0, 1)) {
            Object obj = this.f19935a;
            Subscriber subscriber = this.f19936b;
            subscriber.onNext(obj);
            if (get() != 2) {
                subscriber.onComplete();
            }
        }
    }

    @Override // io.reactivex.rxjava3.operators.QueueFuseable
    public int requestFusion(int i) {
        return i & 1;
    }

    @Override // io.reactivex.rxjava3.operators.SimpleQueue
    public boolean offer(T t, T t2) {
        throw new UnsupportedOperationException("Should not be called!");
    }
}
