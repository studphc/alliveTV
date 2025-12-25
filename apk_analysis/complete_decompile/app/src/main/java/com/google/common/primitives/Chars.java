package com.google.common.primitives;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import kotlin.jvm.internal.CharCompanionObject;
import okhttp3.internal.ws.WebSocketProtocol;
import p000.C1240gp;
import p000.EnumC1277hp;

@GwtCompatible(emulated = true)
/* loaded from: classes2.dex */
public final class Chars {
    public static final int BYTES = 2;

    /* renamed from: a */
    public static int m4242a(char[] cArr, char c, int i, int i2) {
        while (i < i2) {
            if (cArr[i] == c) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public static List<Character> asList(char... cArr) {
        if (cArr.length == 0) {
            return Collections.emptyList();
        }
        return new C1240gp(cArr, 0, cArr.length);
    }

    public static char checkedCast(long j) {
        boolean z;
        char c = (char) j;
        if (c == j) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkArgument(z, "Out of range: %s", j);
        return c;
    }

    public static int compare(char c, char c2) {
        return c - c2;
    }

    public static char[] concat(char[]... cArr) {
        int i = 0;
        for (char[] cArr2 : cArr) {
            i += cArr2.length;
        }
        char[] cArr3 = new char[i];
        int i2 = 0;
        for (char[] cArr4 : cArr) {
            System.arraycopy(cArr4, 0, cArr3, i2, cArr4.length);
            i2 += cArr4.length;
        }
        return cArr3;
    }

    @Beta
    public static char constrainToRange(char c, char c2, char c3) {
        boolean z;
        if (c2 <= c3) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkArgument(z, "min (%s) must be less than or equal to max (%s)", c2, c3);
        if (c < c2) {
            return c2;
        }
        if (c >= c3) {
            return c3;
        }
        return c;
    }

    public static boolean contains(char[] cArr, char c) {
        for (char c2 : cArr) {
            if (c2 == c) {
                return true;
            }
        }
        return false;
    }

    public static char[] ensureCapacity(char[] cArr, int i, int i2) {
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
        if (cArr.length < i) {
            return Arrays.copyOf(cArr, i + i2);
        }
        return cArr;
    }

    @GwtIncompatible
    public static char fromByteArray(byte[] bArr) {
        boolean z;
        if (bArr.length >= 2) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkArgument(z, "array too small: %s < %s", bArr.length, 2);
        return fromBytes(bArr[0], bArr[1]);
    }

    @GwtIncompatible
    public static char fromBytes(byte b, byte b2) {
        return (char) ((b << 8) | (b2 & 255));
    }

    public static int hashCode(char c) {
        return c;
    }

    public static int indexOf(char[] cArr, char c) {
        return m4242a(cArr, c, 0, cArr.length);
    }

    public static String join(String str, char... cArr) {
        Preconditions.checkNotNull(str);
        int length = cArr.length;
        if (length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder(((length - 1) * str.length()) + length);
        sb.append(cArr[0]);
        for (int i = 1; i < length; i++) {
            sb.append(str);
            sb.append(cArr[i]);
        }
        return sb.toString();
    }

    public static int lastIndexOf(char[] cArr, char c) {
        for (int length = cArr.length - 1; length >= 0; length--) {
            if (cArr[length] == c) {
                return length;
            }
        }
        return -1;
    }

    public static Comparator<char[]> lexicographicalComparator() {
        return EnumC1277hp.f18120a;
    }

    public static char max(char... cArr) {
        boolean z;
        if (cArr.length > 0) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkArgument(z);
        char c = cArr[0];
        for (int i = 1; i < cArr.length; i++) {
            char c2 = cArr[i];
            if (c2 > c) {
                c = c2;
            }
        }
        return c;
    }

    public static char min(char... cArr) {
        boolean z;
        if (cArr.length > 0) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkArgument(z);
        char c = cArr[0];
        for (int i = 1; i < cArr.length; i++) {
            char c2 = cArr[i];
            if (c2 < c) {
                c = c2;
            }
        }
        return c;
    }

    public static void reverse(char[] cArr) {
        Preconditions.checkNotNull(cArr);
        reverse(cArr, 0, cArr.length);
    }

    public static char saturatedCast(long j) {
        if (j > WebSocketProtocol.PAYLOAD_SHORT_MAX) {
            return CharCompanionObject.MAX_VALUE;
        }
        if (j < 0) {
            return (char) 0;
        }
        return (char) j;
    }

    public static void sortDescending(char[] cArr) {
        Preconditions.checkNotNull(cArr);
        sortDescending(cArr, 0, cArr.length);
    }

    public static char[] toArray(Collection<Character> collection) {
        if (collection instanceof C1240gp) {
            C1240gp c1240gp = (C1240gp) collection;
            return Arrays.copyOfRange(c1240gp.f17781a, c1240gp.f17782b, c1240gp.f17783c);
        }
        Object[] array = collection.toArray();
        int length = array.length;
        char[] cArr = new char[length];
        for (int i = 0; i < length; i++) {
            cArr[i] = ((Character) Preconditions.checkNotNull(array[i])).charValue();
        }
        return cArr;
    }

    @GwtIncompatible
    public static byte[] toByteArray(char c) {
        return new byte[]{(byte) (c >> '\b'), (byte) c};
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0023, code lost:
    
        r0 = r0 + 1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int indexOf(char[] cArr, char[] cArr2) {
        Preconditions.checkNotNull(cArr, "array");
        Preconditions.checkNotNull(cArr2, TypedValues.AttributesType.S_TARGET);
        if (cArr2.length == 0) {
            return 0;
        }
        int i = 0;
        while (i < (cArr.length - cArr2.length) + 1) {
            for (int i2 = 0; i2 < cArr2.length; i2++) {
                if (cArr[i + i2] != cArr2[i2]) {
                    break;
                }
            }
            return i;
        }
        return -1;
    }

    public static void reverse(char[] cArr, int i, int i2) {
        Preconditions.checkNotNull(cArr);
        Preconditions.checkPositionIndexes(i, i2, cArr.length);
        for (int i3 = i2 - 1; i < i3; i3--) {
            char c = cArr[i];
            cArr[i] = cArr[i3];
            cArr[i3] = c;
            i++;
        }
    }

    public static void sortDescending(char[] cArr, int i, int i2) {
        Preconditions.checkNotNull(cArr);
        Preconditions.checkPositionIndexes(i, i2, cArr.length);
        Arrays.sort(cArr, i, i2);
        reverse(cArr, i, i2);
    }
}
