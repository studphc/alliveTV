package p000;

import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class wn0 extends AtomicReference implements SingleObserver {
    private static final long serialVersionUID = -2935427570954647017L;

    /* renamed from: a */
    public final xn0 f28253a;

    public wn0(xn0 xn0Var) {
        this.f28253a = xn0Var;
    }

    @Override // io.reactivex.rxjava3.core.SingleObserver
    public final void onError(Throwable th) {
        xn0 xn0Var = this.f28253a;
        if (xn0Var.f28644d.tryAddThrowableOrReport(th)) {
            SubscriptionHelper.cancel(xn0Var.f28642b);
            if (xn0Var.getAndIncrement() == 0) {
                xn0Var.m8174a();
            }
        }
    }

    @Override // io.reactivex.rxjava3.core.SingleObserver
    public final void onSubscribe(Disposable disposable) {
        DisposableHelper.setOnce(this, disposable);
    }

    @Override // io.reactivex.rxjava3.core.SingleObserver
    public final void onSuccess(Object obj) {
        xn0 xn0Var = this.f28253a;
        if (xn0Var.compareAndSet(0, 1)) {
            long j = xn0Var.f28653m;
            if (xn0Var.f28645e.get() != j) {
                xn0Var.f28653m = j + 1;
                xn0Var.f28641a.onNext(obj);
                xn0Var.f28652l = 2;
            } else {
                xn0Var.f28649i = obj;
                xn0Var.f28652l = 1;
                if (xn0Var.decrementAndGet() == 0) {
                    return;
                }
            }
        } else {
            xn0Var.f28649i = obj;
            xn0Var.f28652l = 1;
            if (xn0Var.getAndIncrement() != 0) {
                return;
            }
        }
        xn0Var.m8174a();
    }
}
