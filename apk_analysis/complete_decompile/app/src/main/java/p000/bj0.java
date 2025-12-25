package p000;

import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.queue.MpscLinkedQueue;
import io.reactivex.rxjava3.internal.subscribers.QueueDrainSubscriber;
import io.reactivex.rxjava3.internal.subscriptions.EmptySubscription;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.QueueDrainHelper;
import io.reactivex.rxjava3.subscribers.SerializedSubscriber;
import java.util.Collection;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class bj0 extends QueueDrainSubscriber implements Subscription, Runnable, Disposable {

    /* renamed from: A */
    public final boolean f8032A;

    /* renamed from: B */
    public final Scheduler.Worker f8033B;

    /* renamed from: C */
    public Collection f8034C;

    /* renamed from: D */
    public Disposable f8035D;

    /* renamed from: E */
    public Subscription f8036E;

    /* renamed from: F */
    public long f8037F;

    /* renamed from: G */
    public long f8038G;

    /* renamed from: w */
    public final Supplier f8039w;

    /* renamed from: x */
    public final long f8040x;

    /* renamed from: y */
    public final TimeUnit f8041y;

    /* renamed from: z */
    public final int f8042z;

    public bj0(SerializedSubscriber serializedSubscriber, Supplier supplier, long j, TimeUnit timeUnit, int i, boolean z, Scheduler.Worker worker) {
        super(serializedSubscriber, new MpscLinkedQueue());
        this.f8039w = supplier;
        this.f8040x = j;
        this.f8041y = timeUnit;
        this.f8042z = i;
        this.f8032A = z;
        this.f8033B = worker;
    }

    @Override // io.reactivex.rxjava3.internal.subscribers.QueueDrainSubscriber, io.reactivex.rxjava3.internal.util.QueueDrain
    public final boolean accept(Subscriber subscriber, Object obj) {
        subscriber.onNext((Collection) obj);
        return true;
    }

    @Override // org.reactivestreams.Subscription
    public final void cancel() {
        if (!this.cancelled) {
            this.cancelled = true;
            dispose();
        }
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final void dispose() {
        synchronized (this) {
            this.f8034C = null;
        }
        this.f8036E.cancel();
        this.f8033B.dispose();
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final boolean isDisposed() {
        return this.f8033B.isDisposed();
    }

    @Override // org.reactivestreams.Subscriber
    public final void onComplete() {
        Collection collection;
        synchronized (this) {
            collection = this.f8034C;
            this.f8034C = null;
        }
        if (collection != null) {
            this.queue.offer(collection);
            this.done = true;
            if (enter()) {
                QueueDrainHelper.drainMaxLoop(this.queue, this.downstream, false, this, this);
            }
            this.f8033B.dispose();
        }
    }

    @Override // org.reactivestreams.Subscriber
    public final void onError(Throwable th) {
        synchronized (this) {
            this.f8034C = null;
        }
        this.downstream.onError(th);
        this.f8033B.dispose();
    }

    @Override // org.reactivestreams.Subscriber
    public final void onNext(Object obj) {
        synchronized (this) {
            try {
                Collection collection = this.f8034C;
                if (collection == null) {
                    return;
                }
                collection.add(obj);
                if (collection.size() < this.f8042z) {
                    return;
                }
                this.f8034C = null;
                this.f8037F++;
                if (this.f8032A) {
                    this.f8035D.dispose();
                }
                fastPathOrderedEmitMax(collection, false, this);
                try {
                    Object obj2 = this.f8039w.get();
                    Objects.requireNonNull(obj2, "The supplied buffer is null");
                    Collection collection2 = (Collection) obj2;
                    synchronized (this) {
                        this.f8034C = collection2;
                        this.f8038G++;
                    }
                    if (this.f8032A) {
                        Scheduler.Worker worker = this.f8033B;
                        long j = this.f8040x;
                        this.f8035D = worker.schedulePeriodically(this, j, j, this.f8041y);
                    }
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    cancel();
                    this.downstream.onError(th);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // io.reactivex.rxjava3.core.FlowableSubscriber, org.reactivestreams.Subscriber
    public final void onSubscribe(Subscription subscription) {
        if (!SubscriptionHelper.validate(this.f8036E, subscription)) {
            return;
        }
        this.f8036E = subscription;
        try {
            Object obj = this.f8039w.get();
            Objects.requireNonNull(obj, "The supplied buffer is null");
            this.f8034C = (Collection) obj;
            this.downstream.onSubscribe(this);
            TimeUnit timeUnit = this.f8041y;
            Scheduler.Worker worker = this.f8033B;
            long j = this.f8040x;
            this.f8035D = worker.schedulePeriodically(this, j, j, timeUnit);
            subscription.request(Long.MAX_VALUE);
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            this.f8033B.dispose();
            subscription.cancel();
            EmptySubscription.error(th, this.downstream);
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            Object obj = this.f8039w.get();
            Objects.requireNonNull(obj, "The supplied buffer is null");
            Collection collection = (Collection) obj;
            synchronized (this) {
                Collection collection2 = this.f8034C;
                if (collection2 != null && this.f8037F == this.f8038G) {
                    this.f8034C = collection;
                    fastPathOrderedEmitMax(collection2, false, this);
                }
            }
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            cancel();
            this.downstream.onError(th);
        }
    }
}
