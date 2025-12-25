package p000;

import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class e02 extends AtomicReference implements Observer {
    private static final long serialVersionUID = -3326496781427702834L;

    /* renamed from: a */
    public final f02 f16637a;

    public e02(f02 f02Var) {
        this.f16637a = f02Var;
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onComplete() {
        f02 f02Var = this.f16637a;
        f02Var.f17068m = true;
        f02Var.m4764a();
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onError(Throwable th) {
        f02 f02Var = this.f16637a;
        f02Var.f17070o.dispose();
        f02Var.f17060e.dispose();
        if (f02Var.f17069n.tryAddThrowableOrReport(th)) {
            f02Var.f17067l = true;
            f02Var.m4764a();
        }
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onNext(Object obj) {
        f02 f02Var = this.f16637a;
        f02Var.f17063h.offer(new d02(obj));
        f02Var.m4764a();
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onSubscribe(Disposable disposable) {
        DisposableHelper.setOnce(this, disposable);
    }
}
