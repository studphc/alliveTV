package p000;

import io.reactivex.rxjava3.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import io.reactivex.rxjava3.processors.AsyncProcessor;
import org.reactivestreams.Subscriber;

/* renamed from: zb */
/* loaded from: classes2.dex */
public final class C2051zb extends DeferredScalarSubscription {
    private static final long serialVersionUID = 5629876084736248016L;

    /* renamed from: a */
    public final AsyncProcessor f29304a;

    public C2051zb(Subscriber subscriber, AsyncProcessor asyncProcessor) {
        super(subscriber);
        this.f29304a = asyncProcessor;
    }

    @Override // io.reactivex.rxjava3.internal.subscriptions.DeferredScalarSubscription, org.reactivestreams.Subscription
    public final void cancel() {
        if (tryCancel()) {
            this.f29304a.m5309e(this);
        }
    }

    public final void onComplete() {
        if (!isCancelled()) {
            this.downstream.onComplete();
        }
    }

    public final void onError(Throwable th) {
        if (isCancelled()) {
            RxJavaPlugins.onError(th);
        } else {
            this.downstream.onError(th);
        }
    }
}
