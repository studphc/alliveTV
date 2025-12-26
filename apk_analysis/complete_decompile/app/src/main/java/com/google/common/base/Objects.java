package com.google.common.base;

import com.google.common.annotations.GwtCompatible;
import java.util.Arrays;
import javax.annotation.CheckForNull;

@GwtCompatible
/* loaded from: classes.dex */
public final class Objects {
    public static boolean equal(@CheckForNull Object obj, @CheckForNull Object obj2) {
        if (obj != obj2 && (obj == null || !obj.equals(obj2))) {
            return false;
        }
        return true;
    }

    public static int hashCode(@CheckForNull Object... objArr) {
        return Arrays.hashCode(objArr);
    }
}
