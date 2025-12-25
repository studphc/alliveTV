package p000;

import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes2.dex */
public final class sh1 implements MaybeObserver {

    /* renamed from: a */
    public final MaybeObserver f26430a;

    /* renamed from: b */
    public final AtomicBoolean f26431b;

    /* renamed from: c */
    public final CompositeDisposable f26432c;

    /* renamed from: d */
    public Disposable f26433d;

    public sh1(MaybeObserver maybeObserver, CompositeDisposable compositeDisposable, AtomicBoolean atomicBoolean) {
        this.f26430a = maybeObserver;
        this.f26432c = compositeDisposable;
        this.f26431b = atomicBoolean;
    }

    @Override // io.reactivex.rxjava3.core.MaybeObserver
    public final void onComplete() {
        if (this.f26431b.compareAndSet(false, true)) {
            Disposable disposable = this.f26433d;
            CompositeDisposable compositeDisposable = this.f26432c;
            compositeDisposable.delete(disposable);
            compositeDisposable.dispose();
            this.f26430a.onComplete();
        }
    }

    @Override // io.reactivex.rxjava3.core.MaybeObserver
    public final void onError(Throwable th) {
        if (this.f26431b.compareAndSet(false, true)) {
            Disposable disposable = this.f26433d;
            CompositeDisposable compositeDisposable = this.f26432c;
            compositeDisposable.delete(disposable);
            compositeDisposable.dispose();
            this.f26430a.onError(th);
            return;
        }
        RxJavaPlugins.onError(th);
    }

    @Override // io.reactivex.rxjava3.core.MaybeObserver
    public final void onSubscribe(Disposable disposable) {
        this.f26433d = disposable;
        this.f26432c.add(disposable);
    }

    @Override // io.reactivex.rxjava3.core.MaybeObserver
    public final void onSuccess(Object obj) {
        if (this.f26431b.compareAndSet(false, true)) {
            Disposable disposable = this.f26433d;
            CompositeDisposable compositeDisposable = this.f26432c;
            compositeDisposable.delete(disposable);
            compositeDisposable.dispose();
            this.f26430a.onSuccess(obj);
        }
    }
}
