package p000;

import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;

/* renamed from: ls */
/* loaded from: classes2.dex */
public final class C1522ls implements CompletableObserver, Disposable {

    /* renamed from: a */
    public final /* synthetic */ int f22651a;

    /* renamed from: b */
    public Object f22652b;

    /* renamed from: c */
    public Disposable f22653c;

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final void dispose() {
        switch (this.f22651a) {
            case 0:
                this.f22652b = null;
                this.f22653c.dispose();
                this.f22653c = DisposableHelper.DISPOSED;
                return;
            case 1:
                this.f22653c.dispose();
                this.f22653c = DisposableHelper.DISPOSED;
                return;
            default:
                this.f22653c.dispose();
                this.f22653c = DisposableHelper.DISPOSED;
                return;
        }
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final boolean isDisposed() {
        switch (this.f22651a) {
            case 0:
                return this.f22653c.isDisposed();
            case 1:
                return this.f22653c.isDisposed();
            default:
                return this.f22653c.isDisposed();
        }
    }

    @Override // io.reactivex.rxjava3.core.CompletableObserver
    public final void onComplete() {
        switch (this.f22651a) {
            case 0:
                this.f22653c = DisposableHelper.DISPOSED;
                CompletableObserver completableObserver = (CompletableObserver) this.f22652b;
                if (completableObserver != null) {
                    this.f22652b = null;
                    completableObserver.onComplete();
                    return;
                }
                return;
            case 1:
                ((CompletableObserver) this.f22652b).onComplete();
                return;
            default:
                this.f22653c = DisposableHelper.DISPOSED;
                ((MaybeObserver) this.f22652b).onComplete();
                return;
        }
    }

    @Override // io.reactivex.rxjava3.core.CompletableObserver
    public final void onError(Throwable th) {
        switch (this.f22651a) {
            case 0:
                this.f22653c = DisposableHelper.DISPOSED;
                CompletableObserver completableObserver = (CompletableObserver) this.f22652b;
                if (completableObserver != null) {
                    this.f22652b = null;
                    completableObserver.onError(th);
                    return;
                }
                return;
            case 1:
                ((CompletableObserver) this.f22652b).onError(th);
                return;
            default:
                this.f22653c = DisposableHelper.DISPOSED;
                ((MaybeObserver) this.f22652b).onError(th);
                return;
        }
    }

    @Override // io.reactivex.rxjava3.core.CompletableObserver
    public final void onSubscribe(Disposable disposable) {
        switch (this.f22651a) {
            case 0:
                if (DisposableHelper.validate(this.f22653c, disposable)) {
                    this.f22653c = disposable;
                    ((CompletableObserver) this.f22652b).onSubscribe(this);
                    return;
                }
                return;
            case 1:
                if (DisposableHelper.validate(this.f22653c, disposable)) {
                    this.f22653c = disposable;
                    ((CompletableObserver) this.f22652b).onSubscribe(this);
                    return;
                }
                return;
            default:
                if (DisposableHelper.validate(this.f22653c, disposable)) {
                    this.f22653c = disposable;
                    ((MaybeObserver) this.f22652b).onSubscribe(this);
                    return;
                }
                return;
        }
    }

    public /* synthetic */ C1522ls(int i, Object obj) {
        this.f22651a = i;
        this.f22652b = obj;
    }
}
