package p000;

import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Predicate;
import io.reactivex.rxjava3.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class oi0 extends DeferredScalarSubscription implements FlowableSubscriber {
    private static final long serialVersionUID = -3521127104134758517L;

    /* renamed from: a */
    public final Predicate f23811a;

    /* renamed from: b */
    public Subscription f23812b;

    /* renamed from: c */
    public boolean f23813c;

    public oi0(Subscriber subscriber, Predicate predicate) {
        super(subscriber);
        this.f23811a = predicate;
    }

    @Override // io.reactivex.rxjava3.internal.subscriptions.DeferredScalarSubscription, org.reactivestreams.Subscription
    public final void cancel() {
        super.cancel();
        this.f23812b.cancel();
    }

    @Override // org.reactivestreams.Subscriber
    public final void onComplete() {
        if (this.f23813c) {
            return;
        }
        this.f23813c = true;
        complete(Boolean.TRUE);
    }

    @Override // org.reactivestreams.Subscriber
    public final void onError(Throwable th) {
        if (this.f23813c) {
            RxJavaPlugins.onError(th);
        } else {
            this.f23813c = true;
            this.downstream.onError(th);
        }
    }

    @Override // org.reactivestreams.Subscriber
    public final void onNext(Object obj) {
        if (this.f23813c) {
            return;
        }
        try {
            if (!this.f23811a.test(obj)) {
                this.f23813c = true;
                this.f23812b.cancel();
                complete(Boolean.FALSE);
            }
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            this.f23812b.cancel();
            onError(th);
        }
    }

    @Override // io.reactivex.rxjava3.core.FlowableSubscriber, org.reactivestreams.Subscriber
    public final void onSubscribe(Subscription subscription) {
        if (SubscriptionHelper.validate(this.f23812b, subscription)) {
            this.f23812b = subscription;
            this.downstream.onSubscribe(this);
            subscription.request(Long.MAX_VALUE);
        }
    }
}
