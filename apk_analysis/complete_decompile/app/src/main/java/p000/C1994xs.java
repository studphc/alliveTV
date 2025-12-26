package p000;

import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: xs */
/* loaded from: classes2.dex */
public final class C1994xs extends AtomicBoolean implements CompletableObserver, Disposable {
    private static final long serialVersionUID = -7730517613164279224L;

    /* renamed from: a */
    public final CompositeDisposable f28720a;

    /* renamed from: b */
    public final CompletableObserver f28721b;

    /* renamed from: c */
    public final AtomicInteger f28722c;

    public C1994xs(CompletableObserver completableObserver, CompositeDisposable compositeDisposable, AtomicInteger atomicInteger) {
        this.f28721b = completableObserver;
        this.f28720a = compositeDisposable;
        this.f28722c = atomicInteger;
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final void dispose() {
        this.f28720a.dispose();
        set(true);
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final boolean isDisposed() {
        return this.f28720a.isDisposed();
    }

    @Override // io.reactivex.rxjava3.core.CompletableObserver
    public final void onComplete() {
        if (this.f28722c.decrementAndGet() == 0) {
            this.f28721b.onComplete();
        }
    }

    @Override // io.reactivex.rxjava3.core.CompletableObserver
    public final void onError(Throwable th) {
        this.f28720a.dispose();
        if (compareAndSet(false, true)) {
            this.f28721b.onError(th);
        } else {
            RxJavaPlugins.onError(th);
        }
    }

    @Override // io.reactivex.rxjava3.core.CompletableObserver
    public final void onSubscribe(Disposable disposable) {
        this.f28720a.add(disposable);
    }
}
