package p000;

import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.subscriptions.DeferredScalarSubscription;

/* loaded from: classes2.dex */
public final class yj1 extends DeferredScalarSubscription implements MaybeObserver {
    private static final long serialVersionUID = 7603343402964826922L;

    /* renamed from: a */
    public Disposable f28986a;

    @Override // io.reactivex.rxjava3.internal.subscriptions.DeferredScalarSubscription, org.reactivestreams.Subscription
    public final void cancel() {
        super.cancel();
        this.f28986a.dispose();
    }

    @Override // io.reactivex.rxjava3.core.MaybeObserver
    public final void onComplete() {
        this.downstream.onComplete();
    }

    @Override // io.reactivex.rxjava3.core.MaybeObserver
    public final void onError(Throwable th) {
        this.downstream.onError(th);
    }

    @Override // io.reactivex.rxjava3.core.MaybeObserver
    public final void onSubscribe(Disposable disposable) {
        if (DisposableHelper.validate(this.f28986a, disposable)) {
            this.f28986a = disposable;
            this.downstream.onSubscribe(this);
        }
    }
}
