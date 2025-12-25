package p000;

import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.core.SingleSource;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class lj1 extends AtomicReference implements MaybeObserver, Disposable {
    private static final long serialVersionUID = 4603919676453758899L;

    /* renamed from: a */
    public final SingleObserver f22533a;

    /* renamed from: b */
    public final SingleSource f22534b;

    public lj1(SingleObserver singleObserver, SingleSource singleSource) {
        this.f22533a = singleObserver;
        this.f22534b = singleSource;
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
            this.f22534b.subscribe(new xi1(1, this.f22533a, this));
        }
    }

    @Override // io.reactivex.rxjava3.core.MaybeObserver
    public final void onError(Throwable th) {
        this.f22533a.onError(th);
    }

    @Override // io.reactivex.rxjava3.core.MaybeObserver
    public final void onSubscribe(Disposable disposable) {
        if (DisposableHelper.setOnce(this, disposable)) {
            this.f22533a.onSubscribe(this);
        }
    }

    @Override // io.reactivex.rxjava3.core.MaybeObserver
    public final void onSuccess(Object obj) {
        this.f22533a.onSuccess(obj);
    }
}
