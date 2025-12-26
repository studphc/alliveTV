package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import java.util.Objects;

/* loaded from: classes2.dex */
public final class ObservableDefer<T> extends Observable<T> {

    /* renamed from: a */
    public final Supplier f19390a;

    public ObservableDefer(Supplier<? extends ObservableSource<? extends T>> supplier) {
        this.f19390a = supplier;
    }

    @Override // io.reactivex.rxjava3.core.Observable
    public void subscribeActual(Observer<? super T> observer) {
        try {
            Object obj = this.f19390a.get();
            Objects.requireNonNull(obj, "The supplier returned a null ObservableSource");
            ((ObservableSource) obj).subscribe(observer);
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            EmptyDisposable.error(th, observer);
        }
    }
}
