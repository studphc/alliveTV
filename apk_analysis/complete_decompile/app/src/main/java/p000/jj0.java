package p000;

import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Objects;
import java.util.function.BiConsumer;
import java.util.function.Function;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class jj0 extends DeferredScalarSubscription implements FlowableSubscriber {
    private static final long serialVersionUID = -229544830565448758L;

    /* renamed from: a */
    public final BiConsumer f20517a;

    /* renamed from: b */
    public final Function f20518b;

    /* renamed from: c */
    public Subscription f20519c;

    /* renamed from: d */
    public boolean f20520d;

    /* renamed from: e */
    public Object f20521e;

    public jj0(Subscriber subscriber, Object obj, BiConsumer biConsumer, Function function) {
        super(subscriber);
        this.f20521e = obj;
        this.f20517a = biConsumer;
        this.f20518b = function;
    }

    @Override // io.reactivex.rxjava3.internal.subscriptions.DeferredScalarSubscription, org.reactivestreams.Subscription
    public final void cancel() {
        super.cancel();
        this.f20519c.cancel();
    }

    @Override // org.reactivestreams.Subscriber
    public final void onComplete() {
        Object apply;
        if (this.f20520d) {
            return;
        }
        this.f20520d = true;
        this.f20519c = SubscriptionHelper.CANCELLED;
        Object obj = this.f20521e;
        this.f20521e = null;
        try {
            apply = this.f20518b.apply(obj);
            Objects.requireNonNull(apply, "The finisher returned a null value");
            complete(apply);
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            this.downstream.onError(th);
        }
    }

    @Override // org.reactivestreams.Subscriber
    public final void onError(Throwable th) {
        if (this.f20520d) {
            RxJavaPlugins.onError(th);
            return;
        }
        this.f20520d = true;
        this.f20519c = SubscriptionHelper.CANCELLED;
        this.f20521e = null;
        this.downstream.onError(th);
    }

    @Override // org.reactivestreams.Subscriber
    public final void onNext(Object obj) {
        if (!this.f20520d) {
            try {
                this.f20517a.accept(this.f20521e, obj);
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                this.f20519c.cancel();
                onError(th);
            }
        }
    }

    @Override // io.reactivex.rxjava3.core.FlowableSubscriber, org.reactivestreams.Subscriber
    public final void onSubscribe(Subscription subscription) {
        if (SubscriptionHelper.validate(this.f20519c, subscription)) {
            this.f20519c = subscription;
            this.downstream.onSubscribe(this);
            subscription.request(Long.MAX_VALUE);
        }
    }
}
