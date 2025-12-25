package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import java.util.Collection;
import p000.AbstractC1607o2;
import p000.tw1;

/* loaded from: classes2.dex */
public final class ObservableToList<T, U extends Collection<? super T>> extends AbstractC1607o2 {

    /* renamed from: a */
    public final Supplier f19603a;

    public ObservableToList(ObservableSource<T> observableSource, Supplier<U> supplier) {
        super(observableSource);
        this.f19603a = supplier;
    }

    @Override // io.reactivex.rxjava3.core.Observable
    public void subscribeActual(Observer<? super U> observer) {
        try {
            this.source.subscribe(new tw1(observer, (Collection) ExceptionHelper.nullCheck(this.f19603a.get(), "The collectionSupplier returned a null Collection."), 2));
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            EmptyDisposable.error(th, observer);
        }
    }
}
