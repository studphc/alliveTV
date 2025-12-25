package p000;

import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import io.reactivex.rxjava3.schedulers.TestScheduler;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public final class ps2 extends Scheduler.Worker {

    /* renamed from: a */
    public volatile boolean f25279a;

    /* renamed from: b */
    public final /* synthetic */ TestScheduler f25280b;

    public ps2(TestScheduler testScheduler) {
        this.f25280b = testScheduler;
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final void dispose() {
        this.f25279a = true;
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final boolean isDisposed() {
        return this.f25279a;
    }

    @Override // io.reactivex.rxjava3.core.Scheduler.Worker
    public final long now(TimeUnit timeUnit) {
        return this.f25280b.now(timeUnit);
    }

    @Override // io.reactivex.rxjava3.core.Scheduler.Worker
    public final Disposable schedule(Runnable runnable, long j, TimeUnit timeUnit) {
        if (this.f25279a) {
            return EmptyDisposable.INSTANCE;
        }
        if (this.f25280b.f20091d) {
            runnable = RxJavaPlugins.onSchedule(runnable);
        }
        long nanos = timeUnit.toNanos(j) + this.f25280b.f20093f;
        TestScheduler testScheduler = this.f25280b;
        long j2 = testScheduler.f20092e;
        testScheduler.f20092e = 1 + j2;
        qs2 qs2Var = new qs2(this, nanos, runnable, j2);
        testScheduler.f20090c.add(qs2Var);
        return new os2(this, qs2Var);
    }

    @Override // io.reactivex.rxjava3.core.Scheduler.Worker
    public final Disposable schedule(Runnable runnable) {
        if (this.f25279a) {
            return EmptyDisposable.INSTANCE;
        }
        if (this.f25280b.f20091d) {
            runnable = RxJavaPlugins.onSchedule(runnable);
        }
        TestScheduler testScheduler = this.f25280b;
        long j = testScheduler.f20092e;
        testScheduler.f20092e = 1 + j;
        qs2 qs2Var = new qs2(this, 0L, runnable, j);
        testScheduler.f20090c.add(qs2Var);
        return new os2(this, qs2Var);
    }
}
