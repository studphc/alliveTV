package com.google.gson.internal;

import com.google.gson.ReflectionAccessFilter;
import java.lang.reflect.AccessibleObject;
import java.util.Iterator;
import java.util.List;
import p000.m92;

/* loaded from: classes2.dex */
public class ReflectionAccessFilterHelper {
    public static boolean canAccess(AccessibleObject accessibleObject, Object obj) {
        return m92.f22856a.mo5514a(accessibleObject, obj);
    }

    public static ReflectionAccessFilter.FilterResult getFilterResult(List<ReflectionAccessFilter> list, Class<?> cls) {
        Iterator<ReflectionAccessFilter> it = list.iterator();
        while (it.hasNext()) {
            ReflectionAccessFilter.FilterResult check = it.next().check(cls);
            if (check != ReflectionAccessFilter.FilterResult.INDECISIVE) {
                return check;
            }
        }
        return ReflectionAccessFilter.FilterResult.ALLOW;
    }

    public static boolean isAndroidType(Class<?> cls) {
        String name = cls.getName();
        if (!name.startsWith("android.") && !name.startsWith("androidx.") && !name.startsWith("java.") && !name.startsWith("javax.")) {
            return false;
        }
        return true;
    }

    public static boolean isAnyPlatformType(Class<?> cls) {
        String name = cls.getName();
        if (!name.startsWith("android.") && !name.startsWith("androidx.") && !name.startsWith("java.") && !name.startsWith("javax.") && !name.startsWith("kotlin.") && !name.startsWith("kotlinx.") && !name.startsWith("scala.")) {
            return false;
        }
        return true;
    }

    public static boolean isJavaType(Class<?> cls) {
        String name = cls.getName();
        if (!name.startsWith("java.") && !name.startsWith("javax.")) {
            return false;
        }
        return true;
    }
}
