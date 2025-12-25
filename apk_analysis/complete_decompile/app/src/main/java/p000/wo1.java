package p000;

import com.google.common.util.concurrent.AbstractListeningExecutorService;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public final class wo1 extends AbstractListeningExecutorService {

    /* renamed from: a */
    public final Object f28259a = new Object();

    /* renamed from: b */
    public int f28260b = 0;

    /* renamed from: c */
    public boolean f28261c = false;

    /* renamed from: a */
    public final void m8069a() {
        synchronized (this.f28259a) {
            try {
                int i = this.f28260b - 1;
                this.f28260b = i;
                if (i == 0) {
                    this.f28259a.notifyAll();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // java.util.concurrent.ExecutorService
    public final boolean awaitTermination(long j, TimeUnit timeUnit) {
        long nanos = timeUnit.toNanos(j);
        synchronized (this.f28259a) {
            while (true) {
                try {
                    if (this.f28261c && this.f28260b == 0) {
                        return true;
                    }
                    if (nanos <= 0) {
                        return false;
                    }
                    long nanoTime = System.nanoTime();
                    TimeUnit.NANOSECONDS.timedWait(this.f28259a, nanos);
                    nanos -= System.nanoTime() - nanoTime;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        synchronized (this.f28259a) {
            if (!this.f28261c) {
                this.f28260b++;
            } else {
                throw new RejectedExecutionException("Executor already shutdown");
            }
        }
        try {
            runnable.run();
        } finally {
            m8069a();
        }
    }

    @Override // java.util.concurrent.ExecutorService
    public final boolean isShutdown() {
        boolean z;
        synchronized (this.f28259a) {
            z = this.f28261c;
        }
        return z;
    }

    @Override // java.util.concurrent.ExecutorService
    public final boolean isTerminated() {
        boolean z;
        synchronized (this.f28259a) {
            try {
                if (this.f28261c && this.f28260b == 0) {
                    z = true;
                } else {
                    z = false;
                }
            } finally {
            }
        }
        return z;
    }

    @Override // java.util.concurrent.ExecutorService
    public final void shutdown() {
        synchronized (this.f28259a) {
            try {
                this.f28261c = true;
                if (this.f28260b == 0) {
                    this.f28259a.notifyAll();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // java.util.concurrent.ExecutorService
    public final List shutdownNow() {
        shutdown();
        return Collections.emptyList();
    }
}
