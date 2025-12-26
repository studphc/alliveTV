package p000;

import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.core.SingleSource;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.disposables.SequentialDisposable;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class vj2 extends AtomicReference implements SingleObserver, Disposable, Runnable {
    private static final long serialVersionUID = 7000911171163930287L;

    /* renamed from: a */
    public final SingleObserver f27819a;

    /* renamed from: b */
    public final SequentialDisposable f27820b = new SequentialDisposable();

    /* renamed from: c */
    public final SingleSource f27821c;

    public vj2(SingleObserver singleObserver, SingleSource singleSource) {
        this.f27819a = singleObserver;
        this.f27821c = singleSource;
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final void dispose() {
        DisposableHelper.dispose(this);
        this.f27820b.dispose();
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final boolean isDisposed() {
        return DisposableHelper.isDisposed((Disposable) get());
    }

    @Override // io.reactivex.rxjava3.core.SingleObserver
    public final void onError(Throwable th) {
        this.f27819a.onError(th);
    }

    @Override // io.reactivex.rxjava3.core.SingleObserver
    public final void onSubscribe(Disposable disposable) {
        DisposableHelper.setOnce(this, disposable);
    }

    @Override // io.reactivex.rxjava3.core.SingleObserver
    public final void onSuccess(Object obj) {
        this.f27819a.onSuccess(obj);
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f27821c.subscribe(this);
    }
}
