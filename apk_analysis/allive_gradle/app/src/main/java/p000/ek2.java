package p000;

import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class ek2 extends AtomicReference implements SingleObserver, Disposable, Runnable {
    private static final long serialVersionUID = 3256698449646456986L;

    /* renamed from: a */
    public final SingleObserver f16859a;

    /* renamed from: b */
    public final Scheduler f16860b;

    /* renamed from: c */
    public Disposable f16861c;

    public ek2(SingleObserver singleObserver, Scheduler scheduler) {
        this.f16859a = singleObserver;
        this.f16860b = scheduler;
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final void dispose() {
        DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
        Disposable disposable = (Disposable) getAndSet(disposableHelper);
        if (disposable != disposableHelper) {
            this.f16861c = disposable;
            this.f16860b.scheduleDirect(this);
        }
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final boolean isDisposed() {
        return DisposableHelper.isDisposed((Disposable) get());
    }

    @Override // io.reactivex.rxjava3.core.SingleObserver
    public final void onError(Throwable th) {
        this.f16859a.onError(th);
    }

    @Override // io.reactivex.rxjava3.core.SingleObserver
    public final void onSubscribe(Disposable disposable) {
        if (DisposableHelper.setOnce(this, disposable)) {
            this.f16859a.onSubscribe(this);
        }
    }

    @Override // io.reactivex.rxjava3.core.SingleObserver
    public final void onSuccess(Object obj) {
        this.f16859a.onSuccess(obj);
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f16861c.dispose();
    }
}
