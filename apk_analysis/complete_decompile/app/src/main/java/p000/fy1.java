package p000;

import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.util.HalfSerializer;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class fy1 extends AtomicReference implements Observer {
    private static final long serialVersionUID = 3254781284376480842L;

    /* renamed from: a */
    public final /* synthetic */ gy1 f17448a;

    public fy1(gy1 gy1Var) {
        this.f17448a = gy1Var;
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onComplete() {
        gy1 gy1Var = this.f17448a;
        DisposableHelper.dispose(gy1Var.f17882f);
        HalfSerializer.onComplete((Observer<?>) gy1Var.f17877a, gy1Var, gy1Var.f17879c);
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onError(Throwable th) {
        gy1 gy1Var = this.f17448a;
        DisposableHelper.dispose(gy1Var.f17882f);
        HalfSerializer.onError((Observer<?>) gy1Var.f17877a, th, gy1Var, gy1Var.f17879c);
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onNext(Object obj) {
        this.f17448a.m5026a();
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onSubscribe(Disposable disposable) {
        DisposableHelper.setOnce(this, disposable);
    }
}
