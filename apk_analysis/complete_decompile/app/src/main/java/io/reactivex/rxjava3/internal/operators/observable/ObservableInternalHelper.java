package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.Emitter;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.functions.BiConsumer;
import io.reactivex.rxjava3.functions.BiFunction;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.observables.ConnectableObservable;
import java.util.concurrent.TimeUnit;
import p000.an0;
import p000.bn0;
import p000.dn0;
import p000.en0;
import p000.fn0;
import p000.gn0;
import p000.hn0;
import p000.jn0;
import p000.pw1;
import p000.zm0;

/* loaded from: classes2.dex */
public final class ObservableInternalHelper {
    public static <T, U> Function<T, ObservableSource<U>> flatMapIntoIterable(Function<? super T, ? extends Iterable<? extends U>> function) {
        return new bn0(function, 2);
    }

    public static <T, U, R> Function<T, ObservableSource<R>> flatMapWithCombiner(Function<? super T, ? extends ObservableSource<? extends U>> function, BiFunction<? super T, ? super U, ? extends R> biFunction) {
        return new dn0(function, biFunction, 1);
    }

    public static <T, U> Function<T, ObservableSource<T>> itemDelay(Function<? super T, ? extends ObservableSource<U>> function) {
        return new bn0(function, 3);
    }

    public static <T> Action observerOnComplete(Observer<T> observer) {
        return new hn0(3, observer);
    }

    public static <T> Consumer<Throwable> observerOnError(Observer<T> observer) {
        return new pw1(observer, 0);
    }

    public static <T> Consumer<T> observerOnNext(Observer<T> observer) {
        return new pw1(observer, 1);
    }

    public static <T> Supplier<ConnectableObservable<T>> replaySupplier(Observable<T> observable) {
        return new en0(1, observable);
    }

    public static <T, S> BiFunction<S, Emitter<T>, S> simpleBiGenerator(BiConsumer<S, Emitter<T>> biConsumer) {
        return new fn0(biConsumer, 1);
    }

    public static <T, S> BiFunction<S, Emitter<T>, S> simpleGenerator(Consumer<Emitter<T>> consumer) {
        return new gn0(consumer, 1);
    }

    public static <T> Supplier<ConnectableObservable<T>> replaySupplier(Observable<T> observable, int i, boolean z) {
        return new zm0(observable, i, z, 1);
    }

    public static <T> Supplier<ConnectableObservable<T>> replaySupplier(Observable<T> observable, int i, long j, TimeUnit timeUnit, Scheduler scheduler, boolean z) {
        return new an0(observable, i, j, timeUnit, scheduler, z, 1);
    }

    public static <T> Supplier<ConnectableObservable<T>> replaySupplier(Observable<T> observable, long j, TimeUnit timeUnit, Scheduler scheduler, boolean z) {
        return new jn0(observable, j, timeUnit, scheduler, z, 1);
    }
}
