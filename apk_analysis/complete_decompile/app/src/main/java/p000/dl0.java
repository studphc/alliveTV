package p000;

import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class dl0 extends AtomicLong implements FlowableSubscriber, Subscription {
    private static final long serialVersionUID = 2259811067697317255L;

    /* renamed from: a */
    public final Subscriber f16404a;

    /* renamed from: b */
    public final Publisher f16405b;

    /* renamed from: c */
    public final cl0 f16406c = new cl0(this);

    /* renamed from: d */
    public final AtomicReference f16407d = new AtomicReference();

    public dl0(Publisher publisher, Subscriber subscriber) {
        this.f16404a = subscriber;
        this.f16405b = publisher;
    }

    @Override // org.reactivestreams.Subscription
    public final void cancel() {
        SubscriptionHelper.cancel(this.f16406c);
        SubscriptionHelper.cancel(this.f16407d);
    }

    @Override // org.reactivestreams.Subscriber
    public final void onComplete() {
        this.f16404a.onComplete();
    }

    @Override // org.reactivestreams.Subscriber
    public final void onError(Throwable th) {
        this.f16404a.onError(th);
    }

    @Override // org.reactivestreams.Subscriber
    public final void onNext(Object obj) {
        this.f16404a.onNext(obj);
    }

    @Override // io.reactivex.rxjava3.core.FlowableSubscriber, org.reactivestreams.Subscriber
    public final void onSubscribe(Subscription subscription) {
        SubscriptionHelper.deferredSetOnce(this.f16407d, this, subscription);
    }

    @Override // org.reactivestreams.Subscription
    public final void request(long j) {
        if (SubscriptionHelper.validate(j)) {
            SubscriptionHelper.deferredRequest(this.f16407d, this, j);
        }
    }
}
