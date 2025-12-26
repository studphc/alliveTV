package io.reactivex.rxjava3.internal.schedulers;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Scheduler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import p000.i51;
import p000.j51;
import p000.k51;

/* loaded from: classes2.dex */
public final class IoScheduler extends Scheduler {
    public static final long KEEP_ALIVE_TIME_DEFAULT = 60;

    /* renamed from: e */
    public static final RxThreadFactory f19847e;

    /* renamed from: f */
    public static final RxThreadFactory f19848f;

    /* renamed from: i */
    public static final k51 f19851i;

    /* renamed from: j */
    public static final boolean f19852j;

    /* renamed from: k */
    public static final i51 f19853k;

    /* renamed from: c */
    public final ThreadFactory f19854c;

    /* renamed from: d */
    public final AtomicReference f19855d;

    /* renamed from: h */
    public static final TimeUnit f19850h = TimeUnit.SECONDS;

    /* renamed from: g */
    public static final long f19849g = Long.getLong("rx3.io-keep-alive-time", 60).longValue();

    static {
        k51 k51Var = new k51(new RxThreadFactory("RxCachedThreadSchedulerShutdown"));
        f19851i = k51Var;
        k51Var.dispose();
        int max = Math.max(1, Math.min(10, Integer.getInteger("rx3.io-priority", 5).intValue()));
        RxThreadFactory rxThreadFactory = new RxThreadFactory("RxCachedThreadScheduler", max);
        f19847e = rxThreadFactory;
        f19848f = new RxThreadFactory("RxCachedWorkerPoolEvictor", max);
        f19852j = Boolean.getBoolean("rx3.io-scheduled-release");
        i51 i51Var = new i51(0L, null, rxThreadFactory);
        f19853k = i51Var;
        i51Var.m5163a();
    }

    public IoScheduler() {
        this(f19847e);
    }

    @Override // io.reactivex.rxjava3.core.Scheduler
    @NonNull
    public Scheduler.Worker createWorker() {
        return new j51((i51) this.f19855d.get());
    }

    @Override // io.reactivex.rxjava3.core.Scheduler
    public void shutdown() {
        AtomicReference atomicReference = this.f19855d;
        i51 i51Var = f19853k;
        i51 i51Var2 = (i51) atomicReference.getAndSet(i51Var);
        if (i51Var2 != i51Var) {
            i51Var2.m5163a();
        }
    }

    public int size() {
        return ((i51) this.f19855d.get()).f18301c.size();
    }

    @Override // io.reactivex.rxjava3.core.Scheduler
    public void start() {
        i51 i51Var;
        i51 i51Var2 = new i51(f19849g, f19850h, this.f19854c);
        AtomicReference atomicReference = this.f19855d;
        do {
            i51Var = f19853k;
            if (atomicReference.compareAndSet(i51Var, i51Var2)) {
                return;
            }
        } while (atomicReference.get() == i51Var);
        i51Var2.m5163a();
    }

    public IoScheduler(ThreadFactory threadFactory) {
        this.f19854c = threadFactory;
        this.f19855d = new AtomicReference(f19853k);
        start();
    }
}
