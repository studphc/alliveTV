package p000;

import com.google.firebase.concurrent.PausableExecutor;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;

/* loaded from: classes2.dex */
public final class c42 implements PausableExecutor {

    /* renamed from: b */
    public final Executor f8249b;

    /* renamed from: c */
    public final LinkedBlockingQueue f8250c = new LinkedBlockingQueue();

    /* renamed from: a */
    public volatile boolean f8248a = false;

    public c42(Executor executor) {
        this.f8249b = executor;
    }

    /* renamed from: a */
    public final void m2196a() {
        if (this.f8248a) {
            return;
        }
        Runnable runnable = (Runnable) this.f8250c.poll();
        while (runnable != null) {
            this.f8249b.execute(runnable);
            if (!this.f8248a) {
                runnable = (Runnable) this.f8250c.poll();
            } else {
                runnable = null;
            }
        }
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        this.f8250c.offer(runnable);
        m2196a();
    }

    @Override // com.google.firebase.concurrent.PausableExecutor
    public final boolean isPaused() {
        return this.f8248a;
    }

    @Override // com.google.firebase.concurrent.PausableExecutor
    public final void pause() {
        this.f8248a = true;
    }

    @Override // com.google.firebase.concurrent.PausableExecutor
    public final void resume() {
        this.f8248a = false;
        m2196a();
    }
}
