package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;

/* loaded from: classes2.dex */
public final class ObservableError<T> extends Observable<T> {

    /* renamed from: a */
    public final Supplier f19418a;

    public ObservableError(Supplier<? extends Throwable> supplier) {
        this.f19418a = supplier;
    }

    @Override // io.reactivex.rxjava3.core.Observable
    public void subscribeActual(Observer<? super T> observer) {
        try {
            th = (Throwable) ExceptionHelper.nullCheck(this.f19418a.get(), "Supplier returned a null Throwable.");
        } catch (Throwable th) {
            th = th;
            Exceptions.throwIfFatal(th);
        }
        EmptyDisposable.error(th, observer);
    }
}
