package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.base.Throwables;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import p000.e40;
import p000.os0;
import p000.sg2;
import p000.uo1;
import p000.wo1;
import p000.xo1;
import p000.yy2;
import p000.zo1;

@GwtCompatible(emulated = true)
/* loaded from: classes2.dex */
public final class MoreExecutors {
    /* renamed from: a */
    public static Thread m4336a(String str, Runnable runnable) {
        Preconditions.checkNotNull(str);
        Preconditions.checkNotNull(runnable);
        Thread newThread = platformThreadFactory().newThread(runnable);
        try {
            newThread.setName(str);
        } catch (SecurityException unused) {
        }
        return newThread;
    }

    @Beta
    @GwtIncompatible
    public static void addDelayedShutdownHook(ExecutorService executorService, long j, TimeUnit timeUnit) {
        yy2.m8360f(executorService, j, timeUnit);
    }

    /* renamed from: b */
    public static Executor m4337b(Executor executor, os0 os0Var) {
        Preconditions.checkNotNull(executor);
        Preconditions.checkNotNull(os0Var);
        if (executor == directExecutor()) {
            return executor;
        }
        return new uo1(executor, os0Var);
    }

    public static Executor directExecutor() {
        return e40.f16668a;
    }

    @Beta
    @GwtIncompatible
    public static ExecutorService getExitingExecutorService(ThreadPoolExecutor threadPoolExecutor) {
        TimeUnit timeUnit = TimeUnit.SECONDS;
        threadPoolExecutor.setThreadFactory(new ThreadFactoryBuilder().setDaemon(true).setThreadFactory(threadPoolExecutor.getThreadFactory()).build());
        ExecutorService unconfigurableExecutorService = Executors.unconfigurableExecutorService(threadPoolExecutor);
        yy2.m8360f(threadPoolExecutor, 120L, timeUnit);
        return unconfigurableExecutorService;
    }

    @Beta
    @GwtIncompatible
    public static ScheduledExecutorService getExitingScheduledExecutorService(ScheduledThreadPoolExecutor scheduledThreadPoolExecutor) {
        TimeUnit timeUnit = TimeUnit.SECONDS;
        scheduledThreadPoolExecutor.setThreadFactory(new ThreadFactoryBuilder().setDaemon(true).setThreadFactory(scheduledThreadPoolExecutor.getThreadFactory()).build());
        ScheduledExecutorService unconfigurableScheduledExecutorService = Executors.unconfigurableScheduledExecutorService(scheduledThreadPoolExecutor);
        yy2.m8360f(scheduledThreadPoolExecutor, 120L, timeUnit);
        return unconfigurableScheduledExecutorService;
    }

    @GwtIncompatible
    public static ListeningExecutorService listeningDecorator(ExecutorService executorService) {
        ListeningExecutorService xo1Var;
        if (executorService instanceof ListeningExecutorService) {
            return (ListeningExecutorService) executorService;
        }
        if (executorService instanceof ScheduledExecutorService) {
            xo1Var = new zo1((ScheduledExecutorService) executorService);
        } else {
            xo1Var = new xo1(executorService);
        }
        return xo1Var;
    }

    @GwtIncompatible
    public static ListeningExecutorService newDirectExecutorService() {
        return new wo1();
    }

    @GwtIncompatible
    public static Executor newSequentialExecutor(Executor executor) {
        return new sg2(executor);
    }

    @Beta
    @GwtIncompatible
    public static ThreadFactory platformThreadFactory() {
        if (System.getProperty("com.google.appengine.runtime.environment") != null) {
            try {
                Class.forName("com.google.appengine.api.utils.SystemProperty");
                if (Class.forName("com.google.apphosting.api.ApiProxy").getMethod("getCurrentEnvironment", null).invoke(null, null) != null) {
                    try {
                        return (ThreadFactory) Class.forName("com.google.appengine.api.ThreadManager").getMethod("currentRequestThreadFactory", null).invoke(null, null);
                    } catch (ClassNotFoundException e) {
                        throw new RuntimeException("Couldn't invoke ThreadManager.currentRequestThreadFactory", e);
                    } catch (IllegalAccessException e2) {
                        throw new RuntimeException("Couldn't invoke ThreadManager.currentRequestThreadFactory", e2);
                    } catch (NoSuchMethodException e3) {
                        throw new RuntimeException("Couldn't invoke ThreadManager.currentRequestThreadFactory", e3);
                    } catch (InvocationTargetException e4) {
                        throw Throwables.propagate(e4.getCause());
                    }
                }
            } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
            }
        }
        return Executors.defaultThreadFactory();
    }

    @CanIgnoreReturnValue
    @Beta
    @GwtIncompatible
    public static boolean shutdownAndAwaitTermination(ExecutorService executorService, long j, TimeUnit timeUnit) {
        long nanos = timeUnit.toNanos(j) / 2;
        executorService.shutdown();
        try {
            TimeUnit timeUnit2 = TimeUnit.NANOSECONDS;
            if (!executorService.awaitTermination(nanos, timeUnit2)) {
                executorService.shutdownNow();
                executorService.awaitTermination(nanos, timeUnit2);
            }
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            executorService.shutdownNow();
        }
        return executorService.isTerminated();
    }

    @GwtIncompatible
    public static ListeningScheduledExecutorService listeningDecorator(ScheduledExecutorService scheduledExecutorService) {
        if (scheduledExecutorService instanceof ListeningScheduledExecutorService) {
            return (ListeningScheduledExecutorService) scheduledExecutorService;
        }
        return new zo1(scheduledExecutorService);
    }

    @Beta
    @GwtIncompatible
    public static ExecutorService getExitingExecutorService(ThreadPoolExecutor threadPoolExecutor, long j, TimeUnit timeUnit) {
        threadPoolExecutor.setThreadFactory(new ThreadFactoryBuilder().setDaemon(true).setThreadFactory(threadPoolExecutor.getThreadFactory()).build());
        ExecutorService unconfigurableExecutorService = Executors.unconfigurableExecutorService(threadPoolExecutor);
        yy2.m8360f(threadPoolExecutor, j, timeUnit);
        return unconfigurableExecutorService;
    }

    @Beta
    @GwtIncompatible
    public static ScheduledExecutorService getExitingScheduledExecutorService(ScheduledThreadPoolExecutor scheduledThreadPoolExecutor, long j, TimeUnit timeUnit) {
        scheduledThreadPoolExecutor.setThreadFactory(new ThreadFactoryBuilder().setDaemon(true).setThreadFactory(scheduledThreadPoolExecutor.getThreadFactory()).build());
        ScheduledExecutorService unconfigurableScheduledExecutorService = Executors.unconfigurableScheduledExecutorService(scheduledThreadPoolExecutor);
        yy2.m8360f(scheduledThreadPoolExecutor, j, timeUnit);
        return unconfigurableScheduledExecutorService;
    }
}
