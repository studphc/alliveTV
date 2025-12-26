package p000;

import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* renamed from: ks */
/* loaded from: classes2.dex */
public final class RunnableC1485ks extends AtomicReference implements CompletableObserver, Runnable, Disposable {
    private static final long serialVersionUID = 465972761105851022L;

    /* renamed from: a */
    public final CompletableObserver f22172a;

    /* renamed from: b */
    public final long f22173b;

    /* renamed from: c */
    public final TimeUnit f22174c;

    /* renamed from: d */
    public final Scheduler f22175d;

    /* renamed from: e */
    public final boolean f22176e;

    /* renamed from: f */
    public Throwable f22177f;

    public RunnableC1485ks(CompletableObserver completableObserver, long j, TimeUnit timeUnit, Scheduler scheduler, boolean z) {
        this.f22172a = completableObserver;
        this.f22173b = j;
        this.f22174c = timeUnit;
        this.f22175d = scheduler;
        this.f22176e = z;
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
        DisposableHelper.replace(this, this.f22175d.scheduleDirect(this, this.f22173b, this.f22174c));
    }

    @Override // io.reactivex.rxjava3.core.CompletableObserver
    public final void onError(Throwable th) {
        long j;
        this.f22177f = th;
        if (this.f22176e) {
            j = this.f22173b;
        } else {
            j = 0;
        }
        DisposableHelper.replace(this, this.f22175d.scheduleDirect(this, j, this.f22174c));
    }

    @Override // io.reactivex.rxjava3.core.CompletableObserver
    public final void onSubscribe(Disposable disposable) {
        if (DisposableHelper.setOnce(this, disposable)) {
            this.f22172a.onSubscribe(this);
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        Throwable th = this.f22177f;
        this.f22177f = null;
        CompletableObserver completableObserver = this.f22172a;
        if (th != null) {
            completableObserver.onError(th);
        } else {
            completableObserver.onComplete();
        }
    }
}
