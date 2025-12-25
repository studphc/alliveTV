package io.reactivex.rxjava3.internal.subscribers;

import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.QueueDrainHelper;
import io.reactivex.rxjava3.operators.QueueSubscription;
import io.reactivex.rxjava3.operators.SimpleQueue;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class InnerQueuedSubscriber<T> extends AtomicReference<Subscription> implements FlowableSubscriber<T>, Subscription {
    private static final long serialVersionUID = 22876611072430776L;

    /* renamed from: a */
    public final InnerQueuedSubscriberSupport f19911a;

    /* renamed from: b */
    public final int f19912b;

    /* renamed from: c */
    public final int f19913c;

    /* renamed from: d */
    public volatile SimpleQueue f19914d;

    /* renamed from: e */
    public volatile boolean f19915e;

    /* renamed from: f */
    public long f19916f;

    /* renamed from: g */
    public int f19917g;

    public InnerQueuedSubscriber(InnerQueuedSubscriberSupport<T> innerQueuedSubscriberSupport, int i) {
        this.f19911a = innerQueuedSubscriberSupport;
        this.f19912b = i;
        this.f19913c = i - (i >> 2);
    }

    @Override // org.reactivestreams.Subscription
    public void cancel() {
        SubscriptionHelper.cancel(this);
    }

    public boolean isDone() {
        return this.f19915e;
    }

    @Override // org.reactivestreams.Subscriber
    public void onComplete() {
        this.f19911a.innerComplete(this);
    }

    @Override // org.reactivestreams.Subscriber
    public void onError(Throwable th) {
        this.f19911a.innerError(this, th);
    }

    @Override // org.reactivestreams.Subscriber
    public void onNext(T t) {
        int i = this.f19917g;
        InnerQueuedSubscriberSupport innerQueuedSubscriberSupport = this.f19911a;
        if (i == 0) {
            innerQueuedSubscriberSupport.innerNext(this, t);
        } else {
            innerQueuedSubscriberSupport.drain();
        }
    }

    @Override // io.reactivex.rxjava3.core.FlowableSubscriber, org.reactivestreams.Subscriber
    public void onSubscribe(Subscription subscription) {
        if (SubscriptionHelper.setOnce(this, subscription)) {
            if (subscription instanceof QueueSubscription) {
                QueueSubscription queueSubscription = (QueueSubscription) subscription;
                int requestFusion = queueSubscription.requestFusion(3);
                if (requestFusion == 1) {
                    this.f19917g = requestFusion;
                    this.f19914d = queueSubscription;
                    this.f19915e = true;
                    this.f19911a.innerComplete(this);
                    return;
                }
                if (requestFusion == 2) {
                    this.f19917g = requestFusion;
                    this.f19914d = queueSubscription;
                    QueueDrainHelper.request(subscription, this.f19912b);
                    return;
                }
            }
            this.f19914d = QueueDrainHelper.createQueue(this.f19912b);
            QueueDrainHelper.request(subscription, this.f19912b);
        }
    }

    public SimpleQueue<T> queue() {
        return this.f19914d;
    }

    @Override // org.reactivestreams.Subscription
    public void request(long j) {
        if (this.f19917g != 1) {
            long j2 = this.f19916f + j;
            if (j2 >= this.f19913c) {
                this.f19916f = 0L;
                get().request(j2);
            } else {
                this.f19916f = j2;
            }
        }
    }

    public void setDone() {
        this.f19915e = true;
    }
}
