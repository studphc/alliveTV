package p000;

import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class pj1 extends AtomicReference implements MaybeObserver, Disposable {
    private static final long serialVersionUID = -2187421758664251153L;

    /* renamed from: a */
    public final MaybeObserver f25197a;

    /* renamed from: b */
    public final oj1 f25198b = new oj1(this);

    public pj1(MaybeObserver maybeObserver) {
        this.f25197a = maybeObserver;
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final void dispose() {
        DisposableHelper.dispose(this);
        SubscriptionHelper.cancel(this.f25198b);
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final boolean isDisposed() {
        return DisposableHelper.isDisposed((Disposable) get());
    }

    @Override // io.reactivex.rxjava3.core.MaybeObserver
    public final void onComplete() {
        SubscriptionHelper.cancel(this.f25198b);
        DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
        if (getAndSet(disposableHelper) != disposableHelper) {
            this.f25197a.onComplete();
        }
    }

    @Override // io.reactivex.rxjava3.core.MaybeObserver
    public final void onError(Throwable th) {
        SubscriptionHelper.cancel(this.f25198b);
        DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
        if (getAndSet(disposableHelper) != disposableHelper) {
            this.f25197a.onError(th);
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
        SubscriptionHelper.cancel(this.f25198b);
        DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
        if (getAndSet(disposableHelper) != disposableHelper) {
            this.f25197a.onSuccess(obj);
        }
    }
}
