package p000;

import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;

/* loaded from: classes2.dex */
public final class yi2 implements SingleObserver, Disposable {

    /* renamed from: a */
    public final SingleObserver f28969a;

    /* renamed from: b */
    public final Consumer f28970b;

    /* renamed from: c */
    public final Action f28971c;

    /* renamed from: d */
    public Disposable f28972d;

    public yi2(SingleObserver singleObserver, Consumer consumer, Action action) {
        this.f28969a = singleObserver;
        this.f28970b = consumer;
        this.f28971c = action;
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final void dispose() {
        try {
            this.f28971c.run();
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            RxJavaPlugins.onError(th);
        }
        this.f28972d.dispose();
        this.f28972d = DisposableHelper.DISPOSED;
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final boolean isDisposed() {
        return this.f28972d.isDisposed();
    }

    @Override // io.reactivex.rxjava3.core.SingleObserver
    public final void onError(Throwable th) {
        Disposable disposable = this.f28972d;
        DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
        if (disposable != disposableHelper) {
            this.f28972d = disposableHelper;
            this.f28969a.onError(th);
        } else {
            RxJavaPlugins.onError(th);
        }
    }

    @Override // io.reactivex.rxjava3.core.SingleObserver
    public final void onSubscribe(Disposable disposable) {
        SingleObserver singleObserver = this.f28969a;
        try {
            this.f28970b.accept(disposable);
            if (DisposableHelper.validate(this.f28972d, disposable)) {
                this.f28972d = disposable;
                singleObserver.onSubscribe(this);
            }
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            disposable.dispose();
            this.f28972d = DisposableHelper.DISPOSED;
            EmptyDisposable.error(th, (SingleObserver<?>) singleObserver);
        }
    }

    @Override // io.reactivex.rxjava3.core.SingleObserver
    public final void onSuccess(Object obj) {
        Disposable disposable = this.f28972d;
        DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
        if (disposable != disposableHelper) {
            this.f28972d = disposableHelper;
            this.f28969a.onSuccess(obj);
        }
    }
}
