package p000;

import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class bx1 extends AtomicReference implements SingleObserver {
    private static final long serialVersionUID = -2935427570954647017L;

    /* renamed from: a */
    public final cx1 f8178a;

    public bx1(cx1 cx1Var) {
        this.f8178a = cx1Var;
    }

    @Override // io.reactivex.rxjava3.core.SingleObserver
    public final void onError(Throwable th) {
        cx1 cx1Var = this.f8178a;
        if (cx1Var.f16167d.tryAddThrowableOrReport(th)) {
            DisposableHelper.dispose(cx1Var.f16165b);
            if (cx1Var.getAndIncrement() == 0) {
                cx1Var.m4502a();
            }
        }
    }

    @Override // io.reactivex.rxjava3.core.SingleObserver
    public final void onSubscribe(Disposable disposable) {
        DisposableHelper.setOnce(this, disposable);
    }

    @Override // io.reactivex.rxjava3.core.SingleObserver
    public final void onSuccess(Object obj) {
        cx1 cx1Var = this.f8178a;
        if (cx1Var.compareAndSet(0, 1)) {
            cx1Var.f16164a.onNext(obj);
            cx1Var.f16172i = 2;
        } else {
            cx1Var.f16169f = obj;
            cx1Var.f16172i = 1;
            if (cx1Var.getAndIncrement() != 0) {
                return;
            }
        }
        cx1Var.m4502a();
    }
}
