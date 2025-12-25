package p000;

import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import java.util.ArrayDeque;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class jq0 extends ArrayDeque implements FlowableSubscriber, Subscription {
    private static final long serialVersionUID = -3807491841935125653L;

    /* renamed from: a */
    public final Subscriber f20583a;

    /* renamed from: b */
    public final int f20584b;

    /* renamed from: c */
    public Subscription f20585c;

    public jq0(Subscriber subscriber, int i) {
        super(i);
        this.f20583a = subscriber;
        this.f20584b = i;
    }

    @Override // org.reactivestreams.Subscription
    public final void cancel() {
        this.f20585c.cancel();
    }

    @Override // org.reactivestreams.Subscriber
    public final void onComplete() {
        this.f20583a.onComplete();
    }

    @Override // org.reactivestreams.Subscriber
    public final void onError(Throwable th) {
        this.f20583a.onError(th);
    }

    @Override // org.reactivestreams.Subscriber
    public final void onNext(Object obj) {
        if (this.f20584b == size()) {
            this.f20583a.onNext(poll());
        } else {
            this.f20585c.request(1L);
        }
        offer(obj);
    }

    @Override // io.reactivex.rxjava3.core.FlowableSubscriber, org.reactivestreams.Subscriber
    public final void onSubscribe(Subscription subscription) {
        if (SubscriptionHelper.validate(this.f20585c, subscription)) {
            this.f20585c = subscription;
            this.f20583a.onSubscribe(this);
        }
    }

    @Override // org.reactivestreams.Subscription
    public final void request(long j) {
        this.f20585c.request(j);
    }
}
