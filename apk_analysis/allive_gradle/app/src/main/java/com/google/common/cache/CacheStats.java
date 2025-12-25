package com.google.common.cache;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.math.LongMath;
import javax.annotation.CheckForNull;

@GwtCompatible
/* loaded from: classes.dex */
public final class CacheStats {

    /* renamed from: a */
    public final long f14559a;

    /* renamed from: b */
    public final long f14560b;

    /* renamed from: c */
    public final long f14561c;

    /* renamed from: d */
    public final long f14562d;

    /* renamed from: e */
    public final long f14563e;

    /* renamed from: f */
    public final long f14564f;

    public CacheStats(long j, long j2, long j3, long j4, long j5, long j6) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        if (j >= 0) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkArgument(z);
        if (j2 >= 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        Preconditions.checkArgument(z2);
        if (j3 >= 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        Preconditions.checkArgument(z3);
        if (j4 >= 0) {
            z4 = true;
        } else {
            z4 = false;
        }
        Preconditions.checkArgument(z4);
        if (j5 >= 0) {
            z5 = true;
        } else {
            z5 = false;
        }
        Preconditions.checkArgument(z5);
        Preconditions.checkArgument(j6 >= 0);
        this.f14559a = j;
        this.f14560b = j2;
        this.f14561c = j3;
        this.f14562d = j4;
        this.f14563e = j5;
        this.f14564f = j6;
    }

    public double averageLoadPenalty() {
        long saturatedAdd = LongMath.saturatedAdd(this.f14561c, this.f14562d);
        if (saturatedAdd == 0) {
            return 0.0d;
        }
        return this.f14563e / saturatedAdd;
    }

    public boolean equals(@CheckForNull Object obj) {
        if (!(obj instanceof CacheStats)) {
            return false;
        }
        CacheStats cacheStats = (CacheStats) obj;
        if (this.f14559a != cacheStats.f14559a || this.f14560b != cacheStats.f14560b || this.f14561c != cacheStats.f14561c || this.f14562d != cacheStats.f14562d || this.f14563e != cacheStats.f14563e || this.f14564f != cacheStats.f14564f) {
            return false;
        }
        return true;
    }

    public long evictionCount() {
        return this.f14564f;
    }

    public int hashCode() {
        return Objects.hashCode(Long.valueOf(this.f14559a), Long.valueOf(this.f14560b), Long.valueOf(this.f14561c), Long.valueOf(this.f14562d), Long.valueOf(this.f14563e), Long.valueOf(this.f14564f));
    }

    public long hitCount() {
        return this.f14559a;
    }

    public double hitRate() {
        long requestCount = requestCount();
        if (requestCount == 0) {
            return 1.0d;
        }
        return this.f14559a / requestCount;
    }

    public long loadCount() {
        return LongMath.saturatedAdd(this.f14561c, this.f14562d);
    }

    public long loadExceptionCount() {
        return this.f14562d;
    }

    public double loadExceptionRate() {
        long j = this.f14561c;
        long j2 = this.f14562d;
        long saturatedAdd = LongMath.saturatedAdd(j, j2);
        if (saturatedAdd == 0) {
            return 0.0d;
        }
        return j2 / saturatedAdd;
    }

    public long loadSuccessCount() {
        return this.f14561c;
    }

    public CacheStats minus(CacheStats cacheStats) {
        return new CacheStats(Math.max(0L, LongMath.saturatedSubtract(this.f14559a, cacheStats.f14559a)), Math.max(0L, LongMath.saturatedSubtract(this.f14560b, cacheStats.f14560b)), Math.max(0L, LongMath.saturatedSubtract(this.f14561c, cacheStats.f14561c)), Math.max(0L, LongMath.saturatedSubtract(this.f14562d, cacheStats.f14562d)), Math.max(0L, LongMath.saturatedSubtract(this.f14563e, cacheStats.f14563e)), Math.max(0L, LongMath.saturatedSubtract(this.f14564f, cacheStats.f14564f)));
    }

    public long missCount() {
        return this.f14560b;
    }

    public double missRate() {
        long requestCount = requestCount();
        if (requestCount == 0) {
            return 0.0d;
        }
        return this.f14560b / requestCount;
    }

    public CacheStats plus(CacheStats cacheStats) {
        return new CacheStats(LongMath.saturatedAdd(this.f14559a, cacheStats.f14559a), LongMath.saturatedAdd(this.f14560b, cacheStats.f14560b), LongMath.saturatedAdd(this.f14561c, cacheStats.f14561c), LongMath.saturatedAdd(this.f14562d, cacheStats.f14562d), LongMath.saturatedAdd(this.f14563e, cacheStats.f14563e), LongMath.saturatedAdd(this.f14564f, cacheStats.f14564f));
    }

    public long requestCount() {
        return LongMath.saturatedAdd(this.f14559a, this.f14560b);
    }

    public String toString() {
        return MoreObjects.toStringHelper(this).add("hitCount", this.f14559a).add("missCount", this.f14560b).add("loadSuccessCount", this.f14561c).add("loadExceptionCount", this.f14562d).add("totalLoadTime", this.f14563e).add("evictionCount", this.f14564f).toString();
    }

    public long totalLoadTime() {
        return this.f14563e;
    }
}
