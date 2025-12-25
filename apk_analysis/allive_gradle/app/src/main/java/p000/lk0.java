package p000;

import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class lk0 implements FlowableSubscriber, Disposable {

    /* renamed from: a */
    public final SingleObserver f22545a;

    /* renamed from: b */
    public Subscription f22546b;

    /* renamed from: c */
    public long f22547c;

    public lk0(SingleObserver singleObserver) {
        this.f22545a = singleObserver;
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final void dispose() {
        this.f22546b.cancel();
        this.f22546b = SubscriptionHelper.CANCELLED;
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final boolean isDisposed() {
        if (this.f22546b == SubscriptionHelper.CANCELLED) {
            return true;
        }
        return false;
    }

    @Override // org.reactivestreams.Subscriber
    public final void onComplete() {
        this.f22546b = SubscriptionHelper.CANCELLED;
        this.f22545a.onSuccess(Long.valueOf(this.f22547c));
    }

    @Override // org.reactivestreams.Subscriber
    public final void onError(Throwable th) {
        this.f22546b = SubscriptionHelper.CANCELLED;
        this.f22545a.onError(th);
    }

    @Override // org.reactivestreams.Subscriber
    public final void onNext(Object obj) {
        this.f22547c++;
    }

    @Override // io.reactivex.rxjava3.core.FlowableSubscriber, org.reactivestreams.Subscriber
    public final void onSubscribe(Subscription subscription) {
        if (SubscriptionHelper.validate(this.f22546b, subscription)) {
            this.f22546b = subscription;
            this.f22545a.onSubscribe(this);
            subscription.request(Long.MAX_VALUE);
        }
    }
}
