package p000;

import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import io.reactivex.rxjava3.internal.util.HalfSerializer;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class fr0 extends AtomicInteger implements FlowableSubscriber, Subscription {
    private static final long serialVersionUID = -4945480365982832967L;

    /* renamed from: a */
    public final Subscriber f17369a;

    /* renamed from: b */
    public final AtomicLong f17370b = new AtomicLong();

    /* renamed from: c */
    public final AtomicReference f17371c = new AtomicReference();

    /* renamed from: e */
    public final er0 f17373e = new er0(this);

    /* renamed from: d */
    public final AtomicThrowable f17372d = new AtomicThrowable();

    public fr0(Subscriber subscriber) {
        this.f17369a = subscriber;
    }

    @Override // org.reactivestreams.Subscription
    public final void cancel() {
        SubscriptionHelper.cancel(this.f17371c);
        SubscriptionHelper.cancel(this.f17373e);
    }

    @Override // org.reactivestreams.Subscriber
    public final void onComplete() {
        SubscriptionHelper.cancel(this.f17373e);
        HalfSerializer.onComplete((Subscriber<?>) this.f17369a, this, this.f17372d);
    }

    @Override // org.reactivestreams.Subscriber
    public final void onError(Throwable th) {
        SubscriptionHelper.cancel(this.f17373e);
        HalfSerializer.onError((Subscriber<?>) this.f17369a, th, this, this.f17372d);
    }

    @Override // org.reactivestreams.Subscriber
    public final void onNext(Object obj) {
        HalfSerializer.onNext((Subscriber<? super Object>) this.f17369a, obj, this, this.f17372d);
    }

    @Override // io.reactivex.rxjava3.core.FlowableSubscriber, org.reactivestreams.Subscriber
    public final void onSubscribe(Subscription subscription) {
        SubscriptionHelper.deferredSetOnce(this.f17371c, this.f17370b, subscription);
    }

    @Override // org.reactivestreams.Subscription
    public final void request(long j) {
        SubscriptionHelper.deferredRequest(this.f17371c, this.f17370b, j);
    }
}
