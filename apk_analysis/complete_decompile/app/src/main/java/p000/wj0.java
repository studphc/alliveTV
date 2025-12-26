package p000;

import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.util.ErrorMode;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class wj0 extends AtomicReference implements CompletableObserver {
    private static final long serialVersionUID = 5638352172918776687L;

    /* renamed from: a */
    public final xj0 f28202a;

    public wj0(xj0 xj0Var) {
        this.f28202a = xj0Var;
    }

    @Override // io.reactivex.rxjava3.core.CompletableObserver
    public final void onComplete() {
        xj0 xj0Var = this.f28202a;
        xj0Var.f28588l = false;
        xj0Var.mo111c();
    }

    @Override // io.reactivex.rxjava3.core.CompletableObserver
    public final void onError(Throwable th) {
        xj0 xj0Var = this.f28202a;
        if (xj0Var.f19241a.tryAddThrowableOrReport(th)) {
            if (xj0Var.f19243c == ErrorMode.IMMEDIATE) {
                xj0Var.f19245e.cancel();
                xj0Var.f19241a.tryTerminateConsumer(xj0Var.f28585i);
                if (xj0Var.getAndIncrement() == 0) {
                    xj0Var.f19244d.clear();
                    return;
                }
                return;
            }
            xj0Var.f28588l = false;
            xj0Var.mo111c();
        }
    }

    @Override // io.reactivex.rxjava3.core.CompletableObserver
    public final void onSubscribe(Disposable disposable) {
        DisposableHelper.replace(this, disposable);
    }
}
