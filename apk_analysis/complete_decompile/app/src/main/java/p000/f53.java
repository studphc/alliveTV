package p000;

import android.graphics.Typeface;
import android.util.Log;
import android.util.SparseArray;
import androidx.collection.LongSparseArray;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public abstract class f53 {

    /* renamed from: a */
    public static final Field f17130a;

    /* renamed from: b */
    public static final Method f17131b;

    /* renamed from: c */
    public static final Method f17132c;

    /* renamed from: d */
    public static final Constructor f17133d;

    /* renamed from: e */
    public static final LongSparseArray f17134e;

    /* renamed from: f */
    public static final Object f17135f;

    static {
        Field field;
        Method method;
        Constructor constructor;
        Method method2;
        try {
            field = Typeface.class.getDeclaredField("native_instance");
            Class cls = Long.TYPE;
            Class cls2 = Integer.TYPE;
            method2 = Typeface.class.getDeclaredMethod("nativeCreateFromTypeface", cls, cls2);
            method2.setAccessible(true);
            method = Typeface.class.getDeclaredMethod("nativeCreateWeightAlias", cls, cls2);
            method.setAccessible(true);
            constructor = Typeface.class.getDeclaredConstructor(cls);
            constructor.setAccessible(true);
        } catch (NoSuchFieldException | NoSuchMethodException e) {
            Log.e("WeightTypeface", e.getClass().getName(), e);
            field = null;
            method = null;
            constructor = null;
            method2 = null;
        }
        f17130a = field;
        f17131b = method2;
        f17132c = method;
        f17133d = constructor;
        f17134e = new LongSparseArray(3);
        f17135f = new Object();
    }

    /* renamed from: a */
    public static Typeface m4772a(long j) {
        try {
            return (Typeface) f17133d.newInstance(Long.valueOf(j));
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException unused) {
            return null;
        }
    }

    /* renamed from: b */
    public static Typeface m4773b(Typeface typeface, int i, boolean z) {
        Typeface m4772a;
        Field field = f17130a;
        if (field == null) {
            return null;
        }
        int i2 = (i << 1) | (z ? 1 : 0);
        synchronized (f17135f) {
            try {
                try {
                    long j = field.getLong(typeface);
                    LongSparseArray longSparseArray = f17134e;
                    SparseArray sparseArray = (SparseArray) longSparseArray.get(j);
                    if (sparseArray == null) {
                        sparseArray = new SparseArray(4);
                        longSparseArray.put(j, sparseArray);
                    } else {
                        Typeface typeface2 = (Typeface) sparseArray.get(i2);
                        if (typeface2 != null) {
                            return typeface2;
                        }
                    }
                    if (z == typeface.isItalic()) {
                        try {
                            try {
                                m4772a = m4772a(((Long) f17132c.invoke(null, Long.valueOf(j), Integer.valueOf(i))).longValue());
                            } catch (InvocationTargetException e) {
                                throw new RuntimeException(e);
                            }
                        } catch (IllegalAccessException e2) {
                            throw new RuntimeException(e2);
                        }
                    } else {
                        m4772a = m4772a(m4774c(i, j, z));
                    }
                    sparseArray.put(i2, m4772a);
                    return m4772a;
                } catch (IllegalAccessException e3) {
                    throw new RuntimeException(e3);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* renamed from: c */
    public static long m4774c(int i, long j, boolean z) {
        int i2;
        if (z) {
            i2 = 2;
        } else {
            i2 = 0;
        }
        try {
            Long l = (Long) f17131b.invoke(null, Long.valueOf(j), Integer.valueOf(i2));
            l.longValue();
            return ((Long) f17132c.invoke(null, l, Integer.valueOf(i))).longValue();
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e2) {
            throw new RuntimeException(e2);
        }
    }
}
