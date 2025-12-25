package p000;

import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.BiFunction;
import io.reactivex.rxjava3.internal.subscribers.DeferredScalarSubscriber;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Objects;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class u22 extends DeferredScalarSubscriber {
    private static final long serialVersionUID = 8200530050639449080L;

    /* renamed from: a */
    public final BiFunction f27075a;

    /* renamed from: b */
    public Object f27076b;

    /* renamed from: c */
    public boolean f27077c;

    public u22(Subscriber subscriber, Object obj, BiFunction biFunction) {
        super(subscriber);
        this.f27076b = obj;
        this.f27075a = biFunction;
    }

    @Override // io.reactivex.rxjava3.internal.subscribers.DeferredScalarSubscriber, io.reactivex.rxjava3.internal.subscriptions.DeferredScalarSubscription, org.reactivestreams.Subscription
    public final void cancel() {
        super.cancel();
        this.upstream.cancel();
    }

    @Override // io.reactivex.rxjava3.internal.subscribers.DeferredScalarSubscriber, org.reactivestreams.Subscriber
    public final void onComplete() {
        if (!this.f27077c) {
            this.f27077c = true;
            Object obj = this.f27076b;
            this.f27076b = null;
            complete(obj);
        }
    }

    @Override // io.reactivex.rxjava3.internal.subscribers.DeferredScalarSubscriber, org.reactivestreams.Subscriber
    public final void onError(Throwable th) {
        if (this.f27077c) {
            RxJavaPlugins.onError(th);
            return;
        }
        this.f27077c = true;
        this.f27076b = null;
        this.downstream.onError(th);
    }

    @Override // org.reactivestreams.Subscriber
    public final void onNext(Object obj) {
        if (!this.f27077c) {
            try {
                Object apply = this.f27075a.apply(this.f27076b, obj);
                Objects.requireNonNull(apply, "The reducer returned a null value");
                this.f27076b = apply;
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                cancel();
                onError(th);
            }
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
