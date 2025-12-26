package p000;

import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.internal.subscriptions.EmptySubscription;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class ar0 extends AtomicLong implements FlowableSubscriber, Subscription {
    private static final long serialVersionUID = 2288246011222124525L;

    /* renamed from: a */
    public final Subscriber f7721a;

    /* renamed from: b */
    public long f7722b;

    /* renamed from: c */
    public Subscription f7723c;

    public ar0(Subscriber subscriber, long j) {
        this.f7721a = subscriber;
        this.f7722b = j;
        lazySet(j);
    }

    @Override // org.reactivestreams.Subscription
    public final void cancel() {
        this.f7723c.cancel();
    }

    @Override // org.reactivestreams.Subscriber
    public final void onComplete() {
        if (this.f7722b > 0) {
            this.f7722b = 0L;
            this.f7721a.onComplete();
        }
    }

    @Override // org.reactivestreams.Subscriber
    public final void onError(Throwable th) {
        if (this.f7722b > 0) {
            this.f7722b = 0L;
            this.f7721a.onError(th);
        } else {
            RxJavaPlugins.onError(th);
        }
    }

    @Override // org.reactivestreams.Subscriber
    public final void onNext(Object obj) {
        long j = this.f7722b;
        if (j > 0) {
            long j2 = j - 1;
            this.f7722b = j2;
            Subscriber subscriber = this.f7721a;
            subscriber.onNext(obj);
            if (j2 == 0) {
                this.f7723c.cancel();
                subscriber.onComplete();
            }
        }
    }

    @Override // io.reactivex.rxjava3.core.FlowableSubscriber, org.reactivestreams.Subscriber
    public final void onSubscribe(Subscription subscription) {
        if (SubscriptionHelper.validate(this.f7723c, subscription)) {
            long j = this.f7722b;
            Subscriber subscriber = this.f7721a;
            if (j == 0) {
                subscription.cancel();
                EmptySubscription.complete(subscriber);
            } else {
                this.f7723c = subscription;
                subscriber.onSubscribe(this);
            }
        }
    }

    @Override // org.reactivestreams.Subscription
    public final void request(long j) {
        long j2;
        long min;
        if (!SubscriptionHelper.validate(j)) {
            return;
        }
        do {
            j2 = get();
            if (j2 != 0) {
                min = Math.min(j2, j);
            } else {
                return;
            }
        } while (!compareAndSet(j2, j2 - min));
        this.f7723c.request(min);
    }
}
