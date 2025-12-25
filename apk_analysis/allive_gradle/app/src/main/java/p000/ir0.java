package p000;

import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.schedulers.Timed;
import java.util.concurrent.TimeUnit;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class ir0 implements FlowableSubscriber, Subscription {

    /* renamed from: a */
    public final Subscriber f20236a;

    /* renamed from: b */
    public final TimeUnit f20237b;

    /* renamed from: c */
    public final Scheduler f20238c;

    /* renamed from: d */
    public Subscription f20239d;

    /* renamed from: e */
    public long f20240e;

    public ir0(Subscriber subscriber, TimeUnit timeUnit, Scheduler scheduler) {
        this.f20236a = subscriber;
        this.f20238c = scheduler;
        this.f20237b = timeUnit;
    }

    @Override // org.reactivestreams.Subscription
    public final void cancel() {
        this.f20239d.cancel();
    }

    @Override // org.reactivestreams.Subscriber
    public final void onComplete() {
        this.f20236a.onComplete();
    }

    @Override // org.reactivestreams.Subscriber
    public final void onError(Throwable th) {
        this.f20236a.onError(th);
    }

    @Override // org.reactivestreams.Subscriber
    public final void onNext(Object obj) {
        Scheduler scheduler = this.f20238c;
        TimeUnit timeUnit = this.f20237b;
        long now = scheduler.now(timeUnit);
        long j = this.f20240e;
        this.f20240e = now;
        this.f20236a.onNext(new Timed(obj, now - j, timeUnit));
    }

    @Override // io.reactivex.rxjava3.core.FlowableSubscriber, org.reactivestreams.Subscriber
    public final void onSubscribe(Subscription subscription) {
        if (SubscriptionHelper.validate(this.f20239d, subscription)) {
            this.f20240e = this.f20238c.now(this.f20237b);
            this.f20239d = subscription;
            this.f20236a.onSubscribe(this);
        }
    }

    @Override // org.reactivestreams.Subscription
    public final void request(long j) {
        this.f20239d.request(j);
    }
}
