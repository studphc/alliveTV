package p000;

import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: gt */
/* loaded from: classes2.dex */
public final class C1244gt implements CompletableObserver {

    /* renamed from: a */
    public final CompositeDisposable f17826a;

    /* renamed from: b */
    public final AtomicBoolean f17827b;

    /* renamed from: c */
    public final CompletableObserver f17828c;

    public C1244gt(CompletableObserver completableObserver, CompositeDisposable compositeDisposable, AtomicBoolean atomicBoolean) {
        this.f17826a = compositeDisposable;
        this.f17827b = atomicBoolean;
        this.f17828c = completableObserver;
    }

    @Override // io.reactivex.rxjava3.core.CompletableObserver
    public final void onComplete() {
        if (this.f17827b.compareAndSet(false, true)) {
            this.f17826a.dispose();
            this.f17828c.onComplete();
        }
    }

    @Override // io.reactivex.rxjava3.core.CompletableObserver
    public final void onError(Throwable th) {
        if (this.f17827b.compareAndSet(false, true)) {
            this.f17826a.dispose();
            this.f17828c.onError(th);
        } else {
            RxJavaPlugins.onError(th);
        }
    }

    @Override // io.reactivex.rxjava3.core.CompletableObserver
    public final void onSubscribe(Disposable disposable) {
        this.f17826a.add(disposable);
    }
}
