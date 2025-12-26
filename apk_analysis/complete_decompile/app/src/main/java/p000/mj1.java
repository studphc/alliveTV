package p000;

import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class mj1 extends AtomicReference implements MaybeObserver {
    private static final long serialVersionUID = -1266041316834525931L;

    /* renamed from: a */
    public final nj1 f22960a;

    public mj1(nj1 nj1Var) {
        this.f22960a = nj1Var;
    }

    @Override // io.reactivex.rxjava3.core.MaybeObserver
    public final void onComplete() {
        nj1 nj1Var = this.f22960a;
        nj1Var.getClass();
        if (DisposableHelper.dispose(nj1Var)) {
            nj1Var.f23381a.onComplete();
        }
    }

    @Override // io.reactivex.rxjava3.core.MaybeObserver
    public final void onError(Throwable th) {
        nj1 nj1Var = this.f22960a;
        nj1Var.getClass();
        if (DisposableHelper.dispose(nj1Var)) {
            nj1Var.f23381a.onError(th);
        } else {
            RxJavaPlugins.onError(th);
        }
    }

    @Override // io.reactivex.rxjava3.core.MaybeObserver
    public final void onSubscribe(Disposable disposable) {
        DisposableHelper.setOnce(this, disposable);
    }

    @Override // io.reactivex.rxjava3.core.MaybeObserver
    public final void onSuccess(Object obj) {
        nj1 nj1Var = this.f22960a;
        nj1Var.getClass();
        if (DisposableHelper.dispose(nj1Var)) {
            nj1Var.f23381a.onComplete();
        }
    }
}
