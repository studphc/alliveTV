package p000;

import com.google.gson.internal.reflect.ReflectionHelper;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* loaded from: classes2.dex */
public final class o92 extends yy2 {

    /* renamed from: p */
    public final Method f23670p = Class.class.getMethod("isRecord", null);

    /* renamed from: q */
    public final Method f23671q;

    /* renamed from: r */
    public final Method f23672r;

    /* renamed from: s */
    public final Method f23673s;

    public o92() {
        Method method = Class.class.getMethod("getRecordComponents", null);
        this.f23671q = method;
        Class<?> componentType = method.getReturnType().getComponentType();
        this.f23672r = componentType.getMethod("getName", null);
        this.f23673s = componentType.getMethod("getType", null);
    }

    @Override // p000.yy2
    /* renamed from: B */
    public final boolean mo6324B(Class cls) {
        try {
            return ((Boolean) this.f23670p.invoke(cls, null)).booleanValue();
        } catch (ReflectiveOperationException e) {
            yy2 yy2Var = ReflectionHelper.f15787a;
            throw new RuntimeException("Unexpected ReflectiveOperationException occurred (Gson 2.10.1). To support Java records, reflection is utilized to read out information about records. All these invocations happens after it is established that records exist in the JVM. This exception is unexpected behavior.", e);
        }
    }

    @Override // p000.yy2
    /* renamed from: q */
    public final Method mo6325q(Class cls, Field field) {
        try {
            return cls.getMethod(field.getName(), null);
        } catch (ReflectiveOperationException e) {
            yy2 yy2Var = ReflectionHelper.f15787a;
            throw new RuntimeException("Unexpected ReflectiveOperationException occurred (Gson 2.10.1). To support Java records, reflection is utilized to read out information about records. All these invocations happens after it is established that records exist in the JVM. This exception is unexpected behavior.", e);
        }
    }

    @Override // p000.yy2
    /* renamed from: r */
    public final Constructor mo6326r(Class cls) {
        try {
            Object[] objArr = (Object[]) this.f23671q.invoke(cls, null);
            Class<?>[] clsArr = new Class[objArr.length];
            for (int i = 0; i < objArr.length; i++) {
                clsArr[i] = (Class) this.f23673s.invoke(objArr[i], null);
            }
            return cls.getDeclaredConstructor(clsArr);
        } catch (ReflectiveOperationException e) {
            yy2 yy2Var = ReflectionHelper.f15787a;
            throw new RuntimeException("Unexpected ReflectiveOperationException occurred (Gson 2.10.1). To support Java records, reflection is utilized to read out information about records. All these invocations happens after it is established that records exist in the JVM. This exception is unexpected behavior.", e);
        }
    }

    @Override // p000.yy2
    /* renamed from: v */
    public final String[] mo6327v(Class cls) {
        try {
            Object[] objArr = (Object[]) this.f23671q.invoke(cls, null);
            String[] strArr = new String[objArr.length];
            for (int i = 0; i < objArr.length; i++) {
                strArr[i] = (String) this.f23672r.invoke(objArr[i], null);
            }
            return strArr;
        } catch (ReflectiveOperationException e) {
            yy2 yy2Var = ReflectionHelper.f15787a;
            throw new RuntimeException("Unexpected ReflectiveOperationException occurred (Gson 2.10.1). To support Java records, reflection is utilized to read out information about records. All these invocations happens after it is established that records exist in the JVM. This exception is unexpected behavior.", e);
        }
    }
}
