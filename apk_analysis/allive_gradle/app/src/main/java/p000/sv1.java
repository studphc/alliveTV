package p000;

import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.NoSuchElementException;

/* loaded from: classes2.dex */
public final class sv1 implements Observer, Disposable {

    /* renamed from: a */
    public final SingleObserver f26582a;

    /* renamed from: b */
    public final long f26583b;

    /* renamed from: c */
    public final Object f26584c;

    /* renamed from: d */
    public Disposable f26585d;

    /* renamed from: e */
    public long f26586e;

    /* renamed from: f */
    public boolean f26587f;

    public sv1(SingleObserver singleObserver, long j, Object obj) {
        this.f26582a = singleObserver;
        this.f26583b = j;
        this.f26584c = obj;
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final void dispose() {
        this.f26585d.dispose();
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final boolean isDisposed() {
        return this.f26585d.isDisposed();
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onComplete() {
        if (!this.f26587f) {
            this.f26587f = true;
            SingleObserver singleObserver = this.f26582a;
            Object obj = this.f26584c;
            if (obj != null) {
                singleObserver.onSuccess(obj);
            } else {
                singleObserver.onError(new NoSuchElementException());
            }
        }
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onError(Throwable th) {
        if (this.f26587f) {
            RxJavaPlugins.onError(th);
        } else {
            this.f26587f = true;
            this.f26582a.onError(th);
        }
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onNext(Object obj) {
        if (this.f26587f) {
            return;
        }
        long j = this.f26586e;
        if (j == this.f26583b) {
            this.f26587f = true;
            this.f26585d.dispose();
            this.f26582a.onSuccess(obj);
            return;
        }
        this.f26586e = j + 1;
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onSubscribe(Disposable disposable) {
        if (DisposableHelper.validate(this.f26585d, disposable)) {
            this.f26585d = disposable;
            this.f26582a.onSubscribe(this);
        }
    }
}
