package p000;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public abstract class oq0 extends CompletableFuture implements FlowableSubscriber {

    /* renamed from: a */
    public final AtomicReference f24862a = new AtomicReference();

    /* renamed from: b */
    public Object f24863b;

    public abstract void afterSubscribe(Subscription subscription);

    @Override // java.util.concurrent.CompletableFuture, java.util.concurrent.Future
    public final boolean cancel(boolean z) {
        cancelUpstream();
        return super.cancel(z);
    }

    public final void cancelUpstream() {
        SubscriptionHelper.cancel(this.f24862a);
    }

    public final void clear() {
        this.f24863b = null;
        this.f24862a.lazySet(SubscriptionHelper.CANCELLED);
    }

    @Override // java.util.concurrent.CompletableFuture
    public final boolean complete(Object obj) {
        cancelUpstream();
        return super.complete(obj);
    }

    @Override // java.util.concurrent.CompletableFuture
    public final boolean completeExceptionally(Throwable th) {
        cancelUpstream();
        return super.completeExceptionally(th);
    }

    @Override // org.reactivestreams.Subscriber
    public final void onError(Throwable th) {
        clear();
        if (!completeExceptionally(th)) {
            RxJavaPlugins.onError(th);
        }
    }

    @Override // io.reactivex.rxjava3.core.FlowableSubscriber, org.reactivestreams.Subscriber
    public final void onSubscribe(@NonNull Subscription subscription) {
        if (SubscriptionHelper.setOnce(this.f24862a, subscription)) {
            afterSubscribe(subscription);
        }
    }
}
