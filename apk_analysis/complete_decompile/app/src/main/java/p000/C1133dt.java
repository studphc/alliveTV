package p000;

import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicReference;

/* renamed from: dt */
/* loaded from: classes2.dex */
public final class C1133dt extends AtomicReference implements CompletableObserver {
    private static final long serialVersionUID = 5176264485428790318L;

    /* renamed from: a */
    public final C1170et f16533a;

    public C1133dt(C1170et c1170et) {
        this.f16533a = c1170et;
    }

    @Override // io.reactivex.rxjava3.core.CompletableObserver
    public final void onComplete() {
        C1170et c1170et = this.f16533a;
        if (c1170et.f16976c.compareAndSet(false, true)) {
            DisposableHelper.dispose(c1170et);
            c1170et.f16974a.onComplete();
        }
    }

    @Override // io.reactivex.rxjava3.core.CompletableObserver
    public final void onError(Throwable th) {
        C1170et c1170et = this.f16533a;
        if (c1170et.f16976c.compareAndSet(false, true)) {
            DisposableHelper.dispose(c1170et);
            c1170et.f16974a.onError(th);
        } else {
            RxJavaPlugins.onError(th);
        }
    }

    @Override // io.reactivex.rxjava3.core.CompletableObserver
    public final void onSubscribe(Disposable disposable) {
        DisposableHelper.setOnce(this, disposable);
    }
}
