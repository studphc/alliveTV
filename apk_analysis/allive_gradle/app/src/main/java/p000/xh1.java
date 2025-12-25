package p000;

import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import java.util.NoSuchElementException;
import java.util.Objects;

/* loaded from: classes2.dex */
public final class xh1 implements MaybeObserver, Disposable {

    /* renamed from: a */
    public final /* synthetic */ int f28559a;

    /* renamed from: b */
    public final SingleObserver f28560b;

    /* renamed from: c */
    public final Object f28561c;

    /* renamed from: d */
    public Disposable f28562d;

    public /* synthetic */ xh1(SingleObserver singleObserver, Object obj, int i) {
        this.f28559a = i;
        this.f28560b = singleObserver;
        this.f28561c = obj;
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final void dispose() {
        switch (this.f28559a) {
            case 0:
                this.f28562d.dispose();
                this.f28562d = DisposableHelper.DISPOSED;
                return;
            default:
                this.f28562d.dispose();
                this.f28562d = DisposableHelper.DISPOSED;
                return;
        }
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final boolean isDisposed() {
        switch (this.f28559a) {
            case 0:
                return this.f28562d.isDisposed();
            default:
                return this.f28562d.isDisposed();
        }
    }

    @Override // io.reactivex.rxjava3.core.MaybeObserver
    public final void onComplete() {
        switch (this.f28559a) {
            case 0:
                this.f28562d = DisposableHelper.DISPOSED;
                this.f28560b.onSuccess(Boolean.FALSE);
                return;
            default:
                this.f28562d = DisposableHelper.DISPOSED;
                SingleObserver singleObserver = this.f28560b;
                Object obj = this.f28561c;
                if (obj != null) {
                    singleObserver.onSuccess(obj);
                    return;
                } else {
                    singleObserver.onError(new NoSuchElementException("The MaybeSource is empty"));
                    return;
                }
        }
    }

    @Override // io.reactivex.rxjava3.core.MaybeObserver
    public final void onError(Throwable th) {
        switch (this.f28559a) {
            case 0:
                this.f28562d = DisposableHelper.DISPOSED;
                this.f28560b.onError(th);
                return;
            default:
                this.f28562d = DisposableHelper.DISPOSED;
                this.f28560b.onError(th);
                return;
        }
    }

    @Override // io.reactivex.rxjava3.core.MaybeObserver
    public final void onSubscribe(Disposable disposable) {
        switch (this.f28559a) {
            case 0:
                if (DisposableHelper.validate(this.f28562d, disposable)) {
                    this.f28562d = disposable;
                    this.f28560b.onSubscribe(this);
                    return;
                }
                return;
            default:
                if (DisposableHelper.validate(this.f28562d, disposable)) {
                    this.f28562d = disposable;
                    this.f28560b.onSubscribe(this);
                    return;
                }
                return;
        }
    }

    @Override // io.reactivex.rxjava3.core.MaybeObserver
    public final void onSuccess(Object obj) {
        switch (this.f28559a) {
            case 0:
                this.f28562d = DisposableHelper.DISPOSED;
                this.f28560b.onSuccess(Boolean.valueOf(Objects.equals(obj, this.f28561c)));
                return;
            default:
                this.f28562d = DisposableHelper.DISPOSED;
                this.f28560b.onSuccess(obj);
                return;
        }
    }
}
