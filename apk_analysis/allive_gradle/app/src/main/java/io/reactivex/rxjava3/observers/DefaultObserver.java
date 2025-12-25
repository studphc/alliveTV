package io.reactivex.rxjava3.observers;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.util.EndConsumerHelper;

/* loaded from: classes2.dex */
public abstract class DefaultObserver<T> implements Observer<T> {

    /* renamed from: a */
    public Disposable f19969a;

    public final void cancel() {
        Disposable disposable = this.f19969a;
        this.f19969a = DisposableHelper.DISPOSED;
        disposable.dispose();
    }

    public void onStart() {
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onSubscribe(@NonNull Disposable disposable) {
        if (EndConsumerHelper.validate(this.f19969a, disposable, getClass())) {
            this.f19969a = disposable;
            onStart();
        }
    }
}
