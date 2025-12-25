package io.reactivex.rxjava3.internal.jdk8;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import p000.cu1;

/* loaded from: classes2.dex */
public final class ObservableCollectWithCollector<T, A, R> extends Observable<R> {

    /* renamed from: a */
    public final Observable f18554a;

    /* renamed from: b */
    public final Collector f18555b;

    public ObservableCollectWithCollector(Observable<T> observable, Collector<? super T, A, R> collector) {
        this.f18554a = observable;
        this.f18555b = collector;
    }

    @Override // io.reactivex.rxjava3.core.Observable
    public void subscribeActual(@NonNull Observer<? super R> observer) {
        Supplier supplier;
        Object obj;
        BiConsumer accumulator;
        Function finisher;
        try {
            supplier = this.f18555b.supplier();
            obj = supplier.get();
            accumulator = this.f18555b.accumulator();
            finisher = this.f18555b.finisher();
            this.f18554a.subscribe(new cu1(observer, obj, accumulator, finisher));
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            EmptyDisposable.error(th, observer);
        }
    }
}
