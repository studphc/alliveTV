package p000;

import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;

/* loaded from: classes2.dex */
public final class hi1 implements MaybeObserver, Disposable {

    /* renamed from: a */
    public final /* synthetic */ int f18066a;

    /* renamed from: b */
    public MaybeObserver f18067b;

    /* renamed from: c */
    public Disposable f18068c;

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final void dispose() {
        switch (this.f18066a) {
            case 0:
                this.f18067b = null;
                this.f18068c.dispose();
                this.f18068c = DisposableHelper.DISPOSED;
                return;
            case 1:
                this.f18068c.dispose();
                this.f18068c = DisposableHelper.DISPOSED;
                return;
            case 2:
                this.f18068c.dispose();
                this.f18068c = DisposableHelper.DISPOSED;
                return;
            default:
                this.f18068c.dispose();
                return;
        }
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final boolean isDisposed() {
        switch (this.f18066a) {
            case 0:
                return this.f18068c.isDisposed();
            case 1:
                return this.f18068c.isDisposed();
            case 2:
                return this.f18068c.isDisposed();
            default:
                return this.f18068c.isDisposed();
        }
    }

    @Override // io.reactivex.rxjava3.core.MaybeObserver
    public final void onComplete() {
        switch (this.f18066a) {
            case 0:
                this.f18068c = DisposableHelper.DISPOSED;
                MaybeObserver maybeObserver = this.f18067b;
                if (maybeObserver != null) {
                    this.f18067b = null;
                    maybeObserver.onComplete();
                    return;
                }
                return;
            case 1:
                this.f18067b.onComplete();
                return;
            case 2:
                this.f18068c = DisposableHelper.DISPOSED;
                this.f18067b.onComplete();
                return;
            default:
                this.f18067b.onSuccess(Boolean.TRUE);
                return;
        }
    }

    @Override // io.reactivex.rxjava3.core.MaybeObserver
    public final void onError(Throwable th) {
        switch (this.f18066a) {
            case 0:
                this.f18068c = DisposableHelper.DISPOSED;
                MaybeObserver maybeObserver = this.f18067b;
                if (maybeObserver != null) {
                    this.f18067b = null;
                    maybeObserver.onError(th);
                    return;
                }
                return;
            case 1:
                this.f18067b.onError(th);
                return;
            case 2:
                this.f18068c = DisposableHelper.DISPOSED;
                this.f18067b.onError(th);
                return;
            default:
                this.f18067b.onError(th);
                return;
        }
    }

    @Override // io.reactivex.rxjava3.core.MaybeObserver
    public final void onSubscribe(Disposable disposable) {
        switch (this.f18066a) {
            case 0:
                if (DisposableHelper.validate(this.f18068c, disposable)) {
                    this.f18068c = disposable;
                    this.f18067b.onSubscribe(this);
                    return;
                }
                return;
            case 1:
                if (DisposableHelper.validate(this.f18068c, disposable)) {
                    this.f18068c = disposable;
                    this.f18067b.onSubscribe(this);
                    return;
                }
                return;
            case 2:
                if (DisposableHelper.validate(this.f18068c, disposable)) {
                    this.f18068c = disposable;
                    this.f18067b.onSubscribe(this);
                    return;
                }
                return;
            default:
                if (DisposableHelper.validate(this.f18068c, disposable)) {
                    this.f18068c = disposable;
                    this.f18067b.onSubscribe(this);
                    return;
                }
                return;
        }
    }

    @Override // io.reactivex.rxjava3.core.MaybeObserver
    public final void onSuccess(Object obj) {
        switch (this.f18066a) {
            case 0:
                this.f18068c = DisposableHelper.DISPOSED;
                MaybeObserver maybeObserver = this.f18067b;
                if (maybeObserver != null) {
                    this.f18067b = null;
                    maybeObserver.onSuccess(obj);
                    return;
                }
                return;
            case 1:
                this.f18067b.onSuccess(obj);
                return;
            case 2:
                this.f18068c = DisposableHelper.DISPOSED;
                this.f18067b.onComplete();
                return;
            default:
                this.f18067b.onSuccess(Boolean.FALSE);
                return;
        }
    }

    public /* synthetic */ hi1(MaybeObserver maybeObserver, int i) {
        this.f18066a = i;
        this.f18067b = maybeObserver;
    }
}
