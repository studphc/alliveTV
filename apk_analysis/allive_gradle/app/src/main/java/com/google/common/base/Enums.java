package com.google.common.base;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;
import p000.dx0;
import p000.t42;
import p000.t90;

@GwtCompatible(emulated = true)
/* loaded from: classes.dex */
public final class Enums {

    /* renamed from: a */
    public static final WeakHashMap f14473a = new WeakHashMap();

    @GwtIncompatible
    public static Field getField(Enum<?> r1) {
        try {
            return r1.getDeclaringClass().getDeclaredField(r1.name());
        } catch (NoSuchFieldException e) {
            throw new AssertionError(e);
        }
    }

    public static <T extends Enum<T>> Optional<T> getIfPresent(Class<T> cls, String str) {
        Map map;
        Preconditions.checkNotNull(cls);
        Preconditions.checkNotNull(str);
        dx0 dx0Var = t42.f26692a;
        WeakHashMap weakHashMap = f14473a;
        synchronized (weakHashMap) {
            Map map2 = (Map) weakHashMap.get(cls);
            map = map2;
            if (map2 == null) {
                HashMap hashMap = new HashMap();
                Iterator it = EnumSet.allOf(cls).iterator();
                while (it.hasNext()) {
                    Enum r3 = (Enum) it.next();
                    hashMap.put(r3.name(), new WeakReference(r3));
                }
                f14473a.put(cls, hashMap);
                map = hashMap;
            }
        }
        WeakReference weakReference = (WeakReference) map.get(str);
        if (weakReference == null) {
            return Optional.absent();
        }
        return Optional.m3770of(cls.cast(weakReference.get()));
    }

    public static <T extends Enum<T>> Converter<String, T> stringConverter(Class<T> cls) {
        return new t90(cls);
    }
}
