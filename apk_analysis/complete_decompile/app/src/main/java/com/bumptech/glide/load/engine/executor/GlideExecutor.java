package com.bumptech.glide.load.engine.executor;

import android.text.TextUtils;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public final class GlideExecutor implements ExecutorService {

    /* renamed from: b */
    public static final long f8749b = TimeUnit.SECONDS.toMillis(10);

    /* renamed from: c */
    public static volatile int f8750c;

    /* renamed from: a */
    public final ThreadPoolExecutor f8751a;

    /* loaded from: classes.dex */
    public static final class Builder {
        public static final long NO_THREAD_TIMEOUT = 0;

        /* renamed from: a */
        public final boolean f8752a;

        /* renamed from: b */
        public int f8753b;

        /* renamed from: c */
        public int f8754c;

        /* renamed from: d */
        public UncaughtThrowableStrategy f8755d = UncaughtThrowableStrategy.DEFAULT;

        /* renamed from: e */
        public String f8756e;

        /* renamed from: f */
        public long f8757f;

        public Builder(boolean z) {
            this.f8752a = z;
        }

        public GlideExecutor build() {
            if (!TextUtils.isEmpty(this.f8756e)) {
                ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(this.f8753b, this.f8754c, this.f8757f, TimeUnit.MILLISECONDS, new PriorityBlockingQueue(), new ThreadFactoryC0613b(this.f8756e, this.f8755d, this.f8752a));
                if (this.f8757f != 0) {
                    threadPoolExecutor.allowCoreThreadTimeOut(true);
                }
                return new GlideExecutor(threadPoolExecutor);
            }
            throw new IllegalArgumentException("Name must be non-null and non-empty, but given: " + this.f8756e);
        }

        public Builder setName(String str) {
            this.f8756e = str;
            return this;
        }

        public Builder setThreadCount(@IntRange(from = 1) int i) {
            this.f8753b = i;
            this.f8754c = i;
            return this;
        }

        public Builder setThreadTimeoutMillis(long j) {
            this.f8757f = j;
            return this;
        }

        public Builder setUncaughtThrowableStrategy(@NonNull UncaughtThrowableStrategy uncaughtThrowableStrategy) {
            this.f8755d = uncaughtThrowableStrategy;
            return this;
        }
    }

    /* loaded from: classes.dex */
    public interface UncaughtThrowableStrategy {
        public static final UncaughtThrowableStrategy DEFAULT;
        public static final UncaughtThrowableStrategy IGNORE = new Object();
        public static final UncaughtThrowableStrategy LOG;
        public static final UncaughtThrowableStrategy THROW;

        /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Object, com.bumptech.glide.load.engine.executor.GlideExecutor$UncaughtThrowableStrategy] */
        /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.Object, com.bumptech.glide.load.engine.executor.GlideExecutor$UncaughtThrowableStrategy] */
        /* JADX WARN: Type inference failed for: r1v0, types: [java.lang.Object, com.bumptech.glide.load.engine.executor.GlideExecutor$UncaughtThrowableStrategy] */
        static {
            ?? obj = new Object();
            LOG = obj;
            THROW = new Object();
            DEFAULT = obj;
        }

        void handle(Throwable th);
    }

    public GlideExecutor(ThreadPoolExecutor threadPoolExecutor) {
        this.f8751a = threadPoolExecutor;
    }

    public static int calculateBestThreadCount() {
        if (f8750c == 0) {
            f8750c = Math.min(4, Runtime.getRuntime().availableProcessors());
        }
        return f8750c;
    }

    public static Builder newAnimationBuilder() {
        int i;
        if (calculateBestThreadCount() >= 4) {
            i = 2;
        } else {
            i = 1;
        }
        return new Builder(true).setThreadCount(i).setName("animation");
    }

    public static GlideExecutor newAnimationExecutor() {
        return newAnimationBuilder().build();
    }

    public static Builder newDiskCacheBuilder() {
        return new Builder(true).setThreadCount(1).setName("disk-cache");
    }

    public static GlideExecutor newDiskCacheExecutor() {
        return newDiskCacheBuilder().build();
    }

    public static Builder newSourceBuilder() {
        return new Builder(false).setThreadCount(calculateBestThreadCount()).setName(FirebaseAnalytics.Param.SOURCE);
    }

    public static GlideExecutor newSourceExecutor() {
        return newSourceBuilder().build();
    }

    public static GlideExecutor newUnlimitedSourceExecutor() {
        return new GlideExecutor(new ThreadPoolExecutor(0, Integer.MAX_VALUE, f8749b, TimeUnit.MILLISECONDS, new SynchronousQueue(), new ThreadFactoryC0613b("source-unlimited", UncaughtThrowableStrategy.DEFAULT, false)));
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean awaitTermination(long j, @NonNull TimeUnit timeUnit) {
        return this.f8751a.awaitTermination(j, timeUnit);
    }

    @Override // java.util.concurrent.Executor
    public void execute(@NonNull Runnable runnable) {
        this.f8751a.execute(runnable);
    }

    @Override // java.util.concurrent.ExecutorService
    @NonNull
    public <T> List<Future<T>> invokeAll(@NonNull Collection<? extends Callable<T>> collection) {
        return this.f8751a.invokeAll(collection);
    }

    @Override // java.util.concurrent.ExecutorService
    @NonNull
    public <T> T invokeAny(@NonNull Collection<? extends Callable<T>> collection) {
        return (T) this.f8751a.invokeAny(collection);
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isShutdown() {
        return this.f8751a.isShutdown();
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isTerminated() {
        return this.f8751a.isTerminated();
    }

    @Override // java.util.concurrent.ExecutorService
    public void shutdown() {
        this.f8751a.shutdown();
    }

    @Override // java.util.concurrent.ExecutorService
    @NonNull
    public List<Runnable> shutdownNow() {
        return this.f8751a.shutdownNow();
    }

    @Override // java.util.concurrent.ExecutorService
    @NonNull
    public Future<?> submit(@NonNull Runnable runnable) {
        return this.f8751a.submit(runnable);
    }

    public String toString() {
        return this.f8751a.toString();
    }

    @Deprecated
    public static GlideExecutor newAnimationExecutor(int i, UncaughtThrowableStrategy uncaughtThrowableStrategy) {
        return newAnimationBuilder().setThreadCount(i).setUncaughtThrowableStrategy(uncaughtThrowableStrategy).build();
    }

    @Deprecated
    public static GlideExecutor newDiskCacheExecutor(UncaughtThrowableStrategy uncaughtThrowableStrategy) {
        return newDiskCacheBuilder().setUncaughtThrowableStrategy(uncaughtThrowableStrategy).build();
    }

    @Deprecated
    public static GlideExecutor newSourceExecutor(UncaughtThrowableStrategy uncaughtThrowableStrategy) {
        return newSourceBuilder().setUncaughtThrowableStrategy(uncaughtThrowableStrategy).build();
    }

    @Override // java.util.concurrent.ExecutorService
    @NonNull
    public <T> List<Future<T>> invokeAll(@NonNull Collection<? extends Callable<T>> collection, long j, @NonNull TimeUnit timeUnit) {
        return this.f8751a.invokeAll(collection, j, timeUnit);
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> T invokeAny(@NonNull Collection<? extends Callable<T>> collection, long j, @NonNull TimeUnit timeUnit) {
        return (T) this.f8751a.invokeAny(collection, j, timeUnit);
    }

    @Override // java.util.concurrent.ExecutorService
    @NonNull
    public <T> Future<T> submit(@NonNull Runnable runnable, T t) {
        return this.f8751a.submit(runnable, t);
    }

    @Deprecated
    public static GlideExecutor newDiskCacheExecutor(int i, String str, UncaughtThrowableStrategy uncaughtThrowableStrategy) {
        return newDiskCacheBuilder().setThreadCount(i).setName(str).setUncaughtThrowableStrategy(uncaughtThrowableStrategy).build();
    }

    @Deprecated
    public static GlideExecutor newSourceExecutor(int i, String str, UncaughtThrowableStrategy uncaughtThrowableStrategy) {
        return newSourceBuilder().setThreadCount(i).setName(str).setUncaughtThrowableStrategy(uncaughtThrowableStrategy).build();
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> Future<T> submit(@NonNull Callable<T> callable) {
        return this.f8751a.submit(callable);
    }
}
