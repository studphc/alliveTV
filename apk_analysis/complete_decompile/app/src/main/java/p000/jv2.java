package p000;

import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes2.dex */
public final class jv2 extends Scheduler.Worker {

    /* renamed from: a */
    public final PriorityBlockingQueue f20651a = new PriorityBlockingQueue();

    /* renamed from: b */
    public final AtomicInteger f20652b = new AtomicInteger();

    /* renamed from: c */
    public final AtomicInteger f20653c = new AtomicInteger();

    /* renamed from: d */
    public volatile boolean f20654d;

    /* renamed from: a */
    public final Disposable m5463a(long j, Runnable runnable) {
        if (this.f20654d) {
            return EmptyDisposable.INSTANCE;
        }
        iv2 iv2Var = new iv2(runnable, Long.valueOf(j), this.f20653c.incrementAndGet());
        this.f20651a.add(iv2Var);
        if (this.f20652b.getAndIncrement() == 0) {
            int i = 1;
            while (!this.f20654d) {
                iv2 iv2Var2 = (iv2) this.f20651a.poll();
                if (iv2Var2 == null) {
                    i = this.f20652b.addAndGet(-i);
                    if (i == 0) {
                        return EmptyDisposable.INSTANCE;
                    }
                } else if (!iv2Var2.f20283d) {
                    iv2Var2.f20280a.run();
                }
            }
            this.f20651a.clear();
            return EmptyDisposable.INSTANCE;
        }
        return g50.m4925g(new xy1(19, this, iv2Var));
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final void dispose() {
        this.f20654d = true;
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final boolean isDisposed() {
        return this.f20654d;
    }

    @Override // io.reactivex.rxjava3.core.Scheduler.Worker
    public final Disposable schedule(Runnable runnable) {
        return m5463a(now(TimeUnit.MILLISECONDS), runnable);
    }

    @Override // io.reactivex.rxjava3.core.Scheduler.Worker
    public final Disposable schedule(Runnable runnable, long j, TimeUnit timeUnit) {
        long millis = timeUnit.toMillis(j) + now(TimeUnit.MILLISECONDS);
        return m5463a(millis, new vo1(runnable, this, millis));
    }
}
