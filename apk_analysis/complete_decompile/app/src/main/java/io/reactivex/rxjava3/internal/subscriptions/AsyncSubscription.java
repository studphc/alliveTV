package io.reactivex.rxjava3.internal.subscriptions;

import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class AsyncSubscription extends AtomicLong implements Subscription, Disposable {
    private static final long serialVersionUID = 7028635084060361255L;

    /* renamed from: a */
    public final AtomicReference f19932a;

    /* renamed from: b */
    public final AtomicReference f19933b;

    public AsyncSubscription() {
        this.f19933b = new AtomicReference();
        this.f19932a = new AtomicReference();
    }

    @Override // org.reactivestreams.Subscription
    public void cancel() {
        dispose();
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public void dispose() {
        SubscriptionHelper.cancel(this.f19932a);
        DisposableHelper.dispose(this.f19933b);
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public boolean isDisposed() {
        if (this.f19932a.get() == SubscriptionHelper.CANCELLED) {
            return true;
        }
        return false;
    }

    public boolean replaceResource(Disposable disposable) {
        return DisposableHelper.replace(this.f19933b, disposable);
    }

    @Override // org.reactivestreams.Subscription
    public void request(long j) {
        SubscriptionHelper.deferredRequest(this.f19932a, this, j);
    }

    public boolean setResource(Disposable disposable) {
        return DisposableHelper.set(this.f19933b, disposable);
    }

    public void setSubscription(Subscription subscription) {
        SubscriptionHelper.deferredSetOnce(this.f19932a, this, subscription);
    }

    public AsyncSubscription(Disposable disposable) {
        this();
        this.f19933b.lazySet(disposable);
    }
}
