package p000;

import com.google.firebase.concurrent.PausableExecutorService;
import com.google.firebase.concurrent.PausableScheduledExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public final class e42 extends z10 implements PausableScheduledExecutorService {

    /* renamed from: c */
    public final PausableExecutorService f16671c;

    public e42(PausableExecutorService pausableExecutorService, ScheduledExecutorService scheduledExecutorService) {
        super(pausableExecutorService, scheduledExecutorService);
        this.f16671c = pausableExecutorService;
    }

    @Override // com.google.firebase.concurrent.PausableExecutor
    public final boolean isPaused() {
        return this.f16671c.isPaused();
    }

    @Override // com.google.firebase.concurrent.PausableExecutor
    public final void pause() {
        this.f16671c.pause();
    }

    @Override // com.google.firebase.concurrent.PausableExecutor
    public final void resume() {
        this.f16671c.resume();
    }

    @Override // p000.z10, java.util.concurrent.ScheduledExecutorService
    public final ScheduledFuture scheduleAtFixedRate(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        throw new UnsupportedOperationException();
    }

    @Override // p000.z10, java.util.concurrent.ScheduledExecutorService
    public final ScheduledFuture scheduleWithFixedDelay(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        throw new UnsupportedOperationException();
    }
}
