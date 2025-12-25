package p000;

import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;

/* loaded from: classes2.dex */
public final class vi2 implements SingleObserver, Disposable {

    /* renamed from: a */
    public final /* synthetic */ int f27810a = 0;

    /* renamed from: b */
    public SingleObserver f27811b;

    /* renamed from: c */
    public Disposable f27812c;

    public /* synthetic */ vi2() {
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final void dispose() {
        switch (this.f27810a) {
            case 0:
                this.f27811b = null;
                this.f27812c.dispose();
                this.f27812c = DisposableHelper.DISPOSED;
                return;
            default:
                this.f27812c.dispose();
                return;
        }
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final boolean isDisposed() {
        switch (this.f27810a) {
            case 0:
                return this.f27812c.isDisposed();
            default:
                return this.f27812c.isDisposed();
        }
    }

    @Override // io.reactivex.rxjava3.core.SingleObserver
    public final void onError(Throwable th) {
        switch (this.f27810a) {
            case 0:
                this.f27812c = DisposableHelper.DISPOSED;
                SingleObserver singleObserver = this.f27811b;
                if (singleObserver != null) {
                    this.f27811b = null;
                    singleObserver.onError(th);
                    return;
                }
                return;
            default:
                this.f27811b.onError(th);
                return;
        }
    }

    @Override // io.reactivex.rxjava3.core.SingleObserver
    public final void onSubscribe(Disposable disposable) {
        switch (this.f27810a) {
            case 0:
                if (DisposableHelper.validate(this.f27812c, disposable)) {
                    this.f27812c = disposable;
                    this.f27811b.onSubscribe(this);
                    return;
                }
                return;
            default:
                if (DisposableHelper.validate(this.f27812c, disposable)) {
                    this.f27812c = disposable;
                    this.f27811b.onSubscribe(this);
                    return;
                }
                return;
        }
    }

    @Override // io.reactivex.rxjava3.core.SingleObserver
    public final void onSuccess(Object obj) {
        switch (this.f27810a) {
            case 0:
                this.f27812c = DisposableHelper.DISPOSED;
                SingleObserver singleObserver = this.f27811b;
                if (singleObserver != null) {
                    this.f27811b = null;
                    singleObserver.onSuccess(obj);
                    return;
                }
                return;
            default:
                this.f27811b.onSuccess(obj);
                return;
        }
    }

    public vi2(SingleObserver singleObserver) {
        this.f27811b = singleObserver;
    }
}
