package io.reactivex.rxjava3.internal.observers;

import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;

/* loaded from: classes2.dex */
public final class DisposableLambdaObserver<T> implements Observer<T>, Disposable {

    /* renamed from: a */
    public final Observer f18607a;

    /* renamed from: b */
    public final Consumer f18608b;

    /* renamed from: c */
    public final Action f18609c;

    /* renamed from: d */
    public Disposable f18610d;

    public DisposableLambdaObserver(Observer<? super T> observer, Consumer<? super Disposable> consumer, Action action) {
        this.f18607a = observer;
        this.f18608b = consumer;
        this.f18609c = action;
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public void dispose() {
        Disposable disposable = this.f18610d;
        DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
        if (disposable != disposableHelper) {
            this.f18610d = disposableHelper;
            try {
                this.f18609c.run();
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                RxJavaPlugins.onError(th);
            }
            disposable.dispose();
        }
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public boolean isDisposed() {
        return this.f18610d.isDisposed();
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public void onComplete() {
        Disposable disposable = this.f18610d;
        DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
        if (disposable != disposableHelper) {
            this.f18610d = disposableHelper;
            this.f18607a.onComplete();
        }
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public void onError(Throwable th) {
        Disposable disposable = this.f18610d;
        DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
        if (disposable != disposableHelper) {
            this.f18610d = disposableHelper;
            this.f18607a.onError(th);
        } else {
            RxJavaPlugins.onError(th);
        }
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public void onNext(T t) {
        this.f18607a.onNext(t);
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public void onSubscribe(Disposable disposable) {
        Observer observer = this.f18607a;
        try {
            this.f18608b.accept(disposable);
            if (DisposableHelper.validate(this.f18610d, disposable)) {
                this.f18610d = disposable;
                observer.onSubscribe(this);
            }
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            disposable.dispose();
            this.f18610d = DisposableHelper.DISPOSED;
            EmptyDisposable.error(th, (Observer<?>) observer);
        }
    }
}
