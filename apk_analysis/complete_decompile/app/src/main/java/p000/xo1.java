package p000;

import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.AbstractListeningExecutorService;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public class xo1 extends AbstractListeningExecutorService {

    /* renamed from: a */
    public final ExecutorService f28671a;

    public xo1(ExecutorService executorService) {
        this.f28671a = (ExecutorService) Preconditions.checkNotNull(executorService);
    }

    @Override // java.util.concurrent.ExecutorService
    public final boolean awaitTermination(long j, TimeUnit timeUnit) {
        return this.f28671a.awaitTermination(j, timeUnit);
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        this.f28671a.execute(runnable);
    }

    @Override // java.util.concurrent.ExecutorService
    public final boolean isShutdown() {
        return this.f28671a.isShutdown();
    }

    @Override // java.util.concurrent.ExecutorService
    public final boolean isTerminated() {
        return this.f28671a.isTerminated();
    }

    @Override // java.util.concurrent.ExecutorService
    public final void shutdown() {
        this.f28671a.shutdown();
    }

    @Override // java.util.concurrent.ExecutorService
    public final List shutdownNow() {
        return this.f28671a.shutdownNow();
    }

    public final String toString() {
        String obj = super.toString();
        String valueOf = String.valueOf(this.f28671a);
        return AbstractC1726qj.m7055k(valueOf.length() + AbstractC1726qj.m7052h(2, obj), obj, "[", valueOf, "]");
    }
}
