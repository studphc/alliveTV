package p000;

import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.BiFunction;
import io.reactivex.rxjava3.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Objects;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class wo0 extends DeferredScalarSubscription implements FlowableSubscriber {
    private static final long serialVersionUID = -4663883003264602070L;

    /* renamed from: a */
    public final BiFunction f28257a;

    /* renamed from: b */
    public Subscription f28258b;

    public wo0(Subscriber subscriber, BiFunction biFunction) {
        super(subscriber);
        this.f28257a = biFunction;
    }

    @Override // io.reactivex.rxjava3.internal.subscriptions.DeferredScalarSubscription, org.reactivestreams.Subscription
    public final void cancel() {
        super.cancel();
        this.f28258b.cancel();
        this.f28258b = SubscriptionHelper.CANCELLED;
    }

    @Override // org.reactivestreams.Subscriber
    public final void onComplete() {
        Subscription subscription = this.f28258b;
        SubscriptionHelper subscriptionHelper = SubscriptionHelper.CANCELLED;
        if (subscription == subscriptionHelper) {
            return;
        }
        this.f28258b = subscriptionHelper;
        T t = this.value;
        if (t != 0) {
            complete(t);
        } else {
            this.downstream.onComplete();
        }
    }

    @Override // org.reactivestreams.Subscriber
    public final void onError(Throwable th) {
        Subscription subscription = this.f28258b;
        SubscriptionHelper subscriptionHelper = SubscriptionHelper.CANCELLED;
        if (subscription == subscriptionHelper) {
            RxJavaPlugins.onError(th);
        } else {
            this.f28258b = subscriptionHelper;
            this.downstream.onError(th);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v2, types: [T, java.lang.Object] */
    @Override // org.reactivestreams.Subscriber
    public final void onNext(Object obj) {
        if (this.f28258b == SubscriptionHelper.CANCELLED) {
            return;
        }
        T t = this.value;
        if (t == 0) {
            this.value = obj;
            return;
        }
        try {
            ?? apply = this.f28257a.apply(t, obj);
            Objects.requireNonNull(apply, "The reducer returned a null value");
            this.value = apply;
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            this.f28258b.cancel();
            onError(th);
        }
    }

    @Override // io.reactivex.rxjava3.core.FlowableSubscriber, org.reactivestreams.Subscriber
    public final void onSubscribe(Subscription subscription) {
        if (SubscriptionHelper.validate(this.f28258b, subscription)) {
            this.f28258b = subscription;
            this.downstream.onSubscribe(this);
            subscription.request(Long.MAX_VALUE);
        }
    }
}
