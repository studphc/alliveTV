package p000;

import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.BiConsumer;
import io.reactivex.rxjava3.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class hj0 extends DeferredScalarSubscription implements FlowableSubscriber {
    private static final long serialVersionUID = -3589550218733891694L;

    /* renamed from: a */
    public final BiConsumer f18072a;

    /* renamed from: b */
    public final Object f18073b;

    /* renamed from: c */
    public Subscription f18074c;

    /* renamed from: d */
    public boolean f18075d;

    public hj0(Subscriber subscriber, Object obj, BiConsumer biConsumer) {
        super(subscriber);
        this.f18072a = biConsumer;
        this.f18073b = obj;
    }

    @Override // io.reactivex.rxjava3.internal.subscriptions.DeferredScalarSubscription, org.reactivestreams.Subscription
    public final void cancel() {
        super.cancel();
        this.f18074c.cancel();
    }

    @Override // org.reactivestreams.Subscriber
    public final void onComplete() {
        if (this.f18075d) {
            return;
        }
        this.f18075d = true;
        complete(this.f18073b);
    }

    @Override // org.reactivestreams.Subscriber
    public final void onError(Throwable th) {
        if (this.f18075d) {
            RxJavaPlugins.onError(th);
        } else {
            this.f18075d = true;
            this.downstream.onError(th);
        }
    }

    @Override // org.reactivestreams.Subscriber
    public final void onNext(Object obj) {
        if (this.f18075d) {
            return;
        }
        try {
            this.f18072a.accept(this.f18073b, obj);
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            this.f18074c.cancel();
            onError(th);
        }
    }

    @Override // io.reactivex.rxjava3.core.FlowableSubscriber, org.reactivestreams.Subscriber
    public final void onSubscribe(Subscription subscription) {
        if (SubscriptionHelper.validate(this.f18074c, subscription)) {
            this.f18074c = subscription;
            this.downstream.onSubscribe(this);
            subscription.request(Long.MAX_VALUE);
        }
    }
}
