package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.BiFunction;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import java.util.Objects;
import p000.uw1;

/* loaded from: classes2.dex */
public final class ObservableReduceWithSingle<T, R> extends Single<R> {

    /* renamed from: a */
    public final ObservableSource f19516a;

    /* renamed from: b */
    public final Supplier f19517b;

    /* renamed from: c */
    public final BiFunction f19518c;

    public ObservableReduceWithSingle(ObservableSource<T> observableSource, Supplier<R> supplier, BiFunction<R, ? super T, R> biFunction) {
        this.f19516a = observableSource;
        this.f19517b = supplier;
        this.f19518c = biFunction;
    }

    @Override // io.reactivex.rxjava3.core.Single
    public void subscribeActual(SingleObserver<? super R> singleObserver) {
        try {
            Object obj = this.f19517b.get();
            Objects.requireNonNull(obj, "The seedSupplier returned a null value");
            this.f19516a.subscribe(new uw1(singleObserver, this.f19518c, obj));
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            EmptyDisposable.error(th, singleObserver);
        }
    }
}
