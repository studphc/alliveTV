package com.google.common.primitives;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import p000.C1391kh;
import p000.EnumC1511lh;
import p000.EnumC1548mh;

@GwtCompatible
/* loaded from: classes2.dex */
public final class Booleans {
    /* renamed from: a */
    public static int m4240a(boolean[] zArr, boolean z, int i, int i2) {
        while (i < i2) {
            if (zArr[i] == z) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public static List<Boolean> asList(boolean... zArr) {
        if (zArr.length == 0) {
            return Collections.emptyList();
        }
        return new C1391kh(zArr, 0, zArr.length);
    }

    public static int compare(boolean z, boolean z2) {
        if (z == z2) {
            return 0;
        }
        return z ? 1 : -1;
    }

    public static boolean[] concat(boolean[]... zArr) {
        int i = 0;
        for (boolean[] zArr2 : zArr) {
            i += zArr2.length;
        }
        boolean[] zArr3 = new boolean[i];
        int i2 = 0;
        for (boolean[] zArr4 : zArr) {
            System.arraycopy(zArr4, 0, zArr3, i2, zArr4.length);
            i2 += zArr4.length;
        }
        return zArr3;
    }

    public static boolean contains(boolean[] zArr, boolean z) {
        for (boolean z2 : zArr) {
            if (z2 == z) {
                return true;
            }
        }
        return false;
    }

    @Beta
    public static int countTrue(boolean... zArr) {
        int i = 0;
        for (boolean z : zArr) {
            if (z) {
                i++;
            }
        }
        return i;
    }

    public static boolean[] ensureCapacity(boolean[] zArr, int i, int i2) {
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
        if (zArr.length < i) {
            return Arrays.copyOf(zArr, i + i2);
        }
        return zArr;
    }

    @Beta
    public static Comparator<Boolean> falseFirst() {
        return EnumC1511lh.f22500d;
    }

    public static int hashCode(boolean z) {
        return z ? 1231 : 1237;
    }

    public static int indexOf(boolean[] zArr, boolean z) {
        return m4240a(zArr, z, 0, zArr.length);
    }

    public static String join(String str, boolean... zArr) {
        Preconditions.checkNotNull(str);
        if (zArr.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder(zArr.length * 7);
        sb.append(zArr[0]);
        for (int i = 1; i < zArr.length; i++) {
            sb.append(str);
            sb.append(zArr[i]);
        }
        return sb.toString();
    }

    public static int lastIndexOf(boolean[] zArr, boolean z) {
        for (int length = zArr.length - 1; length >= 0; length--) {
            if (zArr[length] == z) {
                return length;
            }
        }
        return -1;
    }

    public static Comparator<boolean[]> lexicographicalComparator() {
        return EnumC1548mh.f22937a;
    }

    public static void reverse(boolean[] zArr) {
        Preconditions.checkNotNull(zArr);
        reverse(zArr, 0, zArr.length);
    }

    public static boolean[] toArray(Collection<Boolean> collection) {
        if (collection instanceof C1391kh) {
            C1391kh c1391kh = (C1391kh) collection;
            return Arrays.copyOfRange(c1391kh.f20850a, c1391kh.f20851b, c1391kh.f20852c);
        }
        Object[] array = collection.toArray();
        int length = array.length;
        boolean[] zArr = new boolean[length];
        for (int i = 0; i < length; i++) {
            zArr[i] = ((Boolean) Preconditions.checkNotNull(array[i])).booleanValue();
        }
        return zArr;
    }

    @Beta
    public static Comparator<Boolean> trueFirst() {
        return EnumC1511lh.f22499c;
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0023, code lost:
    
        r0 = r0 + 1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int indexOf(boolean[] zArr, boolean[] zArr2) {
        Preconditions.checkNotNull(zArr, "array");
        Preconditions.checkNotNull(zArr2, TypedValues.AttributesType.S_TARGET);
        if (zArr2.length == 0) {
            return 0;
        }
        int i = 0;
        while (i < (zArr.length - zArr2.length) + 1) {
            for (int i2 = 0; i2 < zArr2.length; i2++) {
                if (zArr[i + i2] != zArr2[i2]) {
                    break;
                }
            }
            return i;
        }
        return -1;
    }

    public static void reverse(boolean[] zArr, int i, int i2) {
        Preconditions.checkNotNull(zArr);
        Preconditions.checkPositionIndexes(i, i2, zArr.length);
        for (int i3 = i2 - 1; i < i3; i3--) {
            boolean z = zArr[i];
            zArr[i] = zArr[i3];
            zArr[i3] = z;
            i++;
        }
    }
}
