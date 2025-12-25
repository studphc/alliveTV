package p000;

import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: vs */
/* loaded from: classes2.dex */
public final class C1920vs extends AtomicInteger implements CompletableObserver, Disposable {
    private static final long serialVersionUID = -8360547806504310570L;

    /* renamed from: a */
    public final CompletableObserver f27938a;

    /* renamed from: b */
    public final AtomicBoolean f27939b;

    /* renamed from: c */
    public final CompositeDisposable f27940c;

    public C1920vs(CompletableObserver completableObserver, AtomicBoolean atomicBoolean, CompositeDisposable compositeDisposable, int i) {
        this.f27938a = completableObserver;
        this.f27939b = atomicBoolean;
        this.f27940c = compositeDisposable;
        lazySet(i);
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final void dispose() {
        this.f27940c.dispose();
        this.f27939b.set(true);
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final boolean isDisposed() {
        return this.f27940c.isDisposed();
    }

    @Override // io.reactivex.rxjava3.core.CompletableObserver
    public final void onComplete() {
        if (decrementAndGet() == 0) {
            this.f27938a.onComplete();
        }
    }

    @Override // io.reactivex.rxjava3.core.CompletableObserver
    public final void onError(Throwable th) {
        this.f27940c.dispose();
        if (this.f27939b.compareAndSet(false, true)) {
            this.f27938a.onError(th);
        } else {
            RxJavaPlugins.onError(th);
        }
    }

    @Override // io.reactivex.rxjava3.core.CompletableObserver
    public final void onSubscribe(Disposable disposable) {
        this.f27940c.add(disposable);
    }
}
