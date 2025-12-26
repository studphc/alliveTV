package p000;

import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.BiConsumer;
import io.reactivex.rxjava3.functions.BiFunction;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.NoSuchElementException;
import java.util.Objects;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class ij0 implements FlowableSubscriber, Disposable {

    /* renamed from: a */
    public final /* synthetic */ int f18430a = 1;

    /* renamed from: b */
    public Object f18431b;

    /* renamed from: c */
    public Subscription f18432c;

    /* renamed from: d */
    public boolean f18433d;

    /* renamed from: e */
    public final Object f18434e;

    /* renamed from: f */
    public Object f18435f;

    public ij0(SingleObserver singleObserver, Object obj) {
        this.f18434e = singleObserver;
        this.f18431b = obj;
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final void dispose() {
        switch (this.f18430a) {
            case 0:
                this.f18432c.cancel();
                this.f18432c = SubscriptionHelper.CANCELLED;
                return;
            case 1:
                this.f18432c.cancel();
                this.f18433d = true;
                return;
            default:
                this.f18432c.cancel();
                this.f18432c = SubscriptionHelper.CANCELLED;
                return;
        }
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final boolean isDisposed() {
        switch (this.f18430a) {
            case 0:
                if (this.f18432c == SubscriptionHelper.CANCELLED) {
                    return true;
                }
                return false;
            case 1:
                return this.f18433d;
            default:
                if (this.f18432c == SubscriptionHelper.CANCELLED) {
                    return true;
                }
                return false;
        }
    }

    @Override // org.reactivestreams.Subscriber
    public final void onComplete() {
        switch (this.f18430a) {
            case 0:
                if (!this.f18433d) {
                    this.f18433d = true;
                    this.f18432c = SubscriptionHelper.CANCELLED;
                    ((SingleObserver) this.f18434e).onSuccess(this.f18431b);
                    return;
                }
                return;
            case 1:
                if (!this.f18433d) {
                    this.f18433d = true;
                    Object obj = this.f18431b;
                    MaybeObserver maybeObserver = (MaybeObserver) this.f18434e;
                    if (obj != null) {
                        maybeObserver.onSuccess(obj);
                        return;
                    } else {
                        maybeObserver.onComplete();
                        return;
                    }
                }
                return;
            default:
                if (!this.f18433d) {
                    this.f18433d = true;
                    this.f18432c = SubscriptionHelper.CANCELLED;
                    Object obj2 = this.f18435f;
                    this.f18435f = null;
                    if (obj2 == null) {
                        obj2 = this.f18431b;
                    }
                    SingleObserver singleObserver = (SingleObserver) this.f18434e;
                    if (obj2 != null) {
                        singleObserver.onSuccess(obj2);
                        return;
                    } else {
                        singleObserver.onError(new NoSuchElementException());
                        return;
                    }
                }
                return;
        }
    }

    @Override // org.reactivestreams.Subscriber
    public final void onError(Throwable th) {
        switch (this.f18430a) {
            case 0:
                if (this.f18433d) {
                    RxJavaPlugins.onError(th);
                    return;
                }
                this.f18433d = true;
                this.f18432c = SubscriptionHelper.CANCELLED;
                ((SingleObserver) this.f18434e).onError(th);
                return;
            case 1:
                if (this.f18433d) {
                    RxJavaPlugins.onError(th);
                    return;
                } else {
                    this.f18433d = true;
                    ((MaybeObserver) this.f18434e).onError(th);
                    return;
                }
            default:
                if (this.f18433d) {
                    RxJavaPlugins.onError(th);
                    return;
                }
                this.f18433d = true;
                this.f18432c = SubscriptionHelper.CANCELLED;
                ((SingleObserver) this.f18434e).onError(th);
                return;
        }
    }

    @Override // org.reactivestreams.Subscriber
    public final void onNext(Object obj) {
        switch (this.f18430a) {
            case 0:
                if (!this.f18433d) {
                    try {
                        ((BiConsumer) this.f18435f).accept(this.f18431b, obj);
                        return;
                    } catch (Throwable th) {
                        Exceptions.throwIfFatal(th);
                        this.f18432c.cancel();
                        onError(th);
                        return;
                    }
                }
                return;
            case 1:
                if (!this.f18433d) {
                    Object obj2 = this.f18431b;
                    if (obj2 == null) {
                        this.f18431b = obj;
                        return;
                    }
                    try {
                        Object apply = ((BiFunction) this.f18435f).apply(obj2, obj);
                        Objects.requireNonNull(apply, "The reducer returned a null value");
                        this.f18431b = apply;
                        return;
                    } catch (Throwable th2) {
                        Exceptions.throwIfFatal(th2);
                        this.f18432c.cancel();
                        onError(th2);
                        return;
                    }
                }
                return;
            default:
                if (!this.f18433d) {
                    if (this.f18435f != null) {
                        this.f18433d = true;
                        this.f18432c.cancel();
                        this.f18432c = SubscriptionHelper.CANCELLED;
                        ((SingleObserver) this.f18434e).onError(new IllegalArgumentException("Sequence contains more than one element!"));
                        return;
                    }
                    this.f18435f = obj;
                    return;
                }
                return;
        }
    }

    @Override // io.reactivex.rxjava3.core.FlowableSubscriber, org.reactivestreams.Subscriber
    public final void onSubscribe(Subscription subscription) {
        switch (this.f18430a) {
            case 0:
                if (SubscriptionHelper.validate(this.f18432c, subscription)) {
                    this.f18432c = subscription;
                    ((SingleObserver) this.f18434e).onSubscribe(this);
                    subscription.request(Long.MAX_VALUE);
                    return;
                }
                return;
            case 1:
                if (SubscriptionHelper.validate(this.f18432c, subscription)) {
                    this.f18432c = subscription;
                    ((MaybeObserver) this.f18434e).onSubscribe(this);
                    subscription.request(Long.MAX_VALUE);
                    return;
                }
                return;
            default:
                if (SubscriptionHelper.validate(this.f18432c, subscription)) {
                    this.f18432c = subscription;
                    ((SingleObserver) this.f18434e).onSubscribe(this);
                    subscription.request(Long.MAX_VALUE);
                    return;
                }
                return;
        }
    }

    public ij0(MaybeObserver maybeObserver, BiFunction biFunction) {
        this.f18434e = maybeObserver;
        this.f18435f = biFunction;
    }

    public ij0(SingleObserver singleObserver, Object obj, BiConsumer biConsumer) {
        this.f18434e = singleObserver;
        this.f18435f = biConsumer;
        this.f18431b = obj;
    }
}
