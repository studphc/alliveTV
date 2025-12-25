package p000;

import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.subscriptions.DeferredScalarSubscription;

/* loaded from: classes2.dex */
public final class ck2 extends DeferredScalarSubscription implements SingleObserver {
    private static final long serialVersionUID = 187782011903685568L;

    /* renamed from: a */
    public Disposable f8407a;

    @Override // io.reactivex.rxjava3.internal.subscriptions.DeferredScalarSubscription, org.reactivestreams.Subscription
    public final void cancel() {
        super.cancel();
        this.f8407a.dispose();
    }

    @Override // io.reactivex.rxjava3.core.SingleObserver
    public final void onError(Throwable th) {
        this.downstream.onError(th);
    }

    @Override // io.reactivex.rxjava3.core.SingleObserver
    public final void onSubscribe(Disposable disposable) {
        if (DisposableHelper.validate(this.f8407a, disposable)) {
            this.f8407a = disposable;
            this.downstream.onSubscribe(this);
        }
    }
}
