package p000;

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
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class aj0 extends QueueDrainSubscriber implements Subscription, Disposable {

    /* renamed from: A */
    public Collection f217A;

    /* renamed from: w */
    public final Supplier f218w;

    /* renamed from: x */
    public final Publisher f219x;

    /* renamed from: y */
    public Subscription f220y;

    /* renamed from: z */
    public zi0 f221z;

    public aj0(SerializedSubscriber serializedSubscriber, Supplier supplier, Publisher publisher) {
        super(serializedSubscriber, new MpscLinkedQueue());
        this.f218w = supplier;
        this.f219x = publisher;
    }

    /* renamed from: Y */
    public final void m103Y() {
        try {
            Object obj = this.f218w.get();
            Objects.requireNonNull(obj, "The buffer supplied is null");
            Collection collection = (Collection) obj;
            synchronized (this) {
                try {
                    Collection collection2 = this.f217A;
                    if (collection2 == null) {
                        return;
                    }
                    this.f217A = collection;
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

    @Override // io.reactivex.rxjava3.internal.subscribers.QueueDrainSubscriber, io.reactivex.rxjava3.internal.util.QueueDrain
    public final boolean accept(Subscriber subscriber, Object obj) {
        this.downstream.onNext((Collection) obj);
        return true;
    }

    @Override // org.reactivestreams.Subscription
    public final void cancel() {
        if (!this.cancelled) {
            this.cancelled = true;
            this.f221z.dispose();
            this.f220y.cancel();
            if (enter()) {
                this.queue.clear();
            }
        }
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final void dispose() {
        cancel();
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final boolean isDisposed() {
        return this.cancelled;
    }

    @Override // org.reactivestreams.Subscriber
    public final void onComplete() {
        synchronized (this) {
            try {
                Collection collection = this.f217A;
                if (collection == null) {
                    return;
                }
                this.f217A = null;
                this.queue.offer(collection);
                this.done = true;
                if (enter()) {
                    QueueDrainHelper.drainMaxLoop(this.queue, this.downstream, false, this, this);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.reactivestreams.Subscriber
    public final void onError(Throwable th) {
        cancel();
        this.downstream.onError(th);
    }

    @Override // org.reactivestreams.Subscriber
    public final void onNext(Object obj) {
        synchronized (this) {
            try {
                Collection collection = this.f217A;
                if (collection == null) {
                    return;
                }
                collection.add(obj);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // io.reactivex.rxjava3.core.FlowableSubscriber, org.reactivestreams.Subscriber
    public final void onSubscribe(Subscription subscription) {
        if (!SubscriptionHelper.validate(this.f220y, subscription)) {
            return;
        }
        this.f220y = subscription;
        try {
            Object obj = this.f218w.get();
            Objects.requireNonNull(obj, "The buffer supplied is null");
            this.f217A = (Collection) obj;
            zi0 zi0Var = new zi0(this);
            this.f221z = zi0Var;
            this.downstream.onSubscribe(this);
            if (!this.cancelled) {
                subscription.request(Long.MAX_VALUE);
                this.f219x.subscribe(zi0Var);
            }
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            this.cancelled = true;
            subscription.cancel();
            EmptySubscription.error(th, this.downstream);
        }
    }
}
