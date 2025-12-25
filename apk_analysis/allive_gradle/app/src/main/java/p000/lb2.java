package p000;

import android.os.Process;

/* loaded from: classes.dex */
public final class lb2 extends Thread {

    /* renamed from: a */
    public final int f22436a;

    public lb2(Runnable runnable) {
        super(runnable, "fonts-androidx");
        this.f22436a = 10;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        Process.setThreadPriority(this.f22436a);
        super.run();
    }
}
