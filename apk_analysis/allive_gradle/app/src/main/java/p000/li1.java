package p000;

import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class li1 extends AtomicReference implements MaybeObserver {
    private static final long serialVersionUID = -3031974433025990931L;

    /* renamed from: a */
    public final ki1 f22511a;

    /* renamed from: b */
    public Object f22512b;

    public li1(ki1 ki1Var) {
        this.f22511a = ki1Var;
    }

    @Override // io.reactivex.rxjava3.core.MaybeObserver
    public final void onComplete() {
        this.f22511a.m5559a();
    }

    @Override // io.reactivex.rxjava3.core.MaybeObserver
    public final void onError(Throwable th) {
        ki1 ki1Var = this.f22511a;
        if (ki1Var.getAndSet(0) > 0) {
            li1 li1Var = ki1Var.f20860b;
            if (this == li1Var) {
                li1 li1Var2 = ki1Var.f20861c;
                li1Var2.getClass();
                DisposableHelper.dispose(li1Var2);
            } else {
                li1Var.getClass();
                DisposableHelper.dispose(li1Var);
            }
            ki1Var.f20859a.onError(th);
            return;
        }
        RxJavaPlugins.onError(th);
    }

    @Override // io.reactivex.rxjava3.core.MaybeObserver
    public final void onSubscribe(Disposable disposable) {
        DisposableHelper.setOnce(this, disposable);
    }

    @Override // io.reactivex.rxjava3.core.MaybeObserver
    public final void onSuccess(Object obj) {
        this.f22512b = obj;
        this.f22511a.m5559a();
    }
}
