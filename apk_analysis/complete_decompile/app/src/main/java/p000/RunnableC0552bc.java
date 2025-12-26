package p000;

import androidx.loader.content.AsyncTaskLoader;
import java.util.concurrent.CountDownLatch;

/* renamed from: bc */
/* loaded from: classes.dex */
public final class RunnableC0552bc extends ro1 implements Runnable {

    /* renamed from: i */
    public final CountDownLatch f7959i = new CountDownLatch(1);

    /* renamed from: j */
    public boolean f7960j;

    /* renamed from: k */
    public final /* synthetic */ AsyncTaskLoader f7961k;

    public RunnableC0552bc(AsyncTaskLoader asyncTaskLoader) {
        this.f7961k = asyncTaskLoader;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f7960j = false;
        this.f7961k.m1546a();
    }
}
