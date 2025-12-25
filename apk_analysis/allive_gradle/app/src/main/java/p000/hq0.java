package p000;

import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.NoSuchElementException;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class hq0 extends DeferredScalarSubscription implements FlowableSubscriber {
    private static final long serialVersionUID = -5526049321428043809L;

    /* renamed from: a */
    public final Object f18129a;

    /* renamed from: b */
    public final boolean f18130b;

    /* renamed from: c */
    public Subscription f18131c;

    /* renamed from: d */
    public boolean f18132d;

    public hq0(Subscriber subscriber, Object obj, boolean z) {
        super(subscriber);
        this.f18129a = obj;
        this.f18130b = z;
    }

    @Override // io.reactivex.rxjava3.internal.subscriptions.DeferredScalarSubscription, org.reactivestreams.Subscription
    public final void cancel() {
        super.cancel();
        this.f18131c.cancel();
    }

    @Override // org.reactivestreams.Subscriber
    public final void onComplete() {
        if (this.f18132d) {
            return;
        }
        this.f18132d = true;
        Object obj = this.value;
        this.value = null;
        if (obj == null) {
            obj = this.f18129a;
        }
        if (obj == null) {
            if (this.f18130b) {
                this.downstream.onError(new NoSuchElementException());
                return;
            } else {
                this.downstream.onComplete();
                return;
            }
        }
        complete(obj);
    }

    @Override // org.reactivestreams.Subscriber
    public final void onError(Throwable th) {
        if (this.f18132d) {
            RxJavaPlugins.onError(th);
        } else {
            this.f18132d = true;
            this.downstream.onError(th);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.reactivestreams.Subscriber
    public final void onNext(Object obj) {
        if (this.f18132d) {
            return;
        }
        if (this.value != 0) {
            this.f18132d = true;
            this.f18131c.cancel();
            this.downstream.onError(new IllegalArgumentException("Sequence contains more than one element!"));
            return;
        }
        this.value = obj;
    }

    @Override // io.reactivex.rxjava3.core.FlowableSubscriber, org.reactivestreams.Subscriber
    public final void onSubscribe(Subscription subscription) {
        if (SubscriptionHelper.validate(this.f18131c, subscription)) {
            this.f18131c = subscription;
            this.downstream.onSubscribe(this);
            subscription.request(Long.MAX_VALUE);
        }
    }
}
