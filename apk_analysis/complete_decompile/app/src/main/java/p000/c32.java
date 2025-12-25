package p000;

import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class c32 extends AtomicReference implements FlowableSubscriber {
    private static final long serialVersionUID = 6751017204873808094L;

    /* renamed from: a */
    public final d32 f8244a;

    /* renamed from: b */
    public final int f8245b;

    public c32(d32 d32Var, int i) {
        this.f8244a = d32Var;
        this.f8245b = i;
    }

    @Override // org.reactivestreams.Subscriber
    public final void onError(Throwable th) {
        d32 d32Var = this.f8244a;
        AtomicReference atomicReference = d32Var.f16235i;
        while (!atomicReference.compareAndSet(null, th)) {
            if (atomicReference.get() != null) {
                if (th != atomicReference.get()) {
                    RxJavaPlugins.onError(th);
                    return;
                }
                return;
            }
        }
        d32Var.m4518b();
    }

    @Override // org.reactivestreams.Subscriber
    public final void onNext(Object obj) {
        d32 d32Var = this.f8244a;
        d32Var.f16229c[this.f8245b] = (List) obj;
        if (d32Var.f16234h.decrementAndGet() == 0) {
            d32Var.m4518b();
        }
    }

    @Override // io.reactivex.rxjava3.core.FlowableSubscriber, org.reactivestreams.Subscriber
    public final void onSubscribe(Subscription subscription) {
        SubscriptionHelper.setOnce(this, subscription, Long.MAX_VALUE);
    }

    @Override // org.reactivestreams.Subscriber
    public final void onComplete() {
    }
}
