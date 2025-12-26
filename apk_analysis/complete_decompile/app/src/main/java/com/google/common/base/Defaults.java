package com.google.common.base;

import androidx.recyclerview.widget.RecyclerView;
import com.google.common.annotations.GwtIncompatible;
import javax.annotation.CheckForNull;

@GwtIncompatible
/* loaded from: classes.dex */
public final class Defaults {
    @CheckForNull
    public static <T> T defaultValue(Class<T> cls) {
        Preconditions.checkNotNull(cls);
        if (cls.isPrimitive()) {
            if (cls == Boolean.TYPE) {
                return (T) Boolean.FALSE;
            }
            if (cls == Character.TYPE) {
                return (T) (char) 0;
            }
            if (cls == Byte.TYPE) {
                return (T) (byte) 0;
            }
            if (cls == Short.TYPE) {
                return (T) (short) 0;
            }
            if (cls == Integer.TYPE) {
                return (T) 0;
            }
            if (cls == Long.TYPE) {
                return (T) 0L;
            }
            if (cls == Float.TYPE) {
                return (T) Float.valueOf(RecyclerView.f7068F0);
            }
            if (cls == Double.TYPE) {
                return (T) Double.valueOf(0.0d);
            }
            return null;
        }
        return null;
    }
}
