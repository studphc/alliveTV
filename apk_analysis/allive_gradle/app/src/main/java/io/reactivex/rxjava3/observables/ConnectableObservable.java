package io.reactivex.rxjava3.observables;

import io.reactivex.rxjava3.annotations.CheckReturnValue;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.annotations.SchedulerSupport;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.internal.functions.Functions;
import io.reactivex.rxjava3.internal.functions.ObjectHelper;
import io.reactivex.rxjava3.internal.operators.observable.ObservableAutoConnect;
import io.reactivex.rxjava3.internal.operators.observable.ObservableRefCount;
import io.reactivex.rxjava3.internal.util.ConnectConsumer;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import io.reactivex.rxjava3.schedulers.Schedulers;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public abstract class ConnectableObservable<T> extends Observable<T> {
    @CheckReturnValue
    @NonNull
    @SchedulerSupport(SchedulerSupport.NONE)
    public Observable<T> autoConnect() {
        return autoConnect(1);
    }

    @NonNull
    @SchedulerSupport(SchedulerSupport.NONE)
    public final Disposable connect() {
        ConnectConsumer connectConsumer = new ConnectConsumer();
        connect(connectConsumer);
        return connectConsumer.disposable;
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    public abstract void connect(@NonNull Consumer<? super Disposable> consumer);

    @CheckReturnValue
    @NonNull
    @SchedulerSupport(SchedulerSupport.NONE)
    public Observable<T> refCount() {
        return RxJavaPlugins.onAssembly(new ObservableRefCount(this));
    }

    @SchedulerSupport(SchedulerSupport.NONE)
    public abstract void reset();

    @CheckReturnValue
    @NonNull
    @SchedulerSupport(SchedulerSupport.NONE)
    public Observable<T> autoConnect(int i) {
        return autoConnect(i, Functions.emptyConsumer());
    }

    @CheckReturnValue
    @NonNull
    @SchedulerSupport(SchedulerSupport.NONE)
    public final Observable<T> refCount(int i) {
        return refCount(i, 0L, TimeUnit.NANOSECONDS, Schedulers.trampoline());
    }

    @CheckReturnValue
    @NonNull
    @SchedulerSupport(SchedulerSupport.NONE)
    public Observable<T> autoConnect(int i, @NonNull Consumer<? super Disposable> consumer) {
        Objects.requireNonNull(consumer, "connection is null");
        if (i <= 0) {
            connect(consumer);
            return RxJavaPlugins.onAssembly((ConnectableObservable) this);
        }
        return RxJavaPlugins.onAssembly(new ObservableAutoConnect(this, i, consumer));
    }

    @CheckReturnValue
    @NonNull
    @SchedulerSupport(SchedulerSupport.COMPUTATION)
    public final Observable<T> refCount(long j, @NonNull TimeUnit timeUnit) {
        return refCount(1, j, timeUnit, Schedulers.computation());
    }

    @CheckReturnValue
    @NonNull
    @SchedulerSupport(SchedulerSupport.CUSTOM)
    public final Observable<T> refCount(long j, @NonNull TimeUnit timeUnit, @NonNull Scheduler scheduler) {
        return refCount(1, j, timeUnit, scheduler);
    }

    @CheckReturnValue
    @NonNull
    @SchedulerSupport(SchedulerSupport.COMPUTATION)
    public final Observable<T> refCount(int i, long j, @NonNull TimeUnit timeUnit) {
        return refCount(i, j, timeUnit, Schedulers.computation());
    }

    @CheckReturnValue
    @NonNull
    @SchedulerSupport(SchedulerSupport.CUSTOM)
    public final Observable<T> refCount(int i, long j, @NonNull TimeUnit timeUnit, @NonNull Scheduler scheduler) {
        ObjectHelper.verifyPositive(i, "observerCount");
        Objects.requireNonNull(timeUnit, "unit is null");
        Objects.requireNonNull(scheduler, "scheduler is null");
        return RxJavaPlugins.onAssembly(new ObservableRefCount(this, i, j, timeUnit, scheduler));
    }
}
