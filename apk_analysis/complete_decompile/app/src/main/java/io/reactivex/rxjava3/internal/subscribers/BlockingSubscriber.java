package io.reactivex.rxjava3.internal.subscribers;

import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.NotificationLite;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class BlockingSubscriber<T> extends AtomicReference<Subscription> implements FlowableSubscriber<T>, Subscription {
    public static final Object TERMINATED = new Object();
    private static final long serialVersionUID = -4875965440900746268L;

    /* renamed from: a */
    public final Queue f19893a;

    public BlockingSubscriber(Queue<Object> queue) {
        this.f19893a = queue;
    }

    @Override // org.reactivestreams.Subscription
    public void cancel() {
        if (SubscriptionHelper.cancel(this)) {
            this.f19893a.offer(TERMINATED);
        }
    }

    public boolean isCancelled() {
        if (get() == SubscriptionHelper.CANCELLED) {
            return true;
        }
        return false;
    }

    @Override // org.reactivestreams.Subscriber
    public void onComplete() {
        this.f19893a.offer(NotificationLite.complete());
    }

    @Override // org.reactivestreams.Subscriber
    public void onError(Throwable th) {
        this.f19893a.offer(NotificationLite.error(th));
    }

    @Override // org.reactivestreams.Subscriber
    public void onNext(T t) {
        this.f19893a.offer(NotificationLite.next(t));
    }

    @Override // io.reactivex.rxjava3.core.FlowableSubscriber, org.reactivestreams.Subscriber
    public void onSubscribe(Subscription subscription) {
        if (SubscriptionHelper.setOnce(this, subscription)) {
            this.f19893a.offer(NotificationLite.subscription(this));
        }
    }

    @Override // org.reactivestreams.Subscription
    public void request(long j) {
        get().request(j);
    }
}
