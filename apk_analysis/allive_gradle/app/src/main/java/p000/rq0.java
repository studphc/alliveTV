package p000;

import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionArbiter;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class rq0 implements FlowableSubscriber {

    /* renamed from: a */
    public final Subscriber f26107a;

    /* renamed from: b */
    public final Publisher f26108b;

    /* renamed from: d */
    public boolean f26110d = true;

    /* renamed from: c */
    public final SubscriptionArbiter f26109c = new SubscriptionArbiter(false);

    public rq0(Publisher publisher, Subscriber subscriber) {
        this.f26107a = subscriber;
        this.f26108b = publisher;
    }

    @Override // org.reactivestreams.Subscriber
    public final void onComplete() {
        if (this.f26110d) {
            this.f26110d = false;
            this.f26108b.subscribe(this);
        } else {
            this.f26107a.onComplete();
        }
    }

    @Override // org.reactivestreams.Subscriber
    public final void onError(Throwable th) {
        this.f26107a.onError(th);
    }

    @Override // org.reactivestreams.Subscriber
    public final void onNext(Object obj) {
        if (this.f26110d) {
            this.f26110d = false;
        }
        this.f26107a.onNext(obj);
    }

    @Override // io.reactivex.rxjava3.core.FlowableSubscriber, org.reactivestreams.Subscriber
    public final void onSubscribe(Subscription subscription) {
        this.f26109c.setSubscription(subscription);
    }
}
