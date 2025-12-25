package io.reactivex.rxjava3.core;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import io.reactivex.rxjava3.internal.disposables.SequentialDisposable;
import io.reactivex.rxjava3.internal.schedulers.SchedulerWhen;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public abstract class Scheduler {

    /* renamed from: a */
    public static final boolean f18491a = Boolean.getBoolean("rx3.scheduler.use-nanotime");

    /* renamed from: b */
    public static final long f18492b;

    /* loaded from: classes2.dex */
    public static abstract class Worker implements Disposable {
        public long now(@NonNull TimeUnit timeUnit) {
            if (!Scheduler.f18491a) {
                return timeUnit.convert(System.currentTimeMillis(), TimeUnit.MILLISECONDS);
            }
            return timeUnit.convert(System.nanoTime(), TimeUnit.NANOSECONDS);
        }

        @NonNull
        public Disposable schedule(@NonNull Runnable runnable) {
            return schedule(runnable, 0L, TimeUnit.NANOSECONDS);
        }

        @NonNull
        public abstract Disposable schedule(@NonNull Runnable runnable, long j, @NonNull TimeUnit timeUnit);

        @NonNull
        public Disposable schedulePeriodically(@NonNull Runnable runnable, long j, long j2, @NonNull TimeUnit timeUnit) {
            SequentialDisposable sequentialDisposable = new SequentialDisposable();
            SequentialDisposable sequentialDisposable2 = new SequentialDisposable(sequentialDisposable);
            Runnable onSchedule = RxJavaPlugins.onSchedule(runnable);
            long nanos = timeUnit.toNanos(j2);
            long now = now(TimeUnit.NANOSECONDS);
            Disposable schedule = schedule(new RunnableC1316c(this, timeUnit.toNanos(j) + now, onSchedule, now, sequentialDisposable2, nanos), j, timeUnit);
            if (schedule == EmptyDisposable.INSTANCE) {
                return schedule;
            }
            sequentialDisposable.replace(schedule);
            return sequentialDisposable2;
        }
    }

    static {
        long nanos;
        long longValue = Long.getLong("rx3.scheduler.drift-tolerance", 15L).longValue();
        String property = System.getProperty("rx3.scheduler.drift-tolerance-unit", "minutes");
        if ("seconds".equalsIgnoreCase(property)) {
            nanos = TimeUnit.SECONDS.toNanos(longValue);
        } else if ("milliseconds".equalsIgnoreCase(property)) {
            nanos = TimeUnit.MILLISECONDS.toNanos(longValue);
        } else {
            nanos = TimeUnit.MINUTES.toNanos(longValue);
        }
        f18492b = nanos;
    }

    public static long clockDriftTolerance() {
        return f18492b;
    }

    @NonNull
    public abstract Worker createWorker();

    public long now(@NonNull TimeUnit timeUnit) {
        if (!f18491a) {
            return timeUnit.convert(System.currentTimeMillis(), TimeUnit.MILLISECONDS);
        }
        return timeUnit.convert(System.nanoTime(), TimeUnit.NANOSECONDS);
    }

    @NonNull
    public Disposable scheduleDirect(@NonNull Runnable runnable) {
        return scheduleDirect(runnable, 0L, TimeUnit.NANOSECONDS);
    }

    @NonNull
    public Disposable schedulePeriodicallyDirect(@NonNull Runnable runnable, long j, long j2, @NonNull TimeUnit timeUnit) {
        Worker createWorker = createWorker();
        RunnableC1315b runnableC1315b = new RunnableC1315b(RxJavaPlugins.onSchedule(runnable), createWorker);
        Disposable schedulePeriodically = createWorker.schedulePeriodically(runnableC1315b, j, j2, timeUnit);
        if (schedulePeriodically == EmptyDisposable.INSTANCE) {
            return schedulePeriodically;
        }
        return runnableC1315b;
    }

    public void shutdown() {
    }

    public void start() {
    }

    @NonNull
    public <S extends Scheduler & Disposable> S when(@NonNull Function<Flowable<Flowable<Completable>>, Completable> function) {
        Objects.requireNonNull(function, "combine is null");
        return new SchedulerWhen(function, this);
    }

    @NonNull
    public Disposable scheduleDirect(@NonNull Runnable runnable, long j, @NonNull TimeUnit timeUnit) {
        Worker createWorker = createWorker();
        RunnableC1314a runnableC1314a = new RunnableC1314a(RxJavaPlugins.onSchedule(runnable), createWorker);
        createWorker.schedule(runnableC1314a, j, timeUnit);
        return runnableC1314a;
    }
}
