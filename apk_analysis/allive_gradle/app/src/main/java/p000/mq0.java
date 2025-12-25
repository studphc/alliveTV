package p000;

import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import io.reactivex.rxjava3.internal.util.HalfSerializer;
import io.reactivex.rxjava3.operators.ConditionalSubscriber;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class mq0 extends AtomicInteger implements ConditionalSubscriber, Subscription {
    private static final long serialVersionUID = -6270983465606289181L;

    /* renamed from: a */
    public final Subscriber f23052a;

    /* renamed from: b */
    public final AtomicReference f23053b = new AtomicReference();

    /* renamed from: c */
    public final AtomicLong f23054c = new AtomicLong();

    /* renamed from: d */
    public final lq0 f23055d = new lq0(this);

    /* renamed from: e */
    public final AtomicThrowable f23056e = new AtomicThrowable();

    /* renamed from: f */
    public volatile boolean f23057f;

    public mq0(Subscriber subscriber) {
        this.f23052a = subscriber;
    }

    @Override // org.reactivestreams.Subscription
    public final void cancel() {
        SubscriptionHelper.cancel(this.f23053b);
        SubscriptionHelper.cancel(this.f23055d);
    }

    @Override // org.reactivestreams.Subscriber
    public final void onComplete() {
        SubscriptionHelper.cancel(this.f23055d);
        HalfSerializer.onComplete((Subscriber<?>) this.f23052a, this, this.f23056e);
    }

    @Override // org.reactivestreams.Subscriber
    public final void onError(Throwable th) {
        SubscriptionHelper.cancel(this.f23055d);
        HalfSerializer.onError((Subscriber<?>) this.f23052a, th, this, this.f23056e);
    }

    @Override // org.reactivestreams.Subscriber
    public final void onNext(Object obj) {
        if (!tryOnNext(obj)) {
            ((Subscription) this.f23053b.get()).request(1L);
        }
    }

    @Override // io.reactivex.rxjava3.core.FlowableSubscriber, org.reactivestreams.Subscriber
    public final void onSubscribe(Subscription subscription) {
        SubscriptionHelper.deferredSetOnce(this.f23053b, this.f23054c, subscription);
    }

    @Override // org.reactivestreams.Subscription
    public final void request(long j) {
        SubscriptionHelper.deferredRequest(this.f23053b, this.f23054c, j);
    }

    @Override // io.reactivex.rxjava3.operators.ConditionalSubscriber
    public final boolean tryOnNext(Object obj) {
        if (this.f23057f) {
            HalfSerializer.onNext((Subscriber<? super Object>) this.f23052a, obj, this, this.f23056e);
            return true;
        }
        return false;
    }
}
