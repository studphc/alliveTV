package p000;

import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class xp0 implements FlowableSubscriber {

    /* renamed from: a */
    public final /* synthetic */ int f28676a;

    /* renamed from: b */
    public final AtomicReference f28677b;

    public /* synthetic */ xp0(AtomicReference atomicReference, int i) {
        this.f28676a = i;
        this.f28677b = atomicReference;
    }

    @Override // org.reactivestreams.Subscriber
    public final void onComplete() {
        switch (this.f28676a) {
            case 0:
                wp0 wp0Var = (wp0) this.f28677b;
                wp0Var.f28268e.cancel();
                wp0Var.mo7759a();
                return;
            default:
                return;
        }
    }

    @Override // org.reactivestreams.Subscriber
    public final void onError(Throwable th) {
        switch (this.f28676a) {
            case 0:
                wp0 wp0Var = (wp0) this.f28677b;
                wp0Var.f28268e.cancel();
                wp0Var.f28264a.onError(th);
                return;
            default:
                js0 js0Var = (js0) this.f28677b;
                SubscriptionHelper.cancel(js0Var.f20596c);
                js0Var.f20594a.onError(th);
                return;
        }
    }

    @Override // org.reactivestreams.Subscriber
    public final void onNext(Object obj) {
        switch (this.f28676a) {
            case 0:
                ((wp0) this.f28677b).mo7760c();
                return;
            default:
                ((js0) this.f28677b).lazySet(obj);
                return;
        }
    }

    @Override // io.reactivex.rxjava3.core.FlowableSubscriber, org.reactivestreams.Subscriber
    public final void onSubscribe(Subscription subscription) {
        switch (this.f28676a) {
            case 0:
                SubscriptionHelper.setOnce(((wp0) this.f28677b).f28267d, subscription, Long.MAX_VALUE);
                return;
            default:
                if (SubscriptionHelper.setOnce(((js0) this.f28677b).f20598e, subscription)) {
                    subscription.request(Long.MAX_VALUE);
                    return;
                }
                return;
        }
    }

    /* renamed from: a */
    private final void m8176a() {
    }
}
