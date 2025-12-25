package p000;

import io.reactivex.rxjava3.core.MaybeEmitter;
import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Cancellable;
import io.reactivex.rxjava3.internal.disposables.CancellableDisposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class zh1 extends AtomicReference implements MaybeEmitter, Disposable {
    private static final long serialVersionUID = -2467358622224974244L;

    /* renamed from: a */
    public final MaybeObserver f29376a;

    public zh1(MaybeObserver maybeObserver) {
        this.f29376a = maybeObserver;
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final void dispose() {
        DisposableHelper.dispose(this);
    }

    @Override // io.reactivex.rxjava3.core.MaybeEmitter, io.reactivex.rxjava3.disposables.Disposable
    public final boolean isDisposed() {
        return DisposableHelper.isDisposed((Disposable) get());
    }

    @Override // io.reactivex.rxjava3.core.MaybeEmitter
    public final void onComplete() {
        Disposable disposable;
        Object obj = get();
        DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
        if (obj != disposableHelper && (disposable = (Disposable) getAndSet(disposableHelper)) != disposableHelper) {
            try {
                this.f29376a.onComplete();
            } finally {
                if (disposable != null) {
                    disposable.dispose();
                }
            }
        }
    }

    @Override // io.reactivex.rxjava3.core.MaybeEmitter
    public final void onError(Throwable th) {
        if (!tryOnError(th)) {
            RxJavaPlugins.onError(th);
        }
    }

    @Override // io.reactivex.rxjava3.core.MaybeEmitter
    public final void onSuccess(Object obj) {
        Disposable disposable;
        Object obj2 = get();
        DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
        if (obj2 != disposableHelper && (disposable = (Disposable) getAndSet(disposableHelper)) != disposableHelper) {
            MaybeObserver maybeObserver = this.f29376a;
            try {
                if (obj == null) {
                    maybeObserver.onError(ExceptionHelper.createNullPointerException("onSuccess called with a null value."));
                } else {
                    maybeObserver.onSuccess(obj);
                }
                if (disposable != null) {
                    disposable.dispose();
                }
            } catch (Throwable th) {
                if (disposable != null) {
                    disposable.dispose();
                }
                throw th;
            }
        }
    }

    @Override // io.reactivex.rxjava3.core.MaybeEmitter
    public final void setCancellable(Cancellable cancellable) {
        DisposableHelper.set(this, new CancellableDisposable(cancellable));
    }

    @Override // io.reactivex.rxjava3.core.MaybeEmitter
    public final void setDisposable(Disposable disposable) {
        DisposableHelper.set(this, disposable);
    }

    @Override // java.util.concurrent.atomic.AtomicReference
    public final String toString() {
        return zh1.class.getSimpleName() + "{" + super.toString() + "}";
    }

    @Override // io.reactivex.rxjava3.core.MaybeEmitter
    public final boolean tryOnError(Throwable th) {
        Disposable disposable;
        if (th == null) {
            th = ExceptionHelper.createNullPointerException("onError called with a null Throwable.");
        }
        Object obj = get();
        DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
        if (obj != disposableHelper && (disposable = (Disposable) getAndSet(disposableHelper)) != disposableHelper) {
            try {
                this.f29376a.onError(th);
            } finally {
                if (disposable != null) {
                    disposable.dispose();
                }
            }
        }
        return false;
    }
}
