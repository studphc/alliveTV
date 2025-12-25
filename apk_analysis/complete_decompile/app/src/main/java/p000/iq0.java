package p000;

import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class iq0 implements FlowableSubscriber, Subscription {

    /* renamed from: a */
    public final Subscriber f20187a;

    /* renamed from: b */
    public long f20188b;

    /* renamed from: c */
    public Subscription f20189c;

    public iq0(Subscriber subscriber, long j) {
        this.f20187a = subscriber;
        this.f20188b = j;
    }

    @Override // org.reactivestreams.Subscription
    public final void cancel() {
        this.f20189c.cancel();
    }

    @Override // org.reactivestreams.Subscriber
    public final void onComplete() {
        this.f20187a.onComplete();
    }

    @Override // org.reactivestreams.Subscriber
    public final void onError(Throwable th) {
        this.f20187a.onError(th);
    }

    @Override // org.reactivestreams.Subscriber
    public final void onNext(Object obj) {
        long j = this.f20188b;
        if (j != 0) {
            this.f20188b = j - 1;
        } else {
            this.f20187a.onNext(obj);
        }
    }

    @Override // io.reactivex.rxjava3.core.FlowableSubscriber, org.reactivestreams.Subscriber
    public final void onSubscribe(Subscription subscription) {
        if (SubscriptionHelper.validate(this.f20189c, subscription)) {
            long j = this.f20188b;
            this.f20189c = subscription;
            this.f20187a.onSubscribe(this);
            subscription.request(j);
        }
    }

    @Override // org.reactivestreams.Subscription
    public final void request(long j) {
        this.f20189c.request(j);
    }
}
