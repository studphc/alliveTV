package p000;

import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.CompletableSource;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.disposables.SequentialDisposable;
import java.util.concurrent.atomic.AtomicReference;

/* renamed from: ct */
/* loaded from: classes2.dex */
public final class RunnableC1097ct extends AtomicReference implements CompletableObserver, Disposable, Runnable {
    private static final long serialVersionUID = 7000911171163930287L;

    /* renamed from: a */
    public final CompletableObserver f16100a;

    /* renamed from: b */
    public final SequentialDisposable f16101b = new SequentialDisposable();

    /* renamed from: c */
    public final CompletableSource f16102c;

    public RunnableC1097ct(CompletableObserver completableObserver, CompletableSource completableSource) {
        this.f16100a = completableObserver;
        this.f16102c = completableSource;
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final void dispose() {
        DisposableHelper.dispose(this);
        this.f16101b.dispose();
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final boolean isDisposed() {
        return DisposableHelper.isDisposed((Disposable) get());
    }

    @Override // io.reactivex.rxjava3.core.CompletableObserver
    public final void onComplete() {
        this.f16100a.onComplete();
    }

    @Override // io.reactivex.rxjava3.core.CompletableObserver
    public final void onError(Throwable th) {
        this.f16100a.onError(th);
    }

    @Override // io.reactivex.rxjava3.core.CompletableObserver
    public final void onSubscribe(Disposable disposable) {
        DisposableHelper.setOnce(this, disposable);
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f16102c.subscribe(this);
    }
}
