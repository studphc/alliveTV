package p000;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes.dex */
public final class j10 implements ThreadFactory {

    /* renamed from: a */
    public final /* synthetic */ int f20338a;

    /* renamed from: b */
    public final AtomicInteger f20339b;

    public j10(int i) {
        this.f20338a = i;
        switch (i) {
            case 1:
                this.f20339b = new AtomicInteger(1);
                return;
            case 2:
                this.f20339b = new AtomicInteger(1);
                return;
            default:
                this.f20339b = new AtomicInteger(0);
                return;
        }
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        AtomicInteger atomicInteger = this.f20339b;
        switch (this.f20338a) {
            case 0:
                Thread thread = new Thread(runnable);
                thread.setName("arch_disk_io_" + atomicInteger.getAndIncrement());
                return thread;
            case 1:
                return new Thread(runnable, String.format("firebase-installations-executor-%d", Integer.valueOf(atomicInteger.getAndIncrement())));
            default:
                return new Thread(runnable, "ModernAsyncTask #" + atomicInteger.getAndIncrement());
        }
    }
}
