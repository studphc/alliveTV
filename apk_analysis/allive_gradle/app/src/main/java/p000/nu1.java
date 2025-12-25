package p000;

import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.util.ErrorMode;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class nu1 extends AtomicReference implements MaybeObserver {
    private static final long serialVersionUID = -3051469169682093892L;

    /* renamed from: a */
    public final ou1 f23502a;

    public nu1(ou1 ou1Var) {
        this.f23502a = ou1Var;
    }

    @Override // io.reactivex.rxjava3.core.MaybeObserver
    public final void onComplete() {
        ou1 ou1Var = this.f23502a;
        ou1Var.f24916l = 0;
        ou1Var.mo5288c();
    }

    @Override // io.reactivex.rxjava3.core.MaybeObserver
    public final void onError(Throwable th) {
        ou1 ou1Var = this.f23502a;
        if (ou1Var.f19234a.tryAddThrowableOrReport(th)) {
            if (ou1Var.f19236c != ErrorMode.END) {
                ou1Var.f19238e.dispose();
            }
            ou1Var.f24916l = 0;
            ou1Var.mo5288c();
        }
    }

    @Override // io.reactivex.rxjava3.core.MaybeObserver
    public final void onSubscribe(Disposable disposable) {
        DisposableHelper.replace(this, disposable);
    }

    @Override // io.reactivex.rxjava3.core.MaybeObserver
    public final void onSuccess(Object obj) {
        ou1 ou1Var = this.f23502a;
        ou1Var.f24915k = obj;
        ou1Var.f24916l = 2;
        ou1Var.mo5288c();
    }
}
