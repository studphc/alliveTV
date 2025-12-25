package com.google.common.primitives;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Arrays;
import java.util.Comparator;
import p000.q03;
import p000.r03;
import p000.wm1;
import p000.ye0;

@Beta
@GwtCompatible
/* loaded from: classes2.dex */
public final class UnsignedLongs {
    public static final long MAX_VALUE = -1;

    public static int compare(long j, long j2) {
        return Longs.compare(j ^ Long.MIN_VALUE, j2 ^ Long.MIN_VALUE);
    }

    @CanIgnoreReturnValue
    public static long decode(String str) {
        String str2;
        wm1 m8062d = wm1.m8062d(str);
        try {
            return parseUnsignedLong(m8062d.f28242a, m8062d.f28243b);
        } catch (NumberFormatException e) {
            if (str.length() != 0) {
                str2 = "Error parsing value: ".concat(str);
            } else {
                str2 = new String("Error parsing value: ");
            }
            NumberFormatException numberFormatException = new NumberFormatException(str2);
            numberFormatException.initCause(e);
            throw numberFormatException;
        }
    }

    public static long divide(long j, long j2) {
        if (j2 < 0) {
            if (compare(j, j2) < 0) {
                return 0L;
            }
            return 1L;
        }
        if (j >= 0) {
            return j / j2;
        }
        int i = 1;
        long j3 = ((j >>> 1) / j2) << 1;
        if (compare(j - (j3 * j2), j2) < 0) {
            i = 0;
        }
        return j3 + i;
    }

    public static String join(String str, long... jArr) {
        Preconditions.checkNotNull(str);
        if (jArr.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder(jArr.length * 5);
        sb.append(toString(jArr[0]));
        for (int i = 1; i < jArr.length; i++) {
            sb.append(str);
            sb.append(toString(jArr[i]));
        }
        return sb.toString();
    }

    public static Comparator<long[]> lexicographicalComparator() {
        return q03.f25398a;
    }

    public static long max(long... jArr) {
        boolean z;
        if (jArr.length > 0) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkArgument(z);
        long j = jArr[0] ^ Long.MIN_VALUE;
        for (int i = 1; i < jArr.length; i++) {
            long j2 = jArr[i] ^ Long.MIN_VALUE;
            if (j2 > j) {
                j = j2;
            }
        }
        return j ^ Long.MIN_VALUE;
    }

    public static long min(long... jArr) {
        boolean z;
        if (jArr.length > 0) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkArgument(z);
        long j = jArr[0] ^ Long.MIN_VALUE;
        for (int i = 1; i < jArr.length; i++) {
            long j2 = jArr[i] ^ Long.MIN_VALUE;
            if (j2 < j) {
                j = j2;
            }
        }
        return j ^ Long.MIN_VALUE;
    }

    @CanIgnoreReturnValue
    public static long parseUnsignedLong(String str) {
        return parseUnsignedLong(str, 10);
    }

    public static long remainder(long j, long j2) {
        if (j2 < 0) {
            if (compare(j, j2) < 0) {
                return j;
            }
            return j - j2;
        }
        if (j >= 0) {
            return j % j2;
        }
        long j3 = j - ((((j >>> 1) / j2) << 1) * j2);
        if (compare(j3, j2) < 0) {
            j2 = 0;
        }
        return j3 - j2;
    }

    public static void sort(long[] jArr) {
        Preconditions.checkNotNull(jArr);
        sort(jArr, 0, jArr.length);
    }

    public static void sortDescending(long[] jArr) {
        Preconditions.checkNotNull(jArr);
        sortDescending(jArr, 0, jArr.length);
    }

    public static String toString(long j) {
        return toString(j, 10);
    }

    @CanIgnoreReturnValue
    public static long parseUnsignedLong(String str, int i) {
        Preconditions.checkNotNull(str);
        if (str.length() == 0) {
            throw new NumberFormatException("empty string");
        }
        if (i >= 2 && i <= 36) {
            int i2 = r03.f25831c[i] - 1;
            long j = 0;
            for (int i3 = 0; i3 < str.length(); i3++) {
                int digit = Character.digit(str.charAt(i3), i);
                if (digit == -1) {
                    throw new NumberFormatException(str);
                }
                if (i3 > i2) {
                    if (j >= 0) {
                        long j2 = r03.f25829a[i];
                        if (j < j2) {
                            continue;
                        } else if (j <= j2 && digit <= r03.f25830b[i]) {
                        }
                    }
                    throw new NumberFormatException(str.length() != 0 ? "Too large for unsigned long: ".concat(str) : new String("Too large for unsigned long: "));
                }
                j = (j * i) + digit;
            }
            return j;
        }
        throw new NumberFormatException(ye0.m8290j(26, i, "illegal radix: "));
    }

    public static String toString(long j, int i) {
        long divide;
        Preconditions.checkArgument(i >= 2 && i <= 36, "radix (%s) must be between Character.MIN_RADIX and Character.MAX_RADIX", i);
        if (j == 0) {
            return "0";
        }
        if (j > 0) {
            return Long.toString(j, i);
        }
        int i2 = 64;
        char[] cArr = new char[64];
        int i3 = i - 1;
        if ((i & i3) == 0) {
            int numberOfTrailingZeros = Integer.numberOfTrailingZeros(i);
            do {
                i2--;
                cArr[i2] = Character.forDigit(((int) j) & i3, i);
                j >>>= numberOfTrailingZeros;
            } while (j != 0);
        } else {
            if ((i & 1) == 0) {
                divide = (j >>> 1) / (i >>> 1);
            } else {
                divide = divide(j, i);
            }
            long j2 = i;
            int i4 = 63;
            cArr[63] = Character.forDigit((int) (j - (divide * j2)), i);
            while (divide > 0) {
                i4--;
                cArr[i4] = Character.forDigit((int) (divide % j2), i);
                divide /= j2;
            }
            i2 = i4;
        }
        return new String(cArr, i2, 64 - i2);
    }

    public static void sort(long[] jArr, int i, int i2) {
        Preconditions.checkNotNull(jArr);
        Preconditions.checkPositionIndexes(i, i2, jArr.length);
        for (int i3 = i; i3 < i2; i3++) {
            jArr[i3] = Long.MIN_VALUE ^ jArr[i3];
        }
        Arrays.sort(jArr, i, i2);
        while (i < i2) {
            jArr[i] = jArr[i] ^ Long.MIN_VALUE;
            i++;
        }
    }

    public static void sortDescending(long[] jArr, int i, int i2) {
        Preconditions.checkNotNull(jArr);
        Preconditions.checkPositionIndexes(i, i2, jArr.length);
        for (int i3 = i; i3 < i2; i3++) {
            jArr[i3] = Long.MAX_VALUE ^ jArr[i3];
        }
        Arrays.sort(jArr, i, i2);
        while (i < i2) {
            jArr[i] = jArr[i] ^ Long.MAX_VALUE;
            i++;
        }
    }
}
