package p000;

import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.core.SingleSource;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class ak2 extends AtomicReference implements SingleObserver, Runnable, Disposable {
    private static final long serialVersionUID = 37497744973048446L;

    /* renamed from: a */
    public final SingleObserver f245a;

    /* renamed from: b */
    public final AtomicReference f246b = new AtomicReference();

    /* renamed from: c */
    public final zj2 f247c;

    /* renamed from: d */
    public SingleSource f248d;

    /* renamed from: e */
    public final long f249e;

    /* renamed from: f */
    public final TimeUnit f250f;

    public ak2(SingleObserver singleObserver, SingleSource singleSource, long j, TimeUnit timeUnit) {
        this.f245a = singleObserver;
        this.f248d = singleSource;
        this.f249e = j;
        this.f250f = timeUnit;
        if (singleSource != null) {
            this.f247c = new zj2(singleObserver);
        } else {
            this.f247c = null;
        }
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final void dispose() {
        DisposableHelper.dispose(this);
        DisposableHelper.dispose(this.f246b);
        zj2 zj2Var = this.f247c;
        if (zj2Var != null) {
            DisposableHelper.dispose(zj2Var);
        }
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final boolean isDisposed() {
        return DisposableHelper.isDisposed((Disposable) get());
    }

    @Override // io.reactivex.rxjava3.core.SingleObserver
    public final void onError(Throwable th) {
        Disposable disposable = (Disposable) get();
        DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
        if (disposable != disposableHelper && compareAndSet(disposable, disposableHelper)) {
            DisposableHelper.dispose(this.f246b);
            this.f245a.onError(th);
        } else {
            RxJavaPlugins.onError(th);
        }
    }

    @Override // io.reactivex.rxjava3.core.SingleObserver
    public final void onSubscribe(Disposable disposable) {
        DisposableHelper.setOnce(this, disposable);
    }

    @Override // io.reactivex.rxjava3.core.SingleObserver
    public final void onSuccess(Object obj) {
        Disposable disposable = (Disposable) get();
        DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
        if (disposable != disposableHelper && compareAndSet(disposable, disposableHelper)) {
            DisposableHelper.dispose(this.f246b);
            this.f245a.onSuccess(obj);
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        Disposable disposable = (Disposable) get();
        DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
        if (disposable != disposableHelper && compareAndSet(disposable, disposableHelper)) {
            if (disposable != null) {
                disposable.dispose();
            }
            SingleSource singleSource = this.f248d;
            if (singleSource == null) {
                this.f245a.onError(new TimeoutException(ExceptionHelper.timeoutMessage(this.f249e, this.f250f)));
            } else {
                this.f248d = null;
                singleSource.subscribe(this.f247c);
            }
        }
    }
}
