package com.google.common.primitives;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Ascii;
import com.google.common.base.Converter;
import com.google.common.base.Preconditions;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import javax.annotation.CheckForNull;
import p000.c51;
import p000.d51;
import p000.e51;

@GwtCompatible(emulated = true)
/* loaded from: classes2.dex */
public final class Ints {
    public static final int BYTES = 4;
    public static final int MAX_POWER_OF_TWO = 1073741824;

    /* renamed from: a */
    public static int m4273a(int[] iArr, int i, int i2, int i3) {
        while (i2 < i3) {
            if (iArr[i2] == i) {
                return i2;
            }
            i2++;
        }
        return -1;
    }

    public static List<Integer> asList(int... iArr) {
        if (iArr.length == 0) {
            return Collections.emptyList();
        }
        return new c51(0, iArr.length, iArr);
    }

    public static int checkedCast(long j) {
        boolean z;
        int i = (int) j;
        if (i == j) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkArgument(z, "Out of range: %s", j);
        return i;
    }

    public static int compare(int i, int i2) {
        if (i < i2) {
            return -1;
        }
        return i > i2 ? 1 : 0;
    }

    public static int[] concat(int[]... iArr) {
        int i = 0;
        for (int[] iArr2 : iArr) {
            i += iArr2.length;
        }
        int[] iArr3 = new int[i];
        int i2 = 0;
        for (int[] iArr4 : iArr) {
            System.arraycopy(iArr4, 0, iArr3, i2, iArr4.length);
            i2 += iArr4.length;
        }
        return iArr3;
    }

    @Beta
    public static int constrainToRange(int i, int i2, int i3) {
        boolean z;
        if (i2 <= i3) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkArgument(z, "min (%s) must be less than or equal to max (%s)", i2, i3);
        return Math.min(Math.max(i, i2), i3);
    }

    public static boolean contains(int[] iArr, int i) {
        for (int i2 : iArr) {
            if (i2 == i) {
                return true;
            }
        }
        return false;
    }

    public static int[] ensureCapacity(int[] iArr, int i, int i2) {
        boolean z;
        boolean z2 = false;
        if (i >= 0) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkArgument(z, "Invalid minLength: %s", i);
        if (i2 >= 0) {
            z2 = true;
        }
        Preconditions.checkArgument(z2, "Invalid padding: %s", i2);
        if (iArr.length < i) {
            return Arrays.copyOf(iArr, i + i2);
        }
        return iArr;
    }

    public static int fromByteArray(byte[] bArr) {
        boolean z;
        if (bArr.length >= 4) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkArgument(z, "array too small: %s < %s", bArr.length, 4);
        return fromBytes(bArr[0], bArr[1], bArr[2], bArr[3]);
    }

    public static int fromBytes(byte b, byte b2, byte b3, byte b4) {
        return (b << Ascii.CAN) | ((b2 & 255) << 16) | ((b3 & 255) << 8) | (b4 & 255);
    }

    public static int hashCode(int i) {
        return i;
    }

    public static int indexOf(int[] iArr, int i) {
        return m4273a(iArr, i, 0, iArr.length);
    }

    public static String join(String str, int... iArr) {
        Preconditions.checkNotNull(str);
        if (iArr.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder(iArr.length * 5);
        sb.append(iArr[0]);
        for (int i = 1; i < iArr.length; i++) {
            sb.append(str);
            sb.append(iArr[i]);
        }
        return sb.toString();
    }

    public static int lastIndexOf(int[] iArr, int i) {
        for (int length = iArr.length - 1; length >= 0; length--) {
            if (iArr[length] == i) {
                return length;
            }
        }
        return -1;
    }

    public static Comparator<int[]> lexicographicalComparator() {
        return e51.f16673a;
    }

    @GwtIncompatible("Available in GWT! Annotation is to avoid conflict with GWT specialization of base class.")
    public static int max(int... iArr) {
        boolean z;
        if (iArr.length > 0) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkArgument(z);
        int i = iArr[0];
        for (int i2 = 1; i2 < iArr.length; i2++) {
            int i3 = iArr[i2];
            if (i3 > i) {
                i = i3;
            }
        }
        return i;
    }

    @GwtIncompatible("Available in GWT! Annotation is to avoid conflict with GWT specialization of base class.")
    public static int min(int... iArr) {
        boolean z;
        if (iArr.length > 0) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkArgument(z);
        int i = iArr[0];
        for (int i2 = 1; i2 < iArr.length; i2++) {
            int i3 = iArr[i2];
            if (i3 < i) {
                i = i3;
            }
        }
        return i;
    }

    public static void reverse(int[] iArr) {
        Preconditions.checkNotNull(iArr);
        reverse(iArr, 0, iArr.length);
    }

    public static int saturatedCast(long j) {
        if (j > 2147483647L) {
            return Integer.MAX_VALUE;
        }
        if (j < -2147483648L) {
            return Integer.MIN_VALUE;
        }
        return (int) j;
    }

    public static void sortDescending(int[] iArr) {
        Preconditions.checkNotNull(iArr);
        sortDescending(iArr, 0, iArr.length);
    }

    @Beta
    public static Converter<String, Integer> stringConverter() {
        return d51.f16250b;
    }

    public static int[] toArray(Collection<? extends Number> collection) {
        if (collection instanceof c51) {
            c51 c51Var = (c51) collection;
            return Arrays.copyOfRange(c51Var.f8251a, c51Var.f8252b, c51Var.f8253c);
        }
        Object[] array = collection.toArray();
        int length = array.length;
        int[] iArr = new int[length];
        for (int i = 0; i < length; i++) {
            iArr[i] = ((Number) Preconditions.checkNotNull(array[i])).intValue();
        }
        return iArr;
    }

    public static byte[] toByteArray(int i) {
        return new byte[]{(byte) (i >> 24), (byte) (i >> 16), (byte) (i >> 8), (byte) i};
    }

    @Beta
    @CheckForNull
    public static Integer tryParse(String str) {
        return tryParse(str, 10);
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0023, code lost:
    
        r0 = r0 + 1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int indexOf(int[] iArr, int[] iArr2) {
        Preconditions.checkNotNull(iArr, "array");
        Preconditions.checkNotNull(iArr2, TypedValues.AttributesType.S_TARGET);
        if (iArr2.length == 0) {
            return 0;
        }
        int i = 0;
        while (i < (iArr.length - iArr2.length) + 1) {
            for (int i2 = 0; i2 < iArr2.length; i2++) {
                if (iArr[i + i2] != iArr2[i2]) {
                    break;
                }
            }
            return i;
        }
        return -1;
    }

    @Beta
    @CheckForNull
    public static Integer tryParse(String str, int i) {
        Long tryParse = Longs.tryParse(str, i);
        if (tryParse == null || tryParse.longValue() != tryParse.intValue()) {
            return null;
        }
        return Integer.valueOf(tryParse.intValue());
    }

    public static void reverse(int[] iArr, int i, int i2) {
        Preconditions.checkNotNull(iArr);
        Preconditions.checkPositionIndexes(i, i2, iArr.length);
        for (int i3 = i2 - 1; i < i3; i3--) {
            int i4 = iArr[i];
            iArr[i] = iArr[i3];
            iArr[i3] = i4;
            i++;
        }
    }

    public static void sortDescending(int[] iArr, int i, int i2) {
        Preconditions.checkNotNull(iArr);
        Preconditions.checkPositionIndexes(i, i2, iArr.length);
        Arrays.sort(iArr, i, i2);
        reverse(iArr, i, i2);
    }
}
