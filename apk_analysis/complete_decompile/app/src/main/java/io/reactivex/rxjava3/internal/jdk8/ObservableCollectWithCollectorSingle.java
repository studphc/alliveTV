package io.reactivex.rxjava3.internal.jdk8;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import io.reactivex.rxjava3.internal.fuseable.FuseToObservable;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import p000.du1;

/* loaded from: classes2.dex */
public final class ObservableCollectWithCollectorSingle<T, A, R> extends Single<R> implements FuseToObservable<R> {

    /* renamed from: a */
    public final Observable f18556a;

    /* renamed from: b */
    public final Collector f18557b;

    public ObservableCollectWithCollectorSingle(Observable<T> observable, Collector<? super T, A, R> collector) {
        this.f18556a = observable;
        this.f18557b = collector;
    }

    @Override // io.reactivex.rxjava3.internal.fuseable.FuseToObservable
    public Observable<R> fuseToObservable() {
        return new ObservableCollectWithCollector(this.f18556a, this.f18557b);
    }

    @Override // io.reactivex.rxjava3.core.Single
    public void subscribeActual(@NonNull SingleObserver<? super R> singleObserver) {
        Supplier supplier;
        Object obj;
        BiConsumer accumulator;
        Function finisher;
        try {
            supplier = this.f18557b.supplier();
            obj = supplier.get();
            accumulator = this.f18557b.accumulator();
            finisher = this.f18557b.finisher();
            this.f18556a.subscribe(new du1(singleObserver, obj, accumulator, finisher));
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            EmptyDisposable.error(th, singleObserver);
        }
    }
}
