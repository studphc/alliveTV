package com.google.common.math;

import com.google.android.exoplayer2.C0643C;
import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Ascii;
import com.google.common.base.Preconditions;
import com.google.common.primitives.Longs;
import com.google.common.primitives.UnsignedLongs;
import java.math.RoundingMode;
import okhttp3.internal.connection.RealConnection;
import okhttp3.internal.http.HttpStatusCodesKt;
import p000.be1;
import p000.o63;
import p000.p63;
import p000.ye0;

@GwtCompatible(emulated = true)
/* loaded from: classes2.dex */
public final class LongMath {

    /* renamed from: a */
    public static final byte[] f15126a = {19, Ascii.DC2, Ascii.DC2, Ascii.DC2, Ascii.DC2, 17, 17, 17, Ascii.DLE, Ascii.DLE, Ascii.DLE, Ascii.f14464SI, Ascii.f14464SI, Ascii.f14464SI, Ascii.f14464SI, Ascii.f14465SO, Ascii.f14465SO, Ascii.f14465SO, Ascii.f14455CR, Ascii.f14455CR, Ascii.f14455CR, Ascii.f14457FF, Ascii.f14457FF, Ascii.f14457FF, Ascii.f14457FF, Ascii.f14468VT, Ascii.f14468VT, Ascii.f14468VT, 10, 10, 10, 9, 9, 9, 9, 8, 8, 8, 7, 7, 7, 6, 6, 6, 6, 5, 5, 5, 4, 4, 4, 3, 3, 3, 3, 2, 2, 2, 1, 1, 1, 0, 0, 0};

    /* renamed from: b */
    public static final long[] f15127b = {1, 10, 100, 1000, 10000, 100000, 1000000, 10000000, 100000000, C0643C.NANOS_PER_SECOND, RealConnection.IDLE_CONNECTION_HEALTHY_NS, 100000000000L, 1000000000000L, 10000000000000L, 100000000000000L, 1000000000000000L, 10000000000000000L, 100000000000000000L, 1000000000000000000L};

    /* renamed from: c */
    public static final long[] f15128c = {3, 31, 316, 3162, 31622, 316227, 3162277, 31622776, 316227766, 3162277660L, 31622776601L, 316227766016L, 3162277660168L, 31622776601683L, 316227766016837L, 3162277660168379L, 31622776601683793L, 316227766016837933L, 3162277660168379331L};

    /* renamed from: d */
    public static final long[] f15129d = {1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880, 3628800, 39916800, 479001600, 6227020800L, 87178291200L, 1307674368000L, 20922789888000L, 355687428096000L, 6402373705728000L, 121645100408832000L, 2432902008176640000L};

    /* renamed from: e */
    public static final int[] f15130e = {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, 3810779, 121977, 16175, 4337, 1733, 887, 534, 361, 265, HttpStatusCodesKt.HTTP_PARTIAL_CONTENT, 169, 143, 125, 111, 101, 94, 88, 83, 79, 76, 74, 72, 70, 69, 68, 67, 67, 66, 66, 66, 66};

    /* renamed from: f */
    public static final int[] f15131f = {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, 2642246, 86251, 11724, 3218, 1313, 684, HttpStatusCodesKt.HTTP_INSUFFICIENT_SPACE_ON_RESOURCE, 287, 214, 169, 139, 119, 105, 95, 87, 81, 76, 73, 70, 68, 66, 64, 63, 62, 62, 61, 61, 61};

    /* renamed from: g */
    public static final long[][] f15132g = {new long[]{291830, 126401071349994536L}, new long[]{885594168, 725270293939359937L, 3569819667048198375L}, new long[]{273919523040L, 15, 7363882082L, 992620450144556L}, new long[]{47636622961200L, 2, 2570940, 211991001, 3749873356L}, new long[]{7999252175582850L, 2, 4130806001517L, 149795463772692060L, 186635894390467037L, 3967304179347715805L}, new long[]{585226005592931976L, 2, 123635709730000L, 9233062284813009L, 43835965440333360L, 761179012939631437L, 1263739024124850375L}, new long[]{Long.MAX_VALUE, 2, 325, 9375, 28178, 450775, 9780504, 1795265022}};

    public static long binomial(int i, int i2) {
        boolean z;
        long j;
        p63.m6867k(i, "n");
        p63.m6867k(i2, "k");
        if (i2 <= i) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkArgument(z, "k (%s) > n (%s)", i2, i);
        if (i2 > (i >> 1)) {
            i2 = i - i2;
        }
        if (i2 == 0) {
            return 1L;
        }
        if (i2 != 1) {
            if (i < 21) {
                long[] jArr = f15129d;
                return jArr[i] / (jArr[i2] * jArr[i - i2]);
            }
            if (i2 < 34 && i <= f15130e[i2]) {
                int i3 = 2;
                if (i2 < 31 && i <= f15131f[i2]) {
                    int i4 = i - 1;
                    long j2 = i;
                    while (i3 <= i2) {
                        j2 = (j2 * i4) / i3;
                        i4--;
                        i3++;
                    }
                    return j2;
                }
                long j3 = i;
                int log2 = log2(j3, RoundingMode.CEILING);
                int i5 = i - 1;
                int i6 = log2;
                long j4 = 1;
                long j5 = 1;
                while (i3 <= i2) {
                    i6 += log2;
                    if (i6 < 63) {
                        j3 *= i5;
                        j5 *= i3;
                    } else {
                        if (j4 == 1) {
                            j = j3 / j5;
                        } else {
                            long gcd = gcd(j4, j5);
                            j = (j3 / (j5 / gcd)) * (j4 / gcd);
                        }
                        j4 = j;
                        j3 = i5;
                        j5 = i3;
                        i6 = log2;
                    }
                    i3++;
                    i5--;
                }
                if (j4 == 1) {
                    return j3 / j5;
                }
                long gcd2 = gcd(j4, j5);
                return (j3 / (j5 / gcd2)) * (j4 / gcd2);
            }
            return Long.MAX_VALUE;
        }
        return i;
    }

    @Beta
    public static long ceilingPowerOfTwo(long j) {
        p63.m6874r(j);
        if (j <= Longs.MAX_POWER_OF_TWO) {
            return 1 << (-Long.numberOfLeadingZeros(j - 1));
        }
        StringBuilder sb = new StringBuilder(70);
        sb.append("ceilingPowerOfTwo(");
        sb.append(j);
        sb.append(") is not representable as a long");
        throw new ArithmeticException(sb.toString());
    }

    @GwtIncompatible
    public static long checkedAdd(long j, long j2) {
        boolean z;
        long j3 = j + j2;
        boolean z2 = false;
        if ((j ^ j2) < 0) {
            z = true;
        } else {
            z = false;
        }
        if ((j ^ j3) >= 0) {
            z2 = true;
        }
        p63.m6866j(z | z2, "checkedAdd", j, j2);
        return j3;
    }

    public static long checkedMultiply(long j, long j2) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        int numberOfLeadingZeros = Long.numberOfLeadingZeros(~j2) + Long.numberOfLeadingZeros(j2) + Long.numberOfLeadingZeros(~j) + Long.numberOfLeadingZeros(j);
        if (numberOfLeadingZeros > 65) {
            return j * j2;
        }
        if (numberOfLeadingZeros >= 64) {
            z = true;
        } else {
            z = false;
        }
        p63.m6866j(z, "checkedMultiply", j, j2);
        if (j >= 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (j2 != Long.MIN_VALUE) {
            z3 = true;
        } else {
            z3 = false;
        }
        p63.m6866j(z2 | z3, "checkedMultiply", j, j2);
        long j3 = j * j2;
        if (j != 0 && j3 / j != j2) {
            z4 = false;
        } else {
            z4 = true;
        }
        p63.m6866j(z4, "checkedMultiply", j, j2);
        return j3;
    }

    @GwtIncompatible
    public static long checkedPow(long j, int i) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        p63.m6867k(i, "exponent");
        if (j >= -2) {
            z = true;
        } else {
            z = false;
        }
        if (j <= 2) {
            z2 = true;
        } else {
            z2 = false;
        }
        long j2 = 1;
        if (z & z2) {
            int i2 = (int) j;
            if (i2 != -2) {
                if (i2 != -1) {
                    if (i2 != 0) {
                        if (i2 == 1) {
                            return 1L;
                        }
                        if (i2 == 2) {
                            if (i < 63) {
                                z5 = true;
                            } else {
                                z5 = false;
                            }
                            p63.m6866j(z5, "checkedPow", j, i);
                            return 1 << i;
                        }
                        throw new AssertionError();
                    }
                    if (i == 0) {
                        return 1L;
                    }
                    return 0L;
                }
                if ((i & 1) == 0) {
                    return 1L;
                }
                return -1L;
            }
            if (i < 64) {
                z4 = true;
            } else {
                z4 = false;
            }
            p63.m6866j(z4, "checkedPow", j, i);
            if ((i & 1) == 0) {
                return 1 << i;
            }
            return (-1) << i;
        }
        long j3 = j;
        int i3 = i;
        while (i3 != 0) {
            if (i3 != 1) {
                if ((i3 & 1) != 0) {
                    j2 = checkedMultiply(j2, j3);
                }
                long j4 = j2;
                int i4 = i3 >> 1;
                if (i4 > 0) {
                    if (-3037000499L <= j3 && j3 <= 3037000499L) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    p63.m6866j(z3, "checkedPow", j3, i4);
                    j3 *= j3;
                }
                i3 = i4;
                j2 = j4;
            } else {
                return checkedMultiply(j2, j3);
            }
        }
        return j2;
    }

    @GwtIncompatible
    public static long checkedSubtract(long j, long j2) {
        boolean z;
        long j3 = j - j2;
        boolean z2 = false;
        if ((j ^ j2) >= 0) {
            z = true;
        } else {
            z = false;
        }
        if ((j ^ j3) >= 0) {
            z2 = true;
        }
        p63.m6866j(z | z2, "checkedSubtract", j, j2);
        return j3;
    }

    @GwtIncompatible
    public static long divide(long j, long j2, RoundingMode roundingMode) {
        Preconditions.checkNotNull(roundingMode);
        long j3 = j / j2;
        long j4 = j - (j2 * j3);
        if (j4 == 0) {
            return j3;
        }
        boolean z = true;
        int i = ((int) ((j ^ j2) >> 63)) | 1;
        switch (be1.f7979a[roundingMode.ordinal()]) {
            case 1:
                if (j4 != 0) {
                    z = false;
                }
                p63.m6877u(z);
                return j3;
            case 2:
                return j3;
            case 3:
                if (i >= 0) {
                    return j3;
                }
                break;
            case 4:
                break;
            case 5:
                if (i <= 0) {
                    return j3;
                }
                break;
            case 6:
            case 7:
            case 8:
                long abs = Math.abs(j4);
                long abs2 = abs - (Math.abs(j2) - abs);
                if (abs2 == 0) {
                    if (roundingMode != RoundingMode.HALF_UP && (roundingMode != RoundingMode.HALF_EVEN || (1 & j3) == 0)) {
                        return j3;
                    }
                } else if (abs2 <= 0) {
                    return j3;
                }
                break;
            default:
                throw new AssertionError();
        }
        return j3 + i;
    }

    @GwtIncompatible
    public static long factorial(int i) {
        p63.m6867k(i, "n");
        if (i < 21) {
            return f15129d[i];
        }
        return Long.MAX_VALUE;
    }

    @Beta
    public static long floorPowerOfTwo(long j) {
        p63.m6874r(j);
        return 1 << (63 - Long.numberOfLeadingZeros(j));
    }

    public static long gcd(long j, long j2) {
        p63.m6868l(j, "a");
        p63.m6868l(j2, "b");
        if (j == 0) {
            return j2;
        }
        if (j2 == 0) {
            return j;
        }
        int numberOfTrailingZeros = Long.numberOfTrailingZeros(j);
        long j3 = j >> numberOfTrailingZeros;
        int numberOfTrailingZeros2 = Long.numberOfTrailingZeros(j2);
        long j4 = j2 >> numberOfTrailingZeros2;
        while (j3 != j4) {
            long j5 = j3 - j4;
            long j6 = (j5 >> 63) & j5;
            long j7 = (j5 - j6) - j6;
            j4 += j6;
            j3 = j7 >> Long.numberOfTrailingZeros(j7);
        }
        return j3 << Math.min(numberOfTrailingZeros, numberOfTrailingZeros2);
    }

    public static boolean isPowerOfTwo(long j) {
        return (j > 0) & ((j & (j - 1)) == 0);
    }

    @Beta
    @GwtIncompatible
    public static boolean isPrime(long j) {
        int i;
        int i2;
        char c = 0;
        if (j < 2) {
            p63.m6868l(j, "n");
            return false;
        }
        int i3 = 2;
        long j2 = 0;
        if (j < 66) {
            if (((722865708377213483 >> (((int) j) - 2)) & 1) == 0) {
                return false;
            }
            return true;
        }
        if (((1 << ((int) (j % 30))) & (-545925251)) != 0) {
            return false;
        }
        if (j % 7 == 0 || j % 11 == 0 || j % 13 == 0) {
            return false;
        }
        if (j < 289) {
            return true;
        }
        long[][] jArr = f15132g;
        int i4 = 0;
        while (i4 < 7) {
            long[] jArr2 = jArr[i4];
            if (j <= jArr2[c]) {
                int i5 = 1;
                while (i5 < jArr2.length) {
                    long j3 = jArr2[i5];
                    if (j <= 3037000499L) {
                        i = 1;
                    } else {
                        i = i3;
                    }
                    long j4 = j - 1;
                    int numberOfTrailingZeros = Long.numberOfTrailingZeros(j4);
                    long j5 = j4 >> numberOfTrailingZeros;
                    long j6 = j3 % j;
                    if (j6 != j2) {
                        long j7 = 1;
                        while (j5 != j2) {
                            if ((j5 & 1) != j2) {
                                if (i != 1) {
                                    long j8 = j7 >>> 32;
                                    long j9 = j6 >>> 32;
                                    long j10 = j7 & 4294967295L;
                                    long j11 = j6 & 4294967295L;
                                    i2 = numberOfTrailingZeros;
                                    long m8284d = (j8 * j11) + ye0.m8284d(j8 * j9, j);
                                    if (m8284d < 0) {
                                        m8284d = UnsignedLongs.remainder(m8284d, j);
                                    }
                                    Long.signum(j10);
                                    long m8284d2 = ye0.m8284d((j9 * j10) + m8284d, j);
                                    long remainder = UnsignedLongs.remainder(j10 * j11, j);
                                    long j12 = m8284d2 + remainder;
                                    if (m8284d2 >= j - remainder) {
                                        j12 -= j;
                                    }
                                    j7 = j12;
                                } else {
                                    i2 = numberOfTrailingZeros;
                                    j7 = (j7 * j6) % j;
                                }
                            } else {
                                i2 = numberOfTrailingZeros;
                            }
                            j6 = ye0.m8282b(i, j6, j);
                            j5 >>= 1;
                            numberOfTrailingZeros = i2;
                            j2 = 0;
                        }
                        int i6 = numberOfTrailingZeros;
                        if (j7 == 1) {
                            continue;
                        } else {
                            long j13 = j7;
                            int i7 = 0;
                            while (j13 != j4) {
                                i7++;
                                int i8 = i6;
                                if (i7 == i8) {
                                    return false;
                                }
                                j13 = ye0.m8282b(i, j13, j);
                                i6 = i8;
                            }
                        }
                    }
                    i5++;
                    i3 = 2;
                    j2 = 0;
                }
                return true;
            }
            i4++;
            c = 0;
            i3 = 2;
            j2 = 0;
        }
        throw new AssertionError();
    }

    @GwtIncompatible
    public static int log10(long j, RoundingMode roundingMode) {
        boolean z;
        p63.m6874r(j);
        byte b = f15126a[Long.numberOfLeadingZeros(j)];
        long[] jArr = f15127b;
        int i = b - ((int) ((~(~(j - jArr[b]))) >>> 63));
        long j2 = jArr[i];
        switch (be1.f7979a[roundingMode.ordinal()]) {
            case 1:
                if (j == j2) {
                    z = true;
                } else {
                    z = false;
                }
                p63.m6877u(z);
            case 2:
            case 3:
                return i;
            case 4:
            case 5:
                return ((int) ((~(~(j2 - j))) >>> 63)) + i;
            case 6:
            case 7:
            case 8:
                return ((int) ((~(~(f15128c[i] - j))) >>> 63)) + i;
            default:
                throw new AssertionError();
        }
    }

    public static int log2(long j, RoundingMode roundingMode) {
        p63.m6874r(j);
        switch (be1.f7979a[roundingMode.ordinal()]) {
            case 1:
                p63.m6877u(isPowerOfTwo(j));
                break;
            case 2:
            case 3:
                break;
            case 4:
            case 5:
                return 64 - Long.numberOfLeadingZeros(j - 1);
            case 6:
            case 7:
            case 8:
                int numberOfLeadingZeros = Long.numberOfLeadingZeros(j);
                return ((int) ((~(~(((-5402926248376769404) >>> numberOfLeadingZeros) - j))) >>> 63)) + (63 - numberOfLeadingZeros);
            default:
                throw new AssertionError("impossible");
        }
        return 63 - Long.numberOfLeadingZeros(j);
    }

    public static long mean(long j, long j2) {
        return (j & j2) + ((j ^ j2) >> 1);
    }

    @GwtIncompatible
    public static int mod(long j, int i) {
        return (int) mod(j, i);
    }

    @GwtIncompatible
    public static long pow(long j, int i) {
        long j2;
        p63.m6867k(i, "exponent");
        if (-2 <= j && j <= 2) {
            int i2 = (int) j;
            if (i2 != -2) {
                if (i2 != -1) {
                    if (i2 != 0) {
                        if (i2 == 1) {
                            return 1L;
                        }
                        if (i2 == 2) {
                            if (i >= 64) {
                                return 0L;
                            }
                            return 1 << i;
                        }
                        throw new AssertionError();
                    }
                    if (i == 0) {
                        return 1L;
                    }
                    return 0L;
                }
                if ((i & 1) == 0) {
                    return 1L;
                }
                return -1L;
            }
            if (i >= 64) {
                return 0L;
            }
            if ((i & 1) == 0) {
                return 1 << i;
            }
            return -(1 << i);
        }
        long j3 = 1;
        while (i != 0) {
            if (i != 1) {
                if ((i & 1) == 0) {
                    j2 = 1;
                } else {
                    j2 = j;
                }
                j3 *= j2;
                j *= j;
                i >>= 1;
            } else {
                return j3 * j;
            }
        }
        return j3;
    }

    @GwtIncompatible
    public static double roundToDouble(long j, RoundingMode roundingMode) {
        int compare;
        boolean z;
        double d;
        long j2;
        double d2 = j;
        long j3 = (long) d2;
        if (j3 == Long.MAX_VALUE) {
            compare = -1;
        } else {
            compare = Longs.compare(j, j3);
        }
        int[] iArr = be1.f7979a;
        switch (iArr[roundingMode.ordinal()]) {
            case 1:
                if (compare == 0) {
                    z = true;
                } else {
                    z = false;
                }
                p63.m6877u(z);
                return d2;
            case 2:
                if (j >= 0) {
                    if (compare < 0) {
                        return -Math.nextUp(-d2);
                    }
                    return d2;
                }
                if (compare > 0) {
                    return Math.nextUp(d2);
                }
                return d2;
            case 3:
                if (compare < 0) {
                    return -Math.nextUp(-d2);
                }
                return d2;
            case 4:
                if (j >= 0) {
                    if (compare > 0) {
                        return Math.nextUp(d2);
                    }
                    return d2;
                }
                if (compare < 0) {
                    return -Math.nextUp(-d2);
                }
                return d2;
            case 5:
                if (compare > 0) {
                    return Math.nextUp(d2);
                }
                return d2;
            case 6:
            case 7:
            case 8:
                if (compare >= 0) {
                    d = Math.nextUp(d2);
                    j2 = (long) Math.ceil(d);
                } else {
                    double d3 = -Math.nextUp(-d2);
                    j3 = (long) Math.floor(d3);
                    d = d2;
                    d2 = d3;
                    j2 = j3;
                }
                long j4 = j - j3;
                long j5 = j2 - j;
                if (j2 == Long.MAX_VALUE) {
                    j5++;
                }
                int compare2 = Longs.compare(j4, j5);
                if (compare2 < 0) {
                    return d2;
                }
                if (compare2 > 0) {
                    return d;
                }
                int i = iArr[roundingMode.ordinal()];
                if (i != 6) {
                    if (i != 7) {
                        if (i == 8) {
                            if ((o63.m6472p(d2) & 1) != 0) {
                                return d;
                            }
                            return d2;
                        }
                        throw new AssertionError("impossible");
                    }
                    if (j >= 0) {
                        return d;
                    }
                    return d2;
                }
                if (j < 0) {
                    return d;
                }
                return d2;
            default:
                throw new AssertionError("impossible");
        }
    }

    @Beta
    public static long saturatedAdd(long j, long j2) {
        long j3 = j + j2;
        return (((j2 ^ j) > 0L ? 1 : ((j2 ^ j) == 0L ? 0 : -1)) < 0) | ((j ^ j3) >= 0) ? j3 : ((j3 >>> 63) ^ 1) + Long.MAX_VALUE;
    }

    @Beta
    public static long saturatedMultiply(long j, long j2) {
        boolean z;
        boolean z2;
        int numberOfLeadingZeros = Long.numberOfLeadingZeros(~j2) + Long.numberOfLeadingZeros(j2) + Long.numberOfLeadingZeros(~j) + Long.numberOfLeadingZeros(j);
        if (numberOfLeadingZeros > 65) {
            return j * j2;
        }
        long j3 = ((j ^ j2) >>> 63) + Long.MAX_VALUE;
        boolean z3 = false;
        if (numberOfLeadingZeros < 64) {
            z = true;
        } else {
            z = false;
        }
        if (j < 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (j2 == Long.MIN_VALUE) {
            z3 = true;
        }
        if (z | (z3 & z2)) {
            return j3;
        }
        long j4 = j * j2;
        if (j != 0 && j4 / j != j2) {
            return j3;
        }
        return j4;
    }

    @Beta
    public static long saturatedPow(long j, int i) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        p63.m6867k(i, "exponent");
        if (j >= -2) {
            z = true;
        } else {
            z = false;
        }
        if (j <= 2) {
            z2 = true;
        } else {
            z2 = false;
        }
        long j2 = 1;
        if (z & z2) {
            int i2 = (int) j;
            if (i2 != -2) {
                if (i2 != -1) {
                    if (i2 != 0) {
                        if (i2 == 1) {
                            return 1L;
                        }
                        if (i2 == 2) {
                            if (i >= 63) {
                                return Long.MAX_VALUE;
                            }
                            return 1 << i;
                        }
                        throw new AssertionError();
                    }
                    if (i == 0) {
                        return 1L;
                    }
                    return 0L;
                }
                if ((i & 1) == 0) {
                    return 1L;
                }
                return -1L;
            }
            if (i >= 64) {
                return (i & 1) + Long.MAX_VALUE;
            }
            if ((i & 1) == 0) {
                return 1 << i;
            }
            return (-1) << i;
        }
        long j3 = ((j >>> 63) & i & 1) + Long.MAX_VALUE;
        while (i != 0) {
            if (i != 1) {
                if ((i & 1) != 0) {
                    j2 = saturatedMultiply(j2, j);
                }
                i >>= 1;
                if (i > 0) {
                    if (-3037000499L > j) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    if (j > 3037000499L) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    if (z3 | z4) {
                        return j3;
                    }
                    j *= j;
                }
            } else {
                return saturatedMultiply(j2, j);
            }
        }
        return j2;
    }

    @Beta
    public static long saturatedSubtract(long j, long j2) {
        long j3 = j - j2;
        return (((j2 ^ j) > 0L ? 1 : ((j2 ^ j) == 0L ? 0 : -1)) >= 0) | ((j ^ j3) >= 0) ? j3 : ((j3 >>> 63) ^ 1) + Long.MAX_VALUE;
    }

    @GwtIncompatible
    public static long sqrt(long j, RoundingMode roundingMode) {
        p63.m6868l(j, "x");
        if (((int) j) == j) {
            return IntMath.sqrt(r0, roundingMode);
        }
        long sqrt = (long) Math.sqrt(j);
        long j2 = sqrt * sqrt;
        boolean z = false;
        int i = 0;
        switch (be1.f7979a[roundingMode.ordinal()]) {
            case 1:
                if (j2 == j) {
                    z = true;
                }
                p63.m6877u(z);
                return sqrt;
            case 2:
            case 3:
                if (j < j2) {
                    return sqrt - 1;
                }
                return sqrt;
            case 4:
            case 5:
                if (j > j2) {
                    return sqrt + 1;
                }
                return sqrt;
            case 6:
            case 7:
            case 8:
                if (j < j2) {
                    i = 1;
                }
                return (sqrt - i) + ((int) ((~(~(((r0 * r0) + r0) - j))) >>> 63));
            default:
                throw new AssertionError();
        }
    }

    @GwtIncompatible
    public static long mod(long j, long j2) {
        if (j2 > 0) {
            long j3 = j % j2;
            return j3 >= 0 ? j3 : j3 + j2;
        }
        throw new ArithmeticException("Modulus must be positive");
    }
}
