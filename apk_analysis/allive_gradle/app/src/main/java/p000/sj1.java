package p000;

import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.MaybeSource;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class sj1 extends AtomicReference implements MaybeObserver, Disposable {
    private static final long serialVersionUID = -5955289211445418871L;

    /* renamed from: a */
    public final MaybeObserver f26452a;

    /* renamed from: b */
    public final tj1 f26453b = new tj1(this);

    /* renamed from: c */
    public final MaybeSource f26454c;

    /* renamed from: d */
    public final rj1 f26455d;

    public sj1(MaybeObserver maybeObserver, MaybeSource maybeSource) {
        rj1 rj1Var;
        this.f26452a = maybeObserver;
        this.f26454c = maybeSource;
        if (maybeSource != null) {
            rj1Var = new rj1(maybeObserver);
        } else {
            rj1Var = null;
        }
        this.f26455d = rj1Var;
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final void dispose() {
        DisposableHelper.dispose(this);
        DisposableHelper.dispose(this.f26453b);
        rj1 rj1Var = this.f26455d;
        if (rj1Var != null) {
            DisposableHelper.dispose(rj1Var);
        }
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final boolean isDisposed() {
        return DisposableHelper.isDisposed((Disposable) get());
    }

    @Override // io.reactivex.rxjava3.core.MaybeObserver
    public final void onComplete() {
        DisposableHelper.dispose(this.f26453b);
        DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
        if (getAndSet(disposableHelper) != disposableHelper) {
            this.f26452a.onComplete();
        }
    }

    @Override // io.reactivex.rxjava3.core.MaybeObserver
    public final void onError(Throwable th) {
        DisposableHelper.dispose(this.f26453b);
        DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
        if (getAndSet(disposableHelper) != disposableHelper) {
            this.f26452a.onError(th);
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
        DisposableHelper.dispose(this.f26453b);
        DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
        if (getAndSet(disposableHelper) != disposableHelper) {
            this.f26452a.onSuccess(obj);
        }
    }
}
