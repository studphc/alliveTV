package p000;

import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.util.ErrorMode;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class zj0 extends AtomicReference implements MaybeObserver {
    private static final long serialVersionUID = -3051469169682093892L;

    /* renamed from: a */
    public final ak0 f29400a;

    public zj0(ak0 ak0Var) {
        this.f29400a = ak0Var;
    }

    @Override // io.reactivex.rxjava3.core.MaybeObserver
    public final void onComplete() {
        ak0 ak0Var = this.f29400a;
        ak0Var.f241p = 0;
        ak0Var.mo111c();
    }

    @Override // io.reactivex.rxjava3.core.MaybeObserver
    public final void onError(Throwable th) {
        ak0 ak0Var = this.f29400a;
        if (ak0Var.f19241a.tryAddThrowableOrReport(th)) {
            if (ak0Var.f19243c != ErrorMode.END) {
                ak0Var.f19245e.cancel();
            }
            ak0Var.f241p = 0;
            ak0Var.mo111c();
        }
    }

    @Override // io.reactivex.rxjava3.core.MaybeObserver
    public final void onSubscribe(Disposable disposable) {
        DisposableHelper.replace(this, disposable);
    }

    @Override // io.reactivex.rxjava3.core.MaybeObserver
    public final void onSuccess(Object obj) {
        ak0 ak0Var = this.f29400a;
        ak0Var.f240o = obj;
        ak0Var.f241p = 2;
        ak0Var.mo111c();
    }
}
