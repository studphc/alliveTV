package p000;

import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.operators.QueueSubscription;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class ml0 extends BasicIntQueueSubscription implements FlowableSubscriber {
    private static final long serialVersionUID = 4109457741734051389L;

    /* renamed from: a */
    public final Subscriber f22973a;

    /* renamed from: b */
    public final Action f22974b;

    /* renamed from: c */
    public Subscription f22975c;

    /* renamed from: d */
    public QueueSubscription f22976d;

    /* renamed from: e */
    public boolean f22977e;

    public ml0(Subscriber subscriber, Action action) {
        this.f22973a = subscriber;
        this.f22974b = action;
    }

    @Override // org.reactivestreams.Subscription
    public final void cancel() {
        this.f22975c.cancel();
        m6181e();
    }

    @Override // io.reactivex.rxjava3.operators.SimpleQueue
    public final void clear() {
        this.f22976d.clear();
    }

    /* renamed from: e */
    public final void m6181e() {
        if (compareAndSet(0, 1)) {
            try {
                this.f22974b.run();
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                RxJavaPlugins.onError(th);
            }
        }
    }

    @Override // io.reactivex.rxjava3.operators.SimpleQueue
    public final boolean isEmpty() {
        return this.f22976d.isEmpty();
    }

    @Override // org.reactivestreams.Subscriber
    public final void onComplete() {
        this.f22973a.onComplete();
        m6181e();
    }

    @Override // org.reactivestreams.Subscriber
    public final void onError(Throwable th) {
        this.f22973a.onError(th);
        m6181e();
    }

    @Override // org.reactivestreams.Subscriber
    public final void onNext(Object obj) {
        this.f22973a.onNext(obj);
    }

    @Override // io.reactivex.rxjava3.core.FlowableSubscriber, org.reactivestreams.Subscriber
    public final void onSubscribe(Subscription subscription) {
        if (SubscriptionHelper.validate(this.f22975c, subscription)) {
            this.f22975c = subscription;
            if (subscription instanceof QueueSubscription) {
                this.f22976d = (QueueSubscription) subscription;
            }
            this.f22973a.onSubscribe(this);
        }
    }

    @Override // io.reactivex.rxjava3.operators.SimpleQueue
    public final Object poll() {
        T poll = this.f22976d.poll();
        if (poll == 0 && this.f22977e) {
            m6181e();
        }
        return poll;
    }

    @Override // org.reactivestreams.Subscription
    public final void request(long j) {
        this.f22975c.request(j);
    }

    @Override // io.reactivex.rxjava3.operators.QueueFuseable
    public final int requestFusion(int i) {
        QueueSubscription queueSubscription = this.f22976d;
        boolean z = false;
        if (queueSubscription == null || (i & 4) != 0) {
            return 0;
        }
        int requestFusion = queueSubscription.requestFusion(i);
        if (requestFusion != 0) {
            if (requestFusion == 1) {
                z = true;
            }
            this.f22977e = z;
        }
        return requestFusion;
    }
}
