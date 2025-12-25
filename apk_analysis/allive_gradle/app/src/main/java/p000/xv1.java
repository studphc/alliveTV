package p000;

import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class xv1 extends AtomicReference implements CompletableObserver, Disposable {
    private static final long serialVersionUID = 8606673141535671828L;

    /* renamed from: a */
    public final /* synthetic */ yv1 f28744a;

    public xv1(yv1 yv1Var) {
        this.f28744a = yv1Var;
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final void dispose() {
        DisposableHelper.dispose(this);
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final boolean isDisposed() {
        return DisposableHelper.isDisposed((Disposable) get());
    }

    @Override // io.reactivex.rxjava3.core.CompletableObserver
    public final void onComplete() {
        yv1 yv1Var = this.f28744a;
        yv1Var.f29144e.delete(this);
        yv1Var.onComplete();
    }

    @Override // io.reactivex.rxjava3.core.CompletableObserver
    public final void onError(Throwable th) {
        yv1 yv1Var = this.f28744a;
        yv1Var.f29144e.delete(this);
        yv1Var.onError(th);
    }

    @Override // io.reactivex.rxjava3.core.CompletableObserver
    public final void onSubscribe(Disposable disposable) {
        DisposableHelper.setOnce(this, disposable);
    }
}
