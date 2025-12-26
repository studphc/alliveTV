package p000;

import com.google.common.base.Preconditions;
import com.google.common.math.LongMath;
import com.google.common.primitives.Ints;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicLongArray;

/* renamed from: ih */
/* loaded from: classes2.dex */
public final class C1306ih {

    /* renamed from: a */
    public final AtomicLongArray f18407a;

    /* renamed from: b */
    public final sd1 f18408b;

    public C1306ih(long j) {
        Preconditions.checkArgument(j > 0, "data length is zero!");
        this.f18407a = new AtomicLongArray(Ints.checkedCast(LongMath.divide(j, 64L, RoundingMode.CEILING)));
        this.f18408b = (sd1) xd1.f28513a.get();
    }

    /* renamed from: e */
    public static long[] m5240e(AtomicLongArray atomicLongArray) {
        int length = atomicLongArray.length();
        long[] jArr = new long[length];
        for (int i = 0; i < length; i++) {
            jArr[i] = atomicLongArray.get(i);
        }
        return jArr;
    }

    /* renamed from: a */
    public final long m5241a() {
        return this.f18407a.length() * 64;
    }

    /* renamed from: b */
    public final boolean m5242b(long j) {
        if (((1 << ((int) j)) & this.f18407a.get((int) (j >>> 6))) != 0) {
            return true;
        }
        return false;
    }

    /* renamed from: c */
    public final void m5243c(int i, long j) {
        long j2;
        long j3;
        do {
            j2 = this.f18407a.get(i);
            j3 = j2 | j;
            if (j2 == j3) {
                return;
            }
        } while (!this.f18407a.compareAndSet(i, j2, j3));
        this.f18408b.mo7362c(Long.bitCount(j3) - Long.bitCount(j2));
    }

    /* renamed from: d */
    public final boolean m5244d(long j) {
        AtomicLongArray atomicLongArray;
        long j2;
        long j3;
        if (m5242b(j)) {
            return false;
        }
        int i = (int) (j >>> 6);
        long j4 = 1 << ((int) j);
        do {
            atomicLongArray = this.f18407a;
            j2 = atomicLongArray.get(i);
            j3 = j2 | j4;
            if (j2 == j3) {
                return false;
            }
        } while (!atomicLongArray.compareAndSet(i, j2, j3));
        this.f18408b.mo7360a();
        return true;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof C1306ih) {
            return Arrays.equals(m5240e(this.f18407a), m5240e(((C1306ih) obj).f18407a));
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(m5240e(this.f18407a));
    }

    public C1306ih(long[] jArr) {
        Preconditions.checkArgument(jArr.length > 0, "data length is zero!");
        this.f18407a = new AtomicLongArray(jArr);
        this.f18408b = (sd1) xd1.f28513a.get();
        long j = 0;
        for (long j2 : jArr) {
            j += Long.bitCount(j2);
        }
        this.f18408b.mo7362c(j);
    }
}
