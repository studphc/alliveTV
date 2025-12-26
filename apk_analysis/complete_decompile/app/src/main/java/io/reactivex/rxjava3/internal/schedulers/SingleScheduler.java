package io.reactivex.rxjava3.internal.schedulers;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import p000.n41;
import p000.tj2;

/* loaded from: classes2.dex */
public final class SingleScheduler extends Scheduler {

    /* renamed from: e */
    public static final RxThreadFactory f19873e;

    /* renamed from: f */
    public static final ScheduledExecutorService f19874f;

    /* renamed from: c */
    public final ThreadFactory f19875c;

    /* renamed from: d */
    public final AtomicReference f19876d;

    static {
        ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(0);
        f19874f = newScheduledThreadPool;
        newScheduledThreadPool.shutdown();
        f19873e = new RxThreadFactory("RxSingleScheduler", Math.max(1, Math.min(10, Integer.getInteger("rx3.single-priority", 5).intValue())), true);
    }

    public SingleScheduler() {
        this(f19873e);
    }

    @Override // io.reactivex.rxjava3.core.Scheduler
    @NonNull
    public Scheduler.Worker createWorker() {
        return new tj2((ScheduledExecutorService) this.f19876d.get());
    }

    @Override // io.reactivex.rxjava3.core.Scheduler
    @NonNull
    public Disposable scheduleDirect(@NonNull Runnable runnable, long j, TimeUnit timeUnit) {
        Future<?> schedule;
        ScheduledDirectTask scheduledDirectTask = new ScheduledDirectTask(RxJavaPlugins.onSchedule(runnable), true);
        AtomicReference atomicReference = this.f19876d;
        try {
            if (j <= 0) {
                schedule = ((ScheduledExecutorService) atomicReference.get()).submit(scheduledDirectTask);
            } else {
                schedule = ((ScheduledExecutorService) atomicReference.get()).schedule(scheduledDirectTask, j, timeUnit);
            }
            scheduledDirectTask.setFuture(schedule);
            return scheduledDirectTask;
        } catch (RejectedExecutionException e) {
            RxJavaPlugins.onError(e);
            return EmptyDisposable.INSTANCE;
        }
    }

    @Override // io.reactivex.rxjava3.core.Scheduler
    @NonNull
    public Disposable schedulePeriodicallyDirect(@NonNull Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        Future schedule;
        Runnable onSchedule = RxJavaPlugins.onSchedule(runnable);
        AtomicReference atomicReference = this.f19876d;
        if (j2 <= 0) {
            ScheduledExecutorService scheduledExecutorService = (ScheduledExecutorService) atomicReference.get();
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
            scheduledDirectPeriodicTask.setFuture(((ScheduledExecutorService) atomicReference.get()).scheduleAtFixedRate(scheduledDirectPeriodicTask, j, j2, timeUnit));
            return scheduledDirectPeriodicTask;
        } catch (RejectedExecutionException e2) {
            RxJavaPlugins.onError(e2);
            return EmptyDisposable.INSTANCE;
        }
    }

    @Override // io.reactivex.rxjava3.core.Scheduler
    public void shutdown() {
        AtomicReference atomicReference = this.f19876d;
        ScheduledExecutorService scheduledExecutorService = f19874f;
        ScheduledExecutorService scheduledExecutorService2 = (ScheduledExecutorService) atomicReference.getAndSet(scheduledExecutorService);
        if (scheduledExecutorService2 != scheduledExecutorService) {
            scheduledExecutorService2.shutdownNow();
        }
    }

    @Override // io.reactivex.rxjava3.core.Scheduler
    public void start() {
        ScheduledExecutorService scheduledExecutorService = null;
        while (true) {
            AtomicReference atomicReference = this.f19876d;
            ScheduledExecutorService scheduledExecutorService2 = (ScheduledExecutorService) atomicReference.get();
            if (scheduledExecutorService2 != f19874f) {
                if (scheduledExecutorService != null) {
                    scheduledExecutorService.shutdown();
                    return;
                }
                return;
            } else {
                if (scheduledExecutorService == null) {
                    scheduledExecutorService = SchedulerPoolFactory.create(this.f19875c);
                }
                while (!atomicReference.compareAndSet(scheduledExecutorService2, scheduledExecutorService)) {
                    if (atomicReference.get() != scheduledExecutorService2) {
                        break;
                    }
                }
                return;
            }
        }
    }

    public SingleScheduler(ThreadFactory threadFactory) {
        AtomicReference atomicReference = new AtomicReference();
        this.f19876d = atomicReference;
        this.f19875c = threadFactory;
        atomicReference.lazySet(SchedulerPoolFactory.create(threadFactory));
    }
}
