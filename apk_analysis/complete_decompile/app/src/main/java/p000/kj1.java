package p000;

import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.MaybeSource;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class kj1 extends AtomicReference implements MaybeObserver, Disposable {
    private static final long serialVersionUID = -2223459372976438024L;

    /* renamed from: a */
    public final MaybeObserver f20871a;

    /* renamed from: b */
    public final MaybeSource f20872b;

    public kj1(MaybeObserver maybeObserver, MaybeSource maybeSource) {
        this.f20871a = maybeObserver;
        this.f20872b = maybeSource;
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final void dispose() {
        DisposableHelper.dispose(this);
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final boolean isDisposed() {
        return DisposableHelper.isDisposed((Disposable) get());
    }

    @Override // io.reactivex.rxjava3.core.MaybeObserver
    public final void onComplete() {
        Disposable disposable = (Disposable) get();
        if (disposable != DisposableHelper.DISPOSED && compareAndSet(disposable, null)) {
            this.f20872b.subscribe(new ei1(this.f20871a, this, 3));
        }
    }

    @Override // io.reactivex.rxjava3.core.MaybeObserver
    public final void onError(Throwable th) {
        this.f20871a.onError(th);
    }

    @Override // io.reactivex.rxjava3.core.MaybeObserver
    public final void onSubscribe(Disposable disposable) {
        if (DisposableHelper.setOnce(this, disposable)) {
            this.f20871a.onSubscribe(this);
        }
    }

    @Override // io.reactivex.rxjava3.core.MaybeObserver
    public final void onSuccess(Object obj) {
        this.f20871a.onSuccess(obj);
    }
}
