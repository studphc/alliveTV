package p000;

import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.queue.MpscLinkedQueue;
import io.reactivex.rxjava3.internal.subscribers.QueueDrainSubscriber;
import io.reactivex.rxjava3.internal.subscriptions.EmptySubscription;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.QueueDrainHelper;
import io.reactivex.rxjava3.subscribers.SerializedSubscriber;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class ej0 extends QueueDrainSubscriber implements Subscription, Runnable {

    /* renamed from: A */
    public final Scheduler.Worker f16842A;

    /* renamed from: B */
    public final LinkedList f16843B;

    /* renamed from: C */
    public Subscription f16844C;

    /* renamed from: w */
    public final Supplier f16845w;

    /* renamed from: x */
    public final long f16846x;

    /* renamed from: y */
    public final long f16847y;

    /* renamed from: z */
    public final TimeUnit f16848z;

    public ej0(SerializedSubscriber serializedSubscriber, Supplier supplier, long j, long j2, TimeUnit timeUnit, Scheduler.Worker worker) {
        super(serializedSubscriber, new MpscLinkedQueue());
        this.f16845w = supplier;
        this.f16846x = j;
        this.f16847y = j2;
        this.f16848z = timeUnit;
        this.f16842A = worker;
        this.f16843B = new LinkedList();
    }

    @Override // io.reactivex.rxjava3.internal.subscribers.QueueDrainSubscriber, io.reactivex.rxjava3.internal.util.QueueDrain
    public final boolean accept(Subscriber subscriber, Object obj) {
        subscriber.onNext((Collection) obj);
        return true;
    }

    @Override // org.reactivestreams.Subscription
    public final void cancel() {
        this.cancelled = true;
        this.f16844C.cancel();
        this.f16842A.dispose();
        synchronized (this) {
            this.f16843B.clear();
        }
    }

    @Override // org.reactivestreams.Subscriber
    public final void onComplete() {
        ArrayList arrayList;
        synchronized (this) {
            arrayList = new ArrayList(this.f16843B);
            this.f16843B.clear();
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            this.queue.offer((Collection) it.next());
        }
        this.done = true;
        if (enter()) {
            QueueDrainHelper.drainMaxLoop(this.queue, this.downstream, false, this.f16842A, this);
        }
    }

    @Override // org.reactivestreams.Subscriber
    public final void onError(Throwable th) {
        this.done = true;
        this.f16842A.dispose();
        synchronized (this) {
            this.f16843B.clear();
        }
        this.downstream.onError(th);
    }

    @Override // org.reactivestreams.Subscriber
    public final void onNext(Object obj) {
        synchronized (this) {
            try {
                Iterator it = this.f16843B.iterator();
                while (it.hasNext()) {
                    ((Collection) it.next()).add(obj);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // io.reactivex.rxjava3.core.FlowableSubscriber, org.reactivestreams.Subscriber
    public final void onSubscribe(Subscription subscription) {
        Scheduler.Worker worker = this.f16842A;
        if (!SubscriptionHelper.validate(this.f16844C, subscription)) {
            return;
        }
        this.f16844C = subscription;
        try {
            Object obj = this.f16845w.get();
            Objects.requireNonNull(obj, "The supplied buffer is null");
            Collection collection = (Collection) obj;
            this.f16843B.add(collection);
            this.downstream.onSubscribe(this);
            subscription.request(Long.MAX_VALUE);
            TimeUnit timeUnit = this.f16848z;
            Scheduler.Worker worker2 = this.f16842A;
            long j = this.f16847y;
            worker2.schedulePeriodically(this, j, j, timeUnit);
            worker.schedule(new dj0(this, collection), this.f16846x, this.f16848z);
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            worker.dispose();
            subscription.cancel();
            EmptySubscription.error(th, this.downstream);
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.cancelled) {
            return;
        }
        try {
            Object obj = this.f16845w.get();
            Objects.requireNonNull(obj, "The supplied buffer is null");
            Collection collection = (Collection) obj;
            synchronized (this) {
                try {
                    if (this.cancelled) {
                        return;
                    }
                    this.f16843B.add(collection);
                    this.f16842A.schedule(new dj0(this, collection), this.f16846x, this.f16848z);
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
