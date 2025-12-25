package p000;

import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.util.HalfSerializer;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class px1 extends AtomicReference implements Observer {
    private static final long serialVersionUID = 3254781284376480842L;

    /* renamed from: a */
    public final /* synthetic */ qx1 f25331a;

    public px1(qx1 qx1Var) {
        this.f25331a = qx1Var;
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onComplete() {
        qx1 qx1Var = this.f25331a;
        DisposableHelper.dispose(qx1Var.f25793f);
        HalfSerializer.onComplete((Observer<?>) qx1Var.f25788a, qx1Var, qx1Var.f25790c);
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onError(Throwable th) {
        qx1 qx1Var = this.f25331a;
        DisposableHelper.dispose(qx1Var.f25793f);
        HalfSerializer.onError((Observer<?>) qx1Var.f25788a, th, qx1Var, qx1Var.f25790c);
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onNext(Object obj) {
        this.f25331a.m7150a();
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onSubscribe(Disposable disposable) {
        DisposableHelper.setOnce(this, disposable);
    }
}
