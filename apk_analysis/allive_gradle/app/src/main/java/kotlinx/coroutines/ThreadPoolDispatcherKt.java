package kotlinx.coroutines;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import p000.ye0;

@Metadata(m5568d1 = {}, m5569d2 = {}, m5570k = 4, m5571mv = {1, 8, 0}, m5573xi = 48)
/* loaded from: classes2.dex */
public final class ThreadPoolDispatcherKt {
    @DelicateCoroutinesApi
    @NotNull
    public static final ExecutorCoroutineDispatcher newFixedThreadPoolContext(final int i, @NotNull final String str) {
        if (i >= 1) {
            final AtomicInteger atomicInteger = new AtomicInteger();
            return ExecutorsKt.from((ExecutorService) Executors.newScheduledThreadPool(i, new ThreadFactory() { // from class: ht2
                @Override // java.util.concurrent.ThreadFactory
                public final Thread newThread(Runnable runnable) {
                    int i2 = i;
                    String str2 = str;
                    if (i2 != 1) {
                        str2 = str2 + '-' + atomicInteger.incrementAndGet();
                    }
                    Thread thread = new Thread(runnable, str2);
                    thread.setDaemon(true);
                    return thread;
                }
            }));
        }
        throw new IllegalArgumentException(ye0.m8292l(i, "Expected at least one thread, but ", " specified").toString());
    }

    @DelicateCoroutinesApi
    @ExperimentalCoroutinesApi
    @NotNull
    public static final ExecutorCoroutineDispatcher newSingleThreadContext(@NotNull String str) {
        return newFixedThreadPoolContext(1, str);
    }
}
