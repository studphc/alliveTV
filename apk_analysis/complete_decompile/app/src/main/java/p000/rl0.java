package p000;

import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class rl0 implements FlowableSubscriber, Disposable {

    /* renamed from: a */
    public final MaybeObserver f26012a;

    /* renamed from: b */
    public final long f26013b;

    /* renamed from: c */
    public Subscription f26014c;

    /* renamed from: d */
    public long f26015d;

    /* renamed from: e */
    public boolean f26016e;

    public rl0(MaybeObserver maybeObserver, long j) {
        this.f26012a = maybeObserver;
        this.f26013b = j;
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final void dispose() {
        this.f26014c.cancel();
        this.f26014c = SubscriptionHelper.CANCELLED;
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final boolean isDisposed() {
        if (this.f26014c == SubscriptionHelper.CANCELLED) {
            return true;
        }
        return false;
    }

    @Override // org.reactivestreams.Subscriber
    public final void onComplete() {
        this.f26014c = SubscriptionHelper.CANCELLED;
        if (!this.f26016e) {
            this.f26016e = true;
            this.f26012a.onComplete();
        }
    }

    @Override // org.reactivestreams.Subscriber
    public final void onError(Throwable th) {
        if (this.f26016e) {
            RxJavaPlugins.onError(th);
            return;
        }
        this.f26016e = true;
        this.f26014c = SubscriptionHelper.CANCELLED;
        this.f26012a.onError(th);
    }

    @Override // org.reactivestreams.Subscriber
    public final void onNext(Object obj) {
        if (this.f26016e) {
            return;
        }
        long j = this.f26015d;
        if (j == this.f26013b) {
            this.f26016e = true;
            this.f26014c.cancel();
            this.f26014c = SubscriptionHelper.CANCELLED;
            this.f26012a.onSuccess(obj);
            return;
        }
        this.f26015d = j + 1;
    }

    @Override // io.reactivex.rxjava3.core.FlowableSubscriber, org.reactivestreams.Subscriber
    public final void onSubscribe(Subscription subscription) {
        if (SubscriptionHelper.validate(this.f26014c, subscription)) {
            this.f26014c = subscription;
            this.f26012a.onSubscribe(this);
            subscription.request(this.f26013b + 1);
        }
    }
}
