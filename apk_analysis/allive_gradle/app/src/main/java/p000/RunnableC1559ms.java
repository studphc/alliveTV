package p000;

import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;

/* renamed from: ms */
/* loaded from: classes2.dex */
public final class RunnableC1559ms implements CompletableObserver, Disposable, Runnable {

    /* renamed from: a */
    public final CompletableObserver f23089a;

    /* renamed from: b */
    public final Scheduler f23090b;

    /* renamed from: c */
    public Disposable f23091c;

    /* renamed from: d */
    public volatile boolean f23092d;

    public RunnableC1559ms(CompletableObserver completableObserver, Scheduler scheduler) {
        this.f23089a = completableObserver;
        this.f23090b = scheduler;
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final void dispose() {
        this.f23092d = true;
        this.f23090b.scheduleDirect(this);
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final boolean isDisposed() {
        return this.f23092d;
    }

    @Override // io.reactivex.rxjava3.core.CompletableObserver
    public final void onComplete() {
        if (this.f23092d) {
            return;
        }
        this.f23089a.onComplete();
    }

    @Override // io.reactivex.rxjava3.core.CompletableObserver
    public final void onError(Throwable th) {
        if (this.f23092d) {
            RxJavaPlugins.onError(th);
        } else {
            this.f23089a.onError(th);
        }
    }

    @Override // io.reactivex.rxjava3.core.CompletableObserver
    public final void onSubscribe(Disposable disposable) {
        if (DisposableHelper.validate(this.f23091c, disposable)) {
            this.f23091c = disposable;
            this.f23089a.onSubscribe(this);
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f23091c.dispose();
        this.f23091c = DisposableHelper.DISPOSED;
    }
}
