package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.base.Stopwatch;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import p000.s82;
import p000.vk2;
import p000.wk2;

@Beta
@GwtIncompatible
/* loaded from: classes2.dex */
public abstract class RateLimiter {

    /* renamed from: a */
    public final s82 f15332a;

    /* renamed from: b */
    public volatile Object f15333b;

    public RateLimiter(s82 s82Var) {
        this.f15332a = (s82) Preconditions.checkNotNull(s82Var);
    }

    public static RateLimiter create(double d, long j, TimeUnit timeUnit) {
        Preconditions.checkArgument(j >= 0, "warmupPeriod must not be negative: %s", j);
        wk2 wk2Var = new wk2(new s82(), j, timeUnit);
        wk2Var.setRate(d);
        return wk2Var;
    }

    /* renamed from: a */
    public abstract double mo4338a();

    @CanIgnoreReturnValue
    public double acquire() {
        return acquire(1);
    }

    /* renamed from: b */
    public abstract void mo4339b(long j, double d);

    /* renamed from: c */
    public final Object m4340c() {
        Object obj = this.f15333b;
        if (obj == null) {
            synchronized (this) {
                try {
                    obj = this.f15333b;
                    if (obj == null) {
                        obj = new Object();
                        this.f15333b = obj;
                    }
                } finally {
                }
            }
        }
        return obj;
    }

    /* renamed from: d */
    public abstract long mo4341d();

    /* renamed from: e */
    public abstract long mo4342e(int i, long j);

    public final double getRate() {
        double mo4338a;
        synchronized (m4340c()) {
            mo4338a = mo4338a();
        }
        return mo4338a;
    }

    public final void setRate(double d) {
        boolean z;
        if (d > 0.0d && !Double.isNaN(d)) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkArgument(z, "rate must be positive");
        synchronized (m4340c()) {
            mo4339b(this.f15332a.f26314a.elapsed(TimeUnit.MICROSECONDS), d);
        }
    }

    public String toString() {
        return String.format(Locale.ROOT, "RateLimiter[stableRate=%3.1fqps]", Double.valueOf(getRate()));
    }

    public boolean tryAcquire(long j, TimeUnit timeUnit) {
        return tryAcquire(1, j, timeUnit);
    }

    @CanIgnoreReturnValue
    public double acquire(int i) {
        TimeUnit timeUnit;
        long max;
        Preconditions.checkArgument(i > 0, "Requested permits (%s) must be positive", i);
        synchronized (m4340c()) {
            Stopwatch stopwatch = this.f15332a.f26314a;
            timeUnit = TimeUnit.MICROSECONDS;
            long elapsed = stopwatch.elapsed(timeUnit);
            max = Math.max(mo4342e(i, elapsed) - elapsed, 0L);
        }
        this.f15332a.getClass();
        if (max > 0) {
            Uninterruptibles.sleepUninterruptibly(max, timeUnit);
        }
        return (max * 1.0d) / TimeUnit.SECONDS.toMicros(1L);
    }

    public boolean tryAcquire(int i) {
        return tryAcquire(i, 0L, TimeUnit.MICROSECONDS);
    }

    public boolean tryAcquire() {
        return tryAcquire(1, 0L, TimeUnit.MICROSECONDS);
    }

    public boolean tryAcquire(int i, long j, TimeUnit timeUnit) {
        long max = Math.max(timeUnit.toMicros(j), 0L);
        Preconditions.checkArgument(i > 0, "Requested permits (%s) must be positive", i);
        synchronized (m4340c()) {
            Stopwatch stopwatch = this.f15332a.f26314a;
            TimeUnit timeUnit2 = TimeUnit.MICROSECONDS;
            long elapsed = stopwatch.elapsed(timeUnit2);
            if (mo4341d() - max > elapsed) {
                return false;
            }
            long max2 = Math.max(mo4342e(i, elapsed) - elapsed, 0L);
            this.f15332a.getClass();
            if (max2 > 0) {
                Uninterruptibles.sleepUninterruptibly(max2, timeUnit2);
            }
            return true;
        }
    }

    public static RateLimiter create(double d) {
        vk2 vk2Var = new vk2(new s82());
        vk2Var.setRate(d);
        return vk2Var;
    }
}
