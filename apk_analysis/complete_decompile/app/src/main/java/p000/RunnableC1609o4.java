package p000;

import android.os.Process;

/* renamed from: o4 */
/* loaded from: classes.dex */
public final class RunnableC1609o4 implements Runnable {

    /* renamed from: a */
    public final /* synthetic */ int f23595a;

    /* renamed from: b */
    public final Runnable f23596b;

    public /* synthetic */ RunnableC1609o4(int i, Runnable runnable) {
        this.f23595a = i;
        this.f23596b = runnable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f23595a) {
            case 0:
                Process.setThreadPriority(10);
                this.f23596b.run();
                return;
            case 1:
                this.f23596b.run();
                return;
            case 2:
                this.f23596b.run();
                return;
            default:
                Process.setThreadPriority(0);
                this.f23596b.run();
                return;
        }
    }

    public String toString() {
        switch (this.f23595a) {
            case 1:
                return this.f23596b.toString();
            case 2:
                return this.f23596b.toString();
            default:
                return super.toString();
        }
    }
}
