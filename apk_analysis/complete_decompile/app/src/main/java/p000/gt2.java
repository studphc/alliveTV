package p000;

import java.lang.Thread;
import java.util.Locale;
import java.util.Objects;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: classes2.dex */
public final class gt2 implements ThreadFactory {

    /* renamed from: a */
    public final /* synthetic */ ThreadFactory f17833a;

    /* renamed from: b */
    public final /* synthetic */ String f17834b;

    /* renamed from: c */
    public final /* synthetic */ AtomicLong f17835c;

    /* renamed from: d */
    public final /* synthetic */ Boolean f17836d;

    /* renamed from: e */
    public final /* synthetic */ Integer f17837e;

    /* renamed from: f */
    public final /* synthetic */ Thread.UncaughtExceptionHandler f17838f;

    public gt2(ThreadFactory threadFactory, String str, AtomicLong atomicLong, Boolean bool, Integer num, Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        this.f17833a = threadFactory;
        this.f17834b = str;
        this.f17835c = atomicLong;
        this.f17836d = bool;
        this.f17837e = num;
        this.f17838f = uncaughtExceptionHandler;
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        Thread newThread = this.f17833a.newThread(runnable);
        String str = this.f17834b;
        if (str != null) {
            AtomicLong atomicLong = this.f17835c;
            Objects.requireNonNull(atomicLong);
            newThread.setName(String.format(Locale.ROOT, str, Long.valueOf(atomicLong.getAndIncrement())));
        }
        Boolean bool = this.f17836d;
        if (bool != null) {
            newThread.setDaemon(bool.booleanValue());
        }
        Integer num = this.f17837e;
        if (num != null) {
            newThread.setPriority(num.intValue());
        }
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.f17838f;
        if (uncaughtExceptionHandler != null) {
            newThread.setUncaughtExceptionHandler(uncaughtExceptionHandler);
        }
        return newThread;
    }
}
