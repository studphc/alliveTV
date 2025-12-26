package p000;

import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.MaybeSource;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class tj1 extends AtomicReference implements MaybeObserver {
    private static final long serialVersionUID = 8663801314800248617L;

    /* renamed from: a */
    public final sj1 f26846a;

    public tj1(sj1 sj1Var) {
        this.f26846a = sj1Var;
    }

    @Override // io.reactivex.rxjava3.core.MaybeObserver
    public final void onComplete() {
        sj1 sj1Var = this.f26846a;
        sj1Var.getClass();
        if (DisposableHelper.dispose(sj1Var)) {
            MaybeSource maybeSource = sj1Var.f26454c;
            if (maybeSource == null) {
                sj1Var.f26452a.onError(new TimeoutException());
            } else {
                maybeSource.subscribe(sj1Var.f26455d);
            }
        }
    }

    @Override // io.reactivex.rxjava3.core.MaybeObserver
    public final void onError(Throwable th) {
        sj1 sj1Var = this.f26846a;
        sj1Var.getClass();
        if (DisposableHelper.dispose(sj1Var)) {
            sj1Var.f26452a.onError(th);
        } else {
            RxJavaPlugins.onError(th);
        }
    }

    @Override // io.reactivex.rxjava3.core.MaybeObserver
    public final void onSubscribe(Disposable disposable) {
        DisposableHelper.setOnce(this, disposable);
    }

    @Override // io.reactivex.rxjava3.core.MaybeObserver
    public final void onSuccess(Object obj) {
        sj1 sj1Var = this.f26846a;
        sj1Var.getClass();
        if (DisposableHelper.dispose(sj1Var)) {
            MaybeSource maybeSource = sj1Var.f26454c;
            if (maybeSource == null) {
                sj1Var.f26452a.onError(new TimeoutException());
            } else {
                maybeSource.subscribe(sj1Var.f26455d);
            }
        }
    }
}
