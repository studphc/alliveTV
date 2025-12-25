package p000;

import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class zw1 extends AtomicReference implements MaybeObserver {
    private static final long serialVersionUID = -2935427570954647017L;

    /* renamed from: a */
    public final ax1 f29546a;

    public zw1(ax1 ax1Var) {
        this.f29546a = ax1Var;
    }

    @Override // io.reactivex.rxjava3.core.MaybeObserver
    public final void onComplete() {
        ax1 ax1Var = this.f29546a;
        ax1Var.f7787i = 2;
        if (ax1Var.getAndIncrement() == 0) {
            ax1Var.m1975a();
        }
    }

    @Override // io.reactivex.rxjava3.core.MaybeObserver
    public final void onError(Throwable th) {
        ax1 ax1Var = this.f29546a;
        if (ax1Var.f7782d.tryAddThrowableOrReport(th)) {
            DisposableHelper.dispose(ax1Var.f7780b);
            if (ax1Var.getAndIncrement() == 0) {
                ax1Var.m1975a();
            }
        }
    }

    @Override // io.reactivex.rxjava3.core.MaybeObserver
    public final void onSubscribe(Disposable disposable) {
        DisposableHelper.setOnce(this, disposable);
    }

    @Override // io.reactivex.rxjava3.core.MaybeObserver
    public final void onSuccess(Object obj) {
        ax1 ax1Var = this.f29546a;
        if (ax1Var.compareAndSet(0, 1)) {
            ax1Var.f7779a.onNext(obj);
            ax1Var.f7787i = 2;
        } else {
            ax1Var.f7784f = obj;
            ax1Var.f7787i = 1;
            if (ax1Var.getAndIncrement() != 0) {
                return;
            }
        }
        ax1Var.m1975a();
    }
}
