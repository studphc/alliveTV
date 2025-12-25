package p000;

import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class vv1 extends AtomicReference implements CompletableObserver, Disposable {
    private static final long serialVersionUID = 8606673141535671828L;

    /* renamed from: a */
    public final /* synthetic */ wv1 f27978a;

    public vv1(wv1 wv1Var) {
        this.f27978a = wv1Var;
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
        wv1 wv1Var = this.f27978a;
        wv1Var.f28350e.delete(this);
        wv1Var.onComplete();
    }

    @Override // io.reactivex.rxjava3.core.CompletableObserver
    public final void onError(Throwable th) {
        wv1 wv1Var = this.f27978a;
        wv1Var.f28350e.delete(this);
        wv1Var.onError(th);
    }

    @Override // io.reactivex.rxjava3.core.CompletableObserver
    public final void onSubscribe(Disposable disposable) {
        DisposableHelper.setOnce(this, disposable);
    }
}
