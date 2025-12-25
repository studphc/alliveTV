package p000;

import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.MaybeSource;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class vj1 extends AtomicReference implements MaybeObserver, Disposable {
    private static final long serialVersionUID = -5955289211445418871L;

    /* renamed from: a */
    public final MaybeObserver f27815a;

    /* renamed from: b */
    public final wj1 f27816b = new wj1(this);

    /* renamed from: c */
    public final MaybeSource f27817c;

    /* renamed from: d */
    public final uj1 f27818d;

    public vj1(MaybeObserver maybeObserver, MaybeSource maybeSource) {
        uj1 uj1Var;
        this.f27815a = maybeObserver;
        this.f27817c = maybeSource;
        if (maybeSource != null) {
            uj1Var = new uj1(maybeObserver);
        } else {
            uj1Var = null;
        }
        this.f27818d = uj1Var;
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final void dispose() {
        DisposableHelper.dispose(this);
        SubscriptionHelper.cancel(this.f27816b);
        uj1 uj1Var = this.f27818d;
        if (uj1Var != null) {
            DisposableHelper.dispose(uj1Var);
        }
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final boolean isDisposed() {
        return DisposableHelper.isDisposed((Disposable) get());
    }

    @Override // io.reactivex.rxjava3.core.MaybeObserver
    public final void onComplete() {
        SubscriptionHelper.cancel(this.f27816b);
        DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
        if (getAndSet(disposableHelper) != disposableHelper) {
            this.f27815a.onComplete();
        }
    }

    @Override // io.reactivex.rxjava3.core.MaybeObserver
    public final void onError(Throwable th) {
        SubscriptionHelper.cancel(this.f27816b);
        DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
        if (getAndSet(disposableHelper) != disposableHelper) {
            this.f27815a.onError(th);
        } else {
            RxJavaPlugins.onError(th);
        }
    }

    @Override // io.reactivex.rxjava3.core.MaybeObserver
    public final void onSubscribe(Disposable disposable) {
        DisposableHelper.setOnce(this, disposable);
    }

    @Override // io.reactivex.rxjava3.core.MaybeObserver
    public final void onSuccess(Object obj) {
        SubscriptionHelper.cancel(this.f27816b);
        DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
        if (getAndSet(disposableHelper) != disposableHelper) {
            this.f27815a.onSuccess(obj);
        }
    }
}
