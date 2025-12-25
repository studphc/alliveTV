package p000;

import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* renamed from: ht */
/* loaded from: classes2.dex */
public final class RunnableC1281ht extends AtomicReference implements Disposable, Runnable {
    private static final long serialVersionUID = 3167244060586201109L;

    /* renamed from: a */
    public final CompletableObserver f18164a;

    public RunnableC1281ht(CompletableObserver completableObserver) {
        this.f18164a = completableObserver;
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
        this.f18164a.onComplete();
    }
}
