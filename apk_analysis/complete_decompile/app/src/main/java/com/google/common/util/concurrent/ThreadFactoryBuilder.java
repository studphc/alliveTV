package com.google.common.util.concurrent;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.CheckReturnValue;
import java.lang.Thread;
import java.util.Locale;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;
import p000.gt2;

@CanIgnoreReturnValue
@GwtIncompatible
/* loaded from: classes2.dex */
public final class ThreadFactoryBuilder {

    /* renamed from: a */
    public String f15342a = null;

    /* renamed from: b */
    public Boolean f15343b = null;

    /* renamed from: c */
    public Integer f15344c = null;

    /* renamed from: d */
    public Thread.UncaughtExceptionHandler f15345d = null;

    /* renamed from: e */
    public ThreadFactory f15346e = null;

    @CheckReturnValue
    public ThreadFactory build() {
        AtomicLong atomicLong;
        String str = this.f15342a;
        Boolean bool = this.f15343b;
        Integer num = this.f15344c;
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.f15345d;
        ThreadFactory threadFactory = this.f15346e;
        if (threadFactory == null) {
            threadFactory = Executors.defaultThreadFactory();
        }
        ThreadFactory threadFactory2 = threadFactory;
        if (str != null) {
            atomicLong = new AtomicLong(0L);
        } else {
            atomicLong = null;
        }
        return new gt2(threadFactory2, str, atomicLong, bool, num, uncaughtExceptionHandler);
    }

    public ThreadFactoryBuilder setDaemon(boolean z) {
        this.f15343b = Boolean.valueOf(z);
        return this;
    }

    public ThreadFactoryBuilder setNameFormat(String str) {
        String.format(Locale.ROOT, str, 0);
        this.f15342a = str;
        return this;
    }

    public ThreadFactoryBuilder setPriority(int i) {
        boolean z;
        boolean z2 = false;
        if (i >= 1) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkArgument(z, "Thread priority (%s) must be >= %s", i, 1);
        if (i <= 10) {
            z2 = true;
        }
        Preconditions.checkArgument(z2, "Thread priority (%s) must be <= %s", i, 10);
        this.f15344c = Integer.valueOf(i);
        return this;
    }

    public ThreadFactoryBuilder setThreadFactory(ThreadFactory threadFactory) {
        this.f15346e = (ThreadFactory) Preconditions.checkNotNull(threadFactory);
        return this;
    }

    public ThreadFactoryBuilder setUncaughtExceptionHandler(Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        this.f15345d = (Thread.UncaughtExceptionHandler) Preconditions.checkNotNull(uncaughtExceptionHandler);
        return this;
    }
}
