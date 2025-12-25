package p000;

import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class un0 extends AtomicReference implements MaybeObserver {
    private static final long serialVersionUID = -2935427570954647017L;

    /* renamed from: a */
    public final vn0 f27380a;

    public un0(vn0 vn0Var) {
        this.f27380a = vn0Var;
    }

    @Override // io.reactivex.rxjava3.core.MaybeObserver
    public final void onComplete() {
        vn0 vn0Var = this.f27380a;
        vn0Var.f27891l = 2;
        if (vn0Var.getAndIncrement() == 0) {
            vn0Var.m7925a();
        }
    }

    @Override // io.reactivex.rxjava3.core.MaybeObserver
    public final void onError(Throwable th) {
        vn0 vn0Var = this.f27380a;
        if (vn0Var.f27883d.tryAddThrowableOrReport(th)) {
            SubscriptionHelper.cancel(vn0Var.f27881b);
            if (vn0Var.getAndIncrement() == 0) {
                vn0Var.m7925a();
            }
        }
    }

    @Override // io.reactivex.rxjava3.core.MaybeObserver
    public final void onSubscribe(Disposable disposable) {
        DisposableHelper.setOnce(this, disposable);
    }

    @Override // io.reactivex.rxjava3.core.MaybeObserver
    public final void onSuccess(Object obj) {
        vn0 vn0Var = this.f27380a;
        if (vn0Var.compareAndSet(0, 1)) {
            long j = vn0Var.f27892m;
            if (vn0Var.f27884e.get() != j) {
                vn0Var.f27892m = j + 1;
                vn0Var.f27880a.onNext(obj);
                vn0Var.f27891l = 2;
            } else {
                vn0Var.f27888i = obj;
                vn0Var.f27891l = 1;
                if (vn0Var.decrementAndGet() == 0) {
                    return;
                }
            }
        } else {
            vn0Var.f27888i = obj;
            vn0Var.f27891l = 1;
            if (vn0Var.getAndIncrement() != 0) {
                return;
            }
        }
        vn0Var.m7925a();
    }
}
