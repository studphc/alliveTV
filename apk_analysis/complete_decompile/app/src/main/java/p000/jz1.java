package p000;

import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.util.HalfSerializer;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class jz1 extends AtomicReference implements Observer {
    private static final long serialVersionUID = -8693423678067375039L;

    /* renamed from: a */
    public final /* synthetic */ kz1 f20695a;

    public jz1(kz1 kz1Var) {
        this.f20695a = kz1Var;
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onComplete() {
        kz1 kz1Var = this.f20695a;
        DisposableHelper.dispose(kz1Var.f22255b);
        HalfSerializer.onComplete((Observer<?>) kz1Var.f22254a, kz1Var, kz1Var.f22257d);
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onError(Throwable th) {
        kz1 kz1Var = this.f20695a;
        DisposableHelper.dispose(kz1Var.f22255b);
        HalfSerializer.onError((Observer<?>) kz1Var.f22254a, th, kz1Var, kz1Var.f22257d);
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onNext(Object obj) {
        DisposableHelper.dispose(this);
        kz1 kz1Var = this.f20695a;
        DisposableHelper.dispose(kz1Var.f22255b);
        HalfSerializer.onComplete((Observer<?>) kz1Var.f22254a, kz1Var, kz1Var.f22257d);
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onSubscribe(Disposable disposable) {
        DisposableHelper.setOnce(this, disposable);
    }
}
