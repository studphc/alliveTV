package kotlin.internal;

import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.SinceKotlin;
import kotlin.UInt;
import kotlin.ULong;

@Metadata(m5568d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0003\u001a*\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0003H\u0001ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u001a*\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0001\u001a\u00020\b2\u0006\u0010\u0002\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\tH\u0001ø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000b\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\f"}, m5569d2 = {"Lkotlin/UInt;", "start", "end", "", "step", "getProgressionLastElement-Nkh28Cs", "(III)I", "getProgressionLastElement", "Lkotlin/ULong;", "", "getProgressionLastElement-7ftBX0g", "(JJJ)J", "kotlin-stdlib"}, m5570k = 2, m5571mv = {1, 8, 0}, m5573xi = 48)
/* loaded from: classes2.dex */
public final class UProgressionUtilKt {
    /* renamed from: a */
    public static final int m5610a(int i, int i2, int i3) {
        long j = i3 & 4294967295L;
        int i4 = (int) ((i & 4294967295L) % j);
        int i5 = (int) ((i2 & 4294967295L) % j);
        int compare = Integer.compare(i4 ^ Integer.MIN_VALUE, Integer.MIN_VALUE ^ i5);
        int m8546constructorimpl = UInt.m8546constructorimpl(i4 - i5);
        if (compare < 0) {
            return UInt.m8546constructorimpl(m8546constructorimpl + i3);
        }
        return m8546constructorimpl;
    }

    /* renamed from: b */
    public static final long m5611b(long j, long j2, long j3) {
        long j4;
        long j5 = 0;
        if (j3 < 0) {
            if ((j ^ Long.MIN_VALUE) >= (j3 ^ Long.MIN_VALUE)) {
                j -= j3;
            }
        } else if (j >= 0) {
            j %= j3;
        } else {
            long j6 = j - ((((j >>> 1) / j3) << 1) * j3);
            if ((j6 ^ Long.MIN_VALUE) >= (j3 ^ Long.MIN_VALUE)) {
                j4 = j3;
            } else {
                j4 = 0;
            }
            j = j6 - j4;
        }
        if (j3 < 0) {
            if ((j2 ^ Long.MIN_VALUE) >= (j3 ^ Long.MIN_VALUE)) {
                j2 -= j3;
            }
        } else if (j2 >= 0) {
            j2 %= j3;
        } else {
            long j7 = j2 - ((((j2 >>> 1) / j3) << 1) * j3);
            if ((j7 ^ Long.MIN_VALUE) >= (j3 ^ Long.MIN_VALUE)) {
                j5 = j3;
            }
            j2 = j7 - j5;
        }
        int compare = Long.compare(j ^ Long.MIN_VALUE, j2 ^ Long.MIN_VALUE);
        long m8570constructorimpl = ULong.m8570constructorimpl(j - j2);
        if (compare < 0) {
            return ULong.m8570constructorimpl(m8570constructorimpl + j3);
        }
        return m8570constructorimpl;
    }

    @SinceKotlin(version = "1.3")
    @PublishedApi
    /* renamed from: getProgressionLastElement-7ftBX0g, reason: not valid java name */
    public static final long m8677getProgressionLastElement7ftBX0g(long j, long j2, long j3) {
        if (j3 > 0) {
            if (Long.compare(j ^ Long.MIN_VALUE, j2 ^ Long.MIN_VALUE) < 0) {
                return ULong.m8570constructorimpl(j2 - m5611b(j2, j, ULong.m8570constructorimpl(j3)));
            }
            return j2;
        }
        if (j3 < 0) {
            if (Long.compare(j ^ Long.MIN_VALUE, j2 ^ Long.MIN_VALUE) > 0) {
                return ULong.m8570constructorimpl(j2 + m5611b(j, j2, ULong.m8570constructorimpl(-j3)));
            }
            return j2;
        }
        throw new IllegalArgumentException("Step is zero.");
    }

    @SinceKotlin(version = "1.3")
    @PublishedApi
    /* renamed from: getProgressionLastElement-Nkh28Cs, reason: not valid java name */
    public static final int m8678getProgressionLastElementNkh28Cs(int i, int i2, int i3) {
        if (i3 > 0) {
            if (Integer.compare(i ^ Integer.MIN_VALUE, Integer.MIN_VALUE ^ i2) < 0) {
                return UInt.m8546constructorimpl(i2 - m5610a(i2, i, UInt.m8546constructorimpl(i3)));
            }
            return i2;
        }
        if (i3 < 0) {
            if (Integer.compare(i ^ Integer.MIN_VALUE, Integer.MIN_VALUE ^ i2) > 0) {
                return UInt.m8546constructorimpl(m5610a(i, i2, UInt.m8546constructorimpl(-i3)) + i2);
            }
            return i2;
        }
        throw new IllegalArgumentException("Step is zero.");
    }
}
