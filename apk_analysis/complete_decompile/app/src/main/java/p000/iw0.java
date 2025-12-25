package p000;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes2.dex */
public final class iw0 {

    /* renamed from: c */
    public final AtomicInteger f20287c;

    /* renamed from: d */
    public final ListenableFuture[] f20288d;

    /* renamed from: a */
    public boolean f20285a = false;

    /* renamed from: b */
    public boolean f20286b = true;

    /* renamed from: e */
    public volatile int f20289e = 0;

    public iw0(ListenableFuture[] listenableFutureArr) {
        this.f20288d = listenableFutureArr;
        this.f20287c = new AtomicInteger(listenableFutureArr.length);
    }

    /* renamed from: a */
    public final void m5367a() {
        if (this.f20287c.decrementAndGet() == 0 && this.f20285a) {
            for (ListenableFuture listenableFuture : this.f20288d) {
                if (listenableFuture != null) {
                    listenableFuture.cancel(this.f20286b);
                }
            }
        }
    }
}
