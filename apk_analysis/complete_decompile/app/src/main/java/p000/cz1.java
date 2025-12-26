package p000;

import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class cz1 extends AtomicReference implements MaybeObserver {
    private static final long serialVersionUID = 8042919737683345351L;

    /* renamed from: a */
    public final dz1 f16185a;

    /* renamed from: b */
    public volatile Object f16186b;

    public cz1(dz1 dz1Var) {
        this.f16185a = dz1Var;
    }

    @Override // io.reactivex.rxjava3.core.MaybeObserver
    public final void onComplete() {
        dz1 dz1Var = this.f16185a;
        AtomicReference atomicReference = dz1Var.f16624e;
        while (!atomicReference.compareAndSet(this, null)) {
            if (atomicReference.get() != this) {
                return;
            }
        }
        dz1Var.m4649b();
    }

    @Override // io.reactivex.rxjava3.core.MaybeObserver
    public final void onError(Throwable th) {
        dz1 dz1Var = this.f16185a;
        AtomicReference atomicReference = dz1Var.f16624e;
        while (!atomicReference.compareAndSet(this, null)) {
            if (atomicReference.get() != this) {
                RxJavaPlugins.onError(th);
                return;
            }
        }
        if (dz1Var.f16623d.tryAddThrowableOrReport(th)) {
            if (!dz1Var.f16622c) {
                dz1Var.f16625f.dispose();
                dz1Var.m4648a();
            }
            dz1Var.m4649b();
        }
    }

    @Override // io.reactivex.rxjava3.core.MaybeObserver
    public final void onSubscribe(Disposable disposable) {
        DisposableHelper.setOnce(this, disposable);
    }

    @Override // io.reactivex.rxjava3.core.MaybeObserver
    public final void onSuccess(Object obj) {
        this.f16186b = obj;
        this.f16185a.m4649b();
    }
}
