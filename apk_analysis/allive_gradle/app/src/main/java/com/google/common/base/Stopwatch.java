package com.google.common.base;

import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import p000.AbstractC1726qj;
import p000.dx0;
import p000.t42;
import p000.vn2;

@GwtCompatible(emulated = true)
/* loaded from: classes.dex */
public final class Stopwatch {

    /* renamed from: a */
    public final Ticker f14496a;

    /* renamed from: b */
    public boolean f14497b;

    /* renamed from: c */
    public long f14498c;

    /* renamed from: d */
    public long f14499d;

    public Stopwatch() {
        this.f14496a = Ticker.systemTicker();
    }

    public static Stopwatch createStarted() {
        return new Stopwatch().start();
    }

    public static Stopwatch createUnstarted() {
        return new Stopwatch();
    }

    public long elapsed(TimeUnit timeUnit) {
        long j;
        if (this.f14497b) {
            j = (this.f14496a.read() - this.f14499d) + this.f14498c;
        } else {
            j = this.f14498c;
        }
        return timeUnit.convert(j, TimeUnit.NANOSECONDS);
    }

    public boolean isRunning() {
        return this.f14497b;
    }

    @CanIgnoreReturnValue
    public Stopwatch reset() {
        this.f14498c = 0L;
        this.f14497b = false;
        return this;
    }

    @CanIgnoreReturnValue
    public Stopwatch start() {
        Preconditions.checkState(!this.f14497b, "This stopwatch is already running.");
        this.f14497b = true;
        this.f14499d = this.f14496a.read();
        return this;
    }

    @CanIgnoreReturnValue
    public Stopwatch stop() {
        long read = this.f14496a.read();
        Preconditions.checkState(this.f14497b, "This stopwatch is already stopped.");
        this.f14497b = false;
        this.f14498c = (read - this.f14499d) + this.f14498c;
        return this;
    }

    public String toString() {
        long j;
        String str;
        if (this.f14497b) {
            j = (this.f14496a.read() - this.f14499d) + this.f14498c;
        } else {
            j = this.f14498c;
        }
        TimeUnit timeUnit = TimeUnit.DAYS;
        TimeUnit timeUnit2 = TimeUnit.NANOSECONDS;
        if (timeUnit.convert(j, timeUnit2) <= 0) {
            timeUnit = TimeUnit.HOURS;
            if (timeUnit.convert(j, timeUnit2) <= 0) {
                timeUnit = TimeUnit.MINUTES;
                if (timeUnit.convert(j, timeUnit2) <= 0) {
                    timeUnit = TimeUnit.SECONDS;
                    if (timeUnit.convert(j, timeUnit2) <= 0) {
                        timeUnit = TimeUnit.MILLISECONDS;
                        if (timeUnit.convert(j, timeUnit2) <= 0) {
                            timeUnit = TimeUnit.MICROSECONDS;
                            if (timeUnit.convert(j, timeUnit2) <= 0) {
                                timeUnit = timeUnit2;
                            }
                        }
                    }
                }
            }
        }
        double convert = j / timeUnit2.convert(1L, timeUnit);
        dx0 dx0Var = t42.f26692a;
        String format = String.format(Locale.ROOT, "%.4g", Double.valueOf(convert));
        switch (vn2.f27894a[timeUnit.ordinal()]) {
            case 1:
                str = "ns";
                break;
            case 2:
                str = "μs";
                break;
            case 3:
                str = "ms";
                break;
            case 4:
                str = "s";
                break;
            case 5:
                str = "min";
                break;
            case 6:
                str = "h";
                break;
            case 7:
                str = "d";
                break;
            default:
                throw new AssertionError();
        }
        return AbstractC1726qj.m7059o(format, " ", str, str.length() + format.length() + 1);
    }

    public static Stopwatch createStarted(Ticker ticker) {
        return new Stopwatch(ticker).start();
    }

    public static Stopwatch createUnstarted(Ticker ticker) {
        return new Stopwatch(ticker);
    }

    public Stopwatch(Ticker ticker) {
        this.f14496a = (Ticker) Preconditions.checkNotNull(ticker, "ticker");
    }
}
