package p000;

import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class gj1 extends AtomicReference implements MaybeObserver, Disposable, Runnable {
    private static final long serialVersionUID = 8571289934935992137L;

    /* renamed from: a */
    public final MaybeObserver f17718a;

    /* renamed from: b */
    public final Scheduler f17719b;

    /* renamed from: c */
    public Object f17720c;

    /* renamed from: d */
    public Throwable f17721d;

    public gj1(MaybeObserver maybeObserver, Scheduler scheduler) {
        this.f17718a = maybeObserver;
        this.f17719b = scheduler;
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final void dispose() {
        DisposableHelper.dispose(this);
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final boolean isDisposed() {
        return DisposableHelper.isDisposed((Disposable) get());
    }

    @Override // io.reactivex.rxjava3.core.MaybeObserver
    public final void onComplete() {
        DisposableHelper.replace(this, this.f17719b.scheduleDirect(this));
    }

    @Override // io.reactivex.rxjava3.core.MaybeObserver
    public final void onError(Throwable th) {
        this.f17721d = th;
        DisposableHelper.replace(this, this.f17719b.scheduleDirect(this));
    }

    @Override // io.reactivex.rxjava3.core.MaybeObserver
    public final void onSubscribe(Disposable disposable) {
        if (DisposableHelper.setOnce(this, disposable)) {
            this.f17718a.onSubscribe(this);
        }
    }

    @Override // io.reactivex.rxjava3.core.MaybeObserver
    public final void onSuccess(Object obj) {
        this.f17720c = obj;
        DisposableHelper.replace(this, this.f17719b.scheduleDirect(this));
    }

    @Override // java.lang.Runnable
    public final void run() {
        Throwable th = this.f17721d;
        MaybeObserver maybeObserver = this.f17718a;
        if (th != null) {
            this.f17721d = null;
            maybeObserver.onError(th);
            return;
        }
        Object obj = this.f17720c;
        if (obj != null) {
            this.f17720c = null;
            maybeObserver.onSuccess(obj);
        } else {
            maybeObserver.onComplete();
        }
    }
}
