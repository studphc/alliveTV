package p000;

import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.MaybeSource;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Collection;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class nn0 implements FlowableSubscriber, Disposable {

    /* renamed from: a */
    public final /* synthetic */ int f23420a = 0;

    /* renamed from: b */
    public Subscription f23421b;

    /* renamed from: c */
    public final Object f23422c;

    /* renamed from: d */
    public Object f23423d;

    public nn0(MaybeObserver maybeObserver) {
        this.f23422c = maybeObserver;
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final void dispose() {
        switch (this.f23420a) {
            case 0:
                this.f23421b.cancel();
                this.f23421b = SubscriptionHelper.CANCELLED;
                return;
            case 1:
                this.f23421b.cancel();
                this.f23421b = SubscriptionHelper.CANCELLED;
                return;
            default:
                this.f23421b.cancel();
                this.f23421b = SubscriptionHelper.CANCELLED;
                DisposableHelper.dispose((di1) this.f23422c);
                return;
        }
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final boolean isDisposed() {
        switch (this.f23420a) {
            case 0:
                if (this.f23421b == SubscriptionHelper.CANCELLED) {
                    return true;
                }
                return false;
            case 1:
                if (this.f23421b == SubscriptionHelper.CANCELLED) {
                    return true;
                }
                return false;
            default:
                return DisposableHelper.isDisposed((Disposable) ((di1) this.f23422c).get());
        }
    }

    @Override // org.reactivestreams.Subscriber
    public final void onComplete() {
        switch (this.f23420a) {
            case 0:
                this.f23421b = SubscriptionHelper.CANCELLED;
                Object obj = this.f23423d;
                MaybeObserver maybeObserver = (MaybeObserver) this.f23422c;
                if (obj != null) {
                    this.f23423d = null;
                    maybeObserver.onSuccess(obj);
                    return;
                } else {
                    maybeObserver.onComplete();
                    return;
                }
            case 1:
                this.f23421b = SubscriptionHelper.CANCELLED;
                ((SingleObserver) this.f23422c).onSuccess((Collection) this.f23423d);
                return;
            default:
                Subscription subscription = this.f23421b;
                SubscriptionHelper subscriptionHelper = SubscriptionHelper.CANCELLED;
                if (subscription != subscriptionHelper) {
                    this.f23421b = subscriptionHelper;
                    MaybeSource maybeSource = (MaybeSource) this.f23423d;
                    this.f23423d = null;
                    maybeSource.subscribe((di1) this.f23422c);
                    return;
                }
                return;
        }
    }

    @Override // org.reactivestreams.Subscriber
    public final void onError(Throwable th) {
        switch (this.f23420a) {
            case 0:
                this.f23421b = SubscriptionHelper.CANCELLED;
                this.f23423d = null;
                ((MaybeObserver) this.f23422c).onError(th);
                return;
            case 1:
                this.f23423d = null;
                this.f23421b = SubscriptionHelper.CANCELLED;
                ((SingleObserver) this.f23422c).onError(th);
                return;
            default:
                Subscription subscription = this.f23421b;
                SubscriptionHelper subscriptionHelper = SubscriptionHelper.CANCELLED;
                if (subscription != subscriptionHelper) {
                    this.f23421b = subscriptionHelper;
                    ((di1) this.f23422c).f16380a.onError(th);
                    return;
                } else {
                    RxJavaPlugins.onError(th);
                    return;
                }
        }
    }

    @Override // org.reactivestreams.Subscriber
    public final void onNext(Object obj) {
        switch (this.f23420a) {
            case 0:
                this.f23423d = obj;
                return;
            case 1:
                ((Collection) this.f23423d).add(obj);
                return;
            default:
                Subscription subscription = this.f23421b;
                SubscriptionHelper subscriptionHelper = SubscriptionHelper.CANCELLED;
                if (subscription != subscriptionHelper) {
                    subscription.cancel();
                    this.f23421b = subscriptionHelper;
                    MaybeSource maybeSource = (MaybeSource) this.f23423d;
                    this.f23423d = null;
                    maybeSource.subscribe((di1) this.f23422c);
                    return;
                }
                return;
        }
    }

    @Override // io.reactivex.rxjava3.core.FlowableSubscriber, org.reactivestreams.Subscriber
    public final void onSubscribe(Subscription subscription) {
        switch (this.f23420a) {
            case 0:
                if (SubscriptionHelper.validate(this.f23421b, subscription)) {
                    this.f23421b = subscription;
                    ((MaybeObserver) this.f23422c).onSubscribe(this);
                    subscription.request(Long.MAX_VALUE);
                    return;
                }
                return;
            case 1:
                if (SubscriptionHelper.validate(this.f23421b, subscription)) {
                    this.f23421b = subscription;
                    ((SingleObserver) this.f23422c).onSubscribe(this);
                    subscription.request(Long.MAX_VALUE);
                    return;
                }
                return;
            default:
                if (SubscriptionHelper.validate(this.f23421b, subscription)) {
                    this.f23421b = subscription;
                    ((di1) this.f23422c).f16380a.onSubscribe(this);
                    subscription.request(Long.MAX_VALUE);
                    return;
                }
                return;
        }
    }

    public nn0(MaybeObserver maybeObserver, MaybeSource maybeSource) {
        this.f23422c = new di1(maybeObserver);
        this.f23423d = maybeSource;
    }

    public nn0(SingleObserver singleObserver, Collection collection) {
        this.f23422c = singleObserver;
        this.f23423d = collection;
    }
}
