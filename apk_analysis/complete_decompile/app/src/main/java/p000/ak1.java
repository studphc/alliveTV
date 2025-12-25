package p000;

import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class ak1 extends AtomicReference implements MaybeObserver, Disposable, Runnable {
    private static final long serialVersionUID = 3256698449646456986L;

    /* renamed from: a */
    public final MaybeObserver f242a;

    /* renamed from: b */
    public final Scheduler f243b;

    /* renamed from: c */
    public Disposable f244c;

    public ak1(MaybeObserver maybeObserver, Scheduler scheduler) {
        this.f242a = maybeObserver;
        this.f243b = scheduler;
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final void dispose() {
        DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
        Disposable disposable = (Disposable) getAndSet(disposableHelper);
        if (disposable != disposableHelper) {
            this.f244c = disposable;
            this.f243b.scheduleDirect(this);
        }
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final boolean isDisposed() {
        return DisposableHelper.isDisposed((Disposable) get());
    }

    @Override // io.reactivex.rxjava3.core.MaybeObserver
    public final void onComplete() {
        this.f242a.onComplete();
    }

    @Override // io.reactivex.rxjava3.core.MaybeObserver
    public final void onError(Throwable th) {
        this.f242a.onError(th);
    }

    @Override // io.reactivex.rxjava3.core.MaybeObserver
    public final void onSubscribe(Disposable disposable) {
        if (DisposableHelper.setOnce(this, disposable)) {
            this.f242a.onSubscribe(this);
        }
    }

    @Override // io.reactivex.rxjava3.core.MaybeObserver
    public final void onSuccess(Object obj) {
        this.f242a.onSuccess(obj);
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f244c.dispose();
    }
}
