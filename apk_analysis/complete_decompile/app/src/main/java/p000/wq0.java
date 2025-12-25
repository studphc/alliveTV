package p000;

import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class wq0 extends AtomicReference implements MaybeObserver {
    private static final long serialVersionUID = 8042919737683345351L;

    /* renamed from: a */
    public final xq0 f28282a;

    /* renamed from: b */
    public volatile Object f28283b;

    public wq0(xq0 xq0Var) {
        this.f28282a = xq0Var;
    }

    @Override // io.reactivex.rxjava3.core.MaybeObserver
    public final void onComplete() {
        xq0 xq0Var = this.f28282a;
        AtomicReference atomicReference = xq0Var.f28691f;
        while (!atomicReference.compareAndSet(this, null)) {
            if (atomicReference.get() != this) {
                return;
            }
        }
        xq0Var.m8178b();
    }

    @Override // io.reactivex.rxjava3.core.MaybeObserver
    public final void onError(Throwable th) {
        xq0 xq0Var = this.f28282a;
        AtomicReference atomicReference = xq0Var.f28691f;
        while (!atomicReference.compareAndSet(this, null)) {
            if (atomicReference.get() != this) {
                RxJavaPlugins.onError(th);
                return;
            }
        }
        if (xq0Var.f28689d.tryAddThrowableOrReport(th)) {
            if (!xq0Var.f28688c) {
                xq0Var.f28692g.cancel();
                xq0Var.m8177a();
            }
            xq0Var.m8178b();
        }
    }

    @Override // io.reactivex.rxjava3.core.MaybeObserver
    public final void onSubscribe(Disposable disposable) {
        DisposableHelper.setOnce(this, disposable);
    }

    @Override // io.reactivex.rxjava3.core.MaybeObserver
    public final void onSuccess(Object obj) {
        this.f28283b = obj;
        this.f28282a.m8178b();
    }
}
