package p000;

import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.operators.ConditionalSubscriber;
import io.reactivex.rxjava3.operators.QueueSubscription;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class ll0 extends BasicIntQueueSubscription implements ConditionalSubscriber {
    private static final long serialVersionUID = 4109457741734051389L;

    /* renamed from: a */
    public final ConditionalSubscriber f22552a;

    /* renamed from: b */
    public final Action f22553b;

    /* renamed from: c */
    public Subscription f22554c;

    /* renamed from: d */
    public QueueSubscription f22555d;

    /* renamed from: e */
    public boolean f22556e;

    public ll0(ConditionalSubscriber conditionalSubscriber, Action action) {
        this.f22552a = conditionalSubscriber;
        this.f22553b = action;
    }

    @Override // org.reactivestreams.Subscription
    public final void cancel() {
        this.f22554c.cancel();
        m5939e();
    }

    @Override // io.reactivex.rxjava3.operators.SimpleQueue
    public final void clear() {
        this.f22555d.clear();
    }

    /* renamed from: e */
    public final void m5939e() {
        if (compareAndSet(0, 1)) {
            try {
                this.f22553b.run();
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                RxJavaPlugins.onError(th);
            }
        }
    }

    @Override // io.reactivex.rxjava3.operators.SimpleQueue
    public final boolean isEmpty() {
        return this.f22555d.isEmpty();
    }

    @Override // org.reactivestreams.Subscriber
    public final void onComplete() {
        this.f22552a.onComplete();
        m5939e();
    }

    @Override // org.reactivestreams.Subscriber
    public final void onError(Throwable th) {
        this.f22552a.onError(th);
        m5939e();
    }

    @Override // org.reactivestreams.Subscriber
    public final void onNext(Object obj) {
        this.f22552a.onNext(obj);
    }

    @Override // io.reactivex.rxjava3.core.FlowableSubscriber, org.reactivestreams.Subscriber
    public final void onSubscribe(Subscription subscription) {
        if (SubscriptionHelper.validate(this.f22554c, subscription)) {
            this.f22554c = subscription;
            if (subscription instanceof QueueSubscription) {
                this.f22555d = (QueueSubscription) subscription;
            }
            this.f22552a.onSubscribe(this);
        }
    }

    @Override // io.reactivex.rxjava3.operators.SimpleQueue
    public final Object poll() {
        T poll = this.f22555d.poll();
        if (poll == 0 && this.f22556e) {
            m5939e();
        }
        return poll;
    }

    @Override // org.reactivestreams.Subscription
    public final void request(long j) {
        this.f22554c.request(j);
    }

    @Override // io.reactivex.rxjava3.operators.QueueFuseable
    public final int requestFusion(int i) {
        QueueSubscription queueSubscription = this.f22555d;
        boolean z = false;
        if (queueSubscription == null || (i & 4) != 0) {
            return 0;
        }
        int requestFusion = queueSubscription.requestFusion(i);
        if (requestFusion != 0) {
            if (requestFusion == 1) {
                z = true;
            }
            this.f22556e = z;
        }
        return requestFusion;
    }

    @Override // io.reactivex.rxjava3.operators.ConditionalSubscriber
    public final boolean tryOnNext(Object obj) {
        return this.f22552a.tryOnNext(obj);
    }
}
