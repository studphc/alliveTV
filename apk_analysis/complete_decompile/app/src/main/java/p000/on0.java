package p000;

import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.BiFunction;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.NoSuchElementException;
import java.util.Objects;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class on0 implements FlowableSubscriber, Disposable {

    /* renamed from: a */
    public final /* synthetic */ int f24831a = 1;

    /* renamed from: b */
    public final SingleObserver f24832b;

    /* renamed from: c */
    public Object f24833c;

    /* renamed from: d */
    public Subscription f24834d;

    /* renamed from: e */
    public Object f24835e;

    public on0(SingleObserver singleObserver, Object obj) {
        this.f24832b = singleObserver;
        this.f24833c = obj;
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final void dispose() {
        switch (this.f24831a) {
            case 0:
                this.f24834d.cancel();
                this.f24834d = SubscriptionHelper.CANCELLED;
                return;
            default:
                this.f24834d.cancel();
                this.f24834d = SubscriptionHelper.CANCELLED;
                return;
        }
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final boolean isDisposed() {
        switch (this.f24831a) {
            case 0:
                if (this.f24834d == SubscriptionHelper.CANCELLED) {
                    return true;
                }
                return false;
            default:
                if (this.f24834d == SubscriptionHelper.CANCELLED) {
                    return true;
                }
                return false;
        }
    }

    @Override // org.reactivestreams.Subscriber
    public final void onComplete() {
        switch (this.f24831a) {
            case 0:
                this.f24834d = SubscriptionHelper.CANCELLED;
                Object obj = this.f24835e;
                SingleObserver singleObserver = this.f24832b;
                if (obj != null) {
                    this.f24835e = null;
                    singleObserver.onSuccess(obj);
                    return;
                }
                Object obj2 = this.f24833c;
                if (obj2 != null) {
                    singleObserver.onSuccess(obj2);
                    return;
                } else {
                    singleObserver.onError(new NoSuchElementException());
                    return;
                }
            default:
                Object obj3 = this.f24833c;
                if (obj3 != null) {
                    this.f24833c = null;
                    this.f24834d = SubscriptionHelper.CANCELLED;
                    this.f24832b.onSuccess(obj3);
                    return;
                }
                return;
        }
    }

    @Override // org.reactivestreams.Subscriber
    public final void onError(Throwable th) {
        switch (this.f24831a) {
            case 0:
                this.f24834d = SubscriptionHelper.CANCELLED;
                this.f24835e = null;
                this.f24832b.onError(th);
                return;
            default:
                if (this.f24833c != null) {
                    this.f24833c = null;
                    this.f24834d = SubscriptionHelper.CANCELLED;
                    this.f24832b.onError(th);
                    return;
                }
                RxJavaPlugins.onError(th);
                return;
        }
    }

    @Override // org.reactivestreams.Subscriber
    public final void onNext(Object obj) {
        switch (this.f24831a) {
            case 0:
                this.f24835e = obj;
                return;
            default:
                Object obj2 = this.f24833c;
                if (obj2 != null) {
                    try {
                        Object apply = ((BiFunction) this.f24835e).apply(obj2, obj);
                        Objects.requireNonNull(apply, "The reducer returned a null value");
                        this.f24833c = apply;
                        return;
                    } catch (Throwable th) {
                        Exceptions.throwIfFatal(th);
                        this.f24834d.cancel();
                        onError(th);
                        return;
                    }
                }
                return;
        }
    }

    @Override // io.reactivex.rxjava3.core.FlowableSubscriber, org.reactivestreams.Subscriber
    public final void onSubscribe(Subscription subscription) {
        switch (this.f24831a) {
            case 0:
                if (SubscriptionHelper.validate(this.f24834d, subscription)) {
                    this.f24834d = subscription;
                    this.f24832b.onSubscribe(this);
                    subscription.request(Long.MAX_VALUE);
                    return;
                }
                return;
            default:
                if (SubscriptionHelper.validate(this.f24834d, subscription)) {
                    this.f24834d = subscription;
                    this.f24832b.onSubscribe(this);
                    subscription.request(Long.MAX_VALUE);
                    return;
                }
                return;
        }
    }

    public on0(SingleObserver singleObserver, BiFunction biFunction, Object obj) {
        this.f24832b = singleObserver;
        this.f24833c = obj;
        this.f24835e = biFunction;
    }
}
