package p000;

import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.util.ErrorMode;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class fk0 extends AtomicReference implements SingleObserver {
    private static final long serialVersionUID = -3051469169682093892L;

    /* renamed from: a */
    public final gk0 f17300a;

    public fk0(gk0 gk0Var) {
        this.f17300a = gk0Var;
    }

    @Override // io.reactivex.rxjava3.core.SingleObserver
    public final void onError(Throwable th) {
        gk0 gk0Var = this.f17300a;
        if (gk0Var.f19241a.tryAddThrowableOrReport(th)) {
            if (gk0Var.f19243c != ErrorMode.END) {
                gk0Var.f19245e.cancel();
            }
            gk0Var.f17737p = 0;
            gk0Var.mo111c();
        }
    }

    @Override // io.reactivex.rxjava3.core.SingleObserver
    public final void onSubscribe(Disposable disposable) {
        DisposableHelper.replace(this, disposable);
    }

    @Override // io.reactivex.rxjava3.core.SingleObserver
    public final void onSuccess(Object obj) {
        gk0 gk0Var = this.f17300a;
        gk0Var.f17736o = obj;
        gk0Var.f17737p = 2;
        gk0Var.mo111c();
    }
}
