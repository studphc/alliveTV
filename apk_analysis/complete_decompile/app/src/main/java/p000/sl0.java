package p000;

import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.NoSuchElementException;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class sl0 implements FlowableSubscriber, Disposable {

    /* renamed from: a */
    public final SingleObserver f26470a;

    /* renamed from: b */
    public final long f26471b;

    /* renamed from: c */
    public final Object f26472c;

    /* renamed from: d */
    public Subscription f26473d;

    /* renamed from: e */
    public long f26474e;

    /* renamed from: f */
    public boolean f26475f;

    public sl0(SingleObserver singleObserver, long j, Object obj) {
        this.f26470a = singleObserver;
        this.f26471b = j;
        this.f26472c = obj;
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final void dispose() {
        this.f26473d.cancel();
        this.f26473d = SubscriptionHelper.CANCELLED;
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final boolean isDisposed() {
        if (this.f26473d == SubscriptionHelper.CANCELLED) {
            return true;
        }
        return false;
    }

    @Override // org.reactivestreams.Subscriber
    public final void onComplete() {
        this.f26473d = SubscriptionHelper.CANCELLED;
        if (!this.f26475f) {
            this.f26475f = true;
            SingleObserver singleObserver = this.f26470a;
            Object obj = this.f26472c;
            if (obj != null) {
                singleObserver.onSuccess(obj);
            } else {
                singleObserver.onError(new NoSuchElementException());
            }
        }
    }

    @Override // org.reactivestreams.Subscriber
    public final void onError(Throwable th) {
        if (this.f26475f) {
            RxJavaPlugins.onError(th);
            return;
        }
        this.f26475f = true;
        this.f26473d = SubscriptionHelper.CANCELLED;
        this.f26470a.onError(th);
    }

    @Override // org.reactivestreams.Subscriber
    public final void onNext(Object obj) {
        if (this.f26475f) {
            return;
        }
        long j = this.f26474e;
        if (j == this.f26471b) {
            this.f26475f = true;
            this.f26473d.cancel();
            this.f26473d = SubscriptionHelper.CANCELLED;
            this.f26470a.onSuccess(obj);
            return;
        }
        this.f26474e = j + 1;
    }

    @Override // io.reactivex.rxjava3.core.FlowableSubscriber, org.reactivestreams.Subscriber
    public final void onSubscribe(Subscription subscription) {
        if (SubscriptionHelper.validate(this.f26473d, subscription)) {
            this.f26473d = subscription;
            this.f26470a.onSubscribe(this);
            subscription.request(this.f26471b + 1);
        }
    }
}
