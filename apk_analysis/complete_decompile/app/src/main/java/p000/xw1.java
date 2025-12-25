package p000;

import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.util.HalfSerializer;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class xw1 extends AtomicReference implements CompletableObserver {
    private static final long serialVersionUID = -2935427570954647017L;

    /* renamed from: a */
    public final yw1 f28753a;

    public xw1(yw1 yw1Var) {
        this.f28753a = yw1Var;
    }

    @Override // io.reactivex.rxjava3.core.CompletableObserver
    public final void onComplete() {
        yw1 yw1Var = this.f28753a;
        yw1Var.f29155f = true;
        if (yw1Var.f29154e) {
            HalfSerializer.onComplete((Observer<?>) yw1Var.f29150a, yw1Var, yw1Var.f29153d);
        }
    }

    @Override // io.reactivex.rxjava3.core.CompletableObserver
    public final void onError(Throwable th) {
        yw1 yw1Var = this.f28753a;
        DisposableHelper.dispose(yw1Var.f29151b);
        HalfSerializer.onError((Observer<?>) yw1Var.f29150a, th, yw1Var, yw1Var.f29153d);
    }

    @Override // io.reactivex.rxjava3.core.CompletableObserver
    public final void onSubscribe(Disposable disposable) {
        DisposableHelper.setOnce(this, disposable);
    }
}
