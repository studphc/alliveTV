package p000;

import androidx.concurrent.futures.AbstractResolvableFuture;
import com.google.common.util.concurrent.ListenableFuture;

/* renamed from: u2 */
/* loaded from: classes.dex */
public final class RunnableC1857u2 implements Runnable {

    /* renamed from: a */
    public final AbstractResolvableFuture f27070a;

    /* renamed from: b */
    public final ListenableFuture f27071b;

    public RunnableC1857u2(AbstractResolvableFuture abstractResolvableFuture, ListenableFuture listenableFuture) {
        this.f27070a = abstractResolvableFuture;
        this.f27071b = listenableFuture;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.f27070a.f1808a != this) {
            return;
        }
        if (AbstractResolvableFuture.f1806f.mo6481e(this.f27070a, this, AbstractResolvableFuture.m419e(this.f27071b))) {
            AbstractResolvableFuture.m416b(this.f27070a);
        }
    }
}
