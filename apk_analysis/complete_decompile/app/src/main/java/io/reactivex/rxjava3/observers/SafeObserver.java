package io.reactivex.rxjava3.observers;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.CompositeException;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;

/* loaded from: classes2.dex */
public final class SafeObserver<T> implements Observer<T>, Disposable {

    /* renamed from: a */
    public final Observer f19982a;

    /* renamed from: b */
    public Disposable f19983b;

    /* renamed from: c */
    public boolean f19984c;

    public SafeObserver(@NonNull Observer<? super T> observer) {
        this.f19982a = observer;
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public void dispose() {
        this.f19983b.dispose();
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public boolean isDisposed() {
        return this.f19983b.isDisposed();
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public void onComplete() {
        if (this.f19984c) {
            return;
        }
        this.f19984c = true;
        Disposable disposable = this.f19983b;
        Observer observer = this.f19982a;
        if (disposable == null) {
            NullPointerException nullPointerException = new NullPointerException("Subscription not set!");
            try {
                observer.onSubscribe(EmptyDisposable.INSTANCE);
                try {
                    observer.onError(nullPointerException);
                    return;
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    RxJavaPlugins.onError(new CompositeException(nullPointerException, th));
                    return;
                }
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                RxJavaPlugins.onError(new CompositeException(nullPointerException, th2));
                return;
            }
        }
        try {
            observer.onComplete();
        } catch (Throwable th3) {
            Exceptions.throwIfFatal(th3);
            RxJavaPlugins.onError(th3);
        }
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public void onError(@NonNull Throwable th) {
        if (this.f19984c) {
            RxJavaPlugins.onError(th);
            return;
        }
        this.f19984c = true;
        Disposable disposable = this.f19983b;
        Observer observer = this.f19982a;
        if (disposable == null) {
            NullPointerException nullPointerException = new NullPointerException("Subscription not set!");
            try {
                observer.onSubscribe(EmptyDisposable.INSTANCE);
                try {
                    observer.onError(new CompositeException(th, nullPointerException));
                    return;
                } catch (Throwable th2) {
                    Exceptions.throwIfFatal(th2);
                    RxJavaPlugins.onError(new CompositeException(th, nullPointerException, th2));
                    return;
                }
            } catch (Throwable th3) {
                Exceptions.throwIfFatal(th3);
                RxJavaPlugins.onError(new CompositeException(th, nullPointerException, th3));
                return;
            }
        }
        if (th == null) {
            th = ExceptionHelper.createNullPointerException("onError called with a null Throwable.");
        }
        try {
            observer.onError(th);
        } catch (Throwable th4) {
            Exceptions.throwIfFatal(th4);
            RxJavaPlugins.onError(new CompositeException(th, th4));
        }
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public void onNext(@NonNull T t) {
        if (this.f19984c) {
            return;
        }
        Disposable disposable = this.f19983b;
        Observer observer = this.f19982a;
        if (disposable == null) {
            this.f19984c = true;
            NullPointerException nullPointerException = new NullPointerException("Subscription not set!");
            try {
                observer.onSubscribe(EmptyDisposable.INSTANCE);
                try {
                    observer.onError(nullPointerException);
                    return;
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    RxJavaPlugins.onError(new CompositeException(nullPointerException, th));
                    return;
                }
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                RxJavaPlugins.onError(new CompositeException(nullPointerException, th2));
                return;
            }
        }
        if (t == null) {
            NullPointerException createNullPointerException = ExceptionHelper.createNullPointerException("onNext called with a null value.");
            try {
                this.f19983b.dispose();
                onError(createNullPointerException);
                return;
            } catch (Throwable th3) {
                Exceptions.throwIfFatal(th3);
                onError(new CompositeException(createNullPointerException, th3));
                return;
            }
        }
        try {
            observer.onNext(t);
        } catch (Throwable th4) {
            Exceptions.throwIfFatal(th4);
            try {
                this.f19983b.dispose();
                onError(th4);
            } catch (Throwable th5) {
                Exceptions.throwIfFatal(th5);
                onError(new CompositeException(th4, th5));
            }
        }
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public void onSubscribe(@NonNull Disposable disposable) {
        if (DisposableHelper.validate(this.f19983b, disposable)) {
            this.f19983b = disposable;
            try {
                this.f19982a.onSubscribe(this);
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                this.f19984c = true;
                try {
                    disposable.dispose();
                    RxJavaPlugins.onError(th);
                } catch (Throwable th2) {
                    Exceptions.throwIfFatal(th2);
                    RxJavaPlugins.onError(new CompositeException(th, th2));
                }
            }
        }
    }
}
