package io.reactivex.rxjava3.internal.operators.mixed;

import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.Notification;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;

/* loaded from: classes2.dex */
public final class MaterializeSingleObserver<T> implements SingleObserver<T>, MaybeObserver<T>, CompletableObserver, Disposable {

    /* renamed from: a */
    public final SingleObserver f19287a;

    /* renamed from: b */
    public Disposable f19288b;

    public MaterializeSingleObserver(SingleObserver<? super Notification<T>> singleObserver) {
        this.f19287a = singleObserver;
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public void dispose() {
        this.f19288b.dispose();
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public boolean isDisposed() {
        return this.f19288b.isDisposed();
    }

    @Override // io.reactivex.rxjava3.core.MaybeObserver
    public void onComplete() {
        this.f19287a.onSuccess(Notification.createOnComplete());
    }

    @Override // io.reactivex.rxjava3.core.SingleObserver
    public void onError(Throwable th) {
        this.f19287a.onSuccess(Notification.createOnError(th));
    }

    @Override // io.reactivex.rxjava3.core.SingleObserver
    public void onSubscribe(Disposable disposable) {
        if (DisposableHelper.validate(this.f19288b, disposable)) {
            this.f19288b = disposable;
            this.f19287a.onSubscribe(this);
        }
    }

    @Override // io.reactivex.rxjava3.core.SingleObserver
    public void onSuccess(T t) {
        this.f19287a.onSuccess(Notification.createOnNext(t));
    }
}
