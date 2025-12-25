package p000;

import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;

/* loaded from: classes2.dex */
public final class ji1 implements MaybeObserver, Disposable {

    /* renamed from: a */
    public final MaybeObserver f20510a;

    /* renamed from: b */
    public final Consumer f20511b;

    /* renamed from: c */
    public final Action f20512c;

    /* renamed from: d */
    public Disposable f20513d;

    public ji1(MaybeObserver maybeObserver, Consumer consumer, Action action) {
        this.f20510a = maybeObserver;
        this.f20511b = consumer;
        this.f20512c = action;
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final void dispose() {
        try {
            this.f20512c.run();
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            RxJavaPlugins.onError(th);
        }
        this.f20513d.dispose();
        this.f20513d = DisposableHelper.DISPOSED;
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final boolean isDisposed() {
        return this.f20513d.isDisposed();
    }

    @Override // io.reactivex.rxjava3.core.MaybeObserver
    public final void onComplete() {
        Disposable disposable = this.f20513d;
        DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
        if (disposable != disposableHelper) {
            this.f20513d = disposableHelper;
            this.f20510a.onComplete();
        }
    }

    @Override // io.reactivex.rxjava3.core.MaybeObserver
    public final void onError(Throwable th) {
        Disposable disposable = this.f20513d;
        DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
        if (disposable != disposableHelper) {
            this.f20513d = disposableHelper;
            this.f20510a.onError(th);
        } else {
            RxJavaPlugins.onError(th);
        }
    }

    @Override // io.reactivex.rxjava3.core.MaybeObserver
    public final void onSubscribe(Disposable disposable) {
        MaybeObserver maybeObserver = this.f20510a;
        try {
            this.f20511b.accept(disposable);
            if (DisposableHelper.validate(this.f20513d, disposable)) {
                this.f20513d = disposable;
                maybeObserver.onSubscribe(this);
            }
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            disposable.dispose();
            this.f20513d = DisposableHelper.DISPOSED;
            EmptyDisposable.error(th, (MaybeObserver<?>) maybeObserver);
        }
    }

    @Override // io.reactivex.rxjava3.core.MaybeObserver
    public final void onSuccess(Object obj) {
        Disposable disposable = this.f20513d;
        DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
        if (disposable != disposableHelper) {
            this.f20513d = disposableHelper;
            this.f20510a.onSuccess(obj);
        }
    }
}
