package p000;

import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.LockSupport;

/* loaded from: classes2.dex */
public abstract class a51 extends AtomicReference implements Runnable {

    /* renamed from: a */
    public static final a80 f41a = new a80(2);

    /* renamed from: b */
    public static final a80 f42b = new a80(2);

    /* renamed from: a */
    public abstract void mo21a(Throwable th);

    /* renamed from: b */
    public abstract void mo22b(Object obj);

    /* renamed from: c */
    public final void m23c() {
        a80 a80Var = f42b;
        a80 a80Var2 = f41a;
        Runnable runnable = (Runnable) get();
        if (runnable instanceof Thread) {
            z41 z41Var = new z41(this);
            z41.m8391a(z41Var, Thread.currentThread());
            if (compareAndSet(runnable, z41Var)) {
                try {
                    ((Thread) runnable).interrupt();
                } finally {
                    if (((Runnable) getAndSet(a80Var2)) == a80Var) {
                        LockSupport.unpark((Thread) runnable);
                    }
                }
            }
        }
    }

    /* renamed from: d */
    public abstract boolean mo24d();

    /* renamed from: e */
    public abstract Object mo25e();

    /* renamed from: f */
    public abstract String mo26f();

    /* renamed from: g */
    public final void m27g(Thread thread) {
        Runnable runnable = (Runnable) get();
        z41 z41Var = null;
        boolean z = false;
        int i = 0;
        while (true) {
            boolean z2 = runnable instanceof z41;
            a80 a80Var = f42b;
            if (!z2 && runnable != a80Var) {
                break;
            }
            if (z2) {
                z41Var = (z41) runnable;
            }
            i++;
            if (i > 1000) {
                if (runnable == a80Var || compareAndSet(runnable, a80Var)) {
                    if (!Thread.interrupted() && !z) {
                        z = false;
                    } else {
                        z = true;
                    }
                    LockSupport.park(z41Var);
                }
            } else {
                Thread.yield();
            }
            runnable = (Runnable) get();
        }
        if (z) {
            thread.interrupt();
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        Thread currentThread = Thread.currentThread();
        Object obj = null;
        if (!compareAndSet(null, currentThread)) {
            return;
        }
        boolean mo24d = mo24d();
        a80 a80Var = f41a;
        if (!mo24d) {
            try {
                obj = mo25e();
            } catch (Throwable th) {
                if (!compareAndSet(currentThread, a80Var)) {
                    m27g(currentThread);
                }
                if (!mo24d) {
                    mo21a(th);
                    return;
                }
                return;
            }
        }
        if (!compareAndSet(currentThread, a80Var)) {
            m27g(currentThread);
        }
        if (!mo24d) {
            mo22b(obj);
        }
    }

    @Override // java.util.concurrent.atomic.AtomicReference
    public final String toString() {
        String str;
        Runnable runnable = (Runnable) get();
        if (runnable == f41a) {
            str = "running=[DONE]";
        } else if (runnable instanceof z41) {
            str = "running=[INTERRUPTED]";
        } else if (runnable instanceof Thread) {
            String name = ((Thread) runnable).getName();
            str = AbstractC1726qj.m7059o("running=[RUNNING ON ", name, "]", AbstractC1726qj.m7052h(21, name));
        } else {
            str = "running=[NOT STARTED YET]";
        }
        String mo26f = mo26f();
        return AbstractC1726qj.m7059o(str, ", ", mo26f, AbstractC1726qj.m7052h(AbstractC1726qj.m7052h(2, str), mo26f));
    }
}
