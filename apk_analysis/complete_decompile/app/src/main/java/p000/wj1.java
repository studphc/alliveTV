package p000;

import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.core.MaybeSource;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class wj1 extends AtomicReference implements FlowableSubscriber {
    private static final long serialVersionUID = 8663801314800248617L;

    /* renamed from: a */
    public final vj1 f28203a;

    public wj1(vj1 vj1Var) {
        this.f28203a = vj1Var;
    }

    @Override // org.reactivestreams.Subscriber
    public final void onComplete() {
        vj1 vj1Var = this.f28203a;
        vj1Var.getClass();
        if (DisposableHelper.dispose(vj1Var)) {
            MaybeSource maybeSource = vj1Var.f27817c;
            if (maybeSource == null) {
                vj1Var.f27815a.onError(new TimeoutException());
            } else {
                maybeSource.subscribe(vj1Var.f27818d);
            }
        }
    }

    @Override // org.reactivestreams.Subscriber
    public final void onError(Throwable th) {
        vj1 vj1Var = this.f28203a;
        vj1Var.getClass();
        if (DisposableHelper.dispose(vj1Var)) {
            vj1Var.f27815a.onError(th);
        } else {
            RxJavaPlugins.onError(th);
        }
    }

    @Override // org.reactivestreams.Subscriber
    public final void onNext(Object obj) {
        ((Subscription) get()).cancel();
        vj1 vj1Var = this.f28203a;
        vj1Var.getClass();
        if (DisposableHelper.dispose(vj1Var)) {
            MaybeSource maybeSource = vj1Var.f27817c;
            if (maybeSource == null) {
                vj1Var.f27815a.onError(new TimeoutException());
            } else {
                maybeSource.subscribe(vj1Var.f27818d);
            }
        }
    }

    @Override // io.reactivex.rxjava3.core.FlowableSubscriber, org.reactivestreams.Subscriber
    public final void onSubscribe(Subscription subscription) {
        SubscriptionHelper.setOnce(this, subscription, Long.MAX_VALUE);
    }
}
