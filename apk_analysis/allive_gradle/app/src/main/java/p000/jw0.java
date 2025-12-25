package p000;

import com.google.common.util.concurrent.ListenableFuture;

/* loaded from: classes2.dex */
public final class jw0 extends AbstractC1670p0 implements Runnable {

    /* renamed from: h */
    public ListenableFuture f20658h;

    @Override // com.google.common.util.concurrent.AbstractFuture
    public final void afterDone() {
        this.f20658h = null;
    }

    @Override // com.google.common.util.concurrent.AbstractFuture
    public final String pendingToString() {
        ListenableFuture listenableFuture = this.f20658h;
        if (listenableFuture != null) {
            String valueOf = String.valueOf(listenableFuture);
            return AbstractC1726qj.m7059o("delegate=[", valueOf, "]", valueOf.length() + 11);
        }
        return null;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ListenableFuture listenableFuture = this.f20658h;
        if (listenableFuture != null) {
            setFuture(listenableFuture);
        }
    }
}
