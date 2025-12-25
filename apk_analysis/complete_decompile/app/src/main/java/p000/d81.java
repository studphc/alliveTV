package p000;

import com.google.firebase.components.Preconditions;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.Semaphore;

/* loaded from: classes2.dex */
public class d81 implements Executor {

    /* renamed from: a */
    public final Executor f16287a;

    /* renamed from: b */
    public final Semaphore f16288b;

    /* renamed from: c */
    public final LinkedBlockingQueue f16289c = new LinkedBlockingQueue();

    public d81(Executor executor, int i) {
        boolean z;
        if (i > 0) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkArgument(z, "concurrency must be positive.");
        this.f16287a = executor;
        this.f16288b = new Semaphore(i, true);
    }

    /* renamed from: a */
    public final void m4552a() {
        while (true) {
            Semaphore semaphore = this.f16288b;
            if (semaphore.tryAcquire()) {
                Runnable runnable = (Runnable) this.f16289c.poll();
                if (runnable != null) {
                    this.f16287a.execute(new RunnableC0583c7(23, this, runnable));
                } else {
                    semaphore.release();
                    return;
                }
            } else {
                return;
            }
        }
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        this.f16289c.offer(runnable);
        m4552a();
    }
}
