package p000;

import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.MaybeSource;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class fi1 extends AtomicReference implements CompletableObserver, Disposable {
    private static final long serialVersionUID = 703409937383992161L;

    /* renamed from: a */
    public final MaybeObserver f17277a;

    /* renamed from: b */
    public final MaybeSource f17278b;

    public fi1(MaybeObserver maybeObserver, MaybeSource maybeSource) {
        this.f17277a = maybeObserver;
        this.f17278b = maybeSource;
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final void dispose() {
        DisposableHelper.dispose(this);
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final boolean isDisposed() {
        return DisposableHelper.isDisposed((Disposable) get());
    }

    @Override // io.reactivex.rxjava3.core.CompletableObserver
    public final void onComplete() {
        this.f17278b.subscribe(new ei1(0, this.f17277a, this));
    }

    @Override // io.reactivex.rxjava3.core.CompletableObserver
    public final void onError(Throwable th) {
        this.f17277a.onError(th);
    }

    @Override // io.reactivex.rxjava3.core.CompletableObserver
    public final void onSubscribe(Disposable disposable) {
        if (DisposableHelper.setOnce(this, disposable)) {
            this.f17277a.onSubscribe(this);
        }
    }
}
