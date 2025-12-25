package io.reactivex.rxjava3.internal.schedulers;

import io.reactivex.rxjava3.exceptions.Exceptions;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;

/* loaded from: classes2.dex */
public final class SchedulerPoolFactory {
    public static final boolean PURGE_ENABLED;

    static {
        boolean z = true;
        try {
            String property = System.getProperty("rx3.purge-enabled");
            if (property != null) {
                z = "true".equals(property);
            }
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
        }
        PURGE_ENABLED = z;
    }

    public static ScheduledExecutorService create(ThreadFactory threadFactory) {
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(1, threadFactory);
        scheduledThreadPoolExecutor.setRemoveOnCancelPolicy(PURGE_ENABLED);
        return scheduledThreadPoolExecutor;
    }
}
