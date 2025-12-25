package p000;

import io.reactivex.rxjava3.core.ObservableEmitter;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Cancellable;
import io.reactivex.rxjava3.internal.disposables.CancellableDisposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class zu1 extends AtomicReference implements ObservableEmitter, Disposable {
    private static final long serialVersionUID = -3434801548987643227L;

    /* renamed from: a */
    public final Observer f29524a;

    public zu1(Observer observer) {
        this.f29524a = observer;
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final void dispose() {
        DisposableHelper.dispose(this);
    }

    @Override // io.reactivex.rxjava3.core.ObservableEmitter
    public final boolean isDisposed() {
        return DisposableHelper.isDisposed((Disposable) get());
    }

    @Override // io.reactivex.rxjava3.core.Emitter
    public final void onComplete() {
        if (!isDisposed()) {
            try {
                this.f29524a.onComplete();
            } finally {
                DisposableHelper.dispose(this);
            }
        }
    }

    @Override // io.reactivex.rxjava3.core.Emitter
    public final void onError(Throwable th) {
        if (!tryOnError(th)) {
            RxJavaPlugins.onError(th);
        }
    }

    @Override // io.reactivex.rxjava3.core.Emitter
    public final void onNext(Object obj) {
        if (obj == null) {
            onError(ExceptionHelper.createNullPointerException("onNext called with a null value."));
        } else if (!isDisposed()) {
            this.f29524a.onNext(obj);
        }
    }

    @Override // io.reactivex.rxjava3.core.ObservableEmitter
    public final ObservableEmitter serialize() {
        return new av1(this);
    }

    @Override // io.reactivex.rxjava3.core.ObservableEmitter
    public final void setCancellable(Cancellable cancellable) {
        DisposableHelper.set(this, new CancellableDisposable(cancellable));
    }

    @Override // io.reactivex.rxjava3.core.ObservableEmitter
    public final void setDisposable(Disposable disposable) {
        DisposableHelper.set(this, disposable);
    }

    @Override // java.util.concurrent.atomic.AtomicReference
    public final String toString() {
        return zu1.class.getSimpleName() + "{" + super.toString() + "}";
    }

    @Override // io.reactivex.rxjava3.core.ObservableEmitter
    public final boolean tryOnError(Throwable th) {
        if (th == null) {
            th = ExceptionHelper.createNullPointerException("onError called with a null Throwable.");
        }
        if (!isDisposed()) {
            try {
                this.f29524a.onError(th);
                DisposableHelper.dispose(this);
                return true;
            } catch (Throwable th2) {
                DisposableHelper.dispose(this);
                throw th2;
            }
        }
        return false;
    }
}
