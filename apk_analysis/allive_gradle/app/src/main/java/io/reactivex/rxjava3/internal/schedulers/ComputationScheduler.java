package io.reactivex.rxjava3.internal.schedulers;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.functions.ObjectHelper;
import io.reactivex.rxjava3.internal.schedulers.SchedulerMultiWorkerSupport;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import p000.C1330iu;
import p000.C1367ju;

/* loaded from: classes2.dex */
public final class ComputationScheduler extends Scheduler implements SchedulerMultiWorkerSupport {

    /* renamed from: e */
    public static final C1322a f19829e;

    /* renamed from: f */
    public static final RxThreadFactory f19830f;

    /* renamed from: g */
    public static final int f19831g;

    /* renamed from: h */
    public static final C1367ju f19832h;

    /* renamed from: c */
    public final ThreadFactory f19833c;

    /* renamed from: d */
    public final AtomicReference f19834d;

    /* JADX WARN: Type inference failed for: r0v3, types: [io.reactivex.rxjava3.internal.schedulers.NewThreadWorker, ju] */
    static {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        int intValue = Integer.getInteger("rx3.computation-threads", 0).intValue();
        if (intValue > 0 && intValue <= availableProcessors) {
            availableProcessors = intValue;
        }
        f19831g = availableProcessors;
        ?? newThreadWorker = new NewThreadWorker(new RxThreadFactory("RxComputationShutdown"));
        f19832h = newThreadWorker;
        newThreadWorker.dispose();
        RxThreadFactory rxThreadFactory = new RxThreadFactory("RxComputationThreadPool", Math.max(1, Math.min(10, Integer.getInteger("rx3.computation-priority", 5).intValue())), true);
        f19830f = rxThreadFactory;
        C1322a c1322a = new C1322a(rxThreadFactory, 0);
        f19829e = c1322a;
        c1322a.m5299b();
    }

    public ComputationScheduler() {
        this(f19830f);
    }

    @Override // io.reactivex.rxjava3.core.Scheduler
    @NonNull
    public Scheduler.Worker createWorker() {
        return new C1330iu(((C1322a) this.f19834d.get()).m5298a());
    }

    @Override // io.reactivex.rxjava3.internal.schedulers.SchedulerMultiWorkerSupport
    public void createWorkers(int i, SchedulerMultiWorkerSupport.WorkerCallback workerCallback) {
        ObjectHelper.verifyPositive(i, "number > 0 required");
        ((C1322a) this.f19834d.get()).createWorkers(i, workerCallback);
    }

    @Override // io.reactivex.rxjava3.core.Scheduler
    @NonNull
    public Disposable scheduleDirect(@NonNull Runnable runnable, long j, TimeUnit timeUnit) {
        return ((C1322a) this.f19834d.get()).m5298a().scheduleDirect(runnable, j, timeUnit);
    }

    @Override // io.reactivex.rxjava3.core.Scheduler
    @NonNull
    public Disposable schedulePeriodicallyDirect(@NonNull Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        return ((C1322a) this.f19834d.get()).m5298a().schedulePeriodicallyDirect(runnable, j, j2, timeUnit);
    }

    @Override // io.reactivex.rxjava3.core.Scheduler
    public void shutdown() {
        AtomicReference atomicReference = this.f19834d;
        C1322a c1322a = f19829e;
        C1322a c1322a2 = (C1322a) atomicReference.getAndSet(c1322a);
        if (c1322a2 != c1322a) {
            c1322a2.m5299b();
        }
    }

    @Override // io.reactivex.rxjava3.core.Scheduler
    public void start() {
        C1322a c1322a;
        C1322a c1322a2 = new C1322a(this.f19833c, f19831g);
        AtomicReference atomicReference = this.f19834d;
        do {
            c1322a = f19829e;
            if (atomicReference.compareAndSet(c1322a, c1322a2)) {
                return;
            }
        } while (atomicReference.get() == c1322a);
        c1322a2.m5299b();
    }

    public ComputationScheduler(ThreadFactory threadFactory) {
        this.f19833c = threadFactory;
        this.f19834d = new AtomicReference(f19829e);
        start();
    }
}
