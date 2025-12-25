package p000;

import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class vz1 extends AtomicReference implements Disposable, Runnable {
    private static final long serialVersionUID = -2809475196591179431L;

    /* renamed from: a */
    public final Observer f28018a;

    public vz1(Observer observer) {
        this.f28018a = observer;
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final void dispose() {
        DisposableHelper.dispose(this);
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final boolean isDisposed() {
        if (get() == DisposableHelper.DISPOSED) {
            return true;
        }
        return false;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (!isDisposed()) {
            Observer observer = this.f28018a;
            observer.onNext(0L);
            lazySet(EmptyDisposable.INSTANCE);
            observer.onComplete();
        }
    }
}
