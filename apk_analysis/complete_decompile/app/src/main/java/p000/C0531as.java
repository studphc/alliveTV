package p000;

import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.CompletableSource;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* renamed from: as */
/* loaded from: classes2.dex */
public final class C0531as extends AtomicReference implements CompletableObserver, Disposable {
    private static final long serialVersionUID = -4101678820158072998L;

    /* renamed from: a */
    public final CompletableObserver f7728a;

    /* renamed from: b */
    public final CompletableSource f7729b;

    public C0531as(CompletableObserver completableObserver, CompletableSource completableSource) {
        this.f7728a = completableObserver;
        this.f7729b = completableSource;
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
        this.f7729b.subscribe(new C2067zr(this, this.f7728a, 0));
    }

    @Override // io.reactivex.rxjava3.core.CompletableObserver
    public final void onError(Throwable th) {
        this.f7728a.onError(th);
    }

    @Override // io.reactivex.rxjava3.core.CompletableObserver
    public final void onSubscribe(Disposable disposable) {
        if (DisposableHelper.setOnce(this, disposable)) {
            this.f7728a.onSubscribe(this);
        }
    }
}
