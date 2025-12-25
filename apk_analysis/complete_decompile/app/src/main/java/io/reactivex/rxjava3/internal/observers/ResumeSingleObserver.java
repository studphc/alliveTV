package io.reactivex.rxjava3.internal.observers;

import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class ResumeSingleObserver<T> implements SingleObserver<T> {

    /* renamed from: a */
    public final AtomicReference f18631a;

    /* renamed from: b */
    public final SingleObserver f18632b;

    public ResumeSingleObserver(AtomicReference<Disposable> atomicReference, SingleObserver<? super T> singleObserver) {
        this.f18631a = atomicReference;
        this.f18632b = singleObserver;
    }

    @Override // io.reactivex.rxjava3.core.SingleObserver
    public void onError(Throwable th) {
        this.f18632b.onError(th);
    }

    @Override // io.reactivex.rxjava3.core.SingleObserver
    public void onSubscribe(Disposable disposable) {
        DisposableHelper.replace(this.f18631a, disposable);
    }

    @Override // io.reactivex.rxjava3.core.SingleObserver
    public void onSuccess(T t) {
        this.f18632b.onSuccess(t);
    }
}
