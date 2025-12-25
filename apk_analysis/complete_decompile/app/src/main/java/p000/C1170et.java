package p000;

import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* renamed from: et */
/* loaded from: classes2.dex */
public final class C1170et extends AtomicReference implements CompletableObserver, Disposable {
    private static final long serialVersionUID = 3533011714830024923L;

    /* renamed from: a */
    public final CompletableObserver f16974a;

    /* renamed from: b */
    public final C1133dt f16975b = new C1133dt(this);

    /* renamed from: c */
    public final AtomicBoolean f16976c = new AtomicBoolean();

    public C1170et(CompletableObserver completableObserver) {
        this.f16974a = completableObserver;
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final void dispose() {
        if (this.f16976c.compareAndSet(false, true)) {
            DisposableHelper.dispose(this);
            DisposableHelper.dispose(this.f16975b);
        }
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final boolean isDisposed() {
        return this.f16976c.get();
    }

    @Override // io.reactivex.rxjava3.core.CompletableObserver
    public final void onComplete() {
        if (this.f16976c.compareAndSet(false, true)) {
            DisposableHelper.dispose(this.f16975b);
            this.f16974a.onComplete();
        }
    }

    @Override // io.reactivex.rxjava3.core.CompletableObserver
    public final void onError(Throwable th) {
        if (this.f16976c.compareAndSet(false, true)) {
            DisposableHelper.dispose(this.f16975b);
            this.f16974a.onError(th);
        } else {
            RxJavaPlugins.onError(th);
        }
    }

    @Override // io.reactivex.rxjava3.core.CompletableObserver
    public final void onSubscribe(Disposable disposable) {
        DisposableHelper.setOnce(this, disposable);
    }
}
