package p000;

import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.CompositeException;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Objects;

/* loaded from: classes2.dex */
public final class ew1 implements Observer, Disposable {

    /* renamed from: a */
    public final /* synthetic */ int f17008a;

    /* renamed from: b */
    public final Observer f17009b;

    /* renamed from: c */
    public final Function f17010c;

    /* renamed from: d */
    public Disposable f17011d;

    public /* synthetic */ ew1(Observer observer, Function function, int i) {
        this.f17008a = i;
        this.f17009b = observer;
        this.f17010c = function;
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final void dispose() {
        switch (this.f17008a) {
            case 0:
                this.f17011d.dispose();
                this.f17011d = DisposableHelper.DISPOSED;
                return;
            default:
                this.f17011d.dispose();
                return;
        }
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final boolean isDisposed() {
        switch (this.f17008a) {
            case 0:
                return this.f17011d.isDisposed();
            default:
                return this.f17011d.isDisposed();
        }
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onComplete() {
        switch (this.f17008a) {
            case 0:
                Disposable disposable = this.f17011d;
                DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
                if (disposable != disposableHelper) {
                    this.f17011d = disposableHelper;
                    this.f17009b.onComplete();
                    return;
                }
                return;
            default:
                this.f17009b.onComplete();
                return;
        }
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onError(Throwable th) {
        Observer observer = this.f17009b;
        switch (this.f17008a) {
            case 0:
                Disposable disposable = this.f17011d;
                DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
                if (disposable == disposableHelper) {
                    RxJavaPlugins.onError(th);
                    return;
                } else {
                    this.f17011d = disposableHelper;
                    observer.onError(th);
                    return;
                }
            default:
                try {
                    Object apply = this.f17010c.apply(th);
                    if (apply == null) {
                        NullPointerException nullPointerException = new NullPointerException("The supplied value is null");
                        nullPointerException.initCause(th);
                        observer.onError(nullPointerException);
                        return;
                    } else {
                        observer.onNext(apply);
                        observer.onComplete();
                        return;
                    }
                } catch (Throwable th2) {
                    Exceptions.throwIfFatal(th2);
                    observer.onError(new CompositeException(th, th2));
                    return;
                }
        }
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onNext(Object obj) {
        switch (this.f17008a) {
            case 0:
                if (this.f17011d != DisposableHelper.DISPOSED) {
                    try {
                        for (Object obj2 : (Iterable) this.f17010c.apply(obj)) {
                            try {
                                try {
                                    Objects.requireNonNull(obj2, "The iterator returned a null value");
                                    this.f17009b.onNext(obj2);
                                } catch (Throwable th) {
                                    Exceptions.throwIfFatal(th);
                                    this.f17011d.dispose();
                                    onError(th);
                                    return;
                                }
                            } catch (Throwable th2) {
                                Exceptions.throwIfFatal(th2);
                                this.f17011d.dispose();
                                onError(th2);
                                return;
                            }
                        }
                        return;
                    } catch (Throwable th3) {
                        Exceptions.throwIfFatal(th3);
                        this.f17011d.dispose();
                        onError(th3);
                        return;
                    }
                }
                return;
            default:
                this.f17009b.onNext(obj);
                return;
        }
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onSubscribe(Disposable disposable) {
        switch (this.f17008a) {
            case 0:
                if (DisposableHelper.validate(this.f17011d, disposable)) {
                    this.f17011d = disposable;
                    this.f17009b.onSubscribe(this);
                    return;
                }
                return;
            default:
                if (DisposableHelper.validate(this.f17011d, disposable)) {
                    this.f17011d = disposable;
                    this.f17009b.onSubscribe(this);
                    return;
                }
                return;
        }
    }
}
