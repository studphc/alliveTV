package io.reactivex.rxjava3.observers;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.util.EndConsumerHelper;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public abstract class DisposableCompletableObserver implements CompletableObserver, Disposable {

    /* renamed from: a */
    public final AtomicReference f19970a = new AtomicReference();

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final void dispose() {
        DisposableHelper.dispose(this.f19970a);
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final boolean isDisposed() {
        if (this.f19970a.get() == DisposableHelper.DISPOSED) {
            return true;
        }
        return false;
    }

    public void onStart() {
    }

    @Override // io.reactivex.rxjava3.core.CompletableObserver
    public final void onSubscribe(@NonNull Disposable disposable) {
        if (EndConsumerHelper.setOnce((AtomicReference<Disposable>) this.f19970a, disposable, getClass())) {
            onStart();
        }
    }
}
