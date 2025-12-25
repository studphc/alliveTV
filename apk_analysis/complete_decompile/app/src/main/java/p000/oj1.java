package p000;

import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class oj1 extends AtomicReference implements FlowableSubscriber {
    private static final long serialVersionUID = -1266041316834525931L;

    /* renamed from: a */
    public final pj1 f23828a;

    public oj1(pj1 pj1Var) {
        this.f23828a = pj1Var;
    }

    @Override // org.reactivestreams.Subscriber
    public final void onComplete() {
        pj1 pj1Var = this.f23828a;
        pj1Var.getClass();
        if (DisposableHelper.dispose(pj1Var)) {
            pj1Var.f25197a.onComplete();
        }
    }

    @Override // org.reactivestreams.Subscriber
    public final void onError(Throwable th) {
        pj1 pj1Var = this.f23828a;
        pj1Var.getClass();
        if (DisposableHelper.dispose(pj1Var)) {
            pj1Var.f25197a.onError(th);
        } else {
            RxJavaPlugins.onError(th);
        }
    }

    @Override // org.reactivestreams.Subscriber
    public final void onNext(Object obj) {
        SubscriptionHelper.cancel(this);
        pj1 pj1Var = this.f23828a;
        pj1Var.getClass();
        if (DisposableHelper.dispose(pj1Var)) {
            pj1Var.f25197a.onComplete();
        }
    }

    @Override // io.reactivex.rxjava3.core.FlowableSubscriber, org.reactivestreams.Subscriber
    public final void onSubscribe(Subscription subscription) {
        SubscriptionHelper.setOnce(this, subscription, Long.MAX_VALUE);
    }
}
