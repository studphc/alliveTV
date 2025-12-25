package p000;

import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.EmptyComponent;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class fl0 implements FlowableSubscriber, Subscription {

    /* renamed from: a */
    public final /* synthetic */ int f17312a = 0;

    /* renamed from: b */
    public Subscriber f17313b;

    /* renamed from: c */
    public Subscription f17314c;

    public /* synthetic */ fl0() {
    }

    @Override // org.reactivestreams.Subscription
    public final void cancel() {
        switch (this.f17312a) {
            case 0:
                Subscription subscription = this.f17314c;
                this.f17314c = EmptyComponent.INSTANCE;
                this.f17313b = EmptyComponent.asSubscriber();
                subscription.cancel();
                return;
            default:
                this.f17314c.cancel();
                return;
        }
    }

    @Override // org.reactivestreams.Subscriber
    public final void onComplete() {
        switch (this.f17312a) {
            case 0:
                Subscriber subscriber = this.f17313b;
                this.f17314c = EmptyComponent.INSTANCE;
                this.f17313b = EmptyComponent.asSubscriber();
                subscriber.onComplete();
                return;
            default:
                this.f17313b.onComplete();
                return;
        }
    }

    @Override // org.reactivestreams.Subscriber
    public final void onError(Throwable th) {
        switch (this.f17312a) {
            case 0:
                Subscriber subscriber = this.f17313b;
                this.f17314c = EmptyComponent.INSTANCE;
                this.f17313b = EmptyComponent.asSubscriber();
                subscriber.onError(th);
                return;
            default:
                this.f17313b.onError(th);
                return;
        }
    }

    @Override // org.reactivestreams.Subscriber
    public final void onNext(Object obj) {
        switch (this.f17312a) {
            case 0:
                this.f17313b.onNext(obj);
                return;
            default:
                this.f17313b.onNext(obj);
                return;
        }
    }

    @Override // io.reactivex.rxjava3.core.FlowableSubscriber, org.reactivestreams.Subscriber
    public final void onSubscribe(Subscription subscription) {
        switch (this.f17312a) {
            case 0:
                if (SubscriptionHelper.validate(this.f17314c, subscription)) {
                    this.f17314c = subscription;
                    this.f17313b.onSubscribe(this);
                    return;
                }
                return;
            default:
                if (SubscriptionHelper.validate(this.f17314c, subscription)) {
                    this.f17314c = subscription;
                    this.f17313b.onSubscribe(this);
                    return;
                }
                return;
        }
    }

    @Override // org.reactivestreams.Subscription
    public final void request(long j) {
        switch (this.f17312a) {
            case 0:
                this.f17314c.request(j);
                return;
            default:
                this.f17314c.request(j);
                return;
        }
    }

    public fl0(Subscriber subscriber) {
        this.f17313b = subscriber;
    }
}
