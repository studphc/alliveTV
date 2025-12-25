package io.reactivex.rxjava3.internal.operators.completable;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;

/* loaded from: classes2.dex */
public final class CompletableError extends Completable {

    /* renamed from: a */
    public final Throwable f18667a;

    public CompletableError(Throwable th) {
        this.f18667a = th;
    }

    @Override // io.reactivex.rxjava3.core.Completable
    public void subscribeActual(CompletableObserver completableObserver) {
        EmptyDisposable.error(this.f18667a, completableObserver);
    }
}
