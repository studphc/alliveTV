package p000;

import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.TimeUnit;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class bl0 implements FlowableSubscriber, Subscription {

    /* renamed from: a */
    public final Subscriber f8059a;

    /* renamed from: b */
    public final long f8060b;

    /* renamed from: c */
    public final TimeUnit f8061c;

    /* renamed from: d */
    public final Scheduler.Worker f8062d;

    /* renamed from: e */
    public final boolean f8063e;

    /* renamed from: f */
    public Subscription f8064f;

    public bl0(Subscriber subscriber, long j, TimeUnit timeUnit, Scheduler.Worker worker, boolean z) {
        this.f8059a = subscriber;
        this.f8060b = j;
        this.f8061c = timeUnit;
        this.f8062d = worker;
        this.f8063e = z;
    }

    @Override // org.reactivestreams.Subscription
    public final void cancel() {
        this.f8064f.cancel();
        this.f8062d.dispose();
    }

    @Override // org.reactivestreams.Subscriber
    public final void onComplete() {
        this.f8062d.schedule(new zk0(this), this.f8060b, this.f8061c);
    }

    @Override // org.reactivestreams.Subscriber
    public final void onError(Throwable th) {
        long j;
        al0 al0Var = new al0(this, th);
        if (this.f8063e) {
            j = this.f8060b;
        } else {
            j = 0;
        }
        this.f8062d.schedule(al0Var, j, this.f8061c);
    }

    @Override // org.reactivestreams.Subscriber
    public final void onNext(Object obj) {
        this.f8062d.schedule(new xy1(7, this, obj), this.f8060b, this.f8061c);
    }

    @Override // io.reactivex.rxjava3.core.FlowableSubscriber, org.reactivestreams.Subscriber
    public final void onSubscribe(Subscription subscription) {
        if (SubscriptionHelper.validate(this.f8064f, subscription)) {
            this.f8064f = subscription;
            this.f8059a.onSubscribe(this);
        }
    }

    @Override // org.reactivestreams.Subscription
    public final void request(long j) {
        this.f8064f.request(j);
    }
}
