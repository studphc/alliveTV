package p000;

import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class bk2 extends AtomicReference implements Disposable, Runnable {
    private static final long serialVersionUID = 8465401857522493082L;

    /* renamed from: a */
    public final SingleObserver f8057a;

    public bk2(SingleObserver singleObserver) {
        this.f8057a = singleObserver;
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final void dispose() {
        DisposableHelper.dispose(this);
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final boolean isDisposed() {
        return DisposableHelper.isDisposed((Disposable) get());
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f8057a.onSuccess(0L);
    }
}
