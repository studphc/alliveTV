package io.reactivex.rxjava3.internal.schedulers;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import io.reactivex.rxjava3.internal.disposables.SequentialDisposable;
import io.reactivex.rxjava3.internal.queue.MpscLinkedQueue;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import p000.i50;
import p000.pa0;
import p000.qa0;
import p000.xy1;

/* loaded from: classes2.dex */
public final class ExecutorScheduler extends Scheduler {

    /* renamed from: c */
    public final boolean f19835c;

    /* renamed from: d */
    public final boolean f19836d;

    /* renamed from: e */
    public final Executor f19837e;

    public ExecutorScheduler(@NonNull Executor executor, boolean z, boolean z2) {
        this.f19837e = executor;
        this.f19835c = z;
        this.f19836d = z2;
    }

    @Override // io.reactivex.rxjava3.core.Scheduler
    @NonNull
    public Scheduler.Worker createWorker() {
        return new ExecutorWorker(this.f19837e, this.f19835c, this.f19836d);
    }

    @Override // io.reactivex.rxjava3.core.Scheduler
    @NonNull
    public Disposable scheduleDirect(@NonNull Runnable runnable) {
        Executor executor = this.f19837e;
        Runnable onSchedule = RxJavaPlugins.onSchedule(runnable);
        try {
            boolean z = executor instanceof ExecutorService;
            boolean z2 = this.f19835c;
            if (z) {
                ScheduledDirectTask scheduledDirectTask = new ScheduledDirectTask(onSchedule, z2);
                scheduledDirectTask.setFuture(((ExecutorService) executor).submit(scheduledDirectTask));
                return scheduledDirectTask;
            }
            if (z2) {
                RunnableC1324c runnableC1324c = new RunnableC1324c(onSchedule, null);
                executor.execute(runnableC1324c);
                return runnableC1324c;
            }
            RunnableC1323b runnableC1323b = new RunnableC1323b(onSchedule);
            executor.execute(runnableC1323b);
            return runnableC1323b;
        } catch (RejectedExecutionException e) {
            RxJavaPlugins.onError(e);
            return EmptyDisposable.INSTANCE;
        }
    }

    @Override // io.reactivex.rxjava3.core.Scheduler
    @NonNull
    public Disposable schedulePeriodicallyDirect(@NonNull Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        Executor executor = this.f19837e;
        if (executor instanceof ScheduledExecutorService) {
            try {
                ScheduledDirectPeriodicTask scheduledDirectPeriodicTask = new ScheduledDirectPeriodicTask(RxJavaPlugins.onSchedule(runnable), this.f19835c);
                scheduledDirectPeriodicTask.setFuture(((ScheduledExecutorService) executor).scheduleAtFixedRate(scheduledDirectPeriodicTask, j, j2, timeUnit));
                return scheduledDirectPeriodicTask;
            } catch (RejectedExecutionException e) {
                RxJavaPlugins.onError(e);
                return EmptyDisposable.INSTANCE;
            }
        }
        return super.schedulePeriodicallyDirect(runnable, j, j2, timeUnit);
    }

    @Override // io.reactivex.rxjava3.core.Scheduler
    @NonNull
    public Disposable scheduleDirect(@NonNull Runnable runnable, long j, TimeUnit timeUnit) {
        Runnable onSchedule = RxJavaPlugins.onSchedule(runnable);
        Executor executor = this.f19837e;
        if (executor instanceof ScheduledExecutorService) {
            try {
                ScheduledDirectTask scheduledDirectTask = new ScheduledDirectTask(onSchedule, this.f19835c);
                scheduledDirectTask.setFuture(((ScheduledExecutorService) executor).schedule(scheduledDirectTask, j, timeUnit));
                return scheduledDirectTask;
            } catch (RejectedExecutionException e) {
                RxJavaPlugins.onError(e);
                return EmptyDisposable.INSTANCE;
            }
        }
        pa0 pa0Var = new pa0(onSchedule);
        pa0Var.f25093a.replace(qa0.f25495a.scheduleDirect(new xy1(6, this, pa0Var), j, timeUnit));
        return pa0Var;
    }

    /* loaded from: classes2.dex */
    public static final class ExecutorWorker extends Scheduler.Worker implements Runnable {

        /* renamed from: a */
        public final boolean f19838a;

        /* renamed from: b */
        public final boolean f19839b;

        /* renamed from: c */
        public final Executor f19840c;

        /* renamed from: e */
        public volatile boolean f19842e;

        /* renamed from: f */
        public final AtomicInteger f19843f = new AtomicInteger();

        /* renamed from: g */
        public final CompositeDisposable f19844g = new CompositeDisposable();

        /* renamed from: d */
        public final MpscLinkedQueue f19841d = new MpscLinkedQueue();

        public ExecutorWorker(Executor executor, boolean z, boolean z2) {
            this.f19840c = executor;
            this.f19838a = z;
            this.f19839b = z2;
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public void dispose() {
            if (!this.f19842e) {
                this.f19842e = true;
                this.f19844g.dispose();
                if (this.f19843f.getAndIncrement() == 0) {
                    this.f19841d.clear();
                }
            }
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public boolean isDisposed() {
            return this.f19842e;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f19839b) {
                MpscLinkedQueue mpscLinkedQueue = this.f19841d;
                if (this.f19842e) {
                    mpscLinkedQueue.clear();
                    return;
                }
                ((Runnable) mpscLinkedQueue.poll()).run();
                if (this.f19842e) {
                    mpscLinkedQueue.clear();
                    return;
                } else {
                    if (this.f19843f.decrementAndGet() != 0) {
                        this.f19840c.execute(this);
                        return;
                    }
                    return;
                }
            }
            MpscLinkedQueue mpscLinkedQueue2 = this.f19841d;
            int i = 1;
            while (!this.f19842e) {
                do {
                    Runnable runnable = (Runnable) mpscLinkedQueue2.poll();
                    if (runnable == null) {
                        if (this.f19842e) {
                            mpscLinkedQueue2.clear();
                            return;
                        } else {
                            i = this.f19843f.addAndGet(-i);
                            if (i == 0) {
                                return;
                            }
                        }
                    } else {
                        runnable.run();
                    }
                } while (!this.f19842e);
                mpscLinkedQueue2.clear();
                return;
            }
            mpscLinkedQueue2.clear();
        }

        @Override // io.reactivex.rxjava3.core.Scheduler.Worker
        @NonNull
        public Disposable schedule(@NonNull Runnable runnable) {
            Disposable runnableC1323b;
            if (this.f19842e) {
                return EmptyDisposable.INSTANCE;
            }
            Runnable onSchedule = RxJavaPlugins.onSchedule(runnable);
            if (this.f19838a) {
                runnableC1323b = new RunnableC1324c(onSchedule, this.f19844g);
                this.f19844g.add(runnableC1323b);
            } else {
                runnableC1323b = new RunnableC1323b(onSchedule);
            }
            this.f19841d.offer(runnableC1323b);
            if (this.f19843f.getAndIncrement() == 0) {
                try {
                    this.f19840c.execute(this);
                } catch (RejectedExecutionException e) {
                    this.f19842e = true;
                    this.f19841d.clear();
                    RxJavaPlugins.onError(e);
                    return EmptyDisposable.INSTANCE;
                }
            }
            return runnableC1323b;
        }

        @Override // io.reactivex.rxjava3.core.Scheduler.Worker
        @NonNull
        public Disposable schedule(@NonNull Runnable runnable, long j, @NonNull TimeUnit timeUnit) {
            if (j <= 0) {
                return schedule(runnable);
            }
            if (this.f19842e) {
                return EmptyDisposable.INSTANCE;
            }
            SequentialDisposable sequentialDisposable = new SequentialDisposable();
            SequentialDisposable sequentialDisposable2 = new SequentialDisposable(sequentialDisposable);
            ScheduledRunnable scheduledRunnable = new ScheduledRunnable(new RunnableC1325d(this, sequentialDisposable2, RxJavaPlugins.onSchedule(runnable)), this.f19844g);
            this.f19844g.add(scheduledRunnable);
            Executor executor = this.f19840c;
            if (executor instanceof ScheduledExecutorService) {
                try {
                    scheduledRunnable.setFuture(((ScheduledExecutorService) executor).schedule((Callable) scheduledRunnable, j, timeUnit));
                } catch (RejectedExecutionException e) {
                    this.f19842e = true;
                    RxJavaPlugins.onError(e);
                    return EmptyDisposable.INSTANCE;
                }
            } else {
                scheduledRunnable.setFuture(new i50(qa0.f25495a.scheduleDirect(scheduledRunnable, j, timeUnit)));
            }
            sequentialDisposable.replace(scheduledRunnable);
            return sequentialDisposable2;
        }
    }
}
