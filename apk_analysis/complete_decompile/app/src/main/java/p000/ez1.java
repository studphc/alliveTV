package p000;

import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class ez1 extends AtomicReference implements SingleObserver {
    private static final long serialVersionUID = 8042919737683345351L;

    /* renamed from: a */
    public final fz1 f17046a;

    /* renamed from: b */
    public volatile Object f17047b;

    public ez1(fz1 fz1Var) {
        this.f17046a = fz1Var;
    }

    @Override // io.reactivex.rxjava3.core.SingleObserver
    public final void onError(Throwable th) {
        fz1 fz1Var = this.f17046a;
        AtomicReference atomicReference = fz1Var.f17490e;
        while (!atomicReference.compareAndSet(this, null)) {
            if (atomicReference.get() != this) {
                RxJavaPlugins.onError(th);
                return;
            }
        }
        if (fz1Var.f17489d.tryAddThrowableOrReport(th)) {
            if (!fz1Var.f17488c) {
                fz1Var.f17491f.dispose();
                fz1Var.m4891a();
            }
            fz1Var.m4892b();
        }
    }

    @Override // io.reactivex.rxjava3.core.SingleObserver
    public final void onSubscribe(Disposable disposable) {
        DisposableHelper.setOnce(this, disposable);
    }

    @Override // io.reactivex.rxjava3.core.SingleObserver
    public final void onSuccess(Object obj) {
        this.f17047b = obj;
        this.f17046a.m4892b();
    }
}
