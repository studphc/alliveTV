package p000;

import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.queue.MpscLinkedQueue;
import io.reactivex.rxjava3.internal.subscribers.QueueDrainSubscriber;
import io.reactivex.rxjava3.internal.subscriptions.EmptySubscription;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.QueueDrainHelper;
import io.reactivex.rxjava3.subscribers.SerializedSubscriber;
import java.util.Collection;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class cj0 extends QueueDrainSubscriber implements Subscription, Runnable, Disposable {

    /* renamed from: A */
    public Subscription f8378A;

    /* renamed from: B */
    public Collection f8379B;

    /* renamed from: C */
    public final AtomicReference f8380C;

    /* renamed from: w */
    public final Supplier f8381w;

    /* renamed from: x */
    public final long f8382x;

    /* renamed from: y */
    public final TimeUnit f8383y;

    /* renamed from: z */
    public final Scheduler f8384z;

    public cj0(SerializedSubscriber serializedSubscriber, Supplier supplier, long j, TimeUnit timeUnit, Scheduler scheduler) {
        super(serializedSubscriber, new MpscLinkedQueue());
        this.f8380C = new AtomicReference();
        this.f8381w = supplier;
        this.f8382x = j;
        this.f8383y = timeUnit;
        this.f8384z = scheduler;
    }

    @Override // io.reactivex.rxjava3.internal.subscribers.QueueDrainSubscriber, io.reactivex.rxjava3.internal.util.QueueDrain
    public final boolean accept(Subscriber subscriber, Object obj) {
        this.downstream.onNext((Collection) obj);
        return true;
    }

    @Override // org.reactivestreams.Subscription
    public final void cancel() {
        this.cancelled = true;
        this.f8378A.cancel();
        DisposableHelper.dispose(this.f8380C);
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final void dispose() {
        cancel();
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final boolean isDisposed() {
        if (this.f8380C.get() == DisposableHelper.DISPOSED) {
            return true;
        }
        return false;
    }

    @Override // org.reactivestreams.Subscriber
    public final void onComplete() {
        DisposableHelper.dispose(this.f8380C);
        synchronized (this) {
            try {
                Collection collection = this.f8379B;
                if (collection == null) {
                    return;
                }
                this.f8379B = null;
                this.queue.offer(collection);
                this.done = true;
                if (enter()) {
                    QueueDrainHelper.drainMaxLoop(this.queue, this.downstream, false, null, this);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.reactivestreams.Subscriber
    public final void onError(Throwable th) {
        DisposableHelper.dispose(this.f8380C);
        synchronized (this) {
            this.f8379B = null;
        }
        this.downstream.onError(th);
    }

    @Override // org.reactivestreams.Subscriber
    public final void onNext(Object obj) {
        synchronized (this) {
            try {
                Collection collection = this.f8379B;
                if (collection != null) {
                    collection.add(obj);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // io.reactivex.rxjava3.core.FlowableSubscriber, org.reactivestreams.Subscriber
    public final void onSubscribe(Subscription subscription) {
        if (SubscriptionHelper.validate(this.f8378A, subscription)) {
            this.f8378A = subscription;
            try {
                Object obj = this.f8381w.get();
                Objects.requireNonNull(obj, "The supplied buffer is null");
                this.f8379B = (Collection) obj;
                this.downstream.onSubscribe(this);
                if (!this.cancelled) {
                    subscription.request(Long.MAX_VALUE);
                    Scheduler scheduler = this.f8384z;
                    long j = this.f8382x;
                    Disposable schedulePeriodicallyDirect = scheduler.schedulePeriodicallyDirect(this, j, j, this.f8383y);
                    AtomicReference atomicReference = this.f8380C;
                    while (!atomicReference.compareAndSet(null, schedulePeriodicallyDirect)) {
                        if (atomicReference.get() != null) {
                            schedulePeriodicallyDirect.dispose();
                            return;
                        }
                    }
                }
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                cancel();
                EmptySubscription.error(th, this.downstream);
            }
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            Object obj = this.f8381w.get();
            Objects.requireNonNull(obj, "The supplied buffer is null");
            Collection collection = (Collection) obj;
            synchronized (this) {
                try {
                    Collection collection2 = this.f8379B;
                    if (collection2 == null) {
                        return;
                    }
                    this.f8379B = collection;
                    fastPathEmitMax(collection2, false, this);
                } catch (Throwable th) {
                    throw th;
                }
            }
        } catch (Throwable th2) {
            Exceptions.throwIfFatal(th2);
            cancel();
            this.downstream.onError(th2);
        }
    }
}
