package io.reactivex.rxjava3.plugins;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.annotations.Nullable;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.exceptions.CompositeException;
import io.reactivex.rxjava3.exceptions.MissingBackpressureException;
import io.reactivex.rxjava3.exceptions.OnErrorNotImplementedException;
import io.reactivex.rxjava3.exceptions.UndeliverableException;
import io.reactivex.rxjava3.flowables.ConnectableFlowable;
import io.reactivex.rxjava3.functions.BiFunction;
import io.reactivex.rxjava3.functions.BooleanSupplier;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.schedulers.ComputationScheduler;
import io.reactivex.rxjava3.internal.schedulers.ExecutorScheduler;
import io.reactivex.rxjava3.internal.schedulers.IoScheduler;
import io.reactivex.rxjava3.internal.schedulers.NewThreadScheduler;
import io.reactivex.rxjava3.internal.schedulers.SingleScheduler;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import io.reactivex.rxjava3.observables.ConnectableObservable;
import io.reactivex.rxjava3.parallel.ParallelFlowable;
import java.util.Objects;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadFactory;
import org.reactivestreams.Subscriber;

/* loaded from: classes2.dex */
public final class RxJavaPlugins {

    /* renamed from: A */
    public static volatile boolean f20010A;

    /* renamed from: a */
    public static volatile Consumer f20011a;

    /* renamed from: b */
    public static volatile Function f20012b;

    /* renamed from: c */
    public static volatile Function f20013c;

    /* renamed from: d */
    public static volatile Function f20014d;

    /* renamed from: e */
    public static volatile Function f20015e;

    /* renamed from: f */
    public static volatile Function f20016f;

    /* renamed from: g */
    public static volatile Function f20017g;

    /* renamed from: h */
    public static volatile Function f20018h;

    /* renamed from: i */
    public static volatile Function f20019i;

    /* renamed from: j */
    public static volatile Function f20020j;

    /* renamed from: k */
    public static volatile Function f20021k;

    /* renamed from: l */
    public static volatile Function f20022l;

    /* renamed from: m */
    public static volatile Function f20023m;

    /* renamed from: n */
    public static volatile Function f20024n;

    /* renamed from: o */
    public static volatile Function f20025o;

    /* renamed from: p */
    public static volatile Function f20026p;

    /* renamed from: q */
    public static volatile Function f20027q;

    /* renamed from: r */
    public static volatile Function f20028r;

    /* renamed from: s */
    public static volatile BiFunction f20029s;

    /* renamed from: t */
    public static volatile BiFunction f20030t;

    /* renamed from: u */
    public static volatile BiFunction f20031u;

    /* renamed from: v */
    public static volatile BiFunction f20032v;

    /* renamed from: w */
    public static volatile BiFunction f20033w;

    /* renamed from: x */
    public static volatile BiFunction f20034x;

    /* renamed from: y */
    public static volatile BooleanSupplier f20035y;

    /* renamed from: z */
    public static volatile boolean f20036z;

    /* renamed from: a */
    public static Object m5306a(BiFunction biFunction, Object obj, Object obj2) {
        try {
            return biFunction.apply(obj, obj2);
        } catch (Throwable th) {
            throw ExceptionHelper.wrapOrThrow(th);
        }
    }

    /* renamed from: b */
    public static Object m5307b(Object obj, Function function) {
        try {
            return function.apply(obj);
        } catch (Throwable th) {
            throw ExceptionHelper.wrapOrThrow(th);
        }
    }

    /* renamed from: c */
    public static Scheduler m5308c(Supplier supplier) {
        try {
            Object obj = supplier.get();
            Objects.requireNonNull(obj, "Scheduler Supplier result can't be null");
            return (Scheduler) obj;
        } catch (Throwable th) {
            throw ExceptionHelper.wrapOrThrow(th);
        }
    }

    @NonNull
    public static Scheduler createComputationScheduler(@NonNull ThreadFactory threadFactory) {
        Objects.requireNonNull(threadFactory, "threadFactory is null");
        return new ComputationScheduler(threadFactory);
    }

    @NonNull
    public static Scheduler createExecutorScheduler(@NonNull Executor executor, boolean z, boolean z2) {
        return new ExecutorScheduler(executor, z, z2);
    }

    @NonNull
    public static Scheduler createIoScheduler(@NonNull ThreadFactory threadFactory) {
        Objects.requireNonNull(threadFactory, "threadFactory is null");
        return new IoScheduler(threadFactory);
    }

    @NonNull
    public static Scheduler createNewThreadScheduler(@NonNull ThreadFactory threadFactory) {
        Objects.requireNonNull(threadFactory, "threadFactory is null");
        return new NewThreadScheduler(threadFactory);
    }

    @NonNull
    public static Scheduler createSingleScheduler(@NonNull ThreadFactory threadFactory) {
        Objects.requireNonNull(threadFactory, "threadFactory is null");
        return new SingleScheduler(threadFactory);
    }

    @Nullable
    public static Function<? super Scheduler, ? extends Scheduler> getComputationSchedulerHandler() {
        return f20017g;
    }

    @Nullable
    public static Consumer<? super Throwable> getErrorHandler() {
        return f20011a;
    }

    @Nullable
    public static Function<? super Supplier<Scheduler>, ? extends Scheduler> getInitComputationSchedulerHandler() {
        return f20013c;
    }

    @Nullable
    public static Function<? super Supplier<Scheduler>, ? extends Scheduler> getInitIoSchedulerHandler() {
        return f20015e;
    }

    @Nullable
    public static Function<? super Supplier<Scheduler>, ? extends Scheduler> getInitNewThreadSchedulerHandler() {
        return f20016f;
    }

    @Nullable
    public static Function<? super Supplier<Scheduler>, ? extends Scheduler> getInitSingleSchedulerHandler() {
        return f20014d;
    }

    @Nullable
    public static Function<? super Scheduler, ? extends Scheduler> getIoSchedulerHandler() {
        return f20019i;
    }

    @Nullable
    public static Function<? super Scheduler, ? extends Scheduler> getNewThreadSchedulerHandler() {
        return f20020j;
    }

    @Nullable
    public static BooleanSupplier getOnBeforeBlocking() {
        return f20035y;
    }

    @Nullable
    public static Function<? super Completable, ? extends Completable> getOnCompletableAssembly() {
        return f20027q;
    }

    @Nullable
    public static BiFunction<? super Completable, ? super CompletableObserver, ? extends CompletableObserver> getOnCompletableSubscribe() {
        return f20033w;
    }

    @Nullable
    public static Function<? super ConnectableFlowable, ? extends ConnectableFlowable> getOnConnectableFlowableAssembly() {
        return f20022l;
    }

    @Nullable
    public static Function<? super ConnectableObservable, ? extends ConnectableObservable> getOnConnectableObservableAssembly() {
        return f20024n;
    }

    @Nullable
    public static Function<? super Flowable, ? extends Flowable> getOnFlowableAssembly() {
        return f20021k;
    }

    @Nullable
    public static BiFunction<? super Flowable, ? super Subscriber, ? extends Subscriber> getOnFlowableSubscribe() {
        return f20029s;
    }

    @Nullable
    public static Function<? super Maybe, ? extends Maybe> getOnMaybeAssembly() {
        return f20025o;
    }

    @Nullable
    public static BiFunction<? super Maybe, ? super MaybeObserver, ? extends MaybeObserver> getOnMaybeSubscribe() {
        return f20030t;
    }

    @Nullable
    public static Function<? super Observable, ? extends Observable> getOnObservableAssembly() {
        return f20023m;
    }

    @Nullable
    public static BiFunction<? super Observable, ? super Observer, ? extends Observer> getOnObservableSubscribe() {
        return f20031u;
    }

    @Nullable
    public static Function<? super ParallelFlowable, ? extends ParallelFlowable> getOnParallelAssembly() {
        return f20028r;
    }

    @Nullable
    public static BiFunction<? super ParallelFlowable, ? super Subscriber[], ? extends Subscriber[]> getOnParallelSubscribe() {
        return f20034x;
    }

    @Nullable
    public static Function<? super Single, ? extends Single> getOnSingleAssembly() {
        return f20026p;
    }

    @Nullable
    public static BiFunction<? super Single, ? super SingleObserver, ? extends SingleObserver> getOnSingleSubscribe() {
        return f20032v;
    }

    @Nullable
    public static Function<? super Runnable, ? extends Runnable> getScheduleHandler() {
        return f20012b;
    }

    @Nullable
    public static Function<? super Scheduler, ? extends Scheduler> getSingleSchedulerHandler() {
        return f20018h;
    }

    @NonNull
    public static Scheduler initComputationScheduler(@NonNull Supplier<Scheduler> supplier) {
        Objects.requireNonNull(supplier, "Scheduler Supplier can't be null");
        Function function = f20013c;
        if (function == null) {
            return m5308c(supplier);
        }
        Object m5307b = m5307b(supplier, function);
        Objects.requireNonNull(m5307b, "Scheduler Supplier result can't be null");
        return (Scheduler) m5307b;
    }

    @NonNull
    public static Scheduler initIoScheduler(@NonNull Supplier<Scheduler> supplier) {
        Objects.requireNonNull(supplier, "Scheduler Supplier can't be null");
        Function function = f20015e;
        if (function == null) {
            return m5308c(supplier);
        }
        Object m5307b = m5307b(supplier, function);
        Objects.requireNonNull(m5307b, "Scheduler Supplier result can't be null");
        return (Scheduler) m5307b;
    }

    @NonNull
    public static Scheduler initNewThreadScheduler(@NonNull Supplier<Scheduler> supplier) {
        Objects.requireNonNull(supplier, "Scheduler Supplier can't be null");
        Function function = f20016f;
        if (function == null) {
            return m5308c(supplier);
        }
        Object m5307b = m5307b(supplier, function);
        Objects.requireNonNull(m5307b, "Scheduler Supplier result can't be null");
        return (Scheduler) m5307b;
    }

    @NonNull
    public static Scheduler initSingleScheduler(@NonNull Supplier<Scheduler> supplier) {
        Objects.requireNonNull(supplier, "Scheduler Supplier can't be null");
        Function function = f20014d;
        if (function == null) {
            return m5308c(supplier);
        }
        Object m5307b = m5307b(supplier, function);
        Objects.requireNonNull(m5307b, "Scheduler Supplier result can't be null");
        return (Scheduler) m5307b;
    }

    public static boolean isFailOnNonBlockingScheduler() {
        return f20010A;
    }

    public static boolean isLockdown() {
        return f20036z;
    }

    public static void lockdown() {
        f20036z = true;
    }

    @NonNull
    public static <T> Maybe<T> onAssembly(@NonNull Maybe<T> maybe) {
        Function function = f20025o;
        return function != null ? (Maybe) m5307b(maybe, function) : maybe;
    }

    public static boolean onBeforeBlocking() {
        BooleanSupplier booleanSupplier = f20035y;
        if (booleanSupplier != null) {
            try {
                return booleanSupplier.getAsBoolean();
            } catch (Throwable th) {
                throw ExceptionHelper.wrapOrThrow(th);
            }
        }
        return false;
    }

    @NonNull
    public static Scheduler onComputationScheduler(@NonNull Scheduler scheduler) {
        Function function = f20017g;
        if (function == null) {
            return scheduler;
        }
        return (Scheduler) m5307b(scheduler, function);
    }

    public static void onError(@NonNull Throwable th) {
        Consumer consumer = f20011a;
        if (th == null) {
            th = ExceptionHelper.createNullPointerException("onError called with a null Throwable.");
        } else if (!(th instanceof OnErrorNotImplementedException) && !(th instanceof MissingBackpressureException) && !(th instanceof IllegalStateException) && !(th instanceof NullPointerException) && !(th instanceof IllegalArgumentException) && !(th instanceof CompositeException)) {
            th = new UndeliverableException(th);
        }
        if (consumer != null) {
            try {
                consumer.accept(th);
                return;
            } catch (Throwable th2) {
                th2.printStackTrace();
                Thread currentThread = Thread.currentThread();
                currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, th2);
            }
        }
        th.printStackTrace();
        Thread currentThread2 = Thread.currentThread();
        currentThread2.getUncaughtExceptionHandler().uncaughtException(currentThread2, th);
    }

    @NonNull
    public static Scheduler onIoScheduler(@NonNull Scheduler scheduler) {
        Function function = f20019i;
        if (function == null) {
            return scheduler;
        }
        return (Scheduler) m5307b(scheduler, function);
    }

    @NonNull
    public static Scheduler onNewThreadScheduler(@NonNull Scheduler scheduler) {
        Function function = f20020j;
        if (function == null) {
            return scheduler;
        }
        return (Scheduler) m5307b(scheduler, function);
    }

    @NonNull
    public static Runnable onSchedule(@NonNull Runnable runnable) {
        Objects.requireNonNull(runnable, "run is null");
        Function function = f20012b;
        if (function == null) {
            return runnable;
        }
        return (Runnable) m5307b(runnable, function);
    }

    @NonNull
    public static Scheduler onSingleScheduler(@NonNull Scheduler scheduler) {
        Function function = f20018h;
        if (function == null) {
            return scheduler;
        }
        return (Scheduler) m5307b(scheduler, function);
    }

    @NonNull
    public static <T> Subscriber<? super T> onSubscribe(@NonNull Flowable<T> flowable, @NonNull Subscriber<? super T> subscriber) {
        BiFunction biFunction = f20029s;
        return biFunction != null ? (Subscriber) m5306a(biFunction, flowable, subscriber) : subscriber;
    }

    public static void reset() {
        setErrorHandler(null);
        setScheduleHandler(null);
        setComputationSchedulerHandler(null);
        setInitComputationSchedulerHandler(null);
        setIoSchedulerHandler(null);
        setInitIoSchedulerHandler(null);
        setSingleSchedulerHandler(null);
        setInitSingleSchedulerHandler(null);
        setNewThreadSchedulerHandler(null);
        setInitNewThreadSchedulerHandler(null);
        setOnFlowableAssembly(null);
        setOnFlowableSubscribe(null);
        setOnObservableAssembly(null);
        setOnObservableSubscribe(null);
        setOnSingleAssembly(null);
        setOnSingleSubscribe(null);
        setOnCompletableAssembly(null);
        setOnCompletableSubscribe(null);
        setOnConnectableFlowableAssembly(null);
        setOnConnectableObservableAssembly(null);
        setOnMaybeAssembly(null);
        setOnMaybeSubscribe(null);
        setOnParallelAssembly(null);
        setOnParallelSubscribe(null);
        setFailOnNonBlockingScheduler(false);
        setOnBeforeBlocking(null);
    }

    public static void setComputationSchedulerHandler(@Nullable Function<? super Scheduler, ? extends Scheduler> function) {
        if (!f20036z) {
            f20017g = function;
            return;
        }
        throw new IllegalStateException("Plugins can't be changed anymore");
    }

    public static void setErrorHandler(@Nullable Consumer<? super Throwable> consumer) {
        if (!f20036z) {
            f20011a = consumer;
            return;
        }
        throw new IllegalStateException("Plugins can't be changed anymore");
    }

    public static void setFailOnNonBlockingScheduler(boolean z) {
        if (!f20036z) {
            f20010A = z;
            return;
        }
        throw new IllegalStateException("Plugins can't be changed anymore");
    }

    public static void setInitComputationSchedulerHandler(@Nullable Function<? super Supplier<Scheduler>, ? extends Scheduler> function) {
        if (!f20036z) {
            f20013c = function;
            return;
        }
        throw new IllegalStateException("Plugins can't be changed anymore");
    }

    public static void setInitIoSchedulerHandler(@Nullable Function<? super Supplier<Scheduler>, ? extends Scheduler> function) {
        if (!f20036z) {
            f20015e = function;
            return;
        }
        throw new IllegalStateException("Plugins can't be changed anymore");
    }

    public static void setInitNewThreadSchedulerHandler(@Nullable Function<? super Supplier<Scheduler>, ? extends Scheduler> function) {
        if (!f20036z) {
            f20016f = function;
            return;
        }
        throw new IllegalStateException("Plugins can't be changed anymore");
    }

    public static void setInitSingleSchedulerHandler(@Nullable Function<? super Supplier<Scheduler>, ? extends Scheduler> function) {
        if (!f20036z) {
            f20014d = function;
            return;
        }
        throw new IllegalStateException("Plugins can't be changed anymore");
    }

    public static void setIoSchedulerHandler(@Nullable Function<? super Scheduler, ? extends Scheduler> function) {
        if (!f20036z) {
            f20019i = function;
            return;
        }
        throw new IllegalStateException("Plugins can't be changed anymore");
    }

    public static void setNewThreadSchedulerHandler(@Nullable Function<? super Scheduler, ? extends Scheduler> function) {
        if (!f20036z) {
            f20020j = function;
            return;
        }
        throw new IllegalStateException("Plugins can't be changed anymore");
    }

    public static void setOnBeforeBlocking(@Nullable BooleanSupplier booleanSupplier) {
        if (!f20036z) {
            f20035y = booleanSupplier;
            return;
        }
        throw new IllegalStateException("Plugins can't be changed anymore");
    }

    public static void setOnCompletableAssembly(@Nullable Function<? super Completable, ? extends Completable> function) {
        if (!f20036z) {
            f20027q = function;
            return;
        }
        throw new IllegalStateException("Plugins can't be changed anymore");
    }

    public static void setOnCompletableSubscribe(@Nullable BiFunction<? super Completable, ? super CompletableObserver, ? extends CompletableObserver> biFunction) {
        if (!f20036z) {
            f20033w = biFunction;
            return;
        }
        throw new IllegalStateException("Plugins can't be changed anymore");
    }

    public static void setOnConnectableFlowableAssembly(@Nullable Function<? super ConnectableFlowable, ? extends ConnectableFlowable> function) {
        if (!f20036z) {
            f20022l = function;
            return;
        }
        throw new IllegalStateException("Plugins can't be changed anymore");
    }

    public static void setOnConnectableObservableAssembly(@Nullable Function<? super ConnectableObservable, ? extends ConnectableObservable> function) {
        if (!f20036z) {
            f20024n = function;
            return;
        }
        throw new IllegalStateException("Plugins can't be changed anymore");
    }

    public static void setOnFlowableAssembly(@Nullable Function<? super Flowable, ? extends Flowable> function) {
        if (!f20036z) {
            f20021k = function;
            return;
        }
        throw new IllegalStateException("Plugins can't be changed anymore");
    }

    public static void setOnFlowableSubscribe(@Nullable BiFunction<? super Flowable, ? super Subscriber, ? extends Subscriber> biFunction) {
        if (!f20036z) {
            f20029s = biFunction;
            return;
        }
        throw new IllegalStateException("Plugins can't be changed anymore");
    }

    public static void setOnMaybeAssembly(@Nullable Function<? super Maybe, ? extends Maybe> function) {
        if (!f20036z) {
            f20025o = function;
            return;
        }
        throw new IllegalStateException("Plugins can't be changed anymore");
    }

    public static void setOnMaybeSubscribe(@Nullable BiFunction<? super Maybe, MaybeObserver, ? extends MaybeObserver> biFunction) {
        if (!f20036z) {
            f20030t = biFunction;
            return;
        }
        throw new IllegalStateException("Plugins can't be changed anymore");
    }

    public static void setOnObservableAssembly(@Nullable Function<? super Observable, ? extends Observable> function) {
        if (!f20036z) {
            f20023m = function;
            return;
        }
        throw new IllegalStateException("Plugins can't be changed anymore");
    }

    public static void setOnObservableSubscribe(@Nullable BiFunction<? super Observable, ? super Observer, ? extends Observer> biFunction) {
        if (!f20036z) {
            f20031u = biFunction;
            return;
        }
        throw new IllegalStateException("Plugins can't be changed anymore");
    }

    public static void setOnParallelAssembly(@Nullable Function<? super ParallelFlowable, ? extends ParallelFlowable> function) {
        if (!f20036z) {
            f20028r = function;
            return;
        }
        throw new IllegalStateException("Plugins can't be changed anymore");
    }

    public static void setOnParallelSubscribe(@Nullable BiFunction<? super ParallelFlowable, ? super Subscriber[], ? extends Subscriber[]> biFunction) {
        if (!f20036z) {
            f20034x = biFunction;
            return;
        }
        throw new IllegalStateException("Plugins can't be changed anymore");
    }

    public static void setOnSingleAssembly(@Nullable Function<? super Single, ? extends Single> function) {
        if (!f20036z) {
            f20026p = function;
            return;
        }
        throw new IllegalStateException("Plugins can't be changed anymore");
    }

    public static void setOnSingleSubscribe(@Nullable BiFunction<? super Single, ? super SingleObserver, ? extends SingleObserver> biFunction) {
        if (!f20036z) {
            f20032v = biFunction;
            return;
        }
        throw new IllegalStateException("Plugins can't be changed anymore");
    }

    public static void setScheduleHandler(@Nullable Function<? super Runnable, ? extends Runnable> function) {
        if (!f20036z) {
            f20012b = function;
            return;
        }
        throw new IllegalStateException("Plugins can't be changed anymore");
    }

    public static void setSingleSchedulerHandler(@Nullable Function<? super Scheduler, ? extends Scheduler> function) {
        if (!f20036z) {
            f20018h = function;
            return;
        }
        throw new IllegalStateException("Plugins can't be changed anymore");
    }

    @NonNull
    public static <T> Flowable<T> onAssembly(@NonNull Flowable<T> flowable) {
        Function function = f20021k;
        return function != null ? (Flowable) m5307b(flowable, function) : flowable;
    }

    @NonNull
    public static <T> Observer<? super T> onSubscribe(@NonNull Observable<T> observable, @NonNull Observer<? super T> observer) {
        BiFunction biFunction = f20031u;
        return biFunction != null ? (Observer) m5306a(biFunction, observable, observer) : observer;
    }

    @NonNull
    public static <T> ConnectableFlowable<T> onAssembly(@NonNull ConnectableFlowable<T> connectableFlowable) {
        Function function = f20022l;
        return function != null ? (ConnectableFlowable) m5307b(connectableFlowable, function) : connectableFlowable;
    }

    @NonNull
    public static <T> SingleObserver<? super T> onSubscribe(@NonNull Single<T> single, @NonNull SingleObserver<? super T> singleObserver) {
        BiFunction biFunction = f20032v;
        return biFunction != null ? (SingleObserver) m5306a(biFunction, single, singleObserver) : singleObserver;
    }

    @NonNull
    public static <T> Observable<T> onAssembly(@NonNull Observable<T> observable) {
        Function function = f20023m;
        return function != null ? (Observable) m5307b(observable, function) : observable;
    }

    @NonNull
    public static CompletableObserver onSubscribe(@NonNull Completable completable, @NonNull CompletableObserver completableObserver) {
        BiFunction biFunction = f20033w;
        return biFunction != null ? (CompletableObserver) m5306a(biFunction, completable, completableObserver) : completableObserver;
    }

    @NonNull
    public static <T> ConnectableObservable<T> onAssembly(@NonNull ConnectableObservable<T> connectableObservable) {
        Function function = f20024n;
        return function != null ? (ConnectableObservable) m5307b(connectableObservable, function) : connectableObservable;
    }

    @NonNull
    public static <T> MaybeObserver<? super T> onSubscribe(@NonNull Maybe<T> maybe, @NonNull MaybeObserver<? super T> maybeObserver) {
        BiFunction biFunction = f20030t;
        return biFunction != null ? (MaybeObserver) m5306a(biFunction, maybe, maybeObserver) : maybeObserver;
    }

    @NonNull
    public static <T> Single<T> onAssembly(@NonNull Single<T> single) {
        Function function = f20026p;
        return function != null ? (Single) m5307b(single, function) : single;
    }

    @NonNull
    public static <T> Subscriber<? super T>[] onSubscribe(@NonNull ParallelFlowable<T> parallelFlowable, @NonNull Subscriber<? super T>[] subscriberArr) {
        BiFunction biFunction = f20034x;
        return biFunction != null ? (Subscriber[]) m5306a(biFunction, parallelFlowable, subscriberArr) : subscriberArr;
    }

    @NonNull
    public static Completable onAssembly(@NonNull Completable completable) {
        Function function = f20027q;
        return function != null ? (Completable) m5307b(completable, function) : completable;
    }

    @NonNull
    public static <T> ParallelFlowable<T> onAssembly(@NonNull ParallelFlowable<T> parallelFlowable) {
        Function function = f20028r;
        return function != null ? (ParallelFlowable) m5307b(parallelFlowable, function) : parallelFlowable;
    }
}
