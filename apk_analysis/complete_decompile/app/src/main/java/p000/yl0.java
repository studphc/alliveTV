package p000;

import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class yl0 extends AtomicReference implements CompletableObserver, Disposable {
    private static final long serialVersionUID = 8606673141535671828L;

    /* renamed from: a */
    public final /* synthetic */ zl0 f29012a;

    public yl0(zl0 zl0Var) {
        this.f29012a = zl0Var;
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
        zl0 zl0Var = this.f29012a;
        zl0Var.f29422e.delete(this);
        zl0Var.onComplete();
    }

    @Override // io.reactivex.rxjava3.core.CompletableObserver
    public final void onError(Throwable th) {
        zl0 zl0Var = this.f29012a;
        zl0Var.f29422e.delete(this);
        zl0Var.onError(th);
    }

    @Override // io.reactivex.rxjava3.core.CompletableObserver
    public final void onSubscribe(Disposable disposable) {
        DisposableHelper.setOnce(this, disposable);
    }
}
