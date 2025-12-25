package com.google.android.exoplayer2.util;

import com.google.android.exoplayer2.C0643C;

/* loaded from: classes.dex */
public final class TimestampAdjuster {
    public static final long MODE_NO_OFFSET = Long.MAX_VALUE;
    public static final long MODE_SHARED = 9223372036854775806L;

    /* renamed from: a */
    public long f12771a;

    /* renamed from: b */
    public long f12772b;

    /* renamed from: c */
    public long f12773c;

    /* renamed from: d */
    public final ThreadLocal f12774d = new ThreadLocal();

    public TimestampAdjuster(long j) {
        reset(j);
    }

    public static long ptsToUs(long j) {
        return (j * 1000000) / 90000;
    }

    public static long usToNonWrappedPts(long j) {
        return (j * 90000) / 1000000;
    }

    public static long usToWrappedPts(long j) {
        return usToNonWrappedPts(j) % 8589934592L;
    }

    public synchronized long adjustSampleTimestamp(long j) {
        if (j == C0643C.TIME_UNSET) {
            return C0643C.TIME_UNSET;
        }
        try {
            if (this.f12772b == C0643C.TIME_UNSET) {
                long j2 = this.f12771a;
                if (j2 == MODE_SHARED) {
                    j2 = ((Long) Assertions.checkNotNull((Long) this.f12774d.get())).longValue();
                }
                this.f12772b = j2 - j;
                notifyAll();
            }
            this.f12773c = j;
            return j + this.f12772b;
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized long adjustTsTimestamp(long j) {
        if (j == C0643C.TIME_UNSET) {
            return C0643C.TIME_UNSET;
        }
        try {
            long j2 = this.f12773c;
            if (j2 != C0643C.TIME_UNSET) {
                long usToNonWrappedPts = usToNonWrappedPts(j2);
                long j3 = (4294967296L + usToNonWrappedPts) / 8589934592L;
                long j4 = ((j3 - 1) * 8589934592L) + j;
                long j5 = (j3 * 8589934592L) + j;
                if (Math.abs(j4 - usToNonWrappedPts) < Math.abs(j5 - usToNonWrappedPts)) {
                    j = j4;
                } else {
                    j = j5;
                }
            }
            return adjustSampleTimestamp(ptsToUs(j));
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized long getFirstSampleTimestampUs() {
        long j;
        j = this.f12771a;
        if (j == Long.MAX_VALUE || j == MODE_SHARED) {
            j = C0643C.TIME_UNSET;
        }
        return j;
    }

    public synchronized long getLastAdjustedTimestampUs() {
        long firstSampleTimestampUs;
        try {
            long j = this.f12773c;
            if (j != C0643C.TIME_UNSET) {
                firstSampleTimestampUs = j + this.f12772b;
            } else {
                firstSampleTimestampUs = getFirstSampleTimestampUs();
            }
        } catch (Throwable th) {
            throw th;
        }
        return firstSampleTimestampUs;
    }

    public synchronized long getTimestampOffsetUs() {
        return this.f12772b;
    }

    public synchronized void reset(long j) {
        long j2;
        this.f12771a = j;
        if (j == Long.MAX_VALUE) {
            j2 = 0;
        } else {
            j2 = -9223372036854775807L;
        }
        this.f12772b = j2;
        this.f12773c = C0643C.TIME_UNSET;
    }

    public synchronized void sharedInitializeOrWait(boolean z, long j) {
        boolean z2;
        try {
            if (this.f12771a == MODE_SHARED) {
                z2 = true;
            } else {
                z2 = false;
            }
            Assertions.checkState(z2);
            if (this.f12772b != C0643C.TIME_UNSET) {
                return;
            }
            if (z) {
                this.f12774d.set(Long.valueOf(j));
            } else {
                while (this.f12772b == C0643C.TIME_UNSET) {
                    wait();
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }
}
