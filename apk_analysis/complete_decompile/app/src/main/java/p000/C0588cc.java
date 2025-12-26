package p000;

import android.os.Process;
import okio.AsyncTimeout;

/* renamed from: cc */
/* loaded from: classes2.dex */
public final class C0588cc extends Thread {

    /* renamed from: a */
    public final /* synthetic */ int f8323a = 0;

    public /* synthetic */ C0588cc(String str) {
        super(str);
    }

    /* renamed from: a */
    private final void m2217a() {
        AsyncTimeout awaitTimeout$okio;
        while (true) {
            try {
                synchronized (AsyncTimeout.class) {
                    try {
                        awaitTimeout$okio = AsyncTimeout.INSTANCE.awaitTimeout$okio();
                        if (awaitTimeout$okio == AsyncTimeout.access$getHead$cp()) {
                            AsyncTimeout.access$setHead$cp(null);
                            return;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                if (awaitTimeout$okio != null) {
                    awaitTimeout$okio.timedOut();
                }
            } catch (InterruptedException unused) {
                continue;
            }
        }
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        switch (this.f8323a) {
            case 0:
                m2217a();
                return;
            default:
                Process.setThreadPriority(19);
                synchronized (this) {
                    while (true) {
                        try {
                            wait();
                        } catch (InterruptedException unused) {
                            return;
                        }
                    }
                }
        }
    }

    public /* synthetic */ C0588cc(ThreadGroup threadGroup, String str) {
        super(threadGroup, str);
    }
}
