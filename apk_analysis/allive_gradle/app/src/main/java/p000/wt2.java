package p000;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public final class wt2 extends os0 {

    /* renamed from: h */
    public ListenableFuture f28329h;

    /* renamed from: i */
    public ScheduledFuture f28330i;

    @Override // com.google.common.util.concurrent.AbstractFuture
    public final void afterDone() {
        m4312h(this.f28329h);
        ScheduledFuture scheduledFuture = this.f28330i;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(false);
        }
        this.f28329h = null;
        this.f28330i = null;
    }

    @Override // com.google.common.util.concurrent.AbstractFuture
    public final String pendingToString() {
        ListenableFuture listenableFuture = this.f28329h;
        ScheduledFuture scheduledFuture = this.f28330i;
        if (listenableFuture != null) {
            String valueOf = String.valueOf(listenableFuture);
            String m7059o = AbstractC1726qj.m7059o("inputFuture=[", valueOf, "]", valueOf.length() + 14);
            if (scheduledFuture != null) {
                long delay = scheduledFuture.getDelay(TimeUnit.MILLISECONDS);
                if (delay > 0) {
                    String valueOf2 = String.valueOf(m7059o);
                    StringBuilder sb = new StringBuilder(valueOf2.length() + 43);
                    sb.append(valueOf2);
                    sb.append(", remaining delay=[");
                    sb.append(delay);
                    sb.append(" ms]");
                    return sb.toString();
                }
                return m7059o;
            }
            return m7059o;
        }
        return null;
    }
}
