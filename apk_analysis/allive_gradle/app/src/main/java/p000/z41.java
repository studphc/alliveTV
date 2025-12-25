package p000;

import java.util.concurrent.locks.AbstractOwnableSynchronizer;

/* loaded from: classes2.dex */
public final class z41 extends AbstractOwnableSynchronizer implements Runnable {

    /* renamed from: a */
    public final a51 f29244a;

    public z41(a51 a51Var) {
        this.f29244a = a51Var;
    }

    /* renamed from: a */
    public static void m8391a(z41 z41Var, Thread thread) {
        z41Var.setExclusiveOwnerThread(thread);
    }

    public final String toString() {
        return this.f29244a.toString();
    }

    @Override // java.lang.Runnable
    public final void run() {
    }
}
