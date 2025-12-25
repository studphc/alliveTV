package p000;

import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class cp0 extends AtomicInteger implements FlowableSubscriber, Subscription {
    private static final long serialVersionUID = 2827772011130406689L;

    /* renamed from: a */
    public final Publisher f16042a;

    /* renamed from: b */
    public final AtomicReference f16043b = new AtomicReference();

    /* renamed from: c */
    public final AtomicLong f16044c = new AtomicLong();

    /* renamed from: d */
    public dp0 f16045d;

    public cp0(Publisher publisher) {
        this.f16042a = publisher;
    }

    @Override // org.reactivestreams.Subscription
    public final void cancel() {
        SubscriptionHelper.cancel(this.f16043b);
    }

    @Override // org.reactivestreams.Subscriber
    public final void onComplete() {
        this.f16045d.cancel();
        this.f16045d.f16464h.onComplete();
    }

    @Override // org.reactivestreams.Subscriber
    public final void onError(Throwable th) {
        this.f16045d.cancel();
        this.f16045d.f16464h.onError(th);
    }

    @Override // org.reactivestreams.Subscriber
    public final void onNext(Object obj) {
        if (getAndIncrement() != 0) {
            return;
        }
        while (this.f16043b.get() != SubscriptionHelper.CANCELLED) {
            this.f16042a.subscribe(this.f16045d);
            if (decrementAndGet() == 0) {
                return;
            }
        }
    }

    @Override // io.reactivex.rxjava3.core.FlowableSubscriber, org.reactivestreams.Subscriber
    public final void onSubscribe(Subscription subscription) {
        SubscriptionHelper.deferredSetOnce(this.f16043b, this.f16044c, subscription);
    }

    @Override // org.reactivestreams.Subscription
    public final void request(long j) {
        SubscriptionHelper.deferredRequest(this.f16043b, this.f16044c, j);
    }
}
