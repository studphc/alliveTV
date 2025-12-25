package p000;

import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;

/* loaded from: classes2.dex */
public final class rv1 implements Observer, Disposable {

    /* renamed from: a */
    public final MaybeObserver f26160a;

    /* renamed from: b */
    public final long f26161b;

    /* renamed from: c */
    public Disposable f26162c;

    /* renamed from: d */
    public long f26163d;

    /* renamed from: e */
    public boolean f26164e;

    public rv1(MaybeObserver maybeObserver, long j) {
        this.f26160a = maybeObserver;
        this.f26161b = j;
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final void dispose() {
        this.f26162c.dispose();
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final boolean isDisposed() {
        return this.f26162c.isDisposed();
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onComplete() {
        if (!this.f26164e) {
            this.f26164e = true;
            this.f26160a.onComplete();
        }
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onError(Throwable th) {
        if (this.f26164e) {
            RxJavaPlugins.onError(th);
        } else {
            this.f26164e = true;
            this.f26160a.onError(th);
        }
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onNext(Object obj) {
        if (this.f26164e) {
            return;
        }
        long j = this.f26163d;
        if (j == this.f26161b) {
            this.f26164e = true;
            this.f26162c.dispose();
            this.f26160a.onSuccess(obj);
            return;
        }
        this.f26163d = j + 1;
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onSubscribe(Disposable disposable) {
        if (DisposableHelper.validate(this.f26162c, disposable)) {
            this.f26162c = disposable;
            this.f26160a.onSubscribe(this);
        }
    }
}
