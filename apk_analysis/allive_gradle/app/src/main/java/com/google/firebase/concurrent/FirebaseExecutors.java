package com.google.firebase.concurrent;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import p000.c42;
import p000.d42;
import p000.d81;
import p000.e42;
import p000.fe0;
import p000.g81;
import p000.rg2;
import p000.z10;

/* loaded from: classes2.dex */
public class FirebaseExecutors {
    public static Executor directExecutor() {
        return fe0.f17233a;
    }

    public static Executor newLimitedConcurrencyExecutor(Executor executor, int i) {
        return new d81(executor, i);
    }

    public static ExecutorService newLimitedConcurrencyExecutorService(ExecutorService executorService, int i) {
        return new g81(executorService, i);
    }

    public static ScheduledExecutorService newLimitedConcurrencyScheduledExecutorService(ExecutorService executorService, int i) {
        return new z10(newLimitedConcurrencyExecutorService(executorService, i), (ScheduledExecutorService) ExecutorsRegistrar.f15552d.get());
    }

    public static PausableExecutor newPausableExecutor(Executor executor) {
        return new c42(executor);
    }

    public static PausableExecutorService newPausableExecutorService(ExecutorService executorService) {
        return new d42(executorService);
    }

    public static PausableScheduledExecutorService newPausableScheduledExecutorService(ScheduledExecutorService scheduledExecutorService) {
        return new e42(newPausableExecutorService(scheduledExecutorService), (ScheduledExecutorService) ExecutorsRegistrar.f15552d.get());
    }

    public static Executor newSequentialExecutor(Executor executor) {
        return new rg2(executor);
    }
}
