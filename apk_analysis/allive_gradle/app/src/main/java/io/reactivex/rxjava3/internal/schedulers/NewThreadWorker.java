package io.reactivex.rxjava3.internal.schedulers;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.annotations.Nullable;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.disposables.DisposableContainer;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import p000.n41;

/* loaded from: classes2.dex */
public class NewThreadWorker extends Scheduler.Worker implements Disposable {

    /* renamed from: a */
    public final ScheduledExecutorService f19858a;

    /* renamed from: b */
    public volatile boolean f19859b;

    public NewThreadWorker(ThreadFactory threadFactory) {
        this.f19858a = SchedulerPoolFactory.create(threadFactory);
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public void dispose() {
        if (!this.f19859b) {
            this.f19859b = true;
            this.f19858a.shutdownNow();
        }
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public boolean isDisposed() {
        return this.f19859b;
    }

    @Override // io.reactivex.rxjava3.core.Scheduler.Worker
    @NonNull
    public Disposable schedule(@NonNull Runnable runnable) {
        return schedule(runnable, 0L, null);
    }

    @NonNull
    public ScheduledRunnable scheduleActual(Runnable runnable, long j, @NonNull TimeUnit timeUnit, @Nullable DisposableContainer disposableContainer) {
        Future<?> schedule;
        ScheduledRunnable scheduledRunnable = new ScheduledRunnable(RxJavaPlugins.onSchedule(runnable), disposableContainer);
        if (disposableContainer != null && !disposableContainer.add(scheduledRunnable)) {
            return scheduledRunnable;
        }
        ScheduledExecutorService scheduledExecutorService = this.f19858a;
        try {
            if (j <= 0) {
                schedule = scheduledExecutorService.submit((Callable) scheduledRunnable);
            } else {
                schedule = scheduledExecutorService.schedule((Callable) scheduledRunnable, j, timeUnit);
            }
            scheduledRunnable.setFuture(schedule);
        } catch (RejectedExecutionException e) {
            if (disposableContainer != null) {
                disposableContainer.remove(scheduledRunnable);
            }
            RxJavaPlugins.onError(e);
        }
        return scheduledRunnable;
    }

    public Disposable scheduleDirect(Runnable runnable, long j, TimeUnit timeUnit) {
        Future<?> schedule;
        ScheduledDirectTask scheduledDirectTask = new ScheduledDirectTask(RxJavaPlugins.onSchedule(runnable), true);
        ScheduledExecutorService scheduledExecutorService = this.f19858a;
        try {
            if (j <= 0) {
                schedule = scheduledExecutorService.submit(scheduledDirectTask);
            } else {
                schedule = scheduledExecutorService.schedule(scheduledDirectTask, j, timeUnit);
            }
            scheduledDirectTask.setFuture(schedule);
            return scheduledDirectTask;
        } catch (RejectedExecutionException e) {
            RxJavaPlugins.onError(e);
            return EmptyDisposable.INSTANCE;
        }
    }

    public Disposable schedulePeriodicallyDirect(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        Future schedule;
        Runnable onSchedule = RxJavaPlugins.onSchedule(runnable);
        if (j2 <= 0) {
            ScheduledExecutorService scheduledExecutorService = this.f19858a;
            n41 n41Var = new n41(onSchedule, scheduledExecutorService);
            try {
                if (j <= 0) {
                    schedule = scheduledExecutorService.submit(n41Var);
                } else {
                    schedule = scheduledExecutorService.schedule(n41Var, j, timeUnit);
                }
                n41Var.m6303a(schedule);
                return n41Var;
            } catch (RejectedExecutionException e) {
                RxJavaPlugins.onError(e);
                return EmptyDisposable.INSTANCE;
            }
        }
        ScheduledDirectPeriodicTask scheduledDirectPeriodicTask = new ScheduledDirectPeriodicTask(onSchedule, true);
        try {
            scheduledDirectPeriodicTask.setFuture(this.f19858a.scheduleAtFixedRate(scheduledDirectPeriodicTask, j, j2, timeUnit));
            return scheduledDirectPeriodicTask;
        } catch (RejectedExecutionException e2) {
            RxJavaPlugins.onError(e2);
            return EmptyDisposable.INSTANCE;
        }
    }

    public void shutdown() {
        if (!this.f19859b) {
            this.f19859b = true;
            this.f19858a.shutdown();
        }
    }

    @Override // io.reactivex.rxjava3.core.Scheduler.Worker
    @NonNull
    public Disposable schedule(@NonNull Runnable runnable, long j, @NonNull TimeUnit timeUnit) {
        if (this.f19859b) {
            return EmptyDisposable.INSTANCE;
        }
        return scheduleActual(runnable, j, timeUnit, null);
    }
}
