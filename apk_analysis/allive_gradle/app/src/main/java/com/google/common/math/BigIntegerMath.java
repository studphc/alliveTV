package com.google.common.math;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.ArrayList;
import p000.AbstractC1353jg;
import p000.AbstractC1726qj;
import p000.C1305ig;
import p000.o63;
import p000.p63;

@GwtCompatible(emulated = true)
/* loaded from: classes2.dex */
public final class BigIntegerMath {

    /* renamed from: a */
    public static final BigInteger f15114a = new BigInteger("16a09e667f3bcc908b2fb1366ea957d3e3adec17512775099da2f590b0667322a", 16);

    /* renamed from: b */
    public static final double f15115b = Math.log(10.0d);

    /* renamed from: c */
    public static final double f15116c = Math.log(2.0d);

    /* renamed from: a */
    public static BigInteger m4209a(ArrayList arrayList, int i, int i2) {
        int i3 = i2 - i;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        int i4 = (i2 + i) >>> 1;
                        return m4209a(arrayList, i, i4).multiply(m4209a(arrayList, i4, i2));
                    }
                    return ((BigInteger) arrayList.get(i)).multiply((BigInteger) arrayList.get(i + 1)).multiply((BigInteger) arrayList.get(i + 2));
                }
                return ((BigInteger) arrayList.get(i)).multiply((BigInteger) arrayList.get(i + 1));
            }
            return (BigInteger) arrayList.get(i);
        }
        return BigInteger.ONE;
    }

    public static BigInteger binomial(int i, int i2) {
        boolean z;
        int i3;
        p63.m6867k(i, "n");
        p63.m6867k(i2, "k");
        int i4 = 1;
        if (i2 <= i) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkArgument(z, "k (%s) > n (%s)", i2, i);
        if (i2 > (i >> 1)) {
            i2 = i - i2;
        }
        if (i2 < 34 && i <= LongMath.f15130e[i2]) {
            return BigInteger.valueOf(LongMath.binomial(i, i2));
        }
        BigInteger bigInteger = BigInteger.ONE;
        long j = i;
        int log2 = LongMath.log2(j, RoundingMode.CEILING);
        long j2 = 1;
        while (true) {
            int i5 = log2;
            while (i4 < i2) {
                i3 = i - i4;
                i4++;
                i5 += log2;
                if (i5 >= 63) {
                    break;
                }
                j *= i3;
                j2 *= i4;
            }
            return bigInteger.multiply(BigInteger.valueOf(j)).divide(BigInteger.valueOf(j2));
            bigInteger = bigInteger.multiply(BigInteger.valueOf(j)).divide(BigInteger.valueOf(j2));
            j = i3;
            j2 = i4;
        }
    }

    @Beta
    public static BigInteger ceilingPowerOfTwo(BigInteger bigInteger) {
        return BigInteger.ZERO.setBit(log2(bigInteger, RoundingMode.CEILING));
    }

    @GwtIncompatible
    public static BigInteger divide(BigInteger bigInteger, BigInteger bigInteger2, RoundingMode roundingMode) {
        return new BigDecimal(bigInteger).divide(new BigDecimal(bigInteger2), 0, roundingMode).toBigIntegerExact();
    }

    public static BigInteger factorial(int i) {
        p63.m6867k(i, "n");
        long[] jArr = LongMath.f15129d;
        if (i < 21) {
            return BigInteger.valueOf(jArr[i]);
        }
        RoundingMode roundingMode = RoundingMode.CEILING;
        ArrayList arrayList = new ArrayList(IntMath.divide(IntMath.log2(i, roundingMode) * i, 64, roundingMode));
        long j = jArr[20];
        int numberOfTrailingZeros = Long.numberOfTrailingZeros(j);
        long j2 = j >> numberOfTrailingZeros;
        RoundingMode roundingMode2 = RoundingMode.FLOOR;
        int log2 = LongMath.log2(j2, roundingMode2) + 1;
        long j3 = 21;
        int log22 = LongMath.log2(j3, roundingMode2);
        int i2 = log22 + 1;
        int i3 = 1 << log22;
        while (j3 <= i) {
            if ((j3 & i3) != 0) {
                i3 <<= 1;
                i2++;
            }
            int numberOfTrailingZeros2 = Long.numberOfTrailingZeros(j3);
            long j4 = j3 >> numberOfTrailingZeros2;
            numberOfTrailingZeros += numberOfTrailingZeros2;
            if ((i2 - numberOfTrailingZeros2) + log2 >= 64) {
                arrayList.add(BigInteger.valueOf(j2));
                j2 = 1;
            }
            j2 *= j4;
            log2 = LongMath.log2(j2, RoundingMode.FLOOR) + 1;
            j3++;
        }
        if (j2 > 1) {
            arrayList.add(BigInteger.valueOf(j2));
        }
        return m4209a(arrayList, 0, arrayList.size()).shiftLeft(numberOfTrailingZeros);
    }

    @Beta
    public static BigInteger floorPowerOfTwo(BigInteger bigInteger) {
        return BigInteger.ZERO.setBit(log2(bigInteger, RoundingMode.FLOOR));
    }

    public static boolean isPowerOfTwo(BigInteger bigInteger) {
        Preconditions.checkNotNull(bigInteger);
        if (bigInteger.signum() > 0 && bigInteger.getLowestSetBit() == bigInteger.bitLength() - 1) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x009a A[FALL_THROUGH, RETURN] */
    @GwtIncompatible
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int log10(BigInteger bigInteger, RoundingMode roundingMode) {
        int i;
        boolean z;
        p63.m6875s(bigInteger);
        if (bigInteger.bitLength() <= 63) {
            return LongMath.log10(bigInteger.longValue(), roundingMode);
        }
        int log2 = (int) ((log2(bigInteger, RoundingMode.FLOOR) * f15116c) / f15115b);
        BigInteger bigInteger2 = BigInteger.TEN;
        BigInteger pow = bigInteger2.pow(log2);
        int compareTo = pow.compareTo(bigInteger);
        if (compareTo <= 0) {
            BigInteger multiply = bigInteger2.multiply(pow);
            int i2 = compareTo;
            int compareTo2 = multiply.compareTo(bigInteger);
            while (compareTo2 <= 0) {
                log2++;
                BigInteger multiply2 = BigInteger.TEN.multiply(multiply);
                int compareTo3 = multiply2.compareTo(bigInteger);
                pow = multiply;
                multiply = multiply2;
                i2 = compareTo2;
                compareTo2 = compareTo3;
            }
            i = i2;
            switch (AbstractC1353jg.f20490a[roundingMode.ordinal()]) {
                case 1:
                    if (i == 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    p63.m6877u(z);
                case 2:
                case 3:
                    return log2;
                case 4:
                case 5:
                    if (!pow.equals(bigInteger)) {
                        return log2 + 1;
                    }
                    return log2;
                case 6:
                case 7:
                case 8:
                    if (bigInteger.pow(2).compareTo(pow.pow(2).multiply(BigInteger.TEN)) > 0) {
                        return log2 + 1;
                    }
                    return log2;
                default:
                    throw new AssertionError();
            }
        }
        do {
            log2--;
            pow = pow.divide(BigInteger.TEN);
            i = pow.compareTo(bigInteger);
        } while (i > 0);
        switch (AbstractC1353jg.f20490a[roundingMode.ordinal()]) {
        }
    }

    public static int log2(BigInteger bigInteger, RoundingMode roundingMode) {
        p63.m6875s((BigInteger) Preconditions.checkNotNull(bigInteger));
        int bitLength = bigInteger.bitLength();
        int i = bitLength - 1;
        switch (AbstractC1353jg.f20490a[roundingMode.ordinal()]) {
            case 1:
                p63.m6877u(isPowerOfTwo(bigInteger));
            case 2:
            case 3:
                return i;
            case 4:
            case 5:
                if (isPowerOfTwo(bigInteger)) {
                    return i;
                }
                return bitLength;
            case 6:
            case 7:
            case 8:
                if (i < 256) {
                    if (bigInteger.compareTo(f15114a.shiftRight(256 - i)) <= 0) {
                        return i;
                    }
                    return bitLength;
                }
                if (bigInteger.pow(2).bitLength() - 1 < (i * 2) + 1) {
                    return i;
                }
                return bitLength;
            default:
                throw new AssertionError();
        }
    }

    @GwtIncompatible
    public static double roundToDouble(BigInteger bigInteger, RoundingMode roundingMode) {
        return C1305ig.f18400w.m6479G(bigInteger, roundingMode);
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0060, code lost:
    
        if (r0.equals(r1) != false) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0063, code lost:
    
        r0 = r1;
        r1 = r0.add(r5.divide(r0)).shiftRight(1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0074, code lost:
    
        if (r1.compareTo(r0) < 0) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x007f, code lost:
    
        switch(p000.AbstractC1353jg.f20490a[r6.ordinal()]) {
            case 1: goto L33;
            case 2: goto L34;
            case 3: goto L34;
            case 4: goto L26;
            case 5: goto L26;
            case 6: goto L21;
            case 7: goto L21;
            case 8: goto L21;
            default: goto L19;
        };
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0087, code lost:
    
        throw new java.lang.AssertionError();
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0094, code lost:
    
        if (r0.pow(2).add(r0).compareTo(r5) < 0) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x009d, code lost:
    
        return r0.add(java.math.BigInteger.ONE);
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:?, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x009e, code lost:
    
        r6 = r0.intValue();
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x00a7, code lost:
    
        if ((r6 * r6) != r5.intValue()) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x00b1, code lost:
    
        if (r0.pow(2).equals(r5) == false) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:?, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00ba, code lost:
    
        return r0.add(java.math.BigInteger.ONE);
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00bb, code lost:
    
        p000.p63.m6877u(r0.pow(2).equals(r5));
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00c6, code lost:
    
        return r0;
     */
    @GwtIncompatible
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static BigInteger sqrt(BigInteger bigInteger, RoundingMode roundingMode) {
        BigInteger shiftLeft;
        if (bigInteger.signum() >= 0) {
            if (bigInteger.bitLength() <= 63) {
                return BigInteger.valueOf(LongMath.sqrt(bigInteger.longValue(), roundingMode));
            }
            int log2 = log2(bigInteger, RoundingMode.FLOOR);
            if (log2 < 1023) {
                shiftLeft = DoubleMath.roundToBigInteger(Math.sqrt(o63.m6463c(bigInteger)), RoundingMode.HALF_EVEN);
            } else {
                int i = (log2 - 52) & (-2);
                shiftLeft = DoubleMath.roundToBigInteger(Math.sqrt(o63.m6463c(bigInteger.shiftRight(i))), RoundingMode.HALF_EVEN).shiftLeft(i >> 1);
            }
            BigInteger shiftRight = shiftLeft.add(bigInteger.divide(shiftLeft)).shiftRight(1);
        } else {
            String valueOf = String.valueOf(bigInteger);
            throw new IllegalArgumentException(AbstractC1726qj.m7059o("x (", valueOf, ") must be >= 0", valueOf.length() + 17));
        }
    }
}
