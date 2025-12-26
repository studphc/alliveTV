package p000;

import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class kj2 extends AtomicLong implements SingleObserver, FlowableSubscriber, Subscription {
    private static final long serialVersionUID = 7759721921468635667L;

    /* renamed from: a */
    public final Subscriber f20873a;

    /* renamed from: b */
    public final Function f20874b;

    /* renamed from: c */
    public final AtomicReference f20875c = new AtomicReference();

    /* renamed from: d */
    public Disposable f20876d;

    public kj2(Subscriber subscriber, Function function) {
        this.f20873a = subscriber;
        this.f20874b = function;
    }

    @Override // org.reactivestreams.Subscription
    public final void cancel() {
        this.f20876d.dispose();
        SubscriptionHelper.cancel(this.f20875c);
    }

    @Override // org.reactivestreams.Subscriber
    public final void onComplete() {
        this.f20873a.onComplete();
    }

    @Override // io.reactivex.rxjava3.core.SingleObserver
    public final void onError(Throwable th) {
        this.f20873a.onError(th);
    }

    @Override // org.reactivestreams.Subscriber
    public final void onNext(Object obj) {
        this.f20873a.onNext(obj);
    }

    @Override // io.reactivex.rxjava3.core.SingleObserver
    public final void onSubscribe(Disposable disposable) {
        this.f20876d = disposable;
        this.f20873a.onSubscribe(this);
    }

    @Override // io.reactivex.rxjava3.core.SingleObserver
    public final void onSuccess(Object obj) {
        try {
            Object apply = this.f20874b.apply(obj);
            Objects.requireNonNull(apply, "the mapper returned a null Publisher");
            Publisher publisher = (Publisher) apply;
            if (this.f20875c.get() != SubscriptionHelper.CANCELLED) {
                publisher.subscribe(this);
            }
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            this.f20873a.onError(th);
        }
    }

    @Override // org.reactivestreams.Subscription
    public final void request(long j) {
        SubscriptionHelper.deferredRequest(this.f20875c, this, j);
    }

    @Override // io.reactivex.rxjava3.core.FlowableSubscriber, org.reactivestreams.Subscriber
    public final void onSubscribe(Subscription subscription) {
        SubscriptionHelper.deferredSetOnce(this.f20875c, this, subscription);
    }
}
