package p000;

import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class jr0 extends AtomicReference implements FlowableSubscriber, Disposable {
    private static final long serialVersionUID = 8708641127342403073L;

    /* renamed from: a */
    public final Number f20592a;

    /* renamed from: b */
    public final long f20593b;

    /* JADX WARN: Multi-variable type inference failed */
    public jr0(long j, lr0 lr0Var) {
        this.f20593b = j;
        this.f20592a = (Number) lr0Var;
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final void dispose() {
        SubscriptionHelper.cancel(this);
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final boolean isDisposed() {
        if (get() == SubscriptionHelper.CANCELLED) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.Number, qr0] */
    @Override // org.reactivestreams.Subscriber
    public final void onComplete() {
        Object obj = get();
        SubscriptionHelper subscriptionHelper = SubscriptionHelper.CANCELLED;
        if (obj != subscriptionHelper) {
            lazySet(subscriptionHelper);
            this.f20592a.mo5780a(this.f20593b);
        }
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [lr0, java.lang.Number] */
    @Override // org.reactivestreams.Subscriber
    public final void onError(Throwable th) {
        Object obj = get();
        SubscriptionHelper subscriptionHelper = SubscriptionHelper.CANCELLED;
        if (obj != subscriptionHelper) {
            lazySet(subscriptionHelper);
            this.f20592a.mo5781b(this.f20593b, th);
        } else {
            RxJavaPlugins.onError(th);
        }
    }

    /* JADX WARN: Type inference failed for: r3v3, types: [java.lang.Number, qr0] */
    @Override // org.reactivestreams.Subscriber
    public final void onNext(Object obj) {
        Subscription subscription = (Subscription) get();
        SubscriptionHelper subscriptionHelper = SubscriptionHelper.CANCELLED;
        if (subscription != subscriptionHelper) {
            subscription.cancel();
            lazySet(subscriptionHelper);
            this.f20592a.mo5780a(this.f20593b);
        }
    }

    @Override // io.reactivex.rxjava3.core.FlowableSubscriber, org.reactivestreams.Subscriber
    public final void onSubscribe(Subscription subscription) {
        SubscriptionHelper.setOnce(this, subscription, Long.MAX_VALUE);
    }
}
