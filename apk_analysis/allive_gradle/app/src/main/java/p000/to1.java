package p000;

import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.C0994g;
import com.google.common.util.concurrent.Callables;
import java.util.concurrent.Callable;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public final class to1 extends i63 implements ScheduledExecutorService {

    /* renamed from: b */
    public final ScheduledExecutorService f26910b;

    /* renamed from: c */
    public final /* synthetic */ C0994g f26911c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public to1(ScheduledExecutorService scheduledExecutorService, C0994g c0994g) {
        super(scheduledExecutorService);
        this.f26911c = c0994g;
        this.f26910b = scheduledExecutorService;
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public final ScheduledFuture schedule(Callable callable, long j, TimeUnit timeUnit) {
        C0994g c0994g = this.f26911c;
        Preconditions.checkNotNull(c0994g);
        Preconditions.checkNotNull(callable);
        return this.f26910b.schedule(new CallableC1764rk(0, c0994g, callable), j, timeUnit);
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public final ScheduledFuture scheduleAtFixedRate(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        return this.f26910b.scheduleAtFixedRate(Callables.m4318a(runnable, this.f26911c), j, j2, timeUnit);
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public final ScheduledFuture scheduleWithFixedDelay(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        return this.f26910b.scheduleWithFixedDelay(Callables.m4318a(runnable, this.f26911c), j, j2, timeUnit);
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public final ScheduledFuture schedule(Runnable runnable, long j, TimeUnit timeUnit) {
        return this.f26910b.schedule(Callables.m4318a(runnable, this.f26911c), j, timeUnit);
    }
}
