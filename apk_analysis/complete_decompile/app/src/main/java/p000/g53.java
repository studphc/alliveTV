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
public abstract class g53 {

    /* renamed from: a */
    public static final Field f17547a;

    /* renamed from: b */
    public static final Method f17548b;

    /* renamed from: c */
    public static final Constructor f17549c;

    /* renamed from: d */
    public static final LongSparseArray f17550d;

    /* renamed from: e */
    public static final Object f17551e;

    static {
        Field field;
        Constructor constructor;
        Method method;
        try {
            field = Typeface.class.getDeclaredField("native_instance");
            Class cls = Long.TYPE;
            method = Typeface.class.getDeclaredMethod("nativeCreateFromTypefaceWithExactStyle", cls, Integer.TYPE, Boolean.TYPE);
            method.setAccessible(true);
            constructor = Typeface.class.getDeclaredConstructor(cls);
            constructor.setAccessible(true);
        } catch (NoSuchFieldException | NoSuchMethodException e) {
            Log.e("WeightTypeface", e.getClass().getName(), e);
            field = null;
            constructor = null;
            method = null;
        }
        f17547a = field;
        f17548b = method;
        f17549c = constructor;
        f17550d = new LongSparseArray(3);
        f17551e = new Object();
    }

    /* renamed from: a */
    public static Typeface m4928a(Typeface typeface, int i, boolean z) {
        Field field = f17547a;
        Typeface typeface2 = null;
        if (field == null) {
            return null;
        }
        int i2 = (i << 1) | (z ? 1 : 0);
        synchronized (f17551e) {
            try {
                try {
                    long j = field.getLong(typeface);
                    LongSparseArray longSparseArray = f17550d;
                    SparseArray sparseArray = (SparseArray) longSparseArray.get(j);
                    if (sparseArray == null) {
                        sparseArray = new SparseArray(4);
                        longSparseArray.put(j, sparseArray);
                    } else {
                        Typeface typeface3 = (Typeface) sparseArray.get(i2);
                        if (typeface3 != null) {
                            return typeface3;
                        }
                    }
                    try {
                        Long l = (Long) f17548b.invoke(null, Long.valueOf(j), Integer.valueOf(i), Boolean.valueOf(z));
                        l.longValue();
                        try {
                            typeface2 = (Typeface) f17549c.newInstance(l);
                        } catch (IllegalAccessException | InstantiationException | InvocationTargetException unused) {
                        }
                        sparseArray.put(i2, typeface2);
                        return typeface2;
                    } catch (IllegalAccessException e) {
                        throw new RuntimeException(e);
                    } catch (InvocationTargetException e2) {
                        throw new RuntimeException(e2);
                    }
                } catch (IllegalAccessException e3) {
                    throw new RuntimeException(e3);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
