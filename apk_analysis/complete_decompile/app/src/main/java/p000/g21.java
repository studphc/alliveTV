package p000;

import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.schedulers.ImmediateThinScheduler;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public final class g21 extends Scheduler.Worker {
    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final boolean isDisposed() {
        return false;
    }

    @Override // io.reactivex.rxjava3.core.Scheduler.Worker
    public final Disposable schedule(Runnable runnable) {
        runnable.run();
        return ImmediateThinScheduler.f19846d;
    }

    @Override // io.reactivex.rxjava3.core.Scheduler.Worker
    public final Disposable schedulePeriodically(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        throw new UnsupportedOperationException("This scheduler doesn't support periodic execution");
    }

    @Override // io.reactivex.rxjava3.core.Scheduler.Worker
    public final Disposable schedule(Runnable runnable, long j, TimeUnit timeUnit) {
        throw new UnsupportedOperationException("This scheduler doesn't support delayed execution");
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final void dispose() {
    }
}
