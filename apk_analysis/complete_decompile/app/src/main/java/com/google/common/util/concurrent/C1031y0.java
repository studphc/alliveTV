package com.google.common.util.concurrent;

import com.google.common.util.concurrent.ForwardingListenableFuture;
import java.util.concurrent.Delayed;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* renamed from: com.google.common.util.concurrent.y0 */
/* loaded from: classes2.dex */
public final class C1031y0 extends ForwardingListenableFuture.SimpleForwardingListenableFuture implements ListenableScheduledFuture {

    /* renamed from: b */
    public final ScheduledFuture f15445b;

    public C1031y0(AbstractFuture abstractFuture, ScheduledFuture scheduledFuture) {
        super(abstractFuture);
        this.f15445b = scheduledFuture;
    }

    @Override // com.google.common.util.concurrent.ForwardingFuture, java.util.concurrent.Future
    public final boolean cancel(boolean z) {
        boolean cancel = super.cancel(z);
        if (cancel) {
            this.f15445b.cancel(z);
        }
        return cancel;
    }

    @Override // java.lang.Comparable
    public final int compareTo(Delayed delayed) {
        return this.f15445b.compareTo(delayed);
    }

    @Override // java.util.concurrent.Delayed
    public final long getDelay(TimeUnit timeUnit) {
        return this.f15445b.getDelay(timeUnit);
    }
}
