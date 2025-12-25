package p000;

import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.BiFunction;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.NoSuchElementException;
import java.util.Objects;

/* loaded from: classes2.dex */
public final class uw1 implements Observer, Disposable {

    /* renamed from: a */
    public final /* synthetic */ int f27502a = 1;

    /* renamed from: b */
    public final SingleObserver f27503b;

    /* renamed from: c */
    public Object f27504c;

    /* renamed from: d */
    public Disposable f27505d;

    /* renamed from: e */
    public Object f27506e;

    public uw1(SingleObserver singleObserver, Object obj) {
        this.f27503b = singleObserver;
        this.f27504c = obj;
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final void dispose() {
        switch (this.f27502a) {
            case 0:
                this.f27505d.dispose();
                this.f27505d = DisposableHelper.DISPOSED;
                return;
            default:
                this.f27505d.dispose();
                return;
        }
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final boolean isDisposed() {
        switch (this.f27502a) {
            case 0:
                if (this.f27505d == DisposableHelper.DISPOSED) {
                    return true;
                }
                return false;
            default:
                return this.f27505d.isDisposed();
        }
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onComplete() {
        switch (this.f27502a) {
            case 0:
                this.f27505d = DisposableHelper.DISPOSED;
                Object obj = this.f27506e;
                SingleObserver singleObserver = this.f27503b;
                if (obj != null) {
                    this.f27506e = null;
                    singleObserver.onSuccess(obj);
                    return;
                }
                Object obj2 = this.f27504c;
                if (obj2 != null) {
                    singleObserver.onSuccess(obj2);
                    return;
                } else {
                    singleObserver.onError(new NoSuchElementException());
                    return;
                }
            default:
                Object obj3 = this.f27504c;
                if (obj3 != null) {
                    this.f27504c = null;
                    this.f27503b.onSuccess(obj3);
                    return;
                }
                return;
        }
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onError(Throwable th) {
        switch (this.f27502a) {
            case 0:
                this.f27505d = DisposableHelper.DISPOSED;
                this.f27506e = null;
                this.f27503b.onError(th);
                return;
            default:
                if (this.f27504c != null) {
                    this.f27504c = null;
                    this.f27503b.onError(th);
                    return;
                } else {
                    RxJavaPlugins.onError(th);
                    return;
                }
        }
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onNext(Object obj) {
        switch (this.f27502a) {
            case 0:
                this.f27506e = obj;
                return;
            default:
                Object obj2 = this.f27504c;
                if (obj2 != null) {
                    try {
                        Object apply = ((BiFunction) this.f27506e).apply(obj2, obj);
                        Objects.requireNonNull(apply, "The reducer returned a null value");
                        this.f27504c = apply;
                        return;
                    } catch (Throwable th) {
                        Exceptions.throwIfFatal(th);
                        this.f27505d.dispose();
                        onError(th);
                        return;
                    }
                }
                return;
        }
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onSubscribe(Disposable disposable) {
        switch (this.f27502a) {
            case 0:
                if (DisposableHelper.validate(this.f27505d, disposable)) {
                    this.f27505d = disposable;
                    this.f27503b.onSubscribe(this);
                    return;
                }
                return;
            default:
                if (DisposableHelper.validate(this.f27505d, disposable)) {
                    this.f27505d = disposable;
                    this.f27503b.onSubscribe(this);
                    return;
                }
                return;
        }
    }

    public uw1(SingleObserver singleObserver, BiFunction biFunction, Object obj) {
        this.f27503b = singleObserver;
        this.f27504c = obj;
        this.f27506e = biFunction;
    }
}
