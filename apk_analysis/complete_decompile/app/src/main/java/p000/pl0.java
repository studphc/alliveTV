package p000;

import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.functions.LongConsumer;
import io.reactivex.rxjava3.internal.subscriptions.EmptySubscription;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class pl0 implements FlowableSubscriber, Subscription {

    /* renamed from: a */
    public final Subscriber f25209a;

    /* renamed from: b */
    public final Consumer f25210b;

    /* renamed from: c */
    public final LongConsumer f25211c;

    /* renamed from: d */
    public final Action f25212d;

    /* renamed from: e */
    public Subscription f25213e;

    public pl0(Subscriber subscriber, Consumer consumer, LongConsumer longConsumer, Action action) {
        this.f25209a = subscriber;
        this.f25210b = consumer;
        this.f25212d = action;
        this.f25211c = longConsumer;
    }

    @Override // org.reactivestreams.Subscription
    public final void cancel() {
        Subscription subscription = this.f25213e;
        SubscriptionHelper subscriptionHelper = SubscriptionHelper.CANCELLED;
        if (subscription != subscriptionHelper) {
            this.f25213e = subscriptionHelper;
            try {
                this.f25212d.run();
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                RxJavaPlugins.onError(th);
            }
            subscription.cancel();
        }
    }

    @Override // org.reactivestreams.Subscriber
    public final void onComplete() {
        if (this.f25213e != SubscriptionHelper.CANCELLED) {
            this.f25209a.onComplete();
        }
    }

    @Override // org.reactivestreams.Subscriber
    public final void onError(Throwable th) {
        if (this.f25213e != SubscriptionHelper.CANCELLED) {
            this.f25209a.onError(th);
        } else {
            RxJavaPlugins.onError(th);
        }
    }

    @Override // org.reactivestreams.Subscriber
    public final void onNext(Object obj) {
        this.f25209a.onNext(obj);
    }

    @Override // io.reactivex.rxjava3.core.FlowableSubscriber, org.reactivestreams.Subscriber
    public final void onSubscribe(Subscription subscription) {
        Subscriber subscriber = this.f25209a;
        try {
            this.f25210b.accept(subscription);
            if (SubscriptionHelper.validate(this.f25213e, subscription)) {
                this.f25213e = subscription;
                subscriber.onSubscribe(this);
            }
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            subscription.cancel();
            this.f25213e = SubscriptionHelper.CANCELLED;
            EmptySubscription.error(th, subscriber);
        }
    }

    @Override // org.reactivestreams.Subscription
    public final void request(long j) {
        try {
            this.f25211c.accept(j);
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            RxJavaPlugins.onError(th);
        }
        this.f25213e.request(j);
    }
}
