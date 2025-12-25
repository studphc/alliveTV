package io.reactivex.rxjava3.internal.operators.completable;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import java.util.Objects;

/* loaded from: classes2.dex */
public final class CompletableErrorSupplier extends Completable {

    /* renamed from: a */
    public final Supplier f18668a;

    public CompletableErrorSupplier(Supplier<? extends Throwable> supplier) {
        this.f18668a = supplier;
    }

    @Override // io.reactivex.rxjava3.core.Completable
    public void subscribeActual(CompletableObserver completableObserver) {
        try {
            Object obj = this.f18668a.get();
            Objects.requireNonNull(obj, "The error returned is null");
            th = (Throwable) obj;
        } catch (Throwable th) {
            th = th;
            Exceptions.throwIfFatal(th);
        }
        EmptyDisposable.error(th, completableObserver);
    }
}
