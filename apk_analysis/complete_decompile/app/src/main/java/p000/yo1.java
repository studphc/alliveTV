package p000;

import com.google.common.base.Preconditions;
import com.google.common.base.Throwables;

/* loaded from: classes2.dex */
public final class yo1 extends AbstractC1670p0 implements Runnable {

    /* renamed from: h */
    public final Runnable f29053h;

    public yo1(Runnable runnable) {
        this.f29053h = (Runnable) Preconditions.checkNotNull(runnable);
    }

    @Override // com.google.common.util.concurrent.AbstractFuture
    public final String pendingToString() {
        String valueOf = String.valueOf(this.f29053h);
        return AbstractC1726qj.m7059o("task=[", valueOf, "]", valueOf.length() + 7);
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            this.f29053h.run();
        } catch (Throwable th) {
            setException(th);
            throw Throwables.propagate(th);
        }
    }
}
