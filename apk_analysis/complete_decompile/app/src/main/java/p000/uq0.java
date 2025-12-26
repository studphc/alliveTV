package p000;

import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class uq0 extends AtomicReference implements CompletableObserver {
    private static final long serialVersionUID = -8003404460084760287L;

    /* renamed from: a */
    public final vq0 f27409a;

    public uq0(vq0 vq0Var) {
        this.f27409a = vq0Var;
    }

    @Override // io.reactivex.rxjava3.core.CompletableObserver
    public final void onComplete() {
        vq0 vq0Var = this.f27409a;
        AtomicReference atomicReference = vq0Var.f27924e;
        while (!atomicReference.compareAndSet(this, null)) {
            if (atomicReference.get() != this) {
                return;
            }
        }
        if (vq0Var.f27925f) {
            vq0Var.f27923d.tryTerminateConsumer(vq0Var.f27920a);
        }
    }

    @Override // io.reactivex.rxjava3.core.CompletableObserver
    public final void onError(Throwable th) {
        vq0 vq0Var = this.f27409a;
        AtomicReference atomicReference = vq0Var.f27924e;
        while (!atomicReference.compareAndSet(this, null)) {
            if (atomicReference.get() != this) {
                RxJavaPlugins.onError(th);
                return;
            }
        }
        if (vq0Var.f27923d.tryAddThrowableOrReport(th)) {
            if (vq0Var.f27922c) {
                if (vq0Var.f27925f) {
                    vq0Var.f27923d.tryTerminateConsumer(vq0Var.f27920a);
                }
            } else {
                vq0Var.f27926g.cancel();
                vq0Var.m7929a();
                vq0Var.f27923d.tryTerminateConsumer(vq0Var.f27920a);
            }
        }
    }

    @Override // io.reactivex.rxjava3.core.CompletableObserver
    public final void onSubscribe(Disposable disposable) {
        DisposableHelper.setOnce(this, disposable);
    }
}
