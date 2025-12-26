package p000;

import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class ri0 extends AtomicReference implements FlowableSubscriber, Subscription {
    private static final long serialVersionUID = -1185974347409665484L;

    /* renamed from: a */
    public final qi0 f25974a;

    /* renamed from: b */
    public final int f25975b;

    /* renamed from: c */
    public final Subscriber f25976c;

    /* renamed from: d */
    public boolean f25977d;

    /* renamed from: e */
    public final AtomicLong f25978e = new AtomicLong();

    public ri0(qi0 qi0Var, int i, Subscriber subscriber) {
        this.f25974a = qi0Var;
        this.f25975b = i;
        this.f25976c = subscriber;
    }

    @Override // org.reactivestreams.Subscription
    public final void cancel() {
        SubscriptionHelper.cancel(this);
    }

    @Override // org.reactivestreams.Subscriber
    public final void onComplete() {
        boolean z = this.f25977d;
        Subscriber subscriber = this.f25976c;
        if (z) {
            subscriber.onComplete();
        } else if (this.f25974a.m7035a(this.f25975b)) {
            this.f25977d = true;
            subscriber.onComplete();
        } else {
            ((Subscription) get()).cancel();
        }
    }

    @Override // org.reactivestreams.Subscriber
    public final void onError(Throwable th) {
        boolean z = this.f25977d;
        Subscriber subscriber = this.f25976c;
        if (z) {
            subscriber.onError(th);
        } else if (this.f25974a.m7035a(this.f25975b)) {
            this.f25977d = true;
            subscriber.onError(th);
        } else {
            ((Subscription) get()).cancel();
            RxJavaPlugins.onError(th);
        }
    }

    @Override // org.reactivestreams.Subscriber
    public final void onNext(Object obj) {
        boolean z = this.f25977d;
        Subscriber subscriber = this.f25976c;
        if (z) {
            subscriber.onNext(obj);
        } else if (this.f25974a.m7035a(this.f25975b)) {
            this.f25977d = true;
            subscriber.onNext(obj);
        } else {
            ((Subscription) get()).cancel();
        }
    }

    @Override // io.reactivex.rxjava3.core.FlowableSubscriber, org.reactivestreams.Subscriber
    public final void onSubscribe(Subscription subscription) {
        SubscriptionHelper.deferredSetOnce(this, this.f25978e, subscription);
    }

    @Override // org.reactivestreams.Subscription
    public final void request(long j) {
        SubscriptionHelper.deferredRequest(this, this.f25978e, j);
    }
}
