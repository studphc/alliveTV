package p000;

import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.exceptions.MissingBackpressureException;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class fo0 extends AtomicLong implements FlowableSubscriber, Subscription {
    private static final long serialVersionUID = -3176480756392482682L;

    /* renamed from: a */
    public final Subscriber f17351a;

    /* renamed from: b */
    public Subscription f17352b;

    /* renamed from: c */
    public boolean f17353c;

    public fo0(Subscriber subscriber) {
        this.f17351a = subscriber;
    }

    @Override // org.reactivestreams.Subscription
    public final void cancel() {
        this.f17352b.cancel();
    }

    @Override // org.reactivestreams.Subscriber
    public final void onComplete() {
        if (this.f17353c) {
            return;
        }
        this.f17353c = true;
        this.f17351a.onComplete();
    }

    @Override // org.reactivestreams.Subscriber
    public final void onError(Throwable th) {
        if (this.f17353c) {
            RxJavaPlugins.onError(th);
        } else {
            this.f17353c = true;
            this.f17351a.onError(th);
        }
    }

    @Override // org.reactivestreams.Subscriber
    public final void onNext(Object obj) {
        if (this.f17353c) {
            return;
        }
        if (get() != 0) {
            this.f17351a.onNext(obj);
            BackpressureHelper.produced(this, 1L);
        } else {
            this.f17352b.cancel();
            onError(new MissingBackpressureException("could not emit value due to lack of requests"));
        }
    }

    @Override // io.reactivex.rxjava3.core.FlowableSubscriber, org.reactivestreams.Subscriber
    public final void onSubscribe(Subscription subscription) {
        if (SubscriptionHelper.validate(this.f17352b, subscription)) {
            this.f17352b = subscription;
            this.f17351a.onSubscribe(this);
            subscription.request(Long.MAX_VALUE);
        }
    }

    @Override // org.reactivestreams.Subscription
    public final void request(long j) {
        if (SubscriptionHelper.validate(j)) {
            BackpressureHelper.add(this, j);
        }
    }
}
