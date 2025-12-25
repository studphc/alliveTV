package p000;

import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class wj2 extends AtomicReference implements SingleObserver, Disposable {
    private static final long serialVersionUID = -622603812305745221L;

    /* renamed from: a */
    public final SingleObserver f28204a;

    /* renamed from: b */
    public final xj2 f28205b = new xj2(this);

    public wj2(SingleObserver singleObserver) {
        this.f28204a = singleObserver;
    }

    /* renamed from: a */
    public final void m8061a(Throwable th) {
        Disposable disposable;
        Disposable disposable2 = (Disposable) get();
        DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
        if (disposable2 != disposableHelper && (disposable = (Disposable) getAndSet(disposableHelper)) != disposableHelper) {
            if (disposable != null) {
                disposable.dispose();
            }
            this.f28204a.onError(th);
            return;
        }
        RxJavaPlugins.onError(th);
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final void dispose() {
        DisposableHelper.dispose(this);
        xj2 xj2Var = this.f28205b;
        xj2Var.getClass();
        SubscriptionHelper.cancel(xj2Var);
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final boolean isDisposed() {
        return DisposableHelper.isDisposed((Disposable) get());
    }

    @Override // io.reactivex.rxjava3.core.SingleObserver
    public final void onError(Throwable th) {
        xj2 xj2Var = this.f28205b;
        xj2Var.getClass();
        SubscriptionHelper.cancel(xj2Var);
        Disposable disposable = (Disposable) get();
        DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
        if (disposable != disposableHelper && ((Disposable) getAndSet(disposableHelper)) != disposableHelper) {
            this.f28204a.onError(th);
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
        xj2 xj2Var = this.f28205b;
        xj2Var.getClass();
        SubscriptionHelper.cancel(xj2Var);
        DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
        if (((Disposable) getAndSet(disposableHelper)) != disposableHelper) {
            this.f28204a.onSuccess(obj);
        }
    }
}
