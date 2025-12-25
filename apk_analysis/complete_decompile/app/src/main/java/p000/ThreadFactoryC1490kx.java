package p000;

import android.os.StrictMode;
import java.util.Locale;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;

/* renamed from: kx */
/* loaded from: classes2.dex */
public final class ThreadFactoryC1490kx implements ThreadFactory {

    /* renamed from: e */
    public static final ThreadFactory f22234e = Executors.defaultThreadFactory();

    /* renamed from: a */
    public final AtomicLong f22235a = new AtomicLong();

    /* renamed from: b */
    public final String f22236b;

    /* renamed from: c */
    public final int f22237c;

    /* renamed from: d */
    public final StrictMode.ThreadPolicy f22238d;

    public ThreadFactoryC1490kx(String str, int i, StrictMode.ThreadPolicy threadPolicy) {
        this.f22236b = str;
        this.f22237c = i;
        this.f22238d = threadPolicy;
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        Thread newThread = f22234e.newThread(new RunnableC0583c7(8, this, runnable));
        Locale locale = Locale.ROOT;
        newThread.setName(this.f22236b + " Thread #" + this.f22235a.getAndIncrement());
        return newThread;
    }
}
