package p000;

import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicBoolean;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class tr0 extends AtomicBoolean implements FlowableSubscriber, Subscription {
    private static final long serialVersionUID = 1015244841293359600L;

    /* renamed from: a */
    public final Subscriber f26944a;

    /* renamed from: b */
    public final Scheduler f26945b;

    /* renamed from: c */
    public Subscription f26946c;

    public tr0(Subscriber subscriber, Scheduler scheduler) {
        this.f26944a = subscriber;
        this.f26945b = scheduler;
    }

    @Override // org.reactivestreams.Subscription
    public final void cancel() {
        if (compareAndSet(false, true)) {
            this.f26945b.scheduleDirect(new RunnableC1104d(17, this));
        }
    }

    @Override // org.reactivestreams.Subscriber
    public final void onComplete() {
        if (!get()) {
            this.f26944a.onComplete();
        }
    }

    @Override // org.reactivestreams.Subscriber
    public final void onError(Throwable th) {
        if (get()) {
            RxJavaPlugins.onError(th);
        } else {
            this.f26944a.onError(th);
        }
    }

    @Override // org.reactivestreams.Subscriber
    public final void onNext(Object obj) {
        if (!get()) {
            this.f26944a.onNext(obj);
        }
    }

    @Override // io.reactivex.rxjava3.core.FlowableSubscriber, org.reactivestreams.Subscriber
    public final void onSubscribe(Subscription subscription) {
        if (SubscriptionHelper.validate(this.f26946c, subscription)) {
            this.f26946c = subscription;
            this.f26944a.onSubscribe(this);
        }
    }

    @Override // org.reactivestreams.Subscription
    public final void request(long j) {
        this.f26946c.request(j);
    }
}
