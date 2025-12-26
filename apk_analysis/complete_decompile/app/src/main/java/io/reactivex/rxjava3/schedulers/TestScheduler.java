package io.reactivex.rxjava3.schedulers;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Scheduler;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;
import p000.ps2;
import p000.qs2;

/* loaded from: classes2.dex */
public final class TestScheduler extends Scheduler {

    /* renamed from: c */
    public final PriorityBlockingQueue f20090c;

    /* renamed from: d */
    public final boolean f20091d;

    /* renamed from: e */
    public long f20092e;

    /* renamed from: f */
    public volatile long f20093f;

    public TestScheduler() {
        this(false);
    }

    /* renamed from: a */
    public final void m5319a(long j) {
        while (true) {
            qs2 qs2Var = (qs2) this.f20090c.peek();
            if (qs2Var == null) {
                break;
            }
            long j2 = qs2Var.f25736a;
            if (j2 > j) {
                break;
            }
            if (j2 == 0) {
                j2 = this.f20093f;
            }
            this.f20093f = j2;
            this.f20090c.remove(qs2Var);
            if (!qs2Var.f25738c.f25279a) {
                qs2Var.f25737b.run();
            }
        }
        this.f20093f = j;
    }

    public void advanceTimeBy(long j, TimeUnit timeUnit) {
        advanceTimeTo(timeUnit.toNanos(j) + this.f20093f, TimeUnit.NANOSECONDS);
    }

    public void advanceTimeTo(long j, TimeUnit timeUnit) {
        m5319a(timeUnit.toNanos(j));
    }

    @Override // io.reactivex.rxjava3.core.Scheduler
    @NonNull
    public Scheduler.Worker createWorker() {
        return new ps2(this);
    }

    @Override // io.reactivex.rxjava3.core.Scheduler
    public long now(@NonNull TimeUnit timeUnit) {
        return timeUnit.convert(this.f20093f, TimeUnit.NANOSECONDS);
    }

    public void triggerActions() {
        m5319a(this.f20093f);
    }

    public TestScheduler(boolean z) {
        this.f20090c = new PriorityBlockingQueue(11);
        this.f20091d = z;
    }

    public TestScheduler(long j, TimeUnit timeUnit) {
        this(j, timeUnit, false);
    }

    public TestScheduler(long j, TimeUnit timeUnit, boolean z) {
        this.f20090c = new PriorityBlockingQueue(11);
        this.f20093f = timeUnit.toNanos(j);
        this.f20091d = z;
    }
}
