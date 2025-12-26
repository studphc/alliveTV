package io.reactivex.rxjava3.core;

import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.internal.disposables.SequentialDisposable;
import io.reactivex.rxjava3.schedulers.SchedulerRunnableIntrospection;
import java.util.concurrent.TimeUnit;

/* renamed from: io.reactivex.rxjava3.core.c */
/* loaded from: classes2.dex */
public final class RunnableC1316c implements Runnable, SchedulerRunnableIntrospection {

    /* renamed from: a */
    public final Runnable f18499a;

    /* renamed from: b */
    public final SequentialDisposable f18500b;

    /* renamed from: c */
    public final long f18501c;

    /* renamed from: d */
    public long f18502d;

    /* renamed from: e */
    public long f18503e;

    /* renamed from: f */
    public long f18504f;

    /* renamed from: g */
    public final /* synthetic */ Scheduler.Worker f18505g;

    public RunnableC1316c(Scheduler.Worker worker, long j, Runnable runnable, long j2, SequentialDisposable sequentialDisposable, long j3) {
        this.f18505g = worker;
        this.f18499a = runnable;
        this.f18500b = sequentialDisposable;
        this.f18501c = j3;
        this.f18503e = j2;
        this.f18504f = j;
    }

    @Override // io.reactivex.rxjava3.schedulers.SchedulerRunnableIntrospection
    public final Runnable getWrappedRunnable() {
        return this.f18499a;
    }

    @Override // java.lang.Runnable
    public final void run() {
        long j;
        this.f18499a.run();
        SequentialDisposable sequentialDisposable = this.f18500b;
        if (!sequentialDisposable.isDisposed()) {
            TimeUnit timeUnit = TimeUnit.NANOSECONDS;
            Scheduler.Worker worker = this.f18505g;
            long now = worker.now(timeUnit);
            long j2 = Scheduler.f18492b;
            long j3 = now + j2;
            long j4 = this.f18503e;
            long j5 = this.f18501c;
            if (j3 >= j4 && now < j4 + j5 + j2) {
                long j6 = this.f18504f;
                long j7 = this.f18502d + 1;
                this.f18502d = j7;
                j = (j7 * j5) + j6;
            } else {
                j = now + j5;
                long j8 = this.f18502d + 1;
                this.f18502d = j8;
                this.f18504f = j - (j5 * j8);
            }
            this.f18503e = now;
            sequentialDisposable.replace(worker.schedule(this, j - now, timeUnit));
        }
    }
}
