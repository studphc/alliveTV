package p000;

import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.util.ErrorMode;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class ku1 extends AtomicReference implements CompletableObserver {
    private static final long serialVersionUID = 5638352172918776687L;

    /* renamed from: a */
    public final lu1 f22210a;

    public ku1(lu1 lu1Var) {
        this.f22210a = lu1Var;
    }

    @Override // io.reactivex.rxjava3.core.CompletableObserver
    public final void onComplete() {
        lu1 lu1Var = this.f22210a;
        lu1Var.f22673k = false;
        lu1Var.mo5288c();
    }

    @Override // io.reactivex.rxjava3.core.CompletableObserver
    public final void onError(Throwable th) {
        lu1 lu1Var = this.f22210a;
        if (lu1Var.f19234a.tryAddThrowableOrReport(th)) {
            if (lu1Var.f19236c != ErrorMode.END) {
                lu1Var.f19238e.dispose();
            }
            lu1Var.f22673k = false;
            lu1Var.mo5288c();
        }
    }

    @Override // io.reactivex.rxjava3.core.CompletableObserver
    public final void onSubscribe(Disposable disposable) {
        DisposableHelper.replace(this, disposable);
    }
}
