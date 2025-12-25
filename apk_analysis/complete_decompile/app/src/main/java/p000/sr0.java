package p000;

import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import java.util.Collection;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class sr0 extends DeferredScalarSubscription implements FlowableSubscriber, Subscription {
    private static final long serialVersionUID = -8134157938864266736L;

    /* renamed from: a */
    public Subscription f26540a;

    /* JADX WARN: Multi-variable type inference failed */
    public sr0(Subscriber subscriber, Collection collection) {
        super(subscriber);
        this.value = collection;
    }

    @Override // io.reactivex.rxjava3.internal.subscriptions.DeferredScalarSubscription, org.reactivestreams.Subscription
    public final void cancel() {
        super.cancel();
        this.f26540a.cancel();
    }

    @Override // org.reactivestreams.Subscriber
    public final void onComplete() {
        complete(this.value);
    }

    @Override // org.reactivestreams.Subscriber
    public final void onError(Throwable th) {
        this.value = null;
        this.downstream.onError(th);
    }

    @Override // org.reactivestreams.Subscriber
    public final void onNext(Object obj) {
        Collection collection = (Collection) this.value;
        if (collection != null) {
            collection.add(obj);
        }
    }

    @Override // io.reactivex.rxjava3.core.FlowableSubscriber, org.reactivestreams.Subscriber
    public final void onSubscribe(Subscription subscription) {
        if (SubscriptionHelper.validate(this.f26540a, subscription)) {
            this.f26540a = subscription;
            this.downstream.onSubscribe(this);
            subscription.request(Long.MAX_VALUE);
        }
    }
}
