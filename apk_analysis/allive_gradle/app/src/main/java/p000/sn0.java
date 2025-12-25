package p000;

import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.HalfSerializer;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;

/* loaded from: classes2.dex */
public final class sn0 extends AtomicReference implements CompletableObserver {
    private static final long serialVersionUID = -2935427570954647017L;

    /* renamed from: a */
    public final tn0 f26501a;

    public sn0(tn0 tn0Var) {
        this.f26501a = tn0Var;
    }

    @Override // io.reactivex.rxjava3.core.CompletableObserver
    public final void onComplete() {
        tn0 tn0Var = this.f26501a;
        tn0Var.f26899g = true;
        if (tn0Var.f26898f) {
            HalfSerializer.onComplete((Subscriber<?>) tn0Var.f26893a, tn0Var, tn0Var.f26896d);
        }
    }

    @Override // io.reactivex.rxjava3.core.CompletableObserver
    public final void onError(Throwable th) {
        tn0 tn0Var = this.f26501a;
        SubscriptionHelper.cancel(tn0Var.f26894b);
        HalfSerializer.onError((Subscriber<?>) tn0Var.f26893a, th, tn0Var, tn0Var.f26896d);
    }

    @Override // io.reactivex.rxjava3.core.CompletableObserver
    public final void onSubscribe(Disposable disposable) {
        DisposableHelper.setOnce(this, disposable);
    }
}
