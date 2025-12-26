package com.google.gson.internal;

import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import p000.j03;
import p000.k03;
import p000.l03;

/* loaded from: classes2.dex */
public abstract class UnsafeAllocator {
    public static final UnsafeAllocator INSTANCE;

    static {
        UnsafeAllocator unsafeAllocator;
        try {
            try {
                try {
                    Class<?> cls = Class.forName("sun.misc.Unsafe");
                    Field declaredField = cls.getDeclaredField("theUnsafe");
                    declaredField.setAccessible(true);
                    unsafeAllocator = new j03(cls.getMethod("allocateInstance", Class.class), declaredField.get(null));
                } catch (Exception unused) {
                    Method declaredMethod = ObjectInputStream.class.getDeclaredMethod("newInstance", Class.class, Class.class);
                    declaredMethod.setAccessible(true);
                    unsafeAllocator = new l03(declaredMethod);
                }
            } catch (Exception unused2) {
                Method declaredMethod2 = ObjectStreamClass.class.getDeclaredMethod("getConstructorId", Class.class);
                declaredMethod2.setAccessible(true);
                int intValue = ((Integer) declaredMethod2.invoke(null, Object.class)).intValue();
                Method declaredMethod3 = ObjectStreamClass.class.getDeclaredMethod("newInstance", Class.class, Integer.TYPE);
                declaredMethod3.setAccessible(true);
                unsafeAllocator = new k03(intValue, declaredMethod3);
            }
        } catch (Exception unused3) {
            unsafeAllocator = new UnsafeAllocator();
        }
        INSTANCE = unsafeAllocator;
    }

    public abstract <T> T newInstance(Class<T> cls);
}
