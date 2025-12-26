package com.google.common.math;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.google.android.exoplayer2.audio.AacUtil;
import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.primitives.Ints;
import java.math.RoundingMode;
import okhttp3.internal.http2.Http2Connection;
import p000.o41;
import p000.p63;

@GwtCompatible(emulated = true)
/* loaded from: classes2.dex */
public final class IntMath {

    /* renamed from: a */
    public static final byte[] f15119a = {9, 9, 9, 8, 8, 8, 7, 7, 7, 6, 6, 6, 6, 5, 5, 5, 4, 4, 4, 3, 3, 3, 3, 2, 2, 2, 1, 1, 1, 0, 0, 0, 0};

    /* renamed from: b */
    public static final int[] f15120b = {1, 10, 100, 1000, 10000, AacUtil.AAC_LC_MAX_RATE_BYTES_PER_SECOND, 1000000, 10000000, 100000000, Http2Connection.DEGRADED_PONG_TIMEOUT_NS};

    /* renamed from: c */
    public static final int[] f15121c = {3, 31, TypedValues.AttributesType.TYPE_PATH_ROTATE, 3162, 31622, 316227, 3162277, 31622776, 316227766, Integer.MAX_VALUE};

    /* renamed from: d */
    public static final int[] f15122d = {1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880, 3628800, 39916800, 479001600};

    /* renamed from: e */
    public static final int[] f15123e = {Integer.MAX_VALUE, Integer.MAX_VALUE, 65536, 2345, 477, 193, 110, 75, 58, 49, 43, 39, 37, 35, 34, 34, 33};

    /* renamed from: a */
    public static int m4211a(int i, int i2) {
        return (~(~(i - i2))) >>> 31;
    }

    public static int binomial(int i, int i2) {
        boolean z;
        p63.m6867k(i, "n");
        p63.m6867k(i2, "k");
        int i3 = 0;
        if (i2 <= i) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkArgument(z, "k (%s) > n (%s)", i2, i);
        if (i2 > (i >> 1)) {
            i2 = i - i2;
        }
        if (i2 < 17 && i <= f15123e[i2]) {
            if (i2 == 0) {
                return 1;
            }
            if (i2 != 1) {
                long j = 1;
                while (i3 < i2) {
                    long j2 = j * (i - i3);
                    i3++;
                    j = j2 / i3;
                }
                return (int) j;
            }
            return i;
        }
        return Integer.MAX_VALUE;
    }

    @Beta
    public static int ceilingPowerOfTwo(int i) {
        p63.m6872p(i);
        if (i <= 1073741824) {
            return 1 << (-Integer.numberOfLeadingZeros(i - 1));
        }
        StringBuilder sb = new StringBuilder(58);
        sb.append("ceilingPowerOfTwo(");
        sb.append(i);
        sb.append(") not representable as an int");
        throw new ArithmeticException(sb.toString());
    }

    public static int checkedAdd(int i, int i2) {
        boolean z;
        long j = i + i2;
        int i3 = (int) j;
        if (j == i3) {
            z = true;
        } else {
            z = false;
        }
        p63.m6865i("checkedAdd", i, i2, z);
        return i3;
    }

    public static int checkedMultiply(int i, int i2) {
        boolean z;
        long j = i * i2;
        int i3 = (int) j;
        if (j == i3) {
            z = true;
        } else {
            z = false;
        }
        p63.m6865i("checkedMultiply", i, i2, z);
        return i3;
    }

    public static int checkedPow(int i, int i2) {
        boolean z;
        boolean z2;
        p63.m6867k(i2, "exponent");
        boolean z3 = false;
        if (i != -2) {
            if (i != -1) {
                if (i != 0) {
                    if (i == 1) {
                        return 1;
                    }
                    if (i != 2) {
                        int i3 = 1;
                        while (i2 != 0) {
                            if (i2 != 1) {
                                if ((i2 & 1) != 0) {
                                    i3 = checkedMultiply(i3, i);
                                }
                                i2 >>= 1;
                                if (i2 > 0) {
                                    if (-46340 <= i) {
                                        z = true;
                                    } else {
                                        z = false;
                                    }
                                    if (i <= 46340) {
                                        z2 = true;
                                    } else {
                                        z2 = false;
                                    }
                                    p63.m6865i("checkedPow", i, i2, z & z2);
                                    i *= i;
                                }
                            } else {
                                return checkedMultiply(i3, i);
                            }
                        }
                        return i3;
                    }
                    if (i2 < 31) {
                        z3 = true;
                    }
                    p63.m6865i("checkedPow", i, i2, z3);
                    return 1 << i2;
                }
                if (i2 == 0) {
                    return 1;
                }
                return 0;
            }
            if ((i2 & 1) == 0) {
                return 1;
            }
            return -1;
        }
        if (i2 < 32) {
            z3 = true;
        }
        p63.m6865i("checkedPow", i, i2, z3);
        if ((i2 & 1) == 0) {
            return 1 << i2;
        }
        return (-1) << i2;
    }

    public static int checkedSubtract(int i, int i2) {
        boolean z;
        long j = i - i2;
        int i3 = (int) j;
        if (j == i3) {
            z = true;
        } else {
            z = false;
        }
        p63.m6865i("checkedSubtract", i, i2, z);
        return i3;
    }

    public static int divide(int i, int i2, RoundingMode roundingMode) {
        boolean z;
        Preconditions.checkNotNull(roundingMode);
        if (i2 != 0) {
            int i3 = i / i2;
            int i4 = i - (i2 * i3);
            if (i4 == 0) {
                return i3;
            }
            boolean z2 = true;
            int i5 = ((i ^ i2) >> 31) | 1;
            switch (o41.f23600a[roundingMode.ordinal()]) {
                case 1:
                    if (i4 != 0) {
                        z2 = false;
                    }
                    p63.m6877u(z2);
                    return i3;
                case 2:
                    return i3;
                case 3:
                    if (i5 >= 0) {
                        return i3;
                    }
                    break;
                case 4:
                    break;
                case 5:
                    if (i5 <= 0) {
                        return i3;
                    }
                    break;
                case 6:
                case 7:
                case 8:
                    int abs = Math.abs(i4);
                    int abs2 = abs - (Math.abs(i2) - abs);
                    if (abs2 == 0) {
                        if (roundingMode != RoundingMode.HALF_UP) {
                            if (roundingMode == RoundingMode.HALF_EVEN) {
                                z = true;
                            } else {
                                z = false;
                            }
                            if ((i3 & 1) == 0) {
                                z2 = false;
                            }
                            if (!(z & z2)) {
                                return i3;
                            }
                        }
                    } else if (abs2 <= 0) {
                        return i3;
                    }
                    break;
                default:
                    throw new AssertionError();
            }
            return i3 + i5;
        }
        throw new ArithmeticException("/ by zero");
    }

    public static int factorial(int i) {
        p63.m6867k(i, "n");
        if (i < 13) {
            return f15122d[i];
        }
        return Integer.MAX_VALUE;
    }

    @Beta
    public static int floorPowerOfTwo(int i) {
        p63.m6872p(i);
        return Integer.highestOneBit(i);
    }

    public static int gcd(int i, int i2) {
        p63.m6867k(i, "a");
        p63.m6867k(i2, "b");
        if (i == 0) {
            return i2;
        }
        if (i2 == 0) {
            return i;
        }
        int numberOfTrailingZeros = Integer.numberOfTrailingZeros(i);
        int i3 = i >> numberOfTrailingZeros;
        int numberOfTrailingZeros2 = Integer.numberOfTrailingZeros(i2);
        int i4 = i2 >> numberOfTrailingZeros2;
        while (i3 != i4) {
            int i5 = i3 - i4;
            int i6 = (i5 >> 31) & i5;
            int i7 = (i5 - i6) - i6;
            i4 += i6;
            i3 = i7 >> Integer.numberOfTrailingZeros(i7);
        }
        return i3 << Math.min(numberOfTrailingZeros, numberOfTrailingZeros2);
    }

    public static boolean isPowerOfTwo(int i) {
        return (i > 0) & ((i & (i + (-1))) == 0);
    }

    @Beta
    @GwtIncompatible
    public static boolean isPrime(int i) {
        return LongMath.isPrime(i);
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x001e. Please report as an issue. */
    @GwtIncompatible
    public static int log10(int i, RoundingMode roundingMode) {
        boolean z;
        int m4211a;
        p63.m6872p(i);
        byte b = f15119a[Integer.numberOfLeadingZeros(i)];
        int[] iArr = f15120b;
        int m4211a2 = b - m4211a(i, iArr[b]);
        int i2 = iArr[m4211a2];
        switch (o41.f23600a[roundingMode.ordinal()]) {
            case 1:
                if (i == i2) {
                    z = true;
                } else {
                    z = false;
                }
                p63.m6877u(z);
            case 2:
            case 3:
                return m4211a2;
            case 4:
            case 5:
                m4211a = m4211a(i2, i);
                return m4211a + m4211a2;
            case 6:
            case 7:
            case 8:
                m4211a = m4211a(f15121c[m4211a2], i);
                return m4211a + m4211a2;
            default:
                throw new AssertionError();
        }
    }

    public static int log2(int i, RoundingMode roundingMode) {
        p63.m6872p(i);
        switch (o41.f23600a[roundingMode.ordinal()]) {
            case 1:
                p63.m6877u(isPowerOfTwo(i));
                break;
            case 2:
            case 3:
                break;
            case 4:
            case 5:
                return 32 - Integer.numberOfLeadingZeros(i - 1);
            case 6:
            case 7:
            case 8:
                int numberOfLeadingZeros = Integer.numberOfLeadingZeros(i);
                return m4211a((-1257966797) >>> numberOfLeadingZeros, i) + (31 - numberOfLeadingZeros);
            default:
                throw new AssertionError();
        }
        return 31 - Integer.numberOfLeadingZeros(i);
    }

    public static int mean(int i, int i2) {
        return (i & i2) + ((i ^ i2) >> 1);
    }

    public static int mod(int i, int i2) {
        if (i2 > 0) {
            int i3 = i % i2;
            if (i3 < 0) {
                return i3 + i2;
            }
            return i3;
        }
        StringBuilder sb = new StringBuilder(31);
        sb.append("Modulus ");
        sb.append(i2);
        sb.append(" must be > 0");
        throw new ArithmeticException(sb.toString());
    }

    @GwtIncompatible
    public static int pow(int i, int i2) {
        int i3;
        p63.m6867k(i2, "exponent");
        if (i != -2) {
            if (i != -1) {
                if (i != 0) {
                    if (i == 1) {
                        return 1;
                    }
                    if (i != 2) {
                        int i4 = 1;
                        while (i2 != 0) {
                            if (i2 != 1) {
                                if ((i2 & 1) == 0) {
                                    i3 = 1;
                                } else {
                                    i3 = i;
                                }
                                i4 *= i3;
                                i *= i;
                                i2 >>= 1;
                            } else {
                                return i * i4;
                            }
                        }
                        return i4;
                    }
                    if (i2 >= 32) {
                        return 0;
                    }
                    return 1 << i2;
                }
                if (i2 == 0) {
                    return 1;
                }
                return 0;
            }
            if ((i2 & 1) == 0) {
                return 1;
            }
            return -1;
        }
        if (i2 >= 32) {
            return 0;
        }
        if ((i2 & 1) == 0) {
            return 1 << i2;
        }
        return -(1 << i2);
    }

    @Beta
    public static int saturatedAdd(int i, int i2) {
        return Ints.saturatedCast(i + i2);
    }

    @Beta
    public static int saturatedMultiply(int i, int i2) {
        return Ints.saturatedCast(i * i2);
    }

    @Beta
    public static int saturatedPow(int i, int i2) {
        boolean z;
        boolean z2;
        p63.m6867k(i2, "exponent");
        if (i != -2) {
            if (i != -1) {
                if (i != 0) {
                    if (i == 1) {
                        return 1;
                    }
                    if (i != 2) {
                        int i3 = ((i >>> 31) & i2 & 1) + Integer.MAX_VALUE;
                        int i4 = 1;
                        while (i2 != 0) {
                            if (i2 != 1) {
                                if ((i2 & 1) != 0) {
                                    i4 = saturatedMultiply(i4, i);
                                }
                                i2 >>= 1;
                                if (i2 > 0) {
                                    if (-46340 > i) {
                                        z = true;
                                    } else {
                                        z = false;
                                    }
                                    if (i > 46340) {
                                        z2 = true;
                                    } else {
                                        z2 = false;
                                    }
                                    if (z | z2) {
                                        return i3;
                                    }
                                    i *= i;
                                }
                            } else {
                                return saturatedMultiply(i4, i);
                            }
                        }
                        return i4;
                    }
                    if (i2 >= 31) {
                        return Integer.MAX_VALUE;
                    }
                    return 1 << i2;
                }
                if (i2 == 0) {
                    return 1;
                }
                return 0;
            }
            if ((i2 & 1) == 0) {
                return 1;
            }
            return -1;
        }
        if (i2 >= 32) {
            return (i2 & 1) + Integer.MAX_VALUE;
        }
        if ((i2 & 1) == 0) {
            return 1 << i2;
        }
        return (-1) << i2;
    }

    @Beta
    public static int saturatedSubtract(int i, int i2) {
        return Ints.saturatedCast(i - i2);
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x0013. Please report as an issue. */
    @GwtIncompatible
    public static int sqrt(int i, RoundingMode roundingMode) {
        boolean z;
        int m4211a;
        p63.m6867k(i, "x");
        int sqrt = (int) Math.sqrt(i);
        switch (o41.f23600a[roundingMode.ordinal()]) {
            case 1:
                if (sqrt * sqrt == i) {
                    z = true;
                } else {
                    z = false;
                }
                p63.m6877u(z);
            case 2:
            case 3:
                return sqrt;
            case 4:
            case 5:
                m4211a = m4211a(sqrt * sqrt, i);
                return m4211a + sqrt;
            case 6:
            case 7:
            case 8:
                m4211a = m4211a((sqrt * sqrt) + sqrt, i);
                return m4211a + sqrt;
            default:
                throw new AssertionError();
        }
    }
}
