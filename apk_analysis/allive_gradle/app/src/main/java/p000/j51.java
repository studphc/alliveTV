package p000;

import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import io.reactivex.rxjava3.internal.schedulers.IoScheduler;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes2.dex */
public final class j51 extends Scheduler.Worker implements Runnable {

    /* renamed from: b */
    public final i51 f20378b;

    /* renamed from: c */
    public final k51 f20379c;

    /* renamed from: d */
    public final AtomicBoolean f20380d = new AtomicBoolean();

    /* renamed from: a */
    public final CompositeDisposable f20377a = new CompositeDisposable();

    public j51(i51 i51Var) {
        k51 k51Var;
        k51 k51Var2;
        this.f20378b = i51Var;
        CompositeDisposable compositeDisposable = i51Var.f18301c;
        if (compositeDisposable.isDisposed()) {
            k51Var2 = IoScheduler.f19851i;
            this.f20379c = k51Var2;
        }
        while (true) {
            ConcurrentLinkedQueue concurrentLinkedQueue = i51Var.f18300b;
            if (!concurrentLinkedQueue.isEmpty()) {
                k51Var = (k51) concurrentLinkedQueue.poll();
                if (k51Var != null) {
                    break;
                }
            } else {
                k51Var = new k51(i51Var.f18304f);
                compositeDisposable.add(k51Var);
                break;
            }
        }
        k51Var2 = k51Var;
        this.f20379c = k51Var2;
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final void dispose() {
        if (this.f20380d.compareAndSet(false, true)) {
            this.f20377a.dispose();
            if (IoScheduler.f19852j) {
                this.f20379c.scheduleActual(this, 0L, TimeUnit.NANOSECONDS, null);
                return;
            }
            i51 i51Var = this.f20378b;
            i51Var.getClass();
            long nanoTime = System.nanoTime() + i51Var.f18299a;
            k51 k51Var = this.f20379c;
            k51Var.f20751c = nanoTime;
            i51Var.f18300b.offer(k51Var);
        }
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final boolean isDisposed() {
        return this.f20380d.get();
    }

    @Override // java.lang.Runnable
    public final void run() {
        i51 i51Var = this.f20378b;
        i51Var.getClass();
        long nanoTime = System.nanoTime() + i51Var.f18299a;
        k51 k51Var = this.f20379c;
        k51Var.f20751c = nanoTime;
        i51Var.f18300b.offer(k51Var);
    }

    @Override // io.reactivex.rxjava3.core.Scheduler.Worker
    public final Disposable schedule(Runnable runnable, long j, TimeUnit timeUnit) {
        if (this.f20377a.isDisposed()) {
            return EmptyDisposable.INSTANCE;
        }
        return this.f20379c.scheduleActual(runnable, j, timeUnit, this.f20377a);
    }
}
