package p000;

import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class gu1 extends AtomicReference implements Observer {
    private static final long serialVersionUID = 2620149119579502636L;

    /* renamed from: a */
    public final Observer f17844a;

    /* renamed from: b */
    public final hu1 f17845b;

    public gu1(Observer observer, hu1 hu1Var) {
        this.f17844a = observer;
        this.f17845b = hu1Var;
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onComplete() {
        hu1 hu1Var = this.f17845b;
        hu1Var.f18191i = false;
        hu1Var.m5131a();
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onError(Throwable th) {
        hu1 hu1Var = this.f17845b;
        if (hu1Var.f18186d.tryAddThrowableOrReport(th)) {
            if (!hu1Var.f18188f) {
                hu1Var.f18190h.dispose();
            }
            hu1Var.f18191i = false;
            hu1Var.m5131a();
        }
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onNext(Object obj) {
        this.f17844a.onNext(obj);
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onSubscribe(Disposable disposable) {
        DisposableHelper.replace(this, disposable);
    }
}
