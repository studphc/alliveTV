package p000;

import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class xj1 extends AtomicReference implements Disposable, Runnable {
    private static final long serialVersionUID = 2875964065294031672L;

    /* renamed from: a */
    public final MaybeObserver f28590a;

    public xj1(MaybeObserver maybeObserver) {
        this.f28590a = maybeObserver;
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
        this.f28590a.onSuccess(0L);
    }
}
