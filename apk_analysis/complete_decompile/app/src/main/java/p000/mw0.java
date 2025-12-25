package p000;

import com.google.common.collect.Ordering;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

/* loaded from: classes2.dex */
public abstract class mw0 {

    /* renamed from: a */
    public static final Ordering f23142a = Ordering.natural().onResultOf(new n82(3)).reverse();

    /* renamed from: a */
    public static Exception m6260a(Throwable th, Class cls) {
        Object obj;
        for (Constructor constructor : f23142a.sortedCopy(Arrays.asList(cls.getConstructors()))) {
            Class<?>[] parameterTypes = constructor.getParameterTypes();
            Object[] objArr = new Object[parameterTypes.length];
            int i = 0;
            while (true) {
                obj = null;
                if (i < parameterTypes.length) {
                    Class<?> cls2 = parameterTypes[i];
                    if (cls2.equals(String.class)) {
                        objArr[i] = th.toString();
                    } else {
                        if (!cls2.equals(Throwable.class)) {
                            break;
                        }
                        objArr[i] = th;
                    }
                    i++;
                } else {
                    try {
                        obj = constructor.newInstance(objArr);
                        break;
                    } catch (IllegalAccessException | IllegalArgumentException | InstantiationException | InvocationTargetException unused) {
                    }
                }
            }
            Exception exc = (Exception) obj;
            if (exc != null) {
                if (exc.getCause() == null) {
                    exc.initCause(th);
                }
                return exc;
            }
        }
        String valueOf = String.valueOf(cls);
        throw new IllegalArgumentException(AbstractC1726qj.m7059o("No appropriate constructor for exception of type ", valueOf, " in response to chained exception", valueOf.length() + 82), th);
    }
}
