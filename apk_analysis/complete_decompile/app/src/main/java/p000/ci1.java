package p000;

import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.exceptions.CompositeException;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class ci1 extends AtomicReference implements FlowableSubscriber {
    private static final long serialVersionUID = -1215060610805418006L;

    /* renamed from: a */
    public final MaybeObserver f8373a;

    /* renamed from: b */
    public Object f8374b;

    /* renamed from: c */
    public Throwable f8375c;

    public ci1(MaybeObserver maybeObserver) {
        this.f8373a = maybeObserver;
    }

    @Override // org.reactivestreams.Subscriber
    public final void onComplete() {
        Throwable th = this.f8375c;
        MaybeObserver maybeObserver = this.f8373a;
        if (th != null) {
            maybeObserver.onError(th);
            return;
        }
        Object obj = this.f8374b;
        if (obj != null) {
            maybeObserver.onSuccess(obj);
        } else {
            maybeObserver.onComplete();
        }
    }

    @Override // org.reactivestreams.Subscriber
    public final void onError(Throwable th) {
        Throwable th2 = this.f8375c;
        MaybeObserver maybeObserver = this.f8373a;
        if (th2 == null) {
            maybeObserver.onError(th);
        } else {
            maybeObserver.onError(new CompositeException(th2, th));
        }
    }

    @Override // org.reactivestreams.Subscriber
    public final void onNext(Object obj) {
        Subscription subscription = (Subscription) get();
        SubscriptionHelper subscriptionHelper = SubscriptionHelper.CANCELLED;
        if (subscription != subscriptionHelper) {
            lazySet(subscriptionHelper);
            subscription.cancel();
            onComplete();
        }
    }

    @Override // io.reactivex.rxjava3.core.FlowableSubscriber, org.reactivestreams.Subscriber
    public final void onSubscribe(Subscription subscription) {
        SubscriptionHelper.setOnce(this, subscription, Long.MAX_VALUE);
    }
}
