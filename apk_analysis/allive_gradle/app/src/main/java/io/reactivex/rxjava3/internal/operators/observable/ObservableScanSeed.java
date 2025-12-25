package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.BiFunction;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import java.util.Objects;
import p000.AbstractC1607o2;
import p000.ny1;

/* loaded from: classes2.dex */
public final class ObservableScanSeed<T, R> extends AbstractC1607o2 {

    /* renamed from: a */
    public final BiFunction f19546a;

    /* renamed from: b */
    public final Supplier f19547b;

    public ObservableScanSeed(ObservableSource<T> observableSource, Supplier<R> supplier, BiFunction<R, ? super T, R> biFunction) {
        super(observableSource);
        this.f19546a = biFunction;
        this.f19547b = supplier;
    }

    @Override // io.reactivex.rxjava3.core.Observable
    public void subscribeActual(Observer<? super R> observer) {
        try {
            Object obj = this.f19547b.get();
            Objects.requireNonNull(obj, "The seed supplied is null");
            this.source.subscribe(new ny1(observer, this.f19546a, obj));
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            EmptyDisposable.error(th, observer);
        }
    }
}
