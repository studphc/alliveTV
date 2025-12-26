package p000;

import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;

/* loaded from: classes2.dex */
public final class gz1 implements Observer, Disposable {

    /* renamed from: a */
    public final Observer f17887a;

    /* renamed from: b */
    public boolean f17888b;

    /* renamed from: c */
    public Disposable f17889c;

    /* renamed from: d */
    public long f17890d;

    public gz1(Observer observer, long j) {
        this.f17887a = observer;
        this.f17890d = j;
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final void dispose() {
        this.f17889c.dispose();
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final boolean isDisposed() {
        return this.f17889c.isDisposed();
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onComplete() {
        if (!this.f17888b) {
            this.f17888b = true;
            this.f17889c.dispose();
            this.f17887a.onComplete();
        }
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onError(Throwable th) {
        if (this.f17888b) {
            RxJavaPlugins.onError(th);
            return;
        }
        this.f17888b = true;
        this.f17889c.dispose();
        this.f17887a.onError(th);
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onNext(Object obj) {
        boolean z;
        if (!this.f17888b) {
            long j = this.f17890d;
            long j2 = j - 1;
            this.f17890d = j2;
            if (j > 0) {
                if (j2 == 0) {
                    z = true;
                } else {
                    z = false;
                }
                this.f17887a.onNext(obj);
                if (z) {
                    onComplete();
                }
            }
        }
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onSubscribe(Disposable disposable) {
        if (DisposableHelper.validate(this.f17889c, disposable)) {
            this.f17889c = disposable;
            long j = this.f17890d;
            Observer observer = this.f17887a;
            if (j == 0) {
                this.f17888b = true;
                disposable.dispose();
                EmptyDisposable.complete((Observer<?>) observer);
                return;
            }
            observer.onSubscribe(this);
        }
    }
}
