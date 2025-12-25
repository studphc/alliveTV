package p000;

import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class ai1 extends AtomicReference implements MaybeObserver, Disposable, Runnable {
    private static final long serialVersionUID = 5566860102500855068L;

    /* renamed from: a */
    public final MaybeObserver f208a;

    /* renamed from: b */
    public final long f209b;

    /* renamed from: c */
    public final TimeUnit f210c;

    /* renamed from: d */
    public final Scheduler f211d;

    /* renamed from: e */
    public final boolean f212e;

    /* renamed from: f */
    public Object f213f;

    /* renamed from: g */
    public Throwable f214g;

    public ai1(MaybeObserver maybeObserver, long j, TimeUnit timeUnit, Scheduler scheduler, boolean z) {
        this.f208a = maybeObserver;
        this.f209b = j;
        this.f210c = timeUnit;
        this.f211d = scheduler;
        this.f212e = z;
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
        DisposableHelper.replace(this, this.f211d.scheduleDirect(this, this.f209b, this.f210c));
    }

    @Override // io.reactivex.rxjava3.core.MaybeObserver
    public final void onError(Throwable th) {
        long j;
        this.f214g = th;
        if (this.f212e) {
            j = this.f209b;
        } else {
            j = 0;
        }
        DisposableHelper.replace(this, this.f211d.scheduleDirect(this, j, this.f210c));
    }

    @Override // io.reactivex.rxjava3.core.MaybeObserver
    public final void onSubscribe(Disposable disposable) {
        if (DisposableHelper.setOnce(this, disposable)) {
            this.f208a.onSubscribe(this);
        }
    }

    @Override // io.reactivex.rxjava3.core.MaybeObserver
    public final void onSuccess(Object obj) {
        this.f213f = obj;
        DisposableHelper.replace(this, this.f211d.scheduleDirect(this, this.f209b, this.f210c));
    }

    @Override // java.lang.Runnable
    public final void run() {
        Throwable th = this.f214g;
        MaybeObserver maybeObserver = this.f208a;
        if (th != null) {
            maybeObserver.onError(th);
            return;
        }
        Object obj = this.f213f;
        if (obj != null) {
            maybeObserver.onSuccess(obj);
        } else {
            maybeObserver.onComplete();
        }
    }
}
