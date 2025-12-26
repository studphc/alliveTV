package p000;

import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.C1031y0;
import com.google.common.util.concurrent.ListenableScheduledFuture;
import com.google.common.util.concurrent.ListeningScheduledExecutorService;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public final class zo1 extends xo1 implements ListeningScheduledExecutorService {

    /* renamed from: b */
    public final ScheduledExecutorService f29457b;

    public zo1(ScheduledExecutorService scheduledExecutorService) {
        super(scheduledExecutorService);
        this.f29457b = (ScheduledExecutorService) Preconditions.checkNotNull(scheduledExecutorService);
    }

    @Override // com.google.common.util.concurrent.ListeningScheduledExecutorService, java.util.concurrent.ScheduledExecutorService
    public final ListenableScheduledFuture schedule(Callable callable, long j, TimeUnit timeUnit) {
        yw2 yw2Var = new yw2(callable);
        return new C1031y0(yw2Var, this.f29457b.schedule(yw2Var, j, timeUnit));
    }

    @Override // com.google.common.util.concurrent.ListeningScheduledExecutorService, java.util.concurrent.ScheduledExecutorService
    public final ListenableScheduledFuture scheduleAtFixedRate(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        yo1 yo1Var = new yo1(runnable);
        return new C1031y0(yo1Var, this.f29457b.scheduleAtFixedRate(yo1Var, j, j2, timeUnit));
    }

    @Override // com.google.common.util.concurrent.ListeningScheduledExecutorService, java.util.concurrent.ScheduledExecutorService
    public final ListenableScheduledFuture scheduleWithFixedDelay(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        yo1 yo1Var = new yo1(runnable);
        return new C1031y0(yo1Var, this.f29457b.scheduleWithFixedDelay(yo1Var, j, j2, timeUnit));
    }

    @Override // com.google.common.util.concurrent.ListeningScheduledExecutorService, java.util.concurrent.ScheduledExecutorService
    public final ListenableScheduledFuture schedule(Runnable runnable, long j, TimeUnit timeUnit) {
        yw2 yw2Var = new yw2(Executors.callable(runnable, null));
        return new C1031y0(yw2Var, this.f29457b.schedule(yw2Var, j, timeUnit));
    }
}
