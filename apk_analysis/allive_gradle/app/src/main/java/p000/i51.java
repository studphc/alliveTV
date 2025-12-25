package p000;

import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.internal.schedulers.IoScheduler;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public final class i51 implements Runnable {

    /* renamed from: a */
    public final long f18299a;

    /* renamed from: b */
    public final ConcurrentLinkedQueue f18300b;

    /* renamed from: c */
    public final CompositeDisposable f18301c;

    /* renamed from: d */
    public final ScheduledExecutorService f18302d;

    /* renamed from: e */
    public final ScheduledFuture f18303e;

    /* renamed from: f */
    public final ThreadFactory f18304f;

    public i51(long j, TimeUnit timeUnit, ThreadFactory threadFactory) {
        long j2;
        ScheduledExecutorService scheduledExecutorService;
        ScheduledFuture<?> scheduledFuture;
        if (timeUnit != null) {
            j2 = timeUnit.toNanos(j);
        } else {
            j2 = 0;
        }
        long j3 = j2;
        this.f18299a = j3;
        this.f18300b = new ConcurrentLinkedQueue();
        this.f18301c = new CompositeDisposable();
        this.f18304f = threadFactory;
        if (timeUnit != null) {
            scheduledExecutorService = Executors.newScheduledThreadPool(1, IoScheduler.f19848f);
            scheduledFuture = scheduledExecutorService.scheduleWithFixedDelay(this, j3, j3, TimeUnit.NANOSECONDS);
        } else {
            scheduledExecutorService = null;
            scheduledFuture = null;
        }
        this.f18302d = scheduledExecutorService;
        this.f18303e = scheduledFuture;
    }

    /* renamed from: a */
    public final void m5163a() {
        this.f18301c.dispose();
        ScheduledFuture scheduledFuture = this.f18303e;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(true);
        }
        ScheduledExecutorService scheduledExecutorService = this.f18302d;
        if (scheduledExecutorService != null) {
            scheduledExecutorService.shutdownNow();
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        ConcurrentLinkedQueue concurrentLinkedQueue = this.f18300b;
        if (!concurrentLinkedQueue.isEmpty()) {
            long nanoTime = System.nanoTime();
            Iterator it = concurrentLinkedQueue.iterator();
            while (it.hasNext()) {
                k51 k51Var = (k51) it.next();
                if (k51Var.f20751c <= nanoTime) {
                    if (concurrentLinkedQueue.remove(k51Var)) {
                        this.f18301c.remove(k51Var);
                    }
                } else {
                    return;
                }
            }
        }
    }
}
