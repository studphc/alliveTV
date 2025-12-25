package com.google.common.math;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.primitives.Booleans;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.Iterator;
import p000.o63;
import p000.p50;
import p000.p63;

@GwtCompatible(emulated = true)
/* loaded from: classes2.dex */
public final class DoubleMath {

    /* renamed from: a */
    public static final double f15117a = Math.log(2.0d);

    /* renamed from: b */
    public static final double[] f15118b = {1.0d, 2.0922789888E13d, 2.631308369336935E35d, 1.2413915592536073E61d, 1.2688693218588417E89d, 7.156945704626381E118d, 9.916779348709496E149d, 1.974506857221074E182d, 3.856204823625804E215d, 5.5502938327393044E249d, 4.7147236359920616E284d};

    /* renamed from: a */
    public static double m4210a(double d, RoundingMode roundingMode) {
        int i;
        if (o63.m6475t(d)) {
            switch (p50.f25041a[roundingMode.ordinal()]) {
                case 1:
                    p63.m6877u(isMathematicalInteger(d));
                    return d;
                case 2:
                    if (d < 0.0d && !isMathematicalInteger(d)) {
                        return ((long) d) - 1;
                    }
                    return d;
                case 3:
                    if (d > 0.0d && !isMathematicalInteger(d)) {
                        return ((long) d) + 1;
                    }
                    return d;
                case 4:
                    return d;
                case 5:
                    if (isMathematicalInteger(d)) {
                        return d;
                    }
                    long j = (long) d;
                    if (d > 0.0d) {
                        i = 1;
                    } else {
                        i = -1;
                    }
                    return j + i;
                case 6:
                    return Math.rint(d);
                case 7:
                    double rint = Math.rint(d);
                    if (Math.abs(d - rint) == 0.5d) {
                        return Math.copySign(0.5d, d) + d;
                    }
                    return rint;
                case 8:
                    double rint2 = Math.rint(d);
                    if (Math.abs(d - rint2) == 0.5d) {
                        return d;
                    }
                    return rint2;
                default:
                    throw new AssertionError();
            }
        }
        throw new ArithmeticException("input is infinite or NaN");
    }

    public static double factorial(int i) {
        p63.m6867k(i, "n");
        if (i > 170) {
            return Double.POSITIVE_INFINITY;
        }
        double d = 1.0d;
        for (int i2 = (i & (-16)) + 1; i2 <= i; i2++) {
            d *= i2;
        }
        return d * f15118b[i >> 4];
    }

    public static int fuzzyCompare(double d, double d2, double d3) {
        if (fuzzyEquals(d, d2, d3)) {
            return 0;
        }
        if (d < d2) {
            return -1;
        }
        if (d > d2) {
            return 1;
        }
        return Booleans.compare(Double.isNaN(d), Double.isNaN(d2));
    }

    public static boolean fuzzyEquals(double d, double d2, double d3) {
        if (d3 >= 0.0d) {
            if (Math.copySign(d - d2, 1.0d) > d3 && d != d2 && (!Double.isNaN(d) || !Double.isNaN(d2))) {
                return false;
            }
            return true;
        }
        StringBuilder sb = new StringBuilder("tolerance".length() + 40);
        sb.append("tolerance (");
        sb.append(d3);
        sb.append(") must be >= 0");
        throw new IllegalArgumentException(sb.toString());
    }

    @GwtIncompatible
    public static boolean isMathematicalInteger(double d) {
        if (o63.m6475t(d) && (d == 0.0d || 52 - Long.numberOfTrailingZeros(o63.m6472p(d)) <= Math.getExponent(d))) {
            return true;
        }
        return false;
    }

    @GwtIncompatible
    public static boolean isPowerOfTwo(double d) {
        if (d <= 0.0d || !o63.m6475t(d)) {
            return false;
        }
        long m6472p = o63.m6472p(d);
        if ((m6472p & (m6472p - 1)) != 0) {
            return false;
        }
        return true;
    }

    public static double log2(double d) {
        return Math.log(d) / f15117a;
    }

    @GwtIncompatible
    @Deprecated
    public static double mean(double... dArr) {
        Preconditions.checkArgument(dArr.length > 0, "Cannot take mean of 0 values");
        double d = dArr[0];
        Preconditions.checkArgument(o63.m6475t(d));
        long j = 1;
        for (int i = 1; i < dArr.length; i++) {
            Preconditions.checkArgument(o63.m6475t(dArr[i]));
            j++;
            d += (dArr[i] - d) / j;
        }
        return d;
    }

    @GwtIncompatible
    public static BigInteger roundToBigInteger(double d, RoundingMode roundingMode) {
        boolean z;
        double m4210a = m4210a(d, roundingMode);
        boolean z2 = false;
        if ((-9.223372036854776E18d) - m4210a < 1.0d) {
            z = true;
        } else {
            z = false;
        }
        if (m4210a < 9.223372036854776E18d) {
            z2 = true;
        }
        if (z & z2) {
            return BigInteger.valueOf((long) m4210a);
        }
        BigInteger shiftLeft = BigInteger.valueOf(o63.m6472p(m4210a)).shiftLeft(Math.getExponent(m4210a) - 52);
        if (m4210a < 0.0d) {
            return shiftLeft.negate();
        }
        return shiftLeft;
    }

    @GwtIncompatible
    public static int roundToInt(double d, RoundingMode roundingMode) {
        boolean z;
        double m4210a = m4210a(d, roundingMode);
        boolean z2 = false;
        if (m4210a > -2.147483649E9d) {
            z = true;
        } else {
            z = false;
        }
        if (m4210a < 2.147483648E9d) {
            z2 = true;
        }
        p63.m6864h(z & z2, d, roundingMode);
        return (int) m4210a;
    }

    @GwtIncompatible
    public static long roundToLong(double d, RoundingMode roundingMode) {
        boolean z;
        double m4210a = m4210a(d, roundingMode);
        boolean z2 = false;
        if ((-9.223372036854776E18d) - m4210a < 1.0d) {
            z = true;
        } else {
            z = false;
        }
        if (m4210a < 9.223372036854776E18d) {
            z2 = true;
        }
        p63.m6864h(z & z2, d, roundingMode);
        return (long) m4210a;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:9:0x002a. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:26:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:28:? A[RETURN, SYNTHETIC] */
    @GwtIncompatible
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int log2(double d, RoundingMode roundingMode) {
        boolean isPowerOfTwo;
        Preconditions.checkArgument(d > 0.0d && o63.m6475t(d), "x must be positive and finite");
        int exponent = Math.getExponent(d);
        if (Math.getExponent(d) >= -1022) {
            switch (p50.f25041a[roundingMode.ordinal()]) {
                case 1:
                    p63.m6877u(isPowerOfTwo(d));
                    return !r1 ? exponent + 1 : exponent;
                case 2:
                    if (!r1) {
                    }
                    break;
                case 3:
                    r1 = !isPowerOfTwo(d);
                    if (!r1) {
                    }
                    break;
                case 4:
                    r1 = exponent < 0;
                    isPowerOfTwo = isPowerOfTwo(d);
                    r1 &= !isPowerOfTwo;
                    if (!r1) {
                    }
                    break;
                case 5:
                    r1 = exponent >= 0;
                    isPowerOfTwo = isPowerOfTwo(d);
                    r1 &= !isPowerOfTwo;
                    if (!r1) {
                    }
                    break;
                case 6:
                case 7:
                case 8:
                    double longBitsToDouble = Double.longBitsToDouble((Double.doubleToRawLongBits(d) & 4503599627370495L) | 4607182418800017408L);
                    if (longBitsToDouble * longBitsToDouble > 2.0d) {
                        r1 = true;
                    }
                    if (!r1) {
                    }
                    break;
                default:
                    throw new AssertionError();
            }
        } else {
            return log2(d * 4.503599627370496E15d, roundingMode) - 52;
        }
    }

    @Deprecated
    public static double mean(int... iArr) {
        Preconditions.checkArgument(iArr.length > 0, "Cannot take mean of 0 values");
        long j = 0;
        for (int i : iArr) {
            j += i;
        }
        return j / iArr.length;
    }

    @Deprecated
    public static double mean(long... jArr) {
        Preconditions.checkArgument(jArr.length > 0, "Cannot take mean of 0 values");
        double d = jArr[0];
        long j = 1;
        for (int i = 1; i < jArr.length; i++) {
            j++;
            d += (jArr[i] - d) / j;
        }
        return d;
    }

    @GwtIncompatible
    @Deprecated
    public static double mean(Iterable<? extends Number> iterable) {
        return mean(iterable.iterator());
    }

    @GwtIncompatible
    @Deprecated
    public static double mean(Iterator<? extends Number> it) {
        Preconditions.checkArgument(it.hasNext(), "Cannot take mean of 0 values");
        double doubleValue = it.next().doubleValue();
        Preconditions.checkArgument(o63.m6475t(doubleValue));
        long j = 1;
        while (it.hasNext()) {
            double doubleValue2 = it.next().doubleValue();
            Preconditions.checkArgument(o63.m6475t(doubleValue2));
            j++;
            doubleValue += (doubleValue2 - doubleValue) / j;
        }
        return doubleValue;
    }
}
