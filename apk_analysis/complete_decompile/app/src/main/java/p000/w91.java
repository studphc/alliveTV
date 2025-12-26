package p000;

import com.google.common.base.Preconditions;
import com.google.common.collect.Queues;
import java.util.ArrayDeque;
import java.util.concurrent.Executor;

/* loaded from: classes2.dex */
public final class w91 implements Runnable {

    /* renamed from: a */
    public final Object f28102a;

    /* renamed from: b */
    public final Executor f28103b;

    /* renamed from: c */
    public final ArrayDeque f28104c = Queues.newArrayDeque();

    /* renamed from: d */
    public final ArrayDeque f28105d = Queues.newArrayDeque();

    /* renamed from: e */
    public boolean f28106e;

    public w91(Object obj, Executor executor) {
        this.f28102a = Preconditions.checkNotNull(obj);
        this.f28103b = (Executor) Preconditions.checkNotNull(executor);
    }

    /* renamed from: a */
    public final synchronized void m8011a(v91 v91Var, v91 v91Var2) {
        this.f28104c.add(v91Var);
        this.f28105d.add(v91Var2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0025, code lost:
    
        r2.mo4346a(r10.f28102a);
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x002d, code lost:
    
        r2 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x002e, code lost:
    
        r4 = p000.x91.f28480b;
        r5 = java.util.logging.Level.SEVERE;
        r6 = java.lang.String.valueOf(r10.f28102a);
        r3 = java.lang.String.valueOf(r3);
        r8 = new java.lang.StringBuilder((r6.length() + 37) + r3.length());
        r8.append("Exception while executing callback: ");
        r8.append(r6);
        r8.append(" ");
        r8.append(r3);
        r4.log(r5, r8.toString(), (java.lang.Throwable) r2);
     */
    /* JADX WARN: Removed duplicated region for block: B:35:0x006f  */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void run() {
        boolean z;
        Throwable th;
        while (true) {
            boolean z2 = true;
            try {
                synchronized (this) {
                    try {
                        Preconditions.checkState(this.f28106e);
                        v91 v91Var = (v91) this.f28104c.poll();
                        Object poll = this.f28105d.poll();
                        if (v91Var == null) {
                            this.f28106e = false;
                            try {
                                return;
                            } catch (Throwable th2) {
                                th = th2;
                                z = false;
                                while (true) {
                                    try {
                                        break;
                                    } catch (Throwable th3) {
                                        th = th3;
                                    }
                                }
                                throw th;
                            }
                        }
                    } catch (Throwable th4) {
                        z = true;
                        th = th4;
                    }
                }
                try {
                    break;
                    throw th;
                } catch (Throwable th5) {
                    boolean z3 = z;
                    th = th5;
                    z2 = z3;
                    if (z2) {
                        synchronized (this) {
                            this.f28106e = false;
                        }
                    }
                    throw th;
                }
            } catch (Throwable th6) {
                th = th6;
                if (z2) {
                }
                throw th;
            }
        }
    }
}
