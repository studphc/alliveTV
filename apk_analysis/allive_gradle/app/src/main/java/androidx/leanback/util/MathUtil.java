package androidx.leanback.util;

import androidx.annotation.RestrictTo;

@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes.dex */
public final class MathUtil {
    public static int safeLongToInt(long j) {
        int i = (int) j;
        if (i == j) {
            return i;
        }
        throw new ArithmeticException("Input overflows int.\n");
    }
}
