package p000;

import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class po0 implements FlowableSubscriber, Subscription {

    /* renamed from: a */
    public final Subscriber f25238a;

    /* renamed from: b */
    public final no0 f25239b;

    /* renamed from: c */
    public Subscription f25240c;

    public po0(Subscriber subscriber, no0 no0Var) {
        this.f25238a = subscriber;
        this.f25239b = no0Var;
    }

    @Override // org.reactivestreams.Subscription
    public final void cancel() {
        this.f25240c.cancel();
        this.f25239b.dispose();
    }

    @Override // org.reactivestreams.Subscriber
    public final void onComplete() {
        this.f25238a.onComplete();
        this.f25239b.dispose();
    }

    @Override // org.reactivestreams.Subscriber
    public final void onError(Throwable th) {
        this.f25238a.onError(th);
        this.f25239b.dispose();
    }

    @Override // org.reactivestreams.Subscriber
    public final void onNext(Object obj) {
        this.f25238a.onNext(obj);
    }

    @Override // io.reactivex.rxjava3.core.FlowableSubscriber, org.reactivestreams.Subscriber
    public final void onSubscribe(Subscription subscription) {
        if (SubscriptionHelper.validate(this.f25240c, subscription)) {
            this.f25240c = subscription;
            this.f25238a.onSubscribe(this);
        }
    }

    @Override // org.reactivestreams.Subscription
    public final void request(long j) {
        this.f25240c.request(j);
    }
}
