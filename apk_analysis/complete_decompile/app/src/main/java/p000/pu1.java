package p000;

import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class pu1 extends AtomicReference implements Observer {
    private static final long serialVersionUID = 2620149119579502636L;

    /* renamed from: a */
    public final Observer f25305a;

    /* renamed from: b */
    public final qu1 f25306b;

    public pu1(Observer observer, qu1 qu1Var) {
        this.f25305a = observer;
        this.f25306b = qu1Var;
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onComplete() {
        qu1 qu1Var = this.f25306b;
        qu1Var.f25764j = false;
        qu1Var.m7147a();
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onError(Throwable th) {
        qu1 qu1Var = this.f25306b;
        if (qu1Var.f25758d.tryAddThrowableOrReport(th)) {
            if (!qu1Var.f25760f) {
                qu1Var.f25763i.dispose();
            }
            qu1Var.f25764j = false;
            qu1Var.m7147a();
        }
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onNext(Object obj) {
        this.f25305a.onNext(obj);
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onSubscribe(Disposable disposable) {
        DisposableHelper.replace(this, disposable);
    }
}
