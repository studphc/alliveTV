package p000;

import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.observers.DeferredScalarDisposable;

/* loaded from: classes2.dex */
public final class zj1 extends DeferredScalarDisposable implements MaybeObserver {
    private static final long serialVersionUID = 7603343402964826922L;

    /* renamed from: a */
    public Disposable f29401a;

    @Override // io.reactivex.rxjava3.internal.observers.DeferredScalarDisposable, io.reactivex.rxjava3.disposables.Disposable
    public final void dispose() {
        super.dispose();
        this.f29401a.dispose();
    }

    @Override // io.reactivex.rxjava3.core.MaybeObserver
    public final void onSubscribe(Disposable disposable) {
        if (DisposableHelper.validate(this.f29401a, disposable)) {
            this.f29401a = disposable;
            this.downstream.onSubscribe(this);
        }
    }
}
