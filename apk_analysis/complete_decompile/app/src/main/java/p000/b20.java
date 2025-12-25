package p000;

import androidx.concurrent.futures.AbstractResolvableFuture;
import java.util.concurrent.Delayed;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public final class b20 extends AbstractResolvableFuture implements ScheduledFuture {

    /* renamed from: h */
    public final ScheduledFuture f7862h;

    public b20(a20 a20Var) {
        this.f7862h = a20Var.mo2a(new b01(12, this));
    }

    @Override // androidx.concurrent.futures.AbstractResolvableFuture
    public final void afterDone() {
        this.f7862h.cancel(wasInterrupted());
    }

    @Override // java.lang.Comparable
    public final int compareTo(Delayed delayed) {
        return this.f7862h.compareTo(delayed);
    }

    @Override // java.util.concurrent.Delayed
    public final long getDelay(TimeUnit timeUnit) {
        return this.f7862h.getDelay(timeUnit);
    }
}
