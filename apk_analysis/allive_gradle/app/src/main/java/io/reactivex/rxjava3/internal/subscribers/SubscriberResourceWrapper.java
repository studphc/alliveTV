package io.reactivex.rxjava3.internal.subscribers;

import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class SubscriberResourceWrapper<T> extends AtomicReference<Disposable> implements FlowableSubscriber<T>, Disposable, Subscription {
    private static final long serialVersionUID = -8612022020200669122L;

    /* renamed from: a */
    public final Subscriber f19930a;

    /* renamed from: b */
    public final AtomicReference f19931b = new AtomicReference();

    public SubscriberResourceWrapper(Subscriber<? super T> subscriber) {
        this.f19930a = subscriber;
    }

    @Override // org.reactivestreams.Subscription
    public void cancel() {
        dispose();
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public void dispose() {
        SubscriptionHelper.cancel(this.f19931b);
        DisposableHelper.dispose(this);
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public boolean isDisposed() {
        if (this.f19931b.get() == SubscriptionHelper.CANCELLED) {
            return true;
        }
        return false;
    }

    @Override // org.reactivestreams.Subscriber
    public void onComplete() {
        DisposableHelper.dispose(this);
        this.f19930a.onComplete();
    }

    @Override // org.reactivestreams.Subscriber
    public void onError(Throwable th) {
        DisposableHelper.dispose(this);
        this.f19930a.onError(th);
    }

    @Override // org.reactivestreams.Subscriber
    public void onNext(T t) {
        this.f19930a.onNext(t);
    }

    @Override // io.reactivex.rxjava3.core.FlowableSubscriber, org.reactivestreams.Subscriber
    public void onSubscribe(Subscription subscription) {
        if (SubscriptionHelper.setOnce(this.f19931b, subscription)) {
            this.f19930a.onSubscribe(this);
        }
    }

    @Override // org.reactivestreams.Subscription
    public void request(long j) {
        if (SubscriptionHelper.validate(j)) {
            ((Subscription) this.f19931b.get()).request(j);
        }
    }

    public void setResource(Disposable disposable) {
        DisposableHelper.set(this, disposable);
    }
}
