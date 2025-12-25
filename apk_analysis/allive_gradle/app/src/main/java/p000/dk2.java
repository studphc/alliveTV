package p000;

import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.observers.DeferredScalarDisposable;

/* loaded from: classes2.dex */
public final class dk2 extends DeferredScalarDisposable implements SingleObserver {
    private static final long serialVersionUID = 3786543492451018833L;

    /* renamed from: a */
    public Disposable f16401a;

    @Override // io.reactivex.rxjava3.internal.observers.DeferredScalarDisposable, io.reactivex.rxjava3.disposables.Disposable
    public final void dispose() {
        super.dispose();
        this.f16401a.dispose();
    }

    @Override // io.reactivex.rxjava3.core.SingleObserver
    public final void onSubscribe(Disposable disposable) {
        if (DisposableHelper.validate(this.f16401a, disposable)) {
            this.f16401a = disposable;
            this.downstream.onSubscribe(this);
        }
    }
}
