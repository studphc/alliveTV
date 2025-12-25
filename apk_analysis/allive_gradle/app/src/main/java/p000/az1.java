package p000;

import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class az1 extends AtomicReference implements CompletableObserver {
    private static final long serialVersionUID = -8003404460084760287L;

    /* renamed from: a */
    public final bz1 f7819a;

    public az1(bz1 bz1Var) {
        this.f7819a = bz1Var;
    }

    @Override // io.reactivex.rxjava3.core.CompletableObserver
    public final void onComplete() {
        bz1 bz1Var = this.f7819a;
        AtomicReference atomicReference = bz1Var.f8207e;
        while (!atomicReference.compareAndSet(this, null)) {
            if (atomicReference.get() != this) {
                return;
            }
        }
        if (bz1Var.f8208f) {
            bz1Var.f8206d.tryTerminateConsumer(bz1Var.f8203a);
        }
    }

    @Override // io.reactivex.rxjava3.core.CompletableObserver
    public final void onError(Throwable th) {
        bz1 bz1Var = this.f7819a;
        AtomicReference atomicReference = bz1Var.f8207e;
        while (!atomicReference.compareAndSet(this, null)) {
            if (atomicReference.get() != this) {
                RxJavaPlugins.onError(th);
                return;
            }
        }
        if (bz1Var.f8206d.tryAddThrowableOrReport(th)) {
            if (bz1Var.f8205c) {
                if (bz1Var.f8208f) {
                    bz1Var.f8206d.tryTerminateConsumer(bz1Var.f8203a);
                }
            } else {
                bz1Var.f8209g.dispose();
                bz1Var.m2178a();
                bz1Var.f8206d.tryTerminateConsumer(bz1Var.f8203a);
            }
        }
    }

    @Override // io.reactivex.rxjava3.core.CompletableObserver
    public final void onSubscribe(Disposable disposable) {
        DisposableHelper.setOnce(this, disposable);
    }
}
