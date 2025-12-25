package io.reactivex.rxjava3.internal.subscriptions;

import io.reactivex.rxjava3.annotations.Nullable;
import org.reactivestreams.Subscriber;

/* loaded from: classes2.dex */
public class DeferredScalarSubscription<T> extends BasicIntQueueSubscription<T> {
    private static final long serialVersionUID = -2151279923272604993L;
    protected final Subscriber<? super T> downstream;
    protected T value;

    public DeferredScalarSubscription(Subscriber<? super T> subscriber) {
        this.downstream = subscriber;
    }

    public void cancel() {
        set(4);
        this.value = null;
    }

    @Override // io.reactivex.rxjava3.operators.SimpleQueue
    public final void clear() {
        lazySet(32);
        this.value = null;
    }

    public final void complete(T t) {
        int i = get();
        while (i != 8) {
            if ((i & (-3)) != 0) {
                return;
            }
            if (i == 2) {
                lazySet(3);
                Subscriber<? super T> subscriber = this.downstream;
                subscriber.onNext(t);
                if (get() != 4) {
                    subscriber.onComplete();
                    return;
                }
                return;
            }
            this.value = t;
            if (compareAndSet(0, 1)) {
                return;
            }
            i = get();
            if (i == 4) {
                this.value = null;
                return;
            }
        }
        this.value = t;
        lazySet(16);
        Subscriber<? super T> subscriber2 = this.downstream;
        subscriber2.onNext(null);
        if (get() != 4) {
            subscriber2.onComplete();
        }
    }

    public final boolean isCancelled() {
        if (get() == 4) {
            return true;
        }
        return false;
    }

    @Override // io.reactivex.rxjava3.operators.SimpleQueue
    public final boolean isEmpty() {
        if (get() != 16) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onSuccess(Object obj) {
        complete(obj);
    }

    @Override // io.reactivex.rxjava3.operators.SimpleQueue
    @Nullable
    public final T poll() {
        if (get() != 16) {
            return null;
        }
        lazySet(32);
        T t = this.value;
        this.value = null;
        return t;
    }

    @Override // org.reactivestreams.Subscription
    public final void request(long j) {
        T t;
        if (!SubscriptionHelper.validate(j)) {
            return;
        }
        do {
            int i = get();
            if ((i & (-2)) != 0) {
                return;
            }
            if (i == 1) {
                if (compareAndSet(1, 3) && (t = this.value) != null) {
                    this.value = null;
                    Subscriber<? super T> subscriber = this.downstream;
                    subscriber.onNext(t);
                    if (get() != 4) {
                        subscriber.onComplete();
                        return;
                    }
                    return;
                }
                return;
            }
        } while (!compareAndSet(0, 2));
    }

    @Override // io.reactivex.rxjava3.operators.QueueFuseable
    public final int requestFusion(int i) {
        if ((i & 2) != 0) {
            lazySet(8);
            return 2;
        }
        return 0;
    }

    public final boolean tryCancel() {
        if (getAndSet(4) != 4) {
            return true;
        }
        return false;
    }
}
