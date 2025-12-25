package io.reactivex.rxjava3.subscribers;

import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.ListCompositeDisposable;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.EndConsumerHelper;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public abstract class ResourceSubscriber<T> implements FlowableSubscriber<T>, Disposable {

    /* renamed from: a */
    public final AtomicReference f20149a = new AtomicReference();

    /* renamed from: b */
    public final ListCompositeDisposable f20150b = new ListCompositeDisposable();

    /* renamed from: c */
    public final AtomicLong f20151c = new AtomicLong();

    public final void add(Disposable disposable) {
        Objects.requireNonNull(disposable, "resource is null");
        this.f20150b.add(disposable);
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final void dispose() {
        if (SubscriptionHelper.cancel(this.f20149a)) {
            this.f20150b.dispose();
        }
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final boolean isDisposed() {
        if (this.f20149a.get() == SubscriptionHelper.CANCELLED) {
            return true;
        }
        return false;
    }

    public void onStart() {
        request(Long.MAX_VALUE);
    }

    @Override // io.reactivex.rxjava3.core.FlowableSubscriber, org.reactivestreams.Subscriber
    public final void onSubscribe(Subscription subscription) {
        if (EndConsumerHelper.setOnce((AtomicReference<Subscription>) this.f20149a, subscription, getClass())) {
            long andSet = this.f20151c.getAndSet(0L);
            if (andSet != 0) {
                subscription.request(andSet);
            }
            onStart();
        }
    }

    public final void request(long j) {
        SubscriptionHelper.deferredRequest(this.f20149a, this.f20151c, j);
    }
}
