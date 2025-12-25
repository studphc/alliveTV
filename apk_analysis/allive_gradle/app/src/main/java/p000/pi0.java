package p000;

import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Predicate;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class pi0 implements FlowableSubscriber, Disposable {

    /* renamed from: a */
    public final /* synthetic */ int f25183a;

    /* renamed from: b */
    public final Object f25184b;

    /* renamed from: c */
    public Object f25185c;

    /* renamed from: d */
    public Subscription f25186d;

    /* renamed from: e */
    public boolean f25187e;

    public /* synthetic */ pi0(SingleObserver singleObserver, Predicate predicate, int i) {
        this.f25183a = i;
        this.f25184b = singleObserver;
        this.f25185c = predicate;
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final void dispose() {
        switch (this.f25183a) {
            case 0:
                this.f25186d.cancel();
                this.f25186d = SubscriptionHelper.CANCELLED;
                return;
            case 1:
                this.f25186d.cancel();
                this.f25186d = SubscriptionHelper.CANCELLED;
                return;
            default:
                this.f25186d.cancel();
                this.f25186d = SubscriptionHelper.CANCELLED;
                return;
        }
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final boolean isDisposed() {
        switch (this.f25183a) {
            case 0:
                if (this.f25186d == SubscriptionHelper.CANCELLED) {
                    return true;
                }
                return false;
            case 1:
                if (this.f25186d == SubscriptionHelper.CANCELLED) {
                    return true;
                }
                return false;
            default:
                if (this.f25186d == SubscriptionHelper.CANCELLED) {
                    return true;
                }
                return false;
        }
    }

    @Override // org.reactivestreams.Subscriber
    public final void onComplete() {
        switch (this.f25183a) {
            case 0:
                if (!this.f25187e) {
                    this.f25187e = true;
                    this.f25186d = SubscriptionHelper.CANCELLED;
                    ((SingleObserver) this.f25184b).onSuccess(Boolean.TRUE);
                    return;
                }
                return;
            case 1:
                if (!this.f25187e) {
                    this.f25187e = true;
                    this.f25186d = SubscriptionHelper.CANCELLED;
                    ((SingleObserver) this.f25184b).onSuccess(Boolean.FALSE);
                    return;
                }
                return;
            default:
                if (!this.f25187e) {
                    this.f25187e = true;
                    this.f25186d = SubscriptionHelper.CANCELLED;
                    Object obj = this.f25185c;
                    this.f25185c = null;
                    MaybeObserver maybeObserver = (MaybeObserver) this.f25184b;
                    if (obj == null) {
                        maybeObserver.onComplete();
                        return;
                    } else {
                        maybeObserver.onSuccess(obj);
                        return;
                    }
                }
                return;
        }
    }

    @Override // org.reactivestreams.Subscriber
    public final void onError(Throwable th) {
        switch (this.f25183a) {
            case 0:
                if (this.f25187e) {
                    RxJavaPlugins.onError(th);
                    return;
                }
                this.f25187e = true;
                this.f25186d = SubscriptionHelper.CANCELLED;
                ((SingleObserver) this.f25184b).onError(th);
                return;
            case 1:
                if (this.f25187e) {
                    RxJavaPlugins.onError(th);
                    return;
                }
                this.f25187e = true;
                this.f25186d = SubscriptionHelper.CANCELLED;
                ((SingleObserver) this.f25184b).onError(th);
                return;
            default:
                if (this.f25187e) {
                    RxJavaPlugins.onError(th);
                    return;
                }
                this.f25187e = true;
                this.f25186d = SubscriptionHelper.CANCELLED;
                ((MaybeObserver) this.f25184b).onError(th);
                return;
        }
    }

    @Override // org.reactivestreams.Subscriber
    public final void onNext(Object obj) {
        switch (this.f25183a) {
            case 0:
                if (!this.f25187e) {
                    try {
                        if (!((Predicate) this.f25185c).test(obj)) {
                            this.f25187e = true;
                            this.f25186d.cancel();
                            this.f25186d = SubscriptionHelper.CANCELLED;
                            ((SingleObserver) this.f25184b).onSuccess(Boolean.FALSE);
                            return;
                        }
                        return;
                    } catch (Throwable th) {
                        Exceptions.throwIfFatal(th);
                        this.f25186d.cancel();
                        this.f25186d = SubscriptionHelper.CANCELLED;
                        onError(th);
                        return;
                    }
                }
                return;
            case 1:
                if (!this.f25187e) {
                    try {
                        if (((Predicate) this.f25185c).test(obj)) {
                            this.f25187e = true;
                            this.f25186d.cancel();
                            this.f25186d = SubscriptionHelper.CANCELLED;
                            ((SingleObserver) this.f25184b).onSuccess(Boolean.TRUE);
                            return;
                        }
                        return;
                    } catch (Throwable th2) {
                        Exceptions.throwIfFatal(th2);
                        this.f25186d.cancel();
                        this.f25186d = SubscriptionHelper.CANCELLED;
                        onError(th2);
                        return;
                    }
                }
                return;
            default:
                if (!this.f25187e) {
                    if (this.f25185c != null) {
                        this.f25187e = true;
                        this.f25186d.cancel();
                        this.f25186d = SubscriptionHelper.CANCELLED;
                        ((MaybeObserver) this.f25184b).onError(new IllegalArgumentException("Sequence contains more than one element!"));
                        return;
                    }
                    this.f25185c = obj;
                    return;
                }
                return;
        }
    }

    @Override // io.reactivex.rxjava3.core.FlowableSubscriber, org.reactivestreams.Subscriber
    public final void onSubscribe(Subscription subscription) {
        switch (this.f25183a) {
            case 0:
                if (SubscriptionHelper.validate(this.f25186d, subscription)) {
                    this.f25186d = subscription;
                    ((SingleObserver) this.f25184b).onSubscribe(this);
                    subscription.request(Long.MAX_VALUE);
                    return;
                }
                return;
            case 1:
                if (SubscriptionHelper.validate(this.f25186d, subscription)) {
                    this.f25186d = subscription;
                    ((SingleObserver) this.f25184b).onSubscribe(this);
                    subscription.request(Long.MAX_VALUE);
                    return;
                }
                return;
            default:
                if (SubscriptionHelper.validate(this.f25186d, subscription)) {
                    this.f25186d = subscription;
                    ((MaybeObserver) this.f25184b).onSubscribe(this);
                    subscription.request(Long.MAX_VALUE);
                    return;
                }
                return;
        }
    }

    public pi0(MaybeObserver maybeObserver) {
        this.f25183a = 2;
        this.f25184b = maybeObserver;
    }
}
