package p000;

import com.google.common.util.concurrent.AbstractFuture;
import com.google.common.util.concurrent.ListenableFuture;

/* renamed from: m0 */
/* loaded from: classes2.dex */
public final class RunnableC1531m0 implements Runnable {

    /* renamed from: a */
    public final AbstractFuture f22736a;

    /* renamed from: b */
    public final ListenableFuture f22737b;

    public RunnableC1531m0(AbstractFuture abstractFuture, ListenableFuture listenableFuture) {
        this.f22736a = abstractFuture;
        this.f22737b = listenableFuture;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.f22736a.f15255a != this) {
            return;
        }
        if (AbstractFuture.f15253f.mo5807j(this.f22736a, this, AbstractFuture.m4308f(this.f22737b))) {
            AbstractFuture.m4305c(this.f22736a);
        }
    }
}
