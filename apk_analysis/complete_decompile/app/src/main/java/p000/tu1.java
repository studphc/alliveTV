package p000;

import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.util.ErrorMode;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class tu1 extends AtomicReference implements SingleObserver {
    private static final long serialVersionUID = -3051469169682093892L;

    /* renamed from: a */
    public final uu1 f26965a;

    public tu1(uu1 uu1Var) {
        this.f26965a = uu1Var;
    }

    @Override // io.reactivex.rxjava3.core.SingleObserver
    public final void onError(Throwable th) {
        uu1 uu1Var = this.f26965a;
        if (uu1Var.f19234a.tryAddThrowableOrReport(th)) {
            if (uu1Var.f19236c != ErrorMode.END) {
                uu1Var.f19238e.dispose();
            }
            uu1Var.f27455l = 0;
            uu1Var.mo5288c();
        }
    }

    @Override // io.reactivex.rxjava3.core.SingleObserver
    public final void onSubscribe(Disposable disposable) {
        DisposableHelper.replace(this, disposable);
    }

    @Override // io.reactivex.rxjava3.core.SingleObserver
    public final void onSuccess(Object obj) {
        uu1 uu1Var = this.f26965a;
        uu1Var.f27454k = obj;
        uu1Var.f27455l = 2;
        uu1Var.mo5288c();
    }
}
