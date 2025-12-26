package com.google.android.gms.internal.common;

import javax.annotation.CheckForNull;
import org.jspecify.annotations.NullMarked;

@NullMarked
/* loaded from: classes.dex */
public final class zzu {
    public static boolean zza(@CheckForNull Object obj, @CheckForNull Object obj2) {
        if (obj == obj2) {
            return true;
        }
        if (obj != null && obj.equals(obj2)) {
            return true;
        }
        return false;
    }
}
