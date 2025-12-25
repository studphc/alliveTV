package p000;

import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;

/* loaded from: classes2.dex */
public final class yh1 implements MaybeObserver, Disposable {

    /* renamed from: a */
    public final /* synthetic */ int f28955a;

    /* renamed from: b */
    public final SingleObserver f28956b;

    /* renamed from: c */
    public Disposable f28957c;

    public /* synthetic */ yh1(SingleObserver singleObserver, int i) {
        this.f28955a = i;
        this.f28956b = singleObserver;
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final void dispose() {
        switch (this.f28955a) {
            case 0:
                this.f28957c.dispose();
                this.f28957c = DisposableHelper.DISPOSED;
                return;
            default:
                this.f28957c.dispose();
                this.f28957c = DisposableHelper.DISPOSED;
                return;
        }
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final boolean isDisposed() {
        switch (this.f28955a) {
            case 0:
                return this.f28957c.isDisposed();
            default:
                return this.f28957c.isDisposed();
        }
    }

    @Override // io.reactivex.rxjava3.core.MaybeObserver
    public final void onComplete() {
        switch (this.f28955a) {
            case 0:
                this.f28957c = DisposableHelper.DISPOSED;
                this.f28956b.onSuccess(0L);
                return;
            default:
                this.f28957c = DisposableHelper.DISPOSED;
                this.f28956b.onSuccess(Boolean.TRUE);
                return;
        }
    }

    @Override // io.reactivex.rxjava3.core.MaybeObserver
    public final void onError(Throwable th) {
        switch (this.f28955a) {
            case 0:
                this.f28957c = DisposableHelper.DISPOSED;
                this.f28956b.onError(th);
                return;
            default:
                this.f28957c = DisposableHelper.DISPOSED;
                this.f28956b.onError(th);
                return;
        }
    }

    @Override // io.reactivex.rxjava3.core.MaybeObserver
    public final void onSubscribe(Disposable disposable) {
        switch (this.f28955a) {
            case 0:
                if (DisposableHelper.validate(this.f28957c, disposable)) {
                    this.f28957c = disposable;
                    this.f28956b.onSubscribe(this);
                    return;
                }
                return;
            default:
                if (DisposableHelper.validate(this.f28957c, disposable)) {
                    this.f28957c = disposable;
                    this.f28956b.onSubscribe(this);
                    return;
                }
                return;
        }
    }

    @Override // io.reactivex.rxjava3.core.MaybeObserver
    public final void onSuccess(Object obj) {
        switch (this.f28955a) {
            case 0:
                this.f28957c = DisposableHelper.DISPOSED;
                this.f28956b.onSuccess(1L);
                return;
            default:
                this.f28957c = DisposableHelper.DISPOSED;
                this.f28956b.onSuccess(Boolean.FALSE);
                return;
        }
    }
}
