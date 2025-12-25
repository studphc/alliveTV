package p000;

import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* renamed from: ys */
/* loaded from: classes2.dex */
public final class RunnableC2031ys extends AtomicReference implements CompletableObserver, Disposable, Runnable {
    private static final long serialVersionUID = 8571289934935992137L;

    /* renamed from: a */
    public final CompletableObserver f29115a;

    /* renamed from: b */
    public final Scheduler f29116b;

    /* renamed from: c */
    public Throwable f29117c;

    public RunnableC2031ys(CompletableObserver completableObserver, Scheduler scheduler) {
        this.f29115a = completableObserver;
        this.f29116b = scheduler;
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
        DisposableHelper.replace(this, this.f29116b.scheduleDirect(this));
    }

    @Override // io.reactivex.rxjava3.core.CompletableObserver
    public final void onError(Throwable th) {
        this.f29117c = th;
        DisposableHelper.replace(this, this.f29116b.scheduleDirect(this));
    }

    @Override // io.reactivex.rxjava3.core.CompletableObserver
    public final void onSubscribe(Disposable disposable) {
        if (DisposableHelper.setOnce(this, disposable)) {
            this.f29115a.onSubscribe(this);
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        Throwable th = this.f29117c;
        CompletableObserver completableObserver = this.f29115a;
        if (th != null) {
            this.f29117c = null;
            completableObserver.onError(th);
        } else {
            completableObserver.onComplete();
        }
    }
}
