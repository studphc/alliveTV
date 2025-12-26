package p000;

import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class yq0 extends AtomicReference implements SingleObserver {
    private static final long serialVersionUID = 8042919737683345351L;

    /* renamed from: a */
    public final zq0 f29063a;

    /* renamed from: b */
    public volatile Object f29064b;

    public yq0(zq0 zq0Var) {
        this.f29063a = zq0Var;
    }

    @Override // io.reactivex.rxjava3.core.SingleObserver
    public final void onError(Throwable th) {
        zq0 zq0Var = this.f29063a;
        AtomicReference atomicReference = zq0Var.f29471f;
        while (!atomicReference.compareAndSet(this, null)) {
            if (atomicReference.get() != this) {
                RxJavaPlugins.onError(th);
                return;
            }
        }
        if (zq0Var.f29469d.tryAddThrowableOrReport(th)) {
            if (!zq0Var.f29468c) {
                zq0Var.f29472g.cancel();
                zq0Var.m8422a();
            }
            zq0Var.m8423b();
        }
    }

    @Override // io.reactivex.rxjava3.core.SingleObserver
    public final void onSubscribe(Disposable disposable) {
        DisposableHelper.setOnce(this, disposable);
    }

    @Override // io.reactivex.rxjava3.core.SingleObserver
    public final void onSuccess(Object obj) {
        this.f29064b = obj;
        this.f29063a.m8423b();
    }
}
