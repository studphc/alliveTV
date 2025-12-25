package com.bumptech.glide.util;

import androidx.annotation.VisibleForTesting;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
import p000.d40;

/* loaded from: classes.dex */
public final class Executors {

    /* renamed from: a */
    public static final d40 f9168a = new d40(2);

    /* renamed from: b */
    public static final d40 f9169b = new d40(3);

    public static Executor directExecutor() {
        return f9169b;
    }

    public static Executor mainThreadExecutor() {
        return f9168a;
    }

    @VisibleForTesting
    public static void shutdownAndAwaitTermination(ExecutorService executorService) {
        executorService.shutdownNow();
        try {
            TimeUnit timeUnit = TimeUnit.SECONDS;
            if (!executorService.awaitTermination(5L, timeUnit)) {
                executorService.shutdownNow();
                if (!executorService.awaitTermination(5L, timeUnit)) {
                    throw new RuntimeException("Failed to shutdown");
                }
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }
}
