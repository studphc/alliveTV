package p000;

import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class vi1 extends AtomicReference implements FlowableSubscriber, MaybeObserver, Subscription {
    private static final long serialVersionUID = -8948264376121066672L;

    /* renamed from: a */
    public final Subscriber f27806a;

    /* renamed from: b */
    public final Function f27807b;

    /* renamed from: c */
    public Disposable f27808c;

    /* renamed from: d */
    public final AtomicLong f27809d = new AtomicLong();

    public vi1(Subscriber subscriber, Function function) {
        this.f27806a = subscriber;
        this.f27807b = function;
    }

    @Override // org.reactivestreams.Subscription
    public final void cancel() {
        this.f27808c.dispose();
        SubscriptionHelper.cancel(this);
    }

    @Override // org.reactivestreams.Subscriber
    public final void onComplete() {
        this.f27806a.onComplete();
    }

    @Override // org.reactivestreams.Subscriber
    public final void onError(Throwable th) {
        this.f27806a.onError(th);
    }

    @Override // org.reactivestreams.Subscriber
    public final void onNext(Object obj) {
        this.f27806a.onNext(obj);
    }

    @Override // io.reactivex.rxjava3.core.MaybeObserver
    public final void onSubscribe(Disposable disposable) {
        if (DisposableHelper.validate(this.f27808c, disposable)) {
            this.f27808c = disposable;
            this.f27806a.onSubscribe(this);
        }
    }

    @Override // io.reactivex.rxjava3.core.MaybeObserver
    public final void onSuccess(Object obj) {
        try {
            Object apply = this.f27807b.apply(obj);
            Objects.requireNonNull(apply, "The mapper returned a null Publisher");
            Publisher publisher = (Publisher) apply;
            if (get() != SubscriptionHelper.CANCELLED) {
                publisher.subscribe(this);
            }
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            this.f27806a.onError(th);
        }
    }

    @Override // org.reactivestreams.Subscription
    public final void request(long j) {
        SubscriptionHelper.deferredRequest(this, this.f27809d, j);
    }

    @Override // io.reactivex.rxjava3.core.FlowableSubscriber, org.reactivestreams.Subscriber
    public final void onSubscribe(Subscription subscription) {
        SubscriptionHelper.deferredSetOnce(this, this.f27809d, subscription);
    }
}
