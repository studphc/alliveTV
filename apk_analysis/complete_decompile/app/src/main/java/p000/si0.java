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
public final class si0 extends DeferredScalarSubscription implements FlowableSubscriber {
    private static final long serialVersionUID = -2311252482644620661L;

    /* renamed from: a */
    public final Predicate f26437a;

    /* renamed from: b */
    public Subscription f26438b;

    /* renamed from: c */
    public boolean f26439c;

    public si0(Subscriber subscriber, Predicate predicate) {
        super(subscriber);
        this.f26437a = predicate;
    }

    @Override // io.reactivex.rxjava3.internal.subscriptions.DeferredScalarSubscription, org.reactivestreams.Subscription
    public final void cancel() {
        super.cancel();
        this.f26438b.cancel();
    }

    @Override // org.reactivestreams.Subscriber
    public final void onComplete() {
        if (!this.f26439c) {
            this.f26439c = true;
            complete(Boolean.FALSE);
        }
    }

    @Override // org.reactivestreams.Subscriber
    public final void onError(Throwable th) {
        if (this.f26439c) {
            RxJavaPlugins.onError(th);
        } else {
            this.f26439c = true;
            this.downstream.onError(th);
        }
    }

    @Override // org.reactivestreams.Subscriber
    public final void onNext(Object obj) {
        if (this.f26439c) {
            return;
        }
        try {
            if (this.f26437a.test(obj)) {
                this.f26439c = true;
                this.f26438b.cancel();
                complete(Boolean.TRUE);
            }
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            this.f26438b.cancel();
            onError(th);
        }
    }

    @Override // io.reactivex.rxjava3.core.FlowableSubscriber, org.reactivestreams.Subscriber
    public final void onSubscribe(Subscription subscription) {
        if (SubscriptionHelper.validate(this.f26438b, subscription)) {
            this.f26438b = subscription;
            this.downstream.onSubscribe(this);
            subscription.request(Long.MAX_VALUE);
        }
    }
}
