package p000;

import java.util.concurrent.ScheduledFuture;
import kotlinx.coroutines.DisposableHandle;

/* loaded from: classes2.dex */
public final class h50 implements DisposableHandle {

    /* renamed from: a */
    public final ScheduledFuture f17942a;

    public h50(ScheduledFuture scheduledFuture) {
        this.f17942a = scheduledFuture;
    }

    @Override // kotlinx.coroutines.DisposableHandle
    public final void dispose() {
        this.f17942a.cancel(false);
    }

    public final String toString() {
        return "DisposableFutureHandle[" + this.f17942a + ']';
    }
}
