package p000;

import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import io.reactivex.rxjava3.internal.schedulers.ScheduledRunnable;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public final class tj2 extends Scheduler.Worker {

    /* renamed from: a */
    public final ScheduledExecutorService f26847a;

    /* renamed from: b */
    public final CompositeDisposable f26848b = new CompositeDisposable();

    /* renamed from: c */
    public volatile boolean f26849c;

    public tj2(ScheduledExecutorService scheduledExecutorService) {
        this.f26847a = scheduledExecutorService;
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final void dispose() {
        if (!this.f26849c) {
            this.f26849c = true;
            this.f26848b.dispose();
        }
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final boolean isDisposed() {
        return this.f26849c;
    }

    @Override // io.reactivex.rxjava3.core.Scheduler.Worker
    public final Disposable schedule(Runnable runnable, long j, TimeUnit timeUnit) {
        Future<?> schedule;
        if (this.f26849c) {
            return EmptyDisposable.INSTANCE;
        }
        ScheduledRunnable scheduledRunnable = new ScheduledRunnable(RxJavaPlugins.onSchedule(runnable), this.f26848b);
        this.f26848b.add(scheduledRunnable);
        try {
            if (j <= 0) {
                schedule = this.f26847a.submit((Callable) scheduledRunnable);
            } else {
                schedule = this.f26847a.schedule((Callable) scheduledRunnable, j, timeUnit);
            }
            scheduledRunnable.setFuture(schedule);
            return scheduledRunnable;
        } catch (RejectedExecutionException e) {
            dispose();
            RxJavaPlugins.onError(e);
            return EmptyDisposable.INSTANCE;
        }
    }
}
