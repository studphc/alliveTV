package p000;

import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.observers.DisposableObserver;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;

/* loaded from: classes2.dex */
public final class a02 extends DisposableObserver {

    /* renamed from: b */
    public final b02 f7b;

    /* renamed from: c */
    public boolean f8c;

    public a02(b02 b02Var) {
        this.f7b = b02Var;
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onComplete() {
        if (this.f8c) {
            return;
        }
        this.f8c = true;
        b02 b02Var = this.f7b;
        DisposableHelper.dispose(b02Var.f7838d);
        b02Var.f7843i = true;
        b02Var.m2002a();
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onError(Throwable th) {
        if (this.f8c) {
            RxJavaPlugins.onError(th);
            return;
        }
        this.f8c = true;
        b02 b02Var = this.f7b;
        DisposableHelper.dispose(b02Var.f7838d);
        if (b02Var.f7841g.tryAddThrowableOrReport(th)) {
            b02Var.f7843i = true;
            b02Var.m2002a();
        }
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onNext(Object obj) {
        if (this.f8c) {
            return;
        }
        Object obj2 = b02.f7834k;
        b02 b02Var = this.f7b;
        b02Var.f7840f.offer(obj2);
        b02Var.m2002a();
    }
}
