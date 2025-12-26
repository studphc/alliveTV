package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import p000.ye0;

@GwtCompatible(emulated = true)
/* loaded from: classes.dex */
public final class ObjectArrays {
    /* renamed from: a */
    public static void m4065a(int i, Object[] objArr) {
        for (int i2 = 0; i2 < i; i2++) {
            if (objArr[i2] == null) {
                throw new NullPointerException(ye0.m8290j(20, i2, "at index "));
            }
        }
    }

    /* renamed from: b */
    public static void m4066b(Collection collection, Object[] objArr) {
        Iterator it = collection.iterator();
        int i = 0;
        while (it.hasNext()) {
            objArr[i] = it.next();
            i++;
        }
    }

    /* renamed from: c */
    public static Object[] m4067c(Collection collection, Object[] objArr) {
        int size = collection.size();
        if (objArr.length < size) {
            objArr = newArray(objArr, size);
        }
        m4066b(collection, objArr);
        if (objArr.length > size) {
            objArr[size] = null;
        }
        return objArr;
    }

    @GwtIncompatible
    public static <T> T[] concat(T[] tArr, T[] tArr2, Class<T> cls) {
        T[] tArr3 = (T[]) newArray(cls, tArr.length + tArr2.length);
        System.arraycopy(tArr, 0, tArr3, 0, tArr.length);
        System.arraycopy(tArr2, 0, tArr3, tArr.length, tArr2.length);
        return tArr3;
    }

    @GwtIncompatible
    public static <T> T[] newArray(Class<T> cls, int i) {
        return (T[]) ((Object[]) Array.newInstance((Class<?>) cls, i));
    }

    public static <T> T[] newArray(T[] tArr, int i) {
        return (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), i));
    }

    public static <T> T[] concat(T t, T[] tArr) {
        T[] tArr2 = (T[]) newArray(tArr, tArr.length + 1);
        tArr2[0] = t;
        System.arraycopy(tArr, 0, tArr2, 1, tArr.length);
        return tArr2;
    }

    public static <T> T[] concat(T[] tArr, T t) {
        T[] tArr2 = (T[]) Arrays.copyOf(tArr, tArr.length + 1);
        tArr2[tArr.length] = t;
        return tArr2;
    }
}
