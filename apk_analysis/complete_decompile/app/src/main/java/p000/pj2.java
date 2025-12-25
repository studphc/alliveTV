package p000;

import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class pj2 extends AtomicReference implements SingleObserver, Disposable, Runnable {
    private static final long serialVersionUID = 3528003840217436037L;

    /* renamed from: a */
    public final SingleObserver f25199a;

    /* renamed from: b */
    public final Scheduler f25200b;

    /* renamed from: c */
    public Object f25201c;

    /* renamed from: d */
    public Throwable f25202d;

    public pj2(SingleObserver singleObserver, Scheduler scheduler) {
        this.f25199a = singleObserver;
        this.f25200b = scheduler;
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final void dispose() {
        DisposableHelper.dispose(this);
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final boolean isDisposed() {
        return DisposableHelper.isDisposed((Disposable) get());
    }

    @Override // io.reactivex.rxjava3.core.SingleObserver
    public final void onError(Throwable th) {
        this.f25202d = th;
        DisposableHelper.replace(this, this.f25200b.scheduleDirect(this));
    }

    @Override // io.reactivex.rxjava3.core.SingleObserver
    public final void onSubscribe(Disposable disposable) {
        if (DisposableHelper.setOnce(this, disposable)) {
            this.f25199a.onSubscribe(this);
        }
    }

    @Override // io.reactivex.rxjava3.core.SingleObserver
    public final void onSuccess(Object obj) {
        this.f25201c = obj;
        DisposableHelper.replace(this, this.f25200b.scheduleDirect(this));
    }

    @Override // java.lang.Runnable
    public final void run() {
        Throwable th = this.f25202d;
        SingleObserver singleObserver = this.f25199a;
        if (th != null) {
            singleObserver.onError(th);
        } else {
            singleObserver.onSuccess(this.f25201c);
        }
    }
}
