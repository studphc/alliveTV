package p000;

import java.util.ArrayDeque;
import java.util.concurrent.Executor;

/* renamed from: r8 */
/* loaded from: classes.dex */
public final class ExecutorC1752r8 implements Executor {

    /* renamed from: a */
    public final Object f25891a = new Object();

    /* renamed from: b */
    public final ArrayDeque f25892b = new ArrayDeque();

    /* renamed from: c */
    public final d40 f25893c;

    /* renamed from: d */
    public Runnable f25894d;

    public ExecutorC1752r8(d40 d40Var) {
        this.f25893c = d40Var;
    }

    /* renamed from: a */
    public final void m7229a() {
        synchronized (this.f25891a) {
            try {
                Runnable runnable = (Runnable) this.f25892b.poll();
                this.f25894d = runnable;
                if (runnable != null) {
                    this.f25893c.execute(runnable);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        synchronized (this.f25891a) {
            try {
                this.f25892b.add(new RunnableC0583c7(3, this, runnable));
                if (this.f25894d == null) {
                    m7229a();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
