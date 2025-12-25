package p000;

import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.BiConsumer;
import io.reactivex.rxjava3.internal.subscribers.DeferredScalarSubscriber;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class a22 extends DeferredScalarSubscriber {
    private static final long serialVersionUID = -4767392946044436228L;

    /* renamed from: a */
    public final BiConsumer f25a;

    /* renamed from: b */
    public Object f26b;

    /* renamed from: c */
    public boolean f27c;

    public a22(Subscriber subscriber, Object obj, BiConsumer biConsumer) {
        super(subscriber);
        this.f26b = obj;
        this.f25a = biConsumer;
    }

    @Override // io.reactivex.rxjava3.internal.subscribers.DeferredScalarSubscriber, io.reactivex.rxjava3.internal.subscriptions.DeferredScalarSubscription, org.reactivestreams.Subscription
    public final void cancel() {
        super.cancel();
        this.upstream.cancel();
    }

    @Override // io.reactivex.rxjava3.internal.subscribers.DeferredScalarSubscriber, org.reactivestreams.Subscriber
    public final void onComplete() {
        if (this.f27c) {
            return;
        }
        this.f27c = true;
        Object obj = this.f26b;
        this.f26b = null;
        complete(obj);
    }

    @Override // io.reactivex.rxjava3.internal.subscribers.DeferredScalarSubscriber, org.reactivestreams.Subscriber
    public final void onError(Throwable th) {
        if (this.f27c) {
            RxJavaPlugins.onError(th);
            return;
        }
        this.f27c = true;
        this.f26b = null;
        this.downstream.onError(th);
    }

    @Override // org.reactivestreams.Subscriber
    public final void onNext(Object obj) {
        if (this.f27c) {
            return;
        }
        try {
            this.f25a.accept(this.f26b, obj);
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            cancel();
            onError(th);
        }
    }

    @Override // io.reactivex.rxjava3.internal.subscribers.DeferredScalarSubscriber, io.reactivex.rxjava3.core.FlowableSubscriber, org.reactivestreams.Subscriber
    public final void onSubscribe(Subscription subscription) {
        if (SubscriptionHelper.validate(this.upstream, subscription)) {
            this.upstream = subscription;
            this.downstream.onSubscribe(this);
            subscription.request(Long.MAX_VALUE);
        }
    }
}
